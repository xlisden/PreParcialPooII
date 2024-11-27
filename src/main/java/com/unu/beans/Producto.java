package com.unu.beans;

public class Producto {

	private int idproducto;
	private String nombre;
	private int stock;
	private double precioVenta;

	public Producto() {
	}

	public Producto(int idproducto, String nombre, int stock, double precioVenta) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.stock = stock;
		this.precioVenta = precioVenta;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", nombre=" + nombre + ", stock=" + stock + ", precioVenta="
				+ precioVenta + "]";
	}

}
