package com.unu.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Producto;
import com.unu.beans.Producto;

public class ProductoModel {

	private CallableStatement cs;
	private Connection conexion;
	private ResultSet rs;

	public List<Producto> listarProductos() {
		List<Producto> productos = null;
		try {
			String sql = "CALL `preparcial`.`spReadProductos`();";
			productos = new ArrayList<Producto>();
			conexion = Conexion.openConnection();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setIdproducto(rs.getInt("idproducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setStock(rs.getInt("stock"));
				producto.setPrecioVenta(rs.getDouble("precioVenta"));
				productos.add(producto);
			}
			conexion = Conexion.closeConnection();
		} catch (Exception e) {
			System.out.println("listarProductos() " + e.getMessage());
		}
		return productos;
	}

	public int eliminarProducto(int idproducto) {
		int filasAfectadas = 0;
		try {
			String sql = "CALL `preparcial`.`spDeleteProducto`(?);";
			conexion = Conexion.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idproducto);
			filasAfectadas = cs.executeUpdate();
			if(filasAfectadas == 0) {
				System.out.println("producto NO eliminado en model");
			}
		} catch (Exception e) {
			System.out.println("eliminarProducto() " + e.getMessage());
		}
		return filasAfectadas;
	}
	
	public int insertarProducto(Producto producto) {
		int filasAfectadas = 0;
		try {
			String sql = "CALL `preparcial`.`spCreateProducto`(?);";
			
			conexion = Conexion.openConnection();
			cs = conexion.prepareCall(sql);
//			cs.setString(1, producto.getRazonSocial());
			filasAfectadas = cs.executeUpdate();
			if(filasAfectadas == 0) {
				System.out.println("producto NO insertado en model");
			}
			conexion = Conexion.closeConnection();
		} catch (Exception e) {
			System.out.println("insertarProducto() " + e.getMessage());
		}
		return filasAfectadas;
	}
}
