package com.micromercado.entity;

public class DetalleAdquisici�n {

	private int c�digo;
	private int c�digoProducto;//falla
	private int cantidad;
	private int c�digoAdquisici�n;//falla
	
	public DetalleAdquisici�n(int c�digo, int c�digoProducto, int cantidad, int c�digoAdquisici�n) {
		
		this.c�digo=c�digo;
		this.c�digoProducto=c�digoProducto;
		this.cantidad=cantidad;
		this.c�digoAdquisici�n=c�digoAdquisici�n;

	}
	
	public DetalleAdquisici�n(int c�digoProducto, int cantidad, int c�digoAdquisici�n){
		
		this.c�digoProducto=c�digoProducto;
		this.cantidad=cantidad;
		this.c�digoAdquisici�n=c�digoAdquisici�n;
	}
	

	public DetalleAdquisici�n(int c�digo){
		
		this.c�digo = c�digo;
	}

	public int getC�digo() {
		return c�digo;
	}

	public void setC�digo(int c�digo) {
		this.c�digo=c�digo;
	}

	public int getC�digoProducto() {
		return c�digoProducto;
	}

	public void setC�digoProducto(int c�digoProducto) {
		this.c�digoProducto=c�digoProducto;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public int getC�digoAdquisici�n() {
		return c�digoAdquisici�n;
	}

	public void setC�digoAdquisici�n(int c�digoAdquisici�n) {
		this.c�digoAdquisici�n=c�digoAdquisici�n;

	}
	
	@Override
	public String toString() {
		return "detalleAdquisici�n [c�digo = " +  c�digo  +" "+", c�digoProducto = " +  c�digoProducto  +" "+ ", cantidad = "+  cantidad  +" "+", c�digoAdquisici�n = "+  c�digoAdquisici�n  +  "]";
	}

}
