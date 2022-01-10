package model.productos;

public class AxB extends Promociones {
	private Atracciones atraccionGratis;

	public AxB(Atracciones[] pack, String nombre, Atracciones atraccionGratis, TiposAtracciones tipo) {
		super(pack, nombre, tipo);
		this.atraccionGratis = atraccionGratis;
	}
	
	public Atracciones getAtraccionGratis() {
		return this.atraccionGratis;
	}
	
	@Override
	public double getCosto() {
		for (Atracciones atraccion : this.pack) {
			this.costoPromocion += atraccion.getCosto();
		}
		return this.costoPromocion - atraccionGratis.costo;
	}
}
