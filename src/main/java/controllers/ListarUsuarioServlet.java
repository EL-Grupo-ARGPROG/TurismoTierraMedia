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

@WebServlet("/usuario/list.adm")
public class ListUsuarioServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -7384254254803876948L;
	UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("userList", usuarioService.list());
		getServletContext()
			.getRequestDispatcher("/views/usuarios/usuarios.jsp")
			.forward(req, resp);
	}
}
*/