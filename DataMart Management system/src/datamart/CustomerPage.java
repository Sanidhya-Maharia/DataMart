package datamart;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class CustomerPage {

	private JFrame Customer;
	private JTextField input;
	private JLabel success;
	private Scanner scan;
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private final Action action = new SwingAction();

	public static void NewScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage window = new CustomerPage();
					window.Customer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerPage() {
		initialize();
	}

	private void initialize() {
		Customer = new JFrame();
		Customer.setBounds(100, 100, 769, 578);
		Customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Customer.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Welcome, user!");
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(235, 20, 244, 37);
		Customer.getContentPane().add(title);
		
		JLabel question = new JLabel("Please enter a product name to get related information:");
		question.setFont(new Font("Tahoma", Font.PLAIN, 20));
		question.setBounds(106, 99, 517, 25);
		Customer.getContentPane().add(question);
		
		input = new JTextField();
		input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		input.setBounds(139, 165, 434, 37);
		Customer.getContentPane().add(input);
		input.setColumns(10);
		
		JButton searchbtn = new JButton("Search");
		searchbtn.setAction(action);
		searchbtn.setBackground(Color.BLACK);
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchbtn.setBounds(284, 242, 142, 33);
		Customer.getContentPane().add(searchbtn);
		
		success = new JLabel("");
		success.setFont(new Font("Tahoma", Font.PLAIN, 20));
		success.setBounds(124, 315, 562, 49);
		Customer.getContentPane().add(success);
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
					boolean matchFound = false;
					for(String word:words) {
						if(word.equalsIgnoreCase(product)) {
							success.setText("Available stock: "+words[1]+"    Price per pack: "+words[2]);
							matchFound = true;
							break;
						}
						else {
							success.setText("No result found");
						}
					}
					if(matchFound) {
						break;
					}
				}
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
