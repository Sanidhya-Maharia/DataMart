package datamart;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame SignUp;
	private JTextField new_user;
	private JPasswordField new_pass;
	private final Action action = new SwingAction();
	//private FileWriter writer;
	private BufferedWriter writer;
	private File file;
	private JPasswordField confirm;
	private JRadioButton customer, retailer;
	private JLabel warning1, warning2, warning3;
	private final Action action_1 = new SwingAction_1();

	public static void NewScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.SignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp() {
		initialize();
	}

	private void initialize() {
		SignUp = new JFrame();
		SignUp.setBounds(100, 100, 737, 608);
		SignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignUp.getContentPane().setLayout(null);
		
		JLabel newuser = new JLabel("Enter a username:");
		newuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newuser.setBounds(81, 99, 195, 43);
		SignUp.getContentPane().add(newuser);
		
		new_user = new JTextField();
		new_user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		new_user.setBounds(325, 105, 304, 31);
		SignUp.getContentPane().add(new_user);
		new_user.setColumns(10);
		
		JLabel newpass = new JLabel("Enter a password:");
		newpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newpass.setBounds(81, 168, 174, 43);
		SignUp.getContentPane().add(newpass);
		
		new_pass = new JPasswordField();
		new_pass.setToolTipText("");
		new_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		new_pass.setBounds(325, 174, 304, 31);
		SignUp.getContentPane().add(new_pass);
		
		JButton signupbtn = new JButton("Sign Up");
		signupbtn.setForeground(Color.WHITE);
		signupbtn.setBackground(Color.BLACK);
		signupbtn.setAction(action);
		signupbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupbtn.setBounds(161, 470, 149, 31);
		SignUp.getContentPane().add(signupbtn);
		
		JLabel title = new JLabel("User Registration");
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(231, 10, 276, 50);
		SignUp.getContentPane().add(title);
		
		JLabel con_pass = new JLabel("Confirm password:");
		con_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		con_pass.setBounds(81, 247, 174, 31);
		SignUp.getContentPane().add(con_pass);
		
		confirm = new JPasswordField();
		confirm.setToolTipText("");
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confirm.setBounds(325, 247, 304, 31);
		SignUp.getContentPane().add(confirm);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.setAction(action_1);
		clearbtn.setBackground(Color.BLACK);
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clearbtn.setBounds(386, 470, 149, 31);
		SignUp.getContentPane().add(clearbtn);
		
		customer = new JRadioButton("Customer");
		customer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		customer.setBounds(193, 359, 144, 31);
		SignUp.getContentPane().add(customer);
		
		retailer = new JRadioButton("Retailer");
		retailer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		retailer.setBounds(402, 359, 133, 31);
		SignUp.getContentPane().add(retailer);
		
		JLabel question = new JLabel("Are you a Customer or a Retailer?");
		question.setFont(new Font("Tahoma", Font.PLAIN, 20));
		question.setBounds(193, 307, 315, 31);
		SignUp.getContentPane().add(question);
		
		warning1 = new JLabel("Password must contain letters and numbers");
		warning1.setForeground(Color.RED);
		warning1.setBounds(325, 215, 304, 13);
		SignUp.getContentPane().add(warning1);
		
		warning2 = new JLabel("Passwords don't match");
		warning2.setForeground(Color.RED);
		warning2.setBounds(325, 288, 304, 13);
		SignUp.getContentPane().add(warning2);
		
		warning3 = new JLabel("Please enter all details");
		warning3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		warning3.setForeground(Color.RED);
		warning3.setBounds(166, 446, 144, 13);
		SignUp.getContentPane().add(warning3);
		
		warning1.hide();
		warning3.hide();
		warning2.hide();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Sign Up");
			putValue(SHORT_DESCRIPTION, "Click here to sign up");
		}
		public void actionPerformed(ActionEvent e) {
			file = new File("C:/Users/sanid/OneDrive/Documents/Assignments/Java Project/logindetails.txt");
			warning1.hide();
			warning2.hide();
			warning3.hide();
			String nuser = new_user.getText();
			String npw = new_pass.getText();
			String cpw = confirm.getText();
			if(!ValidatePass(npw)) {
				warning1.show();
				new_pass.setText("");
			}
			
			if(!nuser.equals("")&&!npw.equals("")&&cpw.equals(npw)&&customer.isSelected()) {
				try {
					writer = new BufferedWriter(new FileWriter(file, true));
					writer.append(nuser+" "+npw+" Customer"+"\n");
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(SignUp, "Registered successfully");
				SignUp.dispose();
				ShowLogin();
			}
			else if(!nuser.equals("")&&!npw.equals("")&&cpw.equals(npw)&&retailer.isSelected()) {
				try {
					writer = new BufferedWriter(new FileWriter(file, true));
					writer.append(nuser+" "+npw+" Retailer"+"\n");
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(SignUp, "Registered successfully");
				SignUp.dispose();
				ShowLogin();
			}
			else if(!cpw.equals(npw)) {
				warning2.show();
				warning3.show();
				//JOptionPane.showMessageDialog(SignUp, "Passwords don't match");
			}
			else {
				//JOptionPane.showMessageDialog(SignUp, "Please enter all details");
				warning3.show();
			}
		}
		private void ShowLogin() {
			// TODO Auto-generated method stub
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginWindow window = new LoginWindow();
						window.frmLogin.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Clears all entered text");
		}
		public void actionPerformed(ActionEvent e) {
			new_user.setText("");
			new_pass.setText("");
			confirm.setText("");
			warning1.hide();
			warning2.hide();
			warning3.hide();
		}
	}
	private static boolean ValidatePass(String val) {
		Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(val);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      //System.out.println("Match found");
	      return true;
	    } else {
	      //System.out.println("Match not found");
	      return false;
	    }
	}
}
