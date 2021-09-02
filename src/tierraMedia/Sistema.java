
package tierraMedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Sistema {
	private static ArrayList<Vendible> vendibles;
	private Usuario[] visitantes;
	// private Atracciones[] atracciones;

	ArrayList<Vendible> aux = null;

	public ArrayList<Vendible> ordenadorDeVendibles(TiposAtracciones tipo) {
		Collections.sort(vendibles, new ComparadorDeVendibles(tipo));
		return vendibles;
	}

	public ArrayList<Vendible> filtrarOfertas(Usuario usuario) {
		aux = ordenadorDeVendibles(usuario.getPreferencia());
		for (Vendible oferta : aux) {
			if (oferta.getCosto() > usuario.getPresupuesto()) {
				aux.remove(oferta);
			}
			if (oferta.getTiempoNecesario() > usuario.getTiempoDisponible()) {
				aux.remove(oferta);
			}
			if (usuario.getAtraccionesAceptadas().contains(oferta)) {
				aux.remove(oferta);
			}
			if (!oferta.hayCupo()) {
				aux.remove(oferta);
			}
		}
		return aux;
	}

	public void sugerirPromocion() {
		for (Usuario usuario : visitantes) {
			filtrarOfertas(usuario);
			for (Vendible oferta : aux) {
				System.out.println("¿Desea aceptar la oferta siguiente?" + oferta);

				// Aca va el scanner para leer las desiciones del usuario (Si Acepta o no acepta
				// la oferta);
				// if(el usuario responde que acepta)
				// {usuario.setOfertasAceptadas(oferta)
				// usuario.setItinerario(oferta)
				// usuario.restarTiempoDisponible(oferta.getTiempoNecesario())
				// usuario.restarPresupuesto(oferta.getCosto())
				// oferta.restarCupo()
				// filtrarOfertas();
				// } else {(si el usuario no acepta)
				// continue;
			}
			// mostrar Itinerario por consola (con finally)
		}

	}

	public static void main(String[] args) {
	}

}
