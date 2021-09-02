package tierraMedia;

public abstract class Promociones implements Vendible {
	protected Atracciones[] pack;
	protected String nombre;
	protected TiposAtracciones tipo;
	protected int costoPromocion;
	protected int tiempoNecesario;
	
	public Promociones(Atracciones[] pack, String nombre, TiposAtracciones tipo) {
		this.pack = pack;
		this.nombre = nombre;
		this.tipo = tipo;
	}


	public abstract int getCosto();

	public int getTiempoNecesario() {
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
	
	public boolean esPromocion() {
		return true;
	}
	
	public TiposAtracciones getAtraccion() {
		return this.tipo;
	}

}
