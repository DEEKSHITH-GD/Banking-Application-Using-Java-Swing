package com.destination.BankingAppFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.destination.BankingApplication.BankingApplication;
import com.destination.BankingApplication.Connector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ChangePasswordJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	JButton SubmitButton;
	/**
	 * Create the frame.
	 */
	public ChangePasswordJframe() {
		setTitle("CHANGE PASSWORD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel NewPasswdLabel = new JLabel("New Password"); //label for new password 
		NewPasswdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		NewPasswdLabel.setBounds(55, 64, 111, 28);
		contentPane.add(NewPasswdLabel);

		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblConfirmNewPassword.setBounds(55, 103, 147, 28);
		contentPane.add(lblConfirmNewPassword);

		textField1 = new JTextField(null); //input field for new password
		textField1.setBounds(202, 64, 168, 28);
		contentPane.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField(null); //input field for confirm password
		textField2.setColumns(10);
		textField2.setBounds(202, 104, 168, 28);
		contentPane.add(textField2);

		SubmitButton = new JButton("Submit"); //submit button creation
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Condition to compare two strings of entered password
				if(textField1.getText().equals(textField2.getText())) {
					try {
						//Query to update password
						PreparedStatement pst = Connector.Connector().prepareStatement("Update customers set customerPassword=? where customerId=?");
						pst.setString(1, textField2.getText()); 
						pst.setString(2, BankingApplication.getCustomerId());
						byte x = (byte) pst.executeUpdate();
						if(x>0) {
							JOptionPane.showMessageDialog(SubmitButton, "Password Updated");
						}else {
							JOptionPane.showMessageDialog(SubmitButton, "Failed to change password. Try Again!");
						}
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(SubmitButton, "Password Field cannot be empty");
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(SubmitButton, "Reconfirm your new password!");
				}
			}
		});
		SubmitButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		SubmitButton.setBounds(145, 169, 131, 36);
		contentPane.add(SubmitButton);
	}
}
