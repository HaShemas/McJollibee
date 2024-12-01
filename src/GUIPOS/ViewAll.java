package GUIPOS;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.*;
import java.util.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAll {

	private JFrame frame;
	private ArrayList <Data> arrList;
	private JList pricelist, productlist;
	private JButton btnLogOut, btnInventory,btnSettings,btnOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAll window = new ViewAll();
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
	public ViewAll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(10, 11, 1, 439);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(423, 11, 1, 439);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(10, 11, 414, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBounds(10, 448, 414, 2);
		frame.getContentPane().add(separator_2_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(221, 11, 1, 439);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setForeground(Color.BLACK);
		separator_2_1_1.setBounds(10, 53, 414, 2);
		frame.getContentPane().add(separator_2_1_1);
		
		JLabel lblProducts = new JLabel("PRODUCTS");
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setFont(new Font("Consolas", Font.BOLD, 20));
		lblProducts.setBounds(21, 11, 190, 44);
		frame.getContentPane().add(lblProducts);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPrice.setBounds(232, 11, 181, 44);
		frame.getContentPane().add(lblPrice);
		
		productlist = new JList();
		productlist.setFont(new Font("Consolas", Font.PLAIN, 12));
		productlist.setBounds(21, 66, 190, 371);
		frame.getContentPane().add(productlist);
		
		pricelist = new JList();
		pricelist.setFont(new Font("Consolas", Font.PLAIN, 12));
		pricelist.setBounds(232, 66, 181, 371);
		frame.getContentPane().add(pricelist);
		
		btnInventory = new JButton("Inventory");
		btnInventory.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnInventory.setBounds(10, 461, 90, 30);
		frame.getContentPane().add(btnInventory);
		
		 btnOrder = new JButton("Order");
		
		btnOrder.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnOrder.setBounds(110, 461, 90, 30);
		frame.getContentPane().add(btnOrder);
		
		 btnSettings = new JButton("Settings");
		
		btnSettings.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnSettings.setBounds(234, 461, 90, 30);
		frame.getContentPane().add(btnSettings);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnLogOut.setBounds(334, 461, 90, 30);
		frame.getContentPane().add(btnLogOut);
		
		display();
		actions();
		gotoMenu();
		gotoSettings();
	}
	public void actions() {
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?", 
						"Exiting System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				try {
				if(confirm==JOptionPane.YES_OPTION) {
					File file = new File ("record.txt");
					File item = new File ("items.txt");
					BufferedReader br = new BufferedReader(new FileReader(item));
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					
					br.close();
					bw.close();
					item.delete();
					file.renameTo(item);
				
					informationMessage("Logged Out Successfully!","Success!");
					Login login = new Login();
					login.main(null);
					frame.setVisible(false);
					
				}
				else if(confirm==JOptionPane.NO_OPTION) {
					JOptionPane.getDefaultLocale();
				}
			}
			
			catch(Exception err) {
				errorMessage("Can't Log Out!", "Error!");
			}
			
			}
		});
		
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Inventory invent = new Inventory ();
			invent.main(null);
			frame.setVisible(false);
			}
		});
	}
	public void display() {
			try {
				BufferedReader br = new BufferedReader (new FileReader("items.txt"));
				String items;
				arrList = new ArrayList();
				
				while((items = br.readLine())!=null) {
					StringTokenizer st = new StringTokenizer(items,",");
					
					Data data = new Data();
					
					String position = st.nextToken();
					String product = st.nextToken();
					double price = Double.valueOf(st.nextToken());
					
					data.setPos(position);
					data.setProduct(product);
					data.setPrice(price);
					
					arrList.add(data);
				}
				list(arrList);
				br.close();
				
				
			}
			catch (Exception e) {
				
			}
	}
	public void gotoMenu() {
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainmenu = new MainMenu();
				mainmenu.main(null);
				frame.setVisible(false);
			}
		});
	}
	public void gotoSettings() {
		 btnSettings.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		Settings settings = new Settings();
			 		settings.main(null);
			 		frame.setVisible(false);
			 	}
			 });
	}
	public void list(ArrayList <Data> arrList) {
		DefaultListModel modelproduct = new DefaultListModel();
		DefaultListModel modelprice = new DefaultListModel();
		
		for(int i=0; i<arrList.size(); i++) {
			modelproduct.addElement(arrList.get(i).getPos() + " " + arrList.get(i).getProduct());
			modelprice.addElement(arrList.get(i).getPrice());
		}
		productlist.setModel(modelproduct);
		pricelist.setModel(modelprice);
	}
	public void informationMessage(String message, String status) {
		JOptionPane.showMessageDialog(frame, message, status, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void errorMessage(String error, String status) {
		
		JOptionPane.showMessageDialog(null, error, status, JOptionPane.ERROR_MESSAGE);
		
	}

}
