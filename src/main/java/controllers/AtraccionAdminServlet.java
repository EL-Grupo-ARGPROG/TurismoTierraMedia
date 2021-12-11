package controllers;

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
import model.Vendible;
import persistence.impl.AtraccionesDAOImpl;
@WebServlet("/atraccion-admin")
public class AtraccionAdminServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 6386557501870415113L;
	List<Vendible> vendiblesFiltrados = new LinkedList<Vendible>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String tipo = req.getParameter("tipo");
			vendiblesFiltrados.clear();
			Sistema.instanciaDeObjetos();
			
			for (Vendible vendible : AtraccionesDAOImpl.atraccionesList) {
				if ((vendible.getTipo().name().equals(tipo))) {

					vendiblesFiltrados.add(vendible);
				}
			}

			req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atraccion-admin.jsp");
			dispatcher.forward(req, resp);
		}

	}