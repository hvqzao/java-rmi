package hvqzao.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProto extends Remote {

	public String hello(String name) throws RemoteException;
	
}
