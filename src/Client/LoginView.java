package Client;

import java.util.Scanner;

/******************************************
 * @author Bansari Patel
 * 
 * View: LoginView displays the login
 * view for the user. 
 *****************************************/
public class LoginView {
	
	private String UserName;
	private String Password;
	Scanner input = new Scanner(System.in);
	
	public LoginView() {
		
		
		
	}
	
	public LoginView(String UserName, String Password) {
		
		this.UserName = UserName;
		this.Password = Password;		
		
	}
	

	/*
	 * displayLoginView creates a login view
	 * for the admin where the user is 
	 * prompted with userID and password and
	 * on entering submit, admin is logged 
	 * in to the portal. 
	 */
	public void DisplayLoginView() {
		
		System.out.println("\nLogin Page");
		System.out.print("Username: ");
		UserName = input.next();
		System.out.print("Password: ");
		Password = input.next();
		
		System.out.print("Enter 'submit' to login: ");
		String enter = input.next();		
		
		if(enter.equals("submit")) {
			
			System.out.println("Checking the database");
			
		} else {
			
			System.out.println("Please try again");
			
		}
		
	}

	//get the user input for email address
	//inorder to use it as a reference in model
	public String getEmailAddress() {
		
		return UserName;
		
	}

	//get the user input for Password
	//inorder to use it as a reference in model
	public String getPassword() {

		return Password;
		
	}
	
}
