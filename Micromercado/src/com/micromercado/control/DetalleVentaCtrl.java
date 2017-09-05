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
		int código;
		int códigoProducto;
		int cantidad;
		int códigoVenta;

		conexion.SQL("Select * from DetalleVenta");

		rs = conexion.resultSet();

		while (rs.next()) {
			código = rs.getInt("código");
			códigoProducto = rs.getInt("códigoProducto");
			cantidad = rs.getInt("cantidad");
			códigoVenta= rs.getInt("códigoVenta");
			
			DetalleVentas.add(new DetalleVenta(código, códigoProducto, cantidad,códigoVenta));
		}

		return DetalleVentas;

	}
	
	public void insert(DetalleVenta detalleVenta) throws Throwable {

		conexion.SQL("Insert into DetalleVenta(códigoProducto,cantidad,códigoVenta) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, detalleVenta.getCódigoProducto() );
		conexion.preparedStatement().setInt(2, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(3, detalleVenta.getCódigoVenta());
		conexion.CUD();
		conexion.SQL("UPDATE producto SET stock = stock - ? WHERE código = ?");
		conexion.preparedStatement().setInt(1, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(2, detalleVenta.getCódigoProducto());
		conexion.CUD();

	}
	
	public void search(DetalleVenta detalleVenta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from detalleVenta where código=?");
		conexion.preparedStatement().setInt(1, detalleVenta.getCódigo());
		/*detalleVenta.setCódigoProducto(null);
		detalleVenta.setCantidad(null);
		detalleVenta.setCódigoVenta(null);*/
		
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleVenta.setCódigoProducto(rs.getInt("códigoProducto"));
			detalleVenta.setCantidad(rs.getInt("cantidad"));
			detalleVenta.setCódigoVenta(rs.getInt("códigoVenta"));
			
		}

		rs.close();

	}

	public void update(DetalleVenta detalleVenta) throws Throwable {
		int código;
		int códigoProducto;
		int cantidad;
		int códigoVenta;
		
		if (detalleVenta != null) {
			código = detalleVenta.getCódigo();
			códigoProducto = detalleVenta.getCódigoProducto();
			cantidad = detalleVenta.getCantidad();
			códigoVenta = detalleVenta.getCódigoVenta();

			conexion.SQL("Update detalleVenta set códigoProducto = ?, cantidad = ?, códigoVenta = ? where código = ?");
			conexion.preparedStatement().setInt(1, códigoProducto);
			conexion.preparedStatement().setInt(2, cantidad );
			conexion.preparedStatement().setInt(3, códigoVenta);
			conexion.preparedStatement().setInt(4, código);
			conexion.CUD();
		}
	}
	
	public void generarFactura(DetalleVenta detalleVenta) throws Throwable{
		int código;
		int códigoProducto;
		int cantidad;
		int códigoVenta;
		
		if (detalleVenta != null) {
			código = detalleVenta.getCódigo();
			códigoProducto = detalleVenta.getCódigoProducto();
			cantidad = detalleVenta.getCantidad();
			códigoVenta = detalleVenta.getCódigoVenta();

			conexion.SQL("Update factura set códigoProducto = ?, cantidad = ?, códigoVenta = ? where código = ?");
			conexion.preparedStatement().setInt(1, códigoProducto);
			conexion.preparedStatement().setInt(2, cantidad );
			conexion.preparedStatement().setInt(3, códigoVenta);
			conexion.preparedStatement().setInt(4, código);
			conexion.CUD();
		}
		
	}
	
}
