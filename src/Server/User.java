package Server;

/********************************************************************************
 * @author Bansari Patel
 * 
 * Modal: UserModel is a user object that contains the attribute that belongs to
 * each user namely First Name, Last Name, Email address, Password and the type
 * of user. It also helps update the main controller functions like display
 * admin log in or customer login and display admin registration of the customer
 * registration.
 ********************************************************************************/
public class User implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int UserID;
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String Password;
	private String Type;

	public User() {
		
		
	}


	//get and set methods for first name
	public String getFirstName() {
		
		return FirstName;
		
	}

	public void setFirstName(String FirstName) {
		
		this.FirstName = FirstName;
		
	}

	//get and set methods for Last name
	public String getLastName() {
		
		return LastName;
		
	}

	public void setLastName(String LastName) {
		
		this.LastName = LastName;
		
	}

	//get and set methods for Email Address
	public String getEmailAddress() {
		
		return EmailAddress;
		
	}

	public void setEmailAddress(String EmailAddress) {
		
		this.EmailAddress = EmailAddress;
		
	}

	//get and set methods for Password
	public String getPassword() {
		
		return Password;
		
	}

	public void setPassword(String Password) {
		
		this.Password = Password;
		
	}

	//get and set methods for type: Admin vs user
	public String getType() {
		
		return Type;
		
	}

	public void setType(String Type) {
		
		this.Type = Type;
		
	}

	//get and set methods for id: Admin vs user
	public int getUserID() {
		
		return UserID;
		
	}


	public void setUserID(int ID) {
		
		UserID = ID;
		
	}


}