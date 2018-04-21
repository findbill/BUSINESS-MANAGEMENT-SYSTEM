package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class Homepage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel sales = new JPanel();
	JPanel purchases = new JPanel();
	JPanel inventories = new JPanel();
	JPanel assets = new JPanel();
	JPanel expenses = new JPanel();
	JPanel customers = new JPanel();
	JPanel suppliers = new JPanel();
	JPanel employees = new JPanel();
	JPanel financialReports = new JPanel();
	JPanel settings = new JPanel();
	JPanel overview = new JPanel();
	JPanel liability = new JPanel();
	
	JLabel liabilityLabel = new JLabel("Liabilities");
	JLabel salesLabel = new JLabel("Sales");
	JLabel purchasesLabel = new JLabel("Purchases");
	JLabel inventoriesLabel = new JLabel("Inventories");
	JLabel assetsLabel = new JLabel("Assets");
	JLabel expensesLabel = new JLabel("Expenses");
	JLabel customersLabel = new JLabel("Customers");
	JLabel suppliersLabel = new JLabel("Suppliers");
	JLabel employeesLabel = new JLabel("Employees");
	JLabel financialReportsLabel = new JLabel("<html>Financial<br>Report</Reports>");
	JLabel settingsReportsLabel = new JLabel("Settings");
	
	private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd" +"\n" + "hh:mm:ss";
	private String time;  
	private int ONE_SECOND = 1000;
	private final JTextPane textPane = new JTextPane();
	private final JSplitPane splitPane_2 = new JSplitPane();
	private final JTextPane txtpnRssFeedsbbc = new JTextPane();
	private final JScrollPane scrollPane = new JScrollPane();
	public static final JTextArea textArea = new JTextArea();
	private final JSplitPane splitPane_3 = new JSplitPane();
	private final JPanel panel_1 = new JPanel();
	private final static JButton btnAdd = new JButton("Add");
	public static final JTextArea textArea_1 = new JTextArea();
	private static final JScrollPane scrollPane_1 = new JScrollPane();
	public static final JTextArea textArea_2 = new JTextArea();
	public static final JTextPane txtpnReceivables = new JTextPane();
	public static final JTextPane txtpnPaylables = new JTextPane();
	public static final JTextPane txtpnMonthlySales = new JTextPane();
	private final JSplitPane splitPane_4 = new JSplitPane();
	private final JPanel panel_2 = new JPanel();
	public static final JTextField textField = new JTextField();
	private final JLabel lblSearchSaleRecord = new JLabel("Search sale record by using invoice number");
	private static final JButton button_1 = new JButton("Search");
	private final JLabel lblAddNewSale = new JLabel("Add new sale");
	private final JLabel lblProduct = new JLabel("Item");
	public static final JTextField textField_2 = new JTextField();
	public static final JTextField textField_3 = new JTextField();
	public static final JTextField textField_4 = new JTextField();
	public static final JTextField textField_5 = new JTextField();
	private final JLabel lblUnitPrice = new JLabel("Unit price");
	private final JLabel lblQuantity = new JLabel("Quantity");
	private final JLabel lblVatRate = new JLabel("VAT rate");
	private final JLabel lblCustomer = new JLabel("<html>Customer<br>(last name)</Reports>");
	private static final JButton btnNewButton = new JButton("Submit");
	private final JScrollPane scrollPane_2 = new JScrollPane();
	public static final JTextArea textArea_3 = new JTextArea();
	private final JLabel lblSearchAllSales = new JLabel("Search all sales records");
	private static final JButton btnNewButton_1 = new JButton("Search");
	private final JSplitPane splitPane_5 = new JSplitPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JPanel panel_3 = new JPanel();
	public static final JTextField textField_6 = new JTextField();
	private final JLabel lblSearchInventoryBy = new JLabel("Search inventory by using product name");
	private static final JButton button = new JButton("Search");
	private final JLabel lblAddNewInventory = new JLabel("Add new inventory");
	public static final JTextField textField_7 = new JTextField();
	private final JLabel label_2 = new JLabel("Item");
	public static final JTextField textField_8 = new JTextField();
	public static final JTextField textField_10 = new JTextField();
	private final JLabel lblUnitCost = new JLabel("Unit cost");
	private final JLabel label_4 = new JLabel("Quantity");
	private static final JButton button_2 = new JButton("Submit");
	private final JLabel lblSearchAllInventoriess = new JLabel("Search all inventories records");
	private static final JButton button_3 = new JButton("Search");
	public static final JTextArea textArea_4 = new JTextArea();
	private final JSplitPane splitPane_6 = new JSplitPane();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JPanel panel_4 = new JPanel();
	public static final JTextField textField_9 = new JTextField();
	private final JLabel lblSearchAssetBy = new JLabel("Search asset by using asset name");
	private static final JButton button_4 = new JButton("Search");
	private final JLabel lblAddNewAsset = new JLabel("Add or update asset");
	public static final JTextField textField_11 = new JTextField();
	private final JLabel label_3 = new JLabel("Item");
	public static final JTextField textField_12 = new JTextField();
	public static final JTextField textField_13 = new JTextField();
	private final JLabel lblUnitPrice_1 = new JLabel("Unit Value");
	private final JLabel label_6 = new JLabel("Quantity");
	private static final JButton button_5 = new JButton("Submit");
	private final JLabel lblSearchAllAssets = new JLabel("Search all assets records");
	private static final JButton button_6 = new JButton("Search");
	public static final JTextArea textArea_5 = new JTextArea();
	private final JSplitPane splitPane_7 = new JSplitPane();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final JPanel panel_5 = new JPanel();
	public static final JTextField textField_14 = new JTextField();
	private final JLabel lblSearchSaleRecord_1 = new JLabel("Search purchases record by using item name");
	private static final JButton button_7 = new JButton("Search");
	private final JLabel lblAddNewPurchase = new JLabel("Add new purchase");
	public static final JTextField textField_15 = new JTextField();
	private final JLabel lblName = new JLabel("Item");
	public static final JTextField textField_16 = new JTextField();
	public static final JTextField textField_17 = new JTextField();
	public static final JTextField textField_18 = new JTextField();
	public static final JTextField textField_19 = new JTextField();
	private final JLabel label_7 = new JLabel("Unit price");
	private final JLabel label_8 = new JLabel("Quantity");
	private final JLabel lblInvoiceNumber = new JLabel("Invoice No.");
	private final JLabel lblSupplier = new JLabel("Supplier");
	private static final JButton button_8 = new JButton("Submit");
	private final JLabel lblSearchAllPurchases = new JLabel("Search all purchases records");
	private static final JButton button_9 = new JButton("Search");
	public static final JTextArea textArea_6 = new JTextArea();
	private final JSplitPane splitPane_8 = new JSplitPane();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JPanel panel_6 = new JPanel();
	public static final JTextField textField_20 = new JTextField();
	private final JLabel lblSearchExpensesBy = new JLabel("Search expenses by using expenses name");
	private static final JButton button_10 = new JButton("Search");
	private final JLabel lblAddNewExpenses = new JLabel("Add new expenses");
	public static final JTextField textField_21 = new JTextField();
	private final JLabel label_5 = new JLabel("Item");
	public static final JTextField textField_22 = new JTextField();
	private final JLabel lblAmount = new JLabel("Amount");
	private static final JButton button_11 = new JButton("Submit");
	private final JLabel lblSearchAllExpenses = new JLabel("Search all expenses records");
	private static final JButton button_12 = new JButton("Search");
	public static final JTextArea textArea_7 = new JTextArea();
	private final JSplitPane splitPane_9 = new JSplitPane();
	private final JScrollPane scrollPane_7 = new JScrollPane();
	private final JPanel panel_7 = new JPanel();
	public static final JTextField textField_23 = new JTextField();
	private final JLabel lblSearchCustomerRecord = new JLabel("Search customer record by using contact no.");
	private static final JButton button_13 = new JButton("Search");
	private final JLabel lblAddNewCustomer = new JLabel("Add new customer");
	public static final JTextField textField_24 = new JTextField();
	private final JLabel lblFirstName = new JLabel("First name");
	public static final JTextField textField_25 = new JTextField();
	public static final JTextField textField_26 = new JTextField();
	public static final JTextField textField_27 = new JTextField();
	public static final JTextField textField_28 = new JTextField();
	private final JLabel lblLastName = new JLabel("Last name");
	private final JLabel lblAddress = new JLabel("Address");
	private final JLabel lblContactNo = new JLabel("Contact No.");
	private final JLabel lblEmailAddress = new JLabel("Email");
	private static final JButton button_14 = new JButton("Submit");
	private final JLabel lblSearchAllCustomers = new JLabel("Search all customers records");
	private static final JButton button_15 = new JButton("Search");
	public static final JTextArea textArea_8 = new JTextArea();
	private final JSplitPane splitPane_10 = new JSplitPane();
	private final JScrollPane scrollPane_8 = new JScrollPane();
	private final JPanel panel_8 = new JPanel();
	public static final JTextField textField_29 = new JTextField();
	private final JLabel lblSearchSupplierBy = new JLabel("Search supplier by using name");
	private static final JButton button_16 = new JButton("Search");
	private final JLabel lblAddNewSupplier = new JLabel("Add new supplier");
	public static final JTextField textField_30 = new JTextField();
	private final JLabel lblName_1 = new JLabel("Name");
	public static final JTextField textField_31 = new JTextField();
	public static final JTextField textField_32 = new JTextField();
	private final JLabel lblContactNo_1 = new JLabel("Contact No.");
	private final JLabel lblAddress_1 = new JLabel("Address");
	private static final JButton button_17 = new JButton("Submit");
	private final JLabel lblSearchAllSuppliers = new JLabel("Search all suppliersus records");
	private static final JButton button_18 = new JButton("Search");
	public static final JTextArea textArea_9 = new JTextArea();
	private final JSplitPane splitPane_11 = new JSplitPane();
	private final JScrollPane scrollPane_9 = new JScrollPane();
	private final JPanel panel_9 = new JPanel();
	public static final JTextField txtLastName = new JTextField();
	private final JLabel lblSearchEmployeeRecord = new JLabel("Search employees records");
	private static final JButton button_19 = new JButton("Search");
	private final JLabel lblAddOrUpdate = new JLabel("Add or update employee information");
	public static final JTextField textField_34 = new JTextField();
	private final JLabel lblFirstName_1 = new JLabel("First name");
	public static final JTextField textField_35 = new JTextField();
	public static final JTextField textField_36 = new JTextField();
	public static final JTextField textField_37 = new JTextField();
	public static final JTextField textField_38 = new JTextField();
	private final JLabel lblLastName_1 = new JLabel("Last name");
	private final JLabel lblGender = new JLabel("Gender");
	private final JLabel lblAge = new JLabel("Age");
	private final JLabel lblContactNo_2 = new JLabel("Contact No.");
	private static final JButton button_20 = new JButton("Submit");
	private final JLabel lblSearchAllEmployees = new JLabel("Search all employees records");
	private static final JButton button_21 = new JButton("Search");
	public static final JTextArea textArea_10 = new JTextArea();
	public static final JTextField txtYyyy = new JTextField();
	public static final JTextField txtMm = new JTextField();
	public static final JTextField txtDd = new JTextField();
	public static JTextArea textArea_11 = new JTextArea();
	private final JSplitPane splitPane_12 = new JSplitPane();
	public static final JTextArea textArea_12 = new JTextArea();
	public static final JTextArea textArea_13 = new JTextArea();
	private static final JButton btnNewButton_2 = new JButton("Submit");
	public static final JTextField textField_33 = new JTextField();
	public static final JTextField textField_39 = new JTextField();
	private final JLabel lblYear = new JLabel("Year");
	private final JLabel label = new JLabel("Year");
	private static final JButton btnSubmit = new JButton("Submit");
	private final JSplitPane splitPane_13 = new JSplitPane();
	private final JScrollPane scrollPane_10 = new JScrollPane();
	private final JPanel panel_10 = new JPanel();
	public static final JTextField textField_40 = new JTextField();
	private final JLabel lblSearchLiabilitiesBy = new JLabel("Search liabilities by using name");
	private final static  JButton button_22 = new JButton("Search");
	private final JLabel lblAddOrUpdate_1 = new JLabel("Add or update liabilities");
	public static final JTextField textField_41 = new JTextField();
	private final JLabel lblItem = new JLabel("Item");
	public static final JTextField textField_42 = new JTextField();
	private final JLabel lblAmount_1 = new JLabel("Amount");
	private static final JButton button_23 = new JButton("Submit");
	private final JLabel lblSearchAllLiabilities = new JLabel("Search all liabilities records");
	private static final JButton button_24 = new JButton("Search");
	public static final JTextArea textArea_14 = new JTextArea();
	private static final JButton button_28 = new JButton("Submit");
	public static JComboBox comboBox = new JComboBox();
	private final JPanel panel_11 = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("Old username");
	private final JLabel lblNewLabel_2 = new JLabel("New username");
	private final JLabel lblNewLabel_3 = new JLabel("Old password");
	private final JLabel lblNewLabel_4 = new JLabel("New password");
	public static final JTextField textField_1 = new JTextField();
	public static final JTextField textField_43 = new JTextField();
	public static final JPasswordField passwordField = new JPasswordField();
	public static final JPasswordField passwordField_1 = new JPasswordField();
	private static JButton btnNewButton_3 = new JButton("Submit");

	
