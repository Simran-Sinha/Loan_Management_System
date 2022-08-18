import java.awt.*;
import javax.swing.*;
//import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class Email extends JDialog implements ActionListener
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
	JPanel p1=new JPanel();
	JLabel lb1 = new JLabel("Enter the SenderName");
	JLabel lb = new JLabel("Email Confirmation Code");
	JLabel lb2 = new JLabel("Email send code");
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JButton b1= new JButton("Confirm");
	Email()
	{
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,500,50);
		p1.setBackground(new Color(0,162,232));
		p1.add(lb);
		lb.setBounds(0,0,500,50);
		lb.setForeground(Color.WHITE);
		//lb.setOpaque(true);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,500,400);
		p.setLayout(null);
		p.add(lb1);
		p.add(lb2);
		p.add(txt1);
		p.add(txt2);
		p.add(b1);
		p.setBackground(Color.WHITE);
		lb1.setBounds(10,50,250,50);
		txt1.setBounds(260,50,200,50);
		lb2.setBounds(10,150,250,50);
		txt2.setBounds(260,150,200,50);
		b1.setBounds(140,250,150,50);
		txt1.setFont(new Font("Arial",Font.BOLD,20));
		txt2.setFont(new Font("Arial",Font.BOLD,20));
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),7));
		b1.setFont(new Font("Arial",Font.BOLD,23));
		b1.setForeground(new Color(0,162,232));
		lb1.setFont(new Font("Arial",Font.BOLD,23));
		lb1.setForeground(new Color(0,162,232));
		lb2.setFont(new Font("Arial",Font.BOLD,23));
		lb2.setForeground(new Color(0,162,232));
		setSize(520,490);
		setVisible(true);
		b1.addActionListener(this);

	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==b1)
		{
	
			if(txt1.getText().equals("")||txt2.getText().equals(""))
			{
			JOptionPane.showMessageDialog(this,"Fields are Blank!!Please Enter Appropriate Value","Information Message",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(ImageResize.resize("user1.png",50,50)));
			}
			try
			{

			
				//reset();
				pst=con.prepareStatement("select * from otp where sender=?");
				pst.setString(1,txt1.getText());
				System.out.println(txt1.getText());
				rst=pst.executeQuery();
				if(rst.next())
				{
					txt1.setText(rst.getString(1));
					txt2.setText(rst.getString(2));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Wrong Information!!!","SQL Error Message",JOptionPane.WARNING_MESSAGE);		
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);}
			}

		}
		
	public static void main(String []args)
{
	new Email();
}

}
	