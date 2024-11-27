<%@page import="com.unu.beans.Proveedor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista proveedores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script>
	function modificar(id) {
		if(confirm('¿Desea modificar el registro?')){
			location.href = "ProveedoresController";
		}
	}
	function eliminar(id) {
		if(confirm('¿Desea eliminar el registro?')){
			location.href = "ProveedoresController?operacion=eliminar&idproveedor=" + id;
		}
	}
</script>
</head>
<body>

<% List<Proveedor> proveedores = (List<Proveedor>)request.getAttribute("proveedores"); %>
<% String url = "http://localhost:8080/PreParcial/"; %>

<div class="container">
	<br>
	<a href="<%= url %>ProveedoresController?operacion=nuevo" class="btn btn-primary"> Nuevo proveedor </a>
	<br> <br>
	<table class="table table-borderless">
		<thead>
			<tr>
				<th> Id proveedor </th>
				<th> Razon Social </th>
				<th> Operaciones </th>
			</tr>
		</thead>
		<tbody>
			<%
			if(proveedores != null){
				for(Proveedor proveedor: proveedores){
					int idproveedor = proveedor.getIdproveedor();
			%>
			<tr>
				<td><%= idproveedor %></td>
				<td><%= proveedor.getRazonSocial() %></td>
				<td>
					<a href="javascript:modificar(<%= idproveedor %>)" class="btn btn-outline-warning"> Modificar </a>
					<a href="javascript:eliminar(<%= idproveedor %>)" class="btn btn-outline-danger"> Eliminar </a>
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