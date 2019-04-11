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
	@NamedQuery(name = "Toy.findAll", query = "select o from Toy o"),
	@NamedQuery(name = "Toy.findById", query = "select o from Toy o where o.id=:id"),
})

@Entity
public class Toy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String tName;

	public Toy(){	
	}
	
	public Toy(String tName) {
		super();
		this.tName = tName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}


	

}