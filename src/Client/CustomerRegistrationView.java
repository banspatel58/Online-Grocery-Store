
package Client;

import java.util.Scanner;

/******************************************
 * @author Bansari Patel
 * 
 * View: CustomerRegistrationView displays the
 * registration view for the Customer. Admin
 * can add a new customer using this
 *****************************************/
public class CustomerRegistrationView {
	
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String Password;
	private String Type;
	Scanner input = new Scanner(System.in);
	public CustomerRegistrationView() {

		
		
	}
	
	public CustomerRegistrationView(String FirstName, String LastName, 
			String EmailAddress, String Password, String Type) {
		
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.EmailAddress = EmailAddress;
		this.Password = Password;		
		this.Type = Type;
		
	}
	/*
	 * displayRegisterCustomerView creates a 
	 * registration view for the customer where
	 * the customer is prompted with First Name
	 * Last Name, EmailID and password for 
	 * registering a customer admin that is adding
	 * a new customer to the system. 
	 */
	public void displayRegisterCustomerView() {
		
		System.out.println("\nPlease enter the following information:");
		System.out.print("First Name: ");
		this.FirstName = input.next();
		System.out.print("Last Name: ");
		this.LastName = input.next();
		System.out.print("Email Address: ");
		this.EmailAddress = input.next();
		System.out.print("Password: ");
		this.Password = input.next();
		this.Type = "Customer";
		
		System.out.print("Enter 'submit' to register: ");
		String submit = input.next();
		
		if(submit.equals("submit")) {
			
			displaySuccess(FirstName, LastName, EmailAddress, Password, Type);
			
		} else {
			
			System.out.println("Please try again");
			
		}
		
	}
	
	//displays result to the admin if registered successfully
	public void displaySuccess(String FirstName, String LastName, String EmailAddress,
			String Password, String Type) {
		
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
