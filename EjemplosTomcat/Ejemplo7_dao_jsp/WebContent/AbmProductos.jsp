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
<title>Lista de Productos</title>
</head>
<body>
	<%
	session.setAttribute("producto",null);
	List<Producto> productos;
	if(session.getAttribute("productos")!=null){
		productos = (List<Producto>) session.getAttribute("productos");	
	}else{
		productos=new ArrayList();	
	}	
	%>

	<table border="1" width="100%">
	 <tr>
	 	<th align="center">Id</th>
	 	<th align="center">Nombre</th>
	 	<th align="center">Cantidad</th>
	 	<th align="center">Acciones</th>
	 </tr>
	 <%
	 if(productos == null || productos.size() == 0){
	 	out.println("No hay Productos en el sistema");
	 }else{
	 	for(Producto o:productos){
	 %>
	 <tr>
	 	<td><%=o.getId() %></td>
	 	<td><%=o.getNombre()%></td>
	 	<td><%=String.format("%d", o.getCantidad())%></td>
	 	<td><a href="ProductoSrvlt?comando=3&id=<%=o.getId() %>">[Ver], </a>
	 			<a href="ProductoSrvlt?comando=4&id=<%=o.getId() %>">[Modificar]</a>
	 			<a href="ProductoSrvlt?comando=7&id=<%=o.getId() %>">[Eliminar]</a> </td>
	 </tr>
	 <%
	 	}
	 }
	 %>
	</table>
	<div id="comandos">
		<table width="25%">
			<tr>
				<td><a href="DatosProducto.jsp?comando=2">[Agregar Producto]</a> </td>
				<td><a href="ProductoSrvlt?comando=3">[Generar lista en html]</a></td>
				<td><a href="menuPrincipal.jsp">[Menú]</a></td>
			</tr>
		</table>
	</div>
</body>
</html>