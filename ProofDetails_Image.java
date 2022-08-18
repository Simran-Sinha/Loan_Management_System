import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.*;
public class ProofDetails_Image extends JDialog //implements ActionListener
{
	PreparedStatement pst;
	ResultSet rst;
	Connection con;
	{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
	}
	catch(Exception e){}
	}
	JPanel panel=new JPanel();
	JLabel lbl=new JLabel("Image");
	ProofDetails_Image(String str,int col_index)
	{
		try
		{
			pst=con.prepareStatement("Select * from loanform1 where cusid=?");
			pst.setString(1,str);
			rst=pst.executeQuery();
			if(rst.next())
			{
				if(col_index==2)
				{
					byte b[]=rst.getBytes(16);
					Image img=Toolkit.getDefaultToolkit().createImage(b);
					img=img.getScaledInstance(400,400,Image.SCALE_SMOOTH);
					lbl.setText("");
					lbl.setIcon(new ImageIcon(img)); 
				}
				else if(col_index==3)
				{

					byte b[]=rst.getBytes(18);
					Image img=Toolkit.getDefaultToolkit().createImage(b);
					img=img.getScaledInstance(400,400,Image.SCALE_SMOOTH);
					lbl.setText("");
					lbl.setIcon(new ImageIcon(img));
				}
				else if(col_index==4)
				{

					byte b[]=rst.getBytes(20);
					Image img=Toolkit.getDefaultToolkit().createImage(b);
					img=img.getScaledInstance(400,400,Image.SCALE_SMOOTH);
					lbl.setText("");
					lbl.setIcon(new ImageIcon(img));
				} 
			}
		}
		catch(Exception e){}
				
		setLayout(null);
		add(panel);
		panel.setBounds(0,0,600,600);
		panel.setBackground(Color.WHITE);
		panel.add(lbl);
		lbl.setBounds(100,50,400,400);
		setSize(600,600);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}