package com.micromercado.entity;

public class Proveedores {

	private int código;
	private String nombre;
	private String dirección;//falla
	private int teléfono;//falla
	private String correoElectrónico;//falla
	
	public Proveedores(int código, String nombre, String dirección, int teléfono, String correoElectrónico) {
		
		this.código=código;
		this.nombre=nombre;
		this.dirección=dirección;
		this.teléfono=teléfono;
		this.correoElectrónico=correoElectrónico;
	}

	public Proveedores(String nombre, String dirección, int teléfono, String correoElectrónico){
		this.nombre=nombre;
		this.dirección=dirección;
		this.teléfono=teléfono;
		this.correoElectrónico=correoElectrónico;
	}
	

	public Proveedores(int código){
		
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

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public int getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
	}

	public String getCorreoElectrónico() {
		return correoElectrónico;
	}

	public void setCorreoElectrónico(String correoElectrónico) {
		this.correoElectrónico = correoElectrónico;
	}
	
	@Override
	public String toString() {
		return "proveedores [código = " +  código  +" "+ ", nombre = " +  nombre  +" "+ ", dirección = "+  dirección  +" "+", teléfono = "+  teléfono  +" "+", correo electrónico = "+  correoElectrónico  +"]";
	}



	
}
