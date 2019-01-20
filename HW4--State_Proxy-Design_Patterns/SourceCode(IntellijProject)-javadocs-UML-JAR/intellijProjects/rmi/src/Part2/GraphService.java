package Part2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GraphService extends Remote {
    /**
     * construct graph
     * @param a account
     * @param edges edges (edge id = index)
     * @param V number of vertexes
     * @return constructed graph
     * @throws RemoteException
     * @throws NoCreditException
     */
    Graph createGraph(Account a, Edge[] edges, int V) throws RemoteException, NoCreditException;

    /**
     * @param a account
     * @param g graph
     * @return incidence matrix
     * @throws RemoteException
     * @throws NoCreditException
     */
    double[][] getIncidenceMatrix(Account a, Graph g) throws RemoteException, NoCreditException;

    /**
     *
     * @param a account
     * @param g graph
     * @return MST
     * @throws RemoteException
     * @throws NoCreditException
     */
    Graph getMinimumSpanningTree(Account a, Graph g) throws RemoteException, NoCreditException;

    /**
     * @param a account
     * @param g graph
     * @return g.toString()
     * @throws RemoteException
     * @throws NoCreditException
     */
    String graphToString(Account a, Graph g) throws RemoteException, NoCreditException;
}
