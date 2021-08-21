
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class Retailerhub extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1,tf2;
    JButton b1,b2,b3;

    Retailerhub(){
        setTitle("Welcome Retailer!");

        l1 = new JLabel("WELCOME TO DMART");
        l1.setFont(new Font("Osward", Font.BOLD, 32));
        l1.setBounds(175,40,450,40);
        add(l1);

        l2 = new JLabel("Enter the Product You Want to Update :");
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l2.setBounds(80,100,400,40);
        add(l2);

        tf1 = new JTextField(25);
        tf1.setBounds(260,148,230,20);
        tf1.setFont(new Font("Arial", Font.BOLD, 12));
        add(tf1);

        l4 = new JLabel("If You Want to add a Different Product Then Click ADD PRODUCT -->");
        l4.setFont(new Font("Raleway", Font.BOLD, 16));
        l4.setBounds(80,250,550,40);
        add(l4);

        b1 = new JButton("OK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("ADD PRODUCT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 8));
        b1.setBounds(550,148,100,20);
        add(b1);
        

        b2.setFont(new Font("Arial", Font.BOLD, 8));
        b2.setBounds(550,320,100,20);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(400,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String p = tf1.getText();
        int qua=0;
        try {
            if(ae.getSource()==b1){
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamart", "root", "asdf123");
                Statement s = c.createStatement();
        //      conn c1 = new conn();
                String q = "select quantity from products where item_name='"+p+"'";
                ResultSet rs = s.executeQuery(q);
                
                if(rs.next()){
                    qua = rs.getInt("quantity");
                    JOptionPane.showMessageDialog(null, "Available Stock : " + qua);
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number of Items You want to add: "));
                    int newqua = num + qua;
                    String q1 = "update products set quantity="+newqua+" where item_name='"+p+"'";
                    s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Avaialable Stock: " + newqua);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Item Chosen");
                }
            }
            else if(ae.getSource()==b2){
                setVisible(false);
                new Newproduct().setVisible(true);
            }
           
            } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Retailerhub().setVisible(true);
    }
}
