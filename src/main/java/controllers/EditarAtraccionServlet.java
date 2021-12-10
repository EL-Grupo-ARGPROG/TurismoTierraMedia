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
//import services.AtraccionService;
//
//public class EditarAtraccionServlet extends HttpServlet implements Servlet {
//	private static final long serialVersionUID = -3164273460934231688L;
//	AtraccionService atraccionService = new AtraccionService();
//	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
//
//		req.setAttribute("atraccion", atraccionService.find(id));
//
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("listado.jsp");
//		dispatcher.forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getParameter("name");
//		Double price = Double.parseDouble(req.getParameter("price"));
//		Integer stock = Integer.parseInt(req.getParameter("stock"));
//		
//		
//		Atracciones atraccion = atraccionService.update(name, price, stock);
//		if(prod.isValid()) {
//			resp.sendRedirect("list.do");
//		} else {
//			// MANEJAR ERRORES
//			//req.setAttribute("errors", atraccion.validate());
//			//req.setAttribute("producto", atraccion);
//
//			getServletContext()
//					.getRequestDispatcher("/views/atraccion/edit.jsp")
//					.forward(req, resp);			
//		}
//	}
//}
