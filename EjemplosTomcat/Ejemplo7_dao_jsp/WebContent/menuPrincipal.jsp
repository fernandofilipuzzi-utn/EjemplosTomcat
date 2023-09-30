<!-- 
  apellido y nombre: filipuzzi, fernando rafael
  
  email: fernando6867@gmail.com
  url: http://hdcm.sytes.net

 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach, java.util.*, modelo.*"%>
<%@page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Elija una opción :
	<ul>
		<li><a href="ProductoSrvlt?comando=2">Nuevo Producto</a></li>
		<li><a href="ProductoSrvlt?comando=1">Listar, ver, modificar, eliminar Productos</a></li>
	</ul>
</body>
</html>