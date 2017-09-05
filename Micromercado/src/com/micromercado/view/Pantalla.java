package com.micromercado.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.view.Men�.Principal;

public class Pantalla {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		ClienteView clienteView = new ClienteView(conexion,scanner);
		VentaView ventaView = new VentaView(conexion,scanner);
		DetalleVentaView detalleView = new DetalleVentaView(conexion,scanner);
		ProductoView productoView = new ProductoView(conexion,scanner);
		Categor�aView categor�aView = new Categor�aView(conexion, scanner);
		Adquisici�nView adquisici�nView = new Adquisici�nView(conexion, scanner);
		DetalleAdquisici�nView detalleAdquisici�nView = new DetalleAdquisici�nView(conexion, scanner);
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
		//categor�aView.listar();
		//categor�aView.buscar(1);
		//categor�aView.insertar();
		//categor�aView.actualizar();
		
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
		
		
		/*adquisici�nView.listar();
		adquisici�nView.buscar(2);
		adquisici�nView.insertar();
		adquisici�nView.actualizar();*/
		
		//MenusVenta menu = new MenusVenta();
		//menu.menu(scanner);
		
		/*detalleAdquisici�nView.listar();
		detalleAdquisici�nView.buscar(2);
		detalleAdquisici�nView.actualizar();*/
		
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
