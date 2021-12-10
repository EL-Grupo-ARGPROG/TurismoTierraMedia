package persistence.commons;

import java.util.List;

import model.Vendible;


public interface GenericDAO<T> {

	public List<T> findAll(); // SELECT * FROM <T>
	
	int insert(T t);

	public int delete(T t);

	int update(Vendible atraccion);

}
