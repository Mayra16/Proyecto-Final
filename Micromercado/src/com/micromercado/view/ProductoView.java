package com.micromercado.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.ProductoCtrl;
import com.micromercado.entity.Producto;
import com.micromercado.view.Men�.MenusProducto;


public class ProductoView {

	private Scanner scanner;
	private Producto producto;
	private ProductoCtrl productoCtrl;
	
	public ProductoView(Conexion conexion, Scanner scanner) {
		
		this.scanner = scanner;
		productoCtrl = new  ProductoCtrl(conexion);
		
	}
	
	public void insertar(	int c�digoCategor�a) {
		Date fechaVencimiento;
		String nombre;
		double precio;
	
		int stock;
		
		fechaVencimiento = ReadTypes.leerFecha(scanner, "Ingrese la fecha de vencimiento: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		precio = (double) ReadTypes.leerEntero(scanner, "Ingrese el precio: ");
		stock = ReadTypes.leerEntero(scanner, "Ingrese el stock: ");

		producto = new Producto(fechaVencimiento, nombre, precio ,c�digoCategor�a, stock);
		
		try {
			productoCtrl.insert(producto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void listar() {
		ArrayList<Producto> productos;

		try {
			productos = productoCtrl.list();
			for (int i = 0; i < productos.size(); i++) {
				System.out.println(productos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void buscar(int c�digo) {
		producto = new Producto(c�digo);
		try {
			productoCtrl.search(producto);
			if (producto.getNombre() != null){
				System.out.println(producto);	
			}
			else {
			System.out.println("El producto no existe");
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizar() {
		int c�digo;
			
			c�digo = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del producto a modificar; ");
			producto = new Producto(c�digo);
			try {
				productoCtrl.search(producto);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}

			MenusProducto.actualizar(scanner, producto);

			try {
				productoCtrl.update(producto);
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
		}
	
}
