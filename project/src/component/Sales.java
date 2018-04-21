package component;

import java.util.Date;

public class Sales {
	private String productName;
	private int invoiceNumber;
	private double unitPrice;
	private int quantity;
	private double totalPrice;
	private double VATRate;
	private double VAT = VATRate*totalPrice;
	private Date dateOfSell;
	private String customerName;
	
	public Sales(String productName, int invoiceNumber, double unitPrice, int quantity, double totalPrice, double VAT, Date dateOfSell,
			String customerName) {
		this.productName = productName;
		this.invoiceNumber = invoiceNumber;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.VAT = VAT;
		this.dateOfSell = dateOfSell;
		this.customerName = customerName;
	}

	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public double getVAT() {
		return VAT;
	}


	public void setVAT(double vAT) {
		VAT = vAT;
	}


	public Date getDateOfSell() {
		return dateOfSell;
	}


	public void setDateOfSell(Date dateOfSell) {
		this.dateOfSell = dateOfSell;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Override
	public String toString() {
		return "Product Name: " + productName +"\n" + "Invoice Number: " + invoiceNumber + "\n"+ "Unit Price: " + unitPrice
				+"\n"+ "Quantity: " + quantity +"\n"+ "Total Price: " + totalPrice + "\n"+ "VAT ("+VATRate+"): " + VAT + "\n"+ "Date Of Sell: "
				+ dateOfSell + "\n"+ "Customer Name: " + customerName+"\n"+"\n";
	}
}
