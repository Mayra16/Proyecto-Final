package com.micromercado.entity;

public class Factura {

	private int código;
	private String códigoAutorización;
	
	public Factura (int código, String códigoAutorización) {
		super();
		this.código = código;
		this.códigoAutorización = códigoAutorización;
	}
	 public Factura(int código){
		 super();
		  this.código = código;
	  }
	 public Factura(String códigoAutorización){
		  this.códigoAutorización = códigoAutorización;
	  }
	public int getCódigo() {
		return código;
	}
	public void setCódigo(int código) {
		this.código = código;
	}
	public String getCódigoAutorización() {
		return códigoAutorización;
	}
	public void setCódigoAutorización(String códigoAutorización) {
		this.códigoAutorización = códigoAutorización;
	}
	@Override
	public String toString() {
		return "Factura [código=" + código + ", códigoAutorización=" + códigoAutorización + "]";
	}
	
	
	
}
