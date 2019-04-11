/**
 * @author jackhoblyn - C14710555
 * 
 * Please see Dog.java for information on how the entity classes work/behave
 */


package entity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@NamedQueries( {
	@NamedQuery(name = "Kennel.findAll", query = "select o from Kennel o"),
	@NamedQuery(name = "Kennel.findById", query = "select o from Kennel o where o.id=:id"),
	@NamedQuery(name = "Kennel.findBykName", query = "select o from Kennel o where o.kName=:kName"),
})

@Entity
public class Kennel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String kName;
	
	
	/*
	 * In a one to Many relationship there are a few things that should be declared
	 * targetEntity assigns the other entity for the many side of the relationship,
	 * cascade represents the desired behavior if a kennel is to be deleted, which is 
	 * to delete the dogs that are assigned to it
	 * FetchType defines how Hibernate gets the related entities from the table,
	 * for this kind of relationship FetchType.Lazy is recommended.
	 * 
	 */
	@OneToMany(targetEntity=Dog.class, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Set <Dog> dog = new HashSet<Dog>();

	public Kennel(){	
	}
	
	public Kennel(String kName) {
		super();
		this.kName = kName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getkName() {
		return kName;
	}

	public void setkName(String kName) {
		this.kName = kName;
	}

	public Set<Dog> getDog() {
		return dog;
	}

	public void setDog(Set<Dog> dog) {
		this.dog = dog;
	}
	
	
	

	

}
