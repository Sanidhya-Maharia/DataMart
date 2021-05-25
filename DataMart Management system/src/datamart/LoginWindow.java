package datamart;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class LoginWindow {

	public JFrame frmLogin;
	private JTextField username;
	private JPasswordField password;
	private final Action action = new SwingAction();
	private Scanner scan;
	private File file;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	public static void main(String[] args) {
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

	public LoginWindow() {
		initialize();
	}

	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 607, 462);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel usertext = new JLabel("Username:");
		usertext.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usertext.setBounds(55, 83, 141, 61);
		frmLogin.getContentPane().add(usertext);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(241, 100, 237, 32);
		frmLogin.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel passwordtext = new JLabel("Password:");
		passwordtext.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordtext.setBounds(55, 157, 152, 32);
		frmLogin.getContentPane().add(passwordtext);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(241, 160, 237, 32);
		frmLogin.getContentPane().add(password);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.setForeground(Color.WHITE);
		loginbutton.setBackground(Color.BLACK);
		loginbutton.setAction(action);
		loginbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginbutton.setBounds(116, 231, 135, 32);
		frmLogin.getContentPane().add(loginbutton);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.setAction(action_1);
		clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBackground(Color.BLACK);
		clearbtn.setBounds(319, 230, 135, 33);
		frmLogin.getContentPane().add(clearbtn);
		
		JButton signupbtn = new JButton("Sign Up");
		signupbtn.setAction(action_2);
		signupbtn.setForeground(Color.WHITE);
		signupbtn.setBackground(Color.BLACK);
		signupbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupbtn.setBounds(196, 322, 204, 32);
		frmLogin.getContentPane().add(signupbtn);
		
		JLabel Title = new JLabel("Login");
		Title.setFont(new Font("Tahoma", Font.BOLD, 30));
		Title.setBounds(233, 10, 92, 55);
		frmLogin.getContentPane().add(Title);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Click to login");
		}
		public void actionPerformed(ActionEvent e) {
			file = new File("C:/Users/sanid/OneDrive/Documents/Assignments/Java Project/logindetails.txt");
			try {
				scan = new Scanner(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String user = username.getText();
			String pw = password.getText();
			int count1=0, count2=0;
			while(scan.hasNextLine()) {
				String details = scan.nextLine();
				if(details.equals(user+" "+pw+" Customer")) {
					//JOptionPane.showMessageDialog(frmLogin, "Login Successful");
					new CustomerPage().NewScreen2();
					frmLogin.dispose();
				}
				else if(details.equals(user+" "+pw+" Retailer")){
					//JOptionPane.showMessageDialog(frmLogin, "Login Successful");
					new RetailerPage().NewScreen3();
					frmLogin.dispose();
				}
				else {
					count1++;
				}
				count2++;
			}
			if(count1==count2) {
				JOptionPane.showMessageDialog(frmLogin, "Invalid username or password");
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Clears all text entered above");
		}
		public void actionPerformed(ActionEvent e) {
			username.setText("");
			password.setText("");
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Sign Up");
			putValue(SHORT_DESCRIPTION, "Sign up if you don't have an account");
		}
		public void actionPerformed(ActionEvent e) {
			new SignUp().NewScreen1();
			frmLogin.dispose();
		}
	}
}
