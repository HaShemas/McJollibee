package GUIPOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory {

	private JFrame frame;
	private JTextField tfProductName;
	private JTextField tfProductPrice;
	private JButton btnAddItem, btnUpdateItem, btnDeleteItem, btnLogOut, btnSearch, btnOrder, btnViewAll;
	private JList productList, priceList;
	private ArrayList <Data> arrList;
	private JTextField tfSearch;
	private JTextField tfPosNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory();
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
	public Inventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(10, 11, 1, 511);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 11, 514, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(523, 11, 1, 511);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(Color.BLACK);
		separator_1_2.setBounds(10, 57, 514, 2);
		frame.getContentPane().add(separator_1_2);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setFont(new Font("Consolas", Font.BOLD, 25));
		lblInventory.setBounds(21, 11, 492, 48);
		frame.getContentPane().add(lblInventory);
		
		productList = new JList();
		productList.setFont(new Font("Consolas", Font.PLAIN, 12));
		productList.setBounds(21, 102, 151, 407);
		frame.getContentPane().add(productList);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setForeground(Color.BLACK);
		separator_1_2_1.setBounds(10, 89, 514, 2);
		frame.getContentPane().add(separator_1_2_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(182, 57, 1, 465);
		frame.getContentPane().add(separator_3);
		
		priceList = new JList();
		priceList.setFont(new Font("Consolas", Font.PLAIN, 12));
		priceList.setBounds(195, 101, 76, 408);
		frame.getContentPane().add(priceList);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1.setForeground(Color.BLACK);
		separator_3_1.setBounds(283, 57, 1, 465);
		frame.getContentPane().add(separator_3_1);
		
		JLabel lblProducts = new JLabel("Products");
		lblProducts.setFont(new Font("Consolas", Font.BOLD, 15));
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setBounds(21, 57, 151, 34);
		frame.getContentPane().add(lblProducts);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Consolas", Font.BOLD, 15));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(195, 57, 76, 34);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperations.setFont(new Font("Consolas", Font.BOLD, 15));
		lblOperations.setBounds(294, 57, 219, 34);
		frame.getContentPane().add(lblOperations);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(10, 520, 514, 2);
		frame.getContentPane().add(separator_4);
		
		tfProductName = new JTextField();
		tfProductName.setBounds(294, 185, 219, 30);
		frame.getContentPane().add(tfProductName);
		tfProductName.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblProductName.setBounds(294, 164, 99, 20);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblProductPrice = new JLabel("Product Price:");
		lblProductPrice.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblProductPrice.setBounds(294, 226, 99, 20);
		frame.getContentPane().add(lblProductPrice);
		
		tfProductPrice = new JTextField();
		tfProductPrice.setColumns(10);
		tfProductPrice.setBounds(294, 247, 219, 30);
		frame.getContentPane().add(tfProductPrice);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAddItem.setBounds(354, 294, 99, 30);
		frame.getContentPane().add(btnAddItem);
		
		btnDeleteItem = new JButton("Delete");
		btnDeleteItem.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnDeleteItem.setBounds(294, 335, 99, 30);
		frame.getContentPane().add(btnDeleteItem);
		
		btnUpdateItem = new JButton("Update");
		btnUpdateItem.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnUpdateItem.setBounds(414, 335, 99, 30);
		frame.getContentPane().add(btnUpdateItem);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(294, 387, 136, 30);
		frame.getContentPane().add(tfSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnSearch.setBounds(440, 387, 73, 31);
		frame.getContentPane().add(btnSearch);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnLogOut.setBounds(418, 476, 95, 30);
		frame.getContentPane().add(btnLogOut);
		
		btnOrder = new JButton("Order");
		
		btnOrder.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnOrder.setBounds(294, 477, 95, 30);
		frame.getContentPane().add(btnOrder);
		
		JLabel lblPositionNumber = new JLabel("Position Number:");
		lblPositionNumber.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblPositionNumber.setBounds(294, 102, 219, 20);
		frame.getContentPane().add(lblPositionNumber);
		
		tfPosNum = new JTextField();
		tfPosNum.setColumns(10);
		tfPosNum.setBounds(294, 123, 219, 30);
		frame.getContentPane().add(tfPosNum);
		
		btnViewAll = new JButton("View All");
		btnViewAll.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnViewAll.setBounds(354, 435, 95, 30);
		frame.getContentPane().add(btnViewAll);
		
		gotoMenu();
		actions();
		displayProd();
		
	}
	public void actions() {
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String posnum = tfPosNum.getText().toString(); 
					String prodname = tfProductName.getText().toString();
					double prodprice = Double.valueOf(tfProductPrice.getText());
					
					
					addProducts(posnum, prodname,prodprice);
					displayProd();
					
				}
				catch (Exception e) {
					errorMessage("Invalid Input! Please Try Again.","Error");
				}
			}
		});
		
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int prodPos = productList.getSelectedIndex();
					int pricePos = priceList.getSelectedIndex();
					
					deleteSelected(prodPos);
					displayProd();
				}
				catch (Exception e) {
					
				}
			}
		});
		
		btnUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int prodPos = productList.getSelectedIndex();
					editForm(prodPos);
				}
				catch(Exception e) {
					errorMessage("No selected Item to Edit!","Error");
				}
			}
		});
		
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAll view = new ViewAll();
				view.main(null);
				frame.setVisible(false);
			}
		});
		
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				String prodname = tfSearch.getText().toString();
				boolean Exist = searchItem(prodname);
			
				if(Exist) {
					informationMessage("Product: " + prodname + " is Existed..", "Information");
					return;
				}
				else {
					errorMessage("Can't find product!","Error!");
					return;
				}
			}
			catch (Exception e) {
				
			}
			}
		});
		
		
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
	public boolean searchItem(String prodname) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("items.txt"));
			String items;
			
			while((items = br.readLine())!=null) {
				if(items.contains(prodname))
					return true;
			}
			return false;
		}
		catch (Exception e) {
			errorMessage("Can't search product!", "Information");
			return false;
		}
	}
	public void logout() {
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		try {
			int confirm=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?", 
					"Exiting System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
		errorMessage("Can't Log Out!", "Error");
	}
			}
		});
	}
	public void addProducts(String posnum, String prodname, double prodprice) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter ("items.txt", true));
			bw.write(posnum + "," + prodname + "," + prodprice);
			bw.flush();
			bw.newLine();
			bw.close();
		
			clear();
		}
		catch (Exception e) {
			errorMessage ("Can't Add Product!", "Error");
		}
	}
	public void displayProd() {
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
			
			listDisplay(arrList);
			br.close();
			
		}
		catch (Exception e) {
			errorMessage("Can't fetch Items!", "Error");
		}
	}
	
	public void listDisplay(ArrayList <Data> arrList) {
		DefaultListModel modelproduct = new DefaultListModel();
		DefaultListModel modelprice = new DefaultListModel();
		
		for(int i=0; i<arrList.size(); i++) {
			modelproduct.addElement(arrList.get(i).getPos() + " " + arrList.get(i).getProduct());
			modelprice.addElement(arrList.get(i).getPrice());
		}
		productList.setModel(modelproduct);
		priceList.setModel(modelprice);
	}
	public void editForm(int pos) {
		String product = arrList.get(pos).getProduct();
		double price = Double.valueOf(arrList.get(pos).getPrice());
		String position = arrList.get(pos).getPos();
		
		Data data = new Data();
		data.setPos(position);
		data.setProduct(product);
		data.setPrice(price);
		
		
		EditForm edit = new EditForm(data);
		edit.main(null);
		frame.setVisible(false);
	}
	public void deleteSelected(int prodPos) {
		try {
		String prodname = arrList.get(prodPos).getProduct();
		
		String items;
		
		File file = new File ("record.txt");
		File item = new File ("items.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(item));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
			while((items = br.readLine())!=null) {
				if(items.contains(prodname))
					continue;
				
				bw.write(items);
				bw.flush();
				bw.newLine();
			}
				br.close();
				bw.close();
				item.delete();
				file.renameTo(item);
				
				arrList.remove(prodPos);
		}
		catch (Exception e) {
			errorMessage("Please Select an Item to Delete!","Error");
		}
	}
	public void clear() {
		tfPosNum.setText("");
		tfProductName.setText("");
		tfProductPrice.setText("");
		
	}
	
	public void errorMessage(String message, String status) {
		JOptionPane.showMessageDialog(frame, message, status, JOptionPane.ERROR_MESSAGE);
	}
	public void informationMessage(String message, String status) {
		JOptionPane.showMessageDialog(frame, message, status, JOptionPane.INFORMATION_MESSAGE);
	}
}
