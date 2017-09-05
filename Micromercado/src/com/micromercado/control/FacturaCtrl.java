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
		int código;
		String códigoAutorización;

		conexion.SQL("Select * from Factura");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			códigoAutorización = rs.getString("códigoAutorización");
			facturas.add(new Factura(código, códigoAutorización));
		}

		return facturas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Factura factura) throws Throwable {

		conexion.SQL("Insert into factura (código,códigoAutorización) VALUES (?,?)");
		conexion.preparedStatement().setInt(1, factura.getCódigo());
		conexion.preparedStatement().setString(2, factura.getCódigoAutorización());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Factura factura) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from factura where código=?");
		conexion.preparedStatement().setInt(1, factura.getCódigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			factura.setCódigo(rs.getInt("código"));
			factura.setCódigoAutorización(rs.getString("códigoAutorización"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Factura factura) throws Throwable {
		int código;
		String códigoAutorización;
		
		if (factura != null) {
			código = factura.getCódigo();
			códigoAutorización = factura.getCódigoAutorización();

			conexion.SQL("Update factura set códigoAutorización = ? where código=?");
			conexion.preparedStatement().setString(1, códigoAutorización);
			conexion.preparedStatement().setInt(2, código);
			conexion.CUD();
		}
	}

}
