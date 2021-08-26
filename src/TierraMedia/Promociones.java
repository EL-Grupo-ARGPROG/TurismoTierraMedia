package TierraMedia;

public abstract class Promociones implements Vendible {
	protected Atracciones[] pack;
	protected String nombre;
	protected TiposAtracciones tipo;
	protected int costoPromocion;
	protected int tiempoNecesario;
	
	public abstract int calcularCosto();
	
	public abstract int calcularTiempo();
	
	
	public int getCosto() {
		return this.costoPromocion;
	}
	
	public int getTiempoNecesario() {
		return this.tiempoNecesario;
	}
	
	public int getCupo() {
		return 0;
	}
	
}
