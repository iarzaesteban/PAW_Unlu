package Pto7;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cliente  {
	
	
	public static void main(String[] args) {

		try {
			
			Registry clientRMI = LocateRegistry.getRegistry("127.0.0.1", 33333);
			System.out.println("Lista de servicios disponibles: ");
			
			String[] services = clientRMI.list();
		
			/*for (String service : services) {
				System.out.println(service);
			}*/  
			
			InterfazServer servicios = (InterfazServer) clientRMI.lookup(services[0]);
			
			menuPrincipal(servicios);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void menuPrincipal(InterfazServer servicios) {
		Scanner op = new Scanner(System.in);
		System.err.println("Escoja una opcion: ");
		System.out.println("1- Calcular numero random");
		System.out.println("2- Verificar un numero si es primo o no");
		System.out.println("3- Ver precision del numero PI");
		System.out.println("0- Salir");
		int opcion = op.nextInt();
		while (opcion != 0) {		
			switch (opcion) {
				case 1: numRandom(servicios);
					menuPrincipal(servicios);
					break;
				case 2: verPrimo(servicios);
					menuPrincipal(servicios);	
					break;
				case 3: precisionPI(servicios);
					menuPrincipal(servicios);
					break;
			}
			
		}
		
	}
	
	
	
	
	private static void numRandom(InterfazServer servicios) {
		//Numero Random
		System.out.println("Operacion numero random ");
		NumeroRandom random = new NumeroRandom();
		
		System.out.println("Ingrese desde ");
		Scanner desde = new Scanner(System.in);
		random.desde = desde.nextInt();
		System.out.println("Ingrese hasta ");
		Scanner hasta = new Scanner(System.in);
		
		random.rango = (hasta.nextInt() - random.desde) +1;
		try {
			System.out.println("El numero random es: "+servicios.ejecutarTareas(random));
			System.out.println("-----------------------------------");
			menuPrincipal(servicios);
			
		} catch (RemoteException e) {
			System.out.println("holaaaaa");
			e.printStackTrace();
		}
	}
	private static void verPrimo(InterfazServer servicios) {
		//Numero Primo
		NumeroPrimo primo = new NumeroPrimo();
		System.out.println("Ingrese numero para verificar si es primo");
		Scanner numPrimo = new Scanner(System.in);
		primo.numero = numPrimo.nextInt();
		try {
			System.out.println("El numero "+primo.numero+" es primo? " +servicios.ejecutarTareas(primo));
			System.out.println("-----------------------------------");
			menuPrincipal(servicios);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void precisionPI(InterfazServer servicios) {
		//Valor de PI
		System.out.println("Ingrese numero de precision para el calculo de PI");
		ValorPI vPI = new ValorPI();
		Scanner preciosionPI = new Scanner(System.in);
		vPI.precision = preciosionPI.nextInt();
		try {
			System.out.println("El numero PI calculado es: "+ servicios.ejecutarTareas(vPI));
			System.out.println("-----------------------------------");
			menuPrincipal(servicios);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


