package services;


import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;
import persistence.impl.UsuarioDAOImpl;

public class LoginService {

	public Usuario login(String username, String password) {
		UsuarioDAO userDao = new UsuarioDAOImpl();
    	Usuario user = userDao.findByUsername(username);
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUser.build();
    	}
    	return user;
	}
	
}
