package persistence;

import model.Atracciones;
import model.Promociones;
import persistence.commons.GenericDAO;


public interface PromocionesDAO extends GenericDAO<Promociones> {
	
	public Atracciones[] armarPaquete(int id);
	

}
