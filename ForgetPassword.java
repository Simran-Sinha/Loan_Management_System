import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class ForgetPassword extends JDialog implements ActionListener
{
	JPanel main_pan=new JPanel();
	JPanel pan_form=new JPanel();
	JPanel pan_form1=new JPanel();
	JPanel pan_form2=new JPanel();
	JLabel username=new JLabel("ENTER USERNAME");
	JTextField username_txt=new JTextField();
	JLabel security=new JLabel("ANSWER ALL THE SECURITY QUESTIONS:");
	JLabel que1=new JLabel("QUESTION 1:");
	JTextField ans1=new JTextField();
	JLabel que2=new JLabel("QUESTION 2:");
	JTextField ans2=new JTextField();
	JLabel que3=new JLabel("QUESTION 3:");
	JTextField ans3=new JTextField();
	JLabel new_password=new JLabel("ENTER NEW PASSWORD:");
	JLabel re_password=new JLabel("RE-ENTER NEW PASSWORD:");
	JPasswordField new_password_txt=new JPasswordField();
	JPasswordField re_password_txt=new JPasswordField();
	JTextField new_password_txt1=new JTextField();
	JTextField re_password_txt1=new JTextField();
	JButton visible1=new JButton(new ImageIcon(ImageResize.resize("img/visible.jpg",48,48)));
	JButton invisible1=new JButton(new ImageIcon(ImageResize.resize("img/invisible.jpg",48,48)));
	JButton visible2=new JButton(new ImageIcon(ImageResize.resize("img/visible.jpg",48,48)));
	JButton invisible2=new JButton(new ImageIcon(ImageResize.resize("img/invisible.jpg",48,48)));
	JButton submit=new JButton("SUBMIT");
	JButton submit1=new JButton("SUBMIT");
	JButton submit2=new JButton("SUBMIT");
	JButton cancel=new JButton("CANCEL");
	Connection con;
	ResultSet rst;
	PreparedStatement pst;
	{
		try
		{	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	ForgetPassword()
	{
		setLayout(null);
		add(main_pan);
		main_pan.setBackground(new Color(215,215,255));
		main_pan.setLayout(null);
		add(pan_form);
		pan_form.setBackground(new Color(215,215,255));
		pan_form.setLayout(null);
		pan_form.setBounds(0,0,800,90);
		add(pan_form1);
		pan_form1.setBackground(new Color(215,215,255));
		pan_form1.setLayout(null);
		pan_form1.setBounds(0,90,800,400);
		add(pan_form2);
		pan_form2.setBackground(new Color(215,215,255));
		pan_form2.setLayout(null);
		pan_form2.setBounds(0,490,800,400);
		/*javax.swing.border.TitledBorder titleBorder1=BorderFactory.createTitledBorder("Forget Password");
		titleBorder1.setTitleJustification(2);
		titleBorder1.setTitleFont(new Font("Monotype Corsiva",Font.BOLD,30));
		pan_form.setBorder(titleBorder1);
		javax.swing.border.TitledBorder titleBorder2=BorderFactory.createTitledBorder("Forget Password");
		titleBorder2.setTitleJustification(2);
		titleBorder2.setTitleFont(new Font("Monotype Corsiva",Font.BOLD,30));
		pan_form1.setBorder(titleBorder2);*/
		addComponent(pan_form,username,50,30,150,40);addComponent(pan_form,username_txt,230,30,200,40);
		addComponent(pan_form,submit,450,30,150,40);
		addComponent(pan_form1,security,50,20,400,20);
		security.setForeground(Color.RED);
		addComponent1(pan_form1,que1,200,50,300,40);addComponent(pan_form1,ans1,200,100,300,40);
		addComponent1(pan_form1,que2,200,150,300,40);addComponent(pan_form1,ans2,200,200,300,40);
		addComponent1(pan_form1,que3,200,250,300,40);addComponent(pan_form1,ans3,200,300,300,40);
		addComponent1(pan_form1,submit1,550,300,150,40);
		addComponent2(pan_form2,new_password,50,10,300,40);addComponent1(pan_form2,new_password_txt,300,10,200,40);addComponent1(pan_form2,new_password_txt1,300,10,200,40);
		addComponent2(pan_form2,re_password,50,60,300,40);addComponent1(pan_form2,re_password_txt,300,60,200,40);addComponent1(pan_form2,re_password_txt1,300,60,200,40);
		addComponent2(pan_form2,invisible1,500,10,40,40);
		addComponent2(pan_form2,visible1,500,10,40,40);
		addComponent2(pan_form2,invisible2,500,60,40,40);
		addComponent2(pan_form2,visible2,500,60,40,40);
		addComponent2(pan_form2,submit2,150,120,150,50);addComponent1(pan_form2,cancel,320,120,150,50);
		pan_form1.setVisible(false);
		pan_form2.setVisible(false);
		visible1.setVisible(false);
		visible2.setVisible(false);
		new_password_txt1.setVisible(false);
		re_password_txt1.setVisible(false);
		invisible1.addActionListener(this);
		invisible2.addActionListener(this);
		submit1.addActionListener(this);
		submit2.addActionListener(this);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void addComponent(Component comp,Component comp1,int x,int y,int w,int h)
	{
		JPanel pan_form=(JPanel)comp;
		comp1.setBounds(x,y,w,h);
		pan_form.add(comp1);
		comp1.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	void addComponent1(Component comp2,Component comp3,int x,int y,int w,int h)
	{
		JPanel pan_form1=(JPanel)comp2;
		comp3.setBounds(x,y,w,h);
		pan_form1.add(comp3);
		comp3.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	void addComponent2(Component comp4,Component comp5,int x,int y,int w,int h)
	{
		JPanel pan_form2=(JPanel)comp4;
		comp5.setBounds(x,y,w,h);
		pan_form2.add(comp5);
		comp5.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	public void actionPerformed(ActionEvent evt)
	{
		new_password_txt1.setText(new_password_txt.getText());
		re_password_txt1.setText(re_password_txt.getText());
		if(evt.getSource()==invisible1)
		{
			new_password_txt.setVisible(false);
			new_password_txt1.setVisible(true);
			invisible1.setVisible(false);
			visible1.setVisible(true);
		}
		else if(evt.getSource()==invisible2)
		{
			re_password_txt.setVisible(false);
			re_password_txt1.setVisible(true);
			invisible2.setVisible(false);
			visible2.setVisible(true);
		}
		else if(evt.getSource()==cancel)
		{
			dispose();
		}
		else if(evt.getSource()==submit)
		{
			if(username_txt.getText().equals(""))
		   	{
		      	JOptionPane.showMessageDialog(this,"Please Enter User Name","",JOptionPane.INFORMATION_MESSAGE);	
		    }
		    else
		    {
		    try{
		    pst=con.prepareStatement("select * from register where username=?");
			pst.setString(1,username_txt.getText());
			rst=pst.executeQuery();
			if(rst.next())
			{
				que1.setText(rst.getString(9));
				que2.setText(rst.getString(11));
				que3.setText(rst.getString(13));
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Record Not Found","SQL Error Message",JOptionPane.WARNING_MESSAGE);		
			}
			}
			catch(Exception e){}
			submit.setVisible(false);
			pan_form1.setVisible(true);
			}
		}
		else if(evt.getSource()==submit1)
		{
			if(ans1.getText().equals("")||ans2.getText().equals("")||ans3.getText().equals(""))
		   	{
		      	JOptionPane.showMessageDialog(this,"Please Answer All The Question","",JOptionPane.INFORMATION_MESSAGE);	
		    }
		    else
		    {
		    	try
		      	{
		      		pst=con.prepareStatement("select * from register where answer1 = ? and answer2 = ? and answer3 = ? and username=?");
					pst.setString(1,ans1.getText());
					pst.setString(2,ans2.getText());
					pst.setString(3,ans3.getText());
					pst.setString(4,username_txt.getText());
					rst=pst.executeQuery();
					if(rst.next())
					{
						JOptionPane.showMessageDialog(this,"correct info","Correct information",JOptionPane.INFORMATION_MESSAGE);
						pan_form2.setVisible(true);
						submit1.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"OOPS!!InValid Information","Error Message",JOptionPane.INFORMATION_MESSAGE);	
					}
				}
				catch(Exception et){}
			}
		}
		else if(evt.getSource()==submit2)
		{
		    if(new_password_txt.getText().equals("")||re_password_txt.getText().equals(""))
		    {
		      	JOptionPane.showMessageDialog(this,"You can't left the password field blank","",JOptionPane.INFORMATION_MESSAGE);
		    }
		    else if(new_password_txt.getText().equals(re_password_txt.getText()))
		    {	try
		    	{	
		      	pst=con.prepareStatement("update register set password=? where username=?");
				pst.setString(1,new_password_txt.getText());
				pst.setString(2,username_txt.getText());
				rst=pst.executeQuery();
				if(rst.next())
				{
					JOptionPane.showMessageDialog(this,"PASSWORD CHANGED","",JOptionPane.INFORMATION_MESSAGE);		
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Passwor Not Changed","SQL Error Message",JOptionPane.INFORMATION_MESSAGE);		
				}
				}
				catch(Exception et){}
			}
			else
		    {
		    	JOptionPane.showMessageDialog(this,"Please Match The Password Entered","",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public static void main(String ar[])
	{
		new ForgetPassword();
	}
}