package com.micromercado.view.Menú;

import java.util.Scanner;

import com.micromercado.control.ClienteCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Cliente;
import com.micromercado.view.ClienteView;
import com.micromercado.view.ReadTypes;
import com.micromercado.view.VentaView;

public class MenusCliente {
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	//menú cliente 
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("------------------- ");
				System.out.println("1. Ingresar NIT ");
				System.out.println("2. Buscar cliente ");
				System.out.println("3. Listar clientes");
				System.out.println("4. Actualizar cliente ");
				System.out.println("5. Ingresar cliente ");
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
		ClienteView clienteView = new ClienteView(conexion, scanner);
		VentaView ventaView = new VentaView(conexion,scanner);
		ClienteCtrl clienteCtrl = new ClienteCtrl(conexion);
		
		while (!salir) {
			switch (menu(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				String NIT = ReadTypes.leerCadena(scanner, "-");
				Cliente cliente = new Cliente(NIT);
				clienteCtrl.search(cliente);
				if (cliente.getNombre() != null){
				ventaView.insertar(NIT);
				MenusDetalleVenta.subMenu(conexion, scanner);
				salir = true;
				break;
				}
				else{
					System.out.println("El cliente no está registrado ");
					break;
				}
			case 2:
				String código = ReadTypes.leerCadena(scanner, "Ingrese NIT a buscar: ");
				Cliente cliente2 = new Cliente(código);
				clienteCtrl.search(cliente2);
				if (cliente2.getNombre() != null){
				clienteView.buscar(código);
				break;
				} else { 
					System.out.println("El cliente no está registrado");
					break;
				}
				
			case 3:
			clienteView.listar();
				break;
			case 4:
				clienteView.actualizar();
				break;
			case 5:
				clienteView.insertar();
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
	public static void menuModificar(Scanner scanner, Cliente cliente) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(cliente.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				cliente.setNombre(nombre);
				break;
			}
		}
	}
}
