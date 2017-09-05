package com.micromercado.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.micromercado.entity.DetalleVenta;

public class DetalleVentaCtrl implements Control<DetalleVenta> {

	private Conexion conexion;

	public DetalleVentaCtrl(Conexion conexion) {
		super();
		this.conexion = conexion;
	}
	
	public ArrayList<DetalleVenta> list() throws Throwable {
		ArrayList<DetalleVenta> DetalleVentas = new ArrayList<DetalleVenta>();
		ResultSet rs;
		int c�digo;
		int c�digoProducto;
		int cantidad;
		int c�digoVenta;

		conexion.SQL("Select * from DetalleVenta");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digo = rs.getInt("c�digo");
			c�digoProducto = rs.getInt("c�digoProducto");
			cantidad = rs.getInt("cantidad");
			c�digoVenta= rs.getInt("c�digoVenta");
			
			DetalleVentas.add(new DetalleVenta(c�digo, c�digoProducto, cantidad,c�digoVenta));
		}

		return DetalleVentas;

	}
	
	public void insert(DetalleVenta detalleVenta) throws Throwable {

		conexion.SQL("Insert into DetalleVenta(c�digoProducto,cantidad,c�digoVenta) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, detalleVenta.getC�digoProducto() );
		conexion.preparedStatement().setInt(2, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(3, detalleVenta.getC�digoVenta());
		conexion.CUD();
		conexion.SQL("UPDATE producto SET stock = stock - ? WHERE c�digo = ?");
		conexion.preparedStatement().setInt(1, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(2, detalleVenta.getC�digoProducto());
		conexion.CUD();

	}
	
	public void search(DetalleVenta detalleVenta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from detalleVenta where c�digo=?");
		conexion.preparedStatement().setInt(1, detalleVenta.getC�digo());
		/*detalleVenta.setC�digoProducto(null);
		detalleVenta.setCantidad(null);
		detalleVenta.setC�digoVenta(null);*/
		
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleVenta.setC�digoProducto(rs.getInt("c�digoProducto"));
			detalleVenta.setCantidad(rs.getInt("cantidad"));
			detalleVenta.setC�digoVenta(rs.getInt("c�digoVenta"));
			
		}

		rs.close();

	}

	public void update(DetalleVenta detalleVenta) throws Throwable {
		int c�digo;
		int c�digoProducto;
		int cantidad;
		int c�digoVenta;
		
		if (detalleVenta != null) {
			c�digo = detalleVenta.getC�digo();
			c�digoProducto = detalleVenta.getC�digoProducto();
			cantidad = detalleVenta.getCantidad();
			c�digoVenta = detalleVenta.getC�digoVenta();

			conexion.SQL("Update detalleVenta set c�digoProducto = ?, cantidad = ?, c�digoVenta = ? where c�digo = ?");
			conexion.preparedStatement().setInt(1, c�digoProducto);
			conexion.preparedStatement().setInt(2, cantidad );
			conexion.preparedStatement().setInt(3, c�digoVenta);
			conexion.preparedStatement().setInt(4, c�digo);
			conexion.CUD();
		}
	}
	
	public void generarFactura(DetalleVenta detalleVenta) throws Throwable{
		int c�digo;
		int c�digoProducto;
		int cantidad;
		int c�digoVenta;
		
		if (detalleVenta != null) {
			c�digo = detalleVenta.getC�digo();
			c�digoProducto = detalleVenta.getC�digoProducto();
			cantidad = detalleVenta.getCantidad();
			c�digoVenta = detalleVenta.getC�digoVenta();

			conexion.SQL("Update factura set c�digoProducto = ?, cantidad = ?, c�digoVenta = ? where c�digo = ?");
			conexion.preparedStatement().setInt(1, c�digoProducto);
			conexion.preparedStatement().setInt(2, cantidad );
			conexion.preparedStatement().setInt(3, c�digoVenta);
			conexion.preparedStatement().setInt(4, c�digo);
			conexion.CUD();
		}
		
	}
	
}
