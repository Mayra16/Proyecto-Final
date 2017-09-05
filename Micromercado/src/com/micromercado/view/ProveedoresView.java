package com.micromercado.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.ProveedoresCtrl;
import com.micromercado.entity.Proveedores;
import com.micromercado.view.Men�.MenusProveedores;

public class ProveedoresView {
	
	private Scanner scanner;
	private Proveedores proveedores;
	private ProveedoresCtrl proveedoresCtrl;
	

	public ProveedoresView(Conexion conexion, Scanner scanner) {
		
		this.scanner = scanner;
		proveedoresCtrl = new ProveedoresCtrl(conexion);	
	}

	public void insertar() {
	
	String nombre;
	String direcci�n;
	int tel�fono;
	String correoElectr�nico;
	
	nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre del proveedor: ");
	direcci�n = ReadTypes.leerCadena(scanner, "Ingrese la direcci�n: ");
	tel�fono = ReadTypes.leerEntero(scanner, "Ingrese el tel�fono: ");
	correoElectr�nico = ReadTypes.leerCadena(scanner, "Ingrese el correo electr�nico: ");
	
	proveedores = new Proveedores (nombre, direcci�n, tel�fono, correoElectr�nico);
	
	try {
		proveedoresCtrl.insert(proveedores);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
	}
	
	public void listar() {
		ArrayList<Proveedores> proveedores;

		try {
			proveedores = proveedoresCtrl.list();
			for (int i = 0; i < proveedores.size(); i++) {
				System.out.println(proveedores.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void buscar(int c�digo) {
		proveedores = new Proveedores(c�digo);
		try {
			proveedoresCtrl.search(proveedores);
			if (proveedores.getNombre() != null){
				System.out.println(proveedores);
			}
			else{
				System.out.println("No existe el Proveedor");
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizar() {
		
		int c�digo;
		//String nombre;
		//String direcci�n;
		//int tel�fono;
		//String correoElectr�nico;
		
		c�digo = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del proveedor a modificar: ");
		
		proveedores =new Proveedores (c�digo);
		
		try {
			proveedoresCtrl.search(proveedores);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusProveedores.menuModificar(scanner, proveedores);

		try {
			proveedoresCtrl.update(proveedores);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	

}
