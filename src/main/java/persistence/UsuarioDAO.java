package persistence;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract int update(Usuario t);
	
	public abstract Usuario findByUsername(String username);
	

}
