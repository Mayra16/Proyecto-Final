package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.CategoríaCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Categoría;
import com.micromercado.view.CategoríaView;
import com.micromercado.view.ProductoView;
import com.micromercado.view.ReadTypes;

public class MenusCategoría {
	
	//menú  
		public static int menu(Scanner scanner) {

			int opcion;

			while (true) {
				try {
					System.out.println("------------------- ");
					System.out.println("1. Ingresar código de la categoría  ");
					System.out.println("2. Buscar categoría ");
					System.out.println("3. Listar categoría ");
					System.out.println("4. Actualizar categoría ");
					System.out.println("5. Ingresar categoría ");
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
			ProductoView productoView = new ProductoView(conexion,scanner);
			CategoríaView categoríaView = new CategoríaView(conexion,scanner);
			CategoríaCtrl categoríaCtrl = new CategoríaCtrl(conexion);
			
			while (!salir) {
				switch (menu(scanner)) {
				case 5:
					categoríaView.insertar();
					break;
				case 2:
					int código = ReadTypes.leerEntero(scanner, "Ingrese código del producto a buscar: ");
					Categoría categoría2 = new Categoría(código);
					categoríaCtrl.search(categoría2);
					if ( categoría2.getNombre() != null ){
					categoríaView.buscar(código);
					break;
					}else {
						System.out.println("La categoría no está registrada");
						break;
					}
				case 3:
				categoríaView.listar();
					break;
				case 4:
					categoríaView.actualizar();
					break;
				case 1:
					int códigoCategoría = ReadTypes.leerEntero(scanner, "-");
					Categoría categoría = new Categoría(códigoCategoría);
					categoríaCtrl.search(categoría);
					
					if( categoría.getNombre() != null){
					productoView.insertar(códigoCategoría);
					salir = true;
					break;
					}
					else{
						System.out.println("La categoría no esta registrada");
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
				System.out.println("2. Actualizar Descripción");
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

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void menuModificar(Scanner scanner, Categoría categoría) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(categoría.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				categoría.setNombre(nombre);
				break;
			case 2:
				System.out.print("Descripción anterior: ");
				System.out.println(categoría.getDescripción());
				String descripción = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de descripción: ");
				categoría.setDescripción(descripción);
				break;
			}
		}
	}

}
