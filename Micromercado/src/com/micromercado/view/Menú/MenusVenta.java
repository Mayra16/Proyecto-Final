package com.micromercado.view.Menú;

import java.util.Date;
import java.util.Scanner;

import com.micromercado.entity.Venta;
import com.micromercado.view.ReadTypes;


public class MenusVenta {

	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Fecha");
				System.out.println("2. Actualizar NIT");
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

	public static void menuModificar(Scanner scanner, Venta venta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Fecha anterior: ");
				System.out.println(venta.getFecha());
				Date Fecha = ReadTypes.leerFecha(scanner, "Ingrese el nuevo valor de Fecha: ");
				venta.setFecha(Fecha);
				break;
			case 2:
				System.out.print("NIT anterior: ");
				System.out.println(venta.getNIT());
				String NIT = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de NIT: ");
				venta.setNIT(NIT);
				break;
			}
		}
	}
}
