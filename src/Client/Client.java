package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Controller.Command;
import Controller.StoreServerInterface;

/****************************************************************************
 * Class  : Client represents the client side of the online grocery store
 * It Performs the action requested by the user by sending request to the
 * server like: logging in as an Admin/Customer and/or Registering in as 
 * an Admin/Customer
 ***************************************************************************/
public class Client{
	
	public static void main(String [] args) {
						
		try {
			
			String host = args[0];
            int port = Integer.parseInt(args[1]);
            
            String name = "//"+host+":"+port+"/OnlineGroceryStore";

            Registry registry = LocateRegistry.getRegistry(host, port);

			StoreServerInterface stub = (StoreServerInterface)registry.lookup(name);
			System.out.println("Found the Store Server");
			
			// Getting the user input from the displayed menu
			System.out.println("Welcome to the Online Grocery Store\n");
			
			// variables for collecting the user input
			Scanner input = new Scanner(System.in);
			int userInput;
			
			AbstractCommandFactory AdminFactory = FactoryProducer.getFactory("Admin");
			AbstractCommandFactory CustomerFactory = FactoryProducer.getFactory("Customer");
			
			if(AdminFactory == null) {
				
				System.out.println("Admin Factory doesn't exist.");
	            System.exit(1);
				
			}
			
			if(CustomerFactory == null) {
				
				System.out.println("Customer Factory doesn't exist.");
	            System.exit(1);
				
			}
			
			System.out.println("Please choose from the following: \n 1. Login \n "
					+ "2. Register Admin \n 3. Register Customer \n 4. Quit");
			System.out.print("What would you like to do today?: ");
			userInput = input.nextInt();
						
			if(userInput == 1) {

				// requesting the server to redirect the user to the admin login page
				System.out.println("Redirecting to the login view ");
				System.out.println("Please wait...");

				Command login = AdminFactory.CreateCommand("Login");
				
				login.display(stub);
				
				login.execute(stub);
				
			}else if (userInput == 2) {
				
				// requesting the server to redirect the user to the admin registration page
				System.out.println("Redirecting to the admin registration view ");
				System.out.println("Please wait...");

				Command AdminRegister = AdminFactory.CreateCommand("Register");
				AdminRegister.display(stub);				
				
			}else if(userInput == 3) {
				
				// requesting the server to redirect the user to the customer registration page
				System.out.println("Redirecting to the customer registration view ");
				System.out.println("Please wait...");
				
				Command CustomerRegister = CustomerFactory.CreateCommand("Register");
				CustomerRegister.display(stub);
				
			} else {
				
				// throws an error for invalid input
				System.out.println("\nInvalid Option. Please try again");
				
			}
			
		}catch(Exception e) {
			
			System.out.println("Account access error : " + e.getMessage());
       		e.printStackTrace();		
			
		}		
		
	}
	
}
