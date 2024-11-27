<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo proveedor</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script>
</script>
</head>
<body>

<% String url = "http://localhost:8080/PreParcial/"; %>

<div class="container">
	<br>
	<h3> Nuevo Autor </h3>
	<div class="form group">
	<form role="form" action="<%= url %>ProveedoresController" method="POST" onsubmit="">
		<input type="hidden" name="operacion" value="insertar">
		<input type="text" name="razonSocial" id="razonSocial" class="form-control"> <p></p>
		<br>
		<input type="submit" value="Guardar" name="Guardar" class="btn btn-primary">
		<a href="<%= url %>ProveedoresController" class="btn btn-outline-primary"> Volver </a>
	</form>
	</div>
</div>

</body>
</html>