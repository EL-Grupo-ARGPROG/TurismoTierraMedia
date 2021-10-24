package DAO;

import tierraMedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public int insert(Usuario t);
	
	public int update(Usuario t);
}
