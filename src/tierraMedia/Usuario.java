package tierraMedia;

import java.util.ArrayList;

public class Usuario {
	protected String nombre;
	protected int presupuesto;
	protected double tiempoDisponible;
	protected TiposAtracciones preferencia;
	protected ArrayList<Vendible> atraccionesAceptadas;
	protected ArrayList<Vendible> itinerario;

	public Usuario(String nombre, int presupuesto, int tiempoDisponible, TiposAtracciones preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
	}

	public void restarPresupuesto(int costo) {
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

	public int getPresupuesto() {
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
		int costo = 0;
		
		for(Vendible unidad : itinerario) {
			tiempo += unidad.getTiempoNecesario();
			costo += unidad.getCosto();
		}
		
		return "Tu itinerario es: " + this.itinerario + " " + costo + " " + tiempo;
	}

}
