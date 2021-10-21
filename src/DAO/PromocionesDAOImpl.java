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

			String query = "SELECT count(id) FROM pack_atracciones WHERE ID = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			ResultSet results = statement.executeQuery();

			String query2 = "SELECT NOMBRE_ATRACCION FROM PACK_ATRACCIONES WHERE ID = ?";
			PreparedStatement statement2 = conn.prepareStatement(query2);
			statement2.setInt(1, id);

			ResultSet results2 = statement.executeQuery();

			Atracciones[] atracciones = new Atracciones[results.getInt(1)];
			List<Atracciones> atraccionesList = this.findAllWithAtracciones();

			for (int i = 0; i < atracciones.length; i++) {
				for (Atracciones atraccion : atraccionesList) {
					if (results2.getString(i + 1).equals(atraccion)) {
						atracciones[i] = atraccion;
					}
				}
			}
			return atracciones;
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public List<Atracciones> findAllWithAtracciones() {
		try {
			String query = "SELECT * FROM ATRACCIONES";
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<Atracciones> atracciones = new ArrayList<Atracciones>();
			while (results.next()) {
				atracciones.add(toAtraccion(results));
			}
			return atracciones;

		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

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
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	@Override
	public int delete(Promociones t) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

}
