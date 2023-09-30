package srvlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import view.ProductoView;
import dao.ProductoDao;

public class ProductoSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final static ProductoDao productoDao=new ProductoDao();
	ProductoView pv=new ProductoView();
	
    public ProductoSrvlt() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		
		Integer comando=1;
		if(request.getParameter("comando")!=null)
			comando=new Integer(request.getParameter("comando"));
		
		switch(comando){
			case 1:{
				pv.verListarProductos(response.getWriter(), productoDao.listarProductos());
			}break; 
			case 2:{
				//formulario nuevo
				pv.verFormularioEdicion(response.getWriter(),null, 5,true);         // 5 crea nuevo registro
			}break;
			case 3:{
				//formulario ver
				Integer id=new Integer(request.getParameter("id"));
				Producto ver=productoDao.listarPorId(id);
				pv.verFormularioEdicion(response.getWriter(),ver, 1,false);          // 1 vuelve a ver el listado
			}break;
			case 4:{
				//formulario modificar
				Integer id=new Integer(request.getParameter("id"));
				Producto amodificar=productoDao.listarPorId(id);
				pv.verFormularioEdicion(response.getWriter(),amodificar, 6, true);   // 6 modifica el registro visualizado
			}break;
			case 5:{		
				//crear el nuevo
				String nombre=request.getParameter("nombre");
				Integer cantidad=new Integer(request.getParameter("cantidad"));
				Producto nuevo=new Producto(0, nombre, cantidad);
				productoDao.crear(nuevo);
				pv.verListarProductos(response.getWriter(), productoDao.listarProductos());
			}break;
			case 6:{	
				//modifica un existente
				Integer id= new Integer(request.getParameter("id"));
				String nombre=request.getParameter("nombre");
				Integer cantidad=new Integer(request.getParameter("cantidad"));
				Producto modificado=new Producto(id, nombre, cantidad);
				productoDao.nodificar(modificado);
				pv.verListarProductos(response.getWriter(), productoDao.listarProductos());
			}break;
			case 7:{
				//elimina
				Integer id=new Integer(request.getParameter("id"));
				Producto aEliminar=productoDao.listarPorId(id);
				productoDao.eliminar(aEliminar);
				pv.verListarProductos(response.getWriter(), productoDao.listarProductos());
			}break;	
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}


