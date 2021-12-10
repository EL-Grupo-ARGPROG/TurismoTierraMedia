package services;

import java.util.Collections;
import java.util.List;
import model.*;
import persistence.impl.*;

public class CarruselService {
	
	public static List<Vendible> getVendibles(Usuario user){
		List<Vendible> vendiblesList = PromocionesDAOImpl.vendiblesList;
		ComparadorDeVendibles comparadorDeVendibles = 
				new ComparadorDeVendibles(user.getPreferencia());
		
		Collections.sort(vendiblesList, comparadorDeVendibles);
		
//		for (Vendible ven : vendiblesList) {
//			for (Vendible ven2 : vendiblesList) {
//				comparadorDeVendibles.compare(ven, ven2);
//			}
//		}
		
		/*	pedir lista de atracciones a db
		 * 	pedir lista promos a db
		 * 	juntar ambas listas
		 * 	ordenarla segun preferencias (preferencias y recursos)
		 */
		return vendiblesList;
	}
	
}