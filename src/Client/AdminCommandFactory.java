/**
 * 
 */
package Client;

import Controller.AdminRegisterCommand;
import Controller.Command;
import Controller.InventoryCommand;
import Controller.LoginCommand;
import Controller.UpdateInventoryCommand;

/******************************************************
 * @author Bansari Patel
 *
 * AdminCommandFactory extends the Abstract Command 
 * Factory and is responsible for creating the admin
 * commands like: login command, register command, 
 * View Dashboard command, update inventory command
 * etc.
 *****************************************************/
public class AdminCommandFactory extends AbstractCommandFactory {


	public AdminCommandFactory() {


		
	}

	@Override
	public Command CreateCommand(String Type) {

		if(Type.equalsIgnoreCase("Login")) {
			
			return CreateLoginCommand();
			
		} else if(Type.equalsIgnoreCase("Inventory")){
			
			return CreateInventoryCommand();
			
		}else if(Type.equalsIgnoreCase("Update Inventory")){
			
			return CreateUpdateInventoryCommand();
			
		} else {
			
			return CreateRegisterCommand();
			
		}
		
	}	
	
	LoginCommand CreateLoginCommand() {
		
		return new LoginCommand();
		
	}
	
	AdminRegisterCommand CreateRegisterCommand() {
		
		return new AdminRegisterCommand();
		
	}
	
	InventoryCommand CreateInventoryCommand() {
		
		return new InventoryCommand();
		
	}
	
	UpdateInventoryCommand CreateUpdateInventoryCommand() {
		
		return new UpdateInventoryCommand();
		
	}

}
