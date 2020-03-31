package Pto5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

	
	public static void main(String[] args) {
		
		try {
			
			Registry clienteRMI = LocateRegistry.getRegistry("127.0.0.1", 8000);
			
			
			String[] servicios = clienteRMI.list();
			
			InterfazServer is = (InterfazServer) clienteRMI.lookup(servicios[0]);
			String climaCiudad;
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduzca su ciudad que desea ver el clima");
			climaCiudad = entrada.nextLine();
			
			String msg= is.getClima(climaCiudad);
			
			System.out.println(msg);
			
			
			
			
			/*for (String service : servicios) {
				System.out.println("Servicios: " +  service);
				//System.out.println(""+ service);
			}*/
			
			
			
			//Persona p = new Persona("Esteban","Iarza",24);
			//System.out.println("Datos " + is.getNombre(p));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