//	private static Client client;

	/**
	 * Create the frame.
	 */
	public Homepage() {
		setResizable(false);
		textField_33.setBounds(275, 1, 78, 21);
		textField_33.setColumns(10);
		setTitle("Business Management Software");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(957, 724));
		getContentPane().setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 944, 681);
		getContentPane().add(tabbedPane);
		tabbedPane.add("Overview", overview);
		overview.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		overview.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(1, 4, 5, 0));
		configTimeArea();
		textPane.setForeground(new Color(0, 128, 128));
		textPane.setDisabledTextColor(new Color(255, 255, 0));
		textPane.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		textPane.setBackground(Color.LIGHT_GRAY);
		
		panel.add(textPane);

		txtpnReceivables.setForeground(new Color(0, 255, 0));
		txtpnReceivables.setBackground(Color.GRAY);
		txtpnReceivables.setDisabledTextColor(new Color(0, 0, 128));
		txtpnReceivables.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		txtpnReceivables.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(txtpnReceivables);
//		getCurrentReceivables();
		
		
		txtpnPaylables.setForeground(new Color(255, 0, 0));
		txtpnPaylables.setBackground(Color.GRAY);
		txtpnPaylables.setDisabledTextColor(new Color(0, 128, 128));
		txtpnPaylables.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		panel.add(txtpnPaylables);
		
		
		txtpnMonthlySales.setForeground(new Color(0, 0, 139));
		txtpnMonthlySales.setBackground(Color.GRAY);
		txtpnMonthlySales.setDisabledTextColor(new Color(0, 128, 128));
		txtpnMonthlySales.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		panel.add(txtpnMonthlySales);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(splitPane_1);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		splitPane_1.setLeftComponent(splitPane_2);
		txtpnRssFeedsbbc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtpnRssFeedsbbc.setForeground(new Color(255, 127, 80));
		txtpnRssFeedsbbc.setText("RSS feeds(BBC)");
		
		splitPane_2.setLeftComponent(txtpnRssFeedsbbc);
		txtpnRssFeedsbbc.setSize(getPreferredSize());
		
		splitPane_2.setRightComponent(scrollPane);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);

		textArea.setSize(new Dimension(0, 0));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		
		scrollPane.setViewportView(textArea);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setDividerLocation(400);
		
		splitPane_1.setRightComponent(splitPane_3);
		
		splitPane_3.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_1.add(btnAdd, BorderLayout.EAST);
		
		panel_1.add(textArea_1, BorderLayout.CENTER);
		textArea_1.setSize(getSize());
		
		splitPane_3.setLeftComponent(scrollPane_1);
		textArea_2.setLineWrap(true);
		textArea_2.setEditable(false);
		
		scrollPane_1.setViewportView(textArea_2);
		textArea_2.setSize(getPreferredSize());
