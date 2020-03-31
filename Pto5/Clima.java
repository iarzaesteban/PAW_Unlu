package Pto5;

public class Clima {
	public String tipo;
	public float temperatura;
	
	
	
	public Clima(String tipo, float temperatura) {
		super();
		this.tipo = tipo;
		this.temperatura = temperatura;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

}
