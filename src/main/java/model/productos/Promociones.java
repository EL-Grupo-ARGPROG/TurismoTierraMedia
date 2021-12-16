package model.productos;

import java.util.Arrays;

public abstract class Promociones implements Vendible {
	protected String nombre;
	protected double costoPromocion = 0.0;
	protected double tiempoNecesario = 0;
	protected TiposAtracciones tipo;
	protected Atracciones[] pack;

	public Promociones(Atracciones[] pack, String nombre, TiposAtracciones tipo) {
		this.pack = pack;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public TiposAtracciones getTipo() {
		return tipo;
	}

	public void restarCupo() {
		for (Vendible atraccion : this.pack) {
			atraccion.restarCupo();
		}
	}

	@Override
	public void serVendido() {
		for (Atracciones atraccion : this.pack) {
			atraccion.cupo -= 1;
		}
	}

	public abstract double getCosto();

	public double getTiempoNecesario() {
		double tiempo = 0;
		for (Atracciones atraccion : this.pack) {
			tiempo = (tiempo + atraccion.getTiempoNecesario());
		}
		return this.tiempoNecesario = tiempo;
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
		return this.getNombre();
	}

	public boolean esPromocion() {
		return true;
	}

	public Atracciones[] getPack() {
		return pack;
	}

	public boolean contieneAtraccion(Vendible atraccionOfrecida) {
		for (Atracciones atraccion : this.pack) {
			if (atraccion.equals(atraccionOfrecida)) {
				return true;
			}
		}
		return false;
	}
}
