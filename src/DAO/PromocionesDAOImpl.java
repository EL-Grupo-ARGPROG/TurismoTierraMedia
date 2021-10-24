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

public class PromocionesDAOImpl implements PromocionesDAO {

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

//	@Override
//	public List findAll() {
//		try {
//			String query = "SELECT * FROM PROMOCIONES"; // 1
//			Connection conn = TierraMediaConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(query);
//			ResultSet results = statement.executeQuery();
//
//			List<Promociones> promociones = new LinkedList<Promociones>();
//			while (results.next()) {
//				switch()
//				promociones.add(toPromociones(results));
//			}
//			return promociones;
//
//		} catch (SQLException e) {
//			throw new MissingDataException(e);
//		}
//	}

//	@Override
//	public int insert(Promociones t) {
//		try {
//			String query = "INSERT INTO PROMOCIONES(NOMBRE, TIPO_TEMATICA, TIPO_PROMO, BENEFICIO_ABS, BENEFICIO_PORCEN, BENEFICIO_AxB)"
//					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
//			Connection conn = TierraMediaConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(query);
//			statement.setString(1, t.getNombre());
//			statement.setString(2, t.getTipo());
//			statement.setString(3, t.getClass());
//			statement.setDouble(4, t.getTiempoDisponible());
//			statement.setString(5, String.valueOf(t.getPreferencia()));
//
//			return statement.executeUpdate();
//		} catch (SQLException e) {
//			throw new MissingDataException(e);
//		}
//	}

	@Override
	public int update(Promociones t) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	@Override
	public int delete(Promociones t) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

}
