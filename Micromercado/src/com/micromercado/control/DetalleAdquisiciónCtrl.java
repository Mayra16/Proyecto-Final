package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.DetalleAdquisici�n;

public class DetalleAdquisici�nCtrl implements Control<DetalleAdquisici�n> {
	
	private Conexion conexion;
	public DetalleAdquisici�nCtrl (Conexion conexion) {
		this.conexion = conexion;
	}
	
	//LIST
	
	public ArrayList<DetalleAdquisici�n> list() throws Throwable {
		ArrayList<DetalleAdquisici�n> detallesAdquisiciones = new ArrayList<DetalleAdquisici�n>();
		ResultSet rs;
		int c�digo;
		int c�digoProducto;
		int cantidad;
		int c�digoAdquisici�n;
		
		conexion.SQL("Select * from detalleAdquisici�n");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			c�digoProducto = rs.getInt("c�digoProducto");
			cantidad = rs.getInt("cantidad");
			c�digoAdquisici�n = rs.getInt("c�digoAdquisici�n");
			detallesAdquisiciones.add(new DetalleAdquisici�n(c�digo, c�digoProducto, cantidad, c�digoAdquisici�n));
		}
		return detallesAdquisiciones;
	}
	
	//INSERT

	public void insert(DetalleAdquisici�n detalleAdquisici�n) throws Throwable {
		
		conexion.SQL("Insert into detalleAdquisici�n (c�digoProducto, cantidad, c�digoAdquisici�n) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, detalleAdquisici�n.getC�digoProducto());
		conexion.preparedStatement().setInt(2, detalleAdquisici�n.getCantidad());
		conexion.preparedStatement().setInt(3, detalleAdquisici�n.getC�digoAdquisici�n());
		conexion.CUD();
		
		conexion.SQL("UPDATE producto SET stock = stock + ? WHERE c�digo = ?");
		conexion.preparedStatement().setInt(1, detalleAdquisici�n.getCantidad());
		conexion.preparedStatement().setInt(2, detalleAdquisici�n.getC�digoProducto());
		conexion.CUD();
		
	}
	
	//SEARCH
	
	public void search(DetalleAdquisici�n detalleAdquisici�n) throws Throwable {
		
		ResultSet rs;

		conexion.SQL("Select * from detalleAdquisici�n where c�digo=?");
		conexion.preparedStatement().setInt(1, detalleAdquisici�n.getC�digo());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleAdquisici�n.setCantidad(rs.getInt("cantidad"));
		}

		rs.close();
		
	}
	
	//UPDATE
	
	public void update(DetalleAdquisici�n detalleAdquisici�n) throws Throwable {
		int cantidad;
		int c�digo;
		if (detalleAdquisici�n != null) {
			cantidad = detalleAdquisici�n.getCantidad();
			c�digo= detalleAdquisici�n.getC�digo();

			conexion.SQL("Update detalleAdquisici�n set cantidad = ? where c�digo=?");
			conexion.preparedStatement().setInt(1, cantidad);
			conexion.preparedStatement().setInt(2, c�digo);
			conexion.CUD();
		}
		
	}
	

}

