package tierraMedia;

public interface Vendible {
	
	public int getCosto();
	
	public double getTiempoNecesario();
	
	public int getCupo();
	
	public boolean hayCupo();
	
	public boolean esPromocion();
	
	public TiposAtracciones getTipo();
}
