package Part2.Client;

import Part2.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientGUI {
    private JTextField usernameField;
    private JTextField cardNumberTextField;
    private JButton registerButton;
    private JTextArea responseArea;
    private JButton createGraphButton;
    private JButton minimumSpanningTreeButton;
    private JButton incidenceMatrixButton;
    private JPanel card;
    private JTextField creditField;
    private JButton loadCreditButton;
    private JButton showGraphButton;
    private JButton currentCreditButton;
    private JButton browseGraph;
    private JLabel creditBalance;
    private JButton showAccountsButton;
    private String FileName;
    private String FilePath;

    private static GraphService graphService;
    private static RegistrationService registrationService;
    private Graph graph;

    public ClientGUI() {
        // registerButton yeni hesaplari kaydeder.
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());
                try {
                    if (registrationService.register(a, 100)) {
                        responseArea.setText("Account registered");
                        creditBalance.setText("" + registrationService.getCredit(a));
                        createGraphButton.setEnabled(false);
                        showGraphButton.setEnabled(false);
                        incidenceMatrixButton.setEnabled(false);
                        minimumSpanningTreeButton.setEnabled(false);
                    }
                    else
                        responseArea.setText("Account couldn't registered");
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Hangi hesap bulunuyorsa ona ek kredi yukler
        loadCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());
                try {
                    if (registrationService.loadCredit(a, Integer.parseInt(creditField.getText().trim()))) {
                        responseArea.setText("Credit loaded");
                        currentCredit();
                    }
                    else
                        responseArea.setText("Credit couldn't loaded");
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // Dosyadan okuma islemi yapilir ve okunan degerler ile graph olusturulur.
        createGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());
                List<Edge> edges = new ArrayList<>();
                File file = new File(FilePath.trim());
                try {
                    Scanner sc = new Scanner(file);
                    int V = sc.nextInt();
                    while (sc.hasNext()) {
                        int from = sc.nextInt();
                        int to = sc.nextInt();
                        double w = sc.nextDouble();
                        edges.add(new Edge(from, to, w));
                    }
                    sc.close();
                    graph = graphService.createGraph(a, edges.toArray(new Edge[edges.size()]), V);
                    responseArea.setText("Graph Created.");
                    currentCredit();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (NoCreditException ex) {
                    responseArea.setText("Graph couldn't created. (No credit.)");
                } catch (FileNotFoundException ex) {
                    responseArea.setText("Graph couldn't created.\n (File " + FileName.trim() + " not found.)");
                }
            }
        });

        // Olusturulan graph texteArea uzerinde gosterilmek uzere ekrana cikti olarak yansitilir.
        showGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());

                try {
                    responseArea.setText(graphService.graphToString(a, graph));
                    currentCredit();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (NoCreditException ex) {
                    responseArea.setText("Graph couldn't showed. (No credit.)");
                }
            }
        });

        // Graph ile Incidence Matrix olusturulur ve textArea da gosterilmek uzere ekrana cikti olarak yansitilir.
        incidenceMatrixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());

                try {
                    double[][] retval = graphService.getIncidenceMatrix(a, graph);
                    StringBuilder builder = new StringBuilder();
                    for (double[] row : retval) {
                        for (double item : row)
                            builder.append(String.format("%4.3f ", item));
                        builder.append("\n");
                    }
                    responseArea.setText(builder.toString());
                    currentCredit();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (NoCreditException ex) {
                    responseArea.setText("Incidence matrix couldn't retrieved. (No credit.)");
                }
            }
        });

        // Graph ile Minimum Spanning Tree olusturulup
        minimumSpanningTreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());

                try {
                    Graph graph = graphService.getMinimumSpanningTree(a, ClientGUI.this.graph);
                    responseArea.setText(graph.toString());
                    currentCredit();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (NoCreditException ex) {
                    responseArea.setText("Incidence matrix couldn't retrieved. (No credit.)");
                }
            }
        });
        browseGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fs = new JFileChooser("./GraphTEXT/");
                fs.setDialogTitle("Open A GRAPH FILE");
                int result = fs.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                    File file = fs.getSelectedFile();
                    FileName = file.getName();
                    FilePath = file.getParent() + "\\" + FileName;

                    createGraphButton.setEnabled(true);
                    showGraphButton.setEnabled(true);
                    incidenceMatrixButton.setEnabled(true);
                    minimumSpanningTreeButton.setEnabled(true);
                }
                currentCredit();
            }
        });
        showAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    responseArea.setText(registrationService.printAccounts());
                    currentCredit();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }

            }
        });

        currentCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCredit();
            }
        });
    }

    public void currentCredit(){
        Account a = new Account(usernameField.getText().trim(), cardNumberTextField.getText().trim());
        if(usernameField.getText().trim() != "" && cardNumberTextField.getText().trim() != "") {
            try {
                creditBalance.setText("" + registrationService.getCredit(a));
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        else
            creditBalance.setText("0");
    }
    public static void main(String[] args) {
        String host = "localhost";

        if (args.length == 1)
            host = args[0];

        try {
            graphService = (GraphService) Naming.lookup("rmi://" + host + "/BulutCizge");
            registrationService =
                    (RegistrationService)  Naming.lookup("rmi://" + host + "/BulutCizgeKayit");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("CLIENT");
        frame.setContentPane(new ClientGUI().card);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
