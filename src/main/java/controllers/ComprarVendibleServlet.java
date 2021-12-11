/*package controllers;

import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;
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

//REVISAR RUTEADO
@WebServlet("/vendible/comprar.do")
public class ComprarVendibleServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -6677999252619657687L;
	
		ComprarVendibleService comprarVendibleService;
		AtraccionService atraccionService;
		PromocionService promocionService;

		@Override
		public void init() throws ServletException {
			super.init();
			comprarVendibleService = new ComprarVendibleService ();
			atraccionService = new AtraccionService();
			promocionService = new PromocionService();
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Usuario user = (Usuario) req.getSession().getAttribute("user");
			Integer vendibleId = Integer.parseInt(req.getParameter("id"));
			
			// LOGICA DE SI EL VENDIBLE ES PROMO O NO USE EL SERVICE QUE LE CORRESPONDA.
			
			Vendible vendible = vendibleService.find(vendibleId);
			
			if(ComprarVendibleService.comprar(user, vendible)) {
				
				req.setAttribute("flash", "¡La compra se realizo exitosamente!");
			} else {
				
				req.setAttribute("flash", "La compra fallo");
			}
			
			getServletContext()
				.getRequestDispatcher("/listado.do")
				.forward(req, resp);
		}
	}
	
	

}
*/

