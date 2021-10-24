package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import JDBC.TierraMediaConnectionProvider;
import tierraMedia.Atracciones;
import tierraMedia.TiposAtracciones;

public class AtraccionesDAOImpl implements AtraccionesDAO {
	static List<Atracciones> atraccionesList = new LinkedList<Atracciones>();

	private Atracciones toAtraccion(ResultSet result) {
		// (String nombre, double costo, double tiempoNecesario, int cupo,
		// TiposAtracciones tipo)
		try {
			return new Atracciones(result.getString(1), result.getDouble(2), result.getDouble(3), result.getInt(4),
					TiposAtracciones.valueOf(result.getString(5)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Atracciones> findAll() {
		try {
			String query = "SELECT * FROM ATRACCIONES";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				atraccionesList.add(toAtraccion(results));
			}
			return atraccionesList;

		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atracciones t) {
		try {
			String query = "INSERT INTO ATRACCION(NOMBRE, COSTO, TIEMPO_NECESARIO, CUPO, TIPO_TEMATICA)"
					+ "VALUES(?, ?, ?, ?, ?)";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setDouble(2, t.getCosto());
			statement.setDouble(3, t.getTiempoNecesario());
			statement.setDouble(4, t.getCupo());
			statement.setString(5, String.valueOf(t.getTipo()));

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Atracciones t) {
		try {
			String query = "UPDATE USUARIOS SET CUPO = ? WHERE NOMBRE = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, t.getCupo());
			statement.setString(2, t.getNombre());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atracciones t) {
		try {
			String query = "DELETE FROM ATRACCIONES WHERE NOMBRE = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}
}
