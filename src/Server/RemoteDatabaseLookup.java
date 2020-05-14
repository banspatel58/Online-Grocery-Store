package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.StoreServerInterface;

/*********************************************************************************************
 * @author Bansari Patel
 *
 * RemoteDesktopLookup implements the store server interface. Function calls are made using
 * remote method invocation over the server. It defines important functions that interact
 * with the database.
 ********************************************************************************************/
public class RemoteDatabaseLookup extends UnicastRemoteObject implements StoreServerInterface{

	private static final long serialVersionUID = 1L;
	private DatabaseConnection connection = null;

	RemoteDatabaseLookup(DatabaseConnection connection)throws RemoteException{
		
		super();
		System.out.println("Getting things ready");	
		this.connection = connection;
		
	}
	
	//Check if the given username and password belongs to an Admin. If so authenticate the
	//admin hence directing them to the admin dashboard.
	@Override
	public boolean VerifyAdmin(String Username, String Password) throws RemoteException {
		
		String UsernameData = "";
		String PasswordData = "";
		boolean isAdmin = false;
		
		ResultSet AdminResultSet = connection.GetAll("Admin");

		try {
			
			while(AdminResultSet.next()) {
				
				UsernameData = AdminResultSet.getString("UserName");
				PasswordData = AdminResultSet.getString("Password");
				
				if(Username.equals(UsernameData) && Password.equals(PasswordData)) {

					isAdmin = true;
					
				} 
								
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}

	    return isAdmin;
	    
	}
	
	//Check if the given username and password belongs to an Customer. If so authenticate the
	//customer hence directing them to the customer dashboard.
	@Override
	public boolean VerifyCustomer(String Username, String Password) throws RemoteException {
		
		String UsernameData = "";
		String PasswordData = "";
		boolean isCustomer = false;
		
		ResultSet AdminResultSet = connection.GetAll("Customer");

		try {
			
			while(AdminResultSet.next()) {
				
				UsernameData = AdminResultSet.getString("UserName");
				PasswordData = AdminResultSet.getString("Password");
				
				if(Username.equals(UsernameData) && Password.equals(PasswordData)) {

					isCustomer = true;
					
				} 
								
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}

	    return isCustomer;
	    
	}
	
	//displays the list of items in the inventory
	public List<Product> getAdminInventory() throws RemoteException {

		int ItemID;
		String Type;
		String ProductName;
		float ProductPrice;
		int ProductQty;
		String MeasuredUnit;
		
		List<Product> list = new ArrayList<Product>();
		ResultSet AdminResultSet = connection.GetAll("Item");
				
		try {

			while(AdminResultSet.next()) {
				
				ItemID = AdminResultSet.getInt("Item_ID");
				Type = AdminResultSet.getString("Type");
				ProductName = AdminResultSet.getString("Description");
				ProductPrice = AdminResultSet.getFloat("Price");
				ProductQty = AdminResultSet.getInt("Quantity");
				MeasuredUnit = AdminResultSet.getString("Unit");
				
				Product item = new Product();
				item.setProductID(ItemID);
				item.setType(Type);
				item.setProductName(ProductName);
				item.setProductPrice(ProductPrice);
				item.setProductQty(ProductQty);
				item.setMeasuredUnit(MeasuredUnit);
				
				list.add(item);
								
			}
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return list;
		
	}
	
	// adds a new item to the inventory
	public void AddNewItem(Product NewProduct) {
		
		int result = connection.InsertItem(NewProduct);
		
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Added the following item to the inventory successfully"); 
			System.out.println("Item_ID: " + NewProduct.getProductID()); 
			System.out.println("Type: " + NewProduct.getType()); 
			System.out.println("Name: " + NewProduct.getProductName());
			System.out.println("Price: " + NewProduct.getProductPrice()); 
			System.out.println("Quantity: " + NewProduct.getProductQty()); 
			System.out.println("Unit: " + NewProduct.getMeasuredUnit()); 
		
		} else {
			
			System.out.println("Failed to add new item. Please try again later."); 
			
		}	
		
	}
	
	//Adds a new user to either a customer or and admin table
	public void AddNewUser(User user, String table) {
		
		int result = connection.InsertUser(user, table);
		
		if(result == 1) {
			
			//displays the information of the newly added user 
			System.out.println("Registered the new user successfully"); 
			System.out.println("First Name: " + user.getFirstName()); 
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Email Address: " + user.getEmailAddress()); 
			System.out.println("Password: " + user.getPassword()); 
		
		} else {
			
			System.out.println("Failed to add new item. Please try again later."); 
			
		}	
		
	}

	//Removes an item from the inventory
	public void removeItem(int ItemID) {

		int result = connection.Delete(ItemID, "Item");

		if(result == 1) {
			
			System.out.println("\nItem with ID " + ItemID + " removed from the inventory");				
			
		} else {

			System.out.println("Failed to remove the Item from the inventory. Please try again later");				
			
		}
				
	}

	//updates the item name in the inventory using item id
	public void updateDescription(Product Item) {
		
		int result = connection.updateDescription(Item);
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Updated the description of the following item in the inventory successfully"); 
			System.out.println("\nItem with ID " + Item.getProductID() + " is updated with the following description: " + Item.getProductName());
		
		} else {
			
			System.out.println("Failed to add new item. Please try again later."); 
			
		}
				
	}

	//updates the item price in the inventory using item id
	public void updatePrice(Product Item) {

		int result = connection.updatePrice(Item);
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Updated the Price of the following item in the inventory successfully"); 
			System.out.println("\nItem with ID " + Item.getProductID() + " is updated with the following Price: " + Item.getProductPrice());
		
		} else {
			
			System.out.println("Failed to add new item. Please try again later."); 
			
		}
		
	}

