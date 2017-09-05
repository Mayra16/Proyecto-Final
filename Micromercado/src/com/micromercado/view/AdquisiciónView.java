package com.micromercado.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.micromercado.control.Adquisici�nCtrl;
import com.micromercado.control.Conexion;
import com.micromercado.entity.Adquisici�n;
import com.micromercado.view.Men�.MenusAdquisici�n;

public class Adquisici�nView {

	//private static Conexion Conexion = null;
	private Scanner scanner;
	private Adquisici�n Adquisici�n;
	private Adquisici�nCtrl Adquisici�nCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public Adquisici�nView(Conexion conexion, Scanner scanner) {
		
		this.scanner = scanner;
		Adquisici�nCtrl = new  Adquisici�nCtrl(conexion);
		
	}
	/**
	 * @throws Throwable ********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar(int c�digoProveedor) throws Throwable {
		Date fechaPedido;
		Date fechaEntrega;
		fechaPedido = ReadTypes.leerFecha(scanner, "Ingrese la fecha de pedido: ");
		fechaEntrega = ReadTypes.leerFecha(scanner, "Ingrese la fecha de entrega: ");

		Adquisici�n = new Adquisici�n(c�digoProveedor, fechaPedido,fechaEntrega);
		
		try {
			Adquisici�nCtrl.insert(Adquisici�n);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Adquisici�n> Adquisici�n;

		try {
			Adquisici�n = Adquisici�nCtrl.list();
			for (int i = 0; i < Adquisici�n.size(); i++) {
				System.out.println(Adquisici�n.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int c�digo) {
		Adquisici�n = new Adquisici�n(c�digo);
		try {
			Adquisici�nCtrl.search(Adquisici�n);
			System.out.println(Adquisici�n);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
	int c�digo;
		
		c�digo = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de la adquisici�n a modificar; ");
		Adquisici�n = new Adquisici�n(c�digo);
		try {
			Adquisici�nCtrl.search(Adquisici�n);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusAdquisici�n.menuModificar(scanner, Adquisici�n);

		try {
			Adquisici�nCtrl.update(Adquisici�n);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
