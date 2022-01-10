package model;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.productos.TiposAtracciones;
import model.productos.Vendible;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionesDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class Sistema {
	static UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
	static AtraccionesDAOImpl atraccionDAO = new AtraccionesDAOImpl();
	static PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();
	static ItinerarioDAOImpl itinerarioDAO = new ItinerarioDAOImpl();

	public static void instanciaDeObjetos() {
		
		AtraccionesDAOImpl.atraccionesList.clear();
		PromocionesDAOImpl.promocionesList.clear();
		PromocionesDAOImpl.vendiblesList.clear();
		UsuarioDAOImpl.usuariosList.clear();

		atraccionDAO.instanciadorDeAtracciones();
		usuarioDAO.instanciadorDeUsuarios();
		promocionDAO.instanciadorDePromociones();
	}

	public static List<Vendible> ordenadorDeVendibles(TiposAtracciones tipo) {

		Collections.sort(PromocionesDAOImpl.vendiblesList, new ComparadorDeVendibles(tipo));
		return PromocionesDAOImpl.vendiblesList;
	}

	public static List<Vendible> sugerirVisitas(Usuario usuario) throws IOException {
		List<Vendible> sugerenciasList = new LinkedList<Vendible>();

		ordenadorDeVendibles(usuario.getPreferencia());

		for (Vendible oferta : PromocionesDAOImpl.vendiblesList) {
			if (usuario.getPresupuesto() >= oferta.getCosto()
					&& usuario.getTiempoDisponible() >= oferta.getTiempoNecesario() && usuario.puedeComprar(oferta)) {
				sugerenciasList.add(oferta);
			}

		}
		return sugerenciasList;
	}

}
