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
		int código;
		Date fecha;
		String NIT;

		conexion.SQL("Select * from Venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			fecha = rs.getDate("fecha");
			NIT = rs.getString("NIT");
			Ventas.add(new Venta(código, fecha, NIT));
		}

		return Ventas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Venta Venta) throws Throwable {

		conexion.SQL("Insert into Venta(NIT,fecha) VALUES(?,?)");
		//conexion.preparedStatement().setInt(1, Venta.getCódigo());
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

		conexion.SQL("Select * from Venta where código=?");
		conexion.preparedStatement().setInt(1, Venta.getCódigo());
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
		int código;
		String NIT;
		if (Venta != null) {
			código = Venta.getCódigo();
			NIT = Venta.getNIT();

			conexion.SQL("Update Venta set fecha = ?, NIT = ? where código=?");
			conexion.preparedStatement().setDate(1, new java.sql.Date(Venta.getFecha().getTime()));
			conexion.preparedStatement().setString(2, NIT);
			conexion.preparedStatement().setInt(3, código);
			conexion.CUD();
		}
	}

	public int getLastCódigo() throws Throwable {

		ResultSet rs;
		int código = 0;

		conexion.SQL("SELECT código FROM venta ORDER BY código DESC Limit 1 ");
		
		rs = conexion.resultSet();

		while (rs.next()) {

			código = rs.getInt("código");
			
		}

		rs.close();
		return código;
	}
}

