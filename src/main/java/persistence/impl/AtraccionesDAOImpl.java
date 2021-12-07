package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.*;
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
					TiposAtracciones.valueOf(result.getString(5)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}
	
	public void instanciadorDeAtracciones() {
		try {
			String query = "SELECT * FROM ATRACCIONES";
			Connection conn = TierraMediaConnectionProvider.getConnection();

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
	public int update(Vendible atraccion) {
		try {
			String query = "UPDATE ATRACCIONES SET CUPO = ? WHERE NOMBRE = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, atraccion.getCupo());
			statement.setString(2, atraccion.getNombre());

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
