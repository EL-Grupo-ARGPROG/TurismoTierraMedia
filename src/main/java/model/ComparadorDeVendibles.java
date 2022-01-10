package model;

import java.util.Comparator;

import model.productos.TiposAtracciones;
import model.productos.Vendible;

public class ComparadorDeVendibles implements Comparator<Vendible> {
	public TiposAtracciones preferencia;

	public ComparadorDeVendibles(TiposAtracciones preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Vendible o1, Vendible o2) {
		if (o1.getTipo() == preferencia && o2.getTipo() != preferencia) {
			return -1;
		} else if (o1.getTipo() != preferencia && o2.getTipo() == preferencia) {
			return 1;
		} else if ((o1.getTipo() == preferencia && o2.getTipo() == preferencia)
				|| (o1.getTipo() != preferencia && o2.getTipo() != preferencia)) {
			if (o1.esPromocion() && !o2.esPromocion())
				return -1;
			else if (!o1.esPromocion() && o2.esPromocion())
				return 1;
			else if ((o1.esPromocion() && o2.esPromocion()) || (!o1.esPromocion() && !o2.esPromocion())) {
				if (o1.getCosto() > o2.getCosto()) {
					return -1;
				} else if (o1.getCosto() < o2.getCosto()) {
					return 1;
				} else if (o1.getCosto() == o2.getCosto()) {
					if (o1.getTiempoNecesario() > o2.getTiempoNecesario()) {
						return -1;
					} else if (o1.getTiempoNecesario() < o2.getTiempoNecesario()) {
						return 1;
					} else if (o1.getTiempoNecesario() == o2.getTiempoNecesario())
						return 0;
				}
			}
		}
		return 0;
	}

}
