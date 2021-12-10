package services;
import java.util.List;

import model.Atracciones;
import model.TiposAtracciones;
import persistence.impl.AtraccionesDAOImpl;

public class AtraccionService {
	AtraccionesDAOImpl atraccionDao = new AtraccionesDAOImpl();
	
    public List<Atracciones> list(){
			return atraccionDao.findAll();
	}
	
	public void delete(Atracciones atraccion) {
		atraccionDao.delete(atraccion);
	}
	
	public Atracciones update (String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo)  {
		Atracciones atraccion = new Atracciones (nombre, costo, tiempoNecesario, cupo, tipo);
		if(atraccion.isValid()) {
			atraccionDao.update(atraccion);
		}
		return atraccion;
	}
	
	public Atracciones find(Integer id) {
		return atraccionDao.findByID(id);
	}
	
	public Atracciones create(String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo) {
		Atracciones atraccion = new Atracciones (nombre, costo, tiempoNecesario, cupo, tipo);
		if(atraccion.isValid()) {
			atraccionDao.insert(atraccion);
		}
		return atraccion;
	}
}