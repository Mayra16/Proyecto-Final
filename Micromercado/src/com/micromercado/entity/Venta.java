
package com.micromercado.entity;

import java.util.Date;

public class Venta {
	private int código;
	private Date fecha;
	private String NIT;
	
	public Venta(Date fecha,String NIT) {
		this.fecha = fecha;
		this.NIT = NIT;
	}
	public Venta(int código,Date fecha,String NIT) {
		this.código = código;
		this.fecha = fecha;
		this.NIT = NIT;
	}
	
	public Venta(int código) {
		this.código = código;
	}

	public int getCódigo() {
		return código;
	}

	public void setCódigo(int código) {
		this.código = código;
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
		return "Venta [código=" + código + ", fecha=" + fecha + ", NIT=" + NIT + "]";
	}
	
	

	
	
}
