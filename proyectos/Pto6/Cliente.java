package Pto6;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Cliente {
	

	public static void main(String[] args) {
		
		try {
			//Registro el cliente al servidor port 8000;
			Registry clienteRMI = LocateRegistry.getRegistry("127.0.0.1", 8000);
			
			String[] servicios = clienteRMI.list();
			
			InterfazServer is = (InterfazServer) clienteRMI.lookup(servicios[0]);
			
			//ingreso los vectores
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduzca cantidad elemento 1er vector");
			int tamanio1 = entrada.nextInt();
			
			int v1[] = new int[tamanio1];
			
			Scanner entradaV1 = new Scanner(System.in);
			
			System.out.println("Introduzca 1er vector");
			
				for(int i = 0;i < tamanio1; i++ ) {
					v1[i] = entradaV1.nextInt();
				}  
				
				
			System.out.println("Introduzca cantidad elemento 2do vector");
			int tamanio2 = entrada.nextInt();
			int v2[] = new int[tamanio2];
			
			System.out.println("Introduzca 2do vector");
			
			for(int i = 0;i < tamanio2; i++ ) {
				v2[i] = entradaV1.nextInt();
			} 
			
			int vec3[] = is.sumaVectoresPrueba(v1, v2);
		
			
			for(int i = 0; i< vec3.length; i++) {
				System.out.println("La suma es: " + vec3[i]);
			}
			//String msg= is.getClima(climaCiudad);
				 
			//System.out.println(msg);
			
			
			
			
			/*for (String service : servicios) {
				System.out.println("Servicios: " +  service);
				//System.out.println(""+ service);
			}*/
			
			
			
			//Persona p = new Persona("Esteban","Iarza",24);
			//System.out.println("Datos " + is.getNombre(p));
			
		} catch (RemoteException e) {
				e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}

}
