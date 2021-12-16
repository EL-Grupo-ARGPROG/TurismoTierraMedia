package persistence;

import model.productos.Atracciones;
import model.productos.Vendible;
import persistence.commons.GenericDAO;

public interface AtraccionesDAO extends GenericDAO<Atracciones> {
	
	public int update(Vendible t);
	
	public Atracciones findByName(String name);
	

}
