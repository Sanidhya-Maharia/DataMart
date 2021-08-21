
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.AncestorListener;

public class Login extends JFrame implements ActionListener{
//public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField tf1,tf2,tf3;
    JPasswordField pf1;
    JButton b1,b2,b3,b4;
    //JComboBox<String> c1= new JComboBox<>();
  
    Login(){
        setTitle("DATAMART MANAGEMENT SYSTEM");
        
        
        l1 = new JLabel("WELCOME TO DMART");
        l1.setFont(new Font("Osward", Font.BOLD, 32));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2 = new JLabel("USERNAME:");
        l2.setFont(new Font("Raleway", Font.BOLD, 16));
        l2.setBounds(100,100,200,20);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,100,230,20);
        tf1.setFont(new Font("Arial", Font.BOLD, 12));
        add(tf1);
        
        l3 = new JLabel("PASSWORD:");
        l3.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.setBounds(100,150,375,20);
        add(l3);
        
        pf1 = new JPasswordField(15);
        pf1.setFont(new Font("Arial", Font.BOLD, 12));
        pf1.setBounds(300,150,230,20);
        add(pf1);

        // l4 = new JLabel("Logging In as:");
        // l4.setFont(new Font("Raleway", Font.BOLD, 16));
        // l4.setBounds(100,200,375,20);
        // add(l4);

        // tf2 = new JTextField(15);
        // tf2.setBounds(300,200,230,20);
        // tf2.setFont(new Font("Arial", Font.BOLD, 12));
        // add(tf2);

        // String[] type={"User", "Retailer"};
        // c1= new JComboBox<>(type);
        // c1.setBackground(Color.WHITE);
        // c1.setBounds(300,200,60,16);
        // add(c1);
                
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP AS USER");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("SIGN UP AS RETAILER");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 8));
        b1.setBounds(450,250,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 8));
        b2.setBounds(450,290,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 8));
        b3.setBounds(370,330,180,30);
        add(b3);

        b4.setFont(new Font("Arial", Font.BOLD, 8));
        b4.setBounds(370,370,180,30);
        add(b4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(450,100);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        String a= tf1.getText();                // may be changed later to char[] b= pf2.getPassword();
        String pass = pf1.getText();            // may be deleted later along with changing ^
        // String type = tf2.getText();
        String user = "User";
        String retailer = "Retailer"; 
        String str = "";  

        try {
            if(ae.getSource()==b1){
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/datamart", "root", "asdf123");
                Statement s = c.createStatement();
          //    conn c1 =  new conn();
                // String a= tf1.getText();
                // char[] b= pf2.getPassword();
                // String pass = Arrays.toString(b);
                String q= "select type from login where username = '"+a+"' and password = '"+pass+"'";

                ResultSet rs = s.executeQuery(q);
                //ResultSet rs1 = c1.s.executeQuery(q);

                if (rs.next()) {
                    str = rs.getString("type");
                    if(str.equals(user)){
                        setVisible(false);
                        new Userhub().setVisible(true);
                    } else if(str.equals(retailer)){
                        setVisible(false);
                        new Retailerhub().setVisible(true);
                    }
                    //  setVisible(false);
                    //  new checkit().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            } else if(ae.getSource()==b2){
                tf1.setText("");
                pf1.setText("");
            } else if(ae.getSource()==b3){
                setVisible(false);
                new Signupuser().setVisible(true);
            } else if(ae.getSource()==b4){
                setVisible(false);
                new Signupretailer().setVisible(true);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Login().setVisible(true);
    }
}
