package component;

import java.util.Date;

public class Employee {
	private int employeeID;	
	private String firstName;
	private String lastName;
	private String address;
	private String contactNumber;
	private String gender;
	private int age;
	private Date dateOfJoin; //public static final??
	
	public Employee(int employeeID, String firstName, String lastName, String address, String contactNumber, String gender, int age,
			Date dateOfJoin) {
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.age = age;
		this.dateOfJoin = dateOfJoin;
	}

	
	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getLastName() {
		return lastName;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public String toString() {
		return employeeID + "\n"+"Name: " + firstName+" " +lastName +"\n"+
				"Gender: " + gender + "\n"+ "Age: " + age+"\n"
				+ "Contact number: " + contactNumber + "\n"+"Address: " + address +"\n"
				+ "Date of join: " + dateOfJoin + "\n"+"\n";
	}
	
}
