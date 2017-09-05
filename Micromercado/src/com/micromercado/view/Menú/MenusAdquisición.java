package com.micromercado.view.Menú;

import java.util.Date;
import java.util.Scanner;

import com.micromercado.entity.Adquisición;
import com.micromercado.view.ReadTypes;

public class MenusAdquisición {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Fecha");
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

	public static void menuModificar(Scanner scanner, Adquisición adquisición) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Fecha anterior: ");
				System.out.println(adquisición.getFechaEntrega());
				Date fechaEntrega = ReadTypes.leerFecha(scanner, "Ingrese el nuevo valor de Fecha de entrega: ");
				adquisición.setFechaEntrega(fechaEntrega);
				break;
			}
		}
	}
}
