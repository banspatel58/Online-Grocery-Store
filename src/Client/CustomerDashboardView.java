package Client;

import java.util.Scanner;

/******************************************
 * View: CustomerView displays the 
 * list of functionalities a Customer can 
 * do.
 *****************************************/
public class CustomerDashboardView{
    
	Scanner input = new Scanner(System.in);
	
    //default constructor
    public CustomerDashboardView() {
    	
    	
    	
    }
    
    /*
     * displayAvailableProducts method displays a view which
     * represents list of functionalities a customer can do.
     * This method allows the customer to view all the items 
     * available for purchase and then add the desired items 
     * to the cart, redirects to the cart.
     */    
    public int displayDashboard() {
        
        System.out.println("Welcome to the shopping website");
        System.out.println("\nStart purchasing from the items listed");
        System.out.println("\nPlease choose from the following:");
		System.out.println("1. View Items available for purchase");
		System.out.println("2. Make Purchase");
		System.out.println("3. Quit");
		
		
		System.out.print("\nWhat would you like to do?: ");
		int CustomerInput = input.nextInt();
		
		return CustomerInput;
        
   
    }
    
}