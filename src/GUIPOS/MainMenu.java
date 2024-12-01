package GUIPOS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

	
public class MainMenu extends Inventory {

	private JFrame frame;
	private JTextField foodQnty;
	private JButton btnLogOut, btnInventory, btnPayAmount, btnAddOrder,btnSettings;
	private ArrayList <Data> arrList;
	private JComboBox foodcBox;
	private JLabel totalCost, foodName, foodCost, foodQtydisp, discountedCost;
	private JRadioButton rb1, rb2, rb3;	
	private ButtonGroup radioGroup;
	private JTextPane area;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(10, 11, 1, 441);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 11, 464, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(10, 450, 464, 2);
		frame.getContentPane().add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(473, 11, 1, 441);
		frame.getContentPane().add(separator_2);
		
		foodcBox = new JComboBox();
		
		
		foodcBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		foodcBox.setBounds(21, 103, 140, 30);
		frame.getContentPane().add(foodcBox);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(10, 63, 464, 2);
		frame.getContentPane().add(separator_3);
		
		JLabel lblMyOrders = new JLabel("MAIN MENU");
		lblMyOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyOrders.setFont(new Font("Consolas", Font.BOLD, 30));
		lblMyOrders.setBounds(21, 11, 442, 54);
		frame.getContentPane().add(lblMyOrders);
		
		foodQnty = new JTextField();
		foodQnty.setHorizontalAlignment(SwingConstants.CENTER);
		foodQnty.setFont(new Font("Consolas", Font.PLAIN, 11));
		foodQnty.setBounds(21, 167, 60, 30);
		frame.getContentPane().add(foodQnty);
		foodQnty.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(203, -185, 270, 2);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(191, 63, 1, 389);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(Color.BLACK);
		separator_3_1.setBounds(190, 331, 284, 2);
		frame.getContentPane().add(separator_3_1);
		
		JLabel lblYourOrders = new JLabel("YOUR ORDERS");
		lblYourOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrders.setFont(new Font("Consolas", Font.BOLD, 15));
		lblYourOrders.setBounds(203, 63, 148, 33);
		frame.getContentPane().add(lblYourOrders);
		
		JLabel lblFoodLists = new JLabel("Food Lists:");
		lblFoodLists.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblFoodLists.setBounds(21, 76, 140, 20);
		frame.getContentPane().add(lblFoodLists);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblQuantity.setBounds(21, 144, 85, 20);
		frame.getContentPane().add(lblQuantity);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(361, 63, 1, 270);
		frame.getContentPane().add(separator_6);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Consolas", Font.BOLD, 15));
		lblPrice.setBounds(372, 63, 91, 27);
		frame.getContentPane().add(lblPrice);
		
		btnAddOrder = new JButton("ADD ORDER");
		
		
		btnAddOrder.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnAddOrder.setBounds(21, 219, 140, 35);
		frame.getContentPane().add(btnAddOrder);
		
		JLabel lblSelectDiscount = new JLabel("Select Discount:");
		lblSelectDiscount.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblSelectDiscount.setBounds(21, 265, 139, 30);
		frame.getContentPane().add(lblSelectDiscount);
		
		rb1 = new JRadioButton("5%");
		rb1.setFont(new Font("Consolas", Font.PLAIN, 11));
		rb1.setBounds(21, 300, 47, 23);
		frame.getContentPane().add(rb1);
		
		rb2 = new JRadioButton("10%");
		rb2.setFont(new Font("Consolas", Font.PLAIN, 11));
		rb2.setBounds(79, 300, 47, 23);
		frame.getContentPane().add(rb2);
		
		rb3 = new JRadioButton("20%");
		rb3.setFont(new Font("Consolas", Font.PLAIN, 11));
		rb3.setBounds(137, 300, 47, 23);
		frame.getContentPane().add(rb3);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(rb1);
		radioGroup.add(rb2);
		radioGroup.add(rb3);
		
		btnInventory = new JButton("INVENTORY");
		btnInventory.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnInventory.setBounds(21, 334, 140, 30);
		frame.getContentPane().add(btnInventory);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(190, 91, 284, 2);
		frame.getContentPane().add(separator_7);
		
