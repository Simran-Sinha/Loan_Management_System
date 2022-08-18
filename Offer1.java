import java.awt.*;
import javax.swing.*;
//import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class Offer1 extends JDialog implements ActionListener
{
	Connection con;
		PreparedStatement pst;
		ResultSet rst;
		{
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
			}
			catch(Exception e){}
	
	}

	JPanel p=new JPanel();
	JPanel p1 = new JPanel();
	JButton apply= new JButton("Apply Now");
	JLabel pic1 = new JLabel(new ImageIcon(ImageResize.resize("img/homeloan.png",600,400)));;
	Border thickBorder = new LineBorder(new Color(0,0,160), 5);
	JLabel lb = new JLabel("           LOAN OFFER");
	JLabel lb1 = new JLabel("1. Special rates for women Customers");
	JLabel lb2 = new JLabel("2. Loan to Value Ratio is 90%.");
	JLabel lb3 = new JLabel("3. EMI of Rs. 769 per lakh");
	JLabel lb4 = new JLabel("4. Tenure of loan is between 5 to 30 years.");
	JButton b1 = new JButton("For More Details");	
	Offer1()
	{
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
		Border thickBorder = new LineBorder(new Color(0,0,160), 5);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,0,121),10));
		p.setBounds(0,50,900,700);
		p.setLayout(null);
		p.add(pic1);
		p.add(lb1);
		p.add(lb2);
		p.add(lb3);
		p.add(lb4);
		p.add(b1);
		p.add(apply);
		p.setBackground(Color.WHITE);
		apply.setBounds(290,570,200,45);
		b1.setBounds(700,10,180,50);
		lb1.setBounds(50,460,500,60);
		lb2.setBounds(50,510,500,60);
		lb3.setBounds(480,460,500,60);
		lb4.setBounds(480,510,500,60);
		pic1.setBounds(50,50,600,400);
		lb1.setFont(new Font("Arial",Font.BOLD,20));
		b1.setFont(new Font("Arial",Font.BOLD,15));
		lb2.setFont(new Font("Arial",Font.BOLD,20));
		lb3.setFont(new Font("Arial",Font.BOLD,20));
		lb4.setFont(new Font("Arial",Font.BOLD,20));
		apply.setFont(new Font("Arial",Font.BOLD,30));
		lb1.setForeground(new Color(0,0,121));
		lb2.setForeground(new Color(0,0,121));
		lb3.setForeground(new Color(0,0,121));
		lb4.setForeground(new Color(0,0,121));
		setLocation(390,10);
		//setUndecorated(true);
		setVisible(true);
		setSize(900,710);
		apply.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)
	{

		if(evt.getSource()==apply)
		{
			dispose();
			new Application();		
				
		}
		
	}
	public static void main(String []args)
	{
		new Offer1();
	}
}		