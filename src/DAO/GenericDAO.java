package DAO;

import java.util.List;

import tierraMedia.Promociones;

public interface GenericDAO<T> {

	public List<T> findAll(); // SELECT * FROM <T>
	
	int insert(T t);

	public int delete(T t);

}
