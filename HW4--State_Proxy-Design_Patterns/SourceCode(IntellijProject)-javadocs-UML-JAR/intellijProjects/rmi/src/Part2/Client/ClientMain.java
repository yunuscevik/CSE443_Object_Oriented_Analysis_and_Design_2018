package Part2.Client;

import Part2.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {

        String host = "localhost";

        if (args.length == 1)
            host = args[0];

        try {
            GraphService graphService = (GraphService) Naming.lookup("rmi://" + host + "/BulutCizge");
            RegistrationService registrationService =
                    (RegistrationService)  Naming.lookup("rmi://" + host + "/BulutCizgeKayit");

            Account account = new Account("Yunus", "123");
            registrationService.register(account, 100);

            List<Edge> edges = new ArrayList<>();
            edges.add(new Edge(0, 1, 4));
            edges.add(new Edge(0, 2, 3));
            edges.add(new Edge(0, 3, 1));


            Graph graph = graphService.createGraph(account, edges.toArray(new Edge[edges.size()]), 4);
            double[][] retval = graphService.getIncidenceMatrix(account, graph);

            registrationService.loadCredit(account, 42);

            for (double[] row : retval) {
                for (double d : row)
                    System.out.print(String.format("%3.2f ", d));
                System.out.println("");
            }
            System.out.println("");

            Graph g2 = graphService.getMinimumSpanningTree(account,graph);
            System.out.println(graphService.graphToString(account, graph));
        } catch (NotBoundException | MalformedURLException | RemoteException | NoCreditException e) {
            e.printStackTrace();
        }
    }
}
