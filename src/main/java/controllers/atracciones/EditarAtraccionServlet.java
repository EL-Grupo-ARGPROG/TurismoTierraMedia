package controllers.atracciones;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.productos.Atracciones;
import model.productos.TiposAtracciones;
import services.AtraccionService;

@WebServlet("/edit.adm")
public class EditarAtraccionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -3164273460934231688L;
	AtraccionService atraccionService = new AtraccionService();

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		req.setAttribute("atraccion", atraccionService.find(name));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atraccion-admin.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempoNecesario = Double.parseDouble(req.getParameter("tiempoNecesario"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipo");

		Atracciones atraccion = atraccionService.update(nombre, costo, tiempoNecesario, cupo,
				TiposAtracciones.valueOf(tipo), 1);
		if (atraccion.isValid()) {
			resp.sendRedirect("admin.jsp");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atraccion-admin.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
