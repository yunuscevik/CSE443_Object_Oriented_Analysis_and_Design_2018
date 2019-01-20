package Part2.Server;

import Part2.GraphService;

import java.net.MalformedURLException;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) {
        try {
            Register register = new Register();
            GraphService graphService = new BulutCizgeGraphService();
            GraphService proxy = (GraphService) Proxy.newProxyInstance(graphService.getClass().getClassLoader(),
                                                                        graphService.getClass().getInterfaces(),
                                                                        new GraphServiceInvocationHandler(graphService, register));

            //graph service
            Naming.rebind("BulutCizge",  UnicastRemoteObject.exportObject(proxy, 0));
            //registration service
            Naming.rebind("BulutCizgeKayit",  UnicastRemoteObject.exportObject(register, 0));
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
