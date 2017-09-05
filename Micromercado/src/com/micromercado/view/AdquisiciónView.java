package com.micromercado.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.micromercado.control.AdquisiciónCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Adquisición;
import com.micromercado.view.Menú.MenusAdquisición;

public class AdquisiciónView {

	//private static Conexion Conexion = null;
	private Scanner scanner;
	private Adquisición Adquisición;
	private AdquisiciónCtrl AdquisiciónCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public AdquisiciónView(Conexion conexion, Scanner scanner) {
		
		this.scanner = scanner;
		AdquisiciónCtrl = new  AdquisiciónCtrl(conexion);
		
	}
	/**
	 * @throws Throwable ********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar(int códigoProveedor) throws Throwable {
		Date fechaPedido;
		Date fechaEntrega;
		fechaPedido = ReadTypes.leerFecha(scanner, "Ingrese la fecha de pedido: ");
		fechaEntrega = ReadTypes.leerFecha(scanner, "Ingrese la fecha de entrega: ");

		Adquisición = new Adquisición(códigoProveedor, fechaPedido,fechaEntrega);
		
		try {
			AdquisiciónCtrl.insert(Adquisición);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Adquisición> Adquisición;

		try {
			Adquisición = AdquisiciónCtrl.list();
			for (int i = 0; i < Adquisición.size(); i++) {
				System.out.println(Adquisición.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int código) {
		Adquisición = new Adquisición(código);
		try {
			AdquisiciónCtrl.search(Adquisición);
			System.out.println(Adquisición);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
	int código;
		
		código = ReadTypes.leerEntero(scanner, "Ingrese el código de la adquisición a modificar; ");
		Adquisición = new Adquisición(código);
		try {
			AdquisiciónCtrl.search(Adquisición);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusAdquisición.menuModificar(scanner, Adquisición);

		try {
			AdquisiciónCtrl.update(Adquisición);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
