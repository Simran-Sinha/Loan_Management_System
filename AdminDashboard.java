import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class AdminDashboard extends JFrame implements ActionListener
{
	JPanel p= new JPanel();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/a11.png",150,150)));;
	JPanel p1=new JPanel();
	JLabel lb = new JLabel("    AdminPortal");
	JPanel pp=null;
	JButton home=new JButton("Add Details",new ImageIcon(ImageResize.resize("img/add.jpg",180,160)));;
	JButton cusdetail=new JButton("Reports",new ImageIcon(ImageResize.resize("img/report.jpg",180,160)));;
	JButton loandetail=new JButton("Customer Details",new ImageIcon(ImageResize.resize("img/customer.jpg",180,160)));;
	JButton emidetail=new JButton("Search Customer",new ImageIcon(ImageResize.resize("img/search.jpg",180,160)));;
	Border thickBorder = new LineBorder(new Color(0,162,232), 5);
	JButton logout = new JButton("Logout");
	String html="<html><center>Welcome to AdminPortal</center></html>";
	int w = 100;
	JLabel wel= new JLabel(String.format(html, w, w));
	AdminDashboard()
	{
		setLayout(null);
		add(p);
		p.setLayout(null);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.add(logout);
		logout.setBounds(1000,20,200,60);
		logout.setFont(new Font("Arial",Font.BOLD,30));
		logout.setForeground(new Color(0,162,232));
		lb.setBounds(150,50,1350,100);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		p.add(lb1);
		lb1.setBounds(0,30,150,150);
		p.setBounds(0,0,1500,1500);
		p.add(wel);
		wel.setBounds(100,200,350,470);
		wel.setFont(new Font("Arial",Font.BOLD,40));
		wel.setForeground(Color.WHITE);
		wel.setBackground(new Color(0,162,232));
		wel.setOpaque(true);
		p.setBackground(Color.WHITE);
		p.add(cusdetail);
		p.add(emidetail);
		p.add(home);
		p.add(loandetail);
		home.setBounds(500,200,230,220);
		loandetail.setBounds(500,450,230,220);
		emidetail.setBounds(800,200,230,220);
		cusdetail.setBounds(800,450,230,220);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));
		home.setBorder(thickBorder);
		 cusdetail.setBorder(thickBorder);
		loandetail.setBorder(thickBorder);
		 emidetail.setBorder(thickBorder);
		 home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cusdetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loandetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		emidetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setFont(new Font("Arial",Font.BOLD,20));
		home.setForeground(new Color(0,162,232));
		cusdetail.setFont(new Font("Arial",Font.BOLD,20));
		cusdetail.setForeground(new Color(0,162,232));
		loandetail.setFont(new Font("Arial",Font.BOLD,20));
		loandetail.setForeground(new Color(0,162,232));
		emidetail.setFont(new Font("Arial",Font.BOLD,20));
		emidetail.setForeground(new Color(0,162,232));
		home.setVerticalTextPosition(JButton.BOTTOM);
   		home.setHorizontalTextPosition(JButton.CENTER);
   		cusdetail.setVerticalTextPosition(JButton.BOTTOM);
   		cusdetail.setHorizontalTextPosition(JButton.CENTER);
		loandetail.setVerticalTextPosition(JButton.BOTTOM);
   		loandetail.setHorizontalTextPosition(JButton.CENTER);
   		emidetail.setVerticalTextPosition(JButton.BOTTOM);
   		emidetail.setHorizontalTextPosition(JButton.CENTER);
   		setUndecorated(true);
   		setVisible(true);
   		setSize(1500,1500);
		cusdetail.addActionListener(this);
		home.addActionListener(this);		
		loandetail.addActionListener(this);
		emidetail.addActionListener(this);
		logout.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==loandetail)
		{
			new CustomerDetails();
		}
		else if(evt.getSource()==emidetail)
		{
			new SearchDetails();		
		}
		else if(evt.getSource()==home)
		{
			new LoanApplication();		
		}
		else if(evt.getSource()==cusdetail)
		{
			new Reports();		
		}
		else if(evt.getSource()==logout)
		{
			dispose();
			new Start();
		}
	}
	public static void main(String ar[])
	{
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            
        }
		new AdminDashboard();
	}
	}


