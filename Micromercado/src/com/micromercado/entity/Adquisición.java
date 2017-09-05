package com.micromercado.entity;

import java.util.Date;

public class Adquisición {

	private int código;
	private int códigoProveedor;
	private Date fechaPedido;
	private Date fechaEntrega;
	public Adquisición(int código, int códigoProveedor, Date fechaPedido, Date fechaEntrega) {
		super();
		this.código = código;
		this.códigoProveedor = códigoProveedor;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
	}
	public Adquisición(int códigoProveedor, Date fechaPedido, Date fechaEntrega) {
		super();
		this.códigoProveedor = códigoProveedor;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
	}
	public Adquisición(int código){
		this.código = código;
	}
	public int getCódigo() {
		return código;
	}
	public void setCódigo(int código) {
		this.código = código;
	}
	public int getCódigoProveedor() {
		return códigoProveedor;
	}
	public void setCódigoProveedor(int códigoProveedor) {
		this.códigoProveedor = códigoProveedor;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	@Override
	public String toString() {
		return "Adquisición [código=" + código + ", códigoProveedor=" + códigoProveedor + ", fechaPedido=" + fechaPedido
				+ ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	
	
}
