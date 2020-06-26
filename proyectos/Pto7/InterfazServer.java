package Pto7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazServer extends Remote{
	
	public Object ejecutarTareas(InterfazTarea t) throws RemoteException;
	
		
}
