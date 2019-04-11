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
	@NamedQuery(name = "SubscriberProfile.findAll", query = "select o from SubscriberProfile o"),
	@NamedQuery(name = "SubscriberProfile.findById", query = "select o from SubscriberProfile o where o.id=:id"),
})

@Entity
public class SubscriberProfile {
	
	//every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String profileDescription;
	
	public SubscriberProfile(){
		
	}
	

	public SubscriberProfile(String profileDescription) {
		super();
		this.profileDescription = profileDescription;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProfileDescription() {
		return profileDescription;
	}


	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

}
