package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/******************************************************
 * @author Bansari Patel
 *
 * This class is responsible for database related 
 * activities like insert, select, update and delete.
 * A connection to the sql server is established in
 * this class and the connection is used to make 
 * transaction in the database.
 ******************************************************/
public class DatabaseConnection {
	
	public static Connection createConnection() {
		
		Connection connection = null;
		
		//MySQL URL and followed by the database name
		String url = "jdbc:mysql://localhost:6824/onlinestore?useSSL=false";
		
		//MySQL username and Password
		String DatabaseUserName = "Admin";
		String DatabasePassword = "";
		
		try {
			
			try {
				
				//loading mysql driver 
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (Exception err) {
				
				err.printStackTrace();
				
			}
			
			//attempting to connect to MySQL database
			connection = DriverManager.getConnection(url, DatabaseUserName, DatabasePassword);
			System.out.println("Printing connection object " + connection);
			
			
		} catch (Exception err) {
			
			err.printStackTrace();
			
		}
		
		return connection;
		
	}

	public ResultSet GetAll(String Table) {

		Connection connection = null;
		Statement statement = null;
		ResultSet ResultSet = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
			
			//Statement is used to write queries. Read more about it.
			statement = connection.createStatement();
			
			//Fetching all the records and storing in a resultSet.
			ResultSet = statement.executeQuery("SELECT * FROM " + Table);
						
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return ResultSet;
		
	}
	
	public int InsertItem(Product NewProduct) {
		
		int ItemID = NewProduct.getProductID();
		String Type = NewProduct.getType();
		String ProductName = NewProduct.getProductName();
		float ProductPrice = NewProduct.getProductPrice();
		int ProductQty = NewProduct.getProductQty();
		String MeasuredUnit = NewProduct.getMeasuredUnit();
		int result = 0;
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("INSERT INTO Item VALUES (?, ?, ?, ?, ?, ?)");
			
			statement.setInt(1, ItemID);
			statement.setString(2, Type);
			statement.setString(3, ProductName);
			statement.setFloat(4, ProductPrice);
			statement.setInt(5, ProductQty);
			statement.setString(6, MeasuredUnit);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
						
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public int InsertUser(User user, String table) {
		
		String FirstName = user.getFirstName();
		String LastName = user.getLastName();
		String Username = user.getEmailAddress();
		String Password = user.getPassword();
		int result = 0;
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("INSERT INTO " + table + " VALUES (NULL, ?, ?, ?, ?)");
			
			//ItemID = statement.setInt("Item_ID");
			statement.setString(1, FirstName);
			statement.setString(2, LastName);
			statement.setString(3, Username);
			statement.setString(4, Password);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
						
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public int Delete(int ID, String table) {
		
		Connection connection = null;
		Statement statement = null;
		int result = 0;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
			
			//Statement is used to write queries. Read more about it.
			statement = connection.createStatement();
			
			if(table.equalsIgnoreCase("Item")) {

				//Fetching all the records and storing in a resultSet.
				result = statement.executeUpdate("DELETE FROM Item WHERE Item_ID = " + ID);
				
				
			} else if(table.equalsIgnoreCase("Admin")) {

				//Fetching all the records and storing in a resultSet.
				result = statement.executeUpdate("DELETE FROM Admin WHERE Admin_ID = " + ID);
				
				
			} else if(table.equalsIgnoreCase("Customer")) {

				//Fetching all the records and storing in a resultSet.
				result = statement.executeUpdate("DELETE FROM Customer WHERE Customer_ID = " + ID);
				
				
			} else if(table.equalsIgnoreCase("Cart")) {

				//Fetching all the records and storing in a resultSet.
				result = statement.executeUpdate("DELETE FROM Cart WHERE Customer_ID = " + ID);
				
				
			} else {
				
				System.out.println("Table doesn't exist. Please try again later.");
				
			}
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		System.out.println("Result:." + result);
		return result;		
		
	}
	
	public int updateDescription(Product Item) {
					
		int Item_ID = Item.getProductID();
		String ProductName = Item.getProductName();
		int result = 0;
					
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("UPDATE Item SET Description=? WHERE Item_ID=?");
			
			statement.setString(1, ProductName);
			statement.setInt(2, Item_ID);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public int updateQty(Product Item) {
		
		int Item_ID = Item.getProductID();
		int ProductQty = Item.getProductQty();
		int result = 0;
					
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("UPDATE Item SET Quantity=? WHERE Item_ID=?");

			statement.setInt(1, ProductQty);
			statement.setInt(2, Item_ID);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public int updatePrice(Product Item) {
		
		int Item_ID = Item.getProductID();
		float ProductPrice = Item.getProductPrice();
		int result = 0;
					
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("UPDATE Item SET Price=? WHERE Item_ID=?");

			statement.setFloat(1, ProductPrice);
			statement.setInt(2, Item_ID);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}

	public int updateUnit(Product Item) {
		
		int Item_ID = Item.getProductID();
		String Unit = Item.getMeasuredUnit();
		int result = 0;
					
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("UPDATE Item SET Unit=? WHERE Item_ID=?");

			statement.setString(1, Unit);
			statement.setInt(2, Item_ID);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public int updateQtyInCart(Product Cart, int customerID) {
		
		int Item_ID = Cart.getProductID();
		int ProductQty = Cart.getCustomerItemQty();
		int result = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("UPDATE Cart SET Quantity=? WHERE Item_ID=? AND Customer_ID=?");

			statement.setInt(1, ProductQty);
			statement.setInt(2, Item_ID);
			statement.setInt(3, customerID);
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public int InsertItemToCart(Product Item, int customerID) {
				
		int Item_ID = Item.getProductID();
		int Quantity = Item.getCustomerItemQty();
		
		int result = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//establishing connection
			connection = DatabaseConnection.createConnection();
						
			//Statement is used to write queries. Read more about it.
			statement = connection.prepareStatement("INSERT INTO Cart VALUES (NULL, ?, ?, ?)");
			statement.setInt(1, Item_ID );
			statement.setInt(2, customerID);
			statement.setInt(3, Quantity);
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;
		
	}
	
	public ResultSet GetUserID(String email) {

		Connection connection = null;
		Statement statement = null;
		ResultSet Result = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
			
			//Statement is used to write queries. Read more about it.
			statement = connection.createStatement();
			
			//Fetching all the records and storing in a resultSet.
			Result = statement.executeQuery("SELECT * FROM Customer WHERE UserName = '" + email + "'");
						
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return Result;
		
	}
	
	public ResultSet GetCart(int CustomerID) {

		Connection connection = null;
		Statement statement = null;
		ResultSet ResultSet = null;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
			
			//Statement is used to write queries. Read more about it.
			statement = connection.createStatement();
			
			//Fetching all the records and storing in a resultSet.
			ResultSet = statement.executeQuery("SELECT * FROM Cart WHERE Customer_ID = " + CustomerID);
						
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		
		return ResultSet;
		
	}

	public int DeleteCartItem(int itemID, int customerID) {
		
		Connection connection = null;
		Statement statement = null;
		int result = 0;
		
		try {
			
			//establishing connection
			connection = DatabaseConnection.createConnection();
			
			//Statement is used to write queries. Read more about it.
			statement = connection.createStatement();
			
			//Fetching all the records and storing in a resultSet.
			result = statement.executeUpdate("DELETE FROM Cart WHERE Item_ID = " + itemID + " AND Customer_ID = " + customerID);
				
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}
		return result;		
		
	}
	
	
}
