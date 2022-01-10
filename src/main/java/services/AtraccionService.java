package services;

import java.sql.SQLException;
import java.util.List;

import model.productos.Atracciones;
import model.productos.TiposAtracciones;
import model.productos.Vendible;
import persistence.commons.MissingDataException;
import persistence.impl.AtraccionesDAOImpl;

public class AtraccionService {
	AtraccionesDAOImpl atraccionDao = new AtraccionesDAOImpl();

	public List<Atracciones> list() {
		return atraccionDao.findAll();
	}

	public void delete(String name, int valid) {
		atraccionDao.updateValid(name, valid);
	}

	public Atracciones update(String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo,
			int valido) {
		Atracciones atraccion = new Atracciones(nombre, costo, tiempoNecesario, cupo, tipo, valido);
		if (atraccion.isValid()) {
			atraccionDao.update(atraccion);
		}
		return atraccion;
	}

	public void update(Vendible v) {
		atraccionDao.update(v);
	}

	public Atracciones find(String name) {
		return atraccionDao.findByName(name);
	}

	public Atracciones create(String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo, int valido) {
		Atracciones atraccion = new Atracciones (nombre, costo, tiempoNecesario, cupo, tipo, valido);
		if(atraccion.isValid()) {
			atraccionDao.insert(atraccion);
		}
		return atraccion;
	}

}