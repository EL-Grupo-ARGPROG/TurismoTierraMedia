package DAO;

import model.Atracciones;
import model.Vendible;

public interface AtraccionesDAO extends GenericDAO<Atracciones> {
	
	public int update(Vendible t);
	

}
