
package tierraMedia;

import java.io.IOException;
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

	public static void sugerirVisitasYEscribirItinerario() throws IOException {
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
						//le muestro al usuario sus recursos restantes.
						System.out.println("\n"+usuario.getNombre() + 
								", tus recursos restantes: $" + usuario.getPresupuesto() 
								+ ", " + usuario.getTiempoDisponible() + "H.");
						//le muestro al usuario la oferta
						System.out.println("\n" + usuario.getNombre() + " ¿Deseas aceptar la siguiente oferta?\n"
								+ oferta.mostrarOfertaDescriptiva() + "\n1-Si\n2-No");
						String response = sc.nextLine().toLowerCase();
						// if(el usuario responde que acepta)
						if (response.equals("1") || response.equals("si")) {
							invalidResponse = false;
							usuario.comprar(oferta);
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
			System.out.println(usuario.mostrarItinerario());
			AdministradorDeArchivos.escribirItinerario(usuario);
		}

	}

	public static void main(String[] args) throws IOException {
		AdministradorDeArchivos.leerArchivoUsuario("data/usuarioIN.txt");
		AdministradorDeArchivos.leerArchivoAtracciones("data/atraccionesIN.txt");
		AdministradorDeArchivos.leerArchivoPromociones("data/promocionesIN.txt");

		sugerirVisitasYEscribirItinerario();

	}

}
