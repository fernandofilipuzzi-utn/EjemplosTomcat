package srvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import dao.ProductoDao;

public class ProductoSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final static ProductoDao productoDao=new ProductoDao();
	
    public ProductoSrvlt() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
				
		Integer comando=1;
		if(request.getParameter("comando")!=null)
			comando=new Integer(request.getParameter("comando"));
		String respuesta = "menuPrincipal.jsp";
		
		
		switch(comando){
			case 1:{
				List<Producto> productos = productoDao.listarProductos();
				session.setAttribute("productos", productos);
				respuesta = "AbmProductos.jsp";
			}break;
			case 2:{
				//formulario nuevo
				Producto o = null;
				session.setAttribute("producto", o);
				session.setAttribute("comando", 5);		// siguiente accion: 5 crea nuevo registro
				respuesta = "DatosProducto.jsp";        
			}break;
			case 3:{
				//formulario ver
				Integer id=new Integer(request.getParameter("id"));
				Producto ver=productoDao.listarPorId(id);
				session.setAttribute("producto", ver);
				session.setAttribute("comando", 1);		// 1 vuelve a ver el listado    
				respuesta = "DatosProducto.jsp";  
			}break;
			case 4:{
				//mostrar formulario modificar
				Producto o =productoDao.listarPorId(new Integer(request.getParameter("id")));
				session.setAttribute("producto", o);
				session.setAttribute("comando", 6);		// siguiente accion: 6 modifica
				respuesta = "DatosProducto.jsp";
			}break;
			//
			case 5:{		
				//crear el nuevo
				String nombre=request.getParameter("nombre");
				Integer cantidad=new Integer(request.getParameter("cantidad"));
				Producto nuevo=new Producto(0, nombre, cantidad);
				productoDao.crear(nuevo);
				respuesta = "AbmProductos.jsp";
			}break;
			case 6:{	
				//modifica un existente
				Integer id= new Integer(request.getParameter("id"));
				String nombre=request.getParameter("nombre");
				Integer cantidad=new Integer(request.getParameter("cantidad"));
				Producto modificado=new Producto(id, nombre, cantidad);
				productoDao.nodificar(modificado);
				//
				//actualiza la vista del listado
				List<Producto> productos = productoDao.listarProductos();
				session.setAttribute("productos", productos);
				respuesta = "AbmProductos.jsp";
			}break;
			case 7:{
				//elimina
				System.out.println("busca");
				Integer id=new Integer(request.getParameter("id"));				
				Producto aEliminar=productoDao.listarPorId(id);
				System.out.println("elimina");				
				productoDao.eliminar(aEliminar);
				//
				
				//actualiza la vista del listado
				System.out.println("listado");
				List<Producto> productos = productoDao.listarProductos();
				session.setAttribute("productos", productos);
				respuesta = "AbmProductos.jsp";
			}break;			
		}
		response.sendRedirect(respuesta);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}


