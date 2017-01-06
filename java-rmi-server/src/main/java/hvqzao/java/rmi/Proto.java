package hvqzao.java.rmi;

import java.rmi.RemoteException;

public class Proto implements IProto {

        @Override
	public String hello(String name) throws RemoteException {
		String result = "Hello " + name + "!";
		System.out.println("Sending: " + result);
		return result;
	}

}
