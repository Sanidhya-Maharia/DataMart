package datamart;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNew {

	private JFrame AddNew;
	private JTextField name_input;
	private JTextField stock_input;
	private JTextField price_input;
	private File file;
	private BufferedWriter writer;
	private final Action action = new SwingAction();
	private JButton clearbtn;
	private final Action action_1 = new SwingAction_1();

	public static void NewScreen4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew window = new AddNew();
					window.AddNew.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddNew() {
		initialize();
	}

	private void initialize() {
		AddNew = new JFrame();
		AddNew.setBounds(100, 100, 834, 763);
		AddNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AddNew.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("Enter product name:");
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBounds(68, 90, 198, 33);
		AddNew.getContentPane().add(name);
		
		name_input = new JTextField();
		name_input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name_input.setBounds(402, 89, 287, 36);
		AddNew.getContentPane().add(name_input);
		name_input.setColumns(10);
		
		JLabel stock = new JLabel("Enter the amount in stock:");
		stock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stock.setBounds(68, 157, 248, 33);
		AddNew.getContentPane().add(stock);
		
		stock_input = new JTextField();
		stock_input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stock_input.setBounds(402, 157, 287, 33);
		AddNew.getContentPane().add(stock_input);
		stock_input.setColumns(10);
		
		JLabel price = new JLabel("Enter price per pack:");
		price.setFont(new Font("Tahoma", Font.PLAIN, 20));
		price.setBounds(68, 225, 198, 33);
		AddNew.getContentPane().add(price);
		
		price_input = new JTextField();
		price_input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		price_input.setBounds(402, 225, 287, 33);
		AddNew.getContentPane().add(price_input);
		price_input.setColumns(10);
		
		JButton addbtn = new JButton("Add");
		addbtn.setAction(action);
		addbtn.setForeground(Color.WHITE);
		addbtn.setBackground(Color.BLACK);
		addbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addbtn.setBounds(223, 447, 116, 33);
		AddNew.getContentPane().add(addbtn);
		
		clearbtn = new JButton("Clear");
		clearbtn.setAction(action_1);
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBackground(Color.BLACK);
		clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clearbtn.setBounds(429, 447, 123, 33);
		AddNew.getContentPane().add(clearbtn);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Click to add product to the warehouse stock");
		}
		public void actionPerformed(ActionEvent e) {
			file = new File("C:/Users/sanid/OneDrive/Documents/Assignments/Java Project/warehouse_stock.txt");
			String product = name_input.getText();
			String quantity = stock_input.getText();
			String pr = price_input.getText();
			if(!product.equals("")&&!quantity.equals("")&&!pr.equals("")) {
				try {
					writer = new BufferedWriter(new FileWriter(file, true));
					writer.append(product+" "+quantity+" "+pr+"\n");
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(AddNew, "Added successfully");
			}
			else {
				JOptionPane.showMessageDialog(AddNew, "Please enter all details");
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Click to clear all entered values");
		}
		public void actionPerformed(ActionEvent e) {
			name_input.setText("");
			stock_input.setText("");
			price_input.setText("");
		}
	}
}
