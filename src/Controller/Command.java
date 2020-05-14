package Controller;

/********************************************
 * @author Bansari Patel
 *
 * Interface: Command is responsible for
 * creating commands to execute functions
 * These commands are designed as a part
 * of command patterns to add a layer of
 * abstractions for different commands 
 * executed by an admin or a customer
 *******************************************/
public interface Command {

	void execute(StoreServerInterface stub);
	
	void display(StoreServerInterface stub);
	
	public default void displayWithUserInfo(StoreServerInterface stub, String Email){
		
		System.out.println("Displaying with user information");		
		
	}
	
}
