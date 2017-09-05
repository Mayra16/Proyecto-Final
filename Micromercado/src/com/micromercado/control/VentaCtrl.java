package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.micromercado.entity.Venta;

public class VentaCtrl implements Control<Venta> {

private Conexion conexion;
	
	public VentaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> Ventas = new ArrayList<Venta>();
		ResultSet rs;
		int c�digo;
		Date fecha;
		String NIT;

		conexion.SQL("Select * from Venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			fecha = rs.getDate("fecha");
			NIT = rs.getString("NIT");
			Ventas.add(new Venta(c�digo, fecha, NIT));
		}

		return Ventas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Venta Venta) throws Throwable {

		conexion.SQL("Insert into Venta(NIT,fecha) VALUES(?,?)");
		//conexion.preparedStatement().setInt(1, Venta.getC�digo());
		conexion.preparedStatement().setDate(2, new java.sql.Date(Venta.getFecha().getTime()));
		conexion.preparedStatement().setString(1, Venta.getNIT());
		conexion.CUD();
		

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Venta Venta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from Venta where c�digo=?");
		conexion.preparedStatement().setInt(1, Venta.getC�digo());
		Venta.setNIT(null);
		Venta.setFecha(null);
		
		rs = conexion.resultSet();

		while (rs.next()) {

			Venta.setFecha((java.util.Date) rs.getDate("fecha"));
			Venta.setNIT(rs.getString("NIT"));
			
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Venta Venta) throws Throwable {
		int c�digo;
		String NIT;
		if (Venta != null) {
			c�digo = Venta.getC�digo();
			NIT = Venta.getNIT();

			conexion.SQL("Update Venta set fecha = ?, NIT = ? where c�digo=?");
			conexion.preparedStatement().setDate(1, new java.sql.Date(Venta.getFecha().getTime()));
			conexion.preparedStatement().setString(2, NIT);
			conexion.preparedStatement().setInt(3, c�digo);
			conexion.CUD();
		}
	}

	public int getLastC�digo() throws Throwable {

		ResultSet rs;
		int c�digo = 0;

		conexion.SQL("SELECT c�digo FROM venta ORDER BY c�digo DESC Limit 1 ");
		
		rs = conexion.resultSet();

		while (rs.next()) {

			c�digo = rs.getInt("c�digo");
			
		}

		rs.close();
		return c�digo;
	}
}

