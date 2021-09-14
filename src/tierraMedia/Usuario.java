package tierraMedia;

import java.util.ArrayList;

public class Usuario {
	protected String nombre;
	protected double presupuesto;
	protected double tiempoDisponible;
	protected TiposAtracciones preferencia;
	protected ArrayList<Vendible> atraccionesAceptadas;
	protected ArrayList<Vendible> itinerario;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, TiposAtracciones preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
		this.atraccionesAceptadas = new ArrayList<Vendible>();
	}

	public void restarPresupuesto(double costo) {
		this.presupuesto -= costo;
	}

	public void restarTiempoDisponible(double tiempo) {
		this.tiempoDisponible -= tiempo;
	}

	public void guardaSugerencia(Vendible oferta) {
		this.atraccionesAceptadas.add(oferta);
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TiposAtracciones getPreferencia() {
		return preferencia;
	}

	public ArrayList<Vendible> getAtraccionesAceptadas() {
		return atraccionesAceptadas;
	}

	public ArrayList<Vendible> setOfertasAceptadas(Vendible oferta) {
		if (oferta.esPromocion()) {
			for (Vendible atraccion : ((Promociones) oferta).getPack())
				atraccionesAceptadas.add(atraccion);
		} else {
			atraccionesAceptadas.add(oferta);
		}
		return atraccionesAceptadas;
	}

	public void setItinerario(Vendible oferta) {
		itinerario.add(oferta);
	}

	public String mostrarItinerario() {
		double tiempo = 0;
		double costo = 0;
		String aux = "";
		for (Vendible vendible : this.itinerario) {
			tiempo += vendible.getTiempoNecesario();
			costo += vendible.getCosto();

			if (vendible.esPromocion()) {
				aux += (vendible);
			} else {
				aux += (vendible);
			}
		}

		return aux + "\nTOTAL: " + String.valueOf(tiempo) + "H" + "    " + String.valueOf(costo) + "$";

}

	@Override
	public String toString() {
		return this.getNombre();

	}

	public boolean puedeComprar(Vendible oferta) {
		if (oferta.getCosto() > this.getPresupuesto()) {
			return false;
		} else if (oferta.getTiempoNecesario() > this.getTiempoDisponible()) {
			return false;
		} else if (!oferta.hayCupo()) {
			return false;
		} else if (!oferta.esPromocion()) {
			for (Vendible atraccion : this.getAtraccionesAceptadas()) {
				if(oferta.equals(atraccion)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void comprar(Vendible oferta) {
		this.setOfertasAceptadas(oferta);
		this.setItinerario(oferta);
		this.restarTiempoDisponible(oferta.getTiempoNecesario());
		this.restarPresupuesto(oferta.getCosto());
	}

	public boolean tieneDinero() {
		if(this.getPresupuesto() == 0) {
			return false;
		} else { 
			return true;
		}
		
	}

	public boolean tieneTiempo() {
		if(this.getTiempoDisponible() == 0) {
			return false;
		} else { 
			return true;
		}

	}

}
