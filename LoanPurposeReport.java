import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.print.*;
public class LoanPurposeReport extends JDialog implements Printable,ActionListener
{
	Connection con;
		PreparedStatement pst;
		ResultSet rst;
		{
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
			}
			catch(Exception e){}
		}
	JPanel p=new JPanel();
	JLabel loantype = new JLabel("Purpose of Loan");
	JLabel star1 = new JLabel("*");
	JLabel duration = new JLabel("Types Of Relationship");
	JLabel star2 = new JLabel("*");
	JLabel rate = new JLabel("Account number");
	JLabel star3 = new JLabel("*");
	JLabel rate1 = new JLabel("Enter your Account Number with ISD Code");
	JLabel star4 = new JLabel("*");
	String html="<html>I hereby authorize state bank of india and itsrepresentatives to call me email me or sms me to explain the loan & I agree to the Terms and Conditions.</html>";
	  int w = 500;
	JCheckBox check = new JCheckBox(String.format(html, w, w));
	JButton print = new JButton("Print");
	JLabel c1 = new JLabel();
	JLabel c2 = new JLabel();
	JLabel txt1 = new JLabel();
	JLabel txt2 = new JLabel("91");
	JLabel txt3 = new JLabel();
	JPanel pp = null;
	Border thickBorder = new LineBorder(new Color(0,0,160), 5);
	JLabel lb = new JLabel("           LOAN PURPOSE");
	JPanel p1 = new JPanel();
	JLabel green=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green1=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red1=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green2=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red2=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green3=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red3=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel lbll=new JLabel("   Please Enter All The Details");
	String account_no;
	LoanPurposeReport()
	{
		account_no=JOptionPane.showInputDialog(this,"Enter Account Numberr:");
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,800,50);
		p1.setBackground(new Color(0,0,121));
		p1.add(lb);
		lb.setBounds(0,0,800,50);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,800,600);
		p.setLayout(null);
		p.add(loantype);
		p.add(duration);
		p.add(rate);
		p.add(rate1);
		p.add(check);
		p.add(green);
		p.add(red);
		p.add(green1);
		p.add(red1);
		p.add(green2);
		p.add(red2);
		p.add(green3);
		p.add(red3);
		p.add(lbll);
		lbll.setBounds(500,20,250,100);
		lbll.setForeground(Color.RED);
		lbll.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		lbll.setFont(new Font("Arial",Font.BOLD,14));
		lbll.setVisible(false);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,0,121),15));
		p.add(c1);
		p.add(c2);
		p.add(txt1);
		p.add(txt2);
		p.add(txt3);
		p.add(print);
		p.add(star1);
		p.add(star2);
		p.add(star3);
		p.add(star4);
		loantype.setFont(new Font("Arial",Font.BOLD,20));
		print.setFont(new Font("Arial",Font.BOLD,20));
		duration.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,20));
		rate.setFont(new Font("Arial",Font.BOLD,20));
		rate1.setFont(new Font("Arial",Font.BOLD,20));
		txt1.setFont(new Font("Arial",Font.BOLD,20));
		txt2.setFont(new Font("Arial",Font.BOLD,20));
		txt3.setFont(new Font("Arial",Font.BOLD,20));
		star1.setFont(new Font("Arial",Font.BOLD,20));
		star2.setFont(new Font("Arial",Font.BOLD,20));
		star3.setFont(new Font("Arial",Font.BOLD,20));
		star4.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,15));
		star1.setForeground(Color.RED);
		star2.setForeground(Color.RED);
		star3.setForeground(Color.RED);
		star4.setForeground(Color.RED);
		loantype.setForeground(new Color(0,0,121));
		rate1.setForeground(new Color(0,0,121));
		txt2.setForeground(Color.BLACK);
		txt1.setForeground(Color.BLACK);
		txt3.setForeground(Color.BLACK);
		duration.setForeground(new Color(0,0,121));
		rate.setForeground(new Color(0,0,121));
		p.setBackground(Color.WHITE);
		
			
		loantype.setBounds(100,10,250,60);star1.setBounds(260,10,50,50);
		c1.setBounds(100,60,250,40);	
		red1.setBounds(360,60,30,30);
		green1.setBounds(360,60,30,30);	
			

		duration.setBounds(100,110,400,60);star2.setBounds(310,110,50,50);
		c2.setBounds(100,170,250,40);
		red2.setBounds(360,170,30,30);
		green2.setBounds(360,170,30,30);	
		
		rate.setBounds(100,220,300,60);star3.setBounds(260,220,50,50);
		txt1.setBounds(100,280,250,40);
		red3.setBounds(350,280,30,30);
		green3.setBounds(350,280,30,30);

		rate1.setBounds(100,330,500,60);star4.setBounds(500,330,50,50);
		txt2.setBounds(100,390,50,40);
		txt3.setBounds(160,390,300,40);
		red.setBounds(460,390,30,30);
		green.setBounds(460,390,30,30);

		check.setBounds(100,440,670,60);
		print.setBounds(110,505,150,60);
		red.setVisible(false);
		red1.setVisible(false);
		red2.setVisible(false);
		red3.setVisible(false);
		green.setVisible(false);
		green1.setVisible(false);
		green2.setVisible(false);
		green3.setVisible(false);
		try
			{
			pst=con.prepareStatement("select * from purpose where account=?");
				pst.setInt(1,Integer.parseInt(account_no));
				rst=pst.executeQuery();
				if(rst.next())
				{
					c1.setText(rst.getString(1));
					c2.setText(rst.getString(2));
					txt1.setText(rst.getString(3));
					txt3.setText(rst.getString(4));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found","",JOptionPane.INFORMATION_MESSAGE);
					return;	
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
		//setUndecorated(true);
		setSize(815,690);
		setVisible(true);
		check.addActionListener(this);
		check.setEnabled(false);
		print.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)
	{
		print.setVisible(false);
        	PrinterJob printJob = PrinterJob.getPrinterJob();
        	PageFormat pf=printJob.pageDialog(printJob.defaultPage());
          	printJob.setPrintable(this,pf);
          	if (printJob.printDialog()) 
          	{
            try 
            {
               printJob.print();
            } 
            catch (Exception PrintException) 
            {
               PrintException.printStackTrace();
            }
           }
           print.setVisible(true);
	}
	public int print(Graphics g,PageFormat pg,int i) throws PrinterException
	{
    	if(i<0)
        return NO_SUCH_PAGE;
    	Graphics2D g2d=(Graphics2D)g;
    	g2d.translate(pg.getImageableX(),pg.getImageableY());
    	this.printAll(g);
    	return PAGE_EXISTS ;
    }
}
