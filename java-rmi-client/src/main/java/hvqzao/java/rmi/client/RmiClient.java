package hvqzao.java.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import hvqzao.java.rmi.IProto;

public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        //System.setProperty("java.security.policy", "all.policy");
        //System.setSecurityManager(new SecurityManager());

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4000);
        IProto proto = (IProto) registry.lookup("proto");
        System.out.println("Received: " + proto.hello("RMI"));
    }

}