//		textArea_2.setText(getAllNotes().toString());
//		OutData t = new OutData();
//		t.start();
		splitPane_1.setDividerLocation(400);
		splitPane.setDividerLocation(100);
		tabbedPane.add("Sales", sales);
		tabbedPane.setBackgroundAt(0, Color.BLUE);
		sales.setLayout(new BorderLayout(0, 0));
		
		sales.add(splitPane_4, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		splitPane_4.setRightComponent(panel_2);
		textField.setColumns(10);
		textField.setBounds(12, 473, 214, 34);
		
		panel_2.add(textField);
		lblSearchSaleRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchSaleRecord.setBounds(12, 442, 311, 21);
		
		panel_2.add(lblSearchSaleRecord);
		button_1.setBounds(248, 472, 75, 35);
		
		panel_2.add(button_1);
		lblAddNewSale.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewSale.setBounds(10, 105, 268, 21);
		
		panel_2.add(lblAddNewSale);
		lblProduct.setBounds(12, 145, 60, 15);
		
		panel_2.add(lblProduct);
		textField_2.setColumns(10);
		textField_2.setBounds(77, 188, 149, 34);
		
		panel_2.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(77, 352, 149, 34);
		
		panel_2.add(textField_3);
		textField_4.setColumns(10);
		textField_4.setBounds(77, 240, 149, 34);
		
		panel_2.add(textField_4);
		textField_5.setColumns(10);
		textField_5.setBounds(77, 297, 149, 34);
		
		panel_2.add(textField_5);
		lblUnitPrice.setBounds(10, 197, 60, 15);
		
		panel_2.add(lblUnitPrice);
		lblQuantity.setBounds(12, 249, 60, 15);
		
		panel_2.add(lblQuantity);
		lblVatRate.setBounds(12, 306, 60, 15);
		
		panel_2.add(lblVatRate);
		lblCustomer.setBounds(12, 352, 75, 34);
		
		panel_2.add(lblCustomer);
		
		btnNewButton.setBounds(248, 328, 75, 58);
		
		panel_2.add(btnNewButton);
		lblSearchAllSales.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllSales.setBounds(10, 574, 160, 21);
		
		panel_2.add(lblSearchAllSales);

		btnNewButton_1.setBounds(230, 567, 93, 34);
		
		panel_2.add(btnNewButton_1);
		
		comboBox.setBounds(77, 136, 149, 34);
		panel_2.add(comboBox);
		
		splitPane_4.setLeftComponent(scrollPane_2);
		textArea_3.setLineWrap(true);
		textArea_3.setEditable(false);
		
		scrollPane_2.setViewportView(textArea_3);
		textArea_3.setSize(getPreferredSize());

		splitPane_4.setDividerLocation(600);
		tabbedPane.add("Purchases", purchases);
		purchases.setLayout(new BorderLayout(0, 0));
		
		purchases.add(splitPane_7);
		
		splitPane_7.setLeftComponent(scrollPane_5);
		textArea_6.setSize(new Dimension(0, 0));
		textArea_6.setLineWrap(true);
		textArea_6.setEditable(false);
		
		scrollPane_5.setViewportView(textArea_6);
		panel_5.setLayout(null);
		
		splitPane_7.setRightComponent(panel_5);
		textField_14.setColumns(10);
		textField_14.setBounds(12, 473, 214, 34);
		
		panel_5.add(textField_14);
		lblSearchSaleRecord_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchSaleRecord_1.setBounds(12, 442, 311, 21);
		
		panel_5.add(lblSearchSaleRecord_1);
		button_7.setBounds(248, 472, 75, 35);
		
		panel_5.add(button_7);
		lblAddNewPurchase.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewPurchase.setBounds(10, 105, 268, 21);
		
		panel_5.add(lblAddNewPurchase);
		textField_15.setColumns(10);
		textField_15.setBounds(77, 136, 149, 34);
		
		panel_5.add(textField_15);
		lblName.setBounds(12, 145, 60, 15);
		
		panel_5.add(lblName);
		textField_16.setColumns(10);
		textField_16.setBounds(77, 188, 149, 34);
		
		panel_5.add(textField_16);
		textField_17.setColumns(10);
		textField_17.setBounds(77, 352, 149, 34);
		
		panel_5.add(textField_17);
		textField_18.setColumns(10);
		textField_18.setBounds(77, 240, 149, 34);
		
		panel_5.add(textField_18);
		textField_19.setColumns(10);
		textField_19.setBounds(77, 297, 149, 34);
		
		panel_5.add(textField_19);
		label_7.setBounds(10, 197, 60, 15);
		
		panel_5.add(label_7);
		label_8.setBounds(12, 249, 60, 15);
		
		panel_5.add(label_8);
		lblInvoiceNumber.setBounds(12, 306, 75, 15);
		
		panel_5.add(lblInvoiceNumber);
		lblSupplier.setBounds(12, 361, 60, 15);
		
		panel_5.add(lblSupplier);
		button_8.setBounds(248, 328, 75, 58);
		
		panel_5.add(button_8);
		lblSearchAllPurchases.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllPurchases.setBounds(10, 574, 210, 21);
		
		panel_5.add(lblSearchAllPurchases);
		button_9.setBounds(230, 567, 93, 34);
		
		panel_5.add(button_9);
		splitPane_7.setDividerLocation(600);
		tabbedPane.add("Inventories", inventories);
		inventories.setLayout(new BorderLayout(0, 0));
		
		inventories.add(splitPane_5);
		
		splitPane_5.setLeftComponent(scrollPane_3);
		textArea_4.setSize(new Dimension(0, 0));
		textArea_4.setLineWrap(true);
		textArea_4.setEditable(false);
		
		scrollPane_3.setViewportView(textArea_4);
		panel_3.setLayout(null);
		
		splitPane_5.setRightComponent(panel_3);
		textField_6.setColumns(10);
		textField_6.setBounds(12, 395, 214, 34);
		
		panel_3.add(textField_6);
		lblSearchInventoryBy.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchInventoryBy.setBounds(12, 364, 311, 21);
		
		panel_3.add(lblSearchInventoryBy);
		button.setBounds(248, 394, 75, 35);
		
		panel_3.add(button);
		lblAddNewInventory.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewInventory.setBounds(10, 105, 268, 21);
		
		panel_3.add(lblAddNewInventory);
		textField_7.setColumns(10);
		textField_7.setBounds(77, 136, 149, 34);
		
		panel_3.add(textField_7);
		label_2.setBounds(12, 145, 60, 15);
		
		panel_3.add(label_2);
		textField_8.setColumns(10);
		textField_8.setBounds(77, 188, 149, 34);
		
		panel_3.add(textField_8);
		textField_10.setColumns(10);
		textField_10.setBounds(77, 240, 149, 34);
		
		panel_3.add(textField_10);
		lblUnitCost.setBounds(12, 249, 60, 15);
		
		panel_3.add(lblUnitCost);
		label_4.setBounds(12, 197, 60, 15);
		
		panel_3.add(label_4);
		button_2.setBounds(248, 214, 75, 58);
		
		panel_3.add(button_2);
		lblSearchAllInventoriess.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllInventoriess.setBounds(12, 518, 210, 21);
		
		panel_3.add(lblSearchAllInventoriess);
		button_3.setBounds(230, 511, 93, 34);
		
		panel_3.add(button_3);
		splitPane_5.setDividerLocation(600);
		tabbedPane.add("Assets", assets);
		assets.setLayout(new BorderLayout(0, 0));
		
		assets.add(splitPane_6);
		
		splitPane_6.setLeftComponent(scrollPane_4);
		textArea_5.setSize(new Dimension(0, 0));
		textArea_5.setLineWrap(true);
		textArea_5.setEditable(false);
		
		scrollPane_4.setViewportView(textArea_5);
		panel_4.setLayout(null);
		
		splitPane_6.setRightComponent(panel_4);
		textField_9.setColumns(10);
		textField_9.setBounds(12, 395, 214, 34);
		
		panel_4.add(textField_9);
		lblSearchAssetBy.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAssetBy.setBounds(12, 364, 311, 21);
		
		panel_4.add(lblSearchAssetBy);
		button_4.setBounds(248, 394, 75, 35);
		
		panel_4.add(button_4);
		lblAddNewAsset.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewAsset.setBounds(10, 105, 268, 21);
		
		panel_4.add(lblAddNewAsset);
		textField_11.setColumns(10);
		textField_11.setBounds(77, 136, 149, 34);
		
		panel_4.add(textField_11);
		label_3.setBounds(12, 145, 60, 15);
		
		panel_4.add(label_3);
		textField_12.setColumns(10);
		textField_12.setBounds(77, 188, 149, 34);
		
		panel_4.add(textField_12);
		textField_13.setColumns(10);
		textField_13.setBounds(77, 240, 149, 34);
		
		panel_4.add(textField_13);
		lblUnitPrice_1.setBounds(12, 249, 60, 15);
		
		panel_4.add(lblUnitPrice_1);
		label_6.setBounds(12, 197, 60, 15);
		
		panel_4.add(label_6);
		button_5.setBounds(248, 214, 75, 58);
		
		panel_4.add(button_5);
		lblSearchAllAssets.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllAssets.setBounds(12, 518, 210, 21);
		
		panel_4.add(lblSearchAllAssets);
		button_6.setBounds(230, 511, 93, 34);
		
		panel_4.add(button_6);
		splitPane_6.setDividerLocation(600);
		
		tabbedPane.add("Expenses", expenses);
		expenses.setLayout(new BorderLayout(0, 0));
		
		expenses.add(splitPane_8);
		
		splitPane_8.setLeftComponent(scrollPane_6);
		textArea_7.setSize(new Dimension(0, 0));
		textArea_7.setLineWrap(true);
		textArea_7.setEditable(false);
		
		scrollPane_6.setViewportView(textArea_7);
		panel_6.setLayout(null);
		
		splitPane_8.setRightComponent(panel_6);
		textField_20.setColumns(10);
		textField_20.setBounds(12, 395, 214, 34);
		
		panel_6.add(textField_20);
		lblSearchExpensesBy.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchExpensesBy.setBounds(12, 364, 311, 21);
		
		panel_6.add(lblSearchExpensesBy);
		button_10.setBounds(248, 394, 75, 35);
		
		panel_6.add(button_10);
		lblAddNewExpenses.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewExpenses.setBounds(10, 105, 268, 21);
		
		panel_6.add(lblAddNewExpenses);
		textField_21.setColumns(10);
		textField_21.setBounds(77, 136, 149, 34);
		
		panel_6.add(textField_21);
		label_5.setBounds(12, 145, 60, 15);
		
		panel_6.add(label_5);
		textField_22.setColumns(10);
		textField_22.setBounds(77, 188, 149, 34);
		
		panel_6.add(textField_22);
		lblAmount.setBounds(12, 197, 60, 15);
		
		panel_6.add(lblAmount);
		button_11.setBounds(248, 164, 75, 58);
		
		panel_6.add(button_11);
		lblSearchAllExpenses.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllExpenses.setBounds(12, 518, 210, 21);
		
		panel_6.add(lblSearchAllExpenses);
		button_12.setBounds(230, 511, 93, 34);
		
		panel_6.add(button_12);
		splitPane_8.setDividerLocation(600);
		tabbedPane.add("Customers", customers);
		customers.setLayout(new BorderLayout(0, 0));
		
		customers.add(splitPane_9, BorderLayout.CENTER);
		
		splitPane_9.setLeftComponent(scrollPane_7);
		textArea_8.setSize(new Dimension(0, 0));
		textArea_8.setLineWrap(true);
		textArea_8.setEditable(false);
		
		scrollPane_7.setViewportView(textArea_8);
		panel_7.setLayout(null);
		
		splitPane_9.setRightComponent(panel_7);
		textField_23.setColumns(10);
		textField_23.setBounds(12, 473, 214, 34);
		
		panel_7.add(textField_23);
		lblSearchCustomerRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchCustomerRecord.setBounds(12, 442, 311, 21);
		
		panel_7.add(lblSearchCustomerRecord);
		button_13.setBounds(248, 472, 75, 35);
		
		panel_7.add(button_13);
		lblAddNewCustomer.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewCustomer.setBounds(10, 105, 268, 21);
		
		panel_7.add(lblAddNewCustomer);
		textField_24.setColumns(10);
		textField_24.setBounds(77, 136, 149, 34);
		
		panel_7.add(textField_24);
		lblFirstName.setBounds(12, 145, 60, 15);
		
		panel_7.add(lblFirstName);
		textField_25.setColumns(10);
		textField_25.setBounds(77, 188, 149, 34);
		
		panel_7.add(textField_25);
		textField_26.setColumns(10);
		textField_26.setBounds(77, 352, 149, 34);
		
		panel_7.add(textField_26);
		textField_27.setColumns(10);
		textField_27.setBounds(77, 240, 149, 34);
		
		panel_7.add(textField_27);
		textField_28.setColumns(10);
		textField_28.setBounds(77, 297, 149, 34);
		
		panel_7.add(textField_28);
		lblLastName.setBounds(10, 197, 60, 15);
		
		panel_7.add(lblLastName);
		lblAddress.setBounds(12, 249, 60, 15);
		
		panel_7.add(lblAddress);
		lblContactNo.setBounds(12, 306, 75, 15);
		
		panel_7.add(lblContactNo);
		lblEmailAddress.setBounds(12, 361, 60, 15);
		
		panel_7.add(lblEmailAddress);
		button_14.setBounds(248, 328, 75, 58);
		
		panel_7.add(button_14);
		lblSearchAllCustomers.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllCustomers.setBounds(10, 574, 210, 21);
		
		panel_7.add(lblSearchAllCustomers);
		button_15.setBounds(230, 567, 93, 34);
		
		panel_7.add(button_15);
		splitPane_9.setDividerLocation(600);
		tabbedPane.add("Suppliers", suppliers);
		suppliers.setLayout(new BorderLayout(0, 0));
		
		suppliers.add(splitPane_10);
		
		splitPane_10.setLeftComponent(scrollPane_8);
		textArea_9.setSize(new Dimension(0, 0));
		textArea_9.setLineWrap(true);
		textArea_9.setEditable(false);
		
		scrollPane_8.setViewportView(textArea_9);
		panel_8.setLayout(null);
		
		splitPane_10.setRightComponent(panel_8);
		textField_29.setColumns(10);
		textField_29.setBounds(12, 395, 214, 34);
		
		panel_8.add(textField_29);
		lblSearchSupplierBy.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchSupplierBy.setBounds(12, 364, 311, 21);
		
		panel_8.add(lblSearchSupplierBy);
		button_16.setBounds(248, 394, 75, 35);
		
		panel_8.add(button_16);
		lblAddNewSupplier.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddNewSupplier.setBounds(10, 105, 268, 21);
		
		panel_8.add(lblAddNewSupplier);
		textField_30.setColumns(10);
		textField_30.setBounds(77, 136, 149, 34);
		
		panel_8.add(textField_30);
		lblName_1.setBounds(12, 145, 60, 15);
		
		panel_8.add(lblName_1);
		textField_31.setColumns(10);
		textField_31.setBounds(77, 188, 149, 34);
		
		panel_8.add(textField_31);
		textField_32.setColumns(10);
		textField_32.setBounds(77, 240, 149, 34);
		
		panel_8.add(textField_32);
		lblContactNo_1.setBounds(12, 249, 60, 15);
		
		panel_8.add(lblContactNo_1);
		lblAddress_1.setBounds(12, 197, 60, 15);
		
		panel_8.add(lblAddress_1);
		button_17.setBounds(248, 214, 75, 58);
		
		panel_8.add(button_17);
		lblSearchAllSuppliers.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllSuppliers.setBounds(12, 518, 210, 21);
		
		panel_8.add(lblSearchAllSuppliers);
		button_18.setBounds(230, 511, 93, 34);
		
		panel_8.add(button_18);
		splitPane_10.setDividerLocation(600);
		tabbedPane.add("Employees", employees);
		employees.setLayout(new BorderLayout(0, 0));
		
		employees.add(splitPane_11);
		
		splitPane_11.setLeftComponent(scrollPane_9);
		textArea_10.setSize(new Dimension(0, 0));
		textArea_10.setLineWrap(true);
		textArea_10.setEditable(false);
		
		scrollPane_9.setViewportView(textArea_10);
		panel_9.setLayout(null);
		
		splitPane_11.setRightComponent(panel_9);
		txtLastName.setText("Last name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(12, 473, 214, 34);
		
		panel_9.add(txtLastName);
		lblSearchEmployeeRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchEmployeeRecord.setBounds(12, 442, 311, 21);
		
		panel_9.add(lblSearchEmployeeRecord);
		button_19.setBounds(248, 472, 75, 35);
		
		panel_9.add(button_19);
		lblAddOrUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddOrUpdate.setBounds(10, 27, 268, 21);
		
		panel_9.add(lblAddOrUpdate);
		textField_34.setColumns(10);
		textField_34.setBounds(77, 58, 149, 34);
		
		panel_9.add(textField_34);
		lblFirstName_1.setBounds(12, 67, 60, 15);
		
		panel_9.add(lblFirstName_1);
		textField_35.setColumns(10);
		textField_35.setBounds(77, 102, 149, 34);
		
		panel_9.add(textField_35);
		textField_36.setColumns(10);
		textField_36.setBounds(77, 234, 149, 34);
		
		panel_9.add(textField_36);
		textField_37.setColumns(10);
		textField_37.setBounds(77, 146, 149, 34);
		
		panel_9.add(textField_37);
		textField_38.setColumns(10);
		textField_38.setBounds(77, 190, 149, 34);
		
		panel_9.add(textField_38);
		lblLastName_1.setBounds(12, 109, 60, 15);
		
		panel_9.add(lblLastName_1);
		lblGender.setBounds(12, 155, 60, 15);
		
		panel_9.add(lblGender);
		lblAge.setBounds(12, 199, 60, 15);
		
		panel_9.add(lblAge);
		lblContactNo_2.setBounds(12, 233, 66, 34);
		
		panel_9.add(lblContactNo_2);
		button_20.setBounds(248, 350, 75, 58);
		
		panel_9.add(button_20);
		lblSearchAllEmployees.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllEmployees.setBounds(10, 574, 216, 21);
		
		panel_9.add(lblSearchAllEmployees);
		button_21.setBounds(230, 567, 93, 34);
		
		panel_9.add(button_21);
		
		JLabel lblAddress_2 = new JLabel("Address");
		lblAddress_2.setBounds(12, 328, 53, 34);
		panel_9.add(lblAddress_2);

		
		txtYyyy.setText("yyyy");
		txtYyyy.setColumns(4);
		txtYyyy.setBounds(77, 278, 60, 34);
		panel_9.add(txtYyyy);
		
		JLabel lblDateOfJoin = new JLabel("<html>Date of<br>join</Reports>");
		lblDateOfJoin.setBounds(12, 277, 60, 34);
		panel_9.add(lblDateOfJoin);
		
		
		textArea_11.setLineWrap(true);
		textArea_11.setColumns(10);
		textArea_11.setBounds(77, 328, 149, 80);
		panel_9.add(textArea_11);
		
		
		txtMm.setText("mm");
		txtMm.setColumns(2);
		txtMm.setBounds(143, 278, 39, 34);
		panel_9.add(txtMm);
		
		txtDd.setText("dd");
		txtDd.setColumns(2);
		txtDd.setBounds(187, 278, 39, 34);
		panel_9.add(txtDd);
		splitPane_11.setDividerLocation(600);
		
		tabbedPane.add("Liabilities", liability);
		liability.setLayout(new BorderLayout(0, 0));
		
		liability.add(splitPane_13, BorderLayout.CENTER);
		
		splitPane_13.setLeftComponent(scrollPane_10);
		textArea_14.setSize(new Dimension(0, 0));
		textArea_14.setLineWrap(true);
		textArea_14.setEditable(false);
		
		scrollPane_10.setViewportView(textArea_14);
		panel_10.setLayout(null);
		
		splitPane_13.setRightComponent(panel_10);
		textField_40.setColumns(10);
		textField_40.setBounds(12, 395, 214, 34);
		
		panel_10.add(textField_40);
		lblSearchLiabilitiesBy.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchLiabilitiesBy.setBounds(12, 364, 311, 21);
		
		panel_10.add(lblSearchLiabilitiesBy);
		button_22.setBounds(248, 394, 75, 35);
		
		panel_10.add(button_22);
		lblAddOrUpdate_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddOrUpdate_1.setBounds(10, 105, 268, 21);
		
		panel_10.add(lblAddOrUpdate_1);
		textField_41.setColumns(10);
		textField_41.setBounds(77, 136, 149, 34);
		
		panel_10.add(textField_41);
		lblItem.setBounds(12, 145, 60, 15);
		
		panel_10.add(lblItem);
		textField_42.setColumns(10);
		textField_42.setBounds(77, 188, 149, 34);
		
		panel_10.add(textField_42);
		lblAmount_1.setBounds(12, 197, 60, 15);
		
		panel_10.add(lblAmount_1);
		button_23.setBounds(248, 164, 75, 58);
		
		panel_10.add(button_23);
		lblSearchAllLiabilities.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSearchAllLiabilities.setBounds(12, 518, 210, 21);
		
		panel_10.add(lblSearchAllLiabilities);
		button_24.setBounds(230, 511, 93, 34);
		
		panel_10.add(button_24);
		splitPane_13.setDividerLocation(600);
		tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{overview, sales, purchases, inventories, assets, expenses, customers, suppliers, employees, liability, financialReports, settings}));
		tabbedPane.add("<html>Financial<br>Reports</Reports>", financialReports);
		financialReports.setLayout(null);
		splitPane_12.setBounds(0, 23, 939, 614);
		splitPane_12.setDividerSize(8);
		splitPane_12.setAutoscrolls(true);
		
		financialReports.add(splitPane_12);
		textArea_12.setLineWrap(true);
		
		splitPane_12.setLeftComponent(textArea_12);
		splitPane_12.setRightComponent(textArea_13);
		splitPane_12.setDividerLocation(450);
		btnNewButton_2.setBounds(363, 0, 87, 23);
		
		financialReports.add(btnNewButton_2);
		
		
		btnSubmit.setBounds(846, 0, 93, 23);
		financialReports.add(btnSubmit);
		
		financialReports.add(textField_33);
		textField_39.setColumns(10);
		textField_39.setBounds(758, 1, 78, 21);
		
		financialReports.add(textField_39);
		lblYear.setBounds(235, 4, 30, 15);
		
		financialReports.add(lblYear);
		label.setBounds(718, 4, 30, 15);
		
		financialReports.add(label);
		
		JLabel lblNewLabel = new JLabel("Income statement");
		lblNewLabel.setBounds(10, 4, 124, 15);
		financialReports.add(lblNewLabel);
		
		JLabel lblBalanceSheet = new JLabel("Balance sheet");
		lblBalanceSheet.setBounds(464, 4, 124, 15);
		financialReports.add(lblBalanceSheet);
		tabbedPane.add("Settings", settings);
		settings.setLayout(new BorderLayout(0, 0));
		
		settings.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(null);
		
		JLabel lblChangeUsernameAnd = new JLabel("Change username and password");
		lblChangeUsernameAnd.setForeground(Color.RED);
		lblChangeUsernameAnd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChangeUsernameAnd.setBounds(329, 53, 283, 86);
		panel_11.add(lblChangeUsernameAnd);
		lblNewLabel_1.setBounds(160, 197, 85, 15);
		
		panel_11.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(160, 288, 85, 15);
		
		panel_11.add(lblNewLabel_2);
		lblNewLabel_3.setBounds(500, 197, 85, 15);
		
		panel_11.add(lblNewLabel_3);
		lblNewLabel_4.setBounds(500, 288, 85, 15);
		
		panel_11.add(lblNewLabel_4);
		
		
		textField_1.setBounds(250, 189, 204, 31);
		panel_11.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_43.setColumns(10);
		textField_43.setBounds(250, 280, 204, 31);
		panel_11.add(textField_43);
		
		
		passwordField.setBounds(595, 189, 204, 31);
		panel_11.add(passwordField);
		
		
		passwordField_1.setBounds(595, 280, 204, 31);
		panel_11.add(passwordField_1);
		
		
		btnNewButton_3.setBounds(391, 362, 128, 55);
		panel_11.add(btnNewButton_3);
	}
	
	private void configTimeArea() {  
        Timer tmr = new Timer();  
        tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);  
    }  
  
    /** 
     * Timer task update time
     * online available at: http://blog.csdn.net/tianshuguang/article/details/7017462
     *  @author tianshuguang  
     *  @version 2011-11-27 
     */  
    protected class JLabelTimerTask extends TimerTask {  
        SimpleDateFormat dateFormatter = new SimpleDateFormat(  
                DEFAULT_TIME_FORMAT);  
  
        @Override  
        public void run() {  
            time = dateFormatter.format(Calendar.getInstance().getTime());  
            textPane.setText("Current time:" + "\n" + time);  
        }  
    }

