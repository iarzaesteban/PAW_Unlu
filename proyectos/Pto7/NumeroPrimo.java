package Pto7;

import java.io.Serializable;

public class NumeroPrimo implements InterfazTarea,Serializable {
	int numero;

	public Object ejecutar() {
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador!=this.numero)){
		    if (this.numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
	}

	
}
