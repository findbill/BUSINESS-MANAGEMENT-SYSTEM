package component;

import java.util.Date;

public class Receivable {

	private int invoiceNumber;
	private Customer customer;
	private Date date;
	private double amount;
	
	public Receivable(int invoiceNumber, Customer customer, Date date, double amount) {
		this.invoiceNumber = invoiceNumber;
		this.customer = customer;
		this.date = date;
		this.amount = amount;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "Receivable [invoiceNumber=" + invoiceNumber + ", customer=" + customer + ", date=" + date + ", amount="
				+ amount + "]";
	}
	
	
}
