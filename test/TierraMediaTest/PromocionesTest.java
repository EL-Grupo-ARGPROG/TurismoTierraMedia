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
import tierraMedia.ComparadorDeVendibles;
import tierraMedia.AdministradorDeArchivos;
import tierraMedia.Promociones;
import tierraMedia.TiposAtracciones;
import tierraMedia.Usuario;
import tierraMedia.Vendible;

public class PromocionesTest {
	
	Atracciones mordor = new Atracciones("mordor", 150, 2.5, 5, null);
	Atracciones pepe = new Atracciones("pepe", 120, 2.3, 7, null);
	Atracciones jose = new Atracciones("jose", 150, 2.6, 0, null);
	Promociones promo2 = new Absoluta(new Atracciones[] {pepe, jose, mordor}, "promo2", 220, TiposAtracciones.PAISAJE);

	@Test
	public void test() {
		Atracciones mordor = new Atracciones("Pepu",0, 0, 0, null);
		Promociones promo = new Absoluta(new Atracciones[] {mordor}, "Promo", 10, TiposAtracciones.AVENTURA  );
		
		assertEquals(0, promo.getCupo());
		assertFalse(promo.hayCupo());
	}
	
	@Test
	public void comparatorDeVendiblesTest() {
		Vendible[] vendibles = new Vendible[5];
		vendibles[0] = mordor;
		vendibles [2] = new Absoluta(new Atracciones[] {pepe, mordor}, "Promo", 500, TiposAtracciones.AVENTURA  );
		vendibles [1] = pepe;
		vendibles [3] = promo2;
		vendibles [4] = jose;
		
		ComparadorDeVendibles c1 = new ComparadorDeVendibles(TiposAtracciones.PAISAJE);
		Arrays.sort(vendibles, c1);
		
			System.out.println(vendibles[0]);
			System.out.println(vendibles[1]);
			System.out.println(vendibles[2]);
			System.out.println(vendibles[3]);
			System.out.println(vendibles[4]);
		
		
		
	}
	
	@Test
	public void LecturaPromocionesTest() throws IOException{
		AdministradorDeArchivos.leerArchivoAtracciones();
		AdministradorDeArchivos.leerArchivoPromociones();
		System.out.println(AdministradorDeArchivos.getVendibles());
		AdministradorDeArchivos.leerArchivoUsuario();
		System.out.println(AdministradorDeArchivos.getUsuarios());
		List<Usuario> aux = AdministradorDeArchivos.getUsuarios();
        AdministradorDeArchivos.EscribirItinerario(aux.get(0));
	}

	private Object c1() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
