package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.entity.DetalleVenta;
import com.micromercado.view.DetalleVentaView;
import com.micromercado.view.ReadTypes;

public class MenusDetalleVenta {
	
	//menú 
			public static int menu(Scanner scanner) {

				int opcion;

				while (true) {
					try {
						System.out.println("------------------- ");
						System.out.println("1. Ingresar detalle de venta");
						System.out.println("2. Buscar detalle de venta ");
						System.out.println("3. Listar detalle de venta");
						System.out.println("4. Actualizar detalle de venta ");
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
				DetalleVentaView detalleView = new DetalleVentaView(conexion,scanner);

				while (!salir) {
					switch (menu(scanner)) {
						case 1:
							MenusProducto.subMenuVenta(conexion, scanner);
							salir = true;
						break;
					case 2:
						int código = ReadTypes.leerEntero(scanner, "Ingrese código del detalle de venta a buscar: ");
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

	public static void menuModificar(Scanner scanner, DetalleVenta detalleVenta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Cantidad anterior: ");
				System.out.println(detalleVenta.getCantidad());
				int cantidad= ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de cantidad: ");
				detalleVenta.setCantidad(cantidad);
				break;
			}
		}
	}

}
