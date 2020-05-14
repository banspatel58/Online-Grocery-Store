package Client;

import Controller.Command;
import Controller.InventoryCommand;
import Controller.PurchaseProductCommand;
import Controller.StoreServerInterface;

/*************************
 * @author Bansari Patel
 *
 *************************/
public class Dispatcher {

	Command AdminDashboard;
	Command CustomerDashboad;
	
	//default constructor
	public Dispatcher() {
		
		AdminDashboard = new InventoryCommand();
		CustomerDashboad = new PurchaseProductCommand();
		
	}

	//dispatches the dashboard view based on the login request made
	public void dispatch(String request, String EmailAddress, StoreServerInterface stub ) {
	        
		if(request.equalsIgnoreCase("Admin")) {
			
			AdminDashboard.display(stub);
			
		} else if (request.equalsIgnoreCase("Customer")) {

			CustomerDashboad.displayWithUserInfo(stub, EmailAddress);
			
		} else {
			
			System.out.println("Invalid request is been made. Exiting the system");
			
		}
		
		
	}
	
}
