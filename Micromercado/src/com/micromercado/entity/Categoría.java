package com.micromercado.entity;

public class Categoría {

	private int código;
	private String nombre;
	private String descripción;
	public Categoría(int código, String nombre, String descripción) {
		super();
		this.código = código;
		this.nombre = nombre;
		this.descripción = descripción;
	}
	public Categoría(String nombre, String descripción){
		this.nombre= nombre;
		this.descripción = descripción;
	}
	
	public Categoría( int código){
		this.código = código;
	}
	public int getCódigo() {
		return código;
	}
	public void setCódigo(int código) {
		this.código = código;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	@Override
	public String toString() {
		return "Categoría [código=" + código + ", nombre=" + nombre + ", descripción=" + descripción + "]";
	}
	
	
	
}
