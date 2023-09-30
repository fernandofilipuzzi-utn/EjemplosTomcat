package view;

import java.io.PrintWriter;
import java.util.List;
import modelo.Producto;

public class ProductoViewHtml {

	
	public void verListarProductos(PrintWriter pw, List<Producto> productos)
	{
		String titulo="Listando los productos existentes";
		
		String pagina="<html> \n "+
	
					  "<head> \n "+
							"<title>"+titulo+"</title> \n "+
					  "</head> \n "+
							
					  "<body> \n "+
										  
						"<h2>"+titulo+"</h2> \n "+
						"<br/> \n "+
				
						"<br/> \n "+
						
						"<li><a href=\"ProductoSrvlt?comando=2\">Agregar Un Producto</a></li> \n "+
						"<li><a href=\"ProductoSrvlt?comando=1\">Actualizar el listado</a></li> \n "+
					  	
						"<br/> \n "+
						"<br/> \n "+
						
					  	"<table border=\"1\" cellspacing==\"1\"  align=\"center\" style=\"width:100%\"> \n "+
					  	
					  		"<tr> <th>Id</th> <th>Nombre</th> <th>Cantidad</th> <th>Operaci&oacute;n</th> </tr> \n ";
		
			for(Producto producto:productos)
			{
				pagina+=
							"<tr> <td>"+producto.getId()+"</td> "+
									"<td>"+producto.getNombre()+"</td> "+
					  				"<td>"+producto.getCantidad()+"</td> "+
					  				"<td> [<a href=\"ProductoSrvlt?id="+producto.getId()+"&comando=3\">Ver</a>] " +
					  					 	 " [<a href=\"ProductoSrvlt?id="+producto.getId()+"&comando=4\">Modificar</a>] " +
					  					 	 " [<a href=\"ProductoSrvlt?id="+producto.getId()+"&comando=7\">Eliminar</a>] </td> "+
					  		"</tr> \n ";
			}
			
			pagina+=   "</table> \n "+
			 		 "</body> \n "+
			 		 "</html> \n ";
			
		pw.println( pagina );		
	}
	
	public void verFormularioEdicion(PrintWriter pw, Producto producto, Integer comandoSiguiente, boolean editable)
	{
		Integer id=0;
		String nombre="";
		Integer cantidad=0;
		String titulo="";
		
		if(producto!=null)
		{
			if(producto.getId()!=null)
				id=producto.getId();
			if(producto.getNombre()!=null)
				nombre=producto.getNombre();
			if(producto.getCantidad()!=null)
				cantidad=producto.getCantidad();
		}
		
		String label="";
		switch(comandoSiguiente){
			case 1:{
				label="Volver al Listado";
				titulo="";
			} break;
			case 5:{
				label="Agregar y Volver al Listado";
				titulo="Agregando un Registro Nuevo";
			} break;
			case 6:{
				label="Modificar y Volver al Listado";
				titulo="Modificando un Registro Existente";
			} break;
		}
				
		String pagina="<html> \n "+
				
					  "<head> \n "+
					  		"<title>"+titulo+"</title> \n "+
					  "</head> \n "+
					  
					  "<body> \n "+
					  
					  	"<h2>"+titulo+"</h2> \n"+
					  	"<br/> \n"+
					  	"<br/> \n"+
					  	
						"<li><a href=\"ProductoSrvlt?comando=1\">Volver al listado</a></li> \n "+
						
						"<br/> \n"+
						"<br/> \n";
		
		if(editable==true)
		{
			pagina+=
					"<form action=\"ProductoSrvlt\" method=\"get\"> \n"+
					  		"<input type=\"hidden\" name=\"comando\" value=\""+comandoSiguiente+"\"/> \n"+
					  		"<input type=\"hidden\" name=\"id\" value=\""+id+"\" /> \n"+
					  		"<table border=\"0\" align=\"center\"> \n"+
					  			"<tr><td>ID: </td><td>"+id+" </td></tr> \n"+
					  			"<tr><td>Nombre: </td><td><input type=\"input\" name=\"nombre\" value=\""+nombre+"\" /></td></tr> \n"+
								"<tr><td>Cantidad: </td><td><input type=\"input\" name=\"cantidad\" value=\""+cantidad+"\" /></td></tr> \n"+
							"</table> \n"+	
							
							"<p align=\"center\"> \n"+
					  			"<input type=\"submit\" name=\"btnAceptar\" value=\""+label+"\"/> \n" +
					  		"</p> \n"+
						"</form> \n";
		}else{
			pagina+=
					"<table border=\"0\" align=\"center\"> \n"+
							"<tr><td>ID: </td><td>"+id+" </td></tr> \n"+
							"<tr><td>Nombre: </td><td>"+nombre+" </td></tr> \n"+
							"<tr><td>Cantidad: </td><td>"+cantidad+" </td></tr> \n"+
					"</table> \n";
		}
		pagina+=
			 		 "</body> \n "+
			 		 "</html> \n ";
		pw.println( pagina );		
	}
	
	public void verError(PrintWriter pw)
	{
		String titulo="Error";
							
		String pagina="<html> \n "+
				
					  "<head> \n "+
					  		"<title>"+titulo+"</title> \n "+
					  "</head> \n "+
					  
					  "<body> \n "+
					  
					  	"<h2>"+titulo+"</h2> \n"+
					  	"<br/> \n"+
					  	"<br/> \n"+
					  	
						"<li><a href=\"ProductoSrvlt?comando=1\">Volver al listado</a></li> \n "+
						
						"<br/> \n"+
						"<br/> \n";
		pagina+=
							" <p>Error</p> ";
		pagina+=
			 		 "</body> \n "+
			 		 "</html> \n ";
		pw.println( pagina );		
	}
}
