package TierraMediaTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

import org.junit.Test;

import tierraMedia.AdministradorDeArchivos;

public class AdministradorDeArchivosTest {

	@Test (expected = Exception.class)
	public void leerUsuarioArchivoInvalido() { //Se intenta acceder a un archivo que no existe
		AdministradorDeArchivos.leerArchivoUsuario("data/entradaParaTest/usuariosTest.txt");
	}
	
	@Test (expected = NumberFormatException.class)
	public void leerUsuario() { //El archivo leido contiene valores inválidos
		AdministradorDeArchivos.leerArchivoUsuario("data/entradaParaTest/usuariosINTest.txt");
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void leerAtraccion() { //El archivo leido contiene valores inválidos
		AdministradorDeArchivos.leerArchivoAtracciones("data/entradaParaTest/atraccionesINTest.txt");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void leerPromocion() { //En archivo leido, el tipo de atraciones es incorrecto
		AdministradorDeArchivos.leerArchivoPromociones("data/entradaParaTest/promocionesINTest.txt");
	}
	
}
