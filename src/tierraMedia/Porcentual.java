package tierraMedia;

public class Porcentual extends Promociones {
	private final int PORCENTAJE;

	public Porcentual(Atracciones[] pack, String nombre, int porcentaje, TiposAtracciones tipo) {
		super(pack, nombre, tipo);
		this.PORCENTAJE = porcentaje;
	}

	public int calcularCosto() {
		for (Atracciones atraccion : this.pack) {
			this.costoPromocion += atraccion.getCosto();
		}
		int descuento = (this.PORCENTAJE / 100) * this.costoPromocion;
		return this.costoPromocion - descuento;
	}

}
