package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.micromercado.entity.Adquisición;

public class AdquisiciónCtrl implements Control<Adquisición> {

	private Conexion conexion;
	
	public AdquisiciónCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Adquisición> list() throws Throwable {
		ArrayList<Adquisición> Adquisición = new ArrayList<Adquisición>();
		ResultSet rs;
		int código;
		int códigoProveedor;
		Date fechaPedido;
		Date fechaEntrega;
		

		conexion.SQL("Select * from Adquisición");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			fechaPedido = rs.getDate("fechaPedido");
			fechaEntrega = rs.getDate("fechaEntrega");
			códigoProveedor = rs.getInt("códigoProveedor");
			Adquisición.add(new Adquisición(código, códigoProveedor, fechaPedido, fechaEntrega));
		}

		return Adquisición;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Adquisición Adquisición) throws Throwable {

		conexion.SQL("Insert into Adquisición(códigoProveedor,fechaPedido, fechaEntrega) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, Adquisición.getCódigoProveedor());
		conexion.preparedStatement().setDate(2, new java.sql.Date(Adquisición.getFechaPedido().getTime()));
		conexion.preparedStatement().setDate(3, new java.sql.Date(Adquisición.getFechaEntrega().getTime()));
		conexion.CUD();
		

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Adquisición adquisición) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from adquisición where código=?");
		conexion.preparedStatement().setInt(1, adquisición.getCódigo());
		
		rs = conexion.resultSet();

		while (rs.next()) {

			adquisición.setFechaPedido((java.util.Date) rs.getDate("fechaPedido"));
			adquisición.setFechaEntrega((java.util.Date) rs.getDate("fechaEntrega"));
			adquisición.setCódigoProveedor(rs.getInt("códigoProveedor"));
			
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Adquisición Adquisición) throws Throwable {
		int código;
		int códigoProveedor;
		if (Adquisición != null) {
			código = Adquisición.getCódigo();
			códigoProveedor = Adquisición.getCódigoProveedor();

			conexion.SQL("Update Adquisición set códigoProveedor = ?, fechaPedido = ?, fechaEntrega = ? where código=?");
			conexion.preparedStatement().setInt(1, códigoProveedor);
			conexion.preparedStatement().setDate(2, new java.sql.Date(Adquisición.getFechaPedido().getTime()));
			conexion.preparedStatement().setDate(3, new java.sql.Date(Adquisición.getFechaEntrega().getTime()));
			conexion.preparedStatement().setInt(4, código);
			conexion.CUD();
		}
	}
	
}
