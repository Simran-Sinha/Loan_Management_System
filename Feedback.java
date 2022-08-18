import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
import java.sql.*;
public class Feedback extends JDialog implements MouseListener,ActionListener
{
	Connection con;
		PreparedStatement pst;
		ResultSet rst;
		String path="";
		{
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
			}
			catch(Exception e){}
		}

	JPanel panel=new JPanel();
	JLabel lbltitle=new JLabel("    Send us your feedback !");
	JLabel lbl1=new JLabel("Did you achieve your goal ?");
	JLabel lbl2=new JLabel("What was the reason for your visit ?");
	JLabel lbl3=new JLabel("What was the reason you could not achieve your goal ?");
	JLabel lbl4=new JLabel("Do you have any suggestions to make our software better ?");
	JButton yes=new JButton("Yes");
	JButton partially=new JButton("Partially");
	JButton no=new JButton("No");
	JComboBox cmb1=new JComboBox();
	JComboBox cmb2=new JComboBox();
	JTextArea txt=new JTextArea();
	JButton submit=new JButton("Submit");
	JTextField txt1=new JTextField();
	
	Feedback()
	{
		setLayout(null);
		add(panel);
		panel.setBounds(0,0,630,600);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.add(lbltitle);
		lbltitle.setBounds(0,0,600,70);
		lbltitle.setForeground(Color.WHITE);
		lbltitle.setBackground(new Color(0,162,232));
		lbltitle.setOpaque(true);
		lbltitle.setFont(new Font("Arial",Font.BOLD,25));
		panel.add(lbl1);
		lbl1.setBounds(30,80,400,40);
		panel.add(txt1);
		txt1.setBounds(100,120,60,60);
		panel.add(yes);yes.setBackground(Color.WHITE);
		yes.setBounds(30,120,120,40);
		
		panel.add(partially);partially.setBackground(Color.WHITE);
		partially.setBounds(160,120,120,40);
		
		panel.add(no);no.setBackground(Color.WHITE);
		no.setBounds(290,120,120,40);
		
		panel.add(lbl2);
		lbl2.setBounds(30,170,440,40);
		panel.add(cmb1);
		cmb1.setBounds(30,210,440,40);
		panel.add(lbl3);
		lbl3.setBounds(30,260,440,40);
		panel.add(cmb2);
		cmb2.setBounds(30,300,460,40);
		panel.add(lbl4);
		lbl4.setBounds(30,350,480,40);
		panel.add(txt);
		txt.setBounds(30,390,400,100);
		panel.add(submit);
		cmb1.addItem("To Apply for a loan");
		cmb1.addItem("To get information about the types of loan");
		cmb1.addItem("To submit your loan aaplication online");

		cmb2.addItem("Form does not work well");
		cmb2.addItem("Limited no of loans");
		cmb2.addItem("Does not describe the entire details about interest rates and Emi details");
		txt.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),4));
		yes.setFont(new Font("Arial",Font.BOLD,18));
		partially.setFont(new Font("Arial",Font.BOLD,18));
		no.setFont(new Font("Arial",Font.BOLD,18));
		lbl1.setFont(new Font("Arial",Font.BOLD,17));
		txt.setFont(new Font("Arial",Font.BOLD,15));
		lbl2.setFont(new Font("Arial",Font.BOLD,17));
		lbl3.setFont(new Font("Arial",Font.BOLD,17));
		lbl4.setFont(new Font("Arial",Font.BOLD,17));
		submit.setBounds(360,510,150,50);
		submit.setBackground(new Color(0,162,232));
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Arial",Font.BOLD,20));
		yes.addMouseListener(this);
		no.addMouseListener(this);
		partially.addMouseListener(this);
		txt1.setVisible(false);
		yes.addActionListener(this);
		no.addActionListener(this);
		submit.addActionListener(this);
		partially.addActionListener(this);
		
		setSize(630,620);
		setVisible(true);	
	}
	public void mouseClicked(MouseEvent evt4){}
	public void mousePressed(MouseEvent evt2){}
	public void mouseReleased(MouseEvent evt3){}
	public void mouseEntered(MouseEvent evt1)
	{
		if (evt1.getSource()==yes) 
		{
			yes.setBackground(new Color(0,162,232));
			yes.setForeground(Color.WHITE);
		}
		else if (evt1.getSource()==no) 
		{
			no.setBackground(new Color(0,162,232));
			no.setForeground(Color.WHITE);
		}
		else if (evt1.getSource()==partially) 
		{
			partially.setBackground(new Color(0,162,232));
			partially.setForeground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent evt5)
	{
		if (evt5.getSource()==yes) 
		{
			yes.setForeground(Color.BLACK);
			yes.setBackground(Color.WHITE);
		}
		else if (evt5.getSource()==no) 
		{
			no.setForeground(Color.BLACK);
			no.setBackground(Color.WHITE);
		}
		else if (evt5.getSource()==partially) 
		{
			partially.setForeground(Color.BLACK);
			partially.setBackground(Color.WHITE);
		}
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==yes)
			{
				txt1.setText("yes");
			}
			else if(evt.getSource()==partially)
			{
				txt1.setText("partially");
			}
			else if(evt.getSource()==no)
			{
				txt1.setText("no");
			}
		
		

	if(evt.getSource()==submit)
		{
			
			 if(txt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Kindly submit your feedback ....");
				return;
			}
			try
			{
				
				pst=con.prepareStatement("insert into feed values(?,?,?,?)");
				pst.setString(1,txt1.getText());
				pst.setString(2,cmb1.getSelectedItem().toString());
				pst.setString(3,cmb2.getSelectedItem().toString());
				pst.setString(4,txt.getText());
				
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"thankyou!!! for your time..","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new Con2();
					
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Data Not Saved","Error Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
		

	
	public static void main(String []args)
	{
		new Feedback();
	}
}