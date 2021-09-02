package tierraMedia;

public class AxB extends Promociones {
	private Atracciones atraccionGratis;

	public AxB(Atracciones[] pack, String nombre, Atracciones atraccionGratis, TiposAtracciones tipo) {
		this.pack = pack;
		this.nombre = nombre;
		this.tipo = tipo;
		this.atraccionGratis = atraccionGratis;
	}

	public int calcularCosto() {
		for (Atracciones atraccion : this.pack) {
			this.costoPromocion += atraccion.getCosto();
		}
		return this.costoPromocion - atraccionGratis.costo;
	}
	
	@Override
	public int getCosto() {
		return costoPromocion;
	}

}
