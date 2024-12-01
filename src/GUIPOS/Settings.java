package GUIPOS;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.*;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings {

	private JFrame frame;
	private JTextField txtAge;
	private JPasswordField txtPassword;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JButton btnUpdate;
	private ArrayList<String> arrlist = new ArrayList<String>();
	private JTextField txtId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings(  ) {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("McJollibee");
		frame.setBounds(100, 100, 465, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("EDIT ACCOUNT");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCreateAccount.setBounds(0, 11, 449, 48);
		frame.getContentPane().add(lblCreateAccount);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 70, 429, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblUser = new JLabel("Enter Age:");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(71, 300, 135, 20);
		frame.getContentPane().add(lblUser);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBounds(71, 325, 295, 31);
		frame.getContentPane().add(txtAge);
		
		JLabel lblPass = new JLabel("Enter Password:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(71, 367, 117, 18);
		frame.getContentPane().add(lblPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(71, 396, 295, 31);
		frame.getContentPane().add(txtPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 429, 2);
		frame.getContentPane().add(separator);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAll viewall = new ViewAll();
				viewall.main(null);
				frame.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(241, 464, 125, 37);
		frame.getContentPane().add(btnCancel);
		
		 btnUpdate = new JButton("UPDATE");
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(71, 464, 125, 37);
		frame.getContentPane().add(btnUpdate);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(10, 11, 2, 514);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(437, 11, 2, 514);
		frame.getContentPane().add(separator_2_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 523, 429, 2);
		frame.getContentPane().add(separator_1_1);
		
		JLabel lblEnterFirstName = new JLabel("Enter First Name:");
		lblEnterFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterFirstName.setBounds(71, 162, 135, 14);
		frame.getContentPane().add(lblEnterFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(71, 187, 295, 31);
		frame.getContentPane().add(txtFirstName);
		
		JLabel lblEnterLastName = new JLabel("Enter Last Name:");
		lblEnterLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterLastName.setBounds(71, 229, 135, 18);
		frame.getContentPane().add(lblEnterLastName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		txtLastName.setBounds(71, 258, 295, 31);
		frame.getContentPane().add(txtLastName);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(71, 120, 295, 31);
		frame.getContentPane().add(txtId);
		
		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterId.setBounds(71, 95, 135, 14);
		frame.getContentPane().add(lblEnterId);
		
	
		update();
		
	}
	
	public void update() {
		 btnUpdate.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		try {
			 			String id = txtId.getText();
				 		String firstname = txtFirstName.getText().toString();
						String lastname = txtLastName.getText().toString();
						String username = txtAge.getText().toString();
						int age = Integer.valueOf(txtAge.getText());
						String password = txtPassword.getText().toString();
						
						if (age<=0) {
			 				errorMessage("Invalid Age!","Error!");
			 				return;
			 			}
			 			
						File tempDB = new File("accountrecord_temp.txt");
						File db = new File("accountrecord.txt");
						BufferedReader br = new BufferedReader(new FileReader(db));
					BufferedWriter fw = new BufferedWriter(new FileWriter(tempDB));
						//FileWriter fw = new FileWriter(tempDB,true);
						
						String record;
						
						while((record=br.readLine())!=null) {
							if(record.contains(id)){
								clearFields();
								successMessage("Account Updated Successfully!","Success!");
								fw.write(id+","+firstname+","+lastname+","+age+","+password);
								Inventory inventory = new Inventory();
								inventory.main(null);
								frame.setVisible(false);
							}
							
							else {
								fw.write(record);
								errorMessage("Wrong ID!","Error!");
								clearFields();
							}
							fw.flush();
							fw.newLine();
							
						}
						
						br.close();
						fw.close();
						db.delete();
						tempDB.renameTo(db);
						
			
					}
					catch(Exception err) {
						errorMessage("Please complete Fields!","Error!");
					}
			 	}
			 });
		
		
	}
	public void clearFields() {
		txtAge.setText(null);
		txtId.setText("");
		txtPassword.setText("");
		txtFirstName.setText(null);
		txtLastName.setText(null);
	}
	public static void errorMessage(String error, String status) {
		
		JOptionPane.showMessageDialog(null, error, status, JOptionPane.ERROR_MESSAGE);
		
	}
	public static void successMessage(String info, String status) {
		JOptionPane.showMessageDialog(null, info, status, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
