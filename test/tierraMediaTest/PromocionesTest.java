package tierraMediaTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.*;
import persistence.impl.PromocionesDAOImpl;

public class PromocionesTest {
	Atracciones isla;
	Atracciones mordor;
	Atracciones fantasma;
	Promociones promoAbsoluta;
	Promociones promoPorcentual;
	Promociones promoAxB;
	ArrayList<Vendible> itinerario;

	@Before
	public void setUp() {
		itinerario = new ArrayList<Vendible>();
		isla = new Atracciones("La isla Misteriosa", 350, 2.3, 7, null);
		mordor = new Atracciones("Mordor", 200, 2, 2, null);
		fantasma = new Atracciones("El fantasma", 450, 2.6, 0, null);
		promoAbsoluta = new Absoluta(new Atracciones[] { mordor, isla, fantasma }, "Promo", 500,
				TiposAtracciones.AVENTURA);
		promoPorcentual = new Porcentual(new Atracciones[] { mordor, isla, fantasma }, "Promo2", 25,
				TiposAtracciones.AVENTURA);
		promoAxB = new AxB(new Atracciones[] { mordor, isla, fantasma }, "Promo3", mordor, TiposAtracciones.AVENTURA);
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
		Atracciones mordor = new Atracciones("Pepu", 0, 0, 0, null);
		Promociones promo = new Absoluta(new Atracciones[] { mordor }, "Promo", 10, TiposAtracciones.AVENTURA);

		assertEquals(0, promo.getCupo());
		assertFalse(promo.hayCupo());
	}

	@Test
	public void puedeComprarTest() {
		Usuario u1 = new Usuario(1, "Tomas", null, 500, 20, TiposAtracciones.PAISAJE, itinerario, false);
		Atracciones mordor = new Atracciones("mordor", 150, 2.5, 2, TiposAtracciones.PAISAJE);
		Atracciones pepe = new Atracciones("pepe", 120, 2.3, 7, null);
		Atracciones jose = new Atracciones("jose", 150, 2.6, 2, null);
		Promociones promo2 = new Absoluta(new Atracciones[] { pepe, jose, mordor }, "promo2", 220,
				TiposAtracciones.PAISAJE);
		u1.comprar(promo2);

		assertFalse(u1.puedeComprar(mordor));

	}

//	@Test
//	public void tipoGetName() {
//		Sistema.instanciaDeObjetos();
//			System.out.println(PromocionesDAOImpl.vendiblesList);
//
//	}
	
	@Test
	public void OdernadorTest() {
		Sistema.instanciaDeObjetos();
        int hora1 = 1;
		int hora2 = 10;
		int valor1 = 10;
		int valor2 = 600;
		String tipo = "AVENTURA";
		
		List<Vendible> vendiblesFiltrados = new LinkedList<Vendible>();
	
		List<Vendible> lista =  Sistema.ordenadorDeVendibles(TiposAtracciones.valueOf(tipo));
		
		
		for (Vendible vendible : lista ) {
			if ((vendible.getTipo().name().equals(tipo)) && (vendible.getTiempoNecesario() >= hora1)
					&& (vendible.getTiempoNecesario() <= hora2) && (vendible.getCosto() >= valor1)
					&& (vendible.getCosto() <= valor2) && (!vendiblesFiltrados.contains(vendible))) {

				vendiblesFiltrados.add(vendible);
				
			}

		}
			System.out.println(vendiblesFiltrados);
	}



}
