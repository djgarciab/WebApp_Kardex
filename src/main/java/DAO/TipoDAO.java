package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;

import Modelos.JPAUtil;
import Modelos.Tipo;

public class TipoDAO {
	
	//Creando la conexion a la bd
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	// Crear el CRUD
	
	//Guardar
	public void guardar( Tipo tipo) {
		entity.getTransaction().begin(); //comenzar transaccion
		entity.persist(tipo);			 //obtiene el objeto
		entity.getTransaction().commit();//guarda en bd
		//JPAUtil.shutdown();              //Cerrando la conexion	
	}
	
	//Editar
	public void editar( Tipo tipo) {
		entity.getTransaction().begin(); //comenzar transaccion
		entity.merge(tipo);			     //actualiza el objeto
		entity.getTransaction().commit();//guarda en bd
		//JPAUtil.shutdown();              //Cerrando la conexion		
	}
	
	//Buscar
	public Tipo buscar( String id ) {
		Tipo t = new Tipo(); 			 //crea objeto		
		t = entity.find(Tipo.class, id); //Busca con id y guarda en el objeto creado
		//JPAUtil.shutdown();              //Cerrando la conexion
		return t;						 //retorna objeto
		
	}
	
	//Eliminar
	public void eliminar( String id ) {
		Tipo t = new Tipo(); 			 //crea objeto
		t = entity.find(Tipo.class, id); //Busca con id y guarda en el objeto creado
		entity.getTransaction().begin();
		entity.remove(t);				 //elimina en la bd 
		entity.getTransaction().commit();//guarda en bd
	}
	
	
	//Obtener todos
	
	public List<Tipo> obtenerLista(){
		List<Tipo> lista = new ArrayList<>();//crear lista para los objetos
		//Query q = entity.createQuery("SELECT t FROM Tipo t");//consultar con Sentencia jql
		//lista = q.getResultList();		//guardar todos los registros de la tabla en la lista
		
		lista = entity.createQuery("SELECT t FROM Tipo t",Tipo.class).getResultList();
		return lista;					//retorna la lista de objetos
		
		
	}
	
}
