package TierraMediaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tierraMedia.*;
import tierraMedia.Atracciones;
import tierraMedia.TiposAtracciones;

public class PromocionesTest {

	@Test
	public void test() {
		Atracciones mordor = new Atracciones(0);
		Promociones promo = new Absoluta(new Atracciones[] {mordor}, "Promo", 10, TiposAtracciones.AVENTURA  );
		
		assertEquals(0, promo.getCupo());
		assertFalse(promo.hayCupo());
	}

}
