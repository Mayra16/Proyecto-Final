package com.micromercado.entity;

public class Factura {

	private int c�digo;
	private String c�digoAutorizaci�n;
	
	public Factura (int c�digo, String c�digoAutorizaci�n) {
		super();
		this.c�digo = c�digo;
		this.c�digoAutorizaci�n = c�digoAutorizaci�n;
	}
	 public Factura(int c�digo){
		 super();
		  this.c�digo = c�digo;
	  }
	 public Factura(String c�digoAutorizaci�n){
		  this.c�digoAutorizaci�n = c�digoAutorizaci�n;
	  }
	public int getC�digo() {
		return c�digo;
	}
	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}
	public String getC�digoAutorizaci�n() {
		return c�digoAutorizaci�n;
	}
	public void setC�digoAutorizaci�n(String c�digoAutorizaci�n) {
		this.c�digoAutorizaci�n = c�digoAutorizaci�n;
	}
	@Override
	public String toString() {
		return "Factura [c�digo=" + c�digo + ", c�digoAutorizaci�n=" + c�digoAutorizaci�n + "]";
	}
	
	
	
}
