package tierraMedia;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class LeerArchivos {
	static List<Usuario> usuario = new ArrayList<Usuario>();
	static List<Vendible> vendibles = new ArrayList<Vendible>();
	static List<Atracciones> atracciones = new ArrayList<Atracciones>();


	public static void leerArchivoUsuario() {
		File f = new File("data/usuarioIN.txt");
		Scanner sc = null;
		String[] line;
		
		/*
		 * Este método se encarga de abrir el archivo y leer cada una de 
		 * sus líneas con br, con esto el sistema obtiene las preferencias
		 * de cada usuario.
		 */
		
		try {
			sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				//Hago algo con la línea leida
				line = sc.nextLine().split(";"); //Lee hasta encontrar un "; " y 
											//guarda el contenido en el array
				
				usuario.add(
						new Usuario(
								line[0],
								Double.parseDouble(line[1]),
								Double.parseDouble(line[2]),
								TiposAtracciones.valueOf(line[3])
								)
						);
			}
		} catch(IOException e) { 
			//Si hay algun problema en la lectura se muestra la traza de la pila
			//es decir donde ocurrio el error.
			e.printStackTrace();	
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		finally { 
			sc.close();
			//Se cierra el archivo más allá de que haya ocurrido o no un error
		}
	}

	public static void leerArchivoAtracciones() {
		File f = new File("data/atraccionesIN.txt");
		Scanner sc = null;
		String[] line;
		
		try {
			sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				//Hago algo con la línea leida
				line = sc.nextLine().split(";"); //Lee hasta encontrar un "; " y 
											//guarda el contenido en el array
				
				vendibles.add(
						new Atracciones(
								line[0],
								Double.parseDouble(line[1]),
								Double.parseDouble(line[2]),
								Integer.parseInt(line[3]),
								TiposAtracciones.valueOf(line[4])
								)
						);
				atracciones.add(
						new Atracciones(
								line[0],
								Double.parseDouble(line[1]),
								Double.parseDouble(line[2]),
								Integer.parseInt(line[3]),
								TiposAtracciones.valueOf(line[4])
								)
						);
			}
		
		} catch(IOException e) { 
		//Si hay algun problema en la lectura se muestra la traza de la pila
		//es decir donde ocurrio el error.
		e.printStackTrace();	
		} catch (InputMismatchException e) {
		System.err.println(e.getMessage());
		}
		finally { 
			sc.close();
			//Se cierra el archivo más allá de que haya ocurrido o no un error
		}	
	}
	
	public static void leerArchivoPromociones(String nombreArchivo) {
		File f = new File("data/atraccionesIN.txt");
		Scanner sc;
		String[] line;
		
		try {
			sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				//Hago algo con la línea leida
				line = sc.nextLine().split(";"); //Lee hasta encontrar un "; " y 
											//guarda el contenido en el array
				
				switch(line[0]) {
				case "Absoluta":
					Atracciones[] pack = new Atracciones[Integer.parseInt(line[3])];
					
					for(int i = 4; i < 4 + (Integer.parseInt(line[3])); i++) {
						for(Atracciones atraccion : atracciones) {
							if(atraccion.getName() == line[i]) {
								pack[i - 4] = atraccion;
							}
						}
					}
					vendibles.add(
							new Absoluta(
									pack,
									line[1],
									Integer.parseInt(line[3]),
									TiposAtracciones.valueOf(line[4])
									)
							);
					break;
//				case "AxB":
//					Atracciones[] pack = new Atracciones[Integer.parseInt(line[3])];
//					
//					
//					
//					for(int i = 4; i < 4 + (Integer.parseInt(line[3])); i++) {
//						for(Atracciones atraccion : atracciones) {
//							if(atraccion.getName() == line[i]) {
//								pack[i - 4] = atraccion;
//							}
//						}
//					}
//					vendibles.add(
//							new AxB(
//									pack,
//									line[1],
//									
//									TiposAtracciones.valueOf(line[4])
//									)
//							);
//					break;
					
					// Atracciones[] pack, String nombre, int precioFinal, TiposAtracciones tipo
				}
				
			}
		
		} catch(IOException e) { 
		//Si hay algun problema en la lectura se muestra la traza de la pila
		//es decir donde ocurrio el error.
		e.printStackTrace();	
		} catch (InputMismatchException e) {
		System.err.println(e.getMessage());
		}
		finally { 
			sc.close();
			//Se cierra el archivo más allá de que haya ocurrido o no un error
		}	
	}

}
