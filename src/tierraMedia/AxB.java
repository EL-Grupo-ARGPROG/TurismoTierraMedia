package tierraMedia;

public class AxB extends Promociones {
	private Atracciones atraccionGratis;

	public AxB(Atracciones[] pack, String nombre, Atracciones atraccionGratis, TiposAtracciones tipo) {
		super(pack, nombre, tipo);
		this.atraccionGratis = atraccionGratis;
	}
	
	@Override
	public int getCosto() {
		for (Atracciones atraccion : this.pack) {
			this.costoPromocion += atraccion.getCosto();
		}
		return this.costoPromocion - atraccionGratis.costo;
	}

}
