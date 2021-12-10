package persistence;

import model.Atracciones;
import model.Vendible;
import persistence.commons.GenericDAO;

public interface AtraccionesDAO extends GenericDAO<Atracciones> {
	
	public int update(Vendible t);
	
	public Atracciones findByID(Integer id);
	

}
