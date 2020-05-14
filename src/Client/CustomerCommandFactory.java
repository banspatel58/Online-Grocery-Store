package Client;

import Controller.AddToCartCommand;
import Controller.Command;
import Controller.CustomerRegisterCommand;
import Controller.LoginCommand;

/******************************************************
 * @author Bansari Patel
 *
 * CustomerCommandFactory extends the Abstract Command 
 * Factory and is responsible for creating the customer
 * commands like: login command, register command, 
 * View Dashboard command, view inventory command
 * add item to the cart etc.
 *****************************************************/
public class CustomerCommandFactory extends AbstractCommandFactory {


	public CustomerCommandFactory() {

		
		
	}


	@Override
	public Command CreateCommand(String Type) {

		if(Type.equalsIgnoreCase("Login")) {
			
			return CreateLoginCommand();
			
		}  else if(Type.equalsIgnoreCase("PurchaseProduct")){
			
			return CreateAddToCartCommand();
			
		} else if(Type.equalsIgnoreCase("Register")){
			
			return CreateRegisterCommand();
			
		} else {
			
			
			
		}
		return null;
		
	}	
	
	LoginCommand CreateLoginCommand() {
		
		return new LoginCommand();
		
	}
	
	CustomerRegisterCommand CreateRegisterCommand() {
		
		return new CustomerRegisterCommand();
		
	}
	
	AddToCartCommand CreateAddToCartCommand() {
		
		return new AddToCartCommand();
		
	}

}
