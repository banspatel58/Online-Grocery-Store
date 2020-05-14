
package Controller;

import java.rmi.RemoteException;

import Client.AdminRegistrationView;
import Server.User;

/*********************************************************************************************
 * @author Bansari Patel
 *
 * Controller: The admin registration controller is responsible for collaborating the 
 * registration view and the user model. It allows to get the display for the upate
 * registration view and call the remote methods to make necessary inserts.
 ********************************************************************************************/
public class AdminRegistrationController{	
	
	private User user;
	private AdminRegistrationView AdminRegistration;
	
	//default constructor
	public AdminRegistrationController() {
		
		this.AdminRegistration = new AdminRegistrationView();
		this.user = new User();
		
		
	}
	
	//get method for first name
	public String getFirstName() {
		
		return AdminRegistration.getFirstName();
		
	}

	//get method for Last name
	public String getLastName() {
		
		return AdminRegistration.getLastName();
		
	}	
	
	//get method for Email Address
	public String getEmailAddress() {
		
		return AdminRegistration.getEmailAddress();
		
	}
	
	//get method for Password
	public String getPassword() {
		
		return AdminRegistration.getPassword();
		
	}
	
	//get method for Type
	public String getType() {
		
		return AdminRegistration.getType();
		
	}
	
	//displays the admin registration page and calls the register admin
	//function in order to add a new admin
	public void displayAdminRegistrationPage(StoreServerInterface stub) {
		
		AdminRegistration.displayRegisterAdminView();
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
		user.setEmailAddress(getEmailAddress());
		user.setPassword(getPassword());
		
		RegisterAdmin(stub, user);
		
	}

	//calls the AddNewUser function using remote server invocation in
	//order to add the user to the database.
	private void RegisterAdmin(StoreServerInterface stub, User user) {

		try {
			
			stub.AddNewUser(user, "Admin");
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}
		
		
	}
	
}