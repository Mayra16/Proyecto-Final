package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.Conexion;

public class Principal {

	public static int menu(Scanner scanner) {
		
		
		int opcion;
		
		
		

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar Venta: " );
				System.out.println("2. Ingresar Adquisición: " );
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

	public static void subMenu(Conexion conexion, Scanner scanner) throws Throwable {
		boolean salir = false;
		
		
		while (!salir) {
			switch (menu(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				MenusCliente.subMenu(conexion, scanner);
				break;
			case 2:
				MenusProveedores.subMenu(conexion, scanner);
				break;

			}
		}
	}
}