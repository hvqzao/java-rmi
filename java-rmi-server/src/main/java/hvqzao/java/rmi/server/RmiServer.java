package hvqzao.java.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import hvqzao.java.rmi.IProto;
import hvqzao.java.rmi.Proto;

public class RmiServer {

    public static void main(String[] args) throws InterruptedException, RemoteException, AlreadyBoundException {
        //System.setProperty("java.security.policy", "all.policy");
        //System.setSecurityManager(new SecurityManager());

        Proto proto = new Proto();
        IProto protoStub = (IProto) UnicastRemoteObject.exportObject(proto, 0);

        Registry registry = LocateRegistry.createRegistry(4000);
        registry.rebind("proto", protoStub);

        System.out.println("Started...");
        while (true) {
            Thread.yield();
            Thread.sleep(Integer.MAX_VALUE);
        }
    }

}
