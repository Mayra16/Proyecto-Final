package com.micromercado.entity;

public class Categor�a {

	private int c�digo;
	private String nombre;
	private String descripci�n;
	public Categor�a(int c�digo, String nombre, String descripci�n) {
		super();
		this.c�digo = c�digo;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
	}
	public Categor�a(String nombre, String descripci�n){
		this.nombre= nombre;
		this.descripci�n = descripci�n;
	}
	
	public Categor�a( int c�digo){
		this.c�digo = c�digo;
	}
	public int getC�digo() {
		return c�digo;
	}
	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripci�n() {
		return descripci�n;
	}
	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}
	@Override
	public String toString() {
		return "Categor�a [c�digo=" + c�digo + ", nombre=" + nombre + ", descripci�n=" + descripci�n + "]";
	}
	
	
	
}
