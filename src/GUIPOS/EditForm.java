package GUIPOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class EditForm {

	private JFrame frame;
	private JTextField tfProdName;
	private JTextField tfProdPrice;
	private JButton btnUpdateItem, btnCancel;
	private Data data;
	private JTextField tfPosition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public EditForm(Data data) {
		this.data = data;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnUpdateItem = new JButton("Update");
		btnUpdateItem.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnUpdateItem.setBounds(32, 220, 99, 30);
		frame.getContentPane().add(btnUpdateItem);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblProductName.setBounds(32, 73, 99, 20);
		frame.getContentPane().add(lblProductName);
		
		tfProdName = new JTextField();
		tfProdName.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfProdName.setColumns(10);
		tfProdName.setBounds(32, 94, 219, 30);
		frame.getContentPane().add(tfProdName);
		
		JLabel lblProductPrice = new JLabel("Product Price:");
		lblProductPrice.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblProductPrice.setBounds(32, 135, 99, 20);
		frame.getContentPane().add(lblProductPrice);
		
		tfProdPrice = new JTextField();
		tfProdPrice.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfProdPrice.setColumns(10);
		tfProdPrice.setBounds(32, 156, 219, 30);
		frame.getContentPane().add(tfProdPrice);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(152, 219, 99, 30);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblPositionNumber = new JLabel("Position Number:");
		lblPositionNumber.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblPositionNumber.setBounds(32, 11, 219, 14);
		frame.getContentPane().add(lblPositionNumber);
		
		tfPosition = new JTextField();
		tfPosition.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfPosition.setBounds(32, 32, 219, 30);
		frame.getContentPane().add(tfPosition);
		tfPosition.setColumns(10);
		
		frame.setVisible(true);
		display();
		actions();
	}
	
	public void actions() {
		btnUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String position = tfPosition.getText().toString();
				double price = Double.valueOf(tfProdPrice.getText().toString());
				String product = tfProdName.getText().toString();
				
				
				edit(position, product, price);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Inventory invent = new Inventory();
			invent.main(null);
			frame.setVisible(false);
			}
		});
	}
	
	public void edit(String position, String product, double price) {
		try {
			File file = new File ("record.txt");
			File item = new File ("items.txt");
			
			BufferedReader br = new BufferedReader(new FileReader(item));
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String items;
			
			while((items = br.readLine())!=null) {
				if(items.contains(position)) {
					bw.write(position + "," + product + "," + price);
				}
				else {
					bw.write(items);
				}
				
				bw.flush();
				bw.newLine();
			}	
				
				br.close();
				bw.close();
				item.delete();
				file.renameTo(item);
				
				Inventory invent = new Inventory();
				invent.main(null);
				frame.setVisible(false);
		}
		catch (Exception e) {
			
		}
	}
	
	public void display() {
		tfPosition.setText(data.getPos());
		tfProdName.setText(data.getProduct());
		tfProdPrice.setText(String.valueOf(data.getPrice()));
	}
}
