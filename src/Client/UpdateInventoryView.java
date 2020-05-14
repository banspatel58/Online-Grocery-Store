
package Client;
import java.util.Scanner;

import Server.Product;

/******************************************
 * @author Bansari Patel
 * 
 * View: AdminUpdateItemView displays the
 * list of actions admin can do with the 
 * inventory that is: update item price, 
 * update item description, update item
 * quantity, add new item, remove an 
 * existing item.
 *****************************************/
public class UpdateInventoryView{

	Scanner input = new Scanner(System.in);
	
	//default constructor
	public UpdateInventoryView() {
		
		
		
	}
	
	/*
	 * listOptions creates a view for the admin
	 * to chose from the list of available 
	 * actions admin can perform on the inventory
	 * list which are: update item price, qty, 
	 * description, add new item, remove an
	 * existing item from the inventory
	 */	
	public int displayUpdateInventoryView() {

		System.out.println("\nPlease choose from the following:");
		System.out.println("1. Add a new item");
		System.out.println("2. Remove an existing item");
		System.out.println("3. Update an item's description");
		System.out.println("4. Update an item's price");
		System.out.println("5. Update an item's quantity");
		
		System.out.print("\nWhat would you like to do?: ");
		int AdminInput = input.nextInt();
		
		return AdminInput;
		
	}

	/*
	 * AddNewItem creates a view for the admin
	 * to add an item to the inventory list.
	 * it prompts admin with the id, type,
	 * name, quantity, price, batch code and the
	 * inventory count of the new item too be
	 * added and then notifies the admin that
	 * the item is removed from the inventory
	 */	
	public void AddNewItemView(Product Item) {
				
		System.out.println("\nPlease enter the following details:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		Item.setProductID(ItemID);
		
		System.out.print("\nItem Type: ");
		String ItemType = input.next();
		Item.setType(ItemType);
		
		System.out.print("\nItem Name: ");
		String ItemName = input.next();
		Item.setProductName(ItemName);
		
		System.out.print("\nItem Price: ");
		float ItemPrice = input.nextFloat();
		Item.setProductPrice(ItemPrice);
		
		System.out.print("\nQuantity: ");
		int ItemQuantity = input.nextInt();
		Item.setProductQty(ItemQuantity);
		
		System.out.print("\nMeasured Unit: ");
		String ItemMeasuredUnit = input.next();
		Item.setMeasuredUnit(ItemMeasuredUnit);
				
	}

	/*
	 * removeItem creates a view for the admin
	 * to remove an item from the inventory list
	 * it prompts admin with the id of the item
	 * to remove and then notifies the admin 
	 * that the item is removed from the inventory
	 */	
	public int RemoveItemView() {
		
		System.out.println("\nPlease enter the Id of the item you would like to remove:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		return ItemID;
		
	}

	/*
	 * updateDescription creates a view for 
	 * the admin to update an item's
	 * description in the inventory list.
	 * It prompts the admin with the 
	 * description to be updated and then
	 * notifies the admin that the
	 * description of the item is updated
	 */	
	public void UpdateDescriptionView(Product product) {
		
		System.out.println("\nPlease enter the Id of the item you would like to update description for:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		product.setProductID(ItemID);

		System.out.print("Enter the new Description: ");
		String ItemDescription = input.next();
		product.setProductName(ItemDescription);
		
	}

	/*
	 * updatePrice creates a view for the
	 * admin to update an item's price in
	 * the inventory list. It prompts the
	 * admin with the price to be updated
	 * and then notifies the admin that the
	 * price of the item is updated
	 */	
	public void UpdatePriceView(Product product) {
		
		System.out.println("\nPlease enter the Id of the item you would like to update price for:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		product.setProductID(ItemID);

		System.out.print("Enter the new Price: ");
		float ItemPrice = input.nextFloat();
		product.setProductPrice(ItemPrice);
				
	}

	/*
	 * updateQty creates a view for the
	 * admin to update an item's qty in
	 * the inventory list. It prompts the
	 * admin with the qty to be updated
	 * and then notifies the admin that
	 * the qty of the item is updated.
	 */	
	public void UpdateQtyView(Product product) {
		
		System.out.println("\n\nPlease enter the Id of the item you would like to update quantity for:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		product.setProductID(ItemID);

		System.out.print("Enter the updated quantity: ");
		int ItemQty = input.nextInt();
		product.setProductQty(ItemQty);
		
	}
	
}