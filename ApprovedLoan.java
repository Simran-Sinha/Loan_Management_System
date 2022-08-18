import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class ApprovedLoan extends JDialog implements ActionListener
{
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
	}
	catch(Exception e){}
	}
	JPanel extra1 = new JPanel();
	JPanel extra2 = new JPanel();
	JPanel panel = new JPanel();
	JScrollPane jsp=new JScrollPane	(panel);
	int y=0;
	String s[];
	int h=100;
	String strid;
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/a11.png",150,150)));
	JLabel lb = new JLabel(" LOAN APPROVED");
	JButton back=new JButton("Back");
	JButton add_details=new JButton(" Add Detail");
	JButton customer_details=new JButton("Customer Details");
	JButton detail_proof=new JButton("Proof Details");
	JButton change_state=new JButton("Change State");
	JButton payment_details=new JButton("Payment Details");
	JButton report=new JButton("Report");
	ApprovedLoan()
	{
		setLayout(null);
		add(extra1);
		extra1.setBounds(0,0,1400,150);
		extra1.setLayout(null);
		extra1.setBackground(Color.WHITE);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		extra1.add(lb);
		lb.add(back);
		back.setBounds(970,20,150,50);
		back.setFont(new Font("Arial",Font.BOLD,25));
		back.setForeground(new Color(0,162,232));
		lb.setBounds(180,20,1200,100);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		extra1.add(lb1);
		lb1.setBounds(20,0,150,150);
		add(extra2);
		extra2.setBounds(0,150,400,550);
		extra2.setBackground(Color.WHITE);
		extra2.setLayout(null);
		extra2.add(add_details);add_details.setBounds(50,150,270,50);add_details.setForeground(new Color(0,162,232));add_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(customer_details);customer_details.setBounds(50,210,270,50);customer_details.setForeground(new Color(0,162,232));customer_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(detail_proof);detail_proof.setBounds(50,270,270,50);detail_proof.setForeground(new Color(0,162,232));detail_proof.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(change_state);change_state.setBounds(50,330,270,50);change_state.setForeground(new Color(0,162,232));change_state.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(payment_details);payment_details.setBounds(50,390,270,50);payment_details.setForeground(new Color(0,162,232));payment_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(report);report.setBounds(50,450,270,50);report.setForeground(new Color(0,162,232));report.setFont(new Font("Arial",Font.BOLD,25));
		add(jsp);
		jsp.setBounds(400,150,950,550);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		int y=50;
		int no_of_panel=0;
		String status_txt="Active";
		try{
			pst=con.prepareStatement("Select * from loanform1 where status=?");
			pst.setString(1,status_txt);
			rst=pst.executeQuery();
			while(rst.next())
			{				
				JPanel sp=new JPanel();
				sp.setLayout(null);
				sp.setBackground(new Color(0,162,232));
				sp.setBounds(150,y,600,200);
				strid=rst.getString(25);
				addComponent(sp,new JLabel("Customer ID:"),230,15,100,40);addComponent(sp,new JLabel(rst.getString(25)),340,15,150,40);
						InputStream istream = rst.getBinaryStream("PHOTO");
						byte b[] = istream.readAllBytes();
						Image img = Toolkit.getDefaultToolkit().createImage(b);
						img=img.getScaledInstance(200,150,Image.SCALE_SMOOTH);
				addComponent(sp,new JLabel(""),20,25,200,150);addComponent(sp,new JLabel(new ImageIcon(img)),20,25,200,150);
				addComponent(sp,new JLabel("Name:"),230,60,100,40);addComponent(sp,new JLabel(rst.getString(2)),340,60,150,40);
				addComponent(sp,new JLabel("Phone No:"),230,110,100,40);addComponent(sp,new JLabel(rst.getString(24)),340,110,150,40);
				addComponent(sp,new JLabel("Address:"),230,160,100,40);addComponent(sp,new JLabel(rst.getString(22)),340,160,100,40);
				JButton view=new JButton("View-"+strid);
				view.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						new Customer(strid);
					}
				});
				addComponent(sp,view,450,150,100,30);
				y=y+220;
				panel.add(sp);
				h=200*no_of_panel;
				no_of_panel++;
				}
			}
		catch(Exception	q){}
		panel.setPreferredSize(new Dimension(1000,(no_of_panel*200)+((no_of_panel)*20)));
		back.addActionListener(this);
		add_details.addActionListener(this);
		customer_details.addActionListener(this);
		detail_proof.addActionListener(this);
		change_state.addActionListener(this);
		payment_details.addActionListener(this);
		report.addActionListener(this);
		setUndecorated(true);
		setSize(1400,800);
		setVisible(true);
	}
	void addComponent(Component comp,Component companel,int x,int y,int w,int h)
	{
		JPanel panel=(JPanel)comp;
		companel.setBounds(x,y,w,h);
		panel.add(companel);
		companel.setFont(new Font("Arial",Font.BOLD,15));
		if(companel instanceof JButton)
		{
			JButton btn=(JButton)companel;
			btn.addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			dispose();
			new SearchDetails();
		}
		else if(e.getSource()==detail_proof)
		{
			dispose();
			new ProofDetails();
		}
		else if(e.getSource()==change_state)
		{
			dispose();
			new ChangeState();
		}
		else if(e.getSource()==report)
		{
			dispose();
			new Reports();
		}
		else if(e.getSource()==add_details)
		{
			dispose();
			new LoanApplication();
		}
		else if(e.getSource()==customer_details)
		{
			dispose();
			new CustomerDetails();
		}
		else if(e.getSource()==payment_details)
		{
			dispose();
			new RecievePayment();
		}
		
	}
}