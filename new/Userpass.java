
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;

public class Userpass extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1;
    JPasswordField pf1,pf2;
    // JRadioButton r1,r2;
    JButton b1,b2;
    // JComboBox<String> c1= new JComboBox<>();
    // JComboBox<String> c2= new JComboBox<>();
    // JComboBox<String> c3= new JComboBox<>();


    Userpass(){
        setTitle("NEW USER ACCOUNT APPLICATION");

        l1 = new JLabel("PLEASE CHOOSE A STRONG PASSWORD");
        l1.setFont(new Font("Raleway", Font.BOLD, 16));

        l2 = new JLabel("Type Your Username:");                           //textfield
        l2.setFont(new Font("Raleway", Font.BOLD, 12));

        l3 = new JLabel("Type a Password:");                          //textfield 
        l3.setFont(new Font("Raleway", Font.BOLD, 12));

        l4 = new JLabel("Confirm Password:");                          //textfield 
        l4.setFont(new Font("Raleway", Font.BOLD, 12));

        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway", Font.BOLD, 10));

        pf1 = new JPasswordField(10);
        pf1.setFont(new Font("Raleway", Font.BOLD, 10));

        pf2 = new JPasswordField(10);
        pf2.setFont(new Font("Raleway", Font.BOLD, 10));

        b1 = new JButton("OK");
        b1.setFont(new Font("Raleway", Font.BOLD, 10));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        // b2 = new JButton("Next");
        // b2.setFont(new Font("Raleway", Font.BOLD, 10));              //may be added again later
        // b2.setBackground(Color.BLACK);
        // b2.setForeground(Color.WHITE);

        l5 = new JLabel("Password Should Contain at least 1 Number");
        l5.setFont(new Font("Raleway", Font.BOLD, 10));
        l5.setForeground(Color.RED);
        add(l5);

        l6 = new JLabel("Please Confirm Password Correctly");
        l6.setFont(new Font("Raleway", Font.BOLD, 10));
        l6.setForeground(Color.RED);
        add(l6);

        setLayout(null);

        l1.setBounds(60,20,500,30);
        add(l1);

        l2.setBounds(60,60,200,30);
        add(l2);

        tf1.setBounds(190,60,150,30);
        add(tf1);

        l3.setBounds(60,100,200,30);
        add(l3);

        pf1.setBounds(190,100,150,30);
        add(pf1);

        l4.setBounds(60,140,200,30);
        add(l4);

        pf2.setBounds(190,140,150,30);
        add(pf2);

        b1.setBounds(270,182,70,30);
        add(b1);

        // b2.setBounds(360,320,70,30);             //may be added again later
        // add(b2);

        b1.addActionListener(this);
        // b2.addActionListener(this);              //may be added again later

        getContentPane().setBackground(Color.WHITE);
        
        setSize(450,400);
        setLocation(500,120);
        setVisible(true);
    } 

    public void actionPerformed(ActionEvent ae){
        String uid = tf1.getText();                // may be changed later to char[] b= pf2.getPassword();
        String upass = pf1.getText();
        String cpass = pf2.getText();  
        String ss = "User";                       // may be deleted later along with changing ^
        int len = upass.length();
        int count = 0;
        String a = "Password Should Contain at least 1 Number";
        String b = "Please Confirm Password Correctly";
        String alert1 = a+Color.RED;
        String alert2 = b+Color.RED;
        
  //    if(ae.getSource()==b1){
        if(cpass.equals(upass)){
            for(int i=0; i<len; i++){
                if(Character.isLetter(upass.charAt(i)))
                count++;
            }
            if(count == len){
                
                JOptionPane.showMessageDialog(null, l5, "Password Not Accepted", JOptionPane.WARNING_MESSAGE);
                pf1.setText("");
                pf2.setText("");

            } else {
        try {
            //if(ae.getSource()==b1){
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamart", "root", "asdf123");
                Statement s = c.createStatement();
        //      conn c1 =  new conn();
                
                String q = "insert into login values('"+uid+"','"+upass+"','"+ss+"')";
                s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Signed Up Succesfully !!", "User Signup Successful", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "Click OK To Proceed");
                setVisible(false);
            new Userhub().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } else{
        JOptionPane.showMessageDialog(null, l6, "Error Confirming Password", JOptionPane.WARNING_MESSAGE);
        pf2.setText("");
    }
//}

        // else if(ae.getSource()==b2){
        //     setVisible(false);                                              // may be added again later
        //     new Userhub().setVisible(true);
        // }
            
            // else if(ae.getSource()==b2){
            //     setVisible(false);
            //     new userhub().setVisible(true);  
            // }
        // } catch (Exception e) {
        //     //TODO: handle exception
        //     e.printStackTrace();
        }
    

    public static void main(String[] args){
        new Userpass().setVisible(true);
    }
}