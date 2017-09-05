package com.micromercado.view.Men�;

import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.ProveedoresCtrl;
import com.micromercado.entity.Proveedores;
import com.micromercado.view.Adquisici�nView;
import com.micromercado.view.ProveedoresView;
import com.micromercado.view.ReadTypes;

public class MenusProveedores {

	//men� cliente 
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("------------------- ");
				System.out.println("1. Ingresar c�digo del proveedor ");
				System.out.println("2. Buscar proveedor ");
				System.out.println("3. Listar proveedores");
				System.out.println("4. Actualizar proveedor ");
				System.out.println("5. Ingresar proveedor ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 6) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores num�ricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	
	public static void subMenu(Conexion conexion, Scanner scanner) throws Throwable {
		boolean salir = false;
		ProveedoresView proveedorView = new ProveedoresView(conexion, scanner);
		Adquisici�nView Adquisici�nView = new Adquisici�nView(conexion,scanner);
		ProveedoresCtrl control = new ProveedoresCtrl(conexion);
		
		while (!salir) {
			switch (menu(scanner)) {
			case 0:
				salir = true;
				break;
			case 5:
				proveedorView.insertar();
				break;
			case 2:
				int c�digo = ReadTypes.leerEntero(scanner, "Ingrese c�digo del proveedor a buscar: ");
				Proveedores proveedor2 = new Proveedores(c�digo);
				control.search(proveedor2);
				if (proveedor2.getNombre() != null){
				proveedorView.buscar(c�digo);
				break;
				} else {
					System.out.println("El proveedor no est� registrado");
					break;
				}
			case 3:
				proveedorView.listar();
				break;
			case 4:
				proveedorView.actualizar();
				break;
			case 1:
				
				int c�digoProveedor = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de proveedor: ");
				Proveedores proveedor = new Proveedores(c�digoProveedor);
				control.search(proveedor);
				
				if( proveedor.getNombre() != null  ){
				Adquisici�nView.insertar(c�digoProveedor);
				MenusDetalleAdquisici�n.subMenu(conexion, scanner);
				salir = true;
				break;
				}
				else { System.out.println("El proveedor no esta registrado");
				break;
				}
				}
			}
		}

	

	
	
	// actualizar
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar Direcci�n");
				System.out.println("3. Actualizar Tel�fono");
				System.out.println("4. Actualizar Correo Electr�nico");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 5) {//
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores num�ricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	
	public static void menuModificar(Scanner scanner, Proveedores proveedores) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(proveedores.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				proveedores.setNombre(nombre);
				break;
			case 2:
				System.out.print("Direcci�n anterior: ");
				System.out.println(proveedores.getDirecci�n());
				String direcci�n = ReadTypes.leerCadena(scanner, "Ingrese la nueva direcci�n: ");
				proveedores.setDirecci�n(direcci�n);
				break;
			case 3:
				System.out.print("Tel�fono anterior: ");
				System.out.println(proveedores.getTel�fono());
				int tel�fono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo tel�fono: ");
				proveedores.setTel�fono(tel�fono);
				break;
			case 4:
				System.out.print("Correo Electr�nico anterior: ");
				System.out.println(proveedores.getCorreoElectr�nico());
				String correoElectr�nico = ReadTypes.leerCadena(scanner, "Ingrese el nuevo correo electr�nico : ");
				proveedores.setCorreoElectr�nico(correoElectr�nico);
				break;
			}
		}
	}

	
}
