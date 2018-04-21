package GUI;

import javax.swing.JFrame;

import client.Client;
import database.Database;

public class ProjectStart {

	public static void main(String[] args){
		Login theLoginView = new Login();
		Database theModel = new Database();
//		Homepage theHomepageView = new Homepage();
		new Client(theLoginView, theModel);
		
		
		theLoginView.setVisible(true);
		theLoginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		theHomepageView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
