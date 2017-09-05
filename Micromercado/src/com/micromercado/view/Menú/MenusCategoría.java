package com.micromercado.view.Men�;

import java.util.Scanner;

import com.micromercado.control.Categor�aCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Categor�a;
import com.micromercado.view.Categor�aView;
import com.micromercado.view.ProductoView;
import com.micromercado.view.ReadTypes;

public class MenusCategor�a {
	
	//men�  
		public static int menu(Scanner scanner) {

			int opcion;

			while (true) {
				try {
					System.out.println("------------------- ");
					System.out.println("1. Ingresar c�digo de la categor�a  ");
					System.out.println("2. Buscar categor�a ");
					System.out.println("3. Listar categor�a ");
					System.out.println("4. Actualizar categor�a ");
					System.out.println("5. Ingresar categor�a ");
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
			ProductoView productoView = new ProductoView(conexion,scanner);
			Categor�aView categor�aView = new Categor�aView(conexion,scanner);
			Categor�aCtrl categor�aCtrl = new Categor�aCtrl(conexion);
			
			while (!salir) {
				switch (menu(scanner)) {
				case 5:
					categor�aView.insertar();
					break;
				case 2:
					int c�digo = ReadTypes.leerEntero(scanner, "Ingrese c�digo del producto a buscar: ");
					Categor�a categor�a2 = new Categor�a(c�digo);
					categor�aCtrl.search(categor�a2);
					if ( categor�a2.getNombre() != null ){
					categor�aView.buscar(c�digo);
					break;
					}else {
						System.out.println("La categor�a no est� registrada");
						break;
					}
				case 3:
				categor�aView.listar();
					break;
				case 4:
					categor�aView.actualizar();
					break;
				case 1:
					int c�digoCategor�a = ReadTypes.leerEntero(scanner, "-");
					Categor�a categor�a = new Categor�a(c�digoCategor�a);
					categor�aCtrl.search(categor�a);
					
					if( categor�a.getNombre() != null){
					productoView.insertar(c�digoCategor�a);
					salir = true;
					break;
					}
					else{
						System.out.println("La categor�a no esta registrada");
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
				System.out.println("2. Actualizar Descripci�n");
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

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void menuModificar(Scanner scanner, Categor�a categor�a) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(categor�a.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				categor�a.setNombre(nombre);
				break;
			case 2:
				System.out.print("Descripci�n anterior: ");
				System.out.println(categor�a.getDescripci�n());
				String descripci�n = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de descripci�n: ");
				categor�a.setDescripci�n(descripci�n);
				break;
			}
		}
	}

}
