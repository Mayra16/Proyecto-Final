package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.Categor�a;

public class Categor�aCtrl implements Control<Categor�a>  {

private Conexion conexion;
	
	public Categor�aCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Categor�a> list() throws Throwable {
		ArrayList<Categor�a> Categor�as = new ArrayList<Categor�a>();
		ResultSet rs;
		int c�digo;
		String nombre;
		String descripci�n;
		
		conexion.SQL("Select * from categor�a");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			nombre = rs.getString("nombre");
			descripci�n = rs.getString("descripci�n");
			Categor�as.add(new Categor�a(c�digo, nombre, descripci�n));
		}

		return Categor�as;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Categor�a categor�a) throws Throwable {

		conexion.SQL("Insert into categor�a(c�digo,nombre,descripci�n) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, categor�a.getC�digo());
		conexion.preparedStatement().setString(2, categor�a.getNombre());
		conexion.preparedStatement().setString(3, categor�a.getDescripci�n());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Categor�a categor�a) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from categor�a where c�digo=?");
		conexion.preparedStatement().setInt(1, categor�a.getC�digo());
		rs = conexion.resultSet();

		while (rs.next()) {

			categor�a.setNombre(rs.getString("nombre"));
			categor�a.setDescripci�n(rs.getString("descripci�n"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Categor�a categor�a) throws Throwable {
		int c�digo;
		String nombre;
		String descripci�n;
		
		if (categor�a!= null) {
			c�digo = categor�a.getC�digo();
			nombre = categor�a.getNombre();
			descripci�n = categor�a.getDescripci�n();

			conexion.SQL("Update categor�a set nombre = ?, descripci�n = ? where c�digo=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, descripci�n);
			conexion.preparedStatement().setInt(3, c�digo);
			conexion.CUD();
		}
	}

	
}
