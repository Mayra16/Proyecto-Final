package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.DetalleAdquisición;

public class DetalleAdquisiciónCtrl implements Control<DetalleAdquisición> {
	
	private Conexion conexion;
	public DetalleAdquisiciónCtrl (Conexion conexion) {
		this.conexion = conexion;
	}
	
	//LIST
	
	public ArrayList<DetalleAdquisición> list() throws Throwable {
		ArrayList<DetalleAdquisición> detallesAdquisiciones = new ArrayList<DetalleAdquisición>();
		ResultSet rs;
		int código;
		int códigoProducto;
		int cantidad;
		int códigoAdquisición;
		
		conexion.SQL("Select * from detalleAdquisición");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			códigoProducto = rs.getInt("códigoProducto");
			cantidad = rs.getInt("cantidad");
			códigoAdquisición = rs.getInt("códigoAdquisición");
			detallesAdquisiciones.add(new DetalleAdquisición(código, códigoProducto, cantidad, códigoAdquisición));
		}
		return detallesAdquisiciones;
	}
	
	//INSERT

	public void insert(DetalleAdquisición detalleAdquisición) throws Throwable {
		
		conexion.SQL("Insert into detalleAdquisición (códigoProducto, cantidad, códigoAdquisición) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, detalleAdquisición.getCódigoProducto());
		conexion.preparedStatement().setInt(2, detalleAdquisición.getCantidad());
		conexion.preparedStatement().setInt(3, detalleAdquisición.getCódigoAdquisición());
		conexion.CUD();
		
		conexion.SQL("UPDATE producto SET stock = stock + ? WHERE código = ?");
		conexion.preparedStatement().setInt(1, detalleAdquisición.getCantidad());
		conexion.preparedStatement().setInt(2, detalleAdquisición.getCódigoProducto());
		conexion.CUD();
		
	}
	
	//SEARCH
	
	public void search(DetalleAdquisición detalleAdquisición) throws Throwable {
		
		ResultSet rs;

		conexion.SQL("Select * from detalleAdquisición where código=?");
		conexion.preparedStatement().setInt(1, detalleAdquisición.getCódigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleAdquisición.setCantidad(rs.getInt("cantidad"));
		}

		rs.close();
		
	}
	
	//UPDATE
	
	public void update(DetalleAdquisición detalleAdquisición) throws Throwable {
		int cantidad;
		int código;
		if (detalleAdquisición != null) {
			cantidad = detalleAdquisición.getCantidad();
			código= detalleAdquisición.getCódigo();

			conexion.SQL("Update detalleAdquisición set cantidad = ? where código=?");
			conexion.preparedStatement().setInt(1, cantidad);
			conexion.preparedStatement().setInt(2, código);
			conexion.CUD();
		}
		
	}
	

}

