package Pto5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazServer extends Remote{
	
	public  String getClima(String c) throws RemoteException;
 
 
}

