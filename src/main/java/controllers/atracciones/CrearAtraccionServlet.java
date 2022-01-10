package controllers.atracciones;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/createForm.adm")
public class CrearAtraccionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 9079190486756258068L;
	AtraccionService atraccionService;
	Atracciones atraccion;

	@Override
	public void init() throws ServletException {
		super.init();
		atraccionService = new AtraccionService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempoNecesario = Double.parseDouble(req.getParameter("tiempoNecesario"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipo");


		Atracciones atraccion = atraccionService.create(nombre, costo, tiempoNecesario, cupo,
				TiposAtracciones.valueOf(tipo), 1);

		if (atraccion.isValid()) {
			resp.sendRedirect("/TierraMedia/atraccion-admin.jsp");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TierraMedia/atraccion-admin.jsp");
			dispatcher.forward(req, resp);
		}
	}


}