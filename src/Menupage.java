import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
public class Menupage  implements ActionListener {
	JFrame frame=new JFrame("Air Line Reservation System");
    Container c = frame.getContentPane();
    JMenuBar mb=new JMenuBar();
    JButton Flight_Information,Add_Customer_Details,Journey_Details,Payment_Details,Canelation;
    JLabel background;
	Menupage(){
		        frame.setTitle("Air Line Reservation System");
				frame.setLayout(null);
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//c.setBackground(new Color(30,33,41));
				
				Flight_Information=new JButton("Print_Ticket");
				Flight_Information.addActionListener(this);
				Flight_Information.setFont(new Font("Pacifico",Font.PLAIN,15) );
				Flight_Information.setOpaque(false);
				Flight_Information.setBackground(new Color(255, 0, 0, 20));
				Add_Customer_Details=new JButton("Add_Customer_Details");
				Add_Customer_Details.addActionListener(this);
				Add_Customer_Details.setOpaque(false);
				Add_Customer_Details.setBackground(new Color(255, 0, 0, 20));
				Add_Customer_Details.setFont(new Font("Pacifico",Font.PLAIN,15) );
				Journey_Details=new JButton("Journey_Details");
				Journey_Details.addActionListener(this);
				Journey_Details.setFont(new Font("Pacifico",Font.PLAIN,15) );
				Journey_Details.setOpaque(false);
				Journey_Details.setBackground(new Color(255, 0, 0, 20));
				Payment_Details=new JButton("Payment_Details");
				Payment_Details.addActionListener(this);
				Payment_Details.setFont(new Font("Pacifico",Font.PLAIN,15) );
				Payment_Details.setOpaque(false);
				Payment_Details.setBackground(new Color(255, 0, 0, 20));
				Canelation=new JButton("Cancelation");
				Canelation.addActionListener(this);
				Canelation.setFont(new Font("Pacifico",Font.PLAIN,15) );
				Canelation.setOpaque(false);
				Canelation.setBackground(new Color(255, 0, 0, 20));
				mb.add(Add_Customer_Details);mb.add(Journey_Details);mb.add(Payment_Details);mb.add(Canelation);mb.add(Flight_Information);
				//mb.setBackground(new Color(30,33,41));
				mb.setForeground(new Color(30,33,41));
				//mb.setBorder(BorderFactory.createLineBorder(new Color(30,33,41)));
				ImageIcon img=new ImageIcon("C:\\Users\\HAMZA SOHAIL\\eclipse-workspace\\HAMZA1\\src\\icon\\vv.jpeg");
		    	background=new JLabel("",img,JLabel.CENTER);
		    	background.setBounds(0,0,1366,768);
		    	frame.add(background);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setJMenuBar(mb); 
		        frame.setLayout(null);  
		        frame.setVisible(true);  
		       

}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==Flight_Information) {
		flight_info h=new flight_info();
		h.format();
	}
	else if(e.getSource()==Add_Customer_Details) {
		new add_customer();
	}
	else if(e.getSource()==Journey_Details) {
		new Journey_details();
	}
	else if(e.getSource()==Payment_Details) {
		new payment_details();
	}
	else if(e.getSource()==Canelation) {
		new cancelation();
	}
}
public static void main(String[]args) {
	new Menupage();
}
}
