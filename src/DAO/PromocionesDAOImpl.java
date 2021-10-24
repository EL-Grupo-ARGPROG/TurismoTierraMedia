package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import JDBC.TierraMediaConnectionProvider;
import tierraMedia.Absoluta;
import tierraMedia.Atracciones;
import tierraMedia.AxB;
import tierraMedia.Porcentual;
import tierraMedia.Promociones;
import tierraMedia.TiposAtracciones;
import tierraMedia.Usuario;
import tierraMedia.Vendible;

public class PromocionesDAOImpl implements PromocionesDAO {
	static List<Vendible> vendiblesList = setVendiblesList();
	
	private static List<Vendible> setVendiblesList() {
		for(Atracciones atraccion : AtraccionesDAOImpl.atraccionesList) {
			vendiblesList.add(atraccion);
		}
		return vendiblesList;
	}

	private Absoluta toAbsoluta(ResultSet result) {
		//(Atracciones[] pack, String nombre, int precioFinal, TiposAtracciones tipo)
		try {
			return new Absoluta(this.armarPaquete(result.getInt(2)), result.getString(1), result.getInt(5),
					TiposAtracciones.valueOf(result.getString(3)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	private AxB toAxB(ResultSet result) {
		//(Atracciones[] pack, String nombre, Atracciones atraccionGratis, TiposAtracciones tipo)
		try {
			return new AxB(this.armarPaquete(result.getInt(2)), result.getString(1), (Atracciones)result.getObject(7),
					TiposAtracciones.valueOf(result.getString(3)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}
	
	private Porcentual toPorcentual(ResultSet result) {
		//(Atracciones[] pack, String nombre, double porcentaje, TiposAtracciones tipo)
		try {
			return new Porcentual(this.armarPaquete(result.getInt(2)), result.getString(1), result.getDouble(6),
					TiposAtracciones.valueOf(result.getString(3)));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Atracciones[] armarPaquete(int id) {
		try {
			Connection conn = TierraMediaConnectionProvider.getConnection();

			String queryCount = "SELECT count(id) FROM pack_atracciones WHERE ID = ?";
			PreparedStatement statement = conn.prepareStatement(queryCount);
			statement.setInt(1, id);

			ResultSet resultsCount = statement.executeQuery();

			String queryNames = "SELECT NOMBRE_ATRACCION FROM PACK_ATRACCIONES WHERE ID = ?";
			PreparedStatement statement2 = conn.prepareStatement(queryNames);
			statement2.setInt(1, id);

			ResultSet resultsNames = statement.executeQuery();

			Atracciones[] atracciones = new Atracciones[resultsCount.getInt(1)];

			for (int i = 0; i < atracciones.length; i++) {
				for (Atracciones atraccion : AtraccionesDAOImpl.atraccionesList) {
					if (resultsNames.getString(i + 1).equals(atraccion.getNombre())) {
						atracciones[i] = atraccion;
					}
				}
			}
			return atracciones;
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

//	public List<Atracciones> findAllWithAtracciones() {
//		try {
//			String query = "SELECT * FROM ATRACCIONES";
//			Connection conn = TierraMediaConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(query);
//			ResultSet results = statement.executeQuery();
//
//			List<Atracciones> atracciones = new ArrayList<Atracciones>();
//			while (results.next()) {
//				atracciones.add(toAtraccion(results));
//			}
//			return atracciones;
//
//		} catch (SQLException e) {
//			throw new MissingDataException(e);
//		}
//	}

	@Override
	public List findAll() {
		try {
			String query = "SELECT * FROM PROMOCIONES"; // 1
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				switch(results.getString(4)) {
				case "ABSOLUTA":
					vendiblesList.add(toAbsoluta(results));
					break;
					
				case "PORCENTUAL":
					vendiblesList.add(toPorcentual(results));
					break;
					
				case "AxB":
					vendiblesList.add(toAxB(results));
					break;
				}
			}
			return vendiblesList;

		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promociones t) {
		try {
			String query = "INSERT INTO PROMOCIONES(NOMBRE, TIPO_TEMATICA, TIPO_PROMO, BENEFICIO_ABS, BENEFICIO_PORCEN, BENEFICIO_AxB)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, String.valueOf(t.getTipo()));
			statement.setString(3, t.getClass().getSimpleName());
			
			switch(t.getClass().getSimpleName()) {
			case "ABSOLUTA":
				statement.setDouble(4, t.getCosto());
				statement.setString(5, null);
				statement.setString(6, null);
				break;
				
			case "PORCENTUAL":
				statement.setString(4, null);
				statement.setDouble(5, ((Porcentual) t).getPorcentaje());
				statement.setString(6, null);
				break;
				
			case "AxB":
				statement.setString(4, null);
				statement.setString(5, null);
				statement.setString(6, ((AxB) t).getAtraccionGratis().getNombre());
				break;
			}
			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Promociones t) {
		try {
			String query = "DELETE FROM PROMOCIONES WHERE NOMBRE = ?";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

}
