package Pto7;

import java.io.Serializable;

public class ValorPI implements InterfazTarea,Serializable{

	int precision;
	public Object ejecutar() {
		int decimal =1;
		int signo = 1;
		double t;
		double sumatoria = 0;
		for(int i =1; i<= precision; i++) {
			t= (double)1 / decimal * signo;
			sumatoria += t;
			decimal+=2;
			signo *=-1;
		}
		return sumatoria*4;
		
		
	}

}
