package component;

import java.util.Date;

/**
 * Assets class to maintain the data of assets.
 * @author Bingyao Tian
 * @version 11-11-2016
 */
public class Assets {
	private String name;
	private Date date;
	private int quantity;
	private double unitValue;
	private double totalValue = quantity*unitValue;
	
	/**
	 * Constructor of an asset.
	 * @param name
	 * @param date
	 * @param quantity
	 * @param unitValue
	 * @param totalValue
	 */
	public Assets(String name, Date date, int quantity, double unitValue, double totalValue) {
		this.name = name;
		this.date = date;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
	}
	
	/**
	 * getter
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}
	
	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	/**
	 * toString method to print the information of an asset.
	 */
	@Override
	public String toString() {
		return "Asset name: "+name +"\n"+ "Quantity: " + quantity + "\n"+"Unit value: "+ unitValue+"Date: " + date + "\n";
		 
	}

	
	
	
}
