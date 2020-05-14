package Client;

import java.util.Scanner;

/******************************************
 * View: AdminDashboardView displays the 
 * list of functionalities an admin can 
 * do.
 *****************************************/
public class AdminDashboardView{
	
	Scanner input = new Scanner(System.in);
	
	//default constructor
	public AdminDashboardView() {
		
		
		
	}	
	
	/*
	 * displayAdminDashboard displays a view which
	 * represents list of functionalities an admin
	 * can do.  This function allows admin to view
	 * the inventory, update the inventory, add a
	 * new admin, add/remove a customer.
	 */
	public int displayAdminDashboard() {
		
		System.out.println("Welcome!!\n\nWhat would you like to do today?");
					
		System.out.println("Chose from the following option:");
		
		System.out.println("\n1. View Inventory"
				+ "\n2. Update Inventory"
				+ "\n3. Add Customer"
				+ "\n4. Remove Customer"
				+ "\n5. Add Admin"
				+ "\n6. Quit");
		System.out.print("What would you like to do?: ");
		int userInput = input.nextInt();
		
		return userInput;
				
	}
	
	public int UpdateInventory() {
		
		System.out.println("Welcome!!\n\nWhat would you like to do today?");
					
		System.out.println("Chose from the following option:");
		
		System.out.println("\n1. View Inventory"
				+ "\n2. Update Inventory"
				+ "\n3. Add/Remove Customer"
				+ "\n4. Add Admin"
				+ "\n5. Quit");
		System.out.print("What would you like to do?: ");
		int userInput = input.nextInt();
		
		return userInput;
				
	}
	
	public int RemoveCustomer() {
		
		System.out.println("Please enter the customer ID to remove");
					
		System.out.print("CustomerID:");
		int userInput = input.nextInt();
		
		return userInput;
				
	}
	
}
