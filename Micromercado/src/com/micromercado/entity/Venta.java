
package com.micromercado.entity;

import java.util.Date;

public class Venta {
	private int c�digo;
	private Date fecha;
	private String NIT;
	
	public Venta(Date fecha,String NIT) {
		this.fecha = fecha;
		this.NIT = NIT;
	}
	public Venta(int c�digo,Date fecha,String NIT) {
		this.c�digo = c�digo;
		this.fecha = fecha;
		this.NIT = NIT;
	}
	
	public Venta(int c�digo) {
		this.c�digo = c�digo;
	}

	public int getC�digo() {
		return c�digo;
	}

	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String NIT) {
		this.NIT = NIT;
	}

	@Override
	public String toString() {
		return "Venta [c�digo=" + c�digo + ", fecha=" + fecha + ", NIT=" + NIT + "]";
	}
	
	

	
	
}
