package controllers;

import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Vendible;
import services.AtraccionService;
import services.ComprarVendibleService;
import services.PromocionService;


@WebServlet("/comprar")
public class ComprarVendibleServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -6677999252619657687L;
	ComprarVendibleService comprarVendibleService;
	AtraccionService atraccionService;
	PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		comprarVendibleService = new ComprarVendibleService();
		atraccionService = new AtraccionService();
		promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		String vendibleName = req.getParameter("vendibleName");
		String esPromo = req.getParameter("esPromo");
		Vendible vendible = null;
		
		if(esPromo.equals("true")) {
			vendible = promocionService.find(vendibleName);
		} else {
			vendible = atraccionService.find(vendibleName);
		}

		if (new ComprarVendibleService().comprar(vendible, user)) {

			req.setAttribute("flash", "¡La compra se realizo exitosamente!");
		} else {

			req.setAttribute("flash", "La compra fallo");
		}
		
		getServletContext().getRequestDispatcher("/listado.do").forward(req, resp);
	}
}
