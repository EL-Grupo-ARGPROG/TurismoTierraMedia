package services;

import model.Itinerario;
import model.Usuario;
import model.productos.Promociones;
import model.productos.Vendible;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class ComprarVendibleService {
	
	public boolean comprar(Vendible vendible, Usuario user) {
		ItinerarioDAOImpl itinerarioDAO = new ItinerarioDAOImpl();
		UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
		
		if(!user.puedeComprar(vendible) || !vendible.hayCupo()) {
			return false;
		} else {
			user.comprar(vendible);
			userDAO.update(user);
			vendible.restarCupo();
			
			if(vendible.esPromocion()) {
				new PromocionService().update((Promociones)vendible);
				Itinerario itAux = new Itinerario(user.getId(), null, vendible);
				itinerarioDAO.insert(itAux);
			}else {
				new AtraccionService().update(vendible);
				Itinerario itAux = new Itinerario(user.getId(), vendible, null);
				itinerarioDAO.insert(itAux);
			}
			
			return true;
		}
		
	}

}
