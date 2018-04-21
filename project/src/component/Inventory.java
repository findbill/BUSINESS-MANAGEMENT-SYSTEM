package component;

import java.util.Date;

public class Inventory{
	private String name;
	private Date date;
	private int quantity;
	private double unitCost;
	
	public Inventory(String name, Date date, int quantity, double unitCost) {
		this.name = name;
		this.date = date;
		this.quantity = quantity;
		this.unitCost = unitCost;
	}

	public String getName() {
		return name;
	}

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

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	@Override
	public String toString() {
		return "Inventory name: "+ getName() +"\n"+ "Quantity: " + getQuantity() 
		+ "\n"+ "Unit Cost: " + getUnitCost()+ "\n"+ "Date: " + getDate() + "\n"+"\n";
	}
	
}
