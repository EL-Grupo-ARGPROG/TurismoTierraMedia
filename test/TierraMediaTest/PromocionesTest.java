package TierraMediaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import tierraMedia.Absoluta;
import tierraMedia.Atracciones;
import tierraMedia.AxB;
import tierraMedia.Porcentual;
import tierraMedia.Promociones;
import tierraMedia.TiposAtracciones;
import tierraMedia.Usuario;

public class PromocionesTest {
	Atracciones isla;
	Atracciones mordor;
	Atracciones fantasma;
	Promociones promoAbsoluta;
	Promociones promoPorcentual;
	Promociones promoAxB;
	
	@Before
	public void setUp() {
		isla = new Atracciones("La isla Misteriosa", 350, 2.3, 7, null);
		mordor = new Atracciones("Mordor", 200 ,2, 2, null);
		fantasma = new Atracciones("El fantasma", 450, 2.6, 0, null);
		promoAbsoluta = new Absoluta(new Atracciones[] {mordor, isla, fantasma}, "Promo", 500, TiposAtracciones.AVENTURA);
		promoPorcentual = new Porcentual(new Atracciones[] {mordor, isla, fantasma}, "Promo2", 25, TiposAtracciones.AVENTURA);
		promoAxB = new AxB(new Atracciones[] {mordor, isla, fantasma}, "Promo3", mordor, TiposAtracciones.AVENTURA);
	}
	
	@Test
	public void getCostoTest() {
		assertEquals(500, promoAbsoluta.getCosto(), 0);
		assertEquals(750, promoPorcentual.getCosto(), 0);
		assertEquals(800, promoAxB.getCosto(), 0);
	}
	
	@Test
	public void getTiempoTest() {
		assertEquals(6.9, promoAbsoluta.getTiempoNecesario(), 0);
	}
	
	@Test
	public void ContieneAtraccionTest() {
		assertTrue(promoAbsoluta.contieneAtraccion(mordor));
	}
	
	
	@Test
	public void cupoTest() {
		Atracciones mordor = new Atracciones("Pepu",0, 0, 0, null);
		Promociones promo = new Absoluta(new Atracciones[] {mordor}, "Promo", 10, TiposAtracciones.AVENTURA  );
		
		assertEquals(0, promo.getCupo());
		assertFalse(promo.hayCupo());
	}
	
	@Test
	public void puedeComprarTest() {
		Usuario u1 = new Usuario("Tomas", 500, 20, TiposAtracciones.PAISAJE);
		Atracciones mordor = new Atracciones("mordor", 150, 2.5, 2, TiposAtracciones.PAISAJE);
		Atracciones pepe = new Atracciones("pepe", 120, 2.3, 7, null);
		Atracciones jose = new Atracciones("jose", 150, 2.6, 2, null);
		Promociones promo2 = new Absoluta(new Atracciones[] {pepe, jose, mordor}, "promo2", 220, TiposAtracciones.PAISAJE);
		u1.comprar(promo2);
		
		assertFalse(u1.puedeComprar(mordor));

	}

}
