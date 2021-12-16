package services;

import java.util.List;

import model.productos.Atracciones;
import model.productos.Promociones;
import model.productos.Vendible;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.PromocionesDAOImpl;

public class PromocionService {

	PromocionesDAOImpl promocionesDAO = new PromocionesDAOImpl();
	AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();

	public List<Promociones> list() {
		return promocionesDAO.findAll();
	}

	public Vendible find(String name) {
		return promocionesDAO.finder(name);
	}
	
	public Promociones update(Promociones prod) {
		for(Atracciones atraccion : prod.getPack()) {
			
		atraccionesDAO.update(atraccion);
		}
		
		return prod;
	}
	
//
//	public Promociones create(String name, Double price, Integer stock) {
//		Promociones prod = new Promociones(name, price, stock);
//		if (prod.isValid()) {
//			PromocionesDAOImpl.insert(prod);
//		}
//		return prod;
//	}
	
//	public void delete(Integer id) {
//	promocionesDAO.delete(id);
//}
//
//public Promociones update(Integer id, String name, Double price, Integer stock) {
//	Promociones promo = new Promociones(id, name, price, stock);
//	if (prod.isValid()) {
//		PromocionesDAOImpl.update(prod);
//	}
//	return prod;
//}
//

}
