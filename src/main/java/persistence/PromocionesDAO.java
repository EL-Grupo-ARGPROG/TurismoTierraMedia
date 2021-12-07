package persistence;

import model.Atracciones;
import model.Promociones;


public interface PromocionesDAO extends GenericDAO<Promociones> {
	
	public Atracciones[] armarPaquete(int id);
	

}
