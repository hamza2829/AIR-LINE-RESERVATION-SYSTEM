
import java.awt.*;


import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
public class Login implements ActionListener{  
    JTextField tf1,tf2;
    JButton b1; 
    JLabel l1,l2;
    Login(){  
        JPasswordField p=new JPasswordField();
    	JFrame f= new JFrame();
    	JLabel airline=new JLabel("Air Alpha");
    	JLabel background;
    	//setLayout(null);
    	f.getContentPane().setBackground(new Color(26,27,29));
        l1=new JLabel("username");
        l1.setBounds(550,300,150,50);
        l2=new JLabel("password");
        l2.setBounds(550,350,150,50);
        tf1=new JTextField();  
        tf1.setBounds(670,320,120,20);  
        tf1.setOpaque(false);
        tf2=new JPasswordField();  
        tf2.setBounds(670,367,120,20);  
        tf2.setOpaque(false);
        b1=new JButton("submit");  
        b1.setBounds(625,425,75,50);  
        b1.addActionListener(this); 
    	ImageIcon img=new ImageIcon("C:\\Users\\HAMZA SOHAIL\\eclipse-workspace\\HAMZA1\\src\\icon\\MENU.jpeg");
    	background=new JLabel("AIRLINE",img,JLabel.CENTER);
    	background.setBounds(0,0,1366,768);
    	airline.setForeground(new Color(24,26,27));
    	airline.setFont(new Font("Pacifico",Font.PLAIN,36) );
    	l1.setForeground(new Color(24,26,27));
    	l1.setFont(new Font("Pacifico",Font.PLAIN,25) );
    	l2.setForeground(new Color(24,26,27));
    	l2.setFont(new Font("Pacifico",Font.PLAIN,25) );
    	b1.setFont(new Font("Pacifico",Font.PLAIN,15) );
    	b1.setBackground(new Color(255, 0, 0, 20));
    	b1.setOpaque(false);
    	airline.setBounds(600,225,1000,55);	
        f.add(tf1);f.add(tf2);
        f.add(b1);
    	f.add(l1);f.add(l2); 
        f.add(airline);
    	f.add(background);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH);  
        f.setLayout(null);  
        f.setVisible(true);  
        
   }         
 
public void actionPerformed(ActionEvent e) {  
   
	if(e.getSource()==b1) {
    	try{
            conn c1=new conn();
        
    	String s1=tf1.getText();
    	String s2=tf2.getText();
    	String str="select * from login where username ='"+s1+"'and password ='"+s2+"'";
    	ResultSet rs=c1.s.executeQuery(str);
        if(rs.next()) {
    		new Menupage();
    		//etVisible(false);
    	}
    	else {
    		JOptionPane.showMessageDialog(null,"invalid login");
    		//setVisible(false);
    	}
        }
        catch(Exception ae){
            
        }
    }
    } 

public static void main(String[] args) {  
    new Login();  
}   
}