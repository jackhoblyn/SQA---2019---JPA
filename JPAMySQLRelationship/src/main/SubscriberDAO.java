package main;

import java.util.List;
import persistence.PersistenceUtil;
import entity.Subscriber;
import entity.SubscriberProfile;


public class SubscriberDAO {
	
	public static void main(String[] args){
		SubscriberDAO config = new SubscriberDAO();
	}

	public SubscriberDAO(){
		createSubscriber("Jane", "secret123", "Loves tea.");
		viewSubscriber();
	}


	public void viewSubscriber(){
		List<Subscriber> subscribers = PersistenceUtil.findAllSubscribers();
		for(Subscriber s:subscribers){
			System.out.println("Subscriber "+s.getUsername()+ " exists.");
		}
	}
	
	public void createSubscriber(String name, String password, String profileDescription){
		SubscriberProfile profile = new SubscriberProfile(profileDescription);
		PersistenceUtil.persist(profile);
		Subscriber subscriber = new Subscriber(name, password, profile);
		PersistenceUtil.persist(subscriber);
		System.out.println("Subscriber registered");
	}
			

}
