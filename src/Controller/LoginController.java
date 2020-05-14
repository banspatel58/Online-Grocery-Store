package Controller;

import java.rmi.RemoteException;

import Client.Dispatcher;
import Client.LoginView;
import Server.User;

/********************************************
 * @author Bansari Patel
 *
 * Controller: LoginController controls the
 * action on the login window. The most  
 * crucial part is validating the user 
 * attempting to login to the system. 
 *******************************************/
public class LoginController{

	private LoginView loginView;	
	private Dispatcher dispatcher;
	private User user;

	
	public LoginController() {

		this.loginView = new LoginView();
		this.user = new User();
		this.dispatcher = new Dispatcher();
		
	}
	
	//get and set methods for email address
	public void setEmailAddress(String EmailAddress) {
	
		user.setEmailAddress(EmailAddress);
		
	}

	public String getEmailAddress() {
		
		return loginView.getEmailAddress();
		
	}
	
	//get and set methods for password	
	public void setPassword(String Password) {
	
		user.setPassword(Password);
		
	}

	public String getPassword() {
		
		return loginView.getPassword();
		
	}	

	//get and set methods for type: Admin vs user
	public String getType() {
		
		return user.getType();
		
	}
	
	//display the loginview to the user
	public void displayLogin(StoreServerInterface stub) {
		
		loginView.DisplayLoginView();
		user.setEmailAddress(getEmailAddress());
		user.setPassword(getPassword());
		
		//validate the user from the database
		String Username = user.getEmailAddress();
		String Password = user.getPassword();
		System.out.println("Using username: " + Username + " and password " + Password + 
				" to login");
		isAuthenticUser(stub, Username, Password);
				
	}
	
	private void isAuthenticUser(StoreServerInterface stub, String Username, String Password) {
		
		try {
			
			if(stub.VerifyAdmin(Username, Password)) {
				
				user.setType("Admin");
				
			    System.out.println("FrontController authentication: User is authenticated successfully.");
			    System.out.println("User logged in. Updated the data");
				
			} else if (stub.VerifyCustomer(Username, Password)) {
				
				user.setType("Customer");
				
			    System.out.println("FrontController authentication: User is authenticated successfully.");
			    System.out.println("User logged in. Updated the data");
				
			} else {
				
				 System.out.println("User is cannot be verified!!");
				
			}
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}
		
	}
	
	
	//log each request made by the user
	private void trackRequest( String request ) {
		
		System.out.println("FrontController tracking: Page requested: " + request);
		
	}
	
	//call the dispacthcer function which displays the dashboard view.
	public void dispatchRequest(String request, StoreServerInterface stub) {
				
	    // log each request
	    trackRequest(request);
	    
	    System.out.println("FrontController dispatching request");
	    dispatcher.dispatch(request, user.getEmailAddress(), stub);
	    
	}
	
	//make a request to display a view corresponding to the type of user
	public void makeRequest(StoreServerInterface stub) {
		
		dispatchRequest(user.getType(), stub);
				
	}
	
}