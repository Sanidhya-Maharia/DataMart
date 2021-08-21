
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;

public class Signupretailer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JRadioButton r1,r2;
    JButton b;
    JComboBox<String> c1= new JComboBox<>();
    JComboBox<String> c2= new JComboBox<>();
    JComboBox<String> c3= new JComboBox<>();
    JComboBox<String> c4= new JComboBox<>();
    JComboBox<String> c5= new JComboBox<>();

    Signupretailer(){
        setTitle("NEW RETAILER ACCOUNT APPLICATION");

        l1 = new JLabel("PLEASE PROVIDE ESSENTIAL DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 30));

        l2 = new JLabel("Name:");                           //textfield
        l2.setFont(new Font("Raleway", Font.BOLD, 20));

        l3 = new JLabel("ph no:");                          //textfield 
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l4 = new JLabel("Email:");                          //textfield
        l4.setFont(new Font("Raleway", Font.BOLD, 20));

        l5 = new JLabel("Gender");                          //radiob
        l5.setFont(new Font("Raleway", Font.BOLD, 20));

        l6 = new JLabel("Country:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));

        l7 = new JLabel("State:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));

        l8 = new JLabel("City");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));

        l9 = new JLabel("Address:");                            //textfield
        l9.setFont(new Font("Raleway", Font.BOLD, 20));

        l10 = new JLabel("Pin");                                //textfield
        l10.setFont(new Font("Raleway", Font.BOLD, 20));

        l11 = new JLabel("Qualification");                                //textfield
        l11.setFont(new Font("Raleway", Font.BOLD, 20));

        l12 = new JLabel("Company Name");                                //textfield
        l12.setFont(new Font("Raleway", Font.BOLD, 20));

        l13 = new JLabel("Product type");                                //textfield
        l13.setFont(new Font("Raleway", Font.BOLD, 20));

        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway", Font.BOLD, 14));

        tf2 = new JTextField();
        tf2.setFont(new Font("Raleway", Font.BOLD, 14));

        tf3 = new JTextField();
        tf3.setFont(new Font("Raleway", Font.BOLD, 14));

        tf4 = new JTextField();
        tf4.setFont(new Font("Raleway", Font.BOLD, 14));

        tf5 = new JTextField();
        tf5.setFont(new Font("Raleway", Font.BOLD, 14));

        tf6 = new JTextField();
        tf6.setFont(new Font("Raleway", Font.BOLD, 14));

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

        String[] country= {"Argentina", "Australia", "Austria" , "Afghanistan", "Brazil", "Bhutan", "Belgium", "China", "Canada", "Denmark", "Egypt", "France", "Germany", "Italy", "India", "Japan", "Switzerland"};
        c1= new JComboBox<>(country);
        c1.setBackground(Color.WHITE);

        String[] state= {"Andhra", "Punjab", "Maharashtra", "Hariyana", "Telengana", "West Bengal"};
        c2= new JComboBox<>(state);
        c2.setBackground(Color.WHITE);

        String[] city= {"Ahmedabad", "Bangalore", "Bhopal", "Chennai", "Delhi", "Hyderabad", "Kolkata", "Mumbai"};
        c3= new JComboBox<>(city);
        c3.setBackground(Color.WHITE);

        String[] qualification= {"Undergraduate", "Graduate", "Student", "Businessman"};
        c4= new JComboBox<>(qualification);
        c4.setBackground(Color.WHITE);

        String[] product_type= {"Grocery", "Medicine", "Electronic Gadget", "Cosmetics"};
        c5= new JComboBox<>(product_type);
        c5.setBackground(Color.WHITE);

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        setLayout(null);

        l1.setBounds(140,20,600,40);
        add(l1);

        l2.setBounds(100,100,200,30);
        add(l2);

        tf1.setBounds(300,100,400,30);
        add(tf1);

        l3.setBounds(100,150,200,30);
        add(l3);

        tf2.setBounds(300,150,400,30);
        add(tf2);

        l4.setBounds(100,200,200,30);
        add(l4);

        tf3.setBounds(300,200,400,30);
        add(tf3);

        l5.setBounds(100,250,200,30);
        add(l5);

        r1.setBounds(300,250,60,30);
        add(r1);
        
        r2.setBounds(450,250,90,30);
        add(r2);

        l6.setBounds(100,300,200,30);
        add(l6);

        c1.setBounds(300,300,60,30);
        add(c1);

        l7.setBounds(100,350,200,30);
        add(l7);

        c2.setBounds(300,350,60,30);
        add(c2);

        l8.setBounds(100,400,200,30);
        add(l8);

        c3.setBounds(300,400,60,30);
        add(c3);

        l9.setBounds(100,450,200,30);
        add(l9);

        tf4.setBounds(300,450,400,30);
        add(tf4);

        l10.setBounds(100,500,400,30);
        add(l10);

        tf5.setBounds(300,500,400,30);
        add(tf5);

        l11.setBounds(100,550,400,30);
        add(l11);

        c4.setBounds(300,550,60,30);
        add(c4);

        l12.setBounds(100,600,400,30);
        add(l12);

        tf6.setBounds(300,600,400,30);
        add(tf6);

        l13.setBounds(100,650,400,30);
        add(l13);

        c5.setBounds(300,650,60,30);
        add(c5);

        b.setBounds(620,685,80,30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,770);
        setLocation(400,20);
        setVisible(true);
    } 

    public void actionPerformed(ActionEvent ae){
        String name = tf1.getText();
        String ph = tf2.getText();
        String email = tf3.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if(r2.isSelected()){
            gender = "Female";
        }

        String aa = (String)c1.getSelectedItem();
        String bb = (String)c2.getSelectedItem();
        String cc = (String)c3.getSelectedItem();

        String addr = tf4.getText();
        String pin = tf5.getText();

        String qual = (String)c4.getSelectedItem();
        String cname = tf6.getText();
        String ptype = (String)c5.getSelectedItem();

        try {
            if(tf1.getText().equals("") && tf2.getText().equals("") && tf4.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else{
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamart", "root", "asdf123");
                Statement s = c.createStatement();
        //      conn c1 =  new conn();
                String q1 = "insert into signupretailer values('"+name+"','"+ph+"','"+email+"','"+gender+"','"+aa+"','"+bb+"','"+cc+"','"+addr+"','"+pin+"','"+qual+"','"+cname+"','"+ptype+"')";
                s.executeUpdate(q1);
                setVisible(false);
                new Retailerpass().setVisible(true);
                
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Signupretailer().setVisible(true);
    }
}

