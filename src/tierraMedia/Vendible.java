package tierraMedia;

public interface Vendible {
	
	public int getCosto();
	
	public int getTiempoNecesario();
	
	public int getCupo();
	
	public boolean hayCupo();
	
	public boolean esPromocion();
	
	public TiposAtracciones getAtraccion();
}
