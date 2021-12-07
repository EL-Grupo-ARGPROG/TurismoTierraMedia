package model;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EscritorDeRecibos {

	public static void escribirRecibos(Usuario usuario) throws IOException {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(
					new FileWriter("data/Recibos/" + "Recibo de " + usuario.getNombre() + ".txt"));

			salida.println("GAMGEE TOURISM AGENCY\n");
			salida.println("Cliente: " + usuario.getNombre());
			salida.println("Preferencias: " + usuario.getPreferencia() + "\n");
			salida.println("ITINERARIO:");
			salida.println(usuario.mostrarItinerario());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			salida.close();
		}
		
	}
 }
