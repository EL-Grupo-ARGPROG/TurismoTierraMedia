package persistence;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract int update(Usuario t);
	

}