	//updates the item quantity in the inventory using item id
	public void updateQty(Product Item) {

		int result = connection.updateQty(Item);
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Updated the Quantity of the following item in the inventory successfully"); 
			System.out.println("\nItem with ID " + Item.getProductID() + " is updated with the following Quantity: " + Item.getProductQty());
		
		} else {
			
			System.out.println("Failed to add new item. Please try again later."); 
			
		}
		
	}
	
	//updates the item unit in the inventory using item id
	public void updateUnit(Product Item) {

		int result = connection.updateUnit(Item);
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Updated the Unit of the following item in the inventory successfully"); 
			System.out.println("\nItem with ID " + Item.getProductID() + " is updated with the following Unit: " + Item.getMeasuredUnit());
		
		} else {
			
			System.out.println("Failed to add new item. Please try again later."); 
			
		}
		
		
	}
	
	//Displays all the items available for purchase to the customer
	public List<Product> getAvailableProducts() throws RemoteException {

		int ItemID;
		String Type;
		String ProductName;
		float ProductPrice;
		int ProductQty;
		String MeasuredUnit;
		
		List<Product> list = new ArrayList<Product>();
		ResultSet CustomerResultSet = connection.GetAll("Item");
				
		try {

			while(CustomerResultSet.next()) {
				
				ItemID = CustomerResultSet.getInt("Item_ID");
				Type = CustomerResultSet.getString("Type");
				ProductName = CustomerResultSet.getString("Description");
				ProductPrice = CustomerResultSet.getFloat("Price");
				ProductQty = CustomerResultSet.getInt("Quantity");
				MeasuredUnit = CustomerResultSet.getString("Unit");
				
				Product item = new Product();
				item.setProductID(ItemID);
				item.setType(Type);
				item.setProductName(ProductName);
				item.setProductPrice(ProductPrice);
				item.setProductQty(ProductQty);
				item.setMeasuredUnit(MeasuredUnit);
				
				list.add(item);
								
			}
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return list;
		
	}
	
	@Override
	public List<Product> getItemsInCart(int CustomerID) throws RemoteException{
		
		int ItemID;
		int ItemQty;
		
		List<Product> list = new ArrayList<Product>();
		ResultSet CustomerResultSet = connection.GetCart(CustomerID);
				
		try {

			while(CustomerResultSet.next()) {
				
				ItemID = CustomerResultSet.getInt("Item_ID");
				ItemQty = CustomerResultSet.getInt("Quantity");
				
				Product item = new Product();
				item.setProductID(ItemID);
				item.setCustomerItemQty(ItemQty);				
				list.add(item);
								
			}
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return list;
		
	}
	
	@Override
	public void AddItemToCart(Product NewItem, int CustomerID) {
		
		int result = connection.InsertItemToCart(NewItem, CustomerID);
		
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Added item to the cart successfully"); 
			System.out.println("Item_ID: " + NewItem.getProductID()); 
			System.out.println("Quantity: " + NewItem.getCustomerItemQty()); 
		
		} else {
			
			System.out.println("Failed to add new item to cart. Please try again later."); 
			
		}	
		
	}
	
	@Override
	public void removeItemFromCart(int itemID, int CustomerID) throws RemoteException {
		
		int result = connection.DeleteCartItem(itemID, CustomerID);

		if(result == 1) {
			
			System.out.println("\nItem with ID " + itemID + " removed from the cart");				
			
		} else {

			System.out.println("Failed to remove the Item from the inventory. Please try "
					+ "again later");				
			
		}
		
	}
	
	@Override
	public void Checkout(int CustomerID) throws RemoteException {
		
		int result = connection.Delete(CustomerID, "Cart");

		if(result != 0) {
			
			System.out.println("\nItems from the cart in process to deliver");				
			
		} else {

			System.out.println("Failed to remove the Item from the inventory. Please try "
					+ "again later");				
			
		}
		
	}
	
	@Override
	public void updateQtyInCart(Product Item, int CustomerID) {

		int result = connection.updateQtyInCart(Item, CustomerID);
		
		if(result == 1) {
			
			//displays the information of the newly added item to the inventory
			System.out.println("Updated the Quantity of the following item in the cart "
					+ "successfully"); 
			System.out.println("\nItem with ID " + Item.getProductID() + " is updated with"
					+ " the following Quantity: " + Item.getCustomerItemQty());
		
		} else {
			
			System.out.println("Failed to update quantity. Please try again later."); 
			
		}
		
	}
        
	public int GetCustomerID(String EmailAddress) {

		int userID = 0;
		ResultSet CustomerResultSet = connection.GetUserID(EmailAddress);
		try {

			while(CustomerResultSet.next()) {
				
				userID = CustomerResultSet.getInt("Customer_ID");
								
			}
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		System.out.println("User ID " + userID); 
		return userID;
		
	}
	
	//Removes an item from the inventory
	public void removeCustomer(int ID) {

		int result = connection.Delete(ID, "Customer");

		if(result == 1) {
			
			System.out.println("\nCustomer with ID " + ID + " removed");				
			
		} else {

			System.out.println("Failed to remove the Item from the inventory. Please try again later");				
			
		}
				
	}
	
	//Removes an item from the inventory
	public List<User> getAllCustomer(String Table) throws RemoteException{
		
		int ID;
		String FirstName;
		String LastName;
		String UserName;
		String Password;
		
		List<User> list = new ArrayList<User>();
		ResultSet CustomerResultSet = connection.GetAll("Customer");
				
		try {

			while(CustomerResultSet.next()) {
				
				ID = CustomerResultSet.getInt("Customer_ID");
				FirstName = CustomerResultSet.getString("FirstName");
				LastName = CustomerResultSet.getString("LastName");
				UserName = CustomerResultSet.getString("UserName");
				Password = CustomerResultSet.getString("Password");
				
				User user = new User();
				user.setUserID(ID);
				user.setFirstName(FirstName);
				user.setLastName(LastName);
				user.setEmailAddress(UserName);
				user.setPassword(Password);
								
				list.add(user);
								
			}
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return list;
		
	}

	
}
