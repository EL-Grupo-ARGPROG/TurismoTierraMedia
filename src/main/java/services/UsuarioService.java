/*package services;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.Vendible;
import persistence.impl.UsuarioDAOImpl;

public class UsuarioService {

	public List<Usuario> list(){
		return UsuarioDAOImpl.findAll();
	}
	
	public void delete(Usuario user) {
		UsuarioDAOImpl.delete(user);
	}
	
	public Usuario update(Integer id, String name, String password, Double presupuesto, Double tiempo, TiposAtracciones preferencia, ArrayList<Vendible> itinerario) {
		
		Usuario user = new Usuario(id, name, password, presupuesto, preferencia, itinerario);
		if(user.isValid()) {
			UsuarioDAOImpl.update(user);
		}
		return user;
	}
	
	public Usuario find(Integer id) {
		return UsuarioDAOImpl.find(id);
	}
	
	public Usuario create(Integer id, String name, String password, Double presupuesto, Double tiempo, TiposAtracciones preferencia, ArrayList<Vendible> itinerario) {
		Usuario user = new Usuario(id, name, password, presupuesto, preferencia, itinerario);
		if(user.isValid()) {
			UsuarioDAOImpl.insert(user);
		}
		return user;
	}
}
*/