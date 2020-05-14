
package Controller;

/************************************************
 * @author Bansari Patel
 *
 * Registration Command class is responsible for
 * creating a cmmand for the registration process
 * It displays the Admin Rgistration Page and 
 * takes the user input to register the Admin
 ***********************************************/
public class AdminRegisterCommand implements Command {

	private AdminRegistrationController AdminRegistration;
	
	public AdminRegisterCommand() {

		this.AdminRegistration = new AdminRegistrationController();
		
	}

	@Override
	public void execute(StoreServerInterface stub) {

	
	
	}

	@Override
	public void display(StoreServerInterface stub) {

		AdminRegistration.displayAdminRegistrationPage(stub);
		
	}
	

}
