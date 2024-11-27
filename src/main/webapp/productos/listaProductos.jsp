<%@page import="com.unu.beans.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista productos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script>
	function modificar(id) {
		if(confirm('¿Desea modificar el registro?')){
			location.href = "ProductosController";
		}
	}
	function eliminar(id) {
		if(confirm('¿Desea eliminar el registro?')){
			location.href = "ProductosController?operacion=eliminar&idproducto=" + id;
		}
	}
</script>
</head>
<body>

<% List<Producto> productos = (List<Producto>)request.getAttribute("productos"); %>

<div class="container">
	<br>
	<a class="btn btn-primary"> Nuevo producto </a>
	<br> <br>
	<table class="table table-borderless">
		<thead>
			<tr>
				<th> Id producto </th>
				<th> Nombre </th>
				<th> Stock </th>
				<th> P. Venta </th>
				<th> Operaciones </th>
			</tr>
		</thead>
		<tbody>
			<%
			if(productos != null){
				for(Producto producto: productos){
					int idproducto = producto.getIdproducto();
			%>
			<tr>
				<td><%= idproducto %></td>
				<td><%= producto.getNombre() %></td>
				<td><%= producto.getStock() %></td>
				<td><%= producto.getPrecioVenta() %></td>
				<td>
					<a href="javascript:modificar(<%= idproducto %>)" class="btn btn-outline-warning"> Modificar </a>
					<a href="javascript:eliminar(<%= idproducto %>)" class="btn btn-outline-danger"> Eliminar </a>
				</td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
</div>

</body>
</html>