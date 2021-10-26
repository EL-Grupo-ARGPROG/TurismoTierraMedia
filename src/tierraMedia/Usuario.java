package tierraMedia;

import java.util.ArrayList;

import DAO.ItinerarioDAOImpl;

public class Usuario {
	protected int id;
	protected String nombre;
	protected double presupuesto;
	protected double tiempoDisponible;
	protected TiposAtracciones preferencia;
	protected ArrayList<Vendible> atraccionesAceptadas;
	protected ArrayList<Vendible> itinerario;

	public Usuario(int id, String nombre, double presupuesto, double tiempoDisponible, TiposAtracciones preferencia) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
		this.atraccionesAceptadas = new ArrayList<Vendible>();
		this.itinerario = new ArrayList<Vendible>();
	}
	
	public int getId() {
		return this.id;
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
			aux += (vendible);
		}
		return this.getNombre() + ", este es tu itinerario:\n" + aux + "\nTOTAL: " + String.valueOf(tiempo) + "H"
				+ "    " + String.valueOf(costo) + "$";
	}

	@Override
	public String toString() {
		return this.getNombre();

	}
	
	public void guardarItinerarioEnDAO(Vendible oferta) {
		Itinerario itinerario;
		//int id_usuario, Vendible atraccion, Vendible promocion
		if(oferta.esPromocion()) {
			itinerario = new Itinerario(this.getId(), null, oferta);
		} else {
			itinerario = new Itinerario(this.getId(), oferta, null);
		}
		
		ItinerarioDAOImpl.itinerarioList.add(itinerario);
	}

	public boolean puedeComprar(Vendible oferta) {
		if (oferta.getCosto() > this.getPresupuesto()) {
			return false;
		}
		if (oferta.getTiempoNecesario() > this.getTiempoDisponible()) {
			return false;
		}
		if (!oferta.hayCupo()) {
			return false;
		}
		for (Vendible atraccion : this.getAtraccionesAceptadas()) {
			if (oferta.equals(atraccion)) {
				return false;
			}
			if (oferta.esPromocion()) {
				if(((Promociones) oferta).contieneAtraccion(atraccion))
					return false;
			}
		}
		return true;
	}

	public void comprar(Vendible oferta) {
		this.setOfertasAceptadas(oferta);
		this.setItinerario(oferta);
		this.guardarItinerarioEnDAO(oferta);
		this.restarTiempoDisponible(oferta.getTiempoNecesario());
		this.restarPresupuesto(oferta.getCosto());
	}

	public boolean tieneDinero() {
		if (this.getPresupuesto() == 0) {
			return false;
		} else {
			return true;
		}

	}

	public boolean tieneTiempo() {
		if (this.getTiempoDisponible() == 0) {
			return false;
		} else {
			return true;
		}

	}

}
