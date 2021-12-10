/*package services;
import java.util.List;

import model.Atracciones;
import model.TiposAtracciones;
import persistence.impl.AtraccionesDAOImpl;

public class AtraccionService {
	
    // HAY UN PROBLEMA CON QUE ATRACCIONESDAOIMP USE METODOS ESTATICOS
    public List<Atracciones> list(){
		return AtraccionesDAOImpl.findAll();
	}
	
	public void delete(Atracciones atraccion) {
		AtraccionesDAOImpl.delete(atraccion);
	}
	
	public Atracciones update (String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo)  {
		Atracciones atraccion = new Atracciones (nombre, costo, tiempoNecesario, cupo, tipo);
		if(atraccion.isValid()) {
			AtraccionesDAOImpl.update(atraccion);
		}
		return atraccion;
	}
	
	public Atracciones find(Integer id) {
		return AtraccionesDAOImpl.find(id);
	}
	
	public Atracciones create(String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo) {
		Atracciones atraccion = new Atracciones (nombre, costo, tiempoNecesario, cupo, tipo);
		if(atraccion.isValid()) {
			AtraccionesDAOImpl.insert(atraccion);
		}
		return atraccion;
	}
}

}
*/