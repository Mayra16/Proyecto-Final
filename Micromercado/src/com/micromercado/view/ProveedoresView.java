package com.micromercado.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.ProveedoresCtrl;
import com.micromercado.entity.Proveedores;
import com.micromercado.view.Menú.MenusProveedores;

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
	String dirección;
	int teléfono;
	String correoElectrónico;
	
	nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre del proveedor: ");
	dirección = ReadTypes.leerCadena(scanner, "Ingrese la dirección: ");
	teléfono = ReadTypes.leerEntero(scanner, "Ingrese el teléfono: ");
	correoElectrónico = ReadTypes.leerCadena(scanner, "Ingrese el correo electrónico: ");
	
	proveedores = new Proveedores (nombre, dirección, teléfono, correoElectrónico);
	
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
	
	public void buscar(int código) {
		proveedores = new Proveedores(código);
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
		
		int código;
		//String nombre;
		//String dirección;
		//int teléfono;
		//String correoElectrónico;
		
		código = ReadTypes.leerEntero(scanner, "Ingrese el código del proveedor a modificar: ");
		
		proveedores =new Proveedores (código);
		
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
