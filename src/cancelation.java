import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cancelation implements ActionListener {
	JTextField tf1;
    JButton b1; 
    JLabel l1,l2;
    JFrame f= new JFrame();
cancelation(){
	l1=new JLabel("CANCELATION");l1.setBounds(330,20,150,50);f.add(l1);
	l1.setFont(new Font("Pianaforma",Font.PLAIN,25) );l1.setForeground(new Color(24,26,27));
    
	l2=new JLabel("ID NUMBER");l2.setBounds(250,130,100,20);f.add(l2);
    l2.setFont(new Font("Pianaforma",Font.PLAIN,17) );l2.setForeground(new Color(24,26,27));
    
    tf1=new JTextField();tf1.setBounds(350,130,200,20);f.add(tf1);
    
    
    b1=new JButton("REMOVE");  b1.setBounds(350,200,100,50);  
    b1.setFont(new Font("Pianaforma",Font.PLAIN,17) );b1.setForeground(new Color(24,26,27));
    b1.addActionListener(this); f.add(b1);
    f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    f.setLayout(null); 
    f.setBounds(300,150,800,500); 
    f.setVisible(true);
    
    
}

@Override
public void actionPerformed(ActionEvent e) {
	
    	try{
        conn c1=new conn();
        
    	String reg=tf1.getText();
    	
    	String str="DELETE FROM Ticket WHERE registration_num = '"+reg+"'";
    	 c1.s.executeUpdate(str);
    	 
    	 
     		
     		JOptionPane.showMessageDialog(null,"Customer removed");     	
     
     		//JOptionPane.showMessageDialog(null,"invalid login");
     		//setVisible(false);
     	
}
        
        catch(Exception ae){
        	 ae.printStackTrace();
        }
    
    }
public static void main(String[]args) {
new cancelation();
}
	
}

