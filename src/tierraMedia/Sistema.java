
package tierraMedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	public static List<Vendible> ordenadorDeVendibles(TiposAtracciones tipo) {
		Collections.sort(AdministradorDeArchivos.getVendibles(), new ComparadorDeVendibles(tipo));
		return AdministradorDeArchivos.getVendibles();
	}

	// usuario.comprar()

	public static void sugerirPromocion() {
		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : AdministradorDeArchivos.getUsuarios()) {
			ordenadorDeVendibles(usuario.getPreferencia());

			for (Vendible oferta : AdministradorDeArchivos.getVendibles()) {
				boolean invalidResponse = true;
				if (!usuario.tieneDinero() || !usuario.tieneTiempo()) {
					break;
				}
				if (usuario.puedeComprar(oferta)) {
					while (invalidResponse) {
						System.out.println("¿Desea aceptar la oferta siguiente?\n" + oferta + "\n1-Si\n2-No");
						String response = sc.nextLine().toLowerCase();
						// if(el usuario responde que acepta)
						if (response.equals("1") || response.equals("si")) {
							invalidResponse = false;
//							usuario.comprar(oferta);
							usuario.setOfertasAceptadas(oferta);
//							usuario.setItinerario(oferta);
							usuario.restarTiempoDisponible(oferta.getTiempoNecesario());
							usuario.restarPresupuesto(oferta.getCosto());
							oferta.restarCupo();
						} else if (response.equals("2") || response.equals("no")) {
							invalidResponse = false;
							continue;
						} else {
							System.out.println("Respuesta invalida");
						}
					}
				} else {
					continue;
				}
			}

			// mostrar Itinerario por consola (con finally)
//			System.out.println(usuario.mostrarItinerario());

		}

	}

	public static void main(String[] args) {
		AdministradorDeArchivos.leerArchivoUsuario();
		AdministradorDeArchivos.leerArchivoAtracciones();
		AdministradorDeArchivos.leerArchivoPromociones();

		sugerirPromocion();

	}

}
