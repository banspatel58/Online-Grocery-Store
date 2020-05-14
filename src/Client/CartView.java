package Client;

import java.util.Scanner;

import Server.Product;

public class CartView {
	
	Scanner input = new Scanner(System.in);
	
	public CartView() {
		
	}
	
	public int displayUpdateCartView() {
		
		System.out.println("\nPlease choose from the following:");
		System.out.println("1. Add a new item");
		System.out.println("2. Remove an existing item from Cart");
		System.out.println("3. Update an Item's Quantity in Cart");
		System.out.println("4. Checkout");
		System.out.println("5. Quit");
		
		
		System.out.print("\nWhat would you like to do?: ");
		int CustomerInput = input.nextInt();
		
		return CustomerInput;
		
	}

	public void AddNewItemView(Product Item) {
		
		System.out.println("\nPlease enter the following details:");		
		System.out.print("\nItem_ID: ");
		int ItemID = input.nextInt();
		Item.setProductID(ItemID);
				
		System.out.print("\nQuantity: ");
		int ItemQuantity = input.nextInt();
		Item.setCustomerItemQty(ItemQuantity);			
				
	}
	
	public int RemoveItemView() {
		
		System.out.println("\nPlease enter the Item_ID you would like to remove from Cart:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		return ItemID;
		
	}
	
	public void UpdateQtyView(Product product) {
		
		System.out.println("\n\nPlease enter the Id of the item you would like to update quantity for:");
		System.out.print("Item ID: ");
		int ItemID = input.nextInt();
		product.setProductID(ItemID);

		System.out.print("Enter the updated quantity: ");
		int ItemQty = input.nextInt();
		product.setCustomerItemQty(ItemQty);
		
	}

}
