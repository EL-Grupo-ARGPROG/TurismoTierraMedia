package servlets;

import java.io.IOException;
import java.util.ArrayList;

import DAO.PromocionesDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tierraMedia.*;


@webservice(("/lista"))
public class BuscadorIndexServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	List<Vendibles> vendiblesFiltrados;
}
	
	
	@Override
	protected void init() throws ServletException{
		AtraccionesDAOImpl atraccionDAO = new AtraccionesDAOImpl();
		PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();
		
		atraccionDAO.instanciadorDeAtracciones();
		promocionDAO.instanciadorDePromociones();
		
		vendiblesFiltrados = PromocionesDAOImpl.vendiblesList;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}
}
