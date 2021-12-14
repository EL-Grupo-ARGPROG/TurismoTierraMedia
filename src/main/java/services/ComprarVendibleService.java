package services;

import model.Itinerario;
import model.Promociones;
import model.Usuario;
import model.Vendible;
import persistence.impl.ItinerarioDAOImpl;

public class ComprarVendibleService {
	
	public boolean comprar(Vendible vendible, Usuario user) {
		ItinerarioDAOImpl itinerarioDAO = new ItinerarioDAOImpl();
		
		if(!user.puedeComprar(vendible) || !vendible.hayCupo()) {
			return false;
		} else {
			user.comprar(vendible);
			vendible.serVendido();
			
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
