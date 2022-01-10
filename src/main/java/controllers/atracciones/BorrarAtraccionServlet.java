package controllers.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.productos.Atracciones;
import services.AtraccionService;


@WebServlet("/borrar.adm")
public class BorrarAtraccionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 847792739711189162L;
    AtraccionService atraccionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		atraccionService.delete(name, 0);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("admin.jsp");
		dispatcher.forward(req, resp);
		
	}
}

