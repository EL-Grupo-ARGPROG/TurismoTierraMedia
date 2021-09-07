package TierraMediaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tierraMedia.*;

public class AtraccionesTest {

	@Test
	public void LecturaAtraccionesTest() {
		
		LeerArchivos.leerArchivoAtracciones();
		System.out.println(LeerArchivos.getVendibles());

	}

}
