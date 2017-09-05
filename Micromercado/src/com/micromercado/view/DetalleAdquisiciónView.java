package com.micromercado.view;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.DetalleAdquisici�nCtrl;
import com.micromercado.entity.DetalleAdquisici�n;
import com.micromercado.view.Men�.MenusDetalleAdquisici�n;


public class DetalleAdquisici�nView {

	private Scanner scanner;
	private DetalleAdquisici�n detalleAdquisici�n;
	private DetalleAdquisici�nCtrl detalleAdquisici�nCtrl;
	private Conexion conexion;

	public DetalleAdquisici�nView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
		detalleAdquisici�nCtrl = new DetalleAdquisici�nCtrl(conexion);	
	}

	public void insertar(int c�digoProducto, int cantidad) throws Throwable {
	
	int c�digoAdquisici�n;

	DetalleAdquisici�nView detalleView = new DetalleAdquisici�nView(conexion, scanner);
	
	c�digoAdquisici�n = detalleView.getLastC�digo();
	
	detalleAdquisici�n = new DetalleAdquisici�n (c�digoProducto, cantidad, c�digoAdquisici�n);
	
	try {
		detalleAdquisici�nCtrl.insert(detalleAdquisici�n);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}

}

	public void listar() {
	ArrayList<DetalleAdquisici�n> detallesAdquisiciones;

	try {
		detallesAdquisiciones = detalleAdquisici�nCtrl.list();
		for (int i = 0; i < detallesAdquisiciones.size(); i++) {
			System.out.println(detallesAdquisiciones.get(i));
		}
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
}


	public void buscar(int c�digo) {
	detalleAdquisici�n = new DetalleAdquisici�n(c�digo);
	try {
		detalleAdquisici�nCtrl.search(detalleAdquisici�n);
		System.out.println(detalleAdquisici�n);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
}


	public void actualizar() {
		
	int c�digo;
	c�digo = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del detalle de adquisici�n a modificar: ");
	
	detalleAdquisici�n =new DetalleAdquisici�n (c�digo);
	
	try {
		detalleAdquisici�nCtrl.search(detalleAdquisici�n);
	} catch (Throwable e1) {
		System.out.println(e1.getMessage());
	}

	MenusDetalleAdquisici�n.menuModificar(scanner, detalleAdquisici�n);

	try {
		detalleAdquisici�nCtrl.update(detalleAdquisici�n);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
}

	public int getLastC�digo() throws Throwable {

		ResultSet rs;
		int c�digo = 0;

		conexion.SQL("SELECT c�digo FROM Adquisici�n ORDER BY c�digo DESC Limit 1 ");
		
		rs = conexion.resultSet();

		while (rs.next()) {

			c�digo = rs.getInt("c�digo");
			
		}

		rs.close();
		return c�digo;
	}
	
}
