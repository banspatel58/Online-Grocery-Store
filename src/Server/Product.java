package Server;

import java.io.Serializable;

/********************************************************************************
 *  @author Bansari Patel
 * 
 * Modal: Product is a serializable object that contains the attribute related to
 * each item namely Type, product name, product price, product quantity, and 
 * the unit of measurement.
 *********************************************************************************/
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int ItemID;
	private String Type;
	private String ProductName;
	private float ProductPrice;
	private int ProductQty;
	private String MeasuredUnit;
	private int CustomerItemQty;
	
	//default constructor
	public Product() {
		
		
	}
	
	//get and set methods for Product ID
	public int getProductID() {
		
		return ItemID;
		
	}

	public void setProductID(int ItemID) {
		
		this.ItemID = ItemID;
		
	}
	
	//get and set methods for Product Type
	public String getType() {
		
		return Type;
		
	}

	public void setType(String Type) {
		
		this.Type = Type;
		
	}
	
	//get and set methods for Product Name
	public String getProductName() {
		
		return ProductName;
		
	}

	public void setProductName(String productName) {
		
		this.ProductName = productName;
		
	}

	//get and set methods for Product price
	public float getProductPrice() {
		
		return ProductPrice;
		
	}

	public void setProductPrice(float productPrice) {
		
		this.ProductPrice = productPrice;
		
	}

	//get and set methods for ProductQty
	public int getProductQty() {
		
		return ProductQty;
		
	}

	public void setProductQty(int productQty) {
		
		this.ProductQty = productQty;
		
	}

	//get and set methods for Measured Unit
	public String getMeasuredUnit() {
		
		return MeasuredUnit;
		
	}

	public void setMeasuredUnit(String measuredUnit) {
		
		this.MeasuredUnit = measuredUnit;
		
	}
	//get and set methods for ProductQty
		public int getCustomerItemQty() {
		
		return CustomerItemQty;
		
	}

	public void setCustomerItemQty(int customerItemQty) {
		
		this.CustomerItemQty = customerItemQty;
		
	}	
	
}