package linearsolverdeluxe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

/**
 * Linear Solver Deluxe programinin grafik arayuz tasariminin yapildigi kisimdir.
 * @author Yunus CEVIK
 */
public class GUI extends JFrame{
    private TextField[][] aTextFields;
    private TextField[] bTextFields;
    private int row;
    private int col;
    private LinearSolverDeluxe linearSolverDeluxe;
    private JPanel panel;
    private JComboBox<Integer> rowSizeCombo;
    private JComboBox<Integer> colSizeCombo;
    private JPanel downP;
    private Double[][] Amatrix;
    /**
     * Grafik arayuzunun kurucu fonksiyonudur. (GUI Constructor)
     */
    public GUI(){
        super();
        this.setTitle("Linear Solver Deluxe");
        downP = new JPanel();
        GUIInit();
    }
    /**
     * Grafik arayuzu ilk calistiginda ilk yapilmasi gereken islemlerin metodu.
     * Frame olusturulur ve uzerine bir panel konulur. Bu panel uzerine diger nesneler
     * eklenerek grafik arayuzu tamamlanir.
     */
    private void GUIInit() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 400));
        panel.setBackground(Color.CYAN); // Panel renginin belirlenmesi.
        this.add(panel);
        panel.setLayout(new FlowLayout());
        panel.add(upPanel());
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    /**
     * Frame uzerinde bulunan ana panel uzerine yeni bir panel konulur.
     * Bu panel uzerinde matrisin satir ve sutun secimleri, 
     * matris boyutlarina gore matris bilgilerinin girilecegi metin alanlari, 
     * hangi metot ile cozuleceginin belirlenecegi bir acilir kutu, 
     * matrisi belirlenen metot ile cozmek icin bir buton ve matrislerin bulundugu 
     * paneli temizlemizlemek(silmek) icin bir buton daha yer almaktadir.
     * @return Farkli nesnelerin icinde bulundugu yeni panel, Frame uzerinde 
     * yer alan panele eklenmek icin return edilir.
     */
    private JPanel upPanel(){
        JPanel retPanel = new JPanel(new FlowLayout());
        retPanel.setPreferredSize(new Dimension(600, 50));
        retPanel.setBackground(Color.BLUE);
        Integer[] intRow = new Integer[20];
        for(int i = 1; i <= 20; i++)
            intRow[i-1] = i;
        rowSizeCombo = new JComboBox<>(intRow);
        colSizeCombo = new JComboBox<>(intRow);
        
        JLabel firstTag = new JLabel("row: ");
        firstTag.setForeground(Color.yellow);
        JLabel secondTag = new JLabel("col: ");
        secondTag.setForeground(Color.yellow);
        
        MethodsType[] metIntegers = MethodsType.values();
        JComboBox chooseType = new JComboBox<>();
        for(int i = 0; i < MethodsType.size; i++)
            chooseType.addItem(metIntegers[i]);
        /**
         * chooseType acilir kutunun(ComboBox) aktif dinleyici(ActionListener) metodu.
         * Metotlarin secilip, hangi metodun dinamik olarak aktif olacagini belirler.
         */
        chooseType.addActionListener((ae) -> {
            try {
                choosedType((MethodsType) chooseType.getSelectedItem());
            } catch (Exception ex) {
                GUI.resultPrint("Warning", ex.getMessage());
            }
        });
        
        JButton solverMatrix = new JButton("Solve");
        solverMatrix.setVisible(false);
        /**
         * solverMatrix butonunun aktif dinleyici(ActionListener) metodu.
         * Secilen cozum metoduna gore matrislerin cozulmesi icin tetikleyici butondur.
         */
        solverMatrix.addActionListener((ActionEvent ae) -> {
            try {
                choosedType((MethodsType) chooseType.getSelectedItem());
                Amatrix = new Double[row][col+1];
                int k = col;
                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++)
                        Amatrix[i][j] = Double.parseDouble(aTextFields[i][j].getText());
                }
                for(int i = 0; i < col; i++)
                    Amatrix[i][col] = Double.parseDouble(bTextFields[i].getText());
                linearSolverDeluxe.methodsSolver(Amatrix);
            } catch (Exception ex) {
                GUI.resultPrint("Warning", ex.getMessage());
            }
        });
        JButton generateMatrix = new JButton("Generate");
        /**
         * generateMatrix butonunun aktif dinleyici(ActionListener) metodu.
         * Matislerin girilecegi metin alanlarini, matris boyutlarina gore olusturur ve panele ekler.
         */
        generateMatrix.addActionListener((ActionEvent ae) -> {
            row = (int) rowSizeCombo.getSelectedItem();
            col = (int) colSizeCombo.getSelectedItem();
            panel.remove(downP);
            downP = downPanel();
            panel.add(downP);
            setContentPane(panel);
            solverMatrix.setVisible(true);
        });

        JButton deleteMatrix = new JButton("Delete");
        /**
         * deleteMatrix butonunun aktif dinleyici(ActionListener) metodu.
         * Matrislerin bulundugu paneli siler.
         */
        deleteMatrix.addActionListener((ae) -> {
            panel.remove(downP);
            solverMatrix.setVisible(false);
            setContentPane(panel);
        });
        
        // Panele eklenip, ana panele eklenmek uzere return edilir.
        retPanel.add(firstTag);
        retPanel.add(rowSizeCombo);
        retPanel.add(secondTag);
        retPanel.add(colSizeCombo);
        retPanel.add(generateMatrix);
        retPanel.add(chooseType);
        retPanel.add(solverMatrix);
        retPanel.add(deleteMatrix);
        return retPanel;
    }
    /**
     * Frame uzerinde bulunan ana panel uzerine yeni bir panel konulur.
     * Bu panel uzerinde iki tane Scrollpane yer alır ve bunlarin uzerinde ise
     * cozulmesi beklenen matris alanlari yer almaktadir.
     * @return Farkli panellerin icinde bulundugu yeni panel, Frame uzerinde 
     * yer alan panele eklenmek icin return edilir.
     */
    private JPanel downPanel(){
        JPanel retPanel = new JPanel(new BorderLayout());
        retPanel.setPreferredSize(new Dimension(600, 300));
        retPanel.setBackground(Color.yellow);
        
        JPanel AmatrixPane = new JPanel();
        JPanel BmatrixPane = new JPanel();
        
        AmatrixPane.setLayout(null);
        BmatrixPane.setLayout(null);

        AmatrixPane.setPreferredSize(new Dimension(col * 50, row * 35));
        BmatrixPane.setPreferredSize(new Dimension(row, col * 35));
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS ;
        
        
        JScrollPane aScroll = new JScrollPane(AmatrixPane,v,h);
        aScroll.setBorder(new LineBorder(Color.red,5));
        
        JScrollPane bScroll = new JScrollPane(BmatrixPane,v,h);
        bScroll.setBorder(new LineBorder(Color.green,5));
        
        aScroll.setPreferredSize(new Dimension(500, 300));
        bScroll.setPreferredSize(new Dimension(100, 300));
        createTextFilds(AmatrixPane, BmatrixPane);
        
        // Panele eklenip, ana panele eklenmek uzere return edilir.
        retPanel.add(aScroll, BorderLayout.WEST);
        retPanel.add(bScroll, BorderLayout.EAST);
        return retPanel;
    }
    /**
     * Matris verilerinin yazilacagi metin alanlari(TextFields) parametrelerde yer alan panellere eklenir.
     * @param AmatrixP A.x = B formulundeki cozulecek A matrisinin paneli
     * @param BmatrixP A.x = B formulundeki cozulecek B matrisinin(vektorunun) paneli
     */
    private void createTextFilds(JPanel AmatrixP,JPanel BmatrixP){
        JLabel[][] matrixLabel = new JLabel[row][col];
        aTextFields = new TextField[row][col];
        bTextFields = new TextField[col];
        for(int i = 0; i < col; i++){
            matrixLabel[0][i] = new JLabel("A"+i);
            matrixLabel[0][i].setBounds(48*i+45, 0, 30, 25);
            AmatrixP.add(matrixLabel[0][i]);
        }
        for(int i = 0; i < row; i++){
            matrixLabel[i][0] = new JLabel("A"+i);
            matrixLabel[i][0].setBounds(5, 33*i+30, 30, 25);
            AmatrixP.add(matrixLabel[i][0]);
            for(int j = 0; j < col; j++){
                aTextFields[i][j] = new TextField("" + 0);
                aTextFields[i][j].setBounds(48*j+45, 33*i+30, 30, 25);
                AmatrixP.add(aTextFields[i][j]); 
            }
        }
        JLabel b = new JLabel("B");
        b.setBounds(35, 0, 25, 25);
        BmatrixP.add(b);
        JLabel bMatrixLabel[] = new JLabel[col];
        for(int i = 0; i < col; i++ ){
            bMatrixLabel[i] = new JLabel("B"+i);
            bMatrixLabel[i].setBounds(5, 33*i+30, 30, 25);
            BmatrixP.add(bMatrixLabel[i]);
            bTextFields[i] = new TextField("" + 0);
            bTextFields[i].setBounds(35, 33*i+30, 30, 25);
            BmatrixP.add(bTextFields[i]);
        } 
    }
    /**
     * Hangi tip metot ile islem yapilacagini belirleyen metottur.
     * Secilen metot tipine gore metotlarin kurucu fonksiyonu (Constructor) cagrilir ve 
     * nesne olusturularak tetikleme islemi yapilir.
     * @param choosed Hangi metotun secildigini belirten parametre
     * @throws Exception Eger kare matris ile islem yapilmiyor ise Exception firlatilir. 
     * "Ancak bu kisim daha sonraki guncellemeler ile ufak degisiklikle duzenlemesi gerekecektir.
     * Ornegin: kare olmayan bir matrisin cozum yontemi eklendiginde"
     */
    private void choosedType(MethodsType choosed) throws Exception{
        if(row == col){
            switch(choosed){
                case GAUSSIAN_ELIMINATION:
                    linearSolverDeluxe = new LinearSolverDeluxe(new GaussianElimination());   
                    break;
                case MATRIX_INVERSION:
                    linearSolverDeluxe = new LinearSolverDeluxe(new MatrixInversion());
                    break;
            }
        }
        else
            throw new Exception("No Square Matrix for this method");
    }
    
    /**
     * Ekranda sonuclarin gosterilecegi acilir bir pencere.
     * @param title Acilir pencerenin basligi
     * @param message Acilir pencerede gosterilecek yazilar
     */
    public static void resultPrint(String title,String message){
        int error = JOptionPane.CLOSED_OPTION;
        if("Warning".equals(title))
            error = JOptionPane.ERROR_MESSAGE;
        else
            error = JOptionPane.CLOSED_OPTION;
        JOptionPane.showMessageDialog(new JFrame(),
            message,
            title,
            error);
    }
}
