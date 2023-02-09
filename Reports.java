import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;	
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Reports extends JDialog implements ActionListener
{
	JPanel p= new JPanel();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/a11.png",150,150)));;
	JPanel p1=new JPanel();
	JLabel lb = new JLabel("  Reports");
	JPanel pp=null;
	JPanel button=new JPanel();
	JButton customer_details=new JButton("Customer Details",new ImageIcon(ImageResize.resize("img/customer.jpg",180,160)));
	JButton recieve_payment=new JButton("Recieved Payment",new ImageIcon(ImageResize.resize("img/payment.png",180,160)));
	JButton loan_purose=new JButton("Loan Purpose",new ImageIcon(ImageResize.resize("img/Pur1.png",180,160)));
	JButton application=new JButton("Application",new ImageIcon(ImageResize.resize("img/app.png",180,160)));
	Border thickBorder = new LineBorder(new Color(0,162,232), 5);
	JButton back = new JButton("Back");
	JButton add_member1=new JButton("Add Member");
	JButton customer_detail1=new JButton("Customer Details");
	JButton search_details1=new JButton("Search Details");
	JButton logout1=new JButton("Logout");

	Reports()
	{
		setLayout(null);
		add(p);
		p.setLayout(null);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.add(back);
		back.setBounds(1000,20,200,60);
		back.setFont(new Font("Arial",Font.BOLD,30));
		back.setForeground(new Color(0,162,232));
		lb.setBounds(150,50,1350,100);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		p.add(lb1);
		lb1.setBounds(0,30,150,150);
		p.setBounds(0,0,1500,1500);
		p.add(customer_details);
		p.add(recieve_payment);
		p.add(loan_purose);
		p.add(application);
		customer_details.setBounds(500,200,230,220);
		recieve_payment.setBounds(800,200,230,220);
		loan_purose.setBounds(500,450,230,220);
		application.setBounds(800,450,230,220);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));

		customer_details.setBorder(thickBorder);
		loan_purose.setBorder(thickBorder);
		recieve_payment.setBorder(thickBorder);
		application.setBorder(thickBorder);
		
		customer_details.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loan_purose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		recieve_payment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		application.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		customer_details.setFont(new Font("Arial",Font.BOLD,20));
		loan_purose.setFont(new Font("Arial",Font.BOLD,20));
		recieve_payment.setFont(new Font("Arial",Font.BOLD,20));
		application.setFont(new Font("Arial",Font.BOLD,20));
		recieve_payment.setForeground(new Color(0,162,232));
		customer_details.setFont(new Font("Arial",Font.BOLD,20));
		customer_details.setForeground(new Color(0,162,232));
		application.setForeground(new Color(0,162,232));
		loan_purose.setFont(new Font("Arial",Font.BOLD,20));
		loan_purose.setForeground(new Color(0,162,232));

		recieve_payment.setVerticalTextPosition(JButton.BOTTOM);
   		recieve_payment.setHorizontalTextPosition(JButton.CENTER);
		
		 customer_details.setVerticalTextPosition(JButton.BOTTOM);
   		 customer_details.setHorizontalTextPosition(JButton.CENTER);

   		 loan_purose.setVerticalTextPosition(JButton.BOTTOM);
   		 loan_purose.setHorizontalTextPosition(JButton.CENTER);
   		
   		 application.setVerticalTextPosition(JButton.BOTTOM);
   		application.setHorizontalTextPosition(JButton.CENTER);
   		 p.add(button);
   		 button.setBounds(100,200,350,500);
   		 button.setLayout(null);
   		 button.setBackground(Color.WHITE);
   		 button.add(logout1);
   		 button.add(search_details1);
   		 button.add(customer_detail1);
   		 button.add(add_member1);
   		 add_member1.setBounds(30,30,250,60);add_member1.setForeground(new Color(0,162,232));add_member1.setFont(new Font("Arial",Font.BOLD,25));
   		 customer_detail1.setBounds(30,120,250,60);customer_detail1.setForeground(new Color(0,162,232));customer_detail1.setFont(new Font("Arial",Font.BOLD,25));
   		 search_details1.setBounds(30,210,250,60);search_details1.setForeground(new Color(0,162,232));search_details1.setFont(new Font("Arial",Font.BOLD,25));
   		 logout1.setBounds(30,300,250,60);logout1.setForeground(new Color(0,162,232));logout1.setFont(new Font("Arial",Font.BOLD,25));
   		setUndecorated(true);
   		 setVisible(true);
   		 setSize(1500,1500);
   		 p.setBackground(Color.WHITE);
   		 back.addActionListener(this);
		customer_details.addActionListener(this);
		loan_purose.addActionListener(this);
		recieve_payment.addActionListener(this);
		add_member1.addActionListener(this);
		customer_detail1.addActionListener(this);
		search_details1.addActionListener(this);
		logout1.addActionListener(this);
		application.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{
		 if(evt.getSource()==back)
		{
			dispose();			
		}
		else if(evt.getSource()==customer_detail1)
		{
			dispose();
			new CustomerDetails();
		}
		else if(evt.getSource()==search_details1)
		{
			dispose();
			new SearchDetails();
		}
		else if(evt.getSource()==add_member1)
		{
			dispose();
			new LoanApplication();
		}
		else if(evt.getSource()==logout1)
		{
			dispose();
		}
		else if(evt.getSource()==customer_details)
		{
			new CustomerReport();
		}
		else if(evt.getSource()==loan_purose)
		{
			new LoanPurposeReport();
		}
		else if(evt.getSource()==application)
		{
			new ApplicationReport();
		}
		else if(evt.getSource()==recieve_payment)
		{
			new RecievePaymentReport();
		}
	}
}

