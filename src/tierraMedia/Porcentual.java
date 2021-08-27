package tierraMedia;

public class Porcentual extends Promociones {
	private final int PORCENTAJE;

	public Porcentual(Atracciones[] pack, String nombre, int porcentaje,
			          TiposAtracciones tipo) {
		this.pack = pack;
		this.nombre = nombre;
		this.PORCENTAJE = porcentaje;
		this.tipo = tipo;
	}

	public int calcularCosto() {
		for (Atracciones atraccion : this.pack) {
			this.costoPromocion += atraccion.getCosto();
		}
		int descuento = (this.PORCENTAJE / 100) * this.costoPromocion;
		return this.costoPromocion - descuento;
	}

}
