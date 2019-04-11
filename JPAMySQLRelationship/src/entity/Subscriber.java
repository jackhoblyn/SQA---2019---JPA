package entity;


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
	@NamedQuery(name = "Subscriber.findAll", query = "select o from Subscriber o"),
	@NamedQuery(name = "Subscriber.findByUsername", query = "select o from Subscriber o where o.username=:username"),
})

@Entity
public class Subscriber {
	
	//every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String username;
	private String password;
	
	@OneToOne
	private SubscriberProfile profile;
	
	public Subscriber(){
		
	}
	

	public Subscriber(String username, String password, SubscriberProfile profile) {
		super();
		this.username = username;
		this.password = password;
		this.profile = profile;
	}



	public SubscriberProfile getProfile() {
		return profile;
	}


	public void setProfile(SubscriberProfile profile) {
		this.profile = profile;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	

}
