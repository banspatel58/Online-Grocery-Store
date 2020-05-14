/**
 * 
 */
package Controller;

import java.rmi.RemoteException;

import Client.CustomerRegistrationView;
import Server.User;

/*********************************************************************************************
 * @author Bansari Patel
 *
 * Controller: The customer registration controller is responsible for collaborating the 
 * registration view and the user model. It allows to get the display for the upate
 * registration view and call the remote methods to make necessary inserts.
 ********************************************************************************************/
public class CustomerRegistrationController {

	private User user;
	private CustomerRegistrationView CustomerRegistration;
	
	//default constructor
	public CustomerRegistrationController() {
		
		this.CustomerRegistration = new CustomerRegistrationView();
		this.user = new User();
		
		
	}
	
	//get method for first name
	public String getFirstName() {
		
		return CustomerRegistration.getFirstName();
		
	}

	//get method for Last name
	public String getLastName() {
		
		return CustomerRegistration.getLastName();
		
	}	
	
	//get method for Email Address
	public String getEmailAddress() {
		
		return CustomerRegistration.getEmailAddress();
		
	}
	
	//get method for Password
	public String getPassword() {
		
		return CustomerRegistration.getPassword();
		
	}
	
	//get method for Type
	public String getType() {
		
		return CustomerRegistration.getType();
		
	}
	
	//displays the customer registration page and calls the register
	//customer function in order to add a new customer
	public void displayCustomerRegistrationPage(StoreServerInterface stub) {
		
		CustomerRegistration.displayRegisterCustomerView();
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
		user.setEmailAddress(getEmailAddress());
		user.setPassword(getPassword());
		
		RegisterCustomer(stub, user);
		
	}

	//calls the AddNewUser function using remote server invocation in
	//order to add the user to the database.
	private void RegisterCustomer(StoreServerInterface stub, User user) {

		try {
			
			stub.AddNewUser(user, "Customer");
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}
		
		
	}

}
