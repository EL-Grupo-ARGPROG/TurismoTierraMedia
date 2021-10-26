package TierraMediaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import tierraMedia.Absoluta;
import tierraMedia.Atracciones;
import tierraMedia.AxB;
import tierraMedia.Porcentual;
import tierraMedia.TiposAtracciones;
import tierraMedia.Usuario;

public class UsuarioTest {
	Usuario u1 = new Usuario(2, "pepito", 100, 100, TiposAtracciones.AVENTURA);

	Atracciones a1 = new Atracciones("a1", 10, 3, 6, TiposAtracciones.AVENTURA);
	Atracciones a2 = new Atracciones("a2", 4, 2.5, 20, TiposAtracciones.AVENTURA);
	Atracciones a3 = new Atracciones("a3", 2, 1, 25, TiposAtracciones.AVENTURA);
	Atracciones a4 = new Atracciones("a4", 8, 4, 10, TiposAtracciones.AVENTURA);

	Absoluta p1 = 	new Absoluta	(new Atracciones[] {a1, a2}, "Promo 1", 10, TiposAtracciones.AVENTURA);
	Porcentual p2 = new Porcentual	(new Atracciones[] {a1, a3}, "Promo 2", 0.3, TiposAtracciones.AVENTURA);
	AxB p3 = 		new AxB			(new Atracciones[] {a1, a3, a2}, "Promo 3", a2, TiposAtracciones.AVENTURA);
	Absoluta p4 = 	new Absoluta	(new Atracciones[] {a2, a4}, "Promo 4", 5, TiposAtracciones.AVENTURA);

	@Test
	public void test1() {
		u1.comprar(a1);
		assertFalse(u1.puedeComprar(p2));
	}
	
	@Test
	public void test2() {
		u1.comprar(p1);
		assertFalse(u1.puedeComprar(a2));
	}
	
	@Test
	public void test3() {
		u1.comprar(p1);
		assertFalse(u1.puedeComprar(p2));
	}
	
	@Test
	public void test4() {
		u1.comprar(p3);
		assertFalse(u1.puedeComprar(p4));
	}
	

}
