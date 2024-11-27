package com.unu.beans;

public class Proveedor {

	private int idproveedor;
	private String razonSocial;

	public Proveedor() {
	}

	public Proveedor(int idproveedor, String razonSocial) {
		this.idproveedor = idproveedor;
		this.razonSocial = razonSocial;
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Proveedor [idproveedor=" + idproveedor + ", razonSocial=" + razonSocial + "]";
	}

}
