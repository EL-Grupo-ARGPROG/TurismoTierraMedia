package tierraMedia;

import java.io.*;

public class LeerArchivos {
	private FileReader fr = null;
	private BufferedReader br = null; //lector
	private String[] usuario = new String[4]; //Preferencias del usuario leidas
	
	public void leerArchivoUsuario(String nombreArchivo) {
		/*
		 * Este método se encarga de abrir el archivo y leer cada una de 
		 * sus líneas con br, con esto el sistema obtiene las preferencias
		 * de cada usuario.
		 */
		
		try {
			//Se abre el archivo
			fr = new FileReader (nombreArchivo); //ingreso el nombre del archivo
			br = new BufferedReader(br);
			
			String linea = br.readLine();
			while (linea != null) {
				//Hago algo con la línea leida
				usuario = linea.split("; "); //Lee hasta encontrar un "; " y 
											//guarda el contenido en el array
				linea = br.readLine(); //Vuelvo a leer
			}
		}
		catch(IOException e) { 
			//Si hay algun problema en la lectura se muestra la traza de la pila
			//es decir donde ocurrio el error.
			e.printStackTrace();	
		}
		finally { //Se cierra el archivo más allá de que haya ocurrido o no un error
			try {
				if (fr != null)
					fr.close();
			}
			catch (Exception excep){
				excep.printStackTrace();
			}
		}
	}
	

}
