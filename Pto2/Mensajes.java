package Pto2;

public class Mensajes {
	int id;
	String mensaje;
	
	public Mensajes(int id, String mensaje) {
		super();
		this.id = id;
		this.mensaje = mensaje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}
