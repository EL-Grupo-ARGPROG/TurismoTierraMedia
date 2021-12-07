package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vendible;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.PromocionesDAOImpl;


//@WebServlet("/filtrar")
//public class BuscadorIndexServlet extends HttpServlet implements Servlet {
//	private static final long serialVersionUID = 1L;
//	List<Vendible> vendiblesFiltrados;
//
//	
//	
//	@Override
//	public void init() throws ServletException{
//		AtraccionesDAOImpl atraccionDAO = new AtraccionesDAOImpl();
//		PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();
//		
//		atraccionDAO.instanciadorDeAtracciones();
//		promocionDAO.instanciadorDePromociones();
//		
//		vendiblesFiltrados = PromocionesDAOImpl.vendiblesList;
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
//		dispatcher.forward(req, resp);
//	}
//}
