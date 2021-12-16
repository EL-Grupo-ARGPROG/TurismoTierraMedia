package model.productos;

public class Absoluta extends Promociones {

	private final int PRECIO_FINAL;

	public Absoluta(Atracciones[] pack, String nombre, int precioFinal, TiposAtracciones tipo) {
		super(pack, nombre,tipo);
		this.PRECIO_FINAL = precioFinal;
	}
    @Override
	public double getCosto() {
		return this.costoPromocion = PRECIO_FINAL;
	}

}
