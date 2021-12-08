package tierraMediaTest;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.*
;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.PromocionesDAOImpl;
import persistence.impl.UsuarioDAOImpl;




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