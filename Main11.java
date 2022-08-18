import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Main11 extends JDialog implements ActionListener
{
	JPanel p= new JPanel();
	JLabel lb1=new JLabel("State Bank of India");
	JLabel lb=new JLabel(new ImageIcon(ImageResize.resize("img/sbilogo.png",700,130)));;
	JPanel p1=new JPanel();
	JLabel lb2=new JLabel(new ImageIcon(ImageResize.resize("img/car11.jpg",1100,420)));;
	
	 
	 JButton logout = new JButton(" SBI Application");
	  JButton logout1 = new JButton("More Details");
	Main11()
	{
		setLayout(null);
		add(p);
		p.setLayout(null);
		//p.add(p1);
		//p1.setBounds(150,50,1350,100);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.add(logout);
		lb.add(logout1);
		logout.setBounds(1100,20,230,45);
		logout.setFont(new Font("Arial",Font.BOLD,25));
		logout.setForeground(new Color(0,162,232));
		logout1.setBounds(1100,80,230,45);
		logout1.setFont(new Font("Arial",Font.BOLD,25));
		logout1.setForeground(new Color(0,162,232));
		lb.setBounds(5,50,1350,130);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		//p.add(lb1);
		p.add(lb2);
		lb1.setBounds(50,30,1000,150);
		lb2.setBounds(100,230,1100,430);
		lb1.setFont(new Font("Arial",Font.BOLD,50));
		lb1.setBackground(new Color(0,162,232));
		lb1.setForeground(Color.BLACK);
		p.setBounds(0,0,1500,1500);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));
		setUndecorated(true);
		 setVisible(true);
   		 setSize(1500,1500);
   		 logout.addActionListener(this);
   		 logout1.addActionListener(this);
   		 
   		}
		
	
		
	
	public void actionPerformed(ActionEvent evt)
	{

		if(evt.getSource()==logout)
		{
					
		try
		{
		Desktop.getDesktop().open(new java.io.File("img/pdf11.pdf"));
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		}
	else if(evt.getSource()==logout1)
		{
			dispose();
			new Scheme1();
		}
	}
	
	public static void main(String []args)
	{
		new Main11();
	}
}

