package component;

import java.util.Date;

public class Payable {

	private String name;
	private Date date;
	private double amount;
	
	public Payable(String name, Date date, double amount) {
		super();
		this.name = name;
		this.date = date;
		this.amount = amount;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payable [name=" + name + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
}
