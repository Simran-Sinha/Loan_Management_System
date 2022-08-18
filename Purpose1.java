import java.awt.*;
import javax.swing.*;
//import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.regex.*;
import java.text.*;
import java.io.File.*;
import java.io.*;
class PatternMatching11	
	{
		public static boolean numCheck(String x)
		{
			boolean temp;
			Pattern pattern=Pattern.compile("[0-9]{13,16}");
			Matcher m=pattern.matcher(x);
			if(m.find() && m.group().equals(x))
			{
				temp=true;
			}
			else
			{
				temp=false;
			}
			return temp;
		}
		
	}
public class Purpose1 extends JDialog implements ActionListener
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
	JLabel loantype = new JLabel("Purpose of Loan");
	JLabel lblnameError=new JLabel();
	//JLabel lblnameError=new JLabel();
	//JLabel lblnameError=new JLabel();
	//JLabel lblnameError=new JLabel();
	JLabel star1 = new JLabel("*");
	JLabel duration = new JLabel("Types Of Relationship");
	JLabel star2 = new JLabel("*");
	JLabel rate = new JLabel("Account number");JLabel lbl1=new JLabel("Enter Numbers Only");
	JLabel star3 = new JLabel("*");
	JLabel rate1 = new JLabel("Enter your Account Number with ISD Code");
	JLabel lbl2=new JLabel("Enter Numbers Only");
	JLabel star4 = new JLabel("*");
	String html="<html>I hereby authorize state bank of india and itsrepresentatives to call me email me or sms me to explain the loan & I agree to the Terms and Conditions.</html>";
	  int w = 500;
	JCheckBox check = new JCheckBox(String.format(html, w, w));
	JButton insert = new JButton("Submit");
	//JButton cancel = new JButton("Cancel");
	JComboBox c1 = new JComboBox();
	JComboBox c2 = new JComboBox();
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField("91");
	JTextField txt3 = new JTextField();
	JPanel pp = null;
	Border thickBorder = new LineBorder(new Color(0,0,160), 5);
	JLabel lb = new JLabel("           LOAN PURPOSE");
	JPanel p1 = new JPanel();
	JLabel green=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green1=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red1=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green2=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red2=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green3=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red3=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel lbll=new JLabel("   Please Enter All The Details");

	Purpose1()
	{
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,800,50);
		p1.setBackground(new Color(0,0,121));
		p1.add(lb);
		lb.setBounds(0,0,800,50);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,800,600);
		p.setLayout(null);
		p.add(loantype);
		p.add(lblnameError);
		p.add(duration);
		p.add(rate);
		p.add(rate1);
		p.add(check);
		p.add(green);
		p.add(red);
		p.add(green1);
		p.add(red1);
		p.add(green2);
		p.add(red2);
		p.add(green3);
		p.add(red3);
		p.add(lbll);
		lblnameError.setHorizontalAlignment(JLabel.CENTER);
		lblnameError.setVerticalAlignment(JLabel.CENTER);
		lblnameError.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,10));
		lblnameError.setForeground(Color.red);
		lblnameError.setBounds(500,10,150,30);

		lbll.setBounds(500,20,250,100);
		lbll.setForeground(Color.RED);
		lbll.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		lbll.setFont(new Font("Arial",Font.BOLD,14));
		lbll.setVisible(false);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,0,121),15));
		p.add(lbl1);
		p.add(lbl2);
		p.add(c1);
		p.add(c2);
		p.add(txt1);
		p.add(txt2);
		p.add(txt3);
		p.add(insert);
		p.add(star1);
		p.add(star2);
		p.add(star3);
		p.add(star4);

		loantype.setFont(new Font("Arial",Font.BOLD,20));
		insert.setFont(new Font("Arial",Font.BOLD,20));
		duration.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,20));
		rate.setFont(new Font("Arial",Font.BOLD,20));
		rate1.setFont(new Font("Arial",Font.BOLD,20));
		txt1.setFont(new Font("Arial",Font.BOLD,20));
		txt2.setFont(new Font("Arial",Font.BOLD,20));
		txt3.setFont(new Font("Arial",Font.BOLD,20));
		star1.setFont(new Font("Arial",Font.BOLD,20));
		star2.setFont(new Font("Arial",Font.BOLD,20));
		star3.setFont(new Font("Arial",Font.BOLD,20));
		star4.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,15));
		star1.setForeground(Color.RED);
		star2.setForeground(Color.RED);
		star3.setForeground(Color.RED);
		star4.setForeground(Color.RED);


		//txt2.setForeground(Color.BLACK);
		loantype.setForeground(new Color(0,0,121));
		rate1.setForeground(new Color(0,0,121));
		txt2.setForeground(Color.BLACK);
		txt1.setForeground(Color.BLACK);
		txt3.setForeground(Color.BLACK);
		duration.setForeground(new Color(0,0,121));
		rate.setForeground(new Color(0,0,121));
		p.setBackground(Color.WHITE);
		lbl1.setForeground(Color.RED);lbl1.setVisible(false);lbl1.setBounds(380,280,250,40);
		lbl2.setForeground(Color.RED);lbl2.setVisible(false);lbl2.setBounds(510,390,300,40);
			c1.addItem("Select Loan Type");c1.addItem("Home Loan");
			c1.addItem("Car Loan");c1.addItem("Gold Loan");
			c1.addItem("Personal Loan");c2.addItem("Select Criteria");
			c2.addItem("Existing");c2.addItem("Non Existing");
		loantype.setBounds(100,10,250,60);star1.setBounds(260,10,50,50);
		c1.setBounds(100,60,250,40);	
		red1.setBounds(360,60,30,30);
		green1.setBounds(360,60,30,30);	
			

		duration.setBounds(100,110,400,60);star2.setBounds(310,110,50,50);
		c2.setBounds(100,170,250,40);
		red2.setBounds(360,170,30,30);
		green2.setBounds(360,170,30,30);	
		
		rate.setBounds(100,220,300,60);star3.setBounds(260,220,50,50);
		txt1.setBounds(100,280,250,40);
		red3.setBounds(350,280,30,30);
		green3.setBounds(350,280,30,30);

		rate1.setBounds(100,330,500,60);star4.setBounds(500,330,50,50);
		txt2.setBounds(100,390,50,40);
		txt3.setBounds(160,390,300,40);
		red.setBounds(460,390,30,30);
		green.setBounds(460,390,30,30);

		check.setBounds(100,440,670,60);
		insert.setBounds(110,505,150,60);
		red.setVisible(false);
		red1.setVisible(false);
		red2.setVisible(false);
		red3.setVisible(false);
		green.setVisible(false);
		green1.setVisible(false);
		green2.setVisible(false);
		green3.setVisible(false);
		setLocation(400,10);
		setSize(815,690);
		setVisible(true);
		//insert.setVisible(false);
		insert.setEnabled(false);
		insert.addActionListener(this);
		check.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent evt)
	{

JOptionPane.showMessageDialog(null,"A");
		
		if(evt.getSource()==check)
			 {
			 	if(check.isSelected())
			 	insert.setEnabled(true);
			 	else
			 	{
			 		insert.setEnabled(false);
			 	}
			 	//JOptionPane.showMessageDialog(null,"please tick ....");

			 }
	else if(evt.getSource()==insert)
		{
			JOptionPane.showMessageDialog(null,"Insert");
			boolean temp=true;
			if(txt1.getText().equals(""))
			{
				red3.setVisible(true);
				green3.setVisible(false);
				temp=false;
			}

			else
			{
				red3.setVisible(false);
				green3.setVisible(true);
				temp=true;
			}
			if(txt3.getText().equals(""))
			{
				red.setVisible(true);
				green.setVisible(false);
				temp=false;
			}
			else
			{
				green.setVisible(true);
				red.setVisible(false);
				temp=true;
			}
			if(c2.getSelectedItem().equals("Select Criteria"))
			{
				red2.setVisible(true);
				green2.setVisible(false);
				temp=false;
			}
			else
			{
				red2.setVisible(false);
				green2.setVisible(true);	
				temp=true;
			}
			if(c1.getSelectedItem().equals("Select Loan Type"))
			{
				red1.setVisible(true);
				green1.setVisible(false);
				temp=false;
			}
			else
			{
				red1.setVisible(false);
				green1.setVisible(true);
				temp=true;	
			}	//JOptionPane.showMessageDialog(null,"Please Fill the Details ....");
				//return;
			if(!temp)
			{
			lbll.setVisible(true);
			return;
		}
		else
		{
			lbll.setVisible(false);
		}

			boolean t=false;
			if(!PatternMatching11.numCheck(txt1.getText()))
			{
				lbl1.setVisible(true);
				txt1.setText("");
				t=true;
			}
			else
			{
				lbl1.setVisible(false);
			}
			if(!PatternMatching11.numCheck(txt3.getText()))
			{
				lbl2.setVisible(true);
				txt3.setText("");
				t=true;
			}
			else
			{
				lbl2.setVisible(false);
			}
			if(t){return;}
			
		
			
			try
			{
				//lbll.setVisible(false);
				pst=con.prepareStatement("insert into Purpose values(?,?,?,?)");
				pst.setString(1,c1.getSelectedItem().toString());
				pst.setString(2,c2.getSelectedItem().toString());
				pst.setString(3,txt1.getText());
				pst.setString(4,txt3.getText());
				
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"Thankyou for filling the Details","Confirm Message",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(ImageResize.resize("p1.png",80,80)));
					dispose();
					//new Offer1();
					
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Data Not Saved","Error Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
		}
		

	}
public static void main(String []args)
{
	new Purpose1();
}
}