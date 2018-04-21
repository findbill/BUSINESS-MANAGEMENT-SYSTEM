package component;

/**
 * Customer class to maintain the data of assets.
 * @author Bingyao Tian
 * @version 11-11-2016
 */
public class Customer {
	private String lastName;
	private String firstName;
	private String address;
	private String contactNumber;
	private String emailAddress;
	
	// constructor
	public Customer(String firstName, String lastName, String address, String contactNumber,
			String emailAddress) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
	}
/**
 * getter
 * @return lastName
 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setter
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * toString method to print a customer
	 */
	@Override
	public String toString() {
		return "Customer [lastName=" + lastName + ", firstName=" + firstName + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", emailAddress=" + emailAddress + "]";
	}
	
	
}
