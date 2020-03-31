package Pto7;

import java.io.Serializable;

public class NumeroRandom implements InterfazTarea,Serializable{

	int desde;
	int rango;
	public Object ejecutar() {
		return (int)(Math.random()*rango) + desde;
	}
	

}
