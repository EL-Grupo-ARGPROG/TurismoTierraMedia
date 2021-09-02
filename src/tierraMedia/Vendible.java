package tierraMedia;

public interface Vendible {
	
	public int getCosto();
	
	public double getTiempoNecesario();
	
	public TiposAtracciones getTipo();
	
	public int getCupo();
	
	public boolean hayCupo();
	
	public boolean esPromocion();
}
