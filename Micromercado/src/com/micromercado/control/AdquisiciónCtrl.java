package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.micromercado.entity.Adquisici�n;

public class Adquisici�nCtrl implements Control<Adquisici�n> {

	private Conexion conexion;
	
	public Adquisici�nCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Adquisici�n> list() throws Throwable {
		ArrayList<Adquisici�n> Adquisici�n = new ArrayList<Adquisici�n>();
		ResultSet rs;
		int c�digo;
		int c�digoProveedor;
		Date fechaPedido;
		Date fechaEntrega;
		

		conexion.SQL("Select * from Adquisici�n");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			fechaPedido = rs.getDate("fechaPedido");
			fechaEntrega = rs.getDate("fechaEntrega");
			c�digoProveedor = rs.getInt("c�digoProveedor");
			Adquisici�n.add(new Adquisici�n(c�digo, c�digoProveedor, fechaPedido, fechaEntrega));
		}

		return Adquisici�n;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Adquisici�n Adquisici�n) throws Throwable {

		conexion.SQL("Insert into Adquisici�n(c�digoProveedor,fechaPedido, fechaEntrega) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, Adquisici�n.getC�digoProveedor());
		conexion.preparedStatement().setDate(2, new java.sql.Date(Adquisici�n.getFechaPedido().getTime()));
		conexion.preparedStatement().setDate(3, new java.sql.Date(Adquisici�n.getFechaEntrega().getTime()));
		conexion.CUD();
		

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Adquisici�n adquisici�n) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from adquisici�n where c�digo=?");
		conexion.preparedStatement().setInt(1, adquisici�n.getC�digo());
		
		rs = conexion.resultSet();

		while (rs.next()) {

			adquisici�n.setFechaPedido((java.util.Date) rs.getDate("fechaPedido"));
			adquisici�n.setFechaEntrega((java.util.Date) rs.getDate("fechaEntrega"));
			adquisici�n.setC�digoProveedor(rs.getInt("c�digoProveedor"));
			
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Adquisici�n Adquisici�n) throws Throwable {
		int c�digo;
		int c�digoProveedor;
		if (Adquisici�n != null) {
			c�digo = Adquisici�n.getC�digo();
			c�digoProveedor = Adquisici�n.getC�digoProveedor();

			conexion.SQL("Update Adquisici�n set c�digoProveedor = ?, fechaPedido = ?, fechaEntrega = ? where c�digo=?");
			conexion.preparedStatement().setInt(1, c�digoProveedor);
			conexion.preparedStatement().setDate(2, new java.sql.Date(Adquisici�n.getFechaPedido().getTime()));
			conexion.preparedStatement().setDate(3, new java.sql.Date(Adquisici�n.getFechaEntrega().getTime()));
			conexion.preparedStatement().setInt(4, c�digo);
			conexion.CUD();
		}
	}
	
}
