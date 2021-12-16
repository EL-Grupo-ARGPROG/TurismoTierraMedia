package persistence;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract int update(Usuario t);
	
	public abstract Usuario findByUsername(String username);
	

}
