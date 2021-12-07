package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import JDBC.TierraMediaConnectionProvider;
import model.*;


public class UsuarioDAOImpl implements UsuarioDAO {
	public static List<Usuario> usuariosList = new LinkedList<Usuario>();
	public static ArrayList<Vendible> itinerarioUsuario;

	private Usuario toUsuario(ResultSet result) {

		try {
			return new Usuario(result.getInt(1), result.getString(2), result.getDouble(3), result.getDouble(4),
					TiposAtracciones.valueOf(result.getString(5)), itinerarioUsuario);
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
		try {
			String query1 = "SELECT * FROM USUARIOS";
			String query2 = "SELECT * FROM ITINERARIO WHERE ID_USUARIO = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

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
		}
	}

	@Override
	public List<Usuario> findAll() {
		return usuariosList;
	}

	@Override
	public int insert(Usuario t) {
		try {
			String query = "INSERT INTO USUARIO(ID, NOMBRE, PRESUPUESTO, TIEMPO_DISPONIBLE, TIPO_PREFERENCIA)"
					+ "VALUES(?, ?, ?, ?, ?)";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getId());
			statement.setString(2, t.getNombre());
			statement.setDouble(3, t.getPresupuesto());
			statement.setDouble(4, t.getTiempoDisponible());
			statement.setString(5, String.valueOf(t.getPreferencia()));

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Usuario t) {
		Connection conn;
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
		}
	}

	@Override
	public int delete(Usuario t) {
		try {
			String query = "DELETE FROM USUARIO WHERE ID = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getId());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

}
