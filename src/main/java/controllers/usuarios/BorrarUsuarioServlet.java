package controllers.usuarios;
//package controllers.usuarios;
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.Servlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.Usuario;
//import services.*;
//
//
//@WebServlet("/usuario/borrar.adm")
//public class BorrarUsuarioServlet extends HttpServlet implements Servlet {
//
//	private static final long serialVersionUID = 2293373831749064197L;
//	
//    UsuarioService usuarioService;
//	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		usuarioService = new UsuarioService();
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		usuarioService.delete(id);
//		resp.sendRedirect("/webapp/usuario/list.adm");
//	}
//}
//	
//	
//	
//}
