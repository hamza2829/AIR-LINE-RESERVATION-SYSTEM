import java.awt.Color;

import java.util.Random;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.print.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class payment_details implements ActionListener {
	JFrame f= new JFrame();
	JLabel customer=new JLabel("Ticket Booking");
	Container c = f.getContentPane();
	JTextField f1,f2,f3,f4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,flight_code,class1,source,destination,date_time,price,gender,nationality,name;
	JButton b1,b2; 
	JRadioButton radiobutton1,radiobutton2;
	JTable table,table1;
payment_details(){
	
	//labels for text field
	l1=new JLabel("REGISTRATION NUMBER");l1.setBounds(30,100,180,20);
	l1.setFont(new Font("Pianaforma",Font.PLAIN,17) );l1.setForeground(new Color(24,26,27));
    
    l2=new JLabel("FLIGHT CODE");l2.setBounds(30,150,100,20);
	l2.setFont(new Font("Pianaforma",Font.PLAIN,17) );l2.setForeground(new Color(24,26,27));
    
	l3=new JLabel("FLIGHT CLASS");l3.setBounds(30,200,100,20);
    l3.setFont(new Font("Pianaforma",Font.PLAIN,17) );l3.setForeground(new Color(24,26,27));
    
    name=new JLabel("NAME");name.setBounds(430,100,200,20);
	name.setFont(new Font("Pianaforma",Font.PLAIN,17) );name.setForeground(new Color(24,26,27));
    
  //labels for flight information
    
    l4=new JLabel("flight code");l4.setBounds(20,300,100,20);
	l4.setFont(new Font("Pianaforma",Font.PLAIN,17) );l4.setForeground(new Color(24,26,27));
    
	l5=new JLabel("class");l5.setBounds(140,300,100,20);
    l5.setFont(new Font("Pianaforma",Font.PLAIN,17) );l5.setForeground(new Color(24,26,27));
    
    l6=new JLabel("source");l6.setBounds(260,300,150,20);
	l6.setFont(new Font("Pianaforma",Font.PLAIN,17) );l6.setForeground(new Color(24,26,27));
    
	l7=new JLabel("destination");l7.setBounds(375,300,100,20);
    l7.setFont(new Font("Pianaforma",Font.PLAIN,17) );l7.setForeground(new Color(24,26,27));
    
    l8=new JLabel("date_time");l8.setBounds(490,300,100,20);
	l8.setFont(new Font("Pianaforma",Font.PLAIN,17) );l8.setForeground(new Color(24,26,27));
	
	 price=new JLabel("price");price.setBounds(605, 300, 94, 20);
     price.setFont(new Font("Pianaforma",Font.PLAIN,17) );price.setForeground(new Color(24,26,27));
	
     //labels for customer information
 
	 flight_code=new JLabel("reg_number");flight_code.setBounds(20, 350, 150, 20);
     flight_code.setFont(new Font("Pianaforma",Font.PLAIN,17) );flight_code.setForeground(new Color(24,26,27));
     
     class1=new JLabel(" name");class1.setBounds(120, 350, 71, 20);
     class1.setFont(new Font("Pianaforma",Font.PLAIN,17) );class1.setForeground(new Color(24,26,27));
     
     source=new JLabel(" id_num");source.setBounds(220, 350, 103, 20);
     source.setFont(new Font("Pianaforma",Font.PLAIN,17) );source.setForeground(new Color(24,26,27));
     
     destination=new JLabel(" ph_num");destination.setBounds(330, 350, 94, 20);
     destination.setFont(new Font("Pianaforma",Font.PLAIN,17) );destination.setForeground(new Color(24,26,27));
     
     date_time=new JLabel("addresse");date_time.setBounds(420, 350, 83, 20);
     date_time.setFont(new Font("Pianaforma",Font.PLAIN,17) );date_time.setForeground(new Color(24,26,27));
     
     gender=new JLabel("gender");gender.setBounds(530, 350, 83, 20);
     gender.setFont(new Font("Pianaforma",Font.PLAIN,17) );gender.setForeground(new Color(24,26,27));
     
     nationality=new JLabel(" nationality");nationality.setBounds(630, 350, 83, 20);
     nationality.setFont(new Font("Pianaforma",Font.PLAIN,17) );nationality.setForeground(new Color(24,26,27));
     
     
    
    
    
    f1=new JTextField();f1.setBounds(200,100,200,20);
    
    f2=new JTextField();f2.setBounds(500,100,200,20);
    
    f3=new JTextField();f3.setBounds(200,150,200,20);
    
    f4=new JTextField();f4.setBounds(200,200,200,20);
    
    customer.setForeground(new Color(24,26,27));
   	customer.setFont(new Font("Pacifico",Font.PLAIN,25) );
   	customer.setBounds(300,30,600,55);
   	
   	radiobutton1=new JRadioButton("Cash");    
	radiobutton2=new JRadioButton("Debit");
	
	ButtonGroup bg=new ButtonGroup();    
	bg.add(radiobutton1);bg.add(radiobutton2);  
	
	radiobutton1.setBounds(30,250,100,20);
	radiobutton1.setFont(new Font("Verdana",Font.PLAIN,17) );
	radiobutton2.setBounds(200, 250, 150, 20);
	radiobutton2.setFont(new Font("Verdana",Font.PLAIN,17) );
	
	b1=new JButton("Add");  
    b1.setBounds(620, 430, 150, 20);
    b1.addActionListener(this);
    
    b2=new JButton("SHOW DETAILS");  
    b2.setBounds(400, 250, 150, 20);
    b2.addActionListener(this);
    
    table = new JTable();
    table.setBounds(20, 330, 700,20 );
    
    table1 = new JTable();
    table1.setBounds(20, 380, 700,20 );

    
    f.add(b1);f.add(b2);
    f.add(radiobutton1);f.add(radiobutton2);
    f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);f.add(flight_code);f.add(class1);f.add(source);f.add(destination);f.add(date_time);f.add(price);f.add(gender);f.add(nationality);f.add(name);
    f.add(customer);
    f.add(f1);f.add(f3);f.add(f4);f.add(f2);
    f.add(table); f.add(table1);
    
    f.setLayout(null); 
    f.setBounds(300,150,800,500); 
    f.setVisible(true);
	
}
public static void main(String[]args) {
new payment_details();
}
@Override
public void actionPerformed(ActionEvent e) {

	if(e.getSource()==b2) {
	try{
		int Ticket_num=0;
        String reg  = f1.getText();
        String flight_code  = f3.getText();
        String flight_class  = f4.getText();
      
        

        conn c = new conn();

        
        
        String str1 = "select flight_code,class,source,destination,date_time,price from flight where  flight_code = '"+flight_code+"' and class = '"+flight_class+"'";
        ResultSet rs1=c.s.executeQuery(str1);
        table.setModel(DbUtils.resultSetToTableModel(rs1));
        
        String str = "select registration_num,name,id_num,ph_num,addresse,gender,nationality from passenger where registration_num =  '"+reg+"' ";
        ResultSet rs=c.s.executeQuery(str);
        table1.setModel(DbUtils.resultSetToTableModel(rs));
        
        
       				


}catch(Exception ae){
	
}

	

}
	if(e.getSource()==b1) {
		
        try {
        	int Ticket_num=0000;
        	String name=f2.getText();
            String reg  = f1.getText();
            String flight_code  = f3.getText();
            String flight_class  = f4.getText();
            String source = null;
            String destination = null;
            String date_time = null;
            String price = null;
            
            String payement_method=null;
            
            if(radiobutton1.isSelected()){
            	payement_method = "Cash";

            }else if(radiobutton2.isSelected()){
            	payement_method = "Debit";
            }
            

            conn c = new conn();
    		
            String str = "select source,destination,date_time,price from flight where flight_code = '"+flight_code+"' and class = '"+flight_class+"'";
            try {
    			ResultSet rs=c.s.executeQuery(str);
    			
    			while (rs.next()) {
    			   source = rs.getString("source"); // you can use column name or index
    			   destination = rs.getString("destination");
    			   date_time = rs.getString("date_time");
    			   price = rs.getString("price");
    			}
    		} catch (SQLException g) {
    			// TODO Auto-generated catch block
    			g.printStackTrace();
    		}
    		String str2 = "INSERT INTO Ticket values('"+Ticket_num+"', '"+reg+"','"+name+"', '"+flight_code+"', '"+flight_class+"','"+source+"','"+destination+"','"+date_time+"','"+price+"','"+payement_method+"')";
    		//String str4="INSERT INTO Ticket ('"+Ticket_num+"', '"+reg+"', '"+flight_code+"', '"+flight_class+"',source,  destination, date_time, price) SELECT source,destination, date_time,price FROM flight WHERE  flight_code='"+flight_code+"'and class='"+flight_class+"'";
            //String str3 = "select Ticket_id from  Ticket where registration_num='"+reg+"'and  flight_code='"+flight_code+"' and class='"+flight_class+"'";
			c.s.executeUpdate(str2);
			//c.s.executeUpdate(str4);
			 //
			
			
			
			
			
			
			
				//ResultSet rs2=c.s.executeQuery(str3);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
       
	}
}
}