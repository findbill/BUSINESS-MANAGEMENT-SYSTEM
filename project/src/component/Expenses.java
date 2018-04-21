package component;

import java.util.Date;

public class Expenses {
	private int no;
	private String name;
	private double amount;
	private Date date;
	
	public Expenses(int no,String name, double amount, Date date) {
		this.no = no;
		this.name = name;
		this.amount = amount;
		this.date = date;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
		return no+ "\n"+name + "\n"+"Amount: " + amount + "\n"+"Date: " + date + "\n"+"\n";
	}
	
	
}
