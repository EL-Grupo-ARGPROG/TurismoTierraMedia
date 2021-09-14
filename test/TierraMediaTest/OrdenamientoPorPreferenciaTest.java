package TierraMediaTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tierraMedia.AdministradorDeArchivos;
import tierraMedia.Sistema;
import tierraMedia.TiposAtracciones;
import tierraMedia.Vendible;

public class OrdenamientoPorPreferenciaTest {
	
	@Before
	public void setUp() {
		AdministradorDeArchivos.leerArchivoUsuario("data/usuarioIN.txt");
		AdministradorDeArchivos.leerArchivoAtracciones("data/atraccionesIN.txt");
		AdministradorDeArchivos.leerArchivoPromociones("data/promocionesIN.txt");
	}

	@Test
	public void lasAtraccionesDePreferenciaSeMuestranPrimero() {
		List<Vendible> pepe = Sistema.ordenadorDeVendibles(TiposAtracciones.AVENTURA);
		//Promociones Aventura, primero la mas cara.
		assertEquals("Pack Aventura 2", pepe.get(0).getNombre());
		assertEquals("Pack Aventura", pepe.get(1).getNombre());
		//Atracciones Aventura, primero las mas caras.
		assertEquals("Mordor", pepe.get(2).getNombre());
		assertEquals("Moria", pepe.get(3).getNombre());
		assertEquals("Bosque Negro", pepe.get(4).getNombre());
		//Promociones de distinta Preferencia, primero las mas caras
		assertEquals("Pack Degustacion 2", pepe.get(5).getNombre());
		assertEquals("Pack Degustacion", pepe.get(6).getNombre());
		assertEquals("Pack Paisajes", pepe.get(7).getNombre());
		assertEquals("Pack Paisaje 2", pepe.get(8).getNombre());
		//Atracciones de distintas preferencias, primero las mas caras
		assertEquals("Erebor", pepe.get(9).getNombre());
		assertEquals("Lothlorein", pepe.get(10).getNombre());
		assertEquals("La Comarca", pepe.get(11).getNombre());
		assertEquals("Los Arboles Del Infinito", pepe.get(12).getNombre());
		assertEquals("Abismo de Helm", pepe.get(13).getNombre());
		assertEquals("Minas Tirith", pepe.get(14).getNombre());
	}

}
