/**
 * 
 */
package Controller;

import java.rmi.RemoteException;
import java.util.List;

import Client.UpdateInventoryView;
import Server.Product;

/********************************************
 * @author Bansari Patel
 *
 * Controller: UpdateInventoryController 
 * This class is responsible for 
 * collaborating the update inventory view
 * and the product. It allows to get the 
 * display for the upate inventory view
 * and call the remote methods to make 
 * necessary updates.
 *******************************************/
public class UpdateInventoryController {

	private UpdateInventoryView updateInventoryView;
	private Product Item;
	
	public UpdateInventoryController() {

		this.updateInventoryView = new UpdateInventoryView();
		this.Item = new Product();
		
	}
	
	//displays the update inventory view
	public void displayUpdateInventoryView(StoreServerInterface stub) {
		
		int AdminInput = updateInventoryView.displayUpdateInventoryView();
		UpdateInventory(AdminInput, stub);
		
	}

	//displays the update inventory view and calls the function through
	//remote server method to make the updates in the inventory
	public void UpdateInventory(int AdminInput, StoreServerInterface stub) {
				
		if(AdminInput == 1) {
			
			System.out.println("Redirecting to the Add Item View");
			updateInventoryView.AddNewItemView(Item);
			
			try {

				List<Product> list = stub.getAdminInventory();
				viewInventory(list);
				stub.AddNewItem(Item);
				
			} catch (RemoteException e) {

				e.printStackTrace();
				
			}			
			
		}else if(AdminInput == 2) {
			
			System.out.println("Redirecting to the Remove Item View");
			
			try {

				List<Product> list = stub.getAdminInventory();
				viewInventory(list);
				int ItemID = updateInventoryView.RemoveItemView();
				stub.removeItem(ItemID);
				
			} catch (RemoteException e) {

				e.printStackTrace();
				
			}
			
		} else if (AdminInput == 3) {
			
			System.out.println("Redirecting to the Update Item Description");
			
			try {

				List<Product> list = stub.getAdminInventory();
				viewInventory(list);
				updateInventoryView.UpdateDescriptionView(Item);
				stub.updateDescription(Item);
				
			} catch (RemoteException e) {

				e.printStackTrace();
				
			}
			
		} else if (AdminInput == 4) {
			
			System.out.println("Redirecting to the Update Item Price");
			
			try {

				List<Product> list = stub.getAdminInventory();
				viewInventory(list);
				updateInventoryView.UpdatePriceView(Item);
				stub.updatePrice(Item);
				
			} catch (RemoteException e) {

				e.printStackTrace();
				
			}
			
		} else if (AdminInput == 5) {
			
			System.out.println("Redirecting to the Update Item Quantity");
			
			try {
				
				List<Product> list = stub.getAdminInventory();
				viewInventory(list);
				updateInventoryView.UpdateQtyView(Item);
				stub.updateQty(Item);
				
			} catch (RemoteException e) {

				e.printStackTrace();
				
			}
			
		} else {
			
			System.out.println("Invalid entry. Please try back again later");
			
		}
			
	}	
	
	//prints list of items from the inventory
	public void viewInventory(List<Product> list) {
		
		System.out.println("************************************");
		System.out.println("Inventory");
		System.out.println("************************************");
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
