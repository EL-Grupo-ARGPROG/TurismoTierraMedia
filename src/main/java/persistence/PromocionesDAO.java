package persistence;

import model.productos.Atracciones;
import model.productos.Promociones;
import persistence.commons.GenericDAO;


public interface PromocionesDAO extends GenericDAO<Promociones> {
	
	public Atracciones[] armarPaquete(int id);
	

}
