package controllers.usuarios;
/*package controller.usuarios;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TiposAtracciones;
import model.Usuario;
import model.Vendible;
import service.UsuarioService;

//revisar rutas
@WebServlet("/usuario/create.adm")
public class CrearUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 4515280119322089896L;
	UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext()
			.getRequestDispatcher("/views/usuarios/create.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		String preferencia = req.getParameter("tipo");
		itinerario ArrayList<Vendible>;
		
			
		Usuario user = usuarioService.create(id, username, password, presupuesto, tiempo, preferencia, itinerario);
		
		if(user.isValid()) {
			resp.sendRedirect("list.adm");
		} else {
			req.setAttribute("errors", user.validate());
			req.setAttribute("userInstance", user);

			getServletContext()
				.getRequestDispatcher("/views/usuarios/create.jsp")
				.forward(req, resp);			
		}
	}
}
*/