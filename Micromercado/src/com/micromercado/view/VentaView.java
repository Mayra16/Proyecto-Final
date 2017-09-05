package com.micromercado.view;

import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.VentaCtrl;
import com.micromercado.entity.Venta;
import com.micromercado.view.Menú.MenusVenta;


public class VentaView {

	
	private Scanner scanner;
	private Venta Venta;
	private VentaCtrl VentaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public VentaView(Conexion conexion, Scanner scanner) {
		
		
		this.scanner = scanner;
		VentaCtrl = new  VentaCtrl(conexion);
		
	}
	/**
	 * @throws Throwable ********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar(String NIT) throws Throwable {
		Date fecha;
		
		fecha = new Date();
		Venta = new Venta(fecha,NIT);
		
		try {
			VentaCtrl.insert(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
			}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Venta> Ventas;

		try {
			Ventas = VentaCtrl.list();
			for (int i = 0; i < Ventas.size(); i++) {
				System.out.println(Ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int NIT) {
		Venta = new Venta(NIT);
		try {
			VentaCtrl.search(Venta);
			System.out.println(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
	int código;
		
		código = ReadTypes.leerEntero(scanner, "Ingrese el código de la Venta a modificar; ");
		Venta = new Venta(código);
		try {
			VentaCtrl.search(Venta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusVenta.menuModificar(scanner, Venta);

		try {
			VentaCtrl.update(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
