package component;

import java.util.Date;

public class Liability {
	private String name;
	private double amount;
	private Date date;
	
	public Liability(String name, double amount, Date date) {
		this.name = name;
		this.amount = amount;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Item: " + name + "\n"+"Amount: " + amount + "n"+"Date: " + date + "\n"+"\n";
	}
	
}
