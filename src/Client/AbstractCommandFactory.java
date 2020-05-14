
package Client;

import Controller.Command;
import Controller.LoginCommand;

/***********************************************
 * @author Bansari Patel
 *
 * Abstract CommandFactory is responsible for 
 * creating commands.
 **********************************************/
public abstract class AbstractCommandFactory {

	public abstract Command CreateCommand(String Type);
	
	LoginCommand CreateLoginCommand;

}
