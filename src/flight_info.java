import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class flight_info implements Printable, ActionListener {
	static JTextField f1;
    static JFrame f = new JFrame("Ticket printing");
    static JLabel l1=new JLabel("Enter your registration  Number");
    static JButton b3 = new JButton("Print your ticket");
    
   public void format() {
		
		 f.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {System.exit(0);}
	      });
	       
		 b3.setBounds(620, 430, 150, 20);
	     f1=new JTextField();f1.setBounds(300, 200, 200, 20);
	     l1.setFont(new Font("Pianaforma",Font.PLAIN,20) );
	     l1.setBounds(300, 70, 400, 200);
	     b3.addActionListener(new flight_info());
	     f.add("Center",b3);f.add(l1);f.add(f1);
	    // f.pack();
	     f.setLayout(null); 
	     f.setBounds(300,150,800,500);
	     f.setVisible(true);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

public static void main(String args[]) {
	new flight_info();
	
        
    }

    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) { 
            return NO_SUCH_PAGE;
        }

       
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        conn c = new conn();
        
        String Ticket_id = null;
        String registration_num = null;
        String name = null;
        String flight_code = null;
        String class1 = null;
        String source = null;
        String destination = null;
        String date_time = null;
        String price = null;
        String payement_method= null;
        String reg=f1.getText();
       
        String str = "select  *from Ticket where  registration_num = '"+reg+"'";
        try {
			ResultSet rs=c.s.executeQuery(str);
			
			while (rs.next()) {
				Ticket_id = rs.getString("Ticket_id"); // you can use column name or index
				registration_num = rs.getString("registration_num");
				name = rs.getString("name");
				flight_code = rs.getString("flight_code");
				class1 = rs.getString("class");
				source = rs.getString("source");
				destination = rs.getString("destination");
				date_time = rs.getString("date_time");
				price = rs.getString("price");
				payement_method = rs.getString("payement_method");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        g.drawString("****************************************************************\nAIR ALPHA WELCOMES YOU\n**************************************************************************************",00, 70);
        g.drawString(Ticket_id, 10, 100);
        g.drawString(registration_num, 60, 100);
        g.drawString(name, 110, 100);
        g.drawString(flight_code, 160, 100);
        g.drawString(class1, 220, 100);
        g.drawString(source, 270, 100);
        g.drawString(destination, 370, 100);
        g.drawString(date_time, 450, 100);
        g.drawString(price, 580, 100);
        g.drawString(payement_method, 680, 100);
        
        

        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
    	
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              
             }
         }
    }
    
    

    
}