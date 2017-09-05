package com.micromercado.entity;

public class Proveedores {

	private int c�digo;
	private String nombre;
	private String direcci�n;//falla
	private int tel�fono;//falla
	private String correoElectr�nico;//falla
	
	public Proveedores(int c�digo, String nombre, String direcci�n, int tel�fono, String correoElectr�nico) {
		
		this.c�digo=c�digo;
		this.nombre=nombre;
		this.direcci�n=direcci�n;
		this.tel�fono=tel�fono;
		this.correoElectr�nico=correoElectr�nico;
	}

	public Proveedores(String nombre, String direcci�n, int tel�fono, String correoElectr�nico){
		this.nombre=nombre;
		this.direcci�n=direcci�n;
		this.tel�fono=tel�fono;
		this.correoElectr�nico=correoElectr�nico;
	}
	

	public Proveedores(int c�digo){
		
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

	public String getDirecci�n() {
		return direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}

	public int getTel�fono() {
		return tel�fono;
	}

	public void setTel�fono(int tel�fono) {
		this.tel�fono = tel�fono;
	}

	public String getCorreoElectr�nico() {
		return correoElectr�nico;
	}

	public void setCorreoElectr�nico(String correoElectr�nico) {
		this.correoElectr�nico = correoElectr�nico;
	}
	
	@Override
	public String toString() {
		return "proveedores [c�digo = " +  c�digo  +" "+ ", nombre = " +  nombre  +" "+ ", direcci�n = "+  direcci�n  +" "+", tel�fono = "+  tel�fono  +" "+", correo electr�nico = "+  correoElectr�nico  +"]";
	}



	
}
