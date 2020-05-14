package Controller;

/********************************************
 * @author Bansari Patel
 *
 * Login Command class is responsible for
 * creating a command for the login process
 * It displays the login Page and takes the
 * user input to login the Admin
 *******************************************/
public class LoginCommand implements Command{
	
	private LoginController loginController;
	
	public LoginCommand() {

		this.loginController = new LoginController();
				
	}
		
	//responsible for authenticating the user and
	//making a request to redirect to thier 
	//respective dashboards.
	@Override
	public void execute(StoreServerInterface stub) {

		loginController.makeRequest(stub);
		
	}

	//displays the login view.
	@Override
	public void display(StoreServerInterface stub ) {

		loginController.displayLogin(stub);
		
	}
	
}