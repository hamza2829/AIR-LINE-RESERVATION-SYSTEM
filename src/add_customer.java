import java.awt.Color;
import java.util.Random;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class add_customer implements ActionListener {
	JFrame f= new JFrame();
	JLabel customer=new JLabel("Add Customer Details");
	Container c = f.getContentPane();
	Random rand = new Random();
	JTextField f1,f2,f3,f4,f5;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1;
	JRadioButton radiobutton1,radiobutton2;
add_customer(){
	l1=new JLabel("NAME");l1.setBounds(30,130,100,20);
	l1.setFont(new Font("Pianaforma",Font.PLAIN,17) );l1.setForeground(new Color(24,26,27));
    
	l2=new JLabel("ID NUMBER");l2.setBounds(30,180,100,20);
    l2.setFont(new Font("Pianaforma",Font.PLAIN,17) );l2.setForeground(new Color(24,26,27));
    
    l3=new JLabel("PHONE NUMBER");l3.setBounds(30,230,150,20);
	l3.setFont(new Font("Pianaforma",Font.PLAIN,17) );l3.setForeground(new Color(24,26,27));
    
	l4=new JLabel("ADDRESSE");l4.setBounds(30,280,100,20);
    l4.setFont(new Font("Pianaforma",Font.PLAIN,17) );l4.setForeground(new Color(24,26,27));
    
    l5=new JLabel("NATIONALITY");l5.setBounds(30,330,100,20);
	l5.setFont(new Font("Pianaforma",Font.PLAIN,17) );l5.setForeground(new Color(24,26,27));
    
	
    
    f1=new JTextField();f1.setBounds(200,130,200,20);
    
    f2=new JTextField();f2.setBounds(200,180,200,20);
    
    f3=new JTextField();f3.setBounds(200,230,200,20);
    
    f4=new JTextField();f4.setBounds(200,280,200,20);
    
    f5=new JTextField();f5.setBounds(200,330,200,20);
    
    customer.setForeground(new Color(24,26,27));
	customer.setFont(new Font("Pacifico",Font.PLAIN,25) );
	customer.setBounds(270,50,600,55);
    
	radiobutton1=new JRadioButton("Male");    
	radiobutton2=new JRadioButton("Female");
	
	ButtonGroup bg=new ButtonGroup();    
	bg.add(radiobutton1);bg.add(radiobutton2);  
	
	radiobutton1.setBounds(30,380,100,20);
	radiobutton1.setFont(new Font("Verdana",Font.PLAIN,17) );
	radiobutton2.setBounds(150, 380, 150, 20);
	radiobutton2.setFont(new Font("Verdana",Font.PLAIN,17) );
	
	
	 
    b1=new JButton("Add");  
    b1.setBounds(300, 380, 150, 20);
    b1.addActionListener(this);
    f.add(b1);
    f.add(radiobutton1);
    f.add(radiobutton2);
    f.add(l1);
    f.add(l2);
    f.add(l3);f.add(l4);
    f.add(l5);
    f.add(customer);
    f.add(f1);
    f.add(f2);
    f.add(f3);f.add(f4);f.add(f5);
    
    f.setLayout(null); 
    f.setBounds(300,150,800,500); 
    f.setVisible(true);
    
    //c.setBackground(new Color(52,73,94));
}
public void actionPerformed(ActionEvent e) {
	int registration_num=0;
	String id;
	String name=f1.getText();
	String id_num=f2.getText();
	String ph_num=f3.getText();
	String addresse=f4.getText();
	String nationality=f5.getText();
	String gender=null;
	
	 if(radiobutton1.isSelected()){
         gender = "male";

     }else if(radiobutton2.isSelected()){
         gender = "female";
     }
	 
	 try {
         conn c = new conn();
         String str = "INSERT INTO passenger values('"+registration_num+"', '"+name+"', '"+id_num+"', '"+ph_num+"','"+addresse+"', '"+gender+"','"+nationality+"')";
         String str1 = "select registration_num from  passenger where name='"+name+"'and id_num='"+id_num+"' and ph_num='"+ph_num+"'";
         c.s.executeUpdate(str);
         
         ResultSet rs=c.s.executeQuery(str1);
        
         if(rs.next()){
        	 id = rs.getString("registration_num");
        	 JOptionPane.showMessageDialog(null,"Customer Added \n Your registration number is"+id);
        	}
         
         f.setVisible(false);

     } catch (Exception ae) {
         ae.printStackTrace();
 }
}
	

public static void main(String[]args) {
new add_customer();
}


}
