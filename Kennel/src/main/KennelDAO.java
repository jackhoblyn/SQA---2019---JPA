/**
 * 
 * @author jackhoblyn - C14710555
 * 
 * Running this class requires a MySQL database called Kennel, the database name
 * can be configured in persistence.xml. It also requires a number of jar files 
 * to be added to the class path, some of which should be included in the github repository.
 * The class uses JPA to create tables from the entity classes and then hibernate to interact with them.
 * 
 */
package main;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import persistence.PersistenceUtil;
import entity.Dog;
import entity.Kennel;
import entity.User;
import entity.Toy;

/*
 * This class uses a menu including options which, when activated, calls the methods below the menu
 */
public class KennelDAO {
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		KennelDAO config = new KennelDAO();
	}
	
	public KennelDAO(){
		int option;
		
		do{
		menu();
	      option = scan.nextInt();                         //Menu with all options
	 
		
		if(option == 1) {
			createDog();
			System.out.printf("\n");
			System.out.printf("\n");
			System.out.printf("\n");
		}
		if(option == 2) {
			viewUser();
			System.out.println(" \n Users in System \n");
			viewDog();
			System.out.println("\n Dogs in System \n");
			viewKennel();
			System.out.println("\n Kennels in System \n");

		}
		if(option == 3) {
			viewUser();
			System.out.printf("%n");
			System.out.printf("%n");
			System.out.printf("%n");
		}
		if(option == 4) {
			System.out.println("Please enter the id of the kennel to remove: ");
			int removeKennel = scan.nextInt();
			removeKennel(removeKennel);
			
			System.out.printf("%n");
			System.out.printf("%n");
			System.out.printf("%n");
		}
		
		if(option == 5) {
			
			updateDog();
			System.out.printf("%n");
			System.out.printf("%n");
			System.out.printf("%n");
		}
		} while(option != 0);
	
}
	
	public static void menu(){
        System.out.println("\tCommuni-Canine");
        System.out.println("0. End");
        System.out.println("1. Add new Dog to the System");
        System.out.println("2. View Kennels/Users/Dogs in the System");
        System.out.println("4. Remove Kennel");
        System.out.println("5. Update Dog in Kennel");
        System.out.println("Option: ");
    }


	/*
	 * These methods simply use the findAllKennels()/findAllDogs()/... 
	 * methods in PersistenceUtil and then save the result to a list. 
	 * The items in this list are then looped through and printed.
	 */
	public void viewKennel(){
		List<Kennel> kennels = PersistenceUtil.findAllKennels();
		for(Kennel s:kennels){
			System.out.println(s.getkName()+ ".");
		}
	}
	public void viewDog(){
		List<Dog> dogs = PersistenceUtil.findAllDogs();
		for(Dog s:dogs){
			System.out.println(s.getdName()+ ".");
		}
	}
	public void viewUser(){
		List<User> users = PersistenceUtil.findAllUsers();
		for(User s:users){
			System.out.println(s.getuName()+ ".");
		}
	}
	
	
	/* This method uses a scanner and user input to create the entities, 
	 * which are then persisted to the database
	 */
	public void createDog(){                                             
		
		//Basic user input is used here to initialize the parameters that will populate the entities
		System.out.println("Dog Creation System \n");
		scan.nextLine();
		
		System.out.println("Please enter the name of the Kennel that your dog is entering: ");
		String kName = scan.nextLine();
				
		System.out.println("Please create a username: ");
		String uName = scan.nextLine();
		
		System.out.println("Please enter a password ");
		String password = scan.nextLine();
		
		System.out.println("Please confirm your password ");
		String password2 = scan.nextLine();
		
		System.out.println("Please enter the name of the dog being put into the kennel: ");
		String dName = scan.nextLine();
		
		System.out.println("Please enter it's breed: ");
		String breed = scan.nextLine();
		
		System.out.println("If there are any toys the dog will be bringing please enter here: ");
		String tName = scan.nextLine();
		
		//Toy and kennel only contain their names
		Toy toy = new Toy(tName);
		PersistenceUtil.persist(toy);
		
		Kennel kennel = new Kennel(kName);
		PersistenceUtil.persist(kennel);
		
		User user = new User(uName, password);
		PersistenceUtil.persist(user);
		
		//Dog contains name, breed and then kennel and toy which are populated as foreign keys
		Dog dog = new Dog(dName, breed, kennel, toy);                               
		
		//the dog is then also added to the kennel and then persisted using a for loop
		kennel.getDog().add(dog);
		
		for(Dog d: kennel.getDog()) {
			PersistenceUtil.persist(d);
		}
		
		//merge updates the kennel to include the dog
		PersistenceUtil.merge(kennel);
	
		System.out.println("Successfully Registered!");
	}
	
	/*
	 * This method is very similar to the create method above except 
	 * it uses find methods from persistenceUtil to search for the entities and then
	 * uses merge to update them
	 */
	public void updateDog(){
		
		String findName, newName, newBreed;
		scan.nextLine();
		
		System.out.println("Pleass enter the old name of the dog you would like to update: ");            
		findName = scan.nextLine();
		
		/* After scanning the dogs name, it is fetched using the findDogByName() method
		 * A new name is then scanned and the old dogs name is set to the new name and then merged
		 */
		Dog dog = PersistenceUtil.findDogBydName(findName);
		
		System.out.println("Please enter the new name of the dog: ");
		newName = scan.nextLine();
		dog.setdName(newName);
		
		PersistenceUtil.merge(dog);
		
		//exact same for breed
		System.out.println("Please enter it's breed: ");
		newBreed = scan.nextLine();
		dog.setBreed(newBreed);
		
		PersistenceUtil.merge(dog);
	
		System.out.println("Current Dogs in System");
		viewDog();
				
	}
	
	/*
	 * This is very similar to update except that the remove method is called
	 */
    public void removeKennel(int Id){
				
		Kennel kennel = PersistenceUtil.findKennelById(Id);
		PersistenceUtil.remove(kennel);
		
		System.out.println("Kennel Deleted");
		System.out.println("Current Kennels");
		viewKennel();
				
	
	    
	}
		
	}

	
	
	
	
			

