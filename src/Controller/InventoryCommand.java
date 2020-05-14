package Controller;

/*************************************************
 * @author Bansari Patel
 *
 * Inventory Command class is responsible for
 * creating a command for the Admin Dashboard
 * It displays the Dashboard Page and takes the
 * user input from the Admin to preform necessary
 * actions.
 ************************************************/
public class InventoryCommand implements Command {

	private AdminDashboardController AdminDashboard;

	public InventoryCommand() {

		this.AdminDashboard = new AdminDashboardController();
		
	}

	@Override
	public void execute(StoreServerInterface stub) {
		
		
		
	}

	//displays the admin dahboard view
	@Override
	public void display(StoreServerInterface stub) {

		AdminDashboard.viewAdminDashbaord(stub);
		
	}


}