//    public class OutData extends Thread{
//    	public void run(){
//    		for(int i=0;i<(2147483647);i++){
//    			try{	
//    				Client.setOverview();
//    				sleep(1000);
//    			}catch (Exception e){
//    			e.printStackTrace();
//    		}
//    	}
//    	}
//    }
    
	public static String getTextArea(){
		return textArea_1.getText(); 
	}
	public static String getTextArea_11(){
		return textArea_11.getText();
	}
		
	public static void addAddNoteListener(ActionListener addNoteListener) {
		btnAdd.addActionListener(addNoteListener);
	}
	
	public static void addAddSalesListener(ActionListener addSalesListener) {
		btnNewButton.addActionListener(addSalesListener);
	}
	
	public static void addSearchSaleListener(ActionListener searchSaleListener) {
		button_1.addActionListener(searchSaleListener);
	}
	
	public static void addSearchSalesListener(ActionListener searchSalesListener) {
		btnNewButton_1.addActionListener(searchSalesListener);
	}
	
	public static void addAddInventoryListener(ActionListener addInventoryListener) {
		button_2.addActionListener(addInventoryListener);
	}
	
	public static void addSearchInventoryListener(ActionListener searchInventoryListener) {
		button.addActionListener(searchInventoryListener);
	}
	
	public static void addSearchInventoriesListener(ActionListener searchInventoriesListener) {
		button_3.addActionListener(searchInventoriesListener);
	}
	
	public static void addAddAssetListener(ActionListener addAssetListener) {
		button_5.addActionListener(addAssetListener);
	}

	public static void addSearchAssetListener(ActionListener searchAssetListener) {
		button_4.addActionListener(searchAssetListener);
	}
	
	public static void addSearchAssetsListener(ActionListener searchAssetsListener) {
		button_6.addActionListener(searchAssetsListener);
	}
	
	public static void addAddPurchaseListener(ActionListener addPurchaseListener) {
		button_8.addActionListener(addPurchaseListener);
	}
	
	public static void addSearchPurchasesListener(ActionListener searchPurchasesListener) {
		button_7.addActionListener(searchPurchasesListener);
	}
	
	public static void addSearchAllPurchasesListener(ActionListener searchAllPurchasesListener) {
		button_9.addActionListener(searchAllPurchasesListener);
	}
	
	public static void addAddExpensesListener(ActionListener addExpensesListener) {
		button_11.addActionListener(addExpensesListener);
	}
	
	public static void addSearchExpensesListener(ActionListener searchExpensesListener) {
		button_10.addActionListener(searchExpensesListener);
	}
	
	public static void addSearchAllExpensesListener(ActionListener searchAllExpensesListener) {
		button_12.addActionListener(searchAllExpensesListener);
	}
	
	public static void addAddCustomerListener(ActionListener addCustomerListener) {
		button_14.addActionListener(addCustomerListener);
	}
	
	public static void addSearchCustomerListener(ActionListener searchCustomerListener) {
		button_13.addActionListener(searchCustomerListener);
	}
	
	public static void addSearchAllCustomersListener(ActionListener searchAllCustomersListener) {
		button_15.addActionListener(searchAllCustomersListener);
	}
	
	public static void addAddSupplierListener(ActionListener addSupplierListener) {
		button_17.addActionListener(addSupplierListener);
	}
	
	public static void addSearchSuppliersListener(ActionListener searchSuppliersListener) {
		button_16.addActionListener(searchSuppliersListener);
	}
	
	public static void addSearchAllSuppliersListener(ActionListener searchAllSuppliersListener) {
		button_18.addActionListener(searchAllSuppliersListener);
	}
	
	public static void addAddEmployeeListener(ActionListener addEmployeeListener) {
		button_20.addActionListener(addEmployeeListener);
	}
	
	public static void addSearchEmployeesListener(ActionListener searchEmployeesListener) {
		button_19.addActionListener(searchEmployeesListener);
	}
	
	public static void addSearchAllEmployeesListener(ActionListener searchAllEmployeesListener) {
		button_21.addActionListener(searchAllEmployeesListener);
	}
	
	public static void addAddLiabilityListener(ActionListener addLiabilityListener) {
		button_23.addActionListener(addLiabilityListener);
	}
	
	public static void addSearchLiabilityListener(ActionListener searchLiabilityListener) {
		button_22.addActionListener(searchLiabilityListener);
	}
	
	public static void addSearchAllLiabilitiesListener(ActionListener searchAllliabilitiessListener) {
		button_24.addActionListener(searchAllliabilitiessListener);
	}
	
	public static void addUpdateUserListener(ActionListener UpdateUserListener) {
		btnNewButton_3.addActionListener(UpdateUserListener);
	}
	public static void addDeleteUserListener(ActionListener deleteUserListener) {
		button_28.addActionListener(deleteUserListener);
	}
	
	public static void addIsListener(ActionListener isListener){
		btnNewButton_2.addActionListener(isListener);
	}
	
	public static void addFpListener(ActionListener fpListener){
		btnSubmit.addActionListener(fpListener);
	}
}
