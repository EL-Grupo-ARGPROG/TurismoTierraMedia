package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.*;
import model.nullobjects.NullUser;
import model.productos.TiposAtracciones;
import model.productos.Vendible;
import persistence.UsuarioDAO;
import persistence.commons.MissingDataException;
import persistence.commons.TierraMediaConnectionProvider;


public class UsuarioDAOImpl implements UsuarioDAO {
	public static List<Usuario> usuariosList = new LinkedList<Usuario>();
	public static ArrayList<Vendible> itinerarioUsuario;

	private Usuario toUsuario(ResultSet result) {

		try {
			return new Usuario(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4), result.getDouble(5),
					TiposAtracciones.valueOf(result.getString(6)), itinerarioUsuario, Boolean.parseBoolean(result.getString(7)), result.getInt(8));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}
	
	public static ArrayList<Vendible> creadorDeArrayItinerario(ResultSet result) {
		try {
			for (Vendible vendible : PromocionesDAOImpl.vendiblesList) {
				if (result.getString(3) == vendible.getNombre()) {
					itinerarioUsuario.add(vendible);
				} else if (result.getString(4) == vendible.getNombre()) {
					itinerarioUsuario.add(vendible);
				}
			}
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
		return itinerarioUsuario;

	}

	public void instanciadorDeUsuarios() {
		Connection conn = null;

		try {
			String query1 = "SELECT * FROM USUARIOS";
			String query2 = "SELECT * FROM ITINERARIO WHERE ID_USUARIO = ?";
			conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement1 = conn.prepareStatement(query1);
			PreparedStatement statement2 = conn.prepareStatement(query2);
			ResultSet results1 = statement1.executeQuery();
			ResultSet results2 = statement2.executeQuery();
			
			
			while(results1.next()) {
				itinerarioUsuario = new ArrayList<Vendible>();
				statement2.setInt(1, results1.getInt(1));
				while (results2.next()) {
					creadorDeArrayItinerario(results2);
				}
				usuariosList.add(toUsuario(results1));
			}
			
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new MissingDataException(e2);
				}
			}
		}
	}

	@Override
	public List<Usuario> findAll() {
		return usuariosList;
	}

	@Override
	public int insert(Usuario t) {
		Connection conn = null;

		try {
			String query = "INSERT INTO USUARIO(ID, NOMBRE, PRESUPUESTO, TIEMPO_DISPONIBLE, TIPO_PREFERENCIA)"
					+ "VALUES(?, ?, ?, ?, ?)";
			conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getId());
			statement.setString(2, t.getNombre());
			statement.setDouble(3, t.getPresupuesto());
			statement.setDouble(4, t.getTiempoDisponible());
			statement.setString(5, String.valueOf(t.getPreferencia()));

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new MissingDataException(e2);
				}
			}
		}
	}

	@Override
	public int update(Usuario t) {
		Connection conn = null;
		try {
			String query = "UPDATE USUARIOS SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID = ?";
			conn = TierraMediaConnectionProvider.getConnection();

//			conn.setAutoCommit(false);

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, t.getPresupuesto());
			statement.setDouble(2, t.getTiempoDisponible());
			statement.setInt(3, t.getId());

			return statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new MissingDataException(e2);
				}
			}
		}
	}

	@Override
	public int delete(Usuario t) {
		Connection conn = null;

		try {
			String query = "DELETE FROM USUARIO WHERE ID = ?";
	        conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getId());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new MissingDataException(e2);
				}
			}
		}
	}
	
	public Usuario findByUsername(String username) {
		Connection conn = null;

		try {
			String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
			conn = TierraMediaConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					throw new MissingDataException(e2);
				}
			}
		}
	}

	@Override
	public int update(Vendible atraccion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
