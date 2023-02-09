import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class Start extends JFrame implements ActionListener,MouseListener,FocusListener
{
	JPanel main_pan=new JPanel();
	JPanel admin=new JPanel();
	JPanel user=new JPanel();
	JPanel option=new JPanel();
	JButton admin_btn=new JButton("AUTHORITIES");
	JButton user_btn=new JButton("USER LOGIN");
	Font f=new Font("Rockwell",Font.PLAIN,20);
	JButton admin_login=new JButton("LOGIN");
	JButton user_login=new JButton("LOGIN");
	JLabel admin_name=new JLabel("USER NAME");
	JLabel admin_pass=new JLabel("PASSWORD");
	JLabel user_name=new JLabel("USER NAME");
	JLabel user_pass=new JLabel("PASSWORD");
	JTextField admin_name_txt=new JTextField("");
	JTextField user_name_txt=new JTextField("");
	JPasswordField admin_pass_txt=new JPasswordField(20);
	JPasswordField user_pass_txt=new JPasswordField(20);
	JTextField user_password_txt=new JTextField("Enter Password");
	JTextField admin_password_txt=new JTextField("Enter Password");
	JLabel img=new JLabel(new ImageIcon(ImageResize.resize("img/ad1.png",150,140)));
    JLabel img1=new JLabel(new ImageIcon(ImageResize.resize("img/ad1.png",150,140)));
 	JLabel forget_user=new JLabel("Forget Password ?");
    JButton admin_visible_password=new JButton(new ImageIcon(ImageResize.resize("img/invisible.jpg",48,48)));
    JButton user_visible_password=new JButton(new ImageIcon(ImageResize.resize("img/invisible.jpg",48,48)));
    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    JLabel register=new JLabel("New User(Register Yourself)");
    {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	Start()
	{
		setLayout(null);
		add(main_pan);
		main_pan.setLayout(null);
		main_pan.setBackground(Color.WHITE);
		add(admin);
		admin.setBackground(new Color(140,198,255));
		admin.setBounds(400,100,500,500);
		admin.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));
		add(option);
		option.setBackground(Color.BLACK);
		option.setBounds(400,50,500,50);
		option.setLayout(null);
		option.add(admin_btn);
		option.add(user_btn);
		admin_btn.setBounds(0,0,250,50);
		user_btn.setBounds(250,0,250,50);
		add(user);
		user.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));
		user.setBackground(Color.GREEN);
		user.setBounds(400,100,500,500);
		admin_btn.setForeground(Color.BLACK);
		admin_btn.setBackground(Color.WHITE);
		admin_btn.setFont(f);
		user_btn.setForeground(Color.BLACK);
		user_btn.setBackground(Color.WHITE);
		user_btn.setFont(f);
		admin.setLayout(null);
		admin.add(admin_login);
		admin_login.setBounds(150,320,200,50);
		admin_login.setForeground(Color.BLACK);
		admin_login.setBackground(Color.WHITE);
		admin_login.setFont(f);
		user.setLayout(null);
		user.add(user_login);
		user_login.setBounds(150,320,200,50);
		user_login.setForeground(Color.BLACK);
		user_login.setBackground(Color.WHITE);
		user_login.setFont(f);
		admin.add(admin_name);
		admin_name.setBounds(50,150,170,50);
		admin.add(admin_pass);
		admin_pass.setBounds(50,230,160,50);
		admin_password_txt.setBounds(240,230,150,50);
		admin_password_txt.setVisible(false);
		admin.add(admin_password_txt);
		admin.add(admin_visible_password);
		user.add(register);
		register.setBounds(180,400,200,40);
		admin_visible_password.setBounds(390,230,50,50);
		Font fieldFont = new Font("Arial", Font.PLAIN, 20);
		admin_name.setFont(fieldFont);
		user_name.setFont(fieldFont);
		admin_pass.setFont(fieldFont);
		admin_pass_txt.setFont(fieldFont);
		admin_name_txt.setFont(fieldFont);
		user_name_txt.setFont(fieldFont);
		user_pass_txt.setFont(fieldFont);
		admin_password_txt.setFont(fieldFont);
		user_password_txt.setFont(fieldFont);
		user_pass.setFont(fieldFont);
		admin.add(admin_name_txt);
		admin.add(admin_pass_txt);
		admin_name_txt.setBounds(240,150,200,50);
		admin_pass_txt.setBounds(240,230,150,50);
		user.add(user_name);
		user_name.setBounds(50,150,170,50);
		user.add(user_pass);
		user_pass.setBounds(50,230,160,50);
		user_password_txt.setBounds(240,230,150,50);
		user_password_txt.setVisible(false);
		user.add(user_visible_password);
		user_visible_password.setBounds(390,230,50,50);
		user_visible_password.setBackground(new Color(140,198,255));
		user.add(user_name_txt);
		user.add(user_pass_txt);
		user.add(user_password_txt);
		user.add(forget_user);
		forget_user.setBounds(200,370,200,40);
		user_name_txt.setBounds(240,150,200,50);
		user_pass_txt.setBounds(240,230,150,50);
		admin.add(img);
		forget_user.setBackground(new Color(140,198,255));
		img.setBackground(Color.WHITE);
		img.setBounds(150,0,200,150);
		user.add(img1);
		img1.setBounds(150,0,200,150);
		user.setBackground(new Color(140,198,255));
		forget_user.setBackground(new Color(140,198,255));
		admin_btn.addActionListener(this);
		user_btn.addActionListener(this);
		admin_login.addActionListener(this);
		user_login.addActionListener(this);
		admin_visible_password.addActionListener(this);
		user_visible_password.addActionListener(this);
		forget_user.addMouseListener(this);
		//forget_user.addActionListener(this);
		admin_visible_password.setBackground(new Color(140,198,255));
		admin_visible_password.setBorder(null);
		user_visible_password.setBorder(null);
		forget_user.setBorder(null);
		admin_name_txt.addFocusListener(this);
		admin_password_txt.addFocusListener(this);
		admin_pass_txt.addFocusListener(this);
		user_name_txt.addFocusListener(this);
		user_password_txt.addFocusListener(this);
		user_pass_txt.addFocusListener(this);
		register.addMouseListener(this);
		user.setVisible(false);
		setSize(1400,800);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void focusLost(FocusEvent event1)
	{
		if(event1.getSource()==user_name_txt)
		{
			if(user_name_txt.getText().equals(""))
			{
				user_name_txt.setText("enter user name");
			}
			
		}
		else if(event1.getSource()==admin_name_txt)
		{
			if(admin_name_txt.getText().equals(""))
			{
				admin_name_txt.setText("enter admin name");
			}
		}
		
	}
	public void focusGained(FocusEvent event)
	{
		if(event.getSource()==user_name_txt)
		{
			user_name_txt.setText("");
		}
		else if(event.getSource()==admin_name_txt)
		{
			admin_name_txt.setText("");
		}
		else if(event.getSource()==user_pass_txt)
		{
				user_pass_txt.setText("");
		}
		else if(event.getSource()==admin_pass_txt)
		{
			admin_pass_txt.setText("");
		}
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		admin_password_txt.setText(admin_pass_txt.getText());
		user_password_txt.setText(user_pass_txt.getText());
		if(evt.getSource()==user_btn)
		{
			admin.setVisible(false);
			user.setVisible(true);
		}
		else if(evt.getSource()==admin_btn)
		{
			user.setVisible(false);
			admin.setVisible(true);
		}
		if(evt.getSource()==admin_login)
		{
			try
		      {
				pst=con.prepareStatement("select * from login where username=? AND password=?");
				pst.setString(1,admin_name_txt.getText());
				pst.setString(2,admin_pass_txt.getText());
				pst.setString(2,admin_password_txt.getText());
				rst=pst.executeQuery();
				if(rst.next())
				{
					dispose();
					new AdminDashboard();
				}			
				else
				{
					JOptionPane.showMessageDialog(this,"Please check the username and password you have entered","Error Message",JOptionPane.WARNING_MESSAGE);		
				}

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}			
		else if(evt.getSource()==user_login)
		{
            try
		      {
				pst=con.prepareStatement("select username,passsword from register where username=? AND passsword=?");
				pst.setString(1,user_name_txt.getText());
				pst.setString(2,user_pass_txt.getText());
				pst.setString(2,user_password_txt.getText());
				rst=pst.executeQuery();
				if(rst.next())
				{
					dispose();
					//new UserPage();		
				}
				else
				{
					JOptionPane.showMessageDialog(this,"details not matched","SQL Error Message",JOptionPane.WARNING_MESSAGE);		
				}
			  }
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(evt.getSource()==admin_visible_password)
		{
			admin_pass_txt.setVisible(false);
			admin_password_txt.setVisible(true);
			admin_visible_password.setIcon(new ImageIcon(ImageResize.resize("img/visible.jpg",48,48)));
		}
		else if(evt.getSource()==user_visible_password)
		{
			user_password_txt.setVisible(true);
			user_pass_txt.setVisible(false);
			user_visible_password.setIcon(new ImageIcon(ImageResize.resize("img/visible.jpg",48,48)));
		}
		else if(evt.getSource()==forget_user)
		{
			new ForgetPassword();
		}
	}
	public void mouseClicked(MouseEvent evt4)
	{
		if(evt4.getSource()==register)
		{
			new Register();
		}
		else if(evt4.getSource()==forget_user)
		{
			new ForgetPassword();
		}
	}
	public void mousePressed(MouseEvent evt2){}
	public void mouseReleased(MouseEvent evt3){}
	public void mouseEntered(MouseEvent evt1)
	{
		if(evt1.getSource()==forget_user)
		{
			forget_user.setForeground(Color.RED);
		}
		else if(evt1.getSource()==register)
		{
			register.setForeground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent evt5)
	{
		if(evt5.getSource()==forget_user)
		{
			forget_user.setForeground(Color.BLACK);
		}
		else if(evt5.getSource()==register)
		{
			register.setForeground(Color.BLACK);
		}
	}
	public static void main(String ar[])
	{
		new Start();
	}
}