package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.StringUtils;

import GUI.Homepage;
import GUI.Login;

import GUI.RSSReader;
import database.Database;
/**
 * Client class play the controller role in MVC.
 * @author Bingyao Tian
 * @version 11-12-2016
 */
public class Client{

	private NumberFormat nf = NumberFormat.getInstance();
	private Login loginView;
	private static Database Model;
//	private Homepage Homepage;
	public Client(Login loginView, Database Model) {
		this.loginView=loginView;
		this.Model=Model;
//		this.HomepageView = HomepageView;
		
		this.loginView.addLoginListener(new LoginListener());
		
		Homepage.addAddNoteListener(new AddNoteListener());	
		Homepage.addAddSalesListener(new AddSalesListener());		
		Homepage.addSearchSaleListener(new SearchSaleListener());
		Homepage.addSearchSalesListener(new SearchSalesListener());
		
		Homepage.addAddInventoryListener(new AddInventoryListener());
		Homepage.addSearchInventoryListener(new SearchInventoryListener());
		Homepage.addSearchInventoriesListener(new SearchInventoriesListener());
		
		Homepage.addAddAssetListener(new AddAssetListener());
		Homepage.addSearchAssetListener(new SearchAssetListener());
		Homepage.addSearchAssetsListener(new SearchAssetsListener());
		
		Homepage.addAddPurchaseListener(new AddPurchaseListener());
		Homepage.addSearchPurchasesListener(new SearchPurchasesListener());
		Homepage.addSearchAllPurchasesListener(new SearchAllPurchasesListener());
		
		Homepage.addAddExpensesListener(new AddExpensesListener());
		Homepage.addSearchExpensesListener(new SearchExpensesListener());
		Homepage.addSearchAllExpensesListener(new SearchAllExpensesListener());
		
		Homepage.addAddCustomerListener(new AddCustomerListener());
		Homepage.addSearchCustomerListener(new SearchCustomerListener());
		Homepage.addSearchAllCustomersListener(new SearchAllCustomersListener());
		
		Homepage.addAddSupplierListener(new AddSupplierListener());
		Homepage.addSearchSuppliersListener(new SearchSuppliersListener());
		Homepage.addSearchAllSuppliersListener(new SearchAllSuppliersListener());
		
		Homepage.addAddEmployeeListener(new AddEmployeeListener());
		Homepage.addSearchEmployeesListener(new SearchEmployeesListener());
		Homepage.addSearchAllEmployeesListener(new SearchAllEmployeesListener());
		
		Homepage.addAddLiabilityListener(new AddLiabilityListener());
		Homepage.addSearchLiabilityListener(new SearchLiabilityListener());
		Homepage.addSearchAllLiabilitiesListener(new SearchAllLiabilitiesListener());
		
		Homepage.addUpdateUserListener(new UpdateUserListener());

		Homepage.addIsListener(new IsListener());
		Homepage.addFpListener(new FpListener());
		updateCB();
		OutData t = new OutData();
		t.start();
	}
	
	/**
	 * method to check if the String is number
	 * @param str
	 * @return 
	 */
	
	public boolean isNumeric(String str){
		  int index = str.indexOf(".");
		  if(index<0){
		   return StringUtils.isStrictlyNumeric(str);
		  }else{
		   String num1 = str.substring(0,index);
		   String num2 = str.substring(index+1);   
		   
		return StringUtils.isStrictlyNumeric(num1) && StringUtils.isStrictlyNumeric(num2);
		  }
		 }
	
/**
 * method to get cost of good sold for that year
 * @param year
 * @return costOfGoodSold
 */
	public double costOfGoodSold(String year){
		return Model.getOpeningInventories(year)+Model.getAnnualPurchases(year)-
				Model.getClosingInventories(year);
	}
	
	/**
	 * method to get gross profit for the specific year
	 * @param year
	 * @return gross profit
	 */
	public double grossProfit(String year){
		return Model.getAnnualSales(year)-costOfGoodSold(year);
	}
	
	public double netProfit(String year){
		return grossProfit(year)-Model.getAnnualExpenses(year);
	}
	
