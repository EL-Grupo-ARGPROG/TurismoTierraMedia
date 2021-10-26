package TierraMediaTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DAO.PromocionesDAOImpl;
import tierraMedia.AdministradorDeArchivos;
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
		
		List<Vendible> pepe = Sistema.ordenadorDeVendibles(TiposAtracciones.AVENTURA);
		for(int i = 0; i < algo.length; i++) {
			assertEquals(algo[i], pepe.get(i).getNombre());
		}
//		//Promociones Aventura, primero la mas cara.
//		assertEquals("Pack Aventura 2", pepe.get(0).getNombre());
//		assertEquals("Pack Aventura", pepe.get(1).getNombre());
//		//Atracciones Aventura, primero las mas caras.
//		assertEquals("Mordor", pepe.get(2).getNombre());
//		//Atracciones Aventura, al tener mismo precio, se ordena primero la mas tardosa.
//		assertEquals("La isla misteriosa", pepe.get(3).getNombre()); // Cuesta 150, Tarda 2.6
//		assertEquals("mordor2", pepe.get(4).getNombre()); // Cuesta 150, Tarda 2.5
//		assertEquals("Moria", pepe.get(5).getNombre());
//		assertEquals("Bosque Negro", pepe.get(6).getNombre());
//		//Promociones de distinta Preferencia, primero las mas caras
//		assertEquals("Pack Degustacion 2", pepe.get(7).getNombre());
//		assertEquals("Pack Degustacion", pepe.get(8).getNombre());
//		assertEquals("Pack Paisajes", pepe.get(9).getNombre());
//		assertEquals("Pack Paisaje 2", pepe.get(10).getNombre());
//		//Atracciones de distintas preferencias, primero las mas caras
//		assertEquals("Erebor", pepe.get(11).getNombre());
//		assertEquals("Lothlorein", pepe.get(12).getNombre());
//		assertEquals("La Comarca", pepe.get(13).getNombre());
//		assertEquals("Los Arboles Del Infinito", pepe.get(14).getNombre());
//		assertEquals("Abismo de Helm", pepe.get(15).getNombre());
//		assertEquals("Minas Tirith", pepe.get(16).getNombre());
	}

}
