
//package controllers;
//
//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.List;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.Servlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.Sistema;
//import model.TiposAtracciones;
//import model.Vendible;
//import persistence.impl.PromocionesDAOImpl;
//
////NO SE SI ESTAN BIEN LAS REDIRECCIONES
//
//@WebServlet("/atraccion/borrar.adm")
//public class BorrarAtraccionServlet extends HttpServlet implements Servlet {
//
//	private static final long serialVersionUID = 847792739711189162L;
//	
//    AtraccionService atraccionService;
//	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		atraccionService = new AtraccionService();
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		atraccionService.delete(id);
//		resp.sendRedirect("/listado.jsp");
//	}
//}
//	
//	
//
//}

