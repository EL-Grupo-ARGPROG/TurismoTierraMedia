package tierraMedia;

public class Atracciones implements Vendible {
	protected int costo;
	protected double tiempoNecesario;
	protected int cupo;
	protected TiposAtracciones tipo;
	
	public Atracciones(int costo, int tiempoNecesario, int cupo, TiposAtracciones tipo) {
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public int getCosto() {
		return costo;
	}
	
	public double getTiempoNecesario() {
		return tiempoNecesario;
	}
	
	public int getCupo() {
		return cupo;
	}
	
	public void restarCupo() {
		this.cupo--;
	}

}
