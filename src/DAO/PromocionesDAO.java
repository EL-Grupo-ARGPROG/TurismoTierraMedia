package DAO;

import java.util.List;

import tierraMedia.Atracciones;
import tierraMedia.Promociones;

public interface PromocionesDAO extends GenericDAO<Promociones> {
	
	public Atracciones[] armarPaquete(int id);
	

}
