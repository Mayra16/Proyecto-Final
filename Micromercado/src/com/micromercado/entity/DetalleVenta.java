package com.micromercado.entity;

public class DetalleVenta {
	
	private int código;
	private int códigoProducto;
	private int cantidad;
	private int códigoVenta;
	
	public DetalleVenta (int códigoProducto, int cantidad, int códigoVenta) {
		super();
		this.códigoProducto = códigoProducto;
		this.cantidad = cantidad;
		this.códigoVenta = códigoVenta;
	}
	
	public DetalleVenta (int código, int códigoProducto, int cantidad, int códigoVenta) {
		super();
		this.código = código;
		this.códigoProducto = códigoProducto;
		this.cantidad = cantidad;
		this.códigoVenta = códigoVenta;
	}
	
	
	public DetalleVenta(int código){
		this.código = código;
	}
	public int getCódigo() {
		return código;
	}
	public void setCódigo(int código) {
		this.código = código;
	}
	public int getCódigoProducto() {
		return códigoProducto;
	}
	public void setCódigoProducto(int códigoProducto) {
		this.códigoProducto = códigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCódigoVenta() {
		return códigoVenta;
	}
	public void setCódigoVenta(int códigoVenta) {
		this.códigoVenta = códigoVenta;
	}
	@Override
	public String toString() {
		return "DetalleVenta [código=" + código + ", códigoProducto=" + códigoProducto + ", cantidad=" + cantidad
				+ ", códigoVenta=" + códigoVenta + "]";
	}
	
	

}
