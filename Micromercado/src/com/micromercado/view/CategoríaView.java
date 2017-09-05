package com.micromercado.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.Categor�aCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Categor�a;
import com.micromercado.view.Men�.MenusCategor�a;

public class Categor�aView {
	private Scanner scanner;
	private Categor�a categor�a;
	private Categor�aCtrl categor�aCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public Categor�aView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		categor�aCtrl = new  Categor�aCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		String descripci�n;
		String nombre;

		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		descripci�n = ReadTypes.leerCadena(scanner, "Ingrese la descripci�n: ");
		
		categor�a = new Categor�a(nombre, descripci�n);
		
		try {
			categor�aCtrl.insert(categor�a);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Categor�a> categor�as;

		try {
			categor�as = categor�aCtrl.list();
			for (int i = 0; i < categor�as.size(); i++) {
				System.out.println(categor�as.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int c�digo) {
		categor�a = new Categor�a(c�digo);
		try {
			categor�aCtrl.search(categor�a);
			System.out.println(categor�a);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int c�digo;
		
		c�digo = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de la categor�a a modificar; ");
		categor�a = new Categor�a(c�digo);
		try {
			categor�aCtrl.search(categor�a);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCategor�a.menuModificar(scanner, categor�a);

		try {
			categor�aCtrl.update(categor�a);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
