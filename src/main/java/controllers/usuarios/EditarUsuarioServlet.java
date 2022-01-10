package controllers.usuarios;
/*import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Vendible;
import service.UsuarioService;

@WebServlet("/usuario/edit.adm")
public class EditarUsuarioServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 8320093636673388769L;
	UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		req.setAttribute("userInstance", usuarioService.find(id));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		String preferencia = req.getParameter("tipo");
		intinerario ArrayList<Vendible>;
		
		Usuario user = usuarioService.create(id, username, password, presupuesto, tiempo, preferencia, intinerario);
		if(user.isValid()) {
			resp.sendRedirect("list.adm");
		} else {
			req.setAttribute("errors", user.validate());
			req.setAttribute("userInstance", user);

			getServletContext()
					.getRequestDispatcher("/views/usuarios/edit.jsp")
					.forward(req, resp);			
		}
	}
}
*/