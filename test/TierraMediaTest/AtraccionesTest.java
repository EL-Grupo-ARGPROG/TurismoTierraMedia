package TierraMediaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tierraMedia.*;

public class AtraccionesTest {

	@Test
	public void LecturaAtraccionesTest() {
		
		AdministradorDeArchivos.leerArchivoAtracciones("data/atraccionesIN.txt");
		System.out.println(AdministradorDeArchivos.getVendibles());

	}

}
