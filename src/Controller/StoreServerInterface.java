package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Server.Product;
import Server.User;

/************************************************
 * @author Bansari Patel
 * 
 * Methods in the Store Server Interface are 
 * called remotely using remote method 
 * invocation. It basically contains methods 
 * that require interaction with the database
 ***********************************************/
public interface StoreServerInterface extends Remote{

	public default void updateDatabase() throws RemoteException{
		
		System.out.println("Database updated");		
		
	}
	
	public default boolean VerifyAdmin(String Username, String Password) throws RemoteException {
		
		System.out.println("Verifying Admin");
		return false;
		
	}
	
	public default boolean VerifyCustomer(String Username, String Password) throws RemoteException {
		
		System.out.println("Verifying Customer");
		return false;
		
	}
	
	public default List<Product> getAdminInventory() throws RemoteException {
		
		System.out.println("Retrieving Inventory");
		return null;
		
	}	
	
	public default void AddNewItem(Product item) throws RemoteException {
		
		System.out.println("Adding Item to the Inventory");
		
	}
	
	public default void removeItem(int itemID) throws RemoteException {
		
		System.out.println("Removing Item from the Inventory");
		
	}

	public default void updateDescription(Product item) throws RemoteException {
		
		System.out.println("Updating the description of the Item in the Inventory");
		
	}
	
	public default void updateQty(Product item) throws RemoteException {
		
		System.out.println("Updating the quantity of the Item in the Inventory");
		
	}
	
	public default void updatePrice(Product item) throws RemoteException {
		
		System.out.println("Updating the price of the Item in the Inventory");
		
	}
	
	public default void AddNewUser(User user, String string) throws RemoteException {
		
		System.out.println("Registering User");
		
	}

	public default List<Product> getItemsInCart(int CustomerID) throws RemoteException{
		
		System.out.println("Retrieving Items in cart");
		return null;
		
	}	

	public default List<Product> getAvailableProducts() throws RemoteException {
		
		System.out.println("Retrieving Available Products");
		return null;
		
	}
	
	public default void AddItemToCart(Product Item, int CustomerID) throws RemoteException {
		
		System.out.println("Adding Item to the Cart");
		
	}
	
	public default void removeItemFromCart(int itemID, int CustomerID) throws RemoteException {
		
		System.out.println("Removing Item from the Inventory");
		
	}
	
	public default void updateQtyInCart(Product item, int CustomerID) throws RemoteException {
		
		System.out.println("Updating the quantity of the Item in the Inventory");
		
	}
	
	public default int GetCustomerID(String EmailAddress) throws RemoteException{
		
		System.out.println("Getting User information");
		return 0;		
		
	}
	
	public default void Checkout(int CustomerID) throws RemoteException {
		
		System.out.println("Checking out");
		
	}

	public default void removeCustomer(int ID) throws RemoteException{
		
		System.out.println("Removing Customer");
		
	}
	
	public default List<User> getAllCustomer(String Table) throws RemoteException{
		
		System.out.println("Getting list of Customer");
		return null;
		
	}
	
}