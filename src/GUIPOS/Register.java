package GUIPOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;


public class Register {

	private JFrame frame;
	private JTextField txtAge;
	private JPasswordField txtPassword;
	private JLabel lblGoBackLogin,lblAcceptTerms;
	private JButton btnCancel,btnCreate;
	private JCheckBox cbTerms;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register( ) {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("McJollibee");
		frame.setBounds(100, 100, 465, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("CREATE ACCOUNT");
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
		lblUser.setBounds(71, 303, 135, 23);
		frame.getContentPane().add(lblUser);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBounds(71, 328, 295, 31);
		frame.getContentPane().add(txtAge);
		
		JLabel lblPass = new JLabel("Enter Password:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(71, 370, 117, 18);
		frame.getContentPane().add(lblPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(71, 399, 295, 31);
		frame.getContentPane().add(txtPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 429, 2);
		frame.getContentPane().add(separator);
		
		 btnCancel = new JButton("CANCEL");
		
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(241, 467, 125, 37);
		frame.getContentPane().add(btnCancel);
		
		 btnCreate = new JButton("CREATE");
		 
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreate.setBounds(71, 467, 125, 37);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblAlreadyHaveAccount = new JLabel("Already have account?");
		lblAlreadyHaveAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlreadyHaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlreadyHaveAccount.setBounds(81, 525, 148, 18);
		frame.getContentPane().add(lblAlreadyHaveAccount);
		
		 lblGoBackLogin = new JLabel("Go Back Login");

		lblGoBackLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblGoBackLogin.setForeground(Color.RED);
		lblGoBackLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGoBackLogin.setBounds(241, 525, 103, 18);
		frame.getContentPane().add(lblGoBackLogin);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(10, 11, 2, 559);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(437, 11, 2, 559);
		frame.getContentPane().add(separator_2_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 568, 429, 2);
		frame.getContentPane().add(separator_1_1);
		
		 cbTerms = new JCheckBox("Accept");
		 cbTerms.setHorizontalAlignment(SwingConstants.LEFT);
		cbTerms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTerms.setBounds(71, 437, 69, 23);
		frame.getContentPane().add(cbTerms);
		
		 lblAcceptTerms = new JLabel("Terms & Conditions");
		
		lblAcceptTerms.setForeground(SystemColor.textHighlight);
		lblAcceptTerms.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcceptTerms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAcceptTerms.setBounds(140, 439, 222, 18);
		frame.getContentPane().add(lblAcceptTerms);
		
		JLabel lblEnterFirstName = new JLabel("Enter First Name:");
		lblEnterFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterFirstName.setBounds(71, 165, 135, 14);
		frame.getContentPane().add(lblEnterFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(71, 190, 295, 31);
		frame.getContentPane().add(txtFirstName);
		
		JLabel lblEnterLastName = new JLabel("Enter Last Name:");
		lblEnterLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterLastName.setBounds(71, 232, 135, 18);
		frame.getContentPane().add(lblEnterLastName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		txtLastName.setBounds(71, 261, 295, 31);
		frame.getContentPane().add(txtLastName);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(71, 123, 295, 31);
		frame.getContentPane().add(txtId);
		
		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterId.setBounds(71, 98, 135, 14);
		frame.getContentPane().add(lblEnterId);
	
		
		
		actions();
		gobackLogin();
		TermsConditions();
		Cancel();
		
	}
	public void actions() {
		btnCreate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
				try {
					String id = (txtId.getText());
			 		String firstname = txtFirstName.getText();
					String lastname = txtLastName.getText();
					Integer age = Integer.valueOf(txtAge.getText());
					String password = txtPassword.getText();
					
					if (age<=0) {
		 				errorMessage("Invalid Age!","Error!");
		 				return;
		 			}
					boolean isExist = searchEmpId(id);
		 			if(isExist) {
		 				errorMessage("ID: "+id+" already exists!","Error!");
		 				clearFields();
		 				return;
		 			}
		 			boolean isChecked = cbTerms.isSelected();
		 			if(!isChecked) {
		 				errorMessage("Please read terms and conditions before accepting it!","Error");
		 				return;
		 			}
		 			addRecord(id,firstname,lastname,age,password);
		 			clearFields();
		 			return;
			 		}
			 		catch(Exception err) {
			 			errorMessage("Please complete Fields!","Error!");
			 		}
				}
		 	
		 });
	}
	
	public boolean searchEmpId(String Id) {
		try {
			FileReader fr = new FileReader("accountrecord.txt");
		//	BufferedReader br = new BufferedReader(new FileReader("accountrecord.txt"));
			BufferedReader br = new BufferedReader(fr);
			String record;
			while ((record=br.readLine())!=null) {
				if(record.contains(Id)) 
					return true;
				
			}
			br.close();
			return false;
		}
		catch(Exception e) {
			errorMessage("Can't search data!","Error!");	
			return false;
		}
		
	}
	public void addRecord(String Id, String Firstname, String Lastname,int Age,String Password) {
		try {
			String id = (txtId.getText());
			String firstname = txtFirstName.getText();
			String lastname = txtLastName.getText();
			int age = Integer.valueOf(txtAge.getText());
			String password = txtPassword.getText();
			
			File account = new File("accountrecord.txt");
			//FileReader account = new FileReader("accountrecord.txt");
			//BufferedWriter bw = new BufferedWriter(new FileWriter(account,true));
			FileWriter fw = new FileWriter(account,true); 
			fw.write(id+","+firstname+","+lastname+","+age+","+password+"\n");
			clearFields();
			successMessage("Account Created Successfully!","Success!");
			
			
			fw.flush();
			//fw.newLine();
			fw.close();
			Login login = new Login();
			login.main(null);
			frame.setVisible(false);
			
			
		}
		catch(Exception e) {
			errorMessage("There is a problem with the file! Can't add new data!","Error!");
		}
	}
	public void gobackLogin() {
		 lblGoBackLogin.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		Login login = new Login();
			 		login.main(null);
			 		frame.setVisible(false);
			 	}
			 });
	}
	public void Cancel() {
		 btnCancel.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		System.exit(0);
			 		}
			 
			 });
	}
	public void TermsConditions() {
		lblAcceptTerms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TermsConditions tc = new TermsConditions();
				tc.main(null);
				frame.setVisible(true);
			}
		});
	}
	public void clearFields() {
		txtFirstName.setText(null);
		txtLastName.setText(null);
		txtId.setText(null);
		txtAge.setText("");
		txtPassword.setText("");
		
			}
	public static void successMessage(String info, String status) {
		JOptionPane.showMessageDialog(null, info, status, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void errorMessage(String error, String status) {
			
			JOptionPane.showMessageDialog(null, error, status, JOptionPane.ERROR_MESSAGE);
			
		}
}
