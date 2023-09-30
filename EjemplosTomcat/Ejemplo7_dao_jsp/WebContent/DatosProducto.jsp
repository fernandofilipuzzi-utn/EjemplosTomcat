<!-- 
  apellido y nombre: filipuzzi, fernando rafael
  
  email: fernando6867@gmail.com
  url: http://hdcm.sytes.net

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach, java.util.*, modelo.*"%>
<%@page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Datos Producto</title>
</head>
<body>
	<center>
	
	<h2>Editar Datos Producto</h2>
	<%
	Producto producto; 
	if(session.getAttribute("producto")!=null){
		producto = (Producto)session.getAttribute("producto");
	}else{
		producto =new Producto();
	};
		
	%>
	<form action="ProductoSrvlt" method="get">
		<input type="hidden" name="comando" value="<%=session.getAttribute("comando")%>"/>
		<input type="hidden" name="id" value="<%=producto.getId()%>"/>
		
		<table>
			<tr>
				 <td>Id</td>
				 <td><%=(producto.getId()!=null)?producto.getId():""%> </td>
			</tr>
			
			<tr>
				 <td>Nombre</td>
				 <td><input name="nombre" 
				 			type="text" 
				 			value="<%=(producto.getNombre()!=null)?producto.getNombre():""%>"> </td>
			</tr>
			<tr>
				 <td>Cantidad</td>
				 <td><input name="cantidad" 
				 			type="text" 
				 			value="<%=producto.getCantidad()%>"> </td>
			</tr>
				
			<tr>
				 <td><center><input type="submit" value="Aceptar" name="btnAceptar"></center></td>
				 <td><center><input type="submit" value="Cancelar" name="btnCancelar"></input></center></td>
			</tr>
				
		</table>
	</form>
	</center>
</body>
</html>