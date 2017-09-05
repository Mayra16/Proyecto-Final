package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.Categoría;

public class CategoríaCtrl implements Control<Categoría>  {

private Conexion conexion;
	
	public CategoríaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Categoría> list() throws Throwable {
		ArrayList<Categoría> Categorías = new ArrayList<Categoría>();
		ResultSet rs;
		int código;
		String nombre;
		String descripción;
		
		conexion.SQL("Select * from categoría");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			nombre = rs.getString("nombre");
			descripción = rs.getString("descripción");
			Categorías.add(new Categoría(código, nombre, descripción));
		}

		return Categorías;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Categoría categoría) throws Throwable {

		conexion.SQL("Insert into categoría(código,nombre,descripción) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, categoría.getCódigo());
		conexion.preparedStatement().setString(2, categoría.getNombre());
		conexion.preparedStatement().setString(3, categoría.getDescripción());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Categoría categoría) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from categoría where código=?");
		conexion.preparedStatement().setInt(1, categoría.getCódigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			categoría.setNombre(rs.getString("nombre"));
			categoría.setDescripción(rs.getString("descripción"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Categoría categoría) throws Throwable {
		int código;
		String nombre;
		String descripción;
		
		if (categoría!= null) {
			código = categoría.getCódigo();
			nombre = categoría.getNombre();
			descripción = categoría.getDescripción();

			conexion.SQL("Update categoría set nombre = ?, descripción = ? where código=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, descripción);
			conexion.preparedStatement().setInt(3, código);
			conexion.CUD();
		}
	}

	
}
