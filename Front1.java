import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;	
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Front1 extends JDialog //implements ActionListener
{
	JPanel p= new JPanel();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/front.png",700,700)));;
	JLabel lb2=new JLabel("         Loan");
	JLabel lb3=new JLabel("       Management");
	JLabel lb4=new JLabel("        system");
	Front1()
	{
		setLayout(null);
		add(p);
		p.setLayout(null);
		p.setBounds(0,0,1360,1000);
		p.setBackground(Color.WHITE);
		p.add(lb1);
		p.add(lb2);
		p.add(lb3);
		p.add(lb4);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));

		lb1.setBounds(0,0,700,700);
		lb2.setBounds(600,150,500,100);
		lb2.setForeground(Color.WHITE);
		lb2.setOpaque(true);
		lb2.setBackground(new Color(0,162,232));
		lb2.setFont(new Font("Arial",Font.BOLD,50));

		lb3.setBounds(600,320,500,100);
		lb3.setForeground(Color.WHITE);
		lb3.setOpaque(true);
		lb3.setBackground(new Color(0,162,232));
		lb3.setFont(new Font("Arial",Font.BOLD,50));

		lb4.setBounds(600,500,500,100);
		lb4.setForeground(Color.WHITE);
		lb4.setOpaque(true);
		lb4.setBackground(new Color(0,162,232));
		lb4.setFont(new Font("Arial",Font.BOLD,50));

		setSize(1500,1000);
		setVisible(true);
		
	}
	public static void main(String []args)
	{
		new Front1();
	}

	

}	