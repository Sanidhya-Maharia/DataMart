package datamart;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class RetailerPage {

	private JFrame Retailer;
	private JTextField input;
	private JLabel success;
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private final Action action = new SwingAction();
	private JButton addnew;
	private final Action action_1 = new SwingAction_1();

	public static void NewScreen3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetailerPage window = new RetailerPage();
					window.Retailer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RetailerPage() {
		initialize();
	}

	private void initialize() {
		Retailer = new JFrame();
		Retailer.setBounds(100, 100, 822, 643);
		Retailer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Retailer.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Welcome, Retailer!");
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(235, 10, 304, 66);
		Retailer.getContentPane().add(title);
		
		JLabel desc = new JLabel("Add new products to warehouse stock or check on existing products");
		desc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		desc.setBounds(85, 86, 627, 30);
		Retailer.getContentPane().add(desc);
		
		input = new JTextField();
		input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		input.setBounds(125, 162, 536, 42);
		Retailer.getContentPane().add(input);
		input.setColumns(10);
		
		JButton searchbtn = new JButton("Search");
		searchbtn.setAction(action);
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setBackground(Color.BLACK);
		searchbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchbtn.setBounds(314, 259, 130, 30);
		Retailer.getContentPane().add(searchbtn);
		
		success = new JLabel("");
		success.setFont(new Font("Tahoma", Font.PLAIN, 20));
		success.setBounds(167, 338, 437, 66);
		Retailer.getContentPane().add(success);
		
		addnew = new JButton("Add a new product");
		addnew.setAction(action_1);
		addnew.setForeground(Color.WHITE);
		addnew.setBackground(Color.BLACK);
		addnew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addnew.setBounds(254, 507, 246, 30);
		Retailer.getContentPane().add(addnew);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Click to find info on product entered");
		}
		public void actionPerformed(ActionEvent e) {
			file = new File("C:/Users/sanid/OneDrive/Documents/Assignments/Java Project/warehouse_stock.txt");
			try {
				fr = new FileReader(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			br = new BufferedReader(fr);
			String product = input.getText();
			String s;
			String[] words = null;
			try {
				while((s=br.readLine())!=null) {
					words = s.split(" ");
					for(String word:words) {
						if(word.equals(product)) {
							success.setText("Available stock: "+words[1]+"    Price per pack: "+words[2]);
						}
					}
				}
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Add a new product");
			putValue(SHORT_DESCRIPTION, "Click to add a new product");
		}
		public void actionPerformed(ActionEvent e) {
			new AddNew().NewScreen4();
			Retailer.dispose();
		}
	}
}
