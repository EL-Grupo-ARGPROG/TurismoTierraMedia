package tierraMedia;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Vendible> vendibles = new ArrayList<Vendible>();
	static ArrayList<Atracciones> atracciones = new ArrayList<Atracciones>();

	public static List<Vendible> getVendibles() {
		return vendibles;
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void leerArchivoUsuario(String nombreArchivo) {
		File f = new File(nombreArchivo);
		Scanner sc = null;
		String[] line;

		try {
			sc = new Scanner(f);

			while (sc.hasNextLine()) {
				line = sc.nextLine().split(";");

				String nombre = line[0];
				double presupuesto = Double.parseDouble(line[1]);
				double tiempo = Double.parseDouble(line[2]);
				TiposAtracciones preferencia = TiposAtracciones.valueOf(line[3]);

				Usuario usuario = new Usuario(nombre, presupuesto, tiempo, preferencia);
				usuarios.add(usuario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
	}

	public static void leerArchivoAtracciones(String nombreArchivo) {
		File f = new File(nombreArchivo);
		Scanner sc = null;
		String[] line;

		try {
			sc = new Scanner(f);

			while (sc.hasNextLine()) {
				line = sc.nextLine().split(";");

				String nombre = line[0];
				double costo = Double.parseDouble(line[1]);
				double tiempo = Double.parseDouble(line[2]);
				int cupo = Integer.parseInt(line[3]);
				TiposAtracciones tipo = TiposAtracciones.valueOf(line[4]);
				Atracciones atraccion = new Atracciones(nombre, costo, tiempo, cupo, tipo);

				vendibles.add(atraccion);
				atracciones.add(atraccion);
			}

		} catch (IOException e) {
			// Si hay algun problema en la lectura se muestra la traza de la pila
			// es decir donde ocurrio el error.
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
			// Se cierra el archivo más allá de que haya ocurrido o no un error
		}
	}

	public static void leerArchivoPromociones(String nombreArchivo) {
		File f = new File(nombreArchivo);
		Scanner sc = null;
		String[] line;

		try {
			sc = new Scanner(f);

			while (sc.hasNextLine()) {
				line = sc.nextLine().split(";");
				String nombre = line[1];
				TiposAtracciones tipo = TiposAtracciones.valueOf(line[3]);

				switch (line[0]) {
				case "Absoluta":
					Atracciones[] packAbsoluta = new Atracciones[Integer.parseInt(line[4])];
					int preciofinal = Integer.parseInt(line[2]);

					for (int i = 5; i < 5 + (packAbsoluta.length); i++) {
						for (Atracciones atraccion : atracciones) {
							if (atraccion.getNombre().equals(line[i])) {
								packAbsoluta[i - 5] = atraccion;
							}
						}
					}

					Promociones promoAbsoluta = new Absoluta(packAbsoluta, nombre, preciofinal, tipo);
					vendibles.add(promoAbsoluta);

					break;

				case "AxB":
					Atracciones[] packAxB = new Atracciones[Integer.parseInt(line[4])];

					for (int i = 5; i < 5 + (packAxB.length); i++) {
						for (Atracciones atraccion : atracciones) {
							if (atraccion.getNombre().equals(line[i])) {
								packAxB[i - 5] = atraccion;
							}
						}
					}

					Atracciones atraccionGratis = null;
					for (Atracciones atraccion : atracciones) {
						if (atraccion.getNombre().equals(line[2])) {
							atraccionGratis = atraccion;
						}
					}
					Promociones promoAxB = new AxB(packAxB, nombre, atraccionGratis, tipo);
					vendibles.add(promoAxB);

					break;

				case "Porcentual":
					Atracciones[] packPorcentual = new Atracciones[Integer.parseInt(line[4])];
					int porcentaje = Integer.parseInt(line[2]);

					for (int i = 5; i < 5 + (packPorcentual.length); i++) {
						for (Atracciones atraccion : atracciones) {
							if (atraccion.getNombre().equals(line[i])) {
								packPorcentual[i - 5] = atraccion;
							}
						}
					}
					Promociones promoPorcentual = new Porcentual(packPorcentual, nombre, porcentaje, tipo);
					vendibles.add(promoPorcentual);

					break;

				}

			}

		} catch (IOException e) {
			// Si hay algun problema en la lectura se muestra la traza de la pila
			// es decir donde ocurrio el error.
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
			// Se cierra el archivo más allá de que haya ocurrido o no un error
		}
	}

	public static void escribirItinerario(Usuario usuario) throws IOException {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(
					new FileWriter("data/ItinerarioDeUsuarios/" + usuario.getNombre() + ".txt"));

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
