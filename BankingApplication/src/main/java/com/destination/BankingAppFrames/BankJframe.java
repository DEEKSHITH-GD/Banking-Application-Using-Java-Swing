package com.destination.BankingAppFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.destination.BankingApplication.BankingApplication;
import com.destination.BankingApplication.GetDetails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class BankJframe extends JFrame {

	JButton CheckBalanceButton;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public BankJframe() {
		GetDetails.getDetails();
		setTitle("BANK APPLICATION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 30, 957, 45);
		contentPane.add(panel);
		
		JLabel TitleLabel = new JLabel("Welcome to the Bank!"); //heading for the panel
		TitleLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(TitleLabel);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(253, 245, 230));
		panel_1.setBounds(23, 153, 202, 39);
		contentPane.add(panel_1);
		
		JLabel lblMoneyTransfer = new JLabel("Money Transfer"); //Label of money transfer panel
		lblMoneyTransfer.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1.add(lblMoneyTransfer);
		
		Panel panel_MT = new Panel();
		panel_MT.setBackground(new Color(253, 245, 230));
		panel_MT.setBounds(23, 200, 202, 147);
		contentPane.add(panel_MT);
		panel_MT.setLayout(null);
		
		JButton MoneyTransferButton = new JButton("Send Money"); //button creation for money transfer function
		MoneyTransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferMoneyJframe frame = new TransferMoneyJframe();
				frame.setVisible(true);
			}
		});
		MoneyTransferButton.setForeground(new Color(0, 0, 0));
		MoneyTransferButton.setBackground(new Color(255, 250, 240));
		MoneyTransferButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		MoneyTransferButton.setBounds(10, 48, 182, 53);
		panel_MT.add(MoneyTransferButton);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(new Color(224, 255, 255));
		panel_1_2.setBounds(258, 153, 210, 39);
		contentPane.add(panel_1_2);
		
		JLabel lblGetStatement = new JLabel("Get Statement"); //label for get statement panel
		lblGetStatement.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1_2.add(lblGetStatement);
		
		Panel panel_GS = new Panel();
		panel_GS.setBackground(new Color(224, 255, 255));
		panel_GS.setBounds(258, 200, 210, 147);
		contentPane.add(panel_GS);
		panel_GS.setLayout(null);
		
		JButton GetStatementButton = new JButton("Get Statement"); //button creation for get statement
		GetStatementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStatementJframe frame = new GetStatementJframe();
				frame.setVisible(true);
			}
		});
		GetStatementButton.setBackground(new Color(240, 255, 240));
		GetStatementButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GetStatementButton.setBounds(18, 48, 182, 53);
		panel_GS.add(GetStatementButton);
		
		Panel panel_1_2_1 = new Panel();
		panel_1_2_1.setBackground(new Color(255, 240, 245));
		panel_1_2_1.setBounds(501, 153, 202, 39);
		contentPane.add(panel_1_2_1);
		
		JLabel lblChangePassword = new JLabel("Change Password");  //label for change password panel
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1_2_1.add(lblChangePassword);
		
		Panel panel_CP = new Panel();
		panel_CP.setBackground(new Color(255, 240, 245));
		panel_CP.setBounds(501, 200, 202, 147);
		contentPane.add(panel_CP);
		panel_CP.setLayout(null);
		
		JButton ChangePwdButton = new JButton("Change Password"); //button for change password
		ChangePwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordJframe frame = new ChangePasswordJframe();
				frame.setVisible(true);
			}
		});
		ChangePwdButton.setBackground(new Color(255, 240, 245));
		ChangePwdButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		ChangePwdButton.setBounds(10, 48, 182, 53);
		panel_CP.add(ChangePwdButton);
		
		Panel panel_1_2_1_1 = new Panel();
		panel_1_2_1_1.setBackground(new Color(240, 248, 255));
		panel_1_2_1_1.setBounds(734, 153, 202, 39);
		contentPane.add(panel_1_2_1_1);
		
		JLabel BalanceLabel = new JLabel("Check Balance"); //label for check balance
		BalanceLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1_2_1_1.add(BalanceLabel);
		
		Panel panel_CP_1 = new Panel();
		panel_CP_1.setLayout(null);
		panel_CP_1.setBackground(new Color(240, 248, 255));
		panel_CP_1.setBounds(734, 200, 202, 147);
		contentPane.add(panel_CP_1);
		
		CheckBalanceButton = new JButton("Check Balance"); // button for check balance function
		CheckBalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetDetails.getDetails();
				JOptionPane.showMessageDialog(CheckBalanceButton, "Account Balance :"+BankingApplication.getBalance());
			}
		});
		CheckBalanceButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		CheckBalanceButton.setBackground(new Color(240, 248, 255));
		CheckBalanceButton.setBounds(10, 48, 182, 53);
		panel_CP_1.add(CheckBalanceButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(117, 92, 706, 39);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel CustomerNameLabel = new JLabel("Account Holder Name : "+BankingApplication.getCustomerName()); // label for Account Holder Name 
		CustomerNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CustomerNameLabel.setBounds(10, 11, 291, 17);
		panel_2.add(CustomerNameLabel);
		
		JLabel ACNoLabel = new JLabel("Account Number : "+BankingApplication.getAccountNo()); // label for Account Number of user 
		ACNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ACNoLabel.setBounds(362, 11, 291, 17);
		panel_2.add(ACNoLabel);
		
		JLabel CustomerIDLabel = new JLabel("Customer ID : "+BankingApplication.getCustomerId()); // label to display customer ID 
		CustomerIDLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		CustomerIDLabel.setBounds(10, 403, 160, 20);
		contentPane.add(CustomerIDLabel);
		
		JButton LogoutButton = new JButton("Logout"); //button creation for logout
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankingApplication.setCustomerId(null);
				BankingApplication.setCustomerPassword(null);
				dispose();
			}
		});
		LogoutButton.setBackground(new Color(240, 255, 240));
		LogoutButton.setForeground(new Color(0, 0, 128));
		LogoutButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		LogoutButton.setBounds(820, 386, 116, 37);
		contentPane.add(LogoutButton);
	}
}
