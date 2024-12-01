package GUIPOS;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TermsConditions {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TermsConditions window = new TermsConditions();
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
	public TermsConditions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Terms and Conditions");
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnByAccessingOr = new JTextPane();
		txtpnByAccessingOr.setText("By accessing or using our POS in McJollibee or any other world wide owned, operated, licensed, or controlled by Team Amigos(\u201CTA,\u201D \u201CMcJollibee\u2019s Philippines,\u201D \u201Cwe\u201D or \u201Cus\u201D) and/or installing, accessing, or using any mobile applications (e.g., Apple iOS and Android OS devices and any updates, upgrades, and any other software or documentation which enables you to use such mobile application), mobile websites, email newsletters and subscriptions, and other digital properties (collectively, the \u201COnline Services\u201D) you agree to abide by these Terms or any amendment that we may introduce from time to time. By accepting these Terms, you also understand and consent to McJollibee\u2019s Philippines Privacy Policy, which is incorporated into, and made part of these Terms.");
		txtpnByAccessingOr.setBounds(20, 24, 392, 197);
		frame.getContentPane().add(txtpnByAccessingOr);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 268, 414, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 11, 414, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(10, 11, 2, 259);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(422, 11, 2, 259);
		frame.getContentPane().add(separator_2_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnOk.setBounds(171, 232, 84, 28);
		frame.getContentPane().add(btnOk);
	}
}
