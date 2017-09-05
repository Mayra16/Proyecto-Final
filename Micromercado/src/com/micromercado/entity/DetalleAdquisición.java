package com.micromercado.entity;

public class DetalleAdquisición {

	private int código;
	private int códigoProducto;//falla
	private int cantidad;
	private int códigoAdquisición;//falla
	
	public DetalleAdquisición(int código, int códigoProducto, int cantidad, int códigoAdquisición) {
		
		this.código=código;
		this.códigoProducto=códigoProducto;
		this.cantidad=cantidad;
		this.códigoAdquisición=códigoAdquisición;

	}
	
	public DetalleAdquisición(int códigoProducto, int cantidad, int códigoAdquisición){
		
		this.códigoProducto=códigoProducto;
		this.cantidad=cantidad;
		this.códigoAdquisición=códigoAdquisición;
	}
	

	public DetalleAdquisición(int código){
		
		this.código = código;
	}

	public int getCódigo() {
		return código;
	}

	public void setCódigo(int código) {
		this.código=código;
	}

	public int getCódigoProducto() {
		return códigoProducto;
	}

	public void setCódigoProducto(int códigoProducto) {
		this.códigoProducto=códigoProducto;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public int getCódigoAdquisición() {
		return códigoAdquisición;
	}

	public void setCódigoAdquisición(int códigoAdquisición) {
		this.códigoAdquisición=códigoAdquisición;

	}
	
	@Override
	public String toString() {
		return "detalleAdquisición [código = " +  código  +" "+", códigoProducto = " +  códigoProducto  +" "+ ", cantidad = "+  cantidad  +" "+", códigoAdquisición = "+  códigoAdquisición  +  "]";
	}

}
