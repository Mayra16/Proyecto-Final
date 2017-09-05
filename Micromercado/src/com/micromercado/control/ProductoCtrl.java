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
		int c�digo;
		Date fechaVencimiento;
		String nombre;
		double precio;
		int c�digoCategor�a;
		int stock;

		conexion.SQL("Select * from Producto");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			fechaVencimiento = rs.getDate("fechaVencimiento");
			nombre = rs.getString("nombre");
			precio = rs.getDouble("precio");
			c�digoCategor�a = rs.getInt("c�digoCategor�a");
			stock = rs.getInt("stock");
			
			Productos.add(new Producto(c�digo, fechaVencimiento, nombre, precio, c�digoCategor�a, stock));
		}

		return Productos;

	}
	public void insert(Producto producto) throws Throwable {

		conexion.SQL("Insert into Producto(fechaVencimiento, nombre, precio, c�digoCategor�a, stock) VALUES(?,?,?,?,?)");
		conexion.preparedStatement().setDate(1, new java.sql.Date(producto.getFechaVencimiento().getTime()));
		conexion.preparedStatement().setString(2, producto.getNombre() );
		conexion.preparedStatement().setDouble(3, producto.getPrecio());
		conexion.preparedStatement().setInt(4, producto.getC�digoCategor�a());
		conexion.preparedStatement().setInt(5, producto.getStock());
		conexion.CUD();

	}
	
	public void search(Producto producto) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from Producto where c�digo=?");
		conexion.preparedStatement().setInt(1, producto.getC�digo());
		
		rs = conexion.resultSet();

		while (rs.next()) {

			producto.setFechaVencimiento(rs.getDate("fechaVencimiento"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getDouble("precio"));
			producto.setC�digoCategor�a(rs.getInt("c�digoCategor�a"));
			producto.setStock(rs.getInt("stock"));
			
		}

		rs.close();

	}
	
	public void update(Producto producto) throws Throwable {
		int c�digo;
		String nombre;
		double precio;
		int c�digoCategor�a;
		int stock;
		
		if (producto != null) {
			c�digo = producto.getC�digo();
			nombre = producto.getNombre();
			precio = producto.getPrecio();
			c�digoCategor�a = producto.getC�digoCategor�a();
			stock = producto.getStock();

			conexion.SQL("Update Producto set fechaVencimiento = ?, nombre = ?, precio =?, c�digoCategor�a = ?, stock =? where c�digo=?");
			conexion.preparedStatement().setDate(1, new java.sql.Date(producto.getFechaVencimiento().getTime()));
			conexion.preparedStatement().setString(2, nombre);
			conexion.preparedStatement().setDouble(3, precio);
			conexion.preparedStatement().setInt(4 , c�digoCategor�a);
			conexion.preparedStatement().setInt(5, stock);
			conexion.preparedStatement().setInt(6, c�digo);
			conexion.CUD();
		}
	}

}
