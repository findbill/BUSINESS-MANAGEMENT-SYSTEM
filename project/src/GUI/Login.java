package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Client;
import database.Database;


import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField passwordField;
	private JButton btnNewButton = new JButton("Log in");
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(69, 172, 186, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		
		btnNewButton.setBounds(296, 173, 117, 65);
		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 210, 186, 28);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(5, 178, 60, 15);
		panel.add(lblNewLabel);
		
		JLabel lblPassowrd = new JLabel("Passowrd");
		lblPassowrd.setBounds(5, 216, 60, 15);
		panel.add(lblPassowrd);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/login.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 162);
		panel.add(lblNewLabel_1);
	}
	
	public String getUsername(){
		return textField.getText();
	}
	
	public String getPassword(){
		return passwordField.getText();
	}

	public void addLoginListener(ActionListener loginListener) {
		btnNewButton.addActionListener(loginListener);
	}

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(btnNewButton, errorMessage);
	}
}