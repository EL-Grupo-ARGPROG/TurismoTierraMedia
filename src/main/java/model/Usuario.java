package model;

import java.util.ArrayList;
import java.util.LinkedList;

import persistence.impl.ItinerarioDAOImpl;
import utils.Crypt;

public class Usuario {
	protected int id;
	protected String username, password;
	protected double presupuesto;
	protected double tiempoDisponible;
	protected TiposAtracciones preferencia;
	protected ArrayList<Atracciones> atraccionesAceptadas;
	protected ArrayList<Vendible> itinerario;
	protected boolean admin;

	public Usuario(int id, String username, String password, double presupuesto, double tiempoDisponible, TiposAtracciones preferencia, ArrayList<Vendible> itinerario2, boolean admin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
		this.atraccionesAceptadas = new ArrayList<Atracciones>();
		this.itinerario = itinerario2;
		this.admin = admin;
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

	public void guardaSugerencia(Atracciones oferta) {
		this.atraccionesAceptadas.add(oferta);
	}

	public String getNombre() {
		return username;
	}

	public double getPresupuesto() {
		return presupuesto;
	}
	
	public boolean isAdmin() {
		return this.admin;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TiposAtracciones getPreferencia() {
		return preferencia;
	}

	public ArrayList<Atracciones> getAtraccionesAceptadas() {
		return atraccionesAceptadas;
	}
	
	public String getPassword() {
		return this.password;
	}

	public ArrayList<Atracciones> setOfertasAceptadas(Vendible oferta) {
		if (oferta.esPromocion()) {
			for (Atracciones atraccion : ((Promociones) oferta).getPack())
				atraccionesAceptadas.add(atraccion);
		} else {
			atraccionesAceptadas.add((Atracciones) oferta);
		}
		return atraccionesAceptadas;
	}

	public void setItinerario(Vendible oferta) {
		itinerario.add(oferta);
	}

	public ArrayList<Vendible> getItinerario() {
		return this.itinerario;
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
		for (Vendible vendible: this.itinerario) {
			if (vendible.equals(oferta)) {
				return false;
			}
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

	public boolean isNull() {
		return false;
	}
	
	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}
	
	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}


}
