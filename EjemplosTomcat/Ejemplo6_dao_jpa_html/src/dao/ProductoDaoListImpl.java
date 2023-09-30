package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductoDaoListImpl implements IProductoDao {

	List<Producto> productos=new ArrayList<Producto>();
	static int gen_id=1;
		
	public ProductoDaoListImpl(){
		productos.add(new Producto(gen_id++,"Tomate", 100));
		productos.add(new Producto(gen_id++,"Arroz", 1000));
		productos.add(new Producto(gen_id++,"Lechuga", 1000));
	}
	
	@Override
	public List<Producto> listarProductos(){
		return productos;
	}
	
	@Override
	public Producto listarPorId(Integer id){
		for(Producto producto:productos)
			if(producto.getId().equals(id))
				return producto;
		return null;
	}
	
	@Override
	public Producto crear(Producto nuevo){
		nuevo.setId(gen_id++);
		productos.add(nuevo);
		return nuevo;
	}
	
	@Override
	public Producto modificar(Producto modificado){
		Producto p=listarPorId(modificado.getId());
		productos.remove(p);
		productos.add(modificado);
		return modificado;
	}
	
	@Override
	public void eliminar(Producto aEliminar){
		Producto p=listarPorId(aEliminar.getId());
		productos.remove(p);
	}
}
