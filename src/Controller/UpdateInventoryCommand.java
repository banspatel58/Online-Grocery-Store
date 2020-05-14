/**
 * 
 */
package Controller;

/*******************************************************
 * @author Bansari Patel
 * Command: Update Inventory Command is responsible for
 * creating the display and execute function for the
 * update inventory. It implements the command class
 ******************************************************/
public class UpdateInventoryCommand implements Command {
	
	private UpdateInventoryController updateInventory;

	public UpdateInventoryCommand() {

		this.updateInventory = new UpdateInventoryController();
		
	}

	@Override
	public void execute(StoreServerInterface stub) {

		

	}

	@Override
	public void display(StoreServerInterface stub) {

		updateInventory.displayUpdateInventoryView(stub);

	}

}
