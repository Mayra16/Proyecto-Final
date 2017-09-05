package com.micromercado.entity;

import java.util.Date;

public class Adquisici�n {

	private int c�digo;
	private int c�digoProveedor;
	private Date fechaPedido;
	private Date fechaEntrega;
	public Adquisici�n(int c�digo, int c�digoProveedor, Date fechaPedido, Date fechaEntrega) {
		super();
		this.c�digo = c�digo;
		this.c�digoProveedor = c�digoProveedor;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
	}
	public Adquisici�n(int c�digoProveedor, Date fechaPedido, Date fechaEntrega) {
		super();
		this.c�digoProveedor = c�digoProveedor;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
	}
	public Adquisici�n(int c�digo){
		this.c�digo = c�digo;
	}
	public int getC�digo() {
		return c�digo;
	}
	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}
	public int getC�digoProveedor() {
		return c�digoProveedor;
	}
	public void setC�digoProveedor(int c�digoProveedor) {
		this.c�digoProveedor = c�digoProveedor;
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
		return "Adquisici�n [c�digo=" + c�digo + ", c�digoProveedor=" + c�digoProveedor + ", fechaPedido=" + fechaPedido
				+ ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	
	
}
