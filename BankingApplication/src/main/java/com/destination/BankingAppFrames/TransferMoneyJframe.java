package com.destination.BankingAppFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.destination.BankingApplication.BankingApplication;
import com.destination.BankingApplication.Connector;
import com.destination.BankingApplication.RecordStatements;
import com.destination.BankingApplication.Transfer;

public class TransferMoneyJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	JButton SubmitButton;
	/**
	 * Create the frame.
	 */
	public TransferMoneyJframe() {
		setTitle("TRANSFER MONEY");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //to close current window
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AmountLabel = new JLabel("Transfer Amount : "); //label for transfer amount
		AmountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		AmountLabel.setBounds(54, 51, 111, 26);
		contentPane.add(AmountLabel);
		
		textField1 = new JTextField(); //input field for Transfer Amount
		textField1.setBounds(200, 52, 126, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel RecepientLabel = new JLabel("Recipient Account No :"); //label for Recipient Account No
		RecepientLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		RecepientLabel.setBounds(54, 88, 136, 26);
		contentPane.add(RecepientLabel);
		
		textField2 = new JTextField(); //input field for Recipient Account No
		textField2.setColumns(10);
		textField2.setBounds(200, 88, 126, 26);
		contentPane.add(textField2);
		
		JLabel RecepientIFSCLabel = new JLabel("Recipient IFSC Code :"); //Recipient IFSC Code
		RecepientIFSCLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		RecepientIFSCLabel.setBounds(54, 125, 136, 26);
		contentPane.add(RecepientIFSCLabel);
		
		textField3 = new JTextField();  //input field for Recipient IFSC Code
		textField3.setColumns(10);
		textField3.setBounds(200, 125, 126, 26);
		contentPane.add(textField3);
		
		SubmitButton = new JButton("Submit"); //button to submit
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankingApplication.setTransferAmount(Integer.parseInt(textField1.getText()));
				BankingApplication.setRecipientAccountNo(Integer.parseInt(textField2.getText()));
				BankingApplication.setRecipientIfscCode(textField3.getText());
				try {
					//Query to check the balance of sender
					PreparedStatement pst = Connector.Connector().prepareStatement("Select balance from customers where accountNo=? and status=\"active\"");
					pst.setString(1, textField2.getText());
					ResultSet resultSet = pst.executeQuery();
					if(resultSet.next()==true) {
						BankingApplication.setRecipientBalance(resultSet.getInt(1));
						//calling Transfer constructor
						Transfer t = new Transfer();
						byte bt = t.validate();
						if(bt==1) {
							JOptionPane.showMessageDialog(SubmitButton, "Transaction Successfull: "+BankingApplication.getTransferAmount()+" is transferred to A/c no: "+BankingApplication.getRecipientAccountNo());
							RecordStatements.statements();
						}
						else if(bt==2){
							JOptionPane.showMessageDialog(SubmitButton, "Transaction Failed: Incorrect Recipient IFSC code");
						}else {
							JOptionPane.showMessageDialog(SubmitButton, "Transaction Failed: Insufficient balance");
						}
					}else {
						JOptionPane.showMessageDialog(SubmitButton, "Transaction Failed: Incorrect Recipient Account Number or Account is inactive!");
					}
				}
				catch (Exception e1) {
					System.out.println("in transfer frame");
					e1.printStackTrace();
				}
			}
		});
		SubmitButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		SubmitButton.setBounds(152, 178, 126, 34);
		contentPane.add(SubmitButton);
	}
}
