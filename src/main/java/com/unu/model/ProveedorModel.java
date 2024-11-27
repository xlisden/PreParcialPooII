package com.unu.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Proveedor;

public class ProveedorModel {

	private CallableStatement cs;
	private Connection conexion;
	private ResultSet rs;

	public List<Proveedor> listarProveedores() {
		List<Proveedor> proveedores = null;
		try {
			String sql = "CALL `preparcial`.`spReadProveedores`();";
			proveedores = new ArrayList<Proveedor>();
			conexion = Conexion.openConnection();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdproveedor(rs.getInt("idproveedor"));
				proveedor.setRazonSocial(rs.getString("razonSocial"));
				proveedores.add(proveedor);
			}
			conexion = Conexion.closeConnection();
		} catch (Exception e) {
			System.out.println("listarProveedores() " + e.getMessage());
		}
		return proveedores;
	}
	
	public int eliminarProveedor(int idproveedor) {
		int filasAfectadas = 0;
		try {
			String sql = "CALL `preparcial`.`spDeleteProveedor`(?);";
			conexion = Conexion.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idproveedor);
			filasAfectadas = cs.executeUpdate();
			if(filasAfectadas == 0) {
				System.out.println("proveedor NO eliminado en model");
			}
		} catch (Exception e) {
			System.out.println("eliminarProveedor() " + e.getMessage());
		}
		return filasAfectadas;
	}
	
	public int insertarProveedor(Proveedor proveedor) {
		int filasAfectadas = 0;
		try {
			String sql = "CALL `preparcial`.`spCreateProveedor`(?);";
			
			conexion = Conexion.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setString(1, proveedor.getRazonSocial());
			filasAfectadas = cs.executeUpdate();
			if(filasAfectadas == 0) {
				System.out.println("proveedor NO insertado en model");
			}
			conexion = Conexion.closeConnection();
		} catch (Exception e) {
			System.out.println("insertarProveedor() " + e.getMessage());
		}
		return filasAfectadas;
	}
}
