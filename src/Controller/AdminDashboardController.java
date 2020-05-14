package Controller;

import java.rmi.RemoteException;
import java.util.List;

import Client.AbstractCommandFactory;
import Client.AdminDashboardView;
import Client.FactoryProducer;
import Server.Product;
import Server.User;

/***********************************
 * @author Bansari Patel
 *
 * AdminDashboardController displays
 * the list of items in the inventory
 * to the admin. 
 **********************************/
public class AdminDashboardController {

	private AdminDashboardView AdminView;
	private Command UpdateInventory;
	private Command AddAdmin;
	private Command AddCustomer;
	int userInput;
	int AdminInput;
	
	public AdminDashboardController() {

		//creates AdminCommand Factory to generate AdminCommand
		AbstractCommandFactory AdminFactory = FactoryProducer.getFactory("Admin");
		AbstractCommandFactory CustomerFactory = FactoryProducer.getFactory("Customer");
		this.AdminView = new AdminDashboardView();
		this.UpdateInventory = AdminFactory.CreateCommand("Update Inventory");
		this.AddAdmin = AdminFactory.CreateCommand("Register");
		this.AddCustomer = CustomerFactory.CreateCommand("Register");
		
	}
	
	//displays Admin Dashboard and performs action as per admin input
	public void viewAdminDashbaord(StoreServerInterface stub) {
		
		boolean KeepGoing = true;
		
		while(KeepGoing) {
			
			userInput = AdminView.displayAdminDashboard();
		
			if(userInput == 1) {
				
				System.out.println("Displaying the inventory");

				try {
					
					List<Product> list = stub.getAdminInventory();
					viewInventory(list);
					
				} catch (RemoteException e) {

					e.printStackTrace();
					
				} 
				KeepGoing = true;
				
			} else if (userInput == 2){

				//calls the update inventory view
				UpdateInventory.display(stub);
				KeepGoing = true;
				
			} else if (userInput == 3){
				
				AddCustomer.display(stub);
				KeepGoing = true;
				
				
			} else if (userInput == 4){

				//takes the admin to the registraion page 
				// inorder for them to add new admins
				try {
					
					List<User> CustomerList = stub.getAllCustomer("Customer");
					viewCustomer(CustomerList);
					int customerID = AdminView.RemoveCustomer();
					stub.removeCustomer(customerID);
					
				} catch (RemoteException e) {

					e.printStackTrace();
					
				}
				KeepGoing = true;
				
			} else if (userInput == 5){

				//takes the admin to the registraion page 
				// inorder for them to add new admins
				AddAdmin.display(stub);
				KeepGoing = true;
				
			} else if (userInput == 6){

				//quit
				KeepGoing = false;
				
			} else {
				
				System.out.println("Invalid input. Please try again");
				KeepGoing = false;
				
			}		
			
			
		}
		
	}
	
	//gets the list of items in the inventory
	public void viewInventory(List<Product> list) {
		
		System.out.println("This is AdminInventory Model"); 
        for (Product Item:list) { 
            
           System.out.print("Item_ID: " + Item.getProductID() ); 
           System.out.print("\tType: " + Item.getType() ); 
           System.out.print("\tName: " + Item.getProductName() ); 
           System.out.print("\tPrice: " + Item.getProductPrice() ); 
           System.out.print("\tQuantity: " + Item.getProductQty() ); 
           System.out.print("\tUnit: " + Item.getMeasuredUnit() ); 
           System.out.println();
           
        } 
		
	}
	
	//gets the list of items in the inventory
	public void viewCustomer(List<User> list) {
		
		System.out.println("This is AdminInventory Model"); 
        for (User user:list) { 
            
           System.out.print("ID: " + user.getUserID() ); 
           System.out.print("\tFirstName: " + user.getFirstName() ); 
           System.out.print("\tLastName: " + user.getLastName() ); 
           System.out.print("\tUserName: " + user.getEmailAddress() ); 
           System.out.print("\tPassword: " + user.getPassword() ); 
           System.out.println();
           
        } 
		
	}
	
}
