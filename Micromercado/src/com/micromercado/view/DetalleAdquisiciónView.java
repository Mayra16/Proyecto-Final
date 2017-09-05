package com.micromercado.view;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.micromercado.control.Conexion;
import com.micromercado.control.DetalleAdquisiciónCtrl;
import com.micromercado.entity.DetalleAdquisición;
import com.micromercado.view.Menú.MenusDetalleAdquisición;


public class DetalleAdquisiciónView {

	private Scanner scanner;
	private DetalleAdquisición detalleAdquisición;
	private DetalleAdquisiciónCtrl detalleAdquisiciónCtrl;
	private Conexion conexion;

	public DetalleAdquisiciónView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
		detalleAdquisiciónCtrl = new DetalleAdquisiciónCtrl(conexion);	
	}

	public void insertar(int códigoProducto, int cantidad) throws Throwable {
	
	int códigoAdquisición;

	DetalleAdquisiciónView detalleView = new DetalleAdquisiciónView(conexion, scanner);
	
	códigoAdquisición = detalleView.getLastCódigo();
	
	detalleAdquisición = new DetalleAdquisición (códigoProducto, cantidad, códigoAdquisición);
	
	try {
		detalleAdquisiciónCtrl.insert(detalleAdquisición);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}

}

	public void listar() {
	ArrayList<DetalleAdquisición> detallesAdquisiciones;

	try {
		detallesAdquisiciones = detalleAdquisiciónCtrl.list();
		for (int i = 0; i < detallesAdquisiciones.size(); i++) {
			System.out.println(detallesAdquisiciones.get(i));
		}
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
}


	public void buscar(int código) {
	detalleAdquisición = new DetalleAdquisición(código);
	try {
		detalleAdquisiciónCtrl.search(detalleAdquisición);
		System.out.println(detalleAdquisición);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
}


	public void actualizar() {
		
	int código;
	código = ReadTypes.leerEntero(scanner, "Ingrese el código del detalle de adquisición a modificar: ");
	
	detalleAdquisición =new DetalleAdquisición (código);
	
	try {
		detalleAdquisiciónCtrl.search(detalleAdquisición);
	} catch (Throwable e1) {
		System.out.println(e1.getMessage());
	}

	MenusDetalleAdquisición.menuModificar(scanner, detalleAdquisición);

	try {
		detalleAdquisiciónCtrl.update(detalleAdquisición);
	} catch (Throwable e) {
		System.out.println(e.getMessage());
	}
}

	public int getLastCódigo() throws Throwable {

		ResultSet rs;
		int código = 0;

		conexion.SQL("SELECT código FROM Adquisición ORDER BY código DESC Limit 1 ");
		
		rs = conexion.resultSet();

		while (rs.next()) {

			código = rs.getInt("código");
			
		}

		rs.close();
		return código;
	}
	
}