		foodName = new JLabel("");
		foodName.setVerticalAlignment(SwingConstants.TOP);
		foodName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		foodName.setBounds(230, 105, 120, 210);
		frame.getContentPane().add(foodName);
		
		foodCost = new JLabel("");
		foodCost.setVerticalAlignment(SwingConstants.TOP);
		foodCost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		foodCost.setHorizontalAlignment(SwingConstants.RIGHT);
		foodCost.setBounds(365, 105, 70, 210);
		frame.getContentPane().add(foodCost);
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnLogOut.setBounds(21, 407, 140, 30);
		frame.getContentPane().add(btnLogOut);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(190, 362, 284, 2);
		frame.getContentPane().add(separator_8);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Consolas", Font.BOLD, 15));
		lblTotal.setBounds(203, 334, 55, 30);
		frame.getContentPane().add(lblTotal);
		
		totalCost = new JLabel("");
		totalCost.setFont(new Font("Consolas", Font.PLAIN, 12));
		totalCost.setHorizontalAlignment(SwingConstants.RIGHT);
		totalCost.setBounds(365, 335, 70, 25);
		frame.getContentPane().add(totalCost);
		
		btnPayAmount = new JButton("GENERATE RECEIPT");
		btnPayAmount.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnPayAmount.setBounds(251, 407, 162, 30);
		frame.getContentPane().add(btnPayAmount);
		
		foodQtydisp = new JLabel("");
		foodQtydisp.setVerticalAlignment(SwingConstants.TOP);
		foodQtydisp.setHorizontalAlignment(SwingConstants.CENTER);
		foodQtydisp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		foodQtydisp.setBounds(200, 105, 30, 210);
		frame.getContentPane().add(foodQtydisp);
		
		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setForeground(Color.BLACK);
		separator_3_1_1.setBounds(190, 394, 284, 2);
		frame.getContentPane().add(separator_3_1_1);
		
		JLabel lblD = new JLabel("DISCOUNTED PRICE:");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Consolas", Font.BOLD, 15));
		lblD.setBounds(203, 366, 148, 30);
		frame.getContentPane().add(lblD);
		
