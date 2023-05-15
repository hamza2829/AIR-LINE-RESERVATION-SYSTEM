import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;
public class Journey_details implements ActionListener{
	JButton b1; 
    JLabel l1,l2,flight_code,class1,source,destination,date_time,price;
    JFrame f= new JFrame();
	JLabel airline=new JLabel("JOURNEY DETAILS");
	JComboBox combo1,combo2;
	JTable table;
Journey_details(){
	 l1=new JLabel("SOURCE");l1.setBounds(150, 100, 150, 27);
	 l1.setFont(new Font("Pacifico",Font.PLAIN,19) );l1.setForeground(new Color(24,26,27));
     
	 l2=new JLabel("DESTINATION");l2.setBounds(450, 100, 150, 27);
     l2.setFont(new Font("Pacifico",Font.PLAIN,19) );l2.setForeground(new Color(24,26,27));
     
     flight_code=new JLabel("flight_code");flight_code.setBounds(79, 270, 83, 20);
     flight_code.setFont(new Font("Tahoma",Font.PLAIN,17) );flight_code.setForeground(new Color(24,26,27));
     
     class1=new JLabel("class");class1.setBounds(200, 270, 71, 20);
     class1.setFont(new Font("Tahoma",Font.PLAIN,17) );class1.setForeground(new Color(24,26,27));
     
     source=new JLabel("source");source.setBounds(297, 270, 103, 20);
     source.setFont(new Font("Tahoma",Font.PLAIN,17) );source.setForeground(new Color(24,26,27));
     
     destination=new JLabel("destination");destination.setBounds(390, 270, 94, 20);
     destination.setFont(new Font("Tahoma",Font.PLAIN,17) );destination.setForeground(new Color(24,26,27));
     
     date_time=new JLabel("date_time");date_time.setBounds(494, 270, 83, 20);
     date_time.setFont(new Font("Tahoma",Font.PLAIN,17) );date_time.setForeground(new Color(24,26,27));
     
     price=new JLabel("price");price.setBounds(613, 270, 94, 20);
     price.setFont(new Font("Tahoma",Font.PLAIN,17) );price.setForeground(new Color(24,26,27));
     
     b1=new JButton("show");  
     b1.setBounds(300, 200, 100, 30);  
     b1.addActionListener(this);
     
     airline.setForeground(new Color(24,26,27));
 	 airline.setFont(new Font("Pacifico",Font.PLAIN,25) );
 	 airline.setBounds(300,50,600,55);	
 	 
 	 String[] src= {"KARACHI","LAHORE","ISLAMABAD"};
 	 combo1=new JComboBox(src);
 	 combo1.setBounds(250, 100, 150, 27);
 	 
 	 String[] src1= {"KARACHI","LAHORE","ISLAMABAD"};
	 combo2=new JComboBox(src);
	 combo2.setBounds(600, 100, 150, 27);
	 
	 table = new JTable();
     table.setBounds(38, 310, 770,130 );
 
     f.add(table);f.add(l1);f.add(l2);f.add(flight_code);f.add(class1);f.add(source);f.add(destination);f.add(date_time);f.add(price);
     f.add(airline);f.add(b1);f.setBounds(250,50,860,600);
     f.add(combo1);f.add(combo2);
     f.setLayout(null);  
     f.setVisible(true); 
     
     
}

@Override
public void actionPerformed(ActionEvent e) {
	
	try{
        String src  = (String) combo1.getSelectedItem();
        String dst  = (String) combo2.getSelectedItem();

        conn c = new conn();

        String str = "select flight_code,class,source,destination,date_time,price from flight where source = '"+src+"' and destination = '"+dst+"'";
        ResultSet rs=c.s.executeQuery(str);
        
      
            table.setModel(DbUtils.resultSetToTableModel(rs));
        				


}catch(Exception ae){
	JOptionPane.showMessageDialog(null,"No Flightsbetween Source and Destination");
}

}
public static void main(String[]args) {
new Journey_details();
}
}
