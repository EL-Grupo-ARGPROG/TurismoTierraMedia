package tierraMedia;

public class Atracciones implements Vendible {
	protected String nombre;
	protected double costo;
	protected double tiempoNecesario;
	protected int cupo;
	protected TiposAtracciones tipo;

	public Atracciones(String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo) {
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.cupo = cupo;
		this.tipo = tipo;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempoNecesario() {
		return tiempoNecesario;
	}

	@Override
	public int getCupo() {
		return cupo;
	}

	public void restarCupo() {
		this.cupo--;
	}

	@Override
	public boolean esPromocion() {
		return false;
	}

	@Override
	public boolean hayCupo() {
		if (this.cupo <= 0)
			return false;
		else
			return true;
	}

	@Override
	public TiposAtracciones getTipo() {
		return this.tipo;
	}


}
