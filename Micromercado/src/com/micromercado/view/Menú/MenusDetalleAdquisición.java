package com.micromercado.view.Men�;

import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.entity.DetalleAdquisici�n;
import com.micromercado.view.DetalleAdquisici�nView;
import com.micromercado.view.ReadTypes;

public class MenusDetalleAdquisici�n {

	
	//men�  
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("------------------- ");
				System.out.println("1. Ingresar detalle de adquisici�n");
				System.out.println("2. Buscar detalle de adquisici�n ");
				System.out.println("3. Listar detalle de adquisici�n");
				System.out.println("4. Actualizar detalle de adquisici�n ");
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
		DetalleAdquisici�nView detalleView = new DetalleAdquisici�nView(conexion,scanner);

		while (!salir) {
			switch (menu(scanner)) {
				case 1:
					MenusProducto.subMenuAdquisici�n(conexion, scanner);
					salir = true;
				break;
			case 2:
				int c�digo = ReadTypes.leerEntero(scanner, "Ingrese c�digo del detalle de Adquisici�n a buscar: ");
				detalleView.buscar(c�digo);
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
				System.out.println("Ingrese solo valores num�ricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	
	public static void menuModificar(Scanner scanner, DetalleAdquisici�n detalleAdquisici�n) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Cantidad anterior: ");
				System.out.println(detalleAdquisici�n.getCantidad());
				int cantidad = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de la cantidad: ");
				detalleAdquisici�n.setCantidad(cantidad);
				break;
			}
		}
	}

	
}
