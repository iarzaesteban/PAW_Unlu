package Pto6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazServer extends Remote{
	
	public int[] sumaVectores(int[] v1, int[] v2) throws RemoteException;
	
	public int[] sumaVectoresPrueba(int[] v1, int[] v2) throws RemoteException;
		
	
		
}
