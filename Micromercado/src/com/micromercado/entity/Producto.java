package com.micromercado.entity;

import java.util.Date;

public class Producto {

	private int código;
	private Date fechaVencimiento;
	private String nombre;
	private double precio;
	private int códigoCategoría;
	private int stock;
	public Producto(int código, Date fechaVencimiento, String nombre, double precio, int códigoCategoría, int stock) {
		super();
		this.código = código;
		this.fechaVencimiento = fechaVencimiento;
		this.nombre = nombre;
		this.precio = precio;
		this.códigoCategoría = códigoCategoría;
		this.stock = stock;
	}
	
	public Producto( Date fechaVencimiento, String nombre, double precio, int códigoCategoría, int stock) {
		super();
		this.fechaVencimiento = fechaVencimiento;
		this.nombre = nombre;
		this.precio = precio;
		this.códigoCategoría = códigoCategoría;
		this.stock = stock;
	}
	
	public Producto(int código){
		this.código = código;
	}
	
	
	public int getCódigo() {
		return código;
	}
	public void setCódigo(int código) {
		this.código = código;
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
	public int getCódigoCategoría() {
		return códigoCategoría;
	}
	public void setCódigoCategoría(int códigoCategoría) {
		this.códigoCategoría = códigoCategoría;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Producto [código=" + código + ", fechaVencimiento=" + fechaVencimiento + ", nombre=" + nombre
				+ ", precio=" + precio + ", códigoCategoría=" + códigoCategoría + ", stock=" + stock + "]";
	}
	
	
	
}
