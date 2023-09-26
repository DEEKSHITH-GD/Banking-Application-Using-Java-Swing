package com.destination.BankingAppFrames;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.destination.BankingApplication.BankingApplication;
import com.destination.BankingApplication.Connector;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class ActivateCustomer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private String status;
	JButton btnActivate;
	JButton btnDeactivate;
	/**
	 * Create the frame.
	 */
	public ActivateCustomer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes the current window
		setBounds(100, 100, 732, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 694, 287);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Customer ID", "Customer Name", "Account No", "Customer Password", "Balance", "Bank Name", "IFSC Code", "E-mail", "Status" //column names of table
				}
				){

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setModel(model);
		model = (DefaultTableModel) table.getModel();
		model.fireTableDataChanged();
		getTable();
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Registered Customers"); //heading for panel
		lblNewJgoodiesTitle.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewJgoodiesTitle.setLabelFor(contentPane);
		lblNewJgoodiesTitle.setBounds(281, 11, 166, 34);
		contentPane.add(lblNewJgoodiesTitle);

		btnActivate = new JButton("Activate");  //activate button
		btnActivate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnActivate.setBounds(170, 354, 122, 35);
		contentPane.add(btnActivate);

		btnDeactivate = new JButton("Deactivate"); //deactivate button
		btnDeactivate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeactivate.setBounds(390, 354, 122, 35);
		contentPane.add(btnDeactivate);

		//activate button  function
		btnActivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aae) {
				int index = table.getSelectedRow();
				Object ValueOfCell = model.getValueAt(index, 0);
				try {
					PreparedStatement pst = Connector.Connector().prepareStatement("Update customers set status = \"active\" where customerId=? and status =\"inactive\"");
					pst.setString(1, (String) ValueOfCell);
					int result = pst.executeUpdate();
					if(result > 0) {
						JOptionPane.showMessageDialog(btnActivate, ValueOfCell+" is Activated");
						//System.out.println(ValueOfCell);
					}
					getTable();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//deactivate button  function 
		btnDeactivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aae) {
				int index = table.getSelectedRow();
				Object ValueOfCell = model.getValueAt(index, 0);
				//System.out.println(ValueOfCell);
				try {
					PreparedStatement pst = Connector.Connector().prepareStatement("Update customers set status = \"inactive\" where customerId=? and status =\"active\"");
					pst.setString(1, (String) ValueOfCell);
					int result = pst.executeUpdate();
					if(result > 0) {
						JOptionPane.showMessageDialog(btnDeactivate, ValueOfCell+" is Deactivated");
						//System.out.println(ValueOfCell);

					}
					getTable();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	//function to fetch data of the customers table and also refresh each time data is loaded
	public void getTable() {
		model.setRowCount(0); //for refreshing table
		try {
			Statement stmt = Connector.Connector().createStatement();
			ResultSet rs = stmt.executeQuery("Select * from customers");
			while (rs.next()) {
				BankingApplication.setCustomerId(rs.getString(1));
				BankingApplication.setCustomerName(rs.getString(2));
				BankingApplication.setAccountNo(rs.getInt(3));
				BankingApplication.setCustomerPassword(rs.getString(4));
				BankingApplication.setBalance(rs.getInt(5));
				BankingApplication.setBankName(rs.getString(6));
				BankingApplication.setIfscCode(rs.getString(7));
				BankingApplication.setEmail(rs.getString(8));
				status = rs.getString(9);
				String[] rows = {BankingApplication.getCustomerId(), BankingApplication.getCustomerName(), Integer.toString(BankingApplication.getAccountNo()), 
						BankingApplication.getCustomerPassword(), Integer.toString(BankingApplication.getBalance()), BankingApplication.getBankName(),
						BankingApplication.getIfscCode(), BankingApplication.getEmail(), status};
				model.addRow(rows);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("ADMIN CONTROL PANEL");
	}
}
