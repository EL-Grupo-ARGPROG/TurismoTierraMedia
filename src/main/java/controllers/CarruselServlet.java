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
import model.Sistema;
import model.Usuario;
import model.productos.Promociones;
import model.productos.Vendible;
import persistence.impl.PromocionesDAOImpl;
import services.CarruselService;

@WebServlet("/carrusel")
public class CarruselServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -1980302624620822273L;
	private CarruselService carruselService;

	@Override
	public void init() throws ServletException {
		super.init();
		carruselService = new CarruselService();
		Sistema.instanciaDeObjetos();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");

		if (user == null) {
			
			List<Promociones> lista = PromocionesDAOImpl.promocionesList;
			
		   req.getSession().setAttribute("lista", lista);
		   
		   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		   

		}

		else {
			List<Vendible> lista = carruselService.getVendibles(user);

			req.getSession().setAttribute("lista", lista);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);

		}
	}
}
