package Controller;

/*****************************************
 * @author Bansari Patel
 *
 ****************************************/
public class AddToCartCommand implements Command {

	private CartController cartController;
	
	public AddToCartCommand() {

		this.cartController = new CartController();
		
	}

	@Override
	public void execute(StoreServerInterface stub) {

	
	
	}

	@Override
	public void display(StoreServerInterface stub) {
		
		
		
	}


	@Override
	public void displayWithUserInfo(StoreServerInterface stub, String Email){
		
		cartController.displayUpdateCartView(stub, Email);			
		
	}
	
}
