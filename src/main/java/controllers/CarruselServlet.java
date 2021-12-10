package controllers;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Vendible;
import services.CarruselService;

@WebServlet("/index")
public class CarruselServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -1980302624620822273L;
	private CarruselServlet carruselService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		carruselService = new CarruselServlet();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		if (!user.isNull()) {
			List<Vendible> lista = CarruselService.getVendibles(user); //llamo al service y paso usuario
			req.getSession().setAttribute("lista", lista); //seteo lista como atributo
		}
		
		RequestDispatcher dispatcher = getServletContext()
    		      .getRequestDispatcher("/index.jsp");
    		    dispatcher.forward(req, resp);
		/*	llamar al service y pasar user
		 * 	setear la lista como atributo de la pag
		 * 	dispatch forward hacia index.jsp
		 */
	}
}
