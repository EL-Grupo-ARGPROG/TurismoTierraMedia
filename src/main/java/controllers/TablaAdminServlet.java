package controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sistema;
import persistence.impl.PromocionesDAOImpl;

@WebServlet("/lalala")
public class TablaAdminServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 6386557501870415113L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PromocionesDAOImpl.vendiblesList.clear();
			Sistema.instanciaDeObjetos();

			req.setAttribute("vendiblesList", PromocionesDAOImpl.vendiblesList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
			dispatcher.forward(req, resp);
		}
	}