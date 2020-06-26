package Pto6;

import java.rmi.RemoteException;

public class ServidorImplementador implements InterfazServer{

	public int[] sumaVectores(int[] v1, int[] v2) throws RemoteException {
			int[] v3 = new int[v1.length];
			for(int i=0; i< v1.length; i++) {
				v3[i] = v1[i] + v2[i];
		}
		return v3;
	}

	public int[] sumaVectoresPrueba(int[] v1, int[] v2) throws RemoteException {
		int[] vaux = new int[v1.length];
		vaux = cambiarVector(v1);
		
		for(int i=0; i< v1.length; i++) {
			vaux[i] = vaux[i] + v2[i];
		}
	return vaux;
	}
	
	
	private int[] cambiarVector(int[] vector) {
		int[] vecChange = new int[vector.length];
		
			for(int i =0; i< vector.length; i++) {
				vecChange[i] = (int)(Math.random()*100);
			}
		return vecChange;
	}
	

}
