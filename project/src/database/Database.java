package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import component.Assets;
import component.Customer;
import component.Employee;
import component.Expenses;
import component.Inventory;
import component.Liability;
import component.Note;
import component.Purchase;
import component.Sales;
import component.Supplier;
import component.User;

public class Database{
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private String url = "jdbc:mysql://localhost:1226/project?"
				+ "user=root&password=QWer1234&useSSL=false";
		
	public Connection getConnection(){
		try {
			new com.mysql.jdbc.Driver();
			System.out.println("successful load mysql driver");
			
			conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
          return conn;
	}
	
	/**
	 * A method to check if the username and password are entered correct.
	 * @param username
	 * @param password
	 * @return login
	 */
	public boolean loginCheck(String username, String password){
		conn = getConnection();
        String query = "SELECT username, password FROM user";
        String dbUsername, dbPassword;
        boolean login = false;

        try {
            statement = conn.createStatement();
            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();

            while(rs.next())
            {
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("password");

                if(dbUsername.equals(username) && dbPassword.equals(password))
                {
                    System.out.println("OK");
                    login = true;
                }
            }
            conn.close();
            } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
	}

	public void addNote(String obj) {
		Connection conn = getConnection();
		preparedStatement = null;
		String query = "insert into notes (note, date) values (?,curdate());";
		try {
			preparedStatement = conn.prepareStatement(query);

		    // Parameters start with 1

		    preparedStatement.setString(1, obj);		 
		    
		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into notes table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteNote(Note obj) {
		preparedStatement = null;
		conn = getConnection();
		String query = "delete from notes where id=?;";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            // Parameters start with 1
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.executeUpdate();
            System.out.println("This note is deleted!");
            conn.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void updateUser(String username, String password) {
		conn = getConnection();
		String query = "update user set username=?, password=? where No=1";
		try {
           PreparedStatement preparedStatement = conn.prepareStatement(query);
		    preparedStatement.setString(1, username);
		    preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();
           System.out.println("Username and password are updated into user table!");
            conn.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void addLiability(String name, double amount) {
		
		conn = getConnection();
		String query = "insert into liabilities (item, amount, date) "
		+ "values (?,?,curdate()) on duplicate key update amount =(amount+?),date = curdate();";
					
		try {
			preparedStatement = conn.prepareStatement(query);

		    // Parameters start with 1

		    preparedStatement.setString(1, name);
		    preparedStatement.setDouble(2, amount);
		    preparedStatement.setDouble(3, amount);
		    preparedStatement.executeUpdate();
		    System.out.println("Record is updated into liabilities table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Liability getLiability(String name) {
		Liability liability = new Liability(null, 0, null);
		conn = getConnection();
		String query = "select * from liabilities where item=?;";
	    try {

	        PreparedStatement preparedStatement = conn.prepareStatement(query);

	        preparedStatement.setString(1,name);

	        ResultSet rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	        	liability.setName(rs.getString("name"));
	        	liability.setAmount(rs.getInt("quantity"));
	        	liability.setDate(rs.getDate("date"));  	
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return liability;
	}
	
	public List<Liability> getAllLiabilities() {
		 List<Liability> liabilities = new ArrayList<Liability>();
		    conn = getConnection();
			String query = "select * from liabilities;";
	        try {
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while (rs.next()) {
	            	Liability liability = new Liability(null, 0, null);
	            	liability.setName(rs.getString("name"));
		        	liability.setAmount(rs.getInt("quantity"));
		        	liability.setDate(rs.getDate("date"));  	
	            	liabilities.add(liability);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return liabilities;
	}
	/**
	 * method to get the amount of the liabilities at the end of the financial year
	 * require user to update all liabilities at least every year(also other
	 * financial position items)
	 * @param year
	 * @return
	 */
	public double getYearEndLiabilities(String year){
		conn = getConnection();
		String query = "select * from liabilities where date between ? and ?;";
		double d = 0;
		try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-01-01");
	        preparedStatement.setString(2, year+"-12-31");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("amount");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}

	public void addAsset(String name, int quantity, double value) {
		conn = getConnection();
		String query = "insert into assets (name, date, quantity, unitValue, totalValue) "
		+ "values (?,curdate(),?,?,?) on duplicate key update date = curdate(),"
		+ "quantity=(quantity+?), unitValue=?, totalValue=?;";
					
		try {
			preparedStatement = conn.prepareStatement(query);

		    // Parameters start with 1

		    preparedStatement.setString(1, name);
		    preparedStatement.setInt(2, quantity);
		    preparedStatement.setDouble(3, value);
		    preparedStatement.setDouble(4, value*quantity);
		    preparedStatement.setDouble(5, quantity);
		    preparedStatement.setDouble(6, value);
		    preparedStatement.setDouble(7, value*quantity);
		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into assets table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Assets getAsset(String name) {
		Assets asset = new Assets(null, null, 0, 0,0);
		conn = getConnection();
		String query = "select * from assets where name=?;";
	    try {

	        PreparedStatement preparedStatement = conn.prepareStatement(query);

	        preparedStatement.setString(1,name);

	        ResultSet rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	        	asset.setName(rs.getString("name"));
	        	asset.setDate(rs.getDate("date"));
	        	asset.setQuantity(rs.getInt("quantity"));
	        	asset.setUnitValue(rs.getDouble("unitValue"));
	        	asset.setTotalValue(rs.getDouble("totalValue"));
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return asset;
	}
	
	public List<Assets> getAllAssets() {
		 List<Assets> assets = new ArrayList<Assets>();
		    conn = getConnection();
			String query = "select * from assets;";
	        try {
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while (rs.next()) {
	            	Assets asset = new Assets(null, null, 0,0,0);
	            	asset.setName(rs.getString("name"));
		        	asset.setDate(rs.getDate("date"));
		        	asset.setQuantity(rs.getInt("quantity"));
		        	asset.setUnitValue(rs.getDouble("unitValue"));
		        	asset.setTotalValue(rs.getDouble("totalValue"));
		        	assets.add(asset);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return assets;
	}

	public double getYearEndAssets(String year){
		conn = getConnection();
		String query = "select * from assets where date between ? and ?;";
		double d = 0;
		try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-01-01");
	        preparedStatement.setString(2, year+"-12-31");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("totalValue");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	
	public void addCustomer(String fn, String ln, String address, String number, String email) {
		conn = getConnection();
		String query = "insert into customers values (?,?,?,?,?);";
		try {
			preparedStatement = conn.prepareStatement(query);
		    // Parameters start with 1
		    preparedStatement.setString(1, fn);
		    preparedStatement.setString(2, ln);
		    preparedStatement.setString(3, address);
		    preparedStatement.setString(4, number);
		    preparedStatement.setString(5, email);		    
		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into customers table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	public Customer getCustomer(String number) {
		Customer customer = new Customer(null, null, null, null, null);
        conn = getConnection();
		String query = "select * from customers where number=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, number);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastname"));
                customer.setAddress(rs.getString("address"));     
                customer.setContactNumber(rs.getString("contactnumber"));
                customer.setEmailAddress(rs.getString("emailAddress"));
            }
            conn.close();
        	} catch (SQLException e) {
            e.printStackTrace();
        	}
		return customer;
	}


	
	public List<Customer> getAllCustomers() {
	    List<Customer> customers = new ArrayList<Customer>();
	    conn = getConnection();
		String query = "select * from customers";
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Customer customer = new Customer(null, null, null, null, null);           	
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastname"));
                customer.setAddress(rs.getString("address"));     
                customer.setContactNumber(rs.getString("contactnumber"));
                customer.setEmailAddress(rs.getString("emailAddress"));
                customers.add(customer);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return customers;
	}


	
	public void addEmployee(String ln, String fn, String address, String cn, String gender, int age, String s) {
		conn = getConnection();
		String query = "insert into employees (LastName, FirstName, Address, ContactNumber, Gender, Age, DateOfJoin)"
				+ "values (?,?,?,?,?,?,?) on duplicate key update LastName = ?,"
				+ "FirstName=?, Address=?, ContactNumber=?, Gender=?, Age=?;";
		java.util.Date date = null;
		
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {   
		    date = sFormat.parse(s);  
//		    data = format2.parse(str);
		} catch (ParseException e) {   
		    e.printStackTrace();   
		}   	
			
		try {
			preparedStatement = conn.prepareStatement(query);

		    // Parameters start with 1
		    preparedStatement.setString(1, ln);
		    preparedStatement.setString(2, fn);
		    preparedStatement.setString(3, address);
		    preparedStatement.setString(4, cn);
		    preparedStatement.setString(5, gender);
		    preparedStatement.setInt(6, age);
		    preparedStatement.setDate(7, new java.sql.Date(date.getTime()));
		   
		    preparedStatement.setString(8, ln);
		    preparedStatement.setString(9, fn);
		    preparedStatement.setString(10, address);
		    preparedStatement.setString(11, cn);
		    preparedStatement.setString(12, gender);
		    preparedStatement.setInt(13, age);
		    preparedStatement.executeUpdate();
		    System.out.println("Record is updated into employees table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
//	public void deleteEmployee(Employee obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "delete from employees where EmployeeID=?";
//        try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setInt(1, obj.getEmployeeID());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This employee is deleted!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//		
//	}


	
	
	
	
//	public void updateEmployee(Employee obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "update employees set LastName=?, firstName=?, address=?, contactNumber=?, gender=?, age=? dateofjoin=? where employeeID=?";
//		
//		try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getLastName());
//            preparedStatement.setString(2, obj.getFirstName());
//		    preparedStatement.setString(3, obj.getAddress());
//		    preparedStatement.setString(4, obj.getContactNumber());
//		    preparedStatement.setString(5, obj.getGender());
//		    preparedStatement.setInt(6, obj.getAge());
//		    preparedStatement.setDate(7, new java.sql.Date(obj.getDateOfJoin().getTime()));
//		    preparedStatement.setInt(8, obj.getEmployeeID());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This employee's record is updated into employees table!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}


	
	public List<Employee> getEmployees(String name) {
		 List<Employee> employees = new ArrayList<Employee>();
		    conn = getConnection();
			String query = "select * from employees where LastName=? order by EmployeeID";
	        try {    
	            preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);
                ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	Employee emp= new Employee(0, null, null, null, null, null, 0, null);
	            	emp.setEmployeeID(rs.getInt("EmployeeID"));
	                emp.setFirstName(rs.getString("firstName"));
	                emp.setLastName(rs.getString("lastname"));
	                emp.setAddress(rs.getString("address"));     
	                emp.setContactNumber(rs.getString("contactnumber"));
	                emp.setGender(rs.getString("gender"));
	                emp.setAge(rs.getInt("age"));
	                emp.setDateOfJoin(rs.getDate("dateOfJoin"));
	                employees.add(emp);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
			return employees;
	}

	public List<Employee> getAllEmployees() {
		 List<Employee> employees = new ArrayList<Employee>();
		    conn = getConnection();
			String query = "select * from employees order by EmployeeID";
	        try {
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while (rs.next()) {

	            	Employee emp= new Employee(0, null, null, null, null, null, 0, null);
	            	emp.setEmployeeID(rs.getInt("EmployeeID"));
	            	emp.setLastName(rs.getString("lastname"));
	                emp.setFirstName(rs.getString("firstName"));
	                emp.setAddress(rs.getString("address"));     
	                emp.setContactNumber(rs.getString("contactnumber"));
	                emp.setGender(rs.getString("gender"));
	                emp.setAge(rs.getInt("age"));
	                emp.setDateOfJoin(rs.getDate("dateOfJoin"));
	                employees.add(emp);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return employees;
	}

	public void addInventory(String name, int quantity, double unitcost) {
		conn = getConnection();
		String query = "insert into inventories (name, date, quantity, unitCost, totalCost) "
				+ "values (?,curdate(),?,?,?) on duplicate key update date = curdate(),"
				+ "quantity=(quantity+?), unitCost=?, totalCost=?;";
			
			
		try {
			preparedStatement = conn.prepareStatement(query);

		    // Parameters start with 1

		    preparedStatement.setString(1, name);
		    preparedStatement.setInt(2, quantity);
		    preparedStatement.setDouble(3, unitcost);
		    preparedStatement.setDouble(4, unitcost*quantity);
		    preparedStatement.setDouble(5, quantity);
		    preparedStatement.setDouble(6, unitcost);
		    preparedStatement.setDouble(7, unitcost*quantity);
		    
		    preparedStatement.executeUpdate();
		    System.out.println("Record is updated into inventories table!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
//	public void deleteInventory(Inventory obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "delete from inventories where name=?";
//        try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getName());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This inventory is deleted!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}


	
	public void updateInventory(String name, int quantity) {
		conn = getConnection();
		String query = "update inventories set date=curdate(), quantity=(quantity-?) where name=?";
		try {
           PreparedStatement preparedStatement = conn.prepareStatement(query);
		    preparedStatement.setInt(1, quantity);
		    preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
           System.out.println("This inventory is updated into inventories table!");
            conn.close();
            } catch (SQLException e) {

            e.printStackTrace();

        }
	}


	
	public Inventory getInventory(String name) {
		Inventory inv= new Inventory(null, null, 0, 0);
        conn = getConnection();
		String query = "select * from inventories where name=?";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, name);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                inv.setName(rs.getString("name"));
                inv.setDate(rs.getDate("date"));
                inv.setQuantity(rs.getInt("quantity"));
                inv.setUnitCost(rs.getDouble("unitcost"));     
            }
            conn.close();
        	} catch (SQLException e) {

            e.printStackTrace();

        	}
		return inv;
	}

	public int getInventoryQuantity(String name) {
		int i =0;
        conn = getConnection();
		String query = "select quantity from inventories where name=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                i+=rs.getInt("quantity");
            }
            conn.close();
        	} catch (SQLException e) {

            e.printStackTrace();

        	}
		return i;
	}
	
	public List<Inventory> getAllInventories() {
		List<Inventory> inventories = new ArrayList<Inventory>();
	    conn = getConnection();
		String query = "select * from inventories order by name";
        try {
        	statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
           		Inventory inv= new Inventory(null, null, 0, 0);
           		inv.setName(rs.getString("name"));
                inv.setDate(rs.getDate("date"));
                inv.setQuantity(rs.getInt("quantity"));
                inv.setUnitCost(rs.getDouble("unitcost"));     
                inventories.add(inv);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return inventories;
	}
	
	public List<String> getInventoriesForSale() {
		List<String> names= new ArrayList<String>();
	    conn = getConnection();
		String query = "select * from inventories order by name";
        try {
        	statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	String name = rs.getString("name");
                names.add(name);  
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return names;
	}

	public double getAnnualExpenses(String year){
		conn = getConnection();
		String query = "select * from expenses where date between ? and ?;";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-01-01");
	        preparedStatement.setString(2, year+"-12-31");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("amount");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	
	public void addExpenses(String name, double amount){
		conn = getConnection();
		String query = "insert into expenses (name, amount, date) values (?,?,curdate());";
			
		try {
			preparedStatement = conn.prepareStatement(query);
		    // Parameters start with 1
		    preparedStatement.setString(1, name); 
		    preparedStatement.setDouble(2, amount);
//		    preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
		    
		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into expenses table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Expenses> getExpenses(String name) {
		List<Expenses> expenses = new ArrayList<Expenses>();
        conn = getConnection();
		String query = "select * from expenses where name = ? order by date;";       
            try {
            	preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                	Expenses exp= new Expenses(0, null, 0, null);
                
                	exp.setNo(rs.getInt("no"));
                	exp.setName(rs.getString("name"));
                	exp.setAmount(rs.getInt("amount"));
                	exp.setDate(rs.getDate("date")); 
                	expenses.add(exp);
                }
            conn.close();
        	} catch (SQLException e) {
            e.printStackTrace();
        	}
		return expenses;
	}
	
	public List<Expenses> getAllExpenses() {
		List<Expenses> expenses = new ArrayList<Expenses>();
	    conn = getConnection();
		String query = "select * from expenses";
        try {
        	statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
            	Expenses exp= new Expenses(0, null, 0, null);             
            	exp.setNo(rs.getInt("no"));
            	exp.setName(rs.getString("name"));
            	exp.setAmount(rs.getInt("amount"));
            	exp.setDate(rs.getDate("date")); 
            	expenses.add(exp);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return expenses;
	}
	
/**
 * method to add purchases record into the database
 * @param invoiceNumber
 * @param name
 * @param quantity
 * @param unitPrice
 * @param supplier
 */
	
	public void addPurchase(int invoiceNumber, String name, int quantity, double unitPrice, String supplier) {
		conn = getConnection();
		String query = "insert into purchases (invoiceNumber, name, unitPrice, quantity, totalPrice, supplier, dateOfPurchase) "
		+ "values (?,?,?,?,?,?,curdate());";
			
		try {
			preparedStatement = conn.prepareStatement(query);
		    // Parameters start with 1
			preparedStatement.setInt(1, invoiceNumber);
		    preparedStatement.setString(2, name); 
		    preparedStatement.setDouble(3, unitPrice);
		    preparedStatement.setInt(4, quantity);
		    preparedStatement.setDouble(5, quantity*unitPrice);
		    preparedStatement.setString(6, supplier);
		    
		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into purchases table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	
//	public void deletePurchase(Purchase obj) {
//		conn = getConnection();
//		String query = "delete from purchases where name=?";
//        try {
//
//            preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getName());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This purchase record is deleted!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}


	
//	public void updatPurchase(Purchase obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "update purchases set name=?, unitprice=?, quantity=?, totalprice=? supplier=? dateofpurchase=? where name=?";
//		
//		try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getName());	    
//            preparedStatement.setDouble(2, obj.getUnitPrice());
//		    preparedStatement.setInt(3, obj.getQuantity());
//		    preparedStatement.setDouble(4, obj.getTotalPrice());
//		    preparedStatement.setString(5, obj.getSupplier().getName());
//		    preparedStatement.setDate(6, new java.sql.Date(obj.getDateOfPurchase().getTime()));
//
//            preparedStatement.executeUpdate();
//            System.out.println("This purchase's record is updated into purchases table!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}


	
	public List<Purchase> getPurchases(String name) {
		List<Purchase> purchases = new ArrayList<Purchase>();
        conn = getConnection();
		String query = "select * from purchases where name = ? order by dateOfPurchase;";       
            try {
            	preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                	Purchase pur= new Purchase(0,null, 0, 0, 0, null, null);
                	
                	pur.setInvoiceNumber(rs.getInt("invoiceNumber"));
                    pur.setName(rs.getString("name"));
                    pur.setQuantity(rs.getInt("quantity"));
                    pur.setUnitPrice(rs.getDouble("unitprice"));
                    pur.setTotalPrice(rs.getDouble("totalPrice"));
                    pur.setSupplierName(rs.getString("supplier"));
                    pur.setDateOfPurchase(rs.getDate("dateOfPurchase")); 
                    purchases.add(pur);
                }
            conn.close();
        	} catch (SQLException e) {
            e.printStackTrace();
        	}
		return purchases;
	}

	public List<Purchase> getAllPurchases() {
		List<Purchase> purchases = new ArrayList<Purchase>();
	    conn = getConnection();
		String query = "select * from purchases";
        try {
        	statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

            	Purchase pur= new Purchase(0,null, 0, 0, 0, null, null);

            	pur.setInvoiceNumber(rs.getInt("invoiceNumber"));
                pur.setName(rs.getString("name"));
                pur.setQuantity(rs.getInt("quantity"));
                pur.setUnitPrice(rs.getDouble("unitprice"));
                pur.setTotalPrice(rs.getDouble("totalPrice"));
                pur.setSupplierName(rs.getString("supplier"));
                pur.setDateOfPurchase(rs.getDate("dateOfPurchase")); 
                purchases.add(pur);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return purchases;
	}

	public void addSales(String product, double unitprice, int quantity, double VATRate, String customer) {
		
		conn = getConnection();
		String query1 = "insert into sales (product, unitprice, quantity, totalPrice, VAT, VATRate, date, customer)values (?,?,?,?,?,?, curdate(),?);";
		String query2 = "update inventories set date=curdate(), quantity=(quantity-?) where name=?";
		
		try {
			preparedStatement = conn.prepareStatement(query1);

		    // Parameters start with 1
		    preparedStatement.setString(1, product);    
		    preparedStatement.setDouble(2, unitprice);
		    preparedStatement.setInt(3, quantity);
		    preparedStatement.setDouble(4, unitprice*quantity*(1+VATRate));
		    preparedStatement.setDouble(5, unitprice*quantity*VATRate);
		    preparedStatement.setDouble(6, VATRate);
		    preparedStatement.setString(7, customer);
		    
		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into sales table!");
		    


		    } catch (SQLException e) {
			e.printStackTrace();
		}	
		try {

            PreparedStatement preparedStatement = conn.prepareStatement(query2);

            // Parameters start with 1

        
//		    preparedStatement.setDate(2, new java.sql.Date(obj.getDate().getTime()));
		    preparedStatement.setInt(1, quantity);
		    
		    preparedStatement.setString(2, product);

            preparedStatement.executeUpdate();
            System.out.println("This inventory is updated into inventories table!");
            conn.close();
            } catch (SQLException e) {

            e.printStackTrace();

        }
		
		
	}

//sales can not change?
//	
//	public void deleteSales(Sales obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "delete from sales where invoiceNumber=?";
//        try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setInt(1, obj.getInvoiceNumber());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This sale record is deleted!");
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}
//
//
//	
//	public void updatSales(Sales obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "update sales set product=?, unitprice=?, quantity=?, totalPrice=?, VAT=?, date=curdate(), customer=?"+ "where invoicenumber=?";
//		
//		try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getInventory().getName());
//		    preparedStatement.setDouble(2, obj.getUnitPrice());
//		    preparedStatement.setInt(3, obj.getQuantity());
//		    preparedStatement.setDouble(4, obj.getTotalPrice());
//		    preparedStatement.setDouble(5, obj.getVAT());
//		    preparedStatement.setString(6, obj.getCustomer().getFirstName()+obj.getCustomer().getLastName());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This sales record is updated into sales table!");
//		} catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}


	
	public Sales getSales(int invoiceno) {
		Sales sale= new Sales(null, 0, 0, 0, 0, 0, null, null);
        conn = getConnection();
		String query = "select * from sales where invoicenumber=?";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1, invoiceno);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	
                sale.setProductName(rs.getString("product"));
                sale.setInvoiceNumber(rs.getInt("invoicenumber"));
                sale.setUnitPrice(rs.getDouble("unitprice"));
                sale.setQuantity(rs.getInt("quantity"));
                sale.setTotalPrice(rs.getDouble("totalPrice"));
                sale.setVAT(rs.getDouble("VAT"));
                sale.setDateOfSell(rs.getDate("date"));
                sale.setCustomerName(rs.getString("customer"));
                   
            }
            conn.close();
        	} catch (SQLException e) {

            e.printStackTrace();

        	}
		return sale;

	}


	
	public List<Sales> getAllSales() {
		List<Sales> sales = new ArrayList<Sales>();
	    conn = getConnection();
		String query = "select * from sales order by date DESC";
        try {
        	statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

            	Sales sale= new Sales(null, 0, 0, 0, 0, 0, null, null);

            	sale.setProductName(rs.getString("product"));
                sale.setInvoiceNumber(rs.getInt("invoicenumber"));
                sale.setUnitPrice(rs.getDouble("unitprice"));
                sale.setQuantity(rs.getInt("quantity"));
                sale.setTotalPrice(rs.getDouble("totalPrice"));
                sale.setVAT(rs.getDouble("VAT"));
                sale.setDateOfSell(rs.getDate("date"));
                sale.setCustomerName(rs.getString("customer"));
              sales.add(sale);

            }
            conn.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }
		return sales;
	}
	
//	public Object[][] resultSetToObjectArray(ResultSet rs) {  
//	    Object[][] data = null;  
//	    try {     
//	        rs.last();  
//	        int rows = rs.getRow();  
//	        data = new Object[rows][];    
//	        ResultSetMetaData md = rs.getMetaData();//获取记录集的元数据  
//	        int columnCount = md.getColumnCount();//列数  
//	        rs.first();  
//	        int k = 0;  
//	        while(rs.next()) {  
//	            System.out.println("i"+k);  
//	            Object[] row = new Object[columnCount];  
//	            for(int i=0; i<columnCount; i++) {  
//	                row[i] = rs.getObject(i+1).toString();  
//	            }  
//	            data[k] = row;  
//	            k++;  
//	        }  
//	    } catch (Exception e) {  
//	    }  
//	    return data;  
//	}     


	
	public void addSupplier(String n, String add, String cn) {
		conn = getConnection();
		String query = "insert into suppliers values (?,?,?);";	
		try {
			preparedStatement = conn.prepareStatement(query);
		    // Parameters start with 1
		    preparedStatement.setString(1, n);
		    preparedStatement.setString(2, add);
		    preparedStatement.setString(3, cn);

		    preparedStatement.executeUpdate();
		    System.out.println("Record is inserted into supplies table!");
		    conn.close();
		    } catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}


	
//	public void deleteSupplier(Supplier obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "delete from suppliers where contactNumber=?";
//        try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getContactNumber());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This supplier is deleted!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//		
//	}


	
//	public void updatSupplier(Supplier obj) {
//		preparedStatement = null;
//		conn = getConnection();
//		String query = "update suppliers set name=?, address=?, contactnumber=? where contactnumber=?";
//		
//		try {
//
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, obj.getName());
//            preparedStatement.setString(2, obj.getAddress());
//		    preparedStatement.setString(3, obj.getContactNumber());
//
//            preparedStatement.executeUpdate();
//            System.out.println("This supplier's information is updated into sales table!");
//            conn.close();
//            } catch (SQLException e) {
//
//            e.printStackTrace();
//
//        }
//	}


	
	public List<Supplier> getSuppliers(String name) {
		List<Supplier> sups = new ArrayList<Supplier>();
	    conn = getConnection();
		String query = "select * from suppliers where name = ? order by name;";
        try {
            statement = conn.createStatement();
            preparedStatement.setString(1, name);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Supplier sup= new Supplier(null, null, null);
            	 sup.setName(rs.getString("name"));
                 sup.setAddress(rs.getString("address"));
                 sup.setContactNumber(rs.getString("contactNumber"));    
                 sups.add(sup);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return sups;
	}
	
	public List<Supplier> getAllSuppliers() {
		List<Supplier> sups = new ArrayList<Supplier>();
	    conn = getConnection();
		String query = "select * from suppliers";
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Supplier sup= new Supplier(null, null, null);
            	 sup.setName(rs.getString("name"));
                 sup.setAddress(rs.getString("address"));
                 sup.setContactNumber(rs.getString("contactNumber"));    
                 sups.add(sup);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return sups;
	}

	
	public double getCurrentAssets() {
		conn = getConnection();
		String query = "select * from assets;";
		double d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();

	       
	        while (rs.next()) {
	        	d+=(rs.getInt("quantity")*rs.getDouble("unitValue"));
	        }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}

	
	public int getCurrentInventory() {
		conn = getConnection();
		String query = "select * from inventories;";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	d+=(rs.getDouble("unitCost")*rs.getInt("quantity"));
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	//need to update inventories every year at 01-01 and 31-12
	public double getOpeningInventories(String year){
		conn = getConnection();
		String query = "select * from inventories where date = ?;";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-01-01");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("totalCost");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	

	public double getClosingInventories(String year){
		conn = getConnection();
		String query = "select * from inventories where date = ?;";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-12-31");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("totalCost");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	
	public double getAnnualPurchases(String year){
		conn = getConnection();
		String query = "select * from purchases where dateOfPurchase between ? and ?;";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-01-01");
	        preparedStatement.setString(2, year+"-12-31");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("totalPrice");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	
	public double getAnnualSales(String year){
		conn = getConnection();
		String query = "select * from sales where date between ? and ?;";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1, year+"-01-01");
	        preparedStatement.setString(2, year+"-12-31");
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	d+=rs.getDouble("totalPrice");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}

	public double getCurrentReceivables() {
		conn = getConnection();
		String query = "SELECT * FROM receivables;";
		double d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	d+=rs.getDouble("amount");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
		return d;
	}


	public double getCurrentPayables() {
		conn = getConnection();
		String query = "SELECT * FROM payables;";
		double d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	d+=rs.getDouble("amount");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}		

	public double getCurrentMonthlySales() {
		conn = getConnection();
		String query = "SELECT * FROM sales WHERE DATE_FORMAT(date, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m');";
		int d = 0;
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	d+=rs.getDouble("totalPrice");
	        }
	        conn.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return d;
	}
	
	public List<Note> getAllNotes() {
	    List<Note> notes = new ArrayList<Note>();
	    conn = getConnection();
		String query = "select * from notes;";
       
		try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
            	Note note = new Note(0, null, null);
            	note.setId(rs.getInt("id"));
            	note.setNote(rs.getString("note"));
            	note.setDate(rs.getDate("date"));
            	notes.add(note);
            	
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
        
	}

	
}
