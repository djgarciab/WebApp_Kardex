package DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;

import Modelos.JPAUtil;
import Modelos.Producto;

public class ProductoDAO {
	

	//Creando la conexion a la bd
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	// Crear el CRUD
	
	//Guardar
	public void guardar( Producto producto) {
		entity.getTransaction().begin(); //comenzar transaccion
		entity.persist(producto);			 //obtiene el objeto
		entity.getTransaction().commit();//guarda en bd
		//JPAUtil.shutdown();              //Cerrando la conexion	
	}
	
	//Editar
	public void editar( Producto producto) {
		entity.getTransaction().begin(); //comenzar transaccion
		entity.merge(producto);			     //actualiza el objeto
		entity.getTransaction().commit();//guarda en bd
		//JPAUtil.shutdown();              //Cerrando la conexion		
	}
	
	//Buscar
	public Producto buscar( String id ) {
		Producto p = new Producto(); 			 //crea objeto		
		p = entity.find(Producto.class, id); //Busca con id y guarda en el objeto creado
		//JPAUtil.shutdown();              //Cerrando la conexion
		return p;						 //retorna objeto
		
	}
	
	//Eliminar
	public void eliminar( String id ) {
		Producto p = new Producto(); 				 //crea objeto
		p = entity.find(Producto.class, id); //Busca con id y guarda en el objeto creado
		entity.getTransaction().begin();
		entity.remove(p);				 //elimina en la bd 
		entity.getTransaction().commit();//guarda en bd
	}
	
	
	//Obtener todos
	
	public List<Producto> obtenerLista(){
		List<Producto> lista = new ArrayList<>();//crear lista para los objetos
		//Query q = entity.createQuery("SELECT p FROM Producto p");//consultar con Sentencia jql
		//lista = q.getResultList();		//guardar todos los registros de la tabla en la lista
		
		lista = entity.createQuery("SELECT p FROM Producto p",Producto.class).getResultList();
		return lista;					//retorna la lista de objetos
		
		
	}
	

}
