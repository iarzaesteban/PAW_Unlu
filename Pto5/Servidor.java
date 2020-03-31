package Pto5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	
	public static void main(String[] args){
		
		try {
			//paso1- Crear servidor RMI
			Registry serverRMI = LocateRegistry.createRegistry(8000);
			//paso2- Instanciar InterfazSevidor implementantion class
			ServidorImplementador si1 = new ServidorImplementador();
			ServidorImplementador si2 = new ServidorImplementador();
			//paso3 - Export objet of servidor
			InterfazServer servidor1 = (InterfazServer) UnicastRemoteObject.exportObject(si1, 7000);
			InterfazServer servidor2 = (InterfazServer) UnicastRemoteObject.exportObject(si2,7001);
			//paso4 - vinculacion(bind) de nombre de servicio a objeto.
			
			serverRMI.rebind("Distribuidos-servidor", servidor1);
			serverRMI.rebind("otro-servidor", servidor2);
			System.out.println("Corriendo ");
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	
}
 