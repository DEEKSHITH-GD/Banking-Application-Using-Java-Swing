package com.destination.BankingAppFrames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.destination.BankingApplication.Admin;
import com.destination.BankingApplication.BankingApplication;

public class AdminLogin extends JFrame implements ActionListener  {
	//initialize button, panel, label, and text field  
	JButton button;  
	JPanel AdminPanel;  
	JLabel admin_idLabel, admin_pwdLabel;  
	final JTextField  textField1, textField2;

	public AdminLogin() {
		//create label for admin_id   
		admin_idLabel = new JLabel();  
		admin_idLabel.setText("Admin ID");      //set label value for textField1  

		//create text field to get admin_id from the user  
		textField1 = new JTextField(20);    //set length of the text

		//create label for admin_pwd   
		admin_pwdLabel = new JLabel();  
		admin_pwdLabel.setText("Admin Password");      //set label value for textField2  

		//create text field to get admin_pwd from the user  
		textField2 = new JPasswordField(10);    //set length of the password

		//create submit button  
		button = new JButton("Login"); //set label to button 

		//create panel to put form elements  
		AdminPanel = new JPanel(new GridLayout(5, 1));  
		AdminPanel.add(admin_idLabel);    //set admin_id label to panel  
		AdminPanel.add(textField1);   //set text field to panel
		AdminPanel.add(admin_pwdLabel);    //set admin_pwd label to panel  
		AdminPanel.add(textField2);   //set text field to panel
		AdminPanel.add(button);           //set button to panel

		//set border to panel   
		add(AdminPanel, BorderLayout.CENTER);  

		//perform action on button click   
		button.addActionListener(this);     //add action listener to button  
		setTitle("ADMIN LOGIN FORM");         //set title to the login form 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Admin.setAdmin_id(textField1.getText());
		Admin.setAdmin_pwd(textField2.getText());
		Admin a = new Admin();
		boolean ba = a.validate();
		//check whether the credentials are authentic or not  
		if (ba == true) {  //if true, navigate admin to a new page  
			JOptionPane.showMessageDialog(button, "Login Successful: "+Admin.admin_id);
			ActivateCustomer frame = new ActivateCustomer(); //Launches the customer activation/deactivation  windows
			frame.setVisible(true);
			dispose();
		}  
		else{  
			JOptionPane.showMessageDialog(button, "Login Failed: Invalid Credentials");
		}  
	}

}