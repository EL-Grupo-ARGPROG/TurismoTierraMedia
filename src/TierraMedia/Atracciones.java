package TierraMedia;

public class Atracciones implements Vendible {
	protected int costo;
	protected int tiempoNecesario;
	protected int cupo;
	protected TiposAtracciones tipo;
	
	
	public int getCosto() {
		return costo;
	}
	
	public int getTiempoNecesario() {
		return tiempoNecesario;
	}
	
	public int getCupo() {
		return cupo;
	}
	

}
