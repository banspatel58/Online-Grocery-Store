package Controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

import Client.AbstractCommandFactory;
import Client.CustomerDashboardView;
import Client.FactoryProducer;
import Server.Product;

/***********************************
 * @author Bansari Patel
 *
 * CustomerDashboardController displays
 * the list of items in the inventory
 * to the Customer. 
 **********************************/
public class CustomerDashboardController {

	private CustomerDashboardView CustomerView;
	private Command AddToCart;
	int userInput;
    Scanner input = new Scanner(System.in);    
	
	public CustomerDashboardController() {
		
		this.CustomerView = new CustomerDashboardView();
		AbstractCommandFactory CustomerFactory = FactoryProducer.getFactory("Customer");
		this.AddToCart = CustomerFactory.CreateCommand("PurchaseProduct");
		
	}
	
	//displays Customer Dashboard and displays list of available products of purchase to customer
	public void viewCustomerDashbaord(StoreServerInterface stub, String email) {
		
		boolean KeepGoing = true;
		while(KeepGoing) {
			
			int CustomerInput = CustomerView.displayDashboard();
			
			if(CustomerInput == 1) {
				
				System.out.println("\nDisplaying the list of available items");
			
				try {
								
					List<Product> list = stub.getAvailableProducts();
					viewProductDetails(list);			
					
				} catch (RemoteException e) {
			
					e.printStackTrace();
					
				} 
				
				KeepGoing = true;
				
			}else if(CustomerInput == 2) {
				
				AddToCart.displayWithUserInfo(stub, email);
				KeepGoing = true;
				
			} else if(CustomerInput == 3) {
				
				KeepGoing = false;
				
			} else {
				
				KeepGoing = false;
			}
			
		}
		
	}
	
	//gets the list of items to purchase
	public void viewProductDetails(List<Product> list) {
		
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

}
