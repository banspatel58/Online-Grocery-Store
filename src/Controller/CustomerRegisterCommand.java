package Controller;

/************************************************
 * @author Bansari Patel
 *
 * Registration Command class is responsible for
 * creating a cmmand for the registration process
 * It displays the customer Rgistration Page and 
 * takes the user input to register the customer
 ***********************************************/
public class CustomerRegisterCommand implements Command {

	private CustomerRegistrationController CustomerRegistration;
	
	public CustomerRegisterCommand() {

		this.CustomerRegistration = new CustomerRegistrationController();
		
	}

	@Override
	public void execute(StoreServerInterface stub) {

		

	}

	@Override
	public void display(StoreServerInterface stub) {

		CustomerRegistration.displayCustomerRegistrationPage(stub);

	}

}
