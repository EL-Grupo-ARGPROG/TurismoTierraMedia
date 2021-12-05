package servlets;

import java.io.IOException;
import java.util.ArrayList;

import DAO.PromocionesDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tierraMedia.Vendible;

@WebServlet("/filter")
public class DetallesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String objeto = req.getParameter("")

		String[] rangoPrecio = precio.split(" - ");
		int valor1 = Integer.parseInt(String.valueOf(rangoPrecio[0]));
		int valor2 = Integer.parseInt(String.valueOf(rangoPrecio[1]));

		String[] rangoDuracion = duracion.split(" - ");
		int hora1 = Integer.parseInt(String.valueOf(rangoDuracion[0]));
		int hora2 = Integer.parseInt(String.valueOf(rangoDuracion[1]));

		ArrayList vendiblesFiltrados = new ArrayList();

		PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();

		for (Vendible vendible : promocionDAO.vendiblesList) {
			if (vendible.getTipo().name() == tipo) {
				if (vendible.getCosto() >= valor1 && vendible.getCosto() <= valor2) {
					if (vendible.getTiempoNecesario() >= hora1 && vendible.getTiempoNecesario() <= hora2) {
						vendiblesFiltrados.add(vendible);
					}
				}
			}
		}
		req.setAttribute("vendiblesFiltrados", vendiblesFiltrados);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);
	}
}
