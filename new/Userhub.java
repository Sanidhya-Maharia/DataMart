
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;

public class Userhub extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JButton b1;

    Userhub(){
        setTitle("Welcome User!");

        l1 = new JLabel("WELCOME TO DMART");
        l1.setFont(new Font("Osward", Font.BOLD, 32));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2 = new JLabel("Enter the Product You Are Searching for:");
        l2.setFont(new Font("Raleway", Font.BOLD, 16));
        l2.setBounds(100,100,400,40);
        add(l2);
        
        tf1 = new JTextField(25);
        tf1.setBounds(300,160,230,20);
        tf1.setFont(new Font("Arial", Font.BOLD, 12));
        add(tf1);
        
        b1 = new JButton("CHECK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        setLayout(null);

        b1.setFont(new Font("Arial", Font.BOLD, 8));
        b1.setBounds(420,250,100,30);
        add(b1);

        b1.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String p = tf1.getText();
        int qua=0;
        int cost = 0;

        try {
            if(ae.getSource()==b1){
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamart", "root", "asdf123");
                Statement s = c.createStatement();
        //      conn c1 = new conn();
                String q = "select * from products where item_name='"+p+"'";
                ResultSet rs = s.executeQuery(q);

                if(rs.next()){
                    qua = rs.getInt("quantity");
                    cost = rs.getInt("price");
                    JOptionPane.showMessageDialog(null, "Avaialable Stock: " + qua + " Each costs " + cost);
                    //setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "???");
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
     }
    public static void main(String[] args) {
        new Userhub().setVisible(true);
    }
 }

