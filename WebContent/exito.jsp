<%@page import="com.scripletprueba.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
    	Usuario usuario = (Usuario)request.getAttribute("personal");
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exito</title>
</head>
<body>
	<h1>Bienvenido</h1>
	<p>Nombre: <%=usuario.getNombre() %></p>
	<p>Edad: <%=usuario.getEdad() %></p>
</body>
</html>