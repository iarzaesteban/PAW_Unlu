package Pto7;

import java.rmi.RemoteException;

public class Resultor implements InterfazServer {

	public Object ejecutarTareas(InterfazTarea t) throws RemoteException {
		return t.ejecutar();
	}

	
}
