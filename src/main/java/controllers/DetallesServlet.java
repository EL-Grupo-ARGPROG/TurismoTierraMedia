package controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.productos.Vendible;
import services.AtraccionService;


@WebServlet("/detalles.do")
public class DetallesServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -687991492884005033L;
	AtraccionService atraccionService;
	

	@Override
	public void init() throws ServletException {
		super.init();
		AtraccionService atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String vendibleName = req.getParameter("vendible");

		Vendible vendible = atraccionService.find(vendibleName);

		req.setAttribute("vendible", vendible);
		
		if(vendible.esPromocion()) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/detalles-Promocion.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/detalles-Atraccion.jsp");
			dispatcher.forward(req, resp);
		}
	}
}