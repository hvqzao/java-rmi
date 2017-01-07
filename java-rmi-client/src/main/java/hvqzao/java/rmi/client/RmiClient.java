package hvqzao.java.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import hvqzao.java.rmi.IProto;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, IOException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, KeyManagementException, CertificateException {
        //System.setProperty("java.security.policy", "all.policy");
        //System.setSecurityManager(new SecurityManager());

        //Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4000);
        SslClientSocketFactory csf = new SslClientSocketFactory("client", "clientpw");
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4000, csf);

        IProto proto = (IProto) registry.lookup("proto");
        System.out.println("Received: " + proto.hello("RMI"));
    }

}
