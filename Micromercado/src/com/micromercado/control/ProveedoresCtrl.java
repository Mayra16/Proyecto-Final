package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.Proveedores;

public class ProveedoresCtrl implements Control <Proveedores> {
	
	private Conexion conexion;
	public ProveedoresCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	//LIST
	public ArrayList<Proveedores> list() throws Throwable {
		ArrayList<Proveedores> proveedores = new ArrayList<Proveedores>();
		ResultSet rs;
		int c�digo;
		String nombre;//
		String direcci�n;//
		int tel�fono;//
		String correoElectr�nico;
		
		conexion.SQL("Select * from proveedores");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			nombre = rs.getString("nombre");
			direcci�n= rs.getString("direcci�n");
			tel�fono = rs.getInt("tel�fono");
			correoElectr�nico=rs.getString("correoElectr�nico");
			proveedores.add(new Proveedores(c�digo, nombre, direcci�n, tel�fono, correoElectr�nico));
		}
		
		return proveedores;
	}

	//INSERT
	public void insert(Proveedores proveedores) throws Throwable {
		conexion.SQL("Insert into proveedores (nombre, direcci�n, tel�fono, correoElectr�nico) VALUES(?,?,?,?)");
		conexion.preparedStatement().setString(1, proveedores.getNombre());
		conexion.preparedStatement().setString(2, proveedores.getDirecci�n());
		conexion.preparedStatement().setInt(3, proveedores.getTel�fono());
		conexion.preparedStatement().setString(4, proveedores.getCorreoElectr�nico());
		conexion.CUD();	
	}

	//SEARCH
	public void search(Proveedores proveedores) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from proveedores where c�digo=?");
		conexion.preparedStatement().setInt(1, proveedores.getC�digo());
		rs = conexion.resultSet();

		while (rs.next()) {

			proveedores.setNombre(rs.getString("nombre"));
			proveedores.setDirecci�n(rs.getString("direcci�n"));
			proveedores.setTel�fono(rs.getInt("tel�fono"));
			proveedores.setCorreoElectr�nico(rs.getString("correoElectr�nico"));
		}

		rs.close();	
	}

	//UPDATE
	public void update(Proveedores proveedores) throws Throwable {
		int c�digo;
		String nombre;//
		String direcci�n;//
		int tel�fono;//
		String correoElectr�nico;//
		
		if (proveedores != null) {
			nombre = proveedores.getNombre();
			direcci�n = proveedores.getDirecci�n();
			tel�fono = proveedores.getTel�fono();
			correoElectr�nico = proveedores.getCorreoElectr�nico();
			
			c�digo= proveedores.getC�digo();

			conexion.SQL("Update proveedores set nombre = ?, direcci�n= ?, tel�fono= ?, correoElectr�nico= ? where c�digo=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, direcci�n);
			conexion.preparedStatement().setInt(3, tel�fono);
			conexion.preparedStatement().setString(4, correoElectr�nico);
			conexion.preparedStatement().setInt(5, c�digo);

			conexion.CUD();
		}
		
		
	}

}

