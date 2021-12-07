package persistence;

import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionesDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionesDAO getAtraccionesDAO() {
		return new AtraccionesDAOImpl();
	}
	
	public static PromocionesDAO getPromocionesDAO() {
		return new PromocionesDAOImpl();
	}
	
	public static ItinerarioDAOImpl getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
}
