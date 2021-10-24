package DAO;

import tierraMedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public int update(Usuario t);
}
