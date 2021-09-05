package tierraMedia;

public abstract class Promociones implements Vendible {
	protected String nombre;
	protected int costoPromocion;
	protected double tiempoNecesario;
	protected TiposAtracciones tipo;
	protected Atracciones[] pack;

	public Promociones(Atracciones[] pack, String nombre, TiposAtracciones tipo) {
		this.pack = pack;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public TiposAtracciones getTipo() {
		return tipo;
	}
	
	public void restarCupo() {
		for(Vendible atraccion : pack) {
			atraccion.restarCupo();
		}
	}

	public abstract double getCosto();

	public double getTiempoNecesario() {
		for (Atracciones atraccion : this.pack) {
			this.tiempoNecesario += atraccion.getTiempoNecesario();
		}
		return this.tiempoNecesario;
	}

	public boolean hayCupo() {
		boolean r = true;
		for (Atracciones atraccion : this.pack)
			if (atraccion.getCupo() <= 0) {
				r = false;
			}
		return r;
	}

	public int getCupo() {
		int cupoMenor = 1000;
		for (Atracciones atraccion : this.pack) {
			cupoMenor = Math.min(cupoMenor, atraccion.getCupo());
		}
		return cupoMenor;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " Atracciones Incluidas: " + this.getPack();
	}

	public boolean esPromocion() {
		return true;
	}
	
	public Atracciones[] getPack() {
		return pack;
	}
}
