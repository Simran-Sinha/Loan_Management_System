import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Help2 extends JPanel //implements FocusListener
{
	JPanel p=new JPanel();
	JLabel q1=new JLabel("How to know the benefits of SBI Auto Loans?");
	JLabel q2=new JLabel("How to Apply for a loan?");
	JLabel q3=new JLabel("How to know about various schemes available in SBI Car Loan.?");
	JLabel click1=new JLabel("Click here..");
	JLabel click2=new JLabel("Click here..");
	JLabel click3=new JLabel("Click here..");
	Help2()
	{

		setLayout(new BorderLayout());
		add(p);
		p.setLayout(null);
		p.add(q1);
		p.add(q2);
		p.add(q3);
		p.add(click1);
		p.add(click2);
		p.add(click3);
		p.setBackground(Color.WHITE);
		q1.setBounds(10,50,700,60);
		q2.setBounds(10,120,700,60);
		q3.setBounds(10,190,700,60);
		click1.setBounds(720,50,120,70);
		click2.setBounds(720,120,120,70);
		click3.setBounds(720,190,120,70);
		click1.setFont(new Font("Arial",Font.BOLD,19));
		click2.setFont(new Font("Arial",Font.BOLD,19));
		click3.setFont(new Font("Arial",Font.BOLD,19));
		click1.setForeground(new Color(0,162,232));
		click2.setForeground(new Color(0,162,232));
		click3.setForeground(new Color(0,162,232));
		q1.setBackground(new Color(0,162,232));
		q1.setForeground(Color.WHITE);
		q1.setOpaque(true);
		q1.setFont(new Font("Arial",Font.BOLD,20));
		q2.setBackground(new Color(0,162,232));
		q2.setForeground(Color.WHITE);
		q2.setOpaque(true);
		q2.setFont(new Font("Arial",Font.BOLD,20));
		q3.setBackground(new Color(0,162,232));
		q3.setForeground(Color.WHITE);
		q3.setOpaque(true);
		q3.setFont(new Font("Arial",Font.BOLD,20));
		//setUndecorated(true);


		p.setLayout(null);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),8));

		setVisible(true);
		setSize(900,300);
		click3.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
       // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable

      				Scheme1 b1=new Scheme1();
					b1.setPreferredSize(new Dimension(1500,1400));
					b1.setBounds(0,0,1500,1400);
					add(b1);
    }  
}); 
		click2.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
       // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
    				
      				Instruction1 b1=new Instruction1();
					b1.setPreferredSize(new Dimension(1500,900));
					b1.setBounds(0,0,1500,900);
					add(b1);
    }  
}); 

		//setLocationRelativeTo(null);

	}
	/*public static void main(String []args)
	{
		new Help1();
	}*/


}