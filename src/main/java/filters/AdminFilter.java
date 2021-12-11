package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import model.Usuario;

//en el login filter lo hicieron al user como string en vez
//de pasar el objeto completo, aca necesitamos el objeto
//para poder preguntar si es admin (tambien hay que crear el metodo)
@WebFilter("*.adm")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario user = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("user");
		if (user != null && user.esAdmin()) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("flash", "Por favor, ingresa al sistema con tu usuario y contraseña.");

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
