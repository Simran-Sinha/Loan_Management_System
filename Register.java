import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.regex.*;
import java.text.*;
import java.io.File.*;
import java.io.*;
class PatternMatching2	
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
		public static boolean numCheck1(String x)
		{
			boolean temp;
			Pattern pattern=Pattern.compile("[0-9]{3,5}");
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
		Pattern pattern=Pattern.compile("[a-zA-Z .]+");
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
		public static boolean charCheck(String x)
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
public class Register extends JFrame implements ActionListener
{
	JPanel pan_form1=new JPanel();
	JPanel pan_form2=new JPanel();
	JLabel acct_no=new JLabel("Account Number");JLabel lbl1=new JLabel("Enter Numbers Only");JLabel acct_no_man=new JLabel("*");JTextField acct_no_txt=new JTextField();
	JLabel cif=new JLabel("CIF Number");JLabel lbl2=new JLabel("Enter Numbers Only");JLabel cif_man=new JLabel("*");JTextField cif_txt=new JTextField();
	JLabel branch=new JLabel("Branch Code");JLabel lbl3=new JLabel("Enter Numbers Only");JLabel branch_man=new JLabel("*");JTextField branch_txt=new JTextField();
	JLabel country=new JLabel("Country");JLabel country_man=new JLabel("*");JComboBox country_txt=new JComboBox();
	JLabel mob_no=new JLabel("Registered Mobile Number");JLabel lbl4=new JLabel("Enter Numbers Only");JLabel mob_no_man=new JLabel("*");JTextField mob_no_txt=new JTextField();
	JLabel username=new JLabel("Enter UserName");JLabel lbl5=new JLabel("Enter Characters Only");JLabel username_man=new JLabel("*");JTextField username_txt=new JTextField();
	JLabel password=new JLabel("Enter Password");JLabel lbl6=new JLabel("Enter Characters Only");JLabel password_man=new JLabel("*");JPasswordField password_txt=new JPasswordField();
	JLabel capt=new JLabel("Enter the text shown in the image");JLabel capt_man=new JLabel("*");JTextField capt_txt=new JTextField(10);
	String captcha="";
	JLabel lblCaptcha=new JLabel();
	JButton next=new JButton("Next");
	JButton cancel=new JButton("Cancel");
	JLabel lbl=new JLabel("Please select the security questions and answer them:");
	JComboBox question1=new JComboBox();
	JComboBox question2=new JComboBox();
	JComboBox question3=new JComboBox();
	JTextField answer1=new JTextField();
	JTextField answer2=new JTextField();
	JTextField answer3=new JTextField();
	JButton confirm=new JButton("Confirm");
	JButton cancel1=new JButton("Cancel");
	Connection con;
	ResultSet rst;
	PreparedStatement pst;
	void createCapcha()
	{
		captcha="";
		while(true)
		{
			int n=(int)(Math.random()*1000);
			if((n>=65 && n<=90))
			captcha=captcha+(char)n;
			else if(n>=48 && n<=57)
			captcha=captcha+(char)n;
			if(captcha.length()==5)
			break;
		
		}
		lblCaptcha.setText(captcha);
	}
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
		}
		catch(Exception e){JOptionPane.showMessageDialog(null,e);}
	}
	Register()
	{
		setLayout(null);
		add(pan_form1);
		pan_form1.setBounds(0,0,800,620);
		pan_form1.setLayout(null);
		pan_form1.setBackground(new Color(180,255,146));
		pan_form1.setBorder(LineBorder.createBlackLineBorder());
		pan_form2.setVisible(false);
		javax.swing.border.TitledBorder titleBorder=BorderFactory.createTitledBorder("REGISTER YOURSELF");
		titleBorder.setTitleJustification(2);
		titleBorder.setTitleFont(new Font("ARIAL",Font.BOLD,30));
		pan_form1.setBorder(titleBorder);
		add(pan_form2);
		javax.swing.border.TitledBorder titleBorder1=BorderFactory.createTitledBorder("REGISTER YOURSELF");
		titleBorder1.setTitleJustification(2);
		titleBorder1.setTitleFont(new Font("ARIAL",Font.BOLD,30));
		pan_form2.setBorder(titleBorder1);
		pan_form2.setBounds(0,0,800,620);
		pan_form2.setLayout(null);
		pan_form2.setBackground(new Color(180,255,146));
		pan_form2.setBorder(LineBorder.createBlackLineBorder());
		addComponent(pan_form1,acct_no,100,50,200,40);addComponent(pan_form1,acct_no_man,225,50,30,40);acct_no_man.setForeground(Color.RED);addComponent(pan_form1,acct_no_txt,370,50,200,40);addComponent(pan_form1,lbl1,600,50,200,40);
		addComponent(pan_form1,cif,100,100,200,40);addComponent(pan_form1,cif_man,190,100,30,40);cif_man.setForeground(Color.RED);addComponent(pan_form1,cif_txt,370,100,200,40);addComponent(pan_form1,lbl2,600,100,200,40);
		addComponent(pan_form1,branch,100,160,200,40);addComponent(pan_form1,branch_man,195,160,30,40);branch_man.setForeground(Color.RED);addComponent(pan_form1,branch_txt,370,160,200,40);addComponent(pan_form1,lbl3,600,160,200,40);
		addComponent(pan_form1,country,100,220,200,40);addComponent(pan_form1,country_man,160,220,30,40);country_man.setForeground(Color.RED);addComponent(pan_form1,country_txt,370,220,200,40);
		addComponent(pan_form1,mob_no,100,280,200,40);addComponent(pan_form1,mob_no_man,290,280,30,40);mob_no_man.setForeground(Color.RED);addComponent(pan_form1,mob_no_txt,370,280,200,40);addComponent(pan_form1,lbl4,600,280,200,40);
		addComponent(pan_form1,username,100,340,200,40);addComponent(pan_form1,username_man,220,340,30,40);username_man.setForeground(Color.RED);addComponent(pan_form1,username_txt,370,340,200,40);addComponent(pan_form1,lbl5,600,340,200,40);
		addComponent(pan_form1,password,100,400,200,40);addComponent(pan_form1,password_man,220,400,30,40);password_man.setForeground(Color.RED);addComponent(pan_form1,password_txt,370,400,200,40);addComponent(pan_form1,lbl6,600,400,200,40);
		addComponent(pan_form1,capt,100,460,250,40);addComponent(pan_form1,capt_man,340,460,50,40);capt_man.setForeground(Color.RED);
		addComponent(pan_form1,capt_txt,370,460,200,40);addComponent(pan_form1,lblCaptcha,590,460,100,50);
		addComponent(pan_form1,next,250,510,100,50);
		addComponent(pan_form1,cancel,380,510,100,50);
		addComponent1(pan_form2,lbl,150,30,700,50);
		addComponent1(pan_form2,question1,120,100,500,40);addComponent1(pan_form2,answer1,120,150,500,40);
		addComponent1(pan_form2,question2,120,200,500,40);addComponent1(pan_form2,answer2,120,250,500,40);
		addComponent1(pan_form2,question3,120,300,500,40);addComponent1(pan_form2,answer3,120,350,500,40);
		lbl.setForeground(Color.RED);
		addComponent1(pan_form2,confirm,250,400,150,50);
		addComponent1(pan_form2,cancel1,420,400,150,50);
		next.addActionListener(this);
		cancel.addActionListener(this);
		lblCaptcha.setBackground(Color.YELLOW);
		lblCaptcha.setForeground(Color.BLUE);
		country_txt.addItem("India");
		question1.addItem("What Is Your Favourite Colour?");
		question1.addItem("What Is The Name Of Your Childhood Friend?");
		question1.addItem("In What City You Were Born?");
		question1.addItem("What High School Did You Attend?");
		question1.addItem("What Is The Name Of Your First School?");
		question1.addItem("What Is Your Father Middle Name?");
		question1.addItem("What Is Your Favourite Movie?");
		question1.addItem("What Is Your Date Of Birth?");
		question2.addItem("What Is Your Favourite Colour?");
		question2.addItem("What Is The Name Of Your Childhood Friend?");
		question2.addItem("In What City You Were Born?");
		question2.addItem("What high school did you attend?");
		question2.addItem("What Is The Name Of Your First School?");
		question2.addItem("What Is Your Father Middle Name?");
		question2.addItem("What Is Your Favourite Movie?");
		question2.addItem("What Is Your Date Of Birth?");
		question3.addItem("What Is Your Favourite Colour?");
		question3.addItem("What Is The Name Of Your Childhood Friend?");
		question3.addItem("In What City You Were Born?");
		question3.addItem("What High School Did You Attend?");
		question3.addItem("What Is The Name Of Your First School?");
		question3.addItem("What Is Your Father Middle Name?");
		question3.addItem("What Is Your Favourite Movie?");
		question3.addItem("What Is Your Date Of Birth?");
		lbl1.setForeground(Color.RED);lbl1.setVisible(false);
		lbl2.setForeground(Color.RED);lbl2.setVisible(false);
		lbl3.setForeground(Color.RED);lbl3.setVisible(false);
		lbl4.setForeground(Color.RED);lbl4.setVisible(false);
		lbl5.setForeground(Color.RED);lbl5.setVisible(false);
		lbl6.setForeground(Color.RED);lbl6.setVisible(false);
		confirm.addActionListener(this);
		cancel1.addActionListener(this);
		createCapcha();
		setSize(800,620);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void addComponent(Component comp,Component comp1,int x,int y,int w,int h)
	{
		JPanel pan_form1=(JPanel)comp;
		comp1.setBounds(x,y,w,h);
		pan_form1.add(comp1);
		comp1.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	void addComponent1(Component comp2,Component comp3,int x,int y,int w,int h)
	{
		JPanel pan_form2=(JPanel)comp2;
		comp3.setBounds(x,y,w,h);
		pan_form2.add(comp3);
		comp3.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	public void actionPerformed(ActionEvent evt)
	{	
		boolean t=false;
		if(evt.getSource()==next)
		{
				if(acct_no_txt.getText().equals("")||
		      		cif_txt.getText().equals("")||
		      		branch_txt.getText().equals("")||
		      		mob_no_txt.getText().equals("")||
		      		username_txt.getText().equals("")||
		      		password_txt.getText().equals("")||
		      		capt_txt.getText().equals(""))
		      	{
		      		JOptionPane.showMessageDialog(this,"YOU CAN'T LEFT THE FIELDS BLANK","",JOptionPane.INFORMATION_MESSAGE);
		      	}
		        if(!PatternMatching2.numCheck(acct_no_txt.getText()))
				{
					lbl1.setVisible(true);
					acct_no_txt.setText("");;
					t=true;
				}
				else
			{
				lbl1.setVisible(false);
			}
				if(!PatternMatching2.numCheck1(cif_txt.getText()))
				{
					lbl2.setVisible(true);
					cif_txt.setText("");;
					t=true;
				}
				else
			{
				lbl2.setVisible(false);
			}
				if(!PatternMatching2.numCheck1(branch_txt.getText()))
				{
					lbl3.setVisible(true);
					branch_txt.setText("");;
					t=true;
				}
				else
			{
				lbl3.setVisible(false);
			}
				if(!PatternMatching2.mobCheck(mob_no_txt.getText()))
				{
					lbl4.setVisible(true);
					mob_no_txt.setText("");;
					t=true;
				}
				else
			{
				lbl4.setVisible(false);
			}
				if(!PatternMatching2.nameCheck(username_txt.getText()))
				{
					lbl5.setVisible(true);
					username_txt.setText("");;
					t=true;
				}
				else
			{
				lbl5.setVisible(false);
			}
			if(t){return;}
				else 
				{
				if(capt_txt.getText().equals(lblCaptcha.getText()))
		        {
					pan_form2.setVisible(true);
					pan_form1.setVisible(false);
				}
				 else
			     {
			     	JOptionPane.showMessageDialog(this,"Please Enter Correct Captcha","Message",JOptionPane.INFORMATION_MESSAGE);
			     } 			
				}
		}
		else if(evt.getSource()==confirm)
		{	//System.out.println(acct_no_txt.getText());
		      	try
		      	{		      	
		        pst=con.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				pst.setString(1,acct_no_txt.getText());
				pst.setString(2,cif_txt.getText());System.out.println(cif_txt.getText());
				pst.setString(3,branch_txt.getText());System.out.println(branch_txt.getText());
				pst.setString(4,country_txt.getSelectedItem().toString());System.out.println(country_txt.getSelectedItem());
				pst.setString(5,mob_no_txt.getText());System.out.println(mob_no_txt.getText());
				pst.setString(6,username_txt.getText());System.out.println(username_txt.getText());
				pst.setString(7,password_txt.getText());System.out.println(password_txt.getText());
				pst.setString(8,capt_txt.getText());System.out.println(capt_txt.getText());
				pst.setString(9,question1.getSelectedItem().toString());System.out.println(question1.getSelectedItem());
				pst.setString(10,answer1.getText());System.out.println(answer1.getText());
				pst.setString(11,question2.getSelectedItem().toString());System.out.println(question2.getSelectedItem());
				pst.setString(12,answer2.getText());System.out.println(answer2.getText());
				pst.setString(13,question3.getSelectedItem().toString());System.out.println(question3.getSelectedItem());
				pst.setString(14,answer3.getText());System.out.println(answer3.getText());
				
					if(pst.executeUpdate()>0)
					{
					JOptionPane.showMessageDialog(this,"YOU HAVE SUCCESFULLY REGISTERED","",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//new Start();
					}
					else
					{
					JOptionPane.showMessageDialog(this,"DATA NOT INSERTED","SQL Error Message",JOptionPane.WARNING_MESSAGE);		
					}
			     }
			    	
				
				catch(Exception e)
				{	
				System.out.println(e);
				}
		}
		else if(evt.getSource()==cancel)
		{
			dispose();
		}
		else if(evt.getSource()==cancel1)
		{
			dispose();
		}
	}
	public static void main(String ar[])
	{
		new Register();
	}
}