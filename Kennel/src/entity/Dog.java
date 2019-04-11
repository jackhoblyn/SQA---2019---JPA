/**
 * @author jackhoblyn - C14710555
 * 
 * The entity classes are all very similar bar a few minor changes, mainly to their relationships.
 * They all contain the appropriate named queries at the top of them which will be used to interact with them.
 * After that it's just the parameters/constructor, relationships and getters/setters
 */

package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * Named Queries are basically MySQL queries which will be executed on the tables that these entity classes create
 */

@NamedQueries( {
	@NamedQuery(name = "Dog.findAll", query = "select o from Dog o"),
	@NamedQuery(name = "Dog.findBydName", query = "select o from Dog o where o.dName=:dName"),
	@NamedQuery(name = "Dog.findBydId", query = "select o from Dog o where o.id=:id"),
})

//This tag marks this pojo class as a blueprint for a MySQL table
@Entity
public class Dog {
	
	//Every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String dName;
	private String breed;
	
	
	//These relationship tags represent the different relationships between the entities
	@OneToOne
	private Kennel kennel;
	
	//They correspond to a particular entities side of the relationship
	@OneToOne 
	private Toy toy;
	
	public Dog(){
		
	}
	
	/* The entities that will be involved in the relationships are then included in the 
	 * constructor and will represent foreign keys
	 */
	public Dog(String dName, String breed, Kennel kennel, Toy toy) {
		super();
		this.dName = dName;
		this.breed = breed;
		this.kennel = kennel;
		this.toy = toy;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public Kennel getKennel() {
		return kennel;
	}


	public void setKennel(Kennel kennel) {
		this.kennel = kennel;
	}

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}

	

}
