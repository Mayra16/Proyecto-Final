package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.Factura;

public class FacturaCtrl implements Control<Factura>{

private Conexion conexion;
	
	public FacturaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Factura> list() throws Throwable {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		ResultSet rs;
		int c�digo;
		String c�digoAutorizaci�n;

		conexion.SQL("Select * from Factura");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			c�digoAutorizaci�n = rs.getString("c�digoAutorizaci�n");
			facturas.add(new Factura(c�digo, c�digoAutorizaci�n));
		}

		return facturas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Factura factura) throws Throwable {

		conexion.SQL("Insert into factura (c�digo,c�digoAutorizaci�n) VALUES (?,?)");
		conexion.preparedStatement().setInt(1, factura.getC�digo());
		conexion.preparedStatement().setString(2, factura.getC�digoAutorizaci�n());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Factura factura) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from factura where c�digo=?");
		conexion.preparedStatement().setInt(1, factura.getC�digo());
		rs = conexion.resultSet();

		while (rs.next()) {

			factura.setC�digo(rs.getInt("c�digo"));
			factura.setC�digoAutorizaci�n(rs.getString("c�digoAutorizaci�n"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Factura factura) throws Throwable {
		int c�digo;
		String c�digoAutorizaci�n;
		
		if (factura != null) {
			c�digo = factura.getC�digo();
			c�digoAutorizaci�n = factura.getC�digoAutorizaci�n();

			conexion.SQL("Update factura set c�digoAutorizaci�n = ? where c�digo=?");
			conexion.preparedStatement().setString(1, c�digoAutorizaci�n);
			conexion.preparedStatement().setInt(2, c�digo);
			conexion.CUD();
		}
	}

}
