package com.destination.BankingApplication;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.destination.BankingAppFrames.AdminLogin;
import com.destination.BankingAppFrames.RegisterJFrame;
import com.destination.BankingAppFrames.UserLoginJFrame;

public class Main {
	public static void main(String[] args) {
		//menu
		System.out.println("\t\t\tWelcome to the Banking Application");
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Register\n"
				+ "2. User Login\n"
				+ "3. Admin Login\n"
				+ "4. Quit\n");
		System.out.println("Please enter your choice");
		int choice = scan.nextInt();
		switch (choice) {
		case 1: {//Register module
			try  
			{  
				//create instance of the RegisterJFrame  
				RegisterJFrame form = new RegisterJFrame();  
				form.setSize(300,600);  //set size of the frame  
				form.setVisible(true);  //make form visible to the user  
			}  
			catch(Exception e)  
			{   
				System.out.println("in main case 1");
				//handle exception   
				JOptionPane.showMessageDialog(null, e.getMessage());  
			} 
		}
		break;
		case 2: {//access to user module
			UserLoginJFrame frame = new UserLoginJFrame();
			frame.setVisible(true);
			break;
		}
		case 3: {//access to admin module
			/*Admin a = new Admin();
			System.out.println("\n\t\tAdmin Login");
			System.out.println("Enter the Admin ID: ");
			a.setAdmin_id(scan.next());
			System.out.println("Enter the Admin Password: ");
			a.setAdmin_pwd(scan.next());

			boolean b = a.validate();
			if(b==true) {
				System.out.println("Admin Login Successful");
			}else {
				System.out.println("Admin Login Failed");
			}*/
			try  
			{  
				//create instance of the RegisterJFrame  
				AdminLogin AdminForm = new AdminLogin();  
				AdminForm.setSize(300,200);  //set size of the frame  
				AdminForm.setVisible(true);  //make form visible to the user
			}  
			catch(Exception e)  
			{     
				System.out.println("in main case 3");
				//handle exception   
				JOptionPane.showMessageDialog(null, e.getMessage());  
			} 
		}
		break;
		case 4: {//exit the program
			System.exit(0);

		}
		default:
			System.out.println("Invalid input");
		}
	}

}