		discountedCost = new JLabel("");
		discountedCost.setHorizontalAlignment(SwingConstants.RIGHT);
		discountedCost.setFont(new Font("Consolas", Font.PLAIN, 12));
		discountedCost.setBounds(365, 366, 70, 25);
		frame.getContentPane().add(discountedCost);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(473, 11, 217, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		area = new JTextPane();
		area.setFont(new Font("Tahoma", Font.PLAIN, 10));
		area.setBounds(10, 0, 207, 439);
		panel.add(area);
		
		 btnSettings = new JButton("SETTINGS");
		
		btnSettings.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnSettings.setBounds(21, 372, 140, 30);
		frame.getContentPane().add(btnSettings);
		
		comboBoxfromtxtFile();
		buttons();
		numbersOnly();
		
	}
	public void buttons() {
		selectedDiscount();
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(foodcBox.getSelectedIndex()<0) {
					errorMessage("Please select a food", "ERROR!");
					return;
				}
				if(foodQnty.getText().toString().equals("")) {
					errorMessage("Quantity cannot be blank", "ERROR!");
					return;
				}
				
				displayOrders();
				totalFood();
				totalOrder(0);
				clear();
			}
		});
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory newtab = new Inventory();
				newtab.main(null);
				frame.setVisible(false);
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
	    btnPayAmount.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		area.setText(area.getText()+"\n");
	    		area.setText(area.getText()+"************************************\n");
	    		area.setText(area.getText()+"*                      RECEIPT                   *\n");
	    		area.setText(area.getText()+"************************************\n");
	    		area.setText(area.getText()+"                      McJollibee\n");
	    		area.setText(area.getText()+"                        Amigos\n");
	    		area.setText(area.getText()+"                      Davao City\n");
	    		area.setText(area.getText()+"--------------------------------------------------\n");
	    		
	    		Date obj = new Date();
	    		String date = obj.toString();    		
	    		
	    		area.setText(area.getText()+"\n"+foodName.getText()+"\t\t"+foodCost.getText()+"\n");
	    		area.setText(area.getText()+"--------------------------------------------------\n");
	    		area.setText(area.getText()+"                       TOTAL: \t"+totalCost.getText()+"\n");
	    		area.setText(area.getText()+"--------------------------------------------------\n");
	    		area.setText(area.getText()+"DISCOUNTED TOTAL:\t"+discountedCost.getText()+"\n");
	    		area.setText(area.getText()+"--------------------------------------------------\n");
	    		area.setText(area.getText()+date+"\n\n\n");
	    		area.setText(area.getText()+"  NO RETURNS WITHOUT RECEIPT\n");
	    		area.setText(area.getText()+"                    THANK YOU\n");
	    		area.setText(area.getText()+"              ENJOY YOUR MEAL :)\n\n");	
	    	}
	    });
		
	}
	public void comboBoxfromtxtFile() {
		try {
			BufferedReader br = new BufferedReader (new FileReader("items.txt"));
			Object[] lines = br.lines().toArray();
			arrList = new ArrayList();
			
			for(int i=0; i<lines.length; i++) {
				String line = lines[i].toString();
				StringTokenizer st = new StringTokenizer(line,",");
				
				Data data = new Data();
				String position = st.nextToken();
				String product = st.nextToken();
				double price = Double.valueOf(st.nextToken());
				data.setPos(position);
				data.setProduct(product);
				data.setPrice(price);
				
				foodcBox.addItem(product);
				arrList.add(data);
				foodcBox.setSelectedIndex(-1);
			}
		}
		catch (Exception e) {
			errorMessage("Can't fetch Items!", "Error");
		}
		
	}
	public void displayOrders() {
		//foodName.setText("<html>");
		//foodCost.setText("<html>");
		//foodQtydisp.setText("<html>");
			String showItem = foodcBox.getSelectedItem().toString();
			int pos = foodcBox.getSelectedIndex();
			int multiplier = Integer.valueOf(foodQnty.getText());
			double price = Double.valueOf(arrList.get(pos).getPrice());
			foodName.setText(showItem);
			foodCost.setText(Double.valueOf(price).toString());
			foodQtydisp.setText(Integer.valueOf(multiplier).toString());
						//foodName.setText(foodName.getText()+""+showItem+"<br>");
						//foodCost.setText(foodCost.getText()+""+price+"<br>");
						//foodQtydisp.setText(foodQtydisp.getText()+""+multiplier+"<br>");	
		//foodName.setText(foodName.getText()+"<html>");
		//foodCost.setText(foodCost.getText()+"<html>");
		//foodQtydisp.setText(foodQtydisp.getText()+"<html>");
	}
	public void totalFood() {
		double totalfood = 0;
				double fdMultiplier = Double.valueOf(foodQnty.getText());
				double fdC = Double.valueOf(foodCost.getText());
				totalfood = fdMultiplier*fdC;
				foodCost.setText(String.valueOf(totalfood));
				
	}
	
	public void totalOrder(double total) {
		double foodC_value = Double.valueOf(foodCost.getText());
		total = total+foodC_value;
		totalCost.setText(String.valueOf(total));
	}
	public void selectedDiscount() {
		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateDiscount(0.05);
			}
		});
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateDiscount(0.10);
			}
		});
		rb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateDiscount(0.20);
			}
		});
	}
	public void calculateDiscount(double discount) {
		double price = Double.parseDouble(totalCost.getText());
		double total = price - (price*discount);
			discountedCost.setText(String.valueOf(total));
	}
	public void clear() {
		foodcBox.setSelectedIndex(-1);
		foodQnty.setText("");
	}
	public void numbersOnly() {
		foodQnty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(((c<'0')||(c>'9'))&&(c!= KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
				if(((c=='.'))&&(c!= KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
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
	public void logout() {
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
		errorMessage("Can't Log Out!", "Error");
	}
	}
}