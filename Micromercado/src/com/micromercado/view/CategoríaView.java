package com.micromercado.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.CategoríaCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Categoría;
import com.micromercado.view.Menú.MenusCategoría;

public class CategoríaView {
	private Scanner scanner;
	private Categoría categoría;
	private CategoríaCtrl categoríaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public CategoríaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		categoríaCtrl = new  CategoríaCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		String descripción;
		String nombre;

		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		descripción = ReadTypes.leerCadena(scanner, "Ingrese la descripción: ");
		
		categoría = new Categoría(nombre, descripción);
		
		try {
			categoríaCtrl.insert(categoría);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Categoría> categorías;

		try {
			categorías = categoríaCtrl.list();
			for (int i = 0; i < categorías.size(); i++) {
				System.out.println(categorías.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int código) {
		categoría = new Categoría(código);
		try {
			categoríaCtrl.search(categoría);
			System.out.println(categoría);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int código;
		
		código = ReadTypes.leerEntero(scanner, "Ingrese el código de la categoría a modificar; ");
		categoría = new Categoría(código);
		try {
			categoríaCtrl.search(categoría);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCategoría.menuModificar(scanner, categoría);

		try {
			categoríaCtrl.update(categoría);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
