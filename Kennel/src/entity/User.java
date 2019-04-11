/**
 * @author jackhoblyn - C14710555
 * 
 * Please see Dog.java for information on how the entity classes work/behave
 */

package entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@NamedQueries( {
	@NamedQuery(name = "User.findAll", query = "select o from User o"),
	@NamedQuery(name = "User.findByuName", query = "select o from User o where o.uName=:uName"),
})

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String uName;
	private String password;
	
	//Please see Kennel.java for information on OneToMany relationships
	@OneToMany(targetEntity=Dog.class, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Set <Dog> dog = new HashSet<Dog>();

	public User(){
		
	}
	
	public User(String uName, String password) {
		super();
		this.uName = uName;
		this.password = password;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	




	

}
