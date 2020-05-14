package Controller;

import java.rmi.RemoteException;
import java.util.List;

import Client.CartView;
import Server.Product;

public class CartController {
	
	private CartView cartView;
	private Product Item;
	
	public CartController() {

		this.cartView = new CartView();
		this.Item = new Product();
		
	}
	
	//displays the update Cart view
	public void displayUpdateCartView(StoreServerInterface stub, String email) {
		
		int CustomerID = 0;
		
		try {
			
			CustomerID = stub.GetCustomerID(email);
			
		} catch (RemoteException e1) {

			e1.printStackTrace();
			
		}
		
		System.out.println("Welcome " + CustomerID + " name = " + email);
		
		boolean KeepGoing = true;
		while(KeepGoing) {
			
			int CustomerInput = cartView.displayUpdateCartView();
			
			if(CustomerInput == 1) {


				try {
					
					List<Product> list = stub.getAvailableProducts();
					System.out.println("****************************************");
					System.out.println("Items");
					System.out.println("****************************************");
					viewProductDetails(list);	
					
				} catch (RemoteException e) {

					e.printStackTrace();
					
				}
				
				AddItemToCustomerCart(stub, CustomerID);
				KeepGoing = true;
				
			}else if(CustomerInput == 2) {
				
				RemoveAnItemFromCart(stub, CustomerID);
				KeepGoing = true;
				
			} else if(CustomerInput == 3) {

				UpdateQuantityInCustomerCart(stub, CustomerID);
				KeepGoing = true;
				
			} else if(CustomerInput == 4) {
				
				MakePurchase(stub, CustomerID);
				KeepGoing = false;
				
			} else if(CustomerInput == 5) {
				
				KeepGoing = false;
				
			} else {
				
				KeepGoing = false;
			}
			
		}
		
	}
	
	public void AddItemToCustomerCart(StoreServerInterface stub, int CustomerID) {
		
		System.out.println("Redirecting to the Add item to cart view");
		cartView.AddNewItemView(Item);
				
		try {
				
			stub.AddItemToCart(Item, CustomerID);
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}	
		
	}
	
	public void UpdateQuantityInCustomerCart(StoreServerInterface stub, int CustomerID) {
		
		System.out.println("Redirecting to the Update Quantity in Cart view");
		
		try {
			
			List<Product> list = stub.getItemsInCart(CustomerID);
			System.out.println("****************************************");
			System.out.println("Cart");
			System.out.println("****************************************");
			viewCart(list);
			cartView.UpdateQtyView(Item);
			stub.updateQtyInCart(Item, CustomerID);
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}
		
	}
	
	public void RemoveAnItemFromCart(StoreServerInterface stub, int CustomerID) {
		
		System.out.println("Redirecting to the Remove item from Cart view");
		
		try {
			
			List<Product> list = stub.getItemsInCart(CustomerID);
			System.out.println("****************************************");
			System.out.println("Cart");
			System.out.println("****************************************");
			viewCart(list);
			int ItemID = cartView.RemoveItemView();
			stub.removeItemFromCart(ItemID, CustomerID);
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}
				
	}
	
	public void MakePurchase(StoreServerInterface stub, int CustomerID) {
		
		
		try {
			
			List<Product> list = stub.getItemsInCart(CustomerID);
			System.out.println("****************************************");
			System.out.println("Cart");
			System.out.println("****************************************");
			viewCart(list);
			

			System.out.println("************************************************");
			System.out.println("Thank you for making purchase. Your order will be delivered soon.");
			System.out.println("************************************************");

			stub.Checkout(CustomerID);
			
		} catch (RemoteException e) {

			e.printStackTrace();
			
		}
				
	}
	
	public void viewCart(List<Product> list) {			
			
        for (Product Item:list) { 	
        	
           System.out.print("Item_ID: " + Item.getProductID() ); 
           System.out.print("\tQuantity: " + Item.getCustomerItemQty() ); 
           System.out.println();
           
        } 
		
	}	
			
	//gets the list of items to purchase
	public void viewProductDetails(List<Product> list) {
		
        for (Product Item:list) { 
            
           System.out.print("Item_ID: " + Item.getProductID() ); 
           System.out.print("\tType: " + Item.getType() ); 
           System.out.print("\tName: " + Item.getProductName() ); 
           System.out.print("\tPrice: " + Item.getProductPrice() ); 
           System.out.print("\tQuantity: " + Item.getProductQty() ); 
           System.out.print("\tUnit: " + Item.getMeasuredUnit() ); 
           System.out.println();
           
        } 
		
	}
	
}