	public void updateCB(){
		
		Homepage.comboBox.removeAllItems();
		 for(int i=0;i<Model.getInventoriesForSale().size();i++)
			 Homepage.comboBox.addItem(Model.getInventoriesForSale().get(i));
		 Homepage.comboBox.repaint();
		 Homepage.comboBox.updateUI();
	}
    
	class IsListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				String year = Homepage.textField_33.getText();

				if(Homepage.textField_33.getText().equals("")||isNumeric(Homepage.textField_33.getText())==false) {
					JOptionPane.showMessageDialog(null,
						    "You need type a year!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_12.setText("Income statement for XXX company"
							+ "for the year ended 31-December-"+year+"\n"+"\n"+
							"Sales                                                                                                                "+
							Model.getAnnualSales(year)+"\n"+"Cost of goods sold                                                                                        "+
							costOfGoodSold(year)+"\n"+"Gross profit                                                                                                     "
							+grossProfit(year)+"\n"+"\n"
							+"Expenses                                                                                                        "+ 
							Model.getAnnualExpenses(year)+"\n"+"Net Profit                                                                                                        "+
							netProfit(year));
							
					Homepage.textField_23.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();			
				}
				}
			}
	}
	
	public double getTAAYE(String year){
		return Model.getYearEndAssets(year)+Model.getClosingInventories(year);
	}
	
	public double getTEAL(String year){
		return Model.getYearEndLiabilities(year)+netProfit(year);
	}
	
	class FpListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				String year = Homepage.textField_39.getText();

				if(Homepage.textField_39.getText().equals("")||isNumeric(Homepage.textField_39.getText())==false) {
					JOptionPane.showMessageDialog(null,
						    "You need type a year!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_13.setText("Statement of financial position for XXX company"
							+ "at the year ended 31-December-"+year+"\n"+"\n"+
							"Assets                                                                                                                         "+
							Model.getYearEndAssets(year)+"\n"+"Inventories                                                                                                                 "+
							Model.getClosingInventories(year)+"\n"+"Total assets                                                                                                               "+
							getTAAYE(year)+"\n"+"\n"
							+"Liabilities                                                                                                                    "+ 
							Model.getYearEndLiabilities(year)+"\n"+"Net profit                                                                                                                    "+
							netProfit(year)+"\n"+"Total equity and liabilities                                                                                     "+
							getTEAL(year));
							
					Homepage.textField_23.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();			
				}
				}
			}
	}
	
	//update user
	class UpdateUserListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String username = Homepage.textField_1.getText();
			String password = String.valueOf(Homepage.passwordField.getPassword());
			String newUsername = Homepage.textField_43.getText();
			String newPassword = String.valueOf(Homepage.passwordField_1.getPassword());
			if (Model.loginCheck(username, password)==false){
				System.out.println("old username or password wrong!");
				JOptionPane.showMessageDialog(null,
						"old username or password wrong!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			}else if(newUsername.equals("")||newPassword.equals("")) {
				JOptionPane.showMessageDialog(null,
						"You need to fill the new username and password!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			}else {
				try{
					Model.updateUser(newUsername, newPassword);
					JOptionPane.showMessageDialog(null, "Done!", "Warning",
												    JOptionPane.WARNING_MESSAGE);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String username, password = null;
			
			try{
				username = loginView.getUsername();
				password = loginView.getPassword();
				
				if(Model.loginCheck(username, password)==true){
					System.out.println("success");
					
					EventQueue.invokeLater(new Runnable() {
			             @Override
			             public void run() {
			                 try {
			                     Homepage frame = new Homepage();// open Homepage
			                     frame.setVisible(true);
			                     loginView.dispose();
			                 } catch (Exception e) {
			                     e.printStackTrace();
			                 }
			             }
			         });
				}else {
					loginView.displayErrorMessage("Username or password wrong!");
				}
	
			} catch(Exception e){
				loginView.displayErrorMessage("Something wrong with the system!");
			}
		}
	}
	
	class AddNoteListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String n = Homepage.getTextArea();
			if(n.equals("")) {
				JOptionPane.showMessageDialog(null,
					    "You need type something!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			} else{
				try{
				Model.addNote(n);
				Homepage.textArea_1.setText("");
				System.out.println("success");
				JOptionPane.showMessageDialog(null,
					    "Done!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}catch(Exception e) {
			e.printStackTrace();
				
			}
		}
		}
	}
//	class AddCbListener implements ActionListener{
//		public void actionPerformed(ActionEvent arg0) {
//		Homepage.comboBox.removeAllItems();
//		 for(int i=0;i<Model.getInventoriesForSale().toArray().length;i++)
//			 Homepage.comboBox.addItem(Model.getInventoriesForSale().toArray()[i]);
//		 Homepage.comboBox.repaint();
//		 Homepage.comboBox.updateUI();
//		}
//	}
	
	class AddSalesListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String item = String.valueOf(Homepage.comboBox.getSelectedItem());
			double unitprice=0, VATRate =0;
			int quantity =0;
			try {
				unitprice = nf.parse(Homepage.textField_2.getText()).doubleValue();
				quantity = nf.parse(Homepage.textField_4.getText()).intValue();
				VATRate = nf.parse(Homepage.textField_5.getText()).doubleValue();
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			String customer = Homepage.textField_3.getText();
			
			if(Homepage.comboBox.getSelectedItem().equals("")||Homepage.textField_2.getText().equals("")||
					Homepage.textField_4.getText().equals("")||Homepage.textField_5.getText().equals("")) {
								JOptionPane.showMessageDialog(null,
					    "You can't leave item, unit price quantity or VAT rate blank!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}else if(isNumeric(Homepage.textField_2.getText())==false||isNumeric(Homepage.textField_4.getText())==false
					||isNumeric(Homepage.textField_5.getText())==false) {
				JOptionPane.showMessageDialog(null,
						"You must enter number correctly!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			}else if(quantity>Model.getInventoryQuantity(item)){
				JOptionPane.showMessageDialog(null,
					    "Stock is not enough!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);	
			}else{
				try{
				Model.addSales(item, unitprice, quantity, VATRate, customer);
				Homepage.textField_2.setText("");
				Homepage.textField_3.setText("");
				Homepage.textField_4.setText("");
				Homepage.textField_5.setText("");
				Model.updateInventory(item, quantity);
				System.out.println("success");
				JOptionPane.showMessageDialog(null,
					    "Done!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
				}catch(Exception e) {
			e.printStackTrace();	
			}
			}
		}
	}
	
	class SearchSaleListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			try {
				i = nf.parse(Homepage.textField.getText()).intValue();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			if(Homepage.textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
					    "You need type something!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			} else if(isNumeric(Homepage.textField.getText())==false) {
				JOptionPane.showMessageDialog(null,
						"You must enter number correctly!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			}else{
				try{
				
				Homepage.textArea_3.setText(Model.getSales(i).toString());
				System.out.println("success");
			}catch(Exception e) {
			e.printStackTrace();
				
			}
		}
		}
	}
	
	class SearchSalesListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				try{
				
				Homepage.textArea_3.setText(Model.getAllSales().toString());
				System.out.println("success");
			}catch(Exception e) {
			e.printStackTrace();
				
			}
		}
	
	}
	
	//inventories tab 
	
	class AddInventoryListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String item = Homepage.textField_7.getText();
			double unitcost = 0;
			int quantity = 0;
			try {
				quantity = nf.parse(Homepage.textField_8.getText()).intValue();
				unitcost = nf.parse(Homepage.textField_10.getText()).doubleValue();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			if(Homepage.textField_7.getText().equals("")||Homepage.textField_8.getText().equals("")
					||Homepage.textField_10.getText().equals("")) {
								JOptionPane.showMessageDialog(null,
					    "You can't leave item or quantity blank!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			} else if(isNumeric(Homepage.textField_8.getText())==false||isNumeric(Homepage.textField_10.getText())==false) {
				JOptionPane.showMessageDialog(null,
						"You must enter number correctly!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			}else{
				try{
				Model.addInventory(item, quantity, unitcost);
				Homepage.textField_7.setText("");
				Homepage.textField_8.setText("");
				Homepage.textField_10.setText("");
				Homepage.comboBox.addItem(item);
				System.out.println("success");
				JOptionPane.showMessageDialog(null,
					    "Done!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
				}catch(Exception e) {
			e.printStackTrace();	
			}
		}
		}
	}
	
	class SearchInventoryListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String s = Homepage.textField_6.getText();

			if(Homepage.textField_6.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
					    "You need type something!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			} else{
				try{
				Homepage.textArea_4.setText(Model.getInventory(s).toString());
				System.out.println("success");
			}catch(Exception e) {
			e.printStackTrace();
				
			}
			}
		}
	}
	
	class SearchInventoriesListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				try{
				
				Homepage.textArea_4.setText(Model.getAllInventories().toString());
				System.out.println("success");
			}catch(Exception e) {
			e.printStackTrace();
				
			}
		}
	
	}
	
	//asset tab
	class AddAssetListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String item = Homepage.textField_11.getText();
			int quantity = 0;
			double unitcost = 0;		
			try {
				quantity = nf.parse(Homepage.textField_12.getText()).intValue();
				unitcost = nf.parse(Homepage.textField_13.getText()).doubleValue();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(Homepage.textField_11.getText().equals("")||Homepage.textField_12.getText().equals("")
					||Homepage.textField_13.getText().equals("")) {
								JOptionPane.showMessageDialog(null,
					    "You can't leave item or quantity or unit value blank!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			} else if(isNumeric(Homepage.textField_12.getText())==false||isNumeric(Homepage.textField_13.getText())==false) {
				JOptionPane.showMessageDialog(null,
						"You must enter number correctly!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
			}else{
				try{
				Model.addAsset(item, quantity, unitcost);
				Homepage.textField_11.setText("");
				Homepage.textField_12.setText("");
				Homepage.textField_13.setText("");
				System.out.println("success");
				JOptionPane.showMessageDialog(null,
					    "Done!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
				}catch(Exception e) {
			e.printStackTrace();	
			}
		}
		}
	}
	
	class SearchAssetListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String s = Homepage.textField_9.getText();

			if(Homepage.textField_9.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
					    "You need type something!",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			} else{
				try{
				Homepage.textArea_5.setText(Model.getAsset(s).toString());
				System.out.println("success");
			}catch(Exception e) {
			e.printStackTrace();
				
			}
			}
		}
	}
	
	class SearchAssetsListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
				try{
				
				Homepage.textArea_5.setText(Model.getAllAssets().toString());
				System.out.println("success");
			}catch(Exception e) {
			e.printStackTrace();
				
			}
		}
	
	}
	//Purchases tab
		class AddPurchaseListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String item = Homepage.textField_15.getText();
				double unitPrice = 0;
				int quantity = 0;
				int invoiceNumber=0;
				String supplier = Homepage.textField_17.getText();
						
				try {
					unitPrice = nf.parse(Homepage.textField_16.getText()).doubleValue();
					quantity = nf.parse(Homepage.textField_18.getText()).intValue();
					invoiceNumber = nf.parse(Homepage.textField_19.getText()).intValue();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				if(Homepage.textField_15.getText().equals("")||Homepage.textField_16.getText().equals("")||Homepage.textField_17.getText().equals("")
						||Homepage.textField_18.getText().equals("")||Homepage.textField_19.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
						    "You must fill all the information!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else if(isNumeric(Homepage.textField_16.getText())==false||isNumeric(Homepage.textField_18.getText())==false
						||isNumeric(Homepage.textField_19.getText())==false) {
					JOptionPane.showMessageDialog(null,
							"You must enter number correctly!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
				}else{
					try{
					Model.addPurchase(invoiceNumber,item, quantity, unitPrice, supplier);
					Homepage.textField_15.setText("");
					Homepage.textField_16.setText("");
					Homepage.textField_17.setText("");
					Homepage.textField_18.setText("");
					Homepage.textField_19.setText("");
					System.out.println("success");
					JOptionPane.showMessageDialog(null,
						    "Done!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					}catch(Exception e) {
				e.printStackTrace();	
				}
			}
			}
		}
		
		class SearchPurchasesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String s = Homepage.textField_14.getText();

				if(Homepage.textField_14.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
						    "You need type something!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_6.setText(Model.getPurchases(s).toString());
					Homepage.textField_19.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
				}
			}
		}
		
		class SearchAllPurchasesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
					try{
					
					Homepage.textArea_6.setText(Model.getAllPurchases().toString());
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
			}
		
		}
		
		class AddExpensesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String item = Homepage.textField_21.getText();
				double amount = 0;
						
				try {
					amount = nf.parse(Homepage.textField_22.getText()).doubleValue();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				if(Homepage.textField_21.getText().equals("")||Homepage.textField_22.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
						    "You must fill all the information!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else if(isNumeric(Homepage.textField_22.getText())==false) {
					JOptionPane.showMessageDialog(null,
							"You must enter number correctly!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
				}else{
					try{
					Model.addExpenses(item, amount);
					Homepage.textField_21.setText("");
					Homepage.textField_22.setText("");
					System.out.println("success");
					JOptionPane.showMessageDialog(null,
						    "Done!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					}catch(Exception e) {
				e.printStackTrace();	
				}
			}
			}
		}
		
		class SearchExpensesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String s = Homepage.textField_20.getText();

				if(Homepage.textField_20.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
						    "You need type something!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_7.setText(Model.getExpenses(s).toString());
					Homepage.textField_20.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
				}
			}
		}
		
		class SearchAllExpensesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
					try{
					
					Homepage.textArea_7.setText(Model.getAllExpenses().toString());
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
			}
		}
		
		class AddCustomerListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String fn = Homepage.textField_24.getText();
				String ln = Homepage.textField_25.getText();
				String add = Homepage.textField_27.getText();
				String cn = Homepage.textField_28.getText();
				String email = Homepage.textField_26.getText();
				if(Homepage.textField_25.getText().equals("")||Homepage.textField_28.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
						    "You must enter last name and contact number at least!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Model.addCustomer(fn, ln, add, cn, email);
					Homepage.textField_24.setText("");
					Homepage.textField_25.setText("");
					Homepage.textField_26.setText("");
					Homepage.textField_27.setText("");
					Homepage.textField_28.setText("");
					System.out.println("success");
					JOptionPane.showMessageDialog(null,
						    "Done!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					}catch(Exception e) {
				e.printStackTrace();	
				}
			}
			}
		}
		
		class SearchCustomerListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String s = Homepage.textField_23.getText();

				if(Homepage.textField_23.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
						    "You need type something!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_8.setText(Model.getCustomer(s).toString());
					Homepage.textField_23.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();			
				}
				}
			}
		}
		
		class SearchAllCustomersListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
					try{
					
					Homepage.textArea_8.setText(Model.getAllCustomers().toString());
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
			}
		}
		
		class AddSupplierListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String name = Homepage.textField_30.getText();
				String address = Homepage.textField_31.getText();
				String cn = Homepage.textField_32.getText();
				if(Homepage.textField_30.getText().equals("")||Homepage.textField_32.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
						    "You must enter name and contact number at least!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Model.addSupplier(name, address, cn);
					Homepage.textField_30.setText("");
					Homepage.textField_31.setText("");
					Homepage.textField_32.setText("");
					System.out.println("success");
					JOptionPane.showMessageDialog(null,
						    "Done!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					}catch(Exception e) {
				e.printStackTrace();	
				}
			}
			}
		}
		
		class SearchSuppliersListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String s = Homepage.textField_29.getText();

				if(Homepage.textField_29.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
						    "You need type something!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_9.setText(Model.getSuppliers(s).toString());
					Homepage.textField_29.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();			
				}
				}
			}
		}
		
		class SearchAllSuppliersListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
					try{
					
					Homepage.textArea_9.setText(Model.getAllSuppliers().toString());
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
			}
		}
		
		class AddEmployeeListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String fn = Homepage.textField_34.getText();
				String ln = Homepage.textField_35.getText();
				String gd = Homepage.textField_37.getText();
				int age = 0;
				String cn = Homepage.textField_36.getText();
				String doj = Homepage.txtYyyy.getText()+"-"+Homepage.txtMm.getText()+"-"+Homepage.txtDd.getText();
				String address = Homepage.getTextArea_11();
				try {
					age = nf.parse(Homepage.textField_38.getText()).intValue();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if(Homepage.textField_35.getText().equals("")||Homepage.textField_36.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
						    "You must enter last name and contact number at least!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Model.addEmployee(ln, fn, address, cn, gd, age, doj);
					Homepage.textField_34.setText("");
					Homepage.textField_35.setText("");
					Homepage.textField_36.setText("");
					Homepage.textField_37.setText("");
					Homepage.textField_38.setText("");
					Homepage.txtYyyy.setText("");
					Homepage.txtMm.setText("");
					Homepage.txtDd.setText("");
					Homepage.textArea_11.setText("");
					System.out.println("success");
					JOptionPane.showMessageDialog(null,
						    "Done!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					}catch(Exception e) {
				e.printStackTrace();	
				}
			}
			}
		}
		
		class SearchEmployeesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String s = Homepage.txtLastName.getText();

				if(Homepage.txtLastName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
						    "You need type something!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_10.setText(Model.getEmployees(s).toString());
					Homepage.txtLastName.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();			
				}
				}
			}
		}
		
		class SearchAllEmployeesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
					try{
					
					Homepage.textArea_10.setText(Model.getAllEmployees().toString());
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
			}
		}
		
		class AddLiabilityListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String item = Homepage.textField_41.getText();
				double amount=0;
				try {
					amount = nf.parse(Homepage.textField_42.getText()).doubleValue();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if(Homepage.textField_41.getText().equals("")||Homepage.textField_42.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
						    "You must fill the fields!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else if(isNumeric(Homepage.textField_42.getText())==false) {
					JOptionPane.showMessageDialog(null,
							"You must enter number correctly!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
				}else{
					try{
					Model.addLiability(item, amount);
					Homepage.textField_41.setText("");
					Homepage.textField_42.setText("");
					System.out.println("success");
					JOptionPane.showMessageDialog(null,
						    "Done!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					}catch(Exception e) {
				e.printStackTrace();	
				}
			}
			}
		}
		
		class SearchLiabilityListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				String s = Homepage.textField_40.getText();

				if(Homepage.textField_40.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
						    "You need type something!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else{
					try{
					Homepage.textArea_14.setText(Model.getLiability(s).toString());
					Homepage.textField_40.setText("");
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();			
				}
				}
			}
		}
		
		class SearchAllLiabilitiesListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
					try{
					
					Homepage.textArea_14.setText(Model.getAllLiabilities().toString());
					System.out.println("success");
				}catch(Exception e) {
				e.printStackTrace();
					
				}
			}
		}
		
	    public class OutData extends Thread{
	    	public void run(){
	    		for(int i=0;i<(2147483647);i++){
	    			try{	
	    				setOverview();
	    				sleep(1000);
	    			}catch (Exception e){
	    			e.printStackTrace();
	    		}
	    	}
	    	}
	    }
	    
		public static void setOverview(){	
				try{
				showAllNotes();
				Homepage.textArea.setText(RSSReader.readRSS("http://feeds.bbci.co.uk/news/rss.xml?edition=uk#"));
				Homepage.txtpnReceivables.setText("Total amount of receivables:" + "\n" + "$"+String.valueOf(Model.getCurrentReceivables()));
				Homepage.txtpnPaylables.setText("Total amount of payables:" + "\n" +"$"+String.valueOf(Model.getCurrentPayables()));
				Homepage.txtpnMonthlySales.setText("Current sales in this month:" + "\n" +"$"+String.valueOf(Model.getCurrentMonthlySales()));	
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		
		public static void showAllNotes(){
			try{
				Homepage.textArea_2.setText(Model.getAllNotes().toString());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
