package Modelos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;
	
	//Conectarse a la bd
	public static EntityManagerFactory getEntityManagerFactory() {
		if( factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return factory;
	}
	//Desconectarse a la bd
	public static void shutdown() {
		if( factory != null ) {
			factory.close();
		}
	}

}
