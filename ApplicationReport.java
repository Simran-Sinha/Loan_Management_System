import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.print.*;
public class ApplicationReport extends JDialog implements Printable,ActionListener
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
	JLabel loantype = new JLabel("Nature of Loan");
	JLabel star1 = new JLabel("*");
	JLabel duration = new JLabel("Full Name as per PAN Card");
	JLabel star2 = new JLabel("*");
	JLabel rate = new JLabel("Mobile Number");
	JLabel star3 = new JLabel("*");
	JLabel rate1 = new JLabel("Net Monthly Income");
	JLabel star4 = new JLabel("*");
	JLabel resi = new JLabel("PLace of Current Residence or pincode");
	JLabel star5 = new JLabel("*");
	JLabel amt = new JLabel("Loan Amount Needed");
	JLabel star6 = new JLabel("*");
	String html="<html>I hereby authorize state bank of india and itsrepresentatives to call me email me or sms me to explain the loan & I agree to the Terms and Conditions.</html>";
	int w = 500;
	JCheckBox check = new JCheckBox(String.format(html, w, w));
	JButton print = new JButton("Print");
	JLabel txt1 = new JLabel();
	JLabel txt2 = new JLabel("+91");
	JLabel txt3 = new JLabel("");
	JLabel txt4 = new JLabel("");
	JLabel txt5 = new JLabel("");
	JLabel txt6 = new JLabel("");
	JLabel txt7 = new JLabel("");
	JRadioButton r1 = new JRadioButton("New Loan");
	JRadioButton r2 = new JRadioButton("Balance Transfer");
	JPanel pp = null;
	Border thickBorder = new LineBorder(new Color(0,0,160), 5);
	JLabel lb = new JLabel("                      COMPLETE ApplicationReport");
	JPanel p1 = new JPanel();
	JLabel pic1 = new JLabel(new ImageIcon(ImageResize.resize("img/user1.png",50,50)));;
	JLabel pic2 =  new JLabel(new ImageIcon(ImageResize.resize("img/month.png",50,50)));;
	JLabel pic5 =  new JLabel(new ImageIcon(ImageResize.resize("img/mob.png",50,50)));;
	JLabel pic4 =  new JLabel(new ImageIcon(ImageResize.resize("img/loan5.png",50,50)));;
	JLabel pic3 =  new JLabel(new ImageIcon(ImageResize.resize("img/location1.jpg",50,50)));;
	JLabel green=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green1=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red1=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green2=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red2=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green3=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red3=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green4=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red4=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel green5=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red5=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel lbll=new JLabel("   Please Enter All The Details");
	String mobile_no;
	ApplicationReport()
	{
		mobile_no=JOptionPane.showInputDialog(this,"Enter Mobile Numberr:");
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,900,50);
		p1.setBackground(new Color(0,0,121));
		p1.add(lb);
		lb.setBounds(0,0,900,50);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,900,800);
		p.setLayout(null);
		p.add(loantype);
		p.add(duration);
		p.add(rate);
		p.add(rate1);
		p.add(resi);
		p.add(amt);
		p.add(check);
		p.add(pic1);
		p.add(pic2);
		p.add(pic3);
		p.add(pic4);
		p.add(pic5);
		p.add(green);
		p.add(red);
		p.add(green1);
		p.add(red1);
		p.add(green2);
		p.add(red2);
		p.add(green3);
		p.add(red3);
		p.add(green4);
		p.add(red4);
		p.add(green5);
		p.add(red5);
		p.add(txt1);
		p.add(r1);
		p.add(r2);
		p.add(txt2);
		p.add(txt3);
		p.add(txt4);
		p.add(txt5);
		p.add(txt6);
		p.add(txt7);
		p.add(print);
		p.add(star1);
		p.add(star2);
		p.add(star3);
		p.add(star4);
		p.add(star5);
		p.add(star6);
		p.add(lbll);
		lbll.setBounds(630,20,250,100);
		lbll.setForeground(Color.RED);
		lbll.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		lbll.setFont(new Font("Arial",Font.BOLD,14));
		lbll.setVisible(false);
		loantype.setFont(new Font("Arial",Font.BOLD,20));
		print.setFont(new Font("Arial",Font.BOLD,20));
		r1.setFont(new Font("Arial",Font.BOLD,20));
		r2.setFont(new Font("Arial",Font.BOLD,20));
		duration.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,20));
		rate.setFont(new Font("Arial",Font.BOLD,20));
		rate1.setFont(new Font("Arial",Font.BOLD,20));
		resi.setFont(new Font("Arial",Font.BOLD,20));
		amt.setFont(new Font("Arial",Font.BOLD,20));
		txt1.setFont(new Font("Arial",Font.BOLD,15));
		txt2.setFont(new Font("Arial",Font.BOLD,15));
		txt3.setFont(new Font("Arial",Font.BOLD,15));
		txt4.setFont(new Font("Arial",Font.BOLD,15));
		txt5.setFont(new Font("Arial",Font.BOLD,15));
		txt6.setFont(new Font("Arial",Font.BOLD,15));
		txt7.setFont(new Font("Arial",Font.BOLD,15));
		star1.setFont(new Font("Arial",Font.BOLD,20));
		star2.setFont(new Font("Arial",Font.BOLD,20));
		star3.setFont(new Font("Arial",Font.BOLD,20));
		star4.setFont(new Font("Arial",Font.BOLD,20));
		star5.setFont(new Font("Arial",Font.BOLD,20));
		star6.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,15));
		star1.setForeground(Color.RED);
		star2.setForeground(Color.RED);
		star3.setForeground(Color.RED);
		star4.setForeground(Color.RED);
		star5.setForeground(Color.RED);
		star6.setForeground(Color.RED);
		loantype.setForeground(new Color(0,0,121));
		rate1.setForeground(new Color(0,0,121));
		txt2.setForeground(Color.GRAY);
		txt1.setForeground(Color.GRAY);
		txt3.setForeground(Color.GRAY);
		txt4.setForeground(Color.GRAY);
		txt5.setForeground(Color.GRAY);
		txt6.setForeground(Color.GRAY);
		txt7.setForeground(Color.GRAY);
		duration.setForeground(new Color(0,0,121));
		rate.setForeground(new Color(0,0,121));
		resi.setForeground(new Color(0,0,121));
		amt.setForeground(new Color(0,0,121));
		p.setBackground(Color.WHITE);
		duration.setBounds(200,100,400,50);star1.setBounds(460,100,50,50);
		txt5.setBounds(200,150,370,40);	
		red5.setBounds(570,150,30,30);
		green5.setBounds(570,150,30,30);
		pic1.setBounds(150,150,50,50);
		loantype.setBounds(200,10,400,60);star2.setBounds(350,10,50,50);
		r1.setBounds(200,50,150,40);
		r2.setBounds(400,50,200,40);
		red.setBounds(600,50,30,30);
		green.setBounds(600,50,30,30);
		rate.setBounds(200,200,400,50);star3.setBounds(350,200,50,50);
		txt2.setBounds(200,250,60,40);
		txt4.setBounds(270,250,300,40);
		red1.setBounds(570,250,30,30);
		green1.setBounds(570,250,30,30);
		pic5.setBounds(150,250,50,50);
		rate1.setBounds(200,300,500,50);star4.setBounds(390,300,50,50);
		pic2.setBounds(150,350,50,50);
		txt3.setBounds(200,350,370,40);	
		red2.setBounds(570,350,30,30);
		green2.setBounds(570,350,30,30);
		resi.setBounds(200,400,400,50);star5.setBounds(570,400,50,50);
		txt6.setBounds(200,450,370,40);
		red3.setBounds(570,450,30,30);
		green3.setBounds(570,450,30,30);
		amt.setBounds(200,500,400,50);star6.setBounds(410,500,50,50);
		txt7.setBounds(200,550,370,40);
		red4.setBounds(570,550,30,30);
		green4.setBounds(570,550,30,30);
		pic3.setBounds(150,450,50,50);
		pic4.setBounds(150,550,50,40);
		check.setBounds(30,590,700,60);
		print.setBounds(740,590,100,60);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,0,121),20));
		red.setVisible(false);
		red1.setVisible(false);
		red2.setVisible(false);
		red3.setVisible(false);
		red4.setVisible(false);
		red5.setVisible(false);
		green.setVisible(false);
		green1.setVisible(false);
		green2.setVisible(false);
		green3.setVisible(false);
		green4.setVisible(false);
		green5.setVisible(false);
		try
			{
			pst=con.prepareStatement("select * from compapp where mobile=?");
				pst.setInt(1,Integer.parseInt(mobile_no));
				rst=pst.executeQuery();
				if(rst.next())
				{
					String loan=rst.getString("Nature");
					if(loan.equals("New Loan"))
						r1.setSelected(true);
					else if(loan.equals("Balance Transfer"))
						r2.setSelected(true);
				txt5.setText(rst.getString(2));
				txt4.setText(rst.getString(3));
				txt3.setText(rst.getString(4));
				txt6.setText(rst.getString(5));
				txt7.setText(rst.getString(6));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found","",JOptionPane.INFORMATION_MESSAGE);		
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
		
		setSize(915,750);
		setVisible(true);
		//setUndecorated(true);
		check.setEnabled(false);
		print.addActionListener(this);
		check.addActionListener(this);
		
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
    public static void main(String ar[])
	{
		new ApplicationReport();
	}
}