package Pto5;

import java.rmi.RemoteException;

public class ServidorImplementador implements InterfazServer{

	public String getClima(String c) throws RemoteException {
		return "La temperatura de " + c + " es de " + (int)(Math.random()*50) +"º";
	}

	
}
