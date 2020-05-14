package Controller;

public class PurchaseProductCommand implements Command{
	
	private CustomerDashboardController customerController;
	
	public PurchaseProductCommand() {
		
		this.customerController = new CustomerDashboardController();
		
	}
	
	@Override
	public void execute(StoreServerInterface stub) {

	
	}

	@Override
	public void display(StoreServerInterface stub) {

		//customerController.viewCustomerDashbaord(stub);		
		
	}
	
	@Override
	public void displayWithUserInfo(StoreServerInterface stub, String Email){
		
		customerController.viewCustomerDashbaord(stub, Email);			
		
	}

}
