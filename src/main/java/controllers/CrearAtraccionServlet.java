/*package controllers;

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
import model.Sistema;
import model.TiposAtracciones;
import model.Vendible;
import persistence.impl.PromocionesDAOImpl;

//NO SE SI ESTAN BIEN LAS REDIRECCIONES

@WebServlet("/atraccion/crear.adm")
public class CrearAtraccionServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 9079190486756258068L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext()
			.getRequestDispatcher("/views/productos/create.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempoNecesario = Double.parseDouble(req.getParameter("tiempoNecesario"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipo"); 
		
		Atraccion atraccion = atraccionService.crear(nombre, costo, tiempoNecesario, cupo, tipo)
		
       	if(atraccion.isValid()) {
			resp.sendRedirect("listado.do");
		} else {
			// MANEJAR PRODUCTO INVALIDO
			//req.setAttribute("errors", prod.validate());
			//req.setAttribute("producto", prod);

			getServletContext()
				.getRequestDispatcher("/listado.jsp")
				.forward(req, resp);			
		}
	}
}
	

}

*/