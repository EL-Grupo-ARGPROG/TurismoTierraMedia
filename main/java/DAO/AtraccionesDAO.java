package DAO;

import tierraMedia.Atracciones;
import tierraMedia.Vendible;

public interface AtraccionesDAO extends GenericDAO<Atracciones> {
	
	public int update(Vendible t);
	

}
