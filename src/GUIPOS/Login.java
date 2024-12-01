package GUIPOS;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPassword;
	private JButton btnLogin,btnCancel;
	private JLabel lblSignUpHere;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login(   ) {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("McJollibee");
		frame.setBounds(100, 100, 465, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHead = new JLabel("Welcome To Mcjollibee");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblHead.setBounds(0, 11, 449, 48);
		frame.getContentPane().add(lblHead);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 70, 429, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblUser = new JLabel("Enter ID:");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(71, 78, 117, 14);
		frame.getContentPane().add(lblUser);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(71, 103, 295, 31);
		frame.getContentPane().add(txtId);
		
		JLabel lblPass = new JLabel("Enter password:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(71, 145, 117, 18);
		frame.getContentPane().add(lblPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(71, 174, 295, 31);
		frame.getContentPane().add(txtPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 429, 2);
		frame.getContentPane().add(separator);
		
		 btnCancel = new JButton("CANCEL");
		
		
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(241, 230, 125, 37);
		frame.getContentPane().add(btnCancel);
		
		 btnLogin = new JButton("LOGIN");
	
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(71, 230, 125, 37);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Don't have account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(81, 282, 148, 18);
		frame.getContentPane().add(lblNewLabel);
		
		 lblSignUpHere = new JLabel("Sign Up Here");
		
		lblSignUpHere.setForeground(Color.RED);
		lblSignUpHere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSignUpHere.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignUpHere.setBounds(241, 282, 103, 18);
		frame.getContentPane().add(lblSignUpHere);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(10, 11, 2, 299);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(437, 11, 2, 299);
		frame.getContentPane().add(separator_2_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 311, 429, 2);
		frame.getContentPane().add(separator_1_1);
		
		login();
		gotoRegister();
		Cancel();
		
	}
	public void login() {
		 btnLogin.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		try {
			 			int id = Integer.valueOf(txtId.getText());
		 			String Password = txtPassword.getText();
		 			
		 			if (id<=0) {
		 				errorMessage("Invalid ID!","Error!");
		 				clearFields();
		 				return;
		 			}
		 			if (Password.equals("")) {
		 				errorMessage("Please enter your password!","Error");
		 				return;
		 			}
		 			
		 			verifyAcc();
		 			clearFields();
		 			return;		 			
			 		}
			 		catch(Exception err) {
			 			errorMessage("Please enter your ID!","Error!");	
			 		}
			 	}
			 });
	}
	
	public void verifyAcc() {
		try {
			boolean matched = false;
			String record;
			int id = Integer.valueOf(txtId.getText());
			String password = txtPassword.getText();
			FileReader fr = new FileReader("accountrecord.txt");
			BufferedReader br = new BufferedReader(fr);
			
			
			while((record=br.readLine())!=null) {
				if(record.contains(id+","+password)) {
					matched = true;
					break;
				}
			}
			br.close();
			if(matched) {
				successMessage("Log In Successfully!","Success!");
				MainMenu mainmenu = new MainMenu();
				mainmenu.main(null);
				frame.setVisible(false);
				
			}
			if (!matched) {
			errorMessage("Account does not exist!","Error!");
		}
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,"login failed");
		}
	}
		public void gotoRegister() {
		lblSignUpHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register create = new Register();
				create.main(null);
				frame.setVisible(false);
			}
		});
	}
	public void Cancel(){
		 btnCancel.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		System.exit(0);
			 	}
			 });
	}
	public void clearFields() {
		txtId.setText("");
		txtPassword.setText("");
	}
	public static void successMessage(String info, String status) {
		JOptionPane.showMessageDialog(null, info, status, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void errorMessage(String error, String status) {
			
		JOptionPane.showMessageDialog(null, error, status, JOptionPane.ERROR_MESSAGE);
	
	}	
}
