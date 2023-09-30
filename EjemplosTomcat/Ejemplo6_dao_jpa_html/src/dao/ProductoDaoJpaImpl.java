package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Producto;

public class ProductoDaoJpaImpl implements IProductoDao {

		
	public ProductoDaoJpaImpl(){
	}
	
	
	@Override
	public List<Producto> listarProductos() throws Exception{
		List<Producto> productos = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("productos_pgdb");
		EntityManager em = emf.createEntityManager(); 
		try {
			Query query=em.createQuery("select o from Producto as o");
			productos= query.getResultList();
	    }catch (Exception e) {
	    	throw e;
	    } finally {
	    	em.close();
	    	emf.close();
		}
		return productos;
	}

	@Override
	public Producto listarPorId(Integer id) throws Exception{
		Producto producto = new Producto();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("productos_pgdb");
		EntityManager em = emf.createEntityManager(); 
		try {
			Query query=em.createQuery("select o from Producto as o where o.id=:id");
			query.setParameter("id", id);
			producto= (Producto)query.getResultList().get(0);
	    }catch (Exception e) {
	    	throw e;
	    } finally {
	    	em.close();
	    	emf.close();
		}
		return producto;
	}

	@Override
	public Producto crear(Producto nuevo) throws Exception {
		if(nuevo!=null)
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("productos_pgdb");
			EntityManager em = emf.createEntityManager(); 
			
			EntityTransaction tx=null;
		    try {
		    	tx = em.getTransaction();
				tx.begin();
				if(nuevo.getId()==0) nuevo.setId(null);
				em.persist(nuevo);
				tx.commit();
		    }catch (Exception e) {
		    	if(tx!=null) tx.rollback();
		    	throw e;
		    } finally {
		    	em.close();
		    	emf.close();
			}
		    return nuevo;
	    }
		return null;
	}

	@Override
	public Producto modificar(Producto modificado)throws Exception {
		if(modificado!=null)
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("productos_pgdb");
			EntityManager em = emf.createEntityManager(); 
			
			EntityTransaction tx=null;
		    try {
		    	tx = em.getTransaction();
				tx.begin();
				em.merge(modificado);
				tx.commit();
		    }catch (Exception e) {
		    	if(tx!=null) tx.rollback();
		    	throw e;
		    } finally {
		    	em.close();
		    	emf.close();
			}
		    return modificado;
	    }
		return null;
	}

	@Override
	public void eliminar(Producto aEliminar)throws Exception {
		if(aEliminar!=null)
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("productos_pgdb");
			EntityManager em = emf.createEntityManager(); 
			
			EntityTransaction tx=null;
		    try {
		    	tx = em.getTransaction();
				tx.begin();
				em.remove(aEliminar);
				tx.commit();
		    }catch (Exception e) {
		    	if(tx!=null) tx.rollback();
		    	throw e;
		    } finally {
		    	em.close();
		    	emf.close();
			}
	    }
	}

}
