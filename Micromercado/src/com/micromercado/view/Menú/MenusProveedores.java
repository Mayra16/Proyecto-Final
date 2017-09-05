package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.ProveedoresCtrl;
import com.micromercado.entity.Proveedores;
import com.micromercado.view.AdquisiciónView;
import com.micromercado.view.ProveedoresView;
import com.micromercado.view.ReadTypes;

public class MenusProveedores {

	//menú cliente 
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("------------------- ");
				System.out.println("1. Ingresar código del proveedor ");
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
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	
	public static void subMenu(Conexion conexion, Scanner scanner) throws Throwable {
		boolean salir = false;
		ProveedoresView proveedorView = new ProveedoresView(conexion, scanner);
		AdquisiciónView AdquisiciónView = new AdquisiciónView(conexion,scanner);
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
				int código = ReadTypes.leerEntero(scanner, "Ingrese código del proveedor a buscar: ");
				Proveedores proveedor2 = new Proveedores(código);
				control.search(proveedor2);
				if (proveedor2.getNombre() != null){
				proveedorView.buscar(código);
				break;
				} else {
					System.out.println("El proveedor no está registrado");
					break;
				}
			case 3:
				proveedorView.listar();
				break;
			case 4:
				proveedorView.actualizar();
				break;
			case 1:
				
				int códigoProveedor = ReadTypes.leerEntero(scanner, "Ingrese el código de proveedor: ");
				Proveedores proveedor = new Proveedores(códigoProveedor);
				control.search(proveedor);
				
				if( proveedor.getNombre() != null  ){
				AdquisiciónView.insertar(códigoProveedor);
				MenusDetalleAdquisición.subMenu(conexion, scanner);
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
				System.out.println("2. Actualizar Dirección");
				System.out.println("3. Actualizar Teléfono");
				System.out.println("4. Actualizar Correo Electrónico");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 5) {//
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
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
				System.out.print("Dirección anterior: ");
				System.out.println(proveedores.getDirección());
				String dirección = ReadTypes.leerCadena(scanner, "Ingrese la nueva dirección: ");
				proveedores.setDirección(dirección);
				break;
			case 3:
				System.out.print("Teléfono anterior: ");
				System.out.println(proveedores.getTeléfono());
				int teléfono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo teléfono: ");
				proveedores.setTeléfono(teléfono);
				break;
			case 4:
				System.out.print("Correo Electrónico anterior: ");
				System.out.println(proveedores.getCorreoElectrónico());
				String correoElectrónico = ReadTypes.leerCadena(scanner, "Ingrese el nuevo correo electrónico : ");
				proveedores.setCorreoElectrónico(correoElectrónico);
				break;
			}
		}
	}

	
}
