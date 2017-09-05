package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.micromercado.entity.Producto;

public class ProductoCtrl implements Control<Producto> {

private Conexion conexion;
	
	public ProductoCtrl (Conexion conexion) {
		this.conexion = conexion;
	}
	
	public ArrayList<Producto> list() throws Throwable {
		ArrayList<Producto> Productos = new ArrayList<Producto>();
		ResultSet rs;
		int código;
		Date fechaVencimiento;
		String nombre;
		double precio;
		int códigoCategoría;
		int stock;

		conexion.SQL("Select * from Producto");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			fechaVencimiento = rs.getDate("fechaVencimiento");
			nombre = rs.getString("nombre");
			precio = rs.getDouble("precio");
			códigoCategoría = rs.getInt("códigoCategoría");
			stock = rs.getInt("stock");
			
			Productos.add(new Producto(código, fechaVencimiento, nombre, precio, códigoCategoría, stock));
		}

		return Productos;

	}
	public void insert(Producto producto) throws Throwable {

		conexion.SQL("Insert into Producto(fechaVencimiento, nombre, precio, códigoCategoría, stock) VALUES(?,?,?,?,?)");
		conexion.preparedStatement().setDate(1, new java.sql.Date(producto.getFechaVencimiento().getTime()));
		conexion.preparedStatement().setString(2, producto.getNombre() );
		conexion.preparedStatement().setDouble(3, producto.getPrecio());
		conexion.preparedStatement().setInt(4, producto.getCódigoCategoría());
		conexion.preparedStatement().setInt(5, producto.getStock());
		conexion.CUD();

	}
	
	public void search(Producto producto) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from Producto where código=?");
		conexion.preparedStatement().setInt(1, producto.getCódigo());
		
		rs = conexion.resultSet();

		while (rs.next()) {

			producto.setFechaVencimiento(rs.getDate("fechaVencimiento"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getDouble("precio"));
			producto.setCódigoCategoría(rs.getInt("códigoCategoría"));
			producto.setStock(rs.getInt("stock"));
			
		}

		rs.close();

	}
	
	public void update(Producto producto) throws Throwable {
		int código;
		String nombre;
		double precio;
		int códigoCategoría;
		int stock;
		
		if (producto != null) {
			código = producto.getCódigo();
			nombre = producto.getNombre();
			precio = producto.getPrecio();
			códigoCategoría = producto.getCódigoCategoría();
			stock = producto.getStock();

			conexion.SQL("Update Producto set fechaVencimiento = ?, nombre = ?, precio =?, códigoCategoría = ?, stock =? where código=?");
			conexion.preparedStatement().setDate(1, new java.sql.Date(producto.getFechaVencimiento().getTime()));
			conexion.preparedStatement().setString(2, nombre);
			conexion.preparedStatement().setDouble(3, precio);
			conexion.preparedStatement().setInt(4 , códigoCategoría);
			conexion.preparedStatement().setInt(5, stock);
			conexion.preparedStatement().setInt(6, código);
			conexion.CUD();
		}
	}

}
