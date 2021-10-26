package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import JDBC.TierraMediaConnectionProvider;
import tierraMedia.TiposAtracciones;
import tierraMedia.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	public static List<Usuario> usuariosList = new LinkedList<Usuario>();

	private Usuario toUsuario(ResultSet result) {
		// constructor: (String nombre, double presupuesto, double tiempoDisponible,
		// TiposAtracciones preferencia)
		try {
			return new Usuario(result.getInt(1), result.getString(2), result.getDouble(3), result.getDouble(4),
					TiposAtracciones.valueOf(result.getString(5)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}
	
	public void instanciadorDeUsuarios() {
		try {
			String query = "SELECT * FROM USUARIOS";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				usuariosList.add(toUsuario(results));
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
			String query = "INSERT INTO USUARIO(ID, NOMBRE, PRESUPUESTO, TIEMPO_DISPONIBLE, TIPO_PREFERENCIA)" + "VALUES(?, ?, ?, ?, ?)";
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
		try {
			String query = "UPDATE USUARIOS SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);

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
