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
import model.Usuario;
import model.Vendible;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.UsuarioDAOImpl;
@WebServlet("/usuario-admin")
public class UsuarioAdminServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 6386557501870415113L;
	List<Usuario> usuariosFiltrados = new LinkedList<Usuario>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			usuariosFiltrados.clear();
			
			Sistema.instanciaDeObjetos();
			boolean adm = Boolean.parseBoolean(req.getParameter("tipo"));
			
			req.getParameter("tipo");
			for (Usuario usuario : UsuarioDAOImpl.usuariosList) {
				if (adm == usuario.isAdmin()) {

					usuariosFiltrados.add(usuario);
				}
			}

			req.setAttribute("usuariosFiltrados", usuariosFiltrados);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/usuarios-admin.jsp");
			dispatcher.forward(req, resp);
		}

	}