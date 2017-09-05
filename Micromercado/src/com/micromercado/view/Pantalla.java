package com.micromercado.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.view.Menú.Principal;

public class Pantalla {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		ClienteView clienteView = new ClienteView(conexion,scanner);
		VentaView ventaView = new VentaView(conexion,scanner);
		DetalleVentaView detalleView = new DetalleVentaView(conexion,scanner);
		ProductoView productoView = new ProductoView(conexion,scanner);
		CategoríaView categoríaView = new CategoríaView(conexion, scanner);
		AdquisiciónView adquisiciónView = new AdquisiciónView(conexion, scanner);
		DetalleAdquisiciónView detalleAdquisiciónView = new DetalleAdquisiciónView(conexion, scanner);
		ProveedoresView proveedoresView = new ProveedoresView(conexion, scanner);
		
		Principal.subMenu(conexion, scanner);
		
/*		for (int i = 1; i < 3; i++) { 
			ClienteView.insertar(conexion, scanner);
		}*/
		
	//principal.menu(scanner);
		
		//clienteView.listar();
		//clienteView.buscar("246");
		//clienteView.actualizar();
		/*for (int i = 1; i < 11; i++) { 
		clienteView.insertar();
		}*/
		//categoríaView.listar();
		//categoríaView.buscar(1);
		//categoríaView.insertar();
		//categoríaView.actualizar();
		
		/*productoView.listar();
		productoView.insertar();
		productoView.buscar(2);*/
		//productoView.actualizar(); // no funciona
		
		/*ventaView.listar();
		ventaView.insertar();
		ventaView.actualizar();
		ventaView.buscar(2);*/
		
		/*detalleView.listar();
		detalleView.buscar(1);
		detalleView.actualizar();*/
		
		
		/*adquisiciónView.listar();
		adquisiciónView.buscar(2);
		adquisiciónView.insertar();
		adquisiciónView.actualizar();*/
		
		//MenusVenta menu = new MenusVenta();
		//menu.menu(scanner);
		
		/*detalleAdquisiciónView.listar();
		detalleAdquisiciónView.buscar(2);
		detalleAdquisiciónView.actualizar();*/
		
		//proveedoresView.listar();
		//proveedoresView.buscar(1);
		//proveedoresView.insertar();
		//proveedoresView.actualizar();
		
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		
		scanner.close();
		
		
		
	}

	
	
}
