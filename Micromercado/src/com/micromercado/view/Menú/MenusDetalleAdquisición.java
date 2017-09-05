package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.entity.DetalleAdquisición;
import com.micromercado.view.DetalleAdquisiciónView;
import com.micromercado.view.ReadTypes;

public class MenusDetalleAdquisición {

	
	//menú  
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("------------------- ");
				System.out.println("1. Ingresar detalle de adquisición");
				System.out.println("2. Buscar detalle de adquisición ");
				System.out.println("3. Listar detalle de adquisición");
				System.out.println("4. Actualizar detalle de adquisición ");
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
		DetalleAdquisiciónView detalleView = new DetalleAdquisiciónView(conexion,scanner);

		while (!salir) {
			switch (menu(scanner)) {
				case 1:
					MenusProducto.subMenuAdquisición(conexion, scanner);
					salir = true;
				break;
			case 2:
				int código = ReadTypes.leerEntero(scanner, "Ingrese código del detalle de Adquisición a buscar: ");
				detalleView.buscar(código);
				break;
			case 3:
				detalleView.listar();
				break;
			case 4:
				detalleView.actualizar();
				break;
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
				System.out.println("1. Actualizar Cantidad");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	
	public static void menuModificar(Scanner scanner, DetalleAdquisición detalleAdquisición) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Cantidad anterior: ");
				System.out.println(detalleAdquisición.getCantidad());
				int cantidad = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de la cantidad: ");
				detalleAdquisición.setCantidad(cantidad);
				break;
			}
		}
	}

	
}
