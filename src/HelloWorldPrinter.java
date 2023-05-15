import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloWorldPrinter implements Printable, ActionListener {
	
	

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
        String src="1";
        String dst="KARACHI";
        String str = "select  Ticket_id,registration_num,name, flight_code,class,source,destination,date_time, price from Ticket where registration_num = '"+src+"'";
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
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        g.drawString(Ticket_id, 70, 100);
        g.drawString(registration_num, 140, 100);
        g.drawString(name, 210, 100);
        g.drawString(flight_code, 280, 100);
        g.drawString(class1, 350, 100);
        g.drawString(source, 420, 100);
        g.drawString(destination, 490, 100);
        g.drawString(date_time, 560, 100);
        g.drawString(price, 630, 100);
        
        
        

        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==b3) {
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

    public static void main(String args[]) {
 
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Hello World Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JButton printButton = new JButton("Print Hello World");
        printButton.addActionListener(new HelloWorldPrinter());
        f.add("Center", printButton);
        f.pack();
        f.setVisible(true);
    }
}