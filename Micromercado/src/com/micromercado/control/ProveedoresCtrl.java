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
		int código;
		String nombre;//
		String dirección;//
		int teléfono;//
		String correoElectrónico;
		
		conexion.SQL("Select * from proveedores");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			nombre = rs.getString("nombre");
			dirección= rs.getString("dirección");
			teléfono = rs.getInt("teléfono");
			correoElectrónico=rs.getString("correoElectrónico");
			proveedores.add(new Proveedores(código, nombre, dirección, teléfono, correoElectrónico));
		}
		
		return proveedores;
	}

	//INSERT
	public void insert(Proveedores proveedores) throws Throwable {
		conexion.SQL("Insert into proveedores (nombre, dirección, teléfono, correoElectrónico) VALUES(?,?,?,?)");
		conexion.preparedStatement().setString(1, proveedores.getNombre());
		conexion.preparedStatement().setString(2, proveedores.getDirección());
		conexion.preparedStatement().setInt(3, proveedores.getTeléfono());
		conexion.preparedStatement().setString(4, proveedores.getCorreoElectrónico());
		conexion.CUD();	
	}

	//SEARCH
	public void search(Proveedores proveedores) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from proveedores where código=?");
		conexion.preparedStatement().setInt(1, proveedores.getCódigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			proveedores.setNombre(rs.getString("nombre"));
			proveedores.setDirección(rs.getString("dirección"));
			proveedores.setTeléfono(rs.getInt("teléfono"));
			proveedores.setCorreoElectrónico(rs.getString("correoElectrónico"));
		}

		rs.close();	
	}

	//UPDATE
	public void update(Proveedores proveedores) throws Throwable {
		int código;
		String nombre;//
		String dirección;//
		int teléfono;//
		String correoElectrónico;//
		
		if (proveedores != null) {
			nombre = proveedores.getNombre();
			dirección = proveedores.getDirección();
			teléfono = proveedores.getTeléfono();
			correoElectrónico = proveedores.getCorreoElectrónico();
			
			código= proveedores.getCódigo();

			conexion.SQL("Update proveedores set nombre = ?, dirección= ?, teléfono= ?, correoElectrónico= ? where código=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, dirección);
			conexion.preparedStatement().setInt(3, teléfono);
			conexion.preparedStatement().setString(4, correoElectrónico);
			conexion.preparedStatement().setInt(5, código);

			conexion.CUD();
		}
		
		
	}

}

