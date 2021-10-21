package DAO;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionesDAO getAtraccionesDAO() {
		return new AtraccionesDAOImpl();
	}
	
//	public static PorcentualDAO getGeneroDAO() {
//		return new PorcentualDAOImpl();
//	}
//	
//	public static AbsolutaDAO getGeneroDAO() {
//		return new AbsolutaDAOImpl();
//	}
//	
//	public static AxBDAO getGeneroDAO() {
//		return new AxBDAOImpl();
//	}
}
