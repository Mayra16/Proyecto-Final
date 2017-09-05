package com.micromercado.entity;

import java.util.Date;

public class Producto {

	private int c�digo;
	private Date fechaVencimiento;
	private String nombre;
	private double precio;
	private int c�digoCategor�a;
	private int stock;
	public Producto(int c�digo, Date fechaVencimiento, String nombre, double precio, int c�digoCategor�a, int stock) {
		super();
		this.c�digo = c�digo;
		this.fechaVencimiento = fechaVencimiento;
		this.nombre = nombre;
		this.precio = precio;
		this.c�digoCategor�a = c�digoCategor�a;
		this.stock = stock;
	}
	
	public Producto( Date fechaVencimiento, String nombre, double precio, int c�digoCategor�a, int stock) {
		super();
		this.fechaVencimiento = fechaVencimiento;
		this.nombre = nombre;
		this.precio = precio;
		this.c�digoCategor�a = c�digoCategor�a;
		this.stock = stock;
	}
	
	public Producto(int c�digo){
		this.c�digo = c�digo;
	}
	
	
	public int getC�digo() {
		return c�digo;
	}
	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getC�digoCategor�a() {
		return c�digoCategor�a;
	}
	public void setC�digoCategor�a(int c�digoCategor�a) {
		this.c�digoCategor�a = c�digoCategor�a;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Producto [c�digo=" + c�digo + ", fechaVencimiento=" + fechaVencimiento + ", nombre=" + nombre
				+ ", precio=" + precio + ", c�digoCategor�a=" + c�digoCategor�a + ", stock=" + stock + "]";
	}
	
	
	
}
