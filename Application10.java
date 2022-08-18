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
class PatternMatching	
	{
		public static boolean numCheck(String x)
		{
			boolean temp;
			Pattern pattern=Pattern.compile("[0-9]{5,8}");
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
		public static boolean mobCheck(String x)
	{
		boolean temp;
		Pattern pattern=Pattern.compile("(0|91)?[6-9][0-9]{9}");
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
		public static boolean nameCheck(String x)
		{
			boolean temp;
			Pattern pattern=Pattern.compile("[a-zA-Z ]+");
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
public class Application10 extends JDialog implements ActionListener
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
	JLabel loantype = new JLabel("Nature of Loan");
	JLabel star1 = new JLabel("*");
	JLabel duration = new JLabel("Full Name as per PAN Card");JLabel lbl11=new JLabel("Enter Characters Only");
	JLabel star2 = new JLabel("*");
	JLabel rate = new JLabel("Mobile Number");JLabel lbl21=new JLabel("Enter Numbers Only");
	JLabel star3 = new JLabel("*");
	JLabel rate1 = new JLabel("Net Monthly Income");JLabel lbl31=new JLabel("Enter Numbers Only");
	JLabel star4 = new JLabel("*");
	JLabel resi = new JLabel("PLace of Current Residence or pincode");JLabel lbl41=new JLabel("Enter Characters Only");
	JLabel star5 = new JLabel("*");
	JLabel amt = new JLabel("Loan Amount Needed");JLabel lbl51=new JLabel("Enter Numbers Only");
	JLabel star6 = new JLabel("*");
	String html="<html>I hereby authorize state bank of india and itsrepresentatives to call me email me or sms me to explain the loan & I agree to the Terms and Conditions.</html>";
	  int w = 500;
	JCheckBox check = new JCheckBox(String.format(html, w, w));
	JButton insert = new JButton("Submit");
	//JButton cancel = new JButton("Cancel");
	
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField("+91");
	JTextField txt3 = new JTextField("");
	JTextField txt4 = new JTextField("");
	JTextField txt5 = new JTextField("");
	JTextField txt6 = new JTextField("");
	JTextField txt7 = new JTextField("");
	JRadioButton r1 = new JRadioButton("New Loan");
	JRadioButton r2 = new JRadioButton("Balance Transfer");

	JPanel pp = null;
	Border thickBorder = new LineBorder(new Color(0,0,160), 5);
	JLabel lb = new JLabel("                      COMPLETE APPLICATION");
	JPanel p1 = new JPanel();
	JLabel pic1 = new JLabel(new ImageIcon(ImageResize.resize("img/user1.png",50,50)));;
	JLabel pic2 =  new JLabel(new ImageIcon(ImageResize.resize("img/month.png",50,50)));;
	JLabel pic5 =  new JLabel(new ImageIcon(ImageResize.resize("img/mob.png",50,50)));;
	JLabel pic4 =  new JLabel(new ImageIcon(ImageResize.resize("img/loan5.png",50,50)));;
	JLabel pic3 =  new JLabel(new ImageIcon(ImageResize.resize("img/location1.jpg",50,50)));;

	JLabel green=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green1=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red1=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green2=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red2=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green3=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red3=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green4=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red4=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;

	JLabel green5=new JLabel(new ImageIcon(ImageResize.resize("img/green.png",30,30)));;
	JLabel red5=new JLabel(new ImageIcon(ImageResize.resize("img/red.jpg",30,30)));;
	JLabel lbll=new JLabel("   Please Enter All The Details");
	JLabel lblnameError= new JLabel();
	ButtonGroup bg = new ButtonGroup();



	Application10()
	{
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,900,50);
		p1.setBackground(new Color(0,0,121));
		p1.add(lb);
		lb.setBounds(0,0,900,50);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,900,800);
		p.setLayout(null);
		p.add(loantype);
		p.add(duration);
		p.add(rate);
		p.add(rate1);
		p.add(resi);
		p.add(amt);
		p.add(check);
		p.add(pic1);
		p.add(pic2);
		p.add(pic3);
		p.add(pic4);
		p.add(pic5);
		p.add(green);
		p.add(red);
		p.add(green1);
		p.add(red1);
		p.add(green2);
		p.add(red2);
		p.add(green3);
		p.add(red3);
		p.add(green4);
		p.add(red4);
		p.add(green5);
		p.add(red5);
		p.add(txt1);
		p.add(r1);
		p.add(r2);
		p.add(txt2);
		p.add(txt3);
		p.add(txt4);
		p.add(txt5);
		p.add(txt6);
		p.add(txt7);
		p.add(insert);
		p.add(star1);
		p.add(star2);
		p.add(star3);
		p.add(star4);
		p.add(star5);
		p.add(star6);
		p.add(lbll);
		p.add(lblnameError);
		p.add(lbl11);
		p.add(lbl21);
		p.add(lbl31);
		p.add(lbl41);
		p.add(lbl51);
		lblnameError.setHorizontalAlignment(JLabel.CENTER);
		lblnameError.setVerticalAlignment(JLabel.CENTER);
		lblnameError.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,10));
		lblnameError.setForeground(Color.red);
		lblnameError.setBounds(500,10,150,30);
		lbll.setBounds(630,20,250,100);
		lbll.setForeground(Color.RED);
		lbll.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		lbll.setFont(new Font("Arial",Font.BOLD,14));
		lbll.setVisible(false);
		bg.add(r1);
		bg.add(r2);
		lbl11.setForeground(Color.RED);lbl11.setVisible(false);lbl11.setBounds(680,150,370,40);
		lbl21.setForeground(Color.RED);lbl21.setVisible(false);lbl21.setBounds(680,250,300,40);
		lbl31.setForeground(Color.RED);lbl31.setVisible(false);lbl31.setBounds(680,350,370,40);
		lbl41.setForeground(Color.RED);lbl41.setVisible(false);lbl41.setBounds(680,450,370,40);
		lbl51.setForeground(Color.RED);lbl51.setVisible(false);lbl51.setBounds(680,550,370,40);
		loantype.setFont(new Font("Arial",Font.BOLD,20));
		insert.setFont(new Font("Arial",Font.BOLD,20));
		r1.setFont(new Font("Arial",Font.BOLD,20));
		r2.setFont(new Font("Arial",Font.BOLD,20));
		duration.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,20));
		rate.setFont(new Font("Arial",Font.BOLD,20));
		rate1.setFont(new Font("Arial",Font.BOLD,20));
		resi.setFont(new Font("Arial",Font.BOLD,20));
		amt.setFont(new Font("Arial",Font.BOLD,20));
		txt1.setFont(new Font("Arial",Font.BOLD,15));
		txt2.setFont(new Font("Arial",Font.BOLD,15));
		txt3.setFont(new Font("Arial",Font.BOLD,15));
		txt4.setFont(new Font("Arial",Font.BOLD,15));
		txt5.setFont(new Font("Arial",Font.BOLD,15));
		
		txt6.setFont(new Font("Arial",Font.BOLD,15));
		txt7.setFont(new Font("Arial",Font.BOLD,15));
		star1.setFont(new Font("Arial",Font.BOLD,20));
		star2.setFont(new Font("Arial",Font.BOLD,20));
		star3.setFont(new Font("Arial",Font.BOLD,20));
		star4.setFont(new Font("Arial",Font.BOLD,20));
		star5.setFont(new Font("Arial",Font.BOLD,20));
		star6.setFont(new Font("Arial",Font.BOLD,20));
		check.setFont(new Font("Arial",Font.BOLD,15));
		star1.setForeground(Color.RED);
		star2.setForeground(Color.RED);
		star3.setForeground(Color.RED);
		star4.setForeground(Color.RED);
		star5.setForeground(Color.RED);
		star6.setForeground(Color.RED);


		//txt2.setForeground(Color.BLACK);
		loantype.setForeground(new Color(0,0,121));
		rate1.setForeground(new Color(0,0,121));
		txt2.setForeground(Color.GRAY);
		txt1.setForeground(Color.GRAY);
		txt3.setForeground(Color.GRAY);
		txt4.setForeground(Color.GRAY);
		txt5.setForeground(Color.GRAY);
		txt6.setForeground(Color.GRAY);
		txt7.setForeground(Color.GRAY);
		duration.setForeground(new Color(0,0,121));
		rate.setForeground(new Color(0,0,121));
		resi.setForeground(new Color(0,0,121));
		amt.setForeground(new Color(0,0,121));
		p.setBackground(Color.WHITE);
		
		duration.setBounds(200,100,400,50);star1.setBounds(460,100,50,50);
		txt5.setBounds(200,150,370,40);	
		lblnameError.setBounds(700,150,100,100);
		red5.setBounds(570,150,30,30);
		green5.setBounds(570,150,30,30);
		pic1.setBounds(150,150,50,50);
		loantype.setBounds(200,10,400,60);star2.setBounds(350,10,50,50);
		
		r1.setBounds(200,50,150,40);
		r2.setBounds(400,50,200,40);
		red.setBounds(600,50,30,30);
		green.setBounds(600,50,30,30);

		rate.setBounds(200,200,400,50);star3.setBounds(350,200,50,50);
		txt2.setBounds(200,250,60,40);
		txt4.setBounds(270,250,300,40);
		red1.setBounds(570,250,30,30);
		green1.setBounds(570,250,30,30);
		pic5.setBounds(150,250,50,50);


		rate1.setBounds(200,300,500,50);star4.setBounds(390,300,50,50);
		pic2.setBounds(150,350,50,50);
		
		txt3.setBounds(200,350,370,40);	
		red2.setBounds(570,350,30,30);
		green2.setBounds(570,350,30,30);
			

		
		
		

		resi.setBounds(200,400,400,50);star5.setBounds(570,400,50,50);
		txt6.setBounds(200,450,370,40);
		red3.setBounds(570,450,30,30);
		green3.setBounds(570,450,30,30);

		amt.setBounds(200,500,400,50);star6.setBounds(410,500,50,50);
		txt7.setBounds(200,550,370,40);
		red4.setBounds(570,550,30,30);
		green4.setBounds(570,550,30,30);
		pic3.setBounds(150,450,50,50);
		pic4.setBounds(150,550,50,40);
		

		check.setBounds(30,590,700,60);
		insert.setBounds(740,590,100,60);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,0,121),20));

		

		 //c1.setBorder(thickBorder);
		 //txt1.setBorder(thickBorder);
		 //txt2.setBorder(thickBorder);

		 //insert.setBorder(thickBorder);
		 //cancel.setBorder(thickBorder);
		 
		red.setVisible(false);
		red1.setVisible(false);
		red2.setVisible(false);
		red3.setVisible(false);
		red4.setVisible(false);
		red5.setVisible(false);
		green.setVisible(false);
		green1.setVisible(false);
		green2.setVisible(false);
		green3.setVisible(false);
		green4.setVisible(false);
		green5.setVisible(false);
		

		
		setLocation(400,10);
		//setLocationRelativeTo(null);
		setSize(915,750);
		setVisible(true);
		
		insert.addActionListener(this);
		insert.setEnabled(false);
		check.addActionListener(this);
		
	}
	
	

	
	public void actionPerformed(ActionEvent evt)
	{
		
		 if(evt.getSource()==check)
			 {
			 	if(check.isSelected())
			 	insert.setEnabled(true);
			 	else
			 	{
			 		insert.setEnabled(false);
			 	}
			 }
		else if(evt.getSource()==insert)
		{
			boolean temp=true;
			if(txt4.getText().equals(""))
			{
				red1.setVisible(true);
				green1.setVisible(false);
				temp=false;
			}
			else
			{
				red1.setVisible(false);
				green1.setVisible(true);
			}
			if(txt3.getText().equals(""))
			{
				red2.setVisible(true);
				green2.setVisible(false);
				temp=false;
			}
			else
			{
				green2.setVisible(true);
				red2.setVisible(false);
			}
			if(!r1.isSelected())
			{
				if(!r2.isSelected())
				{
					red.setVisible(true);
					green.setVisible(false);
					temp=false;
				}
				else
				{
					red.setVisible(false);
					green.setVisible(true);	
				}
			}
			else
			{
				red.setVisible(false);
				green.setVisible(true);	
			}
			if(txt6.getText().equals(""))
			{
				red3.setVisible(true);
				green3.setVisible(false);
				temp=false;
			}
			else
			{
				red3.setVisible(false);
				green3.setVisible(true);
			}
			if(txt5.getText().equals(""))
			{
				red5.setVisible(true);
				green5.setVisible(false);
				temp=false;
			}
			else
			{
				red5.setVisible(false);
				green5.setVisible(true);
			}
			if(txt7.getText().equals(""))
			{
				red4.setVisible(true);
				green4.setVisible(false);
				temp=false;
			}
			else
			{
				red4.setVisible(false);
				green4.setVisible(true);
			}		
			JOptionPane.showMessageDialog(null,temp);
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
			if(!PatternMatching.nameCheck(txt5.getText()))
			{
				lbl11.setVisible(true);
				txt5.setText("");
				t=true;
			}
			else
			{
				lbl11.setVisible(false);
			}
			if(!PatternMatching.mobCheck(txt4.getText()))
			{
				lbl21.setVisible(true);
				txt4.setText("");
				t=true;
			}
			else
			{
				lbl21.setVisible(false);
			}
			if(!PatternMatching.numCheck(txt3.getText()))
			{
				lbl31.setVisible(true);
				txt3.setText("");
				t=true;
			}
			if(!PatternMatching.nameCheck(txt6.getText()))
			{
				lbl41.setVisible(true);
				txt6.setText("");
				t=true;
			}
			else
			{
				lbl41.setVisible(false);
			}
			if(!PatternMatching.numCheck(txt7.getText()))
			{
				lbl51.setVisible(true);
				txt7.setText("");
				t=true;
			}
			else
			{
				lbl51.setVisible(false);
			}
			if(t){return;}
			
			

			try
			{	
				
				String loan="";
				if(r1.isSelected()){loan="new loan";}
				else if(r2.isSelected()){loan="balance transfer";}
				
				
				pst=con.prepareStatement("insert into compapp values(?,?,?,?,?,?)");
				pst.setString(1,loan);
				pst.setString(2,txt5.getText());
				pst.setString(3,txt4.getText());
				pst.setString(4,txt3.getText());
				pst.setString(5,txt6.getText());
				pst.setString(6,txt7.getText());
				
				
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"Thankyou for filling the Details","Confirm Message",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(ImageResize.resize("p1.png",80,80)));
					dispose();
					//new Appli();
					
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
	new Application10();
}
}