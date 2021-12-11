/*package services;
import java.util.List;
import model.Atracciones;
import model.TiposAtracciones;
import model.Promociones;
import model.AxB;
import model.Absoluta;
import model.Porcentual;
import persistence.impl.PromocionesDAOImpl;

public class PromocionService {
	
	PromocionesDAOImpl promocionesDAO = new PromocionesDAOImpl();
	
	public List<Promociones> list(){
		return PromocionesDAOImpl.findAll();
	}
	
	public void delete(Integer id) {
		PromocionesDAOImpl.delete(id);
	}
	
	public Promociones update(Integer id, String name, Double price, Integer stock) {
		Promociones promo = new Promociones(id, name, price, stock);
		if(prod.isValid()) {
			PromocionesDAOImpl.update(prod);
		}
		return prod;
	}
	
	public Promociones update(Promociones prod) {
		if(prod.isValid()) {
			PromocionesDAOImpl.update(prod);
		}
		return prod;
	}
	
	public Promociones find(Integer id) {
		return PromocionesDAOImpl.find(id);
	}
	
	public Promociones create(String name, Double price, Integer stock) {
		Promociones prod = new Promociones(name, price, stock);
		if(prod.isValid()) {
			PromocionesDAOImpl.insert(prod);
		}
		return prod;
	}
}

}
*/
