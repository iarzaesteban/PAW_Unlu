package Pto7;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Servidor {
	
	public static void main (String[] args) {
		
		try {
			//paso1- Crear servidor RMI
			Registry serverRMI = LocateRegistry.createRegistry(33333);
			System.out.println("Servidor escuchando en el puerto 33333");
			
			
			
			//paso3 - Export objet of servidor
			Resultor r = new Resultor();
			InterfazServer servidor1 = (InterfazServer) UnicastRemoteObject.exportObject(r, 7000);
			//InterfazServer servidor2 = (InterfazServer) UnicastRemoteObject.exportObject(r,7001);
			
			//paso4 - vinculacion(bind) de nombre de servicio a objeto.
			
			serverRMI.rebind("Servidor- Operaciones genericas", servidor1);
			//serverRMI.rebind("otro-servidor", servidor2);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
