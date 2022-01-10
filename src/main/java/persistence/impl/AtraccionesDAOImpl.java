package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.productos.Atracciones;
import model.productos.TiposAtracciones;
import model.productos.Vendible;
import persistence.AtraccionesDAO;
import persistence.commons.MissingDataException;
import persistence.commons.TierraMediaConnectionProvider;

public class AtraccionesDAOImpl implements AtraccionesDAO {
	public static List<Atracciones> atraccionesList = new LinkedList<Atracciones>();

	public static Atracciones toAtraccion(ResultSet result) {
		// (String nombre, double costo, double tiempoNecesario, int cupo,
		// TiposAtracciones tipo)
		try {
			return new Atracciones(result.getString(1), result.getDouble(2), result.getDouble(3), result.getInt(4),
					TiposAtracciones.valueOf(result.getString(5)), result.getInt(6));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public void instanciadorDeAtracciones() {
		Connection conn;

		try {
			String query = "SELECT * FROM ATRACCIONES";
			conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				atraccionesList.add(toAtraccion(results));
			}
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Atracciones> findAll() {
		return atraccionesList;
	}

	public Atracciones findByName(String name) {
		Connection conn;

		try {
			String sql = "SELECT * FROM ATRACCIONES WHERE NOMBRE = ?";
			conn = TierraMediaConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);

			ResultSet resultados = statement.executeQuery();

			Atracciones atraccion = null;
			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atracciones t) {
		Connection conn;

		try {
			String query = "INSERT INTO ATRACCIONES(NOMBRE, COSTO, TIEMPO_NECESARIO, CUPO, TIPO_TEMATICA)"
					+ "VALUES(?, ?, ?, ?, ?)";
			conn = TierraMediaConnectionProvider.getConnection();

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

	public int updateValid(String name, int valid) {
		Connection conn;

		try {
			String query = "UPDATE ATRACCIONES SET VALIDO = ? WHERE NOMBRE = ?";
			conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, valid);
			statement.setString(2, name);

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atracciones t) {
		Connection conn;
		try {
			String query = "DELETE FROM ATRACCIONES WHERE NOMBRE = ?";
			conn = TierraMediaConnectionProvider.getConnection();


			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Vendible t){
		Connection conn;
		try {
			String query = "UPDATE ATRACCIONES SET CUPO = ?, COSTO = ?, TIPO_TEMATICA = ?, TIEMPO_NECESARIO = ? WHERE NOMBRE = ?";
			conn = TierraMediaConnectionProvider.getConnection();
			
		    conn.setAutoCommit(false);

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, t.getCupo());
			statement.setDouble(2, t.getCosto());
			statement.setString(3, t.getTipo().name());
			statement.setDouble(4, t.getTiempoNecesario());
			statement.setString(5, t.getNombre());
			
			
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		} 
	}

}
