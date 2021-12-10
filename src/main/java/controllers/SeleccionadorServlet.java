package controllers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

@WebServlet("/seleccionar")
public class SeleccionadorServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 6386557501870415113L;
	List<Vendible> vendiblesFiltrados = new LinkedList<Vendible>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Sistema.instanciaDeObjetos();
		vendiblesFiltrados.clear();
		
		if(req.getParameter("todos").equals("TODOS")){
			
			vendiblesFiltrados = Sistema.ordenadorDeVendibles(TiposAtracciones.valueOf("AVENTURA"));
			
			req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
			dispatcher.forward(req, resp);
			
		} else if (req.getParameter("precio").equals("Rango de Precio") || req.getParameter("tipo").equals("Tipo de Paquete")
				|| req.getParameter("duracion").equals("Duracion Hs")) {
			req.setAttribute("flash", "Seleccionar un opcion de cada casilla");

			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

		} else {

			String[] rangoPrecio = req.getParameter("precio").split(" - ");
			String stringV = String.valueOf(rangoPrecio[0]);
			String stringV1 = String.valueOf(rangoPrecio[1]);

			int valor1 = Integer.parseInt(stringV);
			int valor2 = Integer.parseInt(stringV1);

			String[] rangoDuracion = req.getParameter("duracion").split(" - ");
			String string1 = String.valueOf(rangoDuracion[0]);
			String string2 = String.valueOf(rangoDuracion[1]);

			int hora1 = Integer.parseInt(string1);
			int hora2 = Integer.parseInt(string2);

			String tipo = req.getParameter("tipo");
			
			List<Vendible> lista = Sistema.ordenadorDeVendibles(TiposAtracciones.valueOf(tipo));
			
			for (Vendible vendible : lista) {
				if ((vendible.getTipo().name().equals(tipo)) && (vendible.getTiempoNecesario() >= hora1)
						&& (vendible.getTiempoNecesario() <= hora2) && (vendible.getCosto() >= valor1)
						&& (vendible.getCosto() <= valor2) && (!vendiblesFiltrados.contains(vendible))) {

					vendiblesFiltrados.add(vendible);

				}

			}

			req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
			dispatcher.forward(req, resp);

		}
	}

}
