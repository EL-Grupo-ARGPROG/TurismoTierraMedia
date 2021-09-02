package tierraMedia;

public class Atracciones implements Vendible {
	protected int costo;
	protected int tiempoNecesario;
	protected int cupo;
	protected TiposAtracciones tipo;
	
	public Atracciones(int cupos) {
		this.cupo = cupos;
	}
	
	@Override
	public int getCosto() {
		return costo;
	}
	@Override
	public int getTiempoNecesario() {
		return tiempoNecesario;
	}
	@Override
	public int getCupo() {
		return cupo;
	}
	
	@Override
	public boolean esPromocion() {
		return false;
	}


	@Override
	public boolean hayCupo() {
		if (this.cupo <= 0)
			return false;
		else return true;
	}

	@Override
	public TiposAtracciones getAtraccion() {
		return this.tipo;
	}
	

}
