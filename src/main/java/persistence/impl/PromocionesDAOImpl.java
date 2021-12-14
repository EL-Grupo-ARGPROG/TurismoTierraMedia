package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.*;
import persistence.PromocionesDAO;
import persistence.commons.MissingDataException;
import persistence.commons.TierraMediaConnectionProvider;


public class PromocionesDAOImpl implements PromocionesDAO {
	public static List<Vendible> vendiblesList = new LinkedList<Vendible>();
	public static List<Promociones> promocionesList = new LinkedList<Promociones>();
	
	private static List<Vendible> setVendiblesList() {
		for(Atracciones atraccion : AtraccionesDAOImpl.atraccionesList) {
			vendiblesList.add(atraccion);
		}
		return vendiblesList;
	}
	
	private Atracciones atraccionFinder(String nombre) {
		for(Atracciones atraccion : AtraccionesDAOImpl.atraccionesList) {
			if(atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
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
			return new AxB(this.armarPaquete(result.getInt(2)), result.getString(1), atraccionFinder(result.getString(7)),
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
	
	public void instanciadorDePromociones() {
		setVendiblesList();
		try {
			String query = "SELECT * FROM PROMOCIONES"; // 1
			Connection conn = TierraMediaConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				switch(results.getString(4)) {
				case "ABSOLUTA":
					promocionesList.add(toAbsoluta(results));
					vendiblesList.add(toAbsoluta(results));
					break;
					
				case "PORCENTUAL":
					promocionesList.add(toPorcentual(results));
					vendiblesList.add(toPorcentual(results));
					break;
					
				case "AxB":
					promocionesList.add(toAxB(results));
					vendiblesList.add(toAxB(results));
					break;
				}
			}

		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
		
	}
	
	public Atracciones[] armarPaquete(int id) {
		try {
			Connection conn = TierraMediaConnectionProvider.getConnection();

			String queryCount = "SELECT count(id) AS TOTAL FROM pack_atracciones WHERE ID = ?";
			PreparedStatement statementCount = conn.prepareStatement(queryCount);
			statementCount.setInt(1, id);

			ResultSet resultsCount = statementCount.executeQuery();
			
			Atracciones[] atracciones = new Atracciones[resultsCount.getInt("TOTAL")];

			String queryNames = "SELECT NOMBRE_ATRACCION FROM PACK_ATRACCIONES WHERE ID = ?";
			PreparedStatement statementNames = conn.prepareStatement(queryNames);
			statementNames.setInt(1, id);

			ResultSet resultsNames = statementNames.executeQuery();

			for (int i = 0; resultsNames.next(); i++) {
				for (Atracciones atraccion : AtraccionesDAOImpl.atraccionesList) {
					if (resultsNames.getString(1).equals(atraccion.getNombre())) {
						atracciones[i] = atraccion;
					}
				}
			}
			return atracciones;
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


	@Override
	public List<Promociones> findAll() {
		return promocionesList;
	}
	
	public Promociones finder(String name) {
			for(Promociones promocion : promocionesList) {
				if (promocion.getNombre().equals(name)) {
					return promocion;
				}
			}
			
			return null;
	}

	@Override
	public int update(Vendible atraccion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
