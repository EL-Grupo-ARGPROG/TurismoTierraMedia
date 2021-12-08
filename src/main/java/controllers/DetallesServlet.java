package controllers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import persistence.impl.PromocionesDAOImpl;


@WebServlet("/filter")
public class DetallesServlet extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 6386557501870415113L;
	List<Vendible> vendiblesFiltrados;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Sistema.instanciaDeObjetos();
		String[] rangoPrecio = req.getParameter("precio").split(" - ");
		int valor1 = Integer.parseInt(String.valueOf(rangoPrecio[0]));
		int valor2 = Integer.parseInt(String.valueOf(rangoPrecio[1]));

		String[] rangoDuracion = req.getParameter("duracion").split(" - ");
		int hora1 = Integer.parseInt(String.valueOf(rangoDuracion[0]));
		int hora2 = Integer.parseInt(String.valueOf(rangoDuracion[1]));
		
		String tipo = req.getParameter("tipo");
		


		for (Vendible vendible : PromocionesDAOImpl.vendiblesList) {
			if (vendible.getTipo().toString() == tipo) {
				if (vendible.getCosto() >= valor1 && vendible.getCosto() <= valor2) {
					if (vendible.getTiempoNecesario() >= hora1 && vendible.getTiempoNecesario() <= hora2) {
						vendiblesFiltrados.add(vendible);
					}
				}
			}
		}
		req.setAttribute("vendiblesList", PromocionesDAOImpl.vendiblesList);
		req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}
}
