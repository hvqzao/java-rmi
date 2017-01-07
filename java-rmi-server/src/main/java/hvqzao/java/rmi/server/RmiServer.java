package hvqzao.java.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import hvqzao.java.rmi.IProto;
import hvqzao.java.rmi.Proto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class RmiServer {

    public static void main(String[] args) throws InterruptedException, RemoteException, AlreadyBoundException, FileNotFoundException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, CertificateException, IOException, UnrecoverableKeyException, IOException, CertificateException, KeyManagementException {
        //System.setProperty("java.security.policy", "all.policy");
        //System.setSecurityManager(new SecurityManager());
        
        // keytool -genkey -alias registry -keyalg RSA -keystore registry.ks
        // password: registrypw
        // keytool -export -alias registry -keystore registry.ks -file registry.crt
        // keytool -genkey -alias client -keyalg RSA -keystore client.ks
        // password: clientpw
        // keytool -import -alias registry -keystore client.ts -file registry.crt
        //
        // keytool -export -alias client -keystore client.ks -file client.crt
        // keytool -import -alias client -keystore registry.ts -file client.crt
        
        //Registry registry = LocateRegistry.createRegistry(4000);
        SslClientSocketFactory csf = new SslClientSocketFactory("client", "clientpw");
        SslServerSocketFactory ssf = new SslServerSocketFactory("registry", "registrypw");
        Registry registry = LocateRegistry.createRegistry(4000, csf, ssf);

        Proto proto = new Proto();
        IProto protoStub = (IProto) UnicastRemoteObject.exportObject(proto, 0);
        registry.rebind("proto", protoStub);

        System.out.println("Started...");
        while (true) {
            Thread.yield();
            Thread.sleep(Integer.MAX_VALUE);
        }
    }

}
