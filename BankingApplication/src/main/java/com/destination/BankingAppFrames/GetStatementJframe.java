package com.destination.BankingAppFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.destination.BankingApplication.BankingApplication;
import com.destination.BankingApplication.Connector;

import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetStatementJframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	PreparedStatement pst;
	ResultSet rs;
	int senderAccountNo;
	int recipientAccountNo;
	String timeStamp;
	int amount;
	DefaultTableModel model1;
	Choice choice;
	/**
	 * Create the frame.
	 */
	public GetStatementJframe() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("BANK STATEMENTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 754, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 48, 686, 231);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model1 = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Sender Account No", "Recipient Account No", "Time of Transaction", "Amount" //column names of statement table
				}
				) 
		{
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model1);
		
		choice = new Choice(); //Choice menu creation
		choice.setBounds(70, 10, 105, 20);
		//menu list names
		choice.add("Last 24 hours");
		choice.add("Last 7 days");
		choice.add("Last 30 days");
		contentPane.add(choice);
		
		JLabel FilterLabel = new JLabel("Filter");
		FilterLabel.setBounds(36, 10, 39, 20);
		contentPane.add(FilterLabel);
		
		JButton ApplyButton = new JButton("Apply");
		ApplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice.getSelectedItem()=="Last 24 hours") {
					try {
						model1.setRowCount(0); //to refresh the column with new data and avoid insertion of new rows under existing rows
						//MySQL query to fetch data of present day for respective accountNo
						pst = Connector.Connector().prepareStatement("SELECT * FROM statements where (transcation_time BETWEEN NOW() - INTERVAL 24 HOUR AND NOW()) and (sender_accountNo=? or recipient_accountNo=?)");
						//Taking user accountNo for both sender and recipient to fetch data of user in either of the columns
						pst.setInt(1, BankingApplication.getAccountNo());
						pst.setInt(2, BankingApplication.getAccountNo());
						rs = pst.executeQuery();
						while (rs.next()) {
							senderAccountNo = rs.getInt(1);
							recipientAccountNo = rs.getInt(2);
							timeStamp = rs.getString(3);
							amount = rs.getInt(4);
							String[] rows = {Integer.toString(senderAccountNo), Integer.toString(recipientAccountNo), timeStamp, Integer.toString(amount)};
							model1.addRow(rows);
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else if(choice.getSelectedItem()=="Last 7 days") {
					try {
						model1.setRowCount(0); //to refresh the column with new data and avoid insertion of new rows under existing rows
						//MySQL query to fetch data of last 7 days for respective accountNo
						pst = Connector.Connector().prepareStatement("SELECT * FROM statements where (transcation_time BETWEEN NOW() - INTERVAL 7 DAY AND NOW()) and (sender_accountNo=? or recipient_accountNo=?)");
						//Taking user accountNo for both sender and recipient to fetch data of user in either of the columns
						pst.setInt(1, BankingApplication.getAccountNo());
						pst.setInt(2, BankingApplication.getAccountNo());
						rs = pst.executeQuery();
						while (rs.next()) {
							senderAccountNo = rs.getInt(1);
							recipientAccountNo = rs.getInt(2);
							timeStamp = rs.getString(3);
							amount = rs.getInt(4);
							String[] rows = {Integer.toString(senderAccountNo), Integer.toString(recipientAccountNo), timeStamp, Integer.toString(amount)};
							model1.addRow(rows);
						}
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}else {
					try {
						model1.setRowCount(0); //to refresh the column with new data and avoid insertion of new rows under existing rows
						//MySQL query to fetch data of last 30 days for respective accountNo 
						pst = Connector.Connector().prepareStatement("SELECT * FROM statements where (transcation_time BETWEEN NOW() - INTERVAL 30 DAY AND NOW()) and (sender_accountNo=? or recipient_accountNo=?)");
						//Taking user accountNo for both sender and recipient to fetch data of user in either of the columns
						pst.setInt(1, BankingApplication.getAccountNo());
						pst.setInt(2, BankingApplication.getAccountNo());
						rs = pst.executeQuery();
						while (rs.next()) {
							senderAccountNo = rs.getInt(1);
							recipientAccountNo = rs.getInt(2);
							timeStamp = rs.getString(3);
							amount = rs.getInt(4);
							String[] rows = {Integer.toString(senderAccountNo), Integer.toString(recipientAccountNo), timeStamp, Integer.toString(amount)};
							model1.addRow(rows);
						}
					}
					catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		ApplyButton.setBounds(183, 10, 89, 23);
		contentPane.add(ApplyButton);
		try {
			//MySQL query to fetch all statement data for respective accountNo
			pst = Connector.Connector().prepareStatement("Select * from statements where sender_accountNo=? or recipient_accountNo=?");
			//Taking user accountNo for both sender and recipient to fetch data of user in either of the columns
			pst.setInt(1, BankingApplication.getAccountNo());
			pst.setInt(2, BankingApplication.getAccountNo());
			rs = pst.executeQuery();
			
			while (rs.next()) {
				senderAccountNo = rs.getInt(1);
				recipientAccountNo = rs.getInt(2);
				timeStamp = rs.getString(3);
				amount = rs.getInt(4);
				String[] rows = {Integer.toString(senderAccountNo), Integer.toString(recipientAccountNo), timeStamp, Integer.toString(amount)};
				model1.addRow(rows);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
