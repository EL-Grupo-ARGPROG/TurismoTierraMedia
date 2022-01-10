package model.productos;

public interface Vendible {
	
	public double getCosto();
	
	public double getTiempoNecesario();
	
	public int getCupo();
	
	public boolean hayCupo();
	
	public boolean esPromocion();
	
	public TiposAtracciones getTipo();
	
	public void restarCupo();
	
	public String getNombre();
	
	public void serVendido();
}
