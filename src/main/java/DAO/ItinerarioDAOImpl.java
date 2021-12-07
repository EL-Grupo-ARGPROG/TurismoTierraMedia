package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import JDBC.TierraMediaConnectionProvider;
import model.*;


public class ItinerarioDAOImpl implements GenericDAO<Itinerario> {
	public static List<Itinerario> itinerarioList = new LinkedList<Itinerario>();
	
	private Vendible objectFinder(String nombre) {
		for(Vendible unidad : PromocionesDAOImpl.vendiblesList) {
			if(unidad.getNombre().equals(nombre)) {
				return unidad;
			}
		}
		return null;
	}
	
	private Itinerario toItinerario(ResultSet result) {
		try {
			return new Itinerario( result.getInt(2), this.objectFinder(result.getString(3)), this.objectFinder(result.getString(4)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Itinerario> findAll() {
		try {
			String query = "SELECT * FROM ITINERARIO";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				itinerarioList.add(toItinerario(results));
			}
			return itinerarioList;
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Itinerario t) {
		try {
			String query = "INSERT INTO ITINERARIO(ID_USUARIO, ATRACCION, PROMOCION)"
					+ "VALUES(?, ?, ?)";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getId_usuario());
			
			if(t.getAtraccion() == null) {
				statement.setString(2, null);
				statement.setString(3, t.getPromocion().getNombre());
			} else {
				statement.setString(2, t.getAtraccion().getNombre());
				statement.setString(3, null);
			}

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Itinerario t) {
		try {
			String query = "DELETE FROM ITINERARIO WHERE ID = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getId());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

}
