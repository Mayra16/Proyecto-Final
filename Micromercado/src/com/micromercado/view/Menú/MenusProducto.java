package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.ProductoCtrl;
import com.micromercado.entity.Producto;
import com.micromercado.view.DetalleAdquisiciónView;
import com.micromercado.view.DetalleVentaView;
import com.micromercado.view.ProductoView;
import com.micromercado.view.ReadTypes;

public class MenusProducto {

	//menú
		public static int menu(Scanner scanner) {

			int opcion;

			while (true) {
				try {
					System.out.println("------------------- ");
					System.out.println("1. Ingresar código del producto ");
					System.out.println("2. Buscar producto ");
					System.out.println("3. Listar productos");
					System.out.println("4. Actualizar producto ");
					System.out.println("5. Ingresar producto ");
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
		
		public static void subMenuVenta(Conexion conexion, Scanner scanner) throws Throwable {
			boolean salir = false;
			ProductoView productoView = new ProductoView(conexion, scanner);
			ProductoCtrl productoCtrl = new ProductoCtrl(conexion);
			
			while (!salir) {
				
				DetalleVentaView detalleView = new DetalleVentaView(conexion,scanner);
				int códigoProducto;
				int cantidad;
				switch (menu(scanner)) {
				case 0:
					salir = true;
					break;
					case 1:
						códigoProducto = ReadTypes.leerEntero(scanner, "Ingrese el código del producto: ");
						Producto producto = new Producto(códigoProducto);
						productoCtrl.search(producto);
						if ( producto.getNombre() != null ){
						cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
						detalleView.insertar(códigoProducto, cantidad);
						salir = true;
						break;
						}
						else {
							System.out.println("El producto no esta registrado");
							break;
						}
				case 2:
					int código = ReadTypes.leerEntero(scanner, "Ingrese código del producto a buscar: ");
					Producto producto2 = new Producto(código);
					productoCtrl.search(producto2);
					if(producto2.getNombre() != null){
					 productoView.buscar(código);
					break;
					} else{
						System.out.println("El producto no está registrado" );
						break;
					}
					
				case 3:
					 productoView.listar();
					break;
				case 4:
					 productoView.actualizar();
					break;
				case 5:
					MenusCategoría.subMenu(conexion, scanner);
					break;
					
				}
			}

		}

		public static void subMenuAdquisición(Conexion conexion, Scanner scanner) throws Throwable {
			boolean salir = false;
			ProductoView productoView = new ProductoView(conexion, scanner);
		

			while (!salir) {
				
				DetalleAdquisiciónView detalleView = new DetalleAdquisiciónView(conexion,scanner);
		
				int códigoProducto;
				int cantidad;
				switch (menu(scanner)) {
				case 0:
					salir = true;
					break;
					case 1:
						códigoProducto = ReadTypes.leerEntero(scanner, "Ingrese el código del producto: ");
						cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
						detalleView.insertar(códigoProducto, cantidad);
						salir = true;
						break;
				case 2:
					int código = ReadTypes.leerEntero(scanner, "Ingrese código del producto a buscar: ");
					 productoView.buscar(código);
					break;
				case 3:
					 productoView.listar();
					break;
				case 4:
					 productoView.actualizar();
					break;
				case 5:
				MenusCategoría.subMenu(conexion, scanner);
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
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar Precio Unitario");
				System.out.println("3. Actualizar Stock");
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
	public static void actualizar(Scanner scanner, Producto producto) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(producto.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor del nombre: ");
				producto.setNombre(nombre);
				break;
			}
		}
	}

	}
