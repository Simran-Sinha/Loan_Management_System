import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Help extends JDialog implements ActionListener
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
		JLabel lb= new JLabel("       Hello,how can we help?");
		JComboBox c1=new JComboBox();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/serach.png",270,270)));;
		JButton b1=new JButton(new ImageIcon(ImageResize.resize("img/b1.png",100,60)));;
		JPanel pp=null;
		Help()
		{

		setLayout(null);
			add(p);
			p.setLayout(null);
			p.add(c1);
			p.add(lb);
			p.add(lb1);
			p.add(b1);
			lb1.setBounds(40,200,270,270);
			p.setBounds(0,0,1200,1200);
			lb.setBounds(200,80,800,100);
			c1.setBounds(250,270,700,60);
			b1.setBounds(950,270,100,60);
			lb.setBackground(new Color(0,162,232));
			lb.setForeground(Color.WHITE);
			lb.setOpaque(true);
			lb.setFont(new Font("Arial",Font.BOLD,50));
			c1.setFont(new Font("Arial",Font.BOLD,30));
			c1.setForeground(Color.GRAY);
			c1.addItem("Select the schemes available in home loan");
			c1.addItem("home loan");
			c1.addItem("how to check the eligiblity");
			p.setBackground(Color.WHITE);
			p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),30));
			//setUndecorated(true);
			setVisible(true);
			setSize(1200,1200);
			setLocationRelativeTo(null);
			//txt.addFocusListener(this);
			c1.addActionListener(this);

		}
		public void actionPerformed(ActionEvent evt)
		{

		if(evt.getSource()==c1)
		{
			if(c1.getSelectedItem().equals("home loan"))
			{
				//JOptionPane.showMessageDialog(null,"A");
				if(pp!=null)
					{
					pp.setVisible(false);
					pp=null;
					}
					pp= new Help1();
					pp.setPreferredSize(new Dimension(900,300));
					pp.setBounds(180,380,900,300);
					//main1.setVisible(false);
					p.add(pp);
					//repaint();
					p.setVisible(false);
					p.setVisible(true);
				}
				/*Help1 b1=new Help1();
				b1.setPreferredSize(new Dimension(920,300));
			    b1.setBounds(250,400,900,300);
					
			   //add(b1);
			    b1.setVisible(true);*/
					
			

		}
	}

		/*public void focusGained(FocusEvent evt2)
	{
		
		if(evt2.getSource()==txt)
		{
			txt.setText("");
		}
	}
		public void focusLost(FocusEvent evt1)
	{
		
	 if(evt1.getSource()==txt)
		{
			if(txt.getText().equals(""))
			{
				txt.setText("Search for Answers");
			}
		}
	}
	*/
		public static void main(String []args)
	{
		new Help();
	}



}		