
/**
 * @author jackhoblyn - C14710555
 * 
 * This class contains the methods called from the pesistenceUtil class which interact with 
 * the database. It uses the namedQueries that you will find at the top of the entity classes.
 */


package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Dog;
import entity.Kennel;
import entity.User;

public class PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	protected static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("kennel"); 	
	
	/*
	 * An entity manager is created here and then used to persist (add to database)
	 */
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	/*
	 * Exact same except remove
	 */
	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	/*
	 * Update
	 */
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	
	/*
	 * These methods execute the findAll namedQueries on the database and then save the
	 * results to a List of the appropriate objects
	 */
	public static List<Kennel> findAllKennels(){
		EntityManager em = emf.createEntityManager();
		List<Kennel> kennels = (List<Kennel>) 
		em.createNamedQuery("Kennel.findAll").getResultList();
		em.close();
		
		return kennels;	
	}
	
	public static List<Dog> findAllDogs(){
		EntityManager em = emf.createEntityManager();
		List<Dog> dogs = (List<Dog>) 
		em.createNamedQuery("Dog.findAll").getResultList();
		em.close();
		
		return dogs;	
	}
	
	public static List<User> findAllUsers(){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) 
		em.createNamedQuery("User.findAll").getResultList();
		em.close();
		
		return users;	
	}
	
	/* The kennel name is passed to this method and then used with the find namedQuery,
	 * if there are no results to return then null will be returned, if there is then it is
	 * saved to a list and passed to the method that called it. The same applies to the other 
	 * search methods
	 */
	public static Kennel findKennelBykName(String kName){
		
		EntityManager em = emf.createEntityManager();
		List<Kennel> kennels = (List<Kennel>) 
		em.createNamedQuery("Kennel.findBykName").
		setParameter("kName", kName).getResultList();
		em.close();
		
		if (kennels.size() == 0)
			return null;
		else 
			return kennels.get(0);
	}
	
	public static Dog findDogBydName(String dName){
		
		EntityManager em = emf.createEntityManager();
		List<Dog> dogs = (List<Dog>) 
		em.createNamedQuery("Dog.findBydName").
		setParameter("dName", dName).getResultList();
		em.close();
		
		if (dogs.size() == 0)
			return null;
		else 
			return dogs.get(0);
	}
	
	public static Kennel findKennelById(int identifier){
		
		EntityManager em = emf.createEntityManager();
		List<Kennel> kennels = (List<Kennel>) 
		em.createNamedQuery("Kennel.findById").
		setParameter("id", identifier).getResultList();
		em.close();
		
		if (kennels.size() == 0)
			return null;
		else 
			return kennels.get(0);
	}
	
public static Dog findDogById(int identifier){
		
		EntityManager em = emf.createEntityManager();
		List<Dog> dogs = (List<Dog>) 
		em.createNamedQuery("Dog.findById").
		setParameter("id", identifier).getResultList();
		em.close();
		
		if (dogs.size() == 0)
			return null;
		else 
			return dogs.get(0);
	}

	
}

