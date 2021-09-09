package TierraMediaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tierraMedia.Absoluta;
import tierraMedia.Atracciones;
import tierraMedia.AxB;
import tierraMedia.ComparadorDeVendibles;
import tierraMedia.Porcentual;
import tierraMedia.AdministradorDeArchivos;
import tierraMedia.Promociones;
import tierraMedia.TiposAtracciones;
import tierraMedia.Usuario;
import tierraMedia.Vendible;

public class PromocionesTest {
	
	Atracciones mordor = new Atracciones("mordor", 150, 2.5, 5, null);
	Atracciones pepe = new Atracciones("pepe", 120, 2.3, 7, null);
	Atracciones jose = new Atracciones("jose", 150, 2.6, 0, null);
	Promociones promo2 = new AxB(new Atracciones[] {pepe, mordor}, "promo2", jose, TiposAtracciones.PAISAJE);

	@Test
	public void test() {
		Atracciones mordor = new Atracciones("Pepu",0, 0, 0, null);
		Promociones promo = new Absoluta(new Atracciones[] {mordor}, "Promo", 10, TiposAtracciones.AVENTURA  );
		
		assertEquals(0, promo.getCupo());
		assertFalse(promo.hayCupo());
		System.out.println(promo2.getCosto());
	}
	
	
	
	

	private Object c1() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
