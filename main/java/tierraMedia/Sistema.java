package tierraMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import DAO.AtraccionesDAOImpl;
import DAO.ItinerarioDAOImpl;
import DAO.PromocionesDAOImpl;
import DAO.UsuarioDAOImpl;

public class Sistema {
	static UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
	static AtraccionesDAOImpl atraccionDAO = new AtraccionesDAOImpl();
	static PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();
	static ItinerarioDAOImpl itinerarioDAO = new ItinerarioDAOImpl();
	
	public static void instanciaDeObjetos() {
			atraccionDAO.instanciadorDeAtracciones();
			promocionDAO.instanciadorDePromociones();
			usuarioDAO.instanciadorDeUsuarios();
		
//		System.out.println(PromocionesDAOImpl.vendiblesList);
//		System.out.println(AtraccionesDAOImpl.atraccionesList);
//		System.out.println(UsuarioDAOImpl.usuariosList);
	}

	public static List<Vendible> ordenadorDeVendibles(TiposAtracciones tipo) {
		Collections.sort(PromocionesDAOImpl.vendiblesList, new ComparadorDeVendibles(tipo));
		return PromocionesDAOImpl.vendiblesList;
	}

	// usuario.comprar()

	public static void sugerirVisitasYEscribirItinerario() throws IOException {
		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : UsuarioDAOImpl.usuariosList) {
			ordenadorDeVendibles(usuario.getPreferencia());

			for (Vendible oferta : PromocionesDAOImpl.vendiblesList) {
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
			EscritorDeRecibos.escribirRecibos(usuario);
			usuarioDAO.update(usuario);
			for(Vendible atraccion : usuario.atraccionesAceptadas) {
				atraccionDAO.update(atraccion);
			}
		}
		System.out.println("Gracias por usar los servicios de GAMGEE TOURISM AGENCY");
		for(Itinerario itinerario : ItinerarioDAOImpl.itinerarioList) {
			itinerarioDAO.insert(itinerario);
		}
	}

	public static void main(String[] args) throws IOException {
		instanciaDeObjetos();
		
		sugerirVisitasYEscribirItinerario();

	}

}
