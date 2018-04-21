package component;

import java.util.Date;

public class Purchase{
	private int invoiceNumber;
	private String name;
	private int quantity;
	private double unitPrice;
	private double totalPrice = unitPrice*quantity;
	private String supplierName;
	private Date dateOfPurchase;
	
	public Purchase(int invoiceNumber, String name, int quantity, double unitPrice, double totalPrice, String supplierName,
			Date dateOfPurchase) {
		this.setInvoiceNumber(invoiceNumber);
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.supplierName = supplierName;
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	@Override
	public String toString() {
		return "Purchase name: " + name +"\n"+ "Invoice number: " + invoiceNumber + "\n"+ "Quantity: " + quantity + "\n"+ "Unit price: "
				+ unitPrice + "\n"+ "Total price: " + totalPrice + "\n"+ "Supplier name: " + supplierName + "\n" + "Date of purchase: "
				+ dateOfPurchase + "\n"+"\n";
	}
}
