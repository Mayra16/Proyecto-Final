package com.micromercado.view;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.ClienteCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.control.DetalleVentaCtrl;
import com.micromercado.control.ProductoCtrl;
import com.micromercado.control.VentaCtrl;
import com.micromercado.entity.Cliente;
import com.micromercado.entity.DetalleVenta;
import com.micromercado.entity.Producto;
import com.micromercado.entity.Venta;
import com.micromercado.view.Men�.MenusDetalleVenta;

public class DetalleVentaView {

	private Scanner scanner;
	private DetalleVenta detalleVenta;
	private DetalleVentaCtrl detalleVentaCtrl;
	private Conexion conexion;
	
	public DetalleVentaView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
		detalleVentaCtrl = new  DetalleVentaCtrl(conexion);
		
	}
	
	public void insertar(int c�digoProducto, int cantidad) throws Throwable {
		int c�digoVenta;
		
		Producto producto = new Producto(c�digoProducto);
		
		DetalleVentaView detalleVentaView = new DetalleVentaView(conexion, scanner);
		c�digoVenta = detalleVentaView.getLastC�digo();
		
		ProductoCtrl productoCtrl = new  ProductoCtrl(conexion);
		productoCtrl.search(producto);
		Venta venta = new Venta(c�digoVenta);
		
		if(producto.getStock() < cantidad){
		System.out.println("No existen suficientes productos para la venta, existen "+ producto.getStock() +" "+ producto.getNombre() +"s");	
		}
		else {detalleVenta = new DetalleVenta(c�digoProducto,cantidad,c�digoVenta);
		ProductoCtrl productoCtrl2 = new  ProductoCtrl(conexion);
		productoCtrl2.search(producto);
		VentaCtrl VentaCtrl2 = new  VentaCtrl(conexion);
		VentaCtrl2.search(venta);
		Cliente cliente = new Cliente(venta.getNIT());
		ClienteCtrl ClienteCtrl2 = new  ClienteCtrl(conexion);
		ClienteCtrl2.search(cliente);
		
		System.out.println("			Nombre:  "+ cliente.getNombre());
		System.out.println("			NIT:  " +cliente.getNIT());
		System.out.println("			C�digo venta:  " + detalleVenta.getC�digoVenta());
		System.out.println("			Producto:  " + producto.getNombre());
		System.out.println("			Cantidad:  "+ detalleVenta.getCantidad());
		System.out.println("			Monto =  " + detalleVenta.getCantidad() * producto.getPrecio()  );
		
		
		
		try {
			detalleVentaCtrl.insert(detalleVenta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		}
	}
	
	
	public void listar() {
		ArrayList<DetalleVenta> detalleVentas;

		try {
			detalleVentas = detalleVentaCtrl.list();
			for (int i = 0; i < detalleVentas.size(); i++) {
				System.out.println(detalleVentas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void buscar(int c�digo) {
		detalleVenta = new DetalleVenta(c�digo);
		try {
			detalleVentaCtrl.search(detalleVenta);
			
			System.out.println(detalleVenta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizar() {
		int c�digo;
			
			c�digo = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del detalle de venta a modificar; ");
			detalleVenta = new DetalleVenta(c�digo);
			try {
				detalleVentaCtrl.search(detalleVenta);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}

			MenusDetalleVenta.menuModificar(scanner, detalleVenta);

			try {
				detalleVentaCtrl.update(detalleVenta);
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
		}
	
	public int getLastC�digo() throws Throwable {

		ResultSet rs;
		int c�digo = 0;

		conexion.SQL("SELECT c�digo FROM venta ORDER BY c�digo DESC Limit 1 ");
		
		rs = conexion.resultSet();

		while (rs.next()) {

			c�digo = rs.getInt("c�digo");
			
		}

		rs.close();
		return c�digo;
	}
	
}

