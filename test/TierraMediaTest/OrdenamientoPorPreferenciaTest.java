package TierraMediaTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DAO.AtraccionesDAOImpl;
import DAO.PromocionesDAOImpl;
import DAO.UsuarioDAOImpl;
import tierraMedia.Atracciones;
import tierraMedia.Sistema;
import tierraMedia.TiposAtracciones;
import tierraMedia.Vendible;

public class OrdenamientoPorPreferenciaTest {
	
	
	@Before
	public void setUp() {
		//Agregamos dos Atracciones mas con el mismo precio, pero distinto tiempo.
		Atracciones mordor2 = new Atracciones("mordor2", 150, 2.5, 5, TiposAtracciones.AVENTURA);
		Atracciones isla = new Atracciones("La isla misteriosa", 150, 2.6, 0, TiposAtracciones.AVENTURA);
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		AtraccionesDAOImpl atraccionDAO = new AtraccionesDAOImpl();
		PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();
		
		usuarioDAO.instanciadorDeUsuarios();
		atraccionDAO.instanciadorDeAtracciones();
		promocionDAO.instanciadorDePromociones();
		
		PromocionesDAOImpl.vendiblesList.add(isla);
		PromocionesDAOImpl.vendiblesList.add(mordor2);
		
	}

	@Test
	public void lasAtraccionesDePreferenciaSeMuestranPrimero() {
		String[] algo = {"Pack Aventura 2", "Pack Aventura", "Mordor",
				"La isla misteriosa", "mordor2", "Moria", "Bosque Negro",
				"Pack Degustacion 2", "Pack Degustacion", "Pack Paisajes",
				"Pack Paisaje 2", "Erebor", "Lothlorein", "La Comarca",
				"Los Arboles Del Infinito", "Abismo de Helm", "Minas Tirith"};
		
		List<Vendible> ordenada = Sistema.ordenadorDeVendibles(TiposAtracciones.AVENTURA);
		for(int i = 0; i < algo.length; i++) {
			assertEquals(algo[i], ordenada.get(i).getNombre());
						
		}
		
	}

}