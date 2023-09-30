package dao;

import java.util.List;

import modelo.Producto;


public interface IProductoDao {
	 List<Producto> listarProductos() throws Exception;
	 Producto listarPorId(Integer id) throws Exception;
	 Producto crear(Producto nuevo) throws Exception;
	 Producto modificar(Producto modificado)throws Exception ;
	 void eliminar(Producto aEliminar) throws Exception;
}
