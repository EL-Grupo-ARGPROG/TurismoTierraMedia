
package tierraMedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	static List<Vendible> aux = null;

	public static List<Vendible> ordenadorDeVendibles(TiposAtracciones tipo) {
		Collections.sort(AdministradorDeArchivos.getVendibles(), new ComparadorDeVendibles(tipo));
		return AdministradorDeArchivos.getVendibles();
	}

	public static void sugerirPromocion() {
		for (Usuario usuario : AdministradorDeArchivos.getUsuarios()) {
			ordenadorDeVendibles(usuario.getPreferencia());

			for (Vendible oferta : AdministradorDeArchivos.getVendibles()) {
				if(usuario.puedeComprar(oferta)) {
					System.out.println("¿Desea aceptar la oferta siguiente?\n" + oferta + "\n1-Si\n2-No");

					// Aca va el scanner para leer las desiciones del usuario (Si Acepta o no acepta
					// la oferta);
					Scanner sc = new Scanner(System.in);
					String response = sc.nextLine().toLowerCase();
					// if(el usuario responde que acepta)
					if (response == "1" || response == "si") {
						usuario.setOfertasAceptadas(oferta);
						usuario.setItinerario(oferta);
						usuario.restarTiempoDisponible(oferta.getTiempoNecesario());
						usuario.restarPresupuesto(oferta.getCosto());
						oferta.restarCupo();
						usuario.puedeComprar(oferta);
					} else if (response == "2" || response == "no") {
						continue;
					} else {
						System.out.println("Respuesta invalida");
					}
				} else {
					continue;
				}
				// mostrar Itinerario por consola (con finally)
				System.out.println(usuario.mostrarItinerario());
					
				}
				
		}

	}

	public static void main(String[] args) {
		AdministradorDeArchivos.leerArchivoUsuario();
		AdministradorDeArchivos.leerArchivoAtracciones();
		AdministradorDeArchivos.leerArchivoPromociones();
		
		sugerirPromocion();

	}

}
