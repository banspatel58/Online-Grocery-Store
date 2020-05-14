package Client;

import java.util.Scanner;

/******************************************
 * @author Bansari Patel
 * 
 * View: AdminRegistrationView displays the
 * registration view for the admin. Admin
 * can add a new admin using this
 *****************************************/
public class AdminRegistrationView{
	
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String Password;
	private String Type;
	Scanner input = new Scanner(System.in);
	
	//default constructor
	public AdminRegistrationView() {

		
		
	}	
	
	public AdminRegistrationView(String FirstName, String LastName, String EmailAddress, String Password, String Type) {
		
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.EmailAddress = EmailAddress;
		this.Password = Password;		
		this.Type = Type;
		
	}
	/*
	 * displayRegisterAdminView creates a 
	 * registration view for the admin where
	 * the admin is prompted with First Name
	 * Last Name, EmailID and password for 
	 * registering a new admin that is adding
	 * a new admin to the system. 
	 */
	public void displayRegisterAdminView() {
		
		System.out.println("\nPlease enter the following information:");
		System.out.print("First Name: ");
		this.FirstName = input.next();
		System.out.print("Last Name: ");
		this.LastName = input.next();
		System.out.print("Email Address: ");
		this.EmailAddress = input.next();
		System.out.print("Password: ");
		this.Password = input.next();
		this.Type = "Admin";
		
		System.out.print("Enter 'submit' to register: ");
		String submit = input.next();
		
		if(submit.equals("submit")) {
			
			displaySuccess(FirstName, LastName, EmailAddress, Password, Type);
			
		} else {
			
			System.out.println("Please try again");
			
		}
		
	}
	
	//displays result to the admin if registered successfully
	public void displaySuccess(String FirstName, String LastName, String EmailAddress, String Password,
			String Type) {
		
		System.out.println("\nRegistering:\n"
				+ "First Name: " + FirstName
				+ "\nLast Name: " + LastName
				+ "\nEmailAddress: " + EmailAddress
				+ "\nPassword: " + Password
				+ "\nUser as " + Type + "\n");
		
	}
	
	public String getFirstName() {
		
		return this.FirstName;
		
	}

	public String getLastName() {
		
		return this.LastName;
		
	}

	public String getEmailAddress() {
		
		return this.EmailAddress;
		
	}
	
	public String getPassword() {
		
		return this.Password;
		
	}
	
	public String getType() {
		
		return this.Type;
		
	}

}