import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.*;
public class ProofDetails extends JDialog implements ActionListener
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
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/a11.png",150,150)));
	JLabel lb = new JLabel("Submitted Proof Details");
	JButton back=new JButton("Back");
	JLabel search=new JLabel("Enter Customer Id:");
	JTextField search_txt=new JTextField();
	JButton view=new JButton("Search");
	
	JButton add_details=new JButton(" Add Detail");
	JButton change_state=new JButton("Change State");
	JButton customer_details=new JButton("Customer Details");
	JButton approved_loan=new JButton("Approved Loan");
	JButton payment_details=new JButton("Payment Details");
	JButton report=new JButton("Report");

	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String data1[][];
	String strHeading[]={"ID","NAME","IDENTITY","ADDRESS","INCOME"};
	Object obj[][];
	Object value[][];
	ImageIcon tick=new ImageIcon(Toolkit.getDefaultToolkit().getImage("img/tick.jpeg").getScaledInstance(30,30,Image.SCALE_SMOOTH));
	ImageIcon cross=new ImageIcon(Toolkit.getDefaultToolkit().getImage("img/cross.png").getScaledInstance(30,30,Image.SCALE_SMOOTH));
	ProofDetails()
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
		extra2.add(search);
		extra2.add(search_txt);
		extra2.add(view);
		search.setBounds(30,30,150,50);
		search_txt.setBounds(180,30,200,50);
		view.setBounds(180,90,100,40);
		extra2.add(add_details);add_details.setBounds(50,150,270,50);add_details.setForeground(new Color(0,162,232));add_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(change_state);change_state.setBounds(50,210,270,50);change_state.setForeground(new Color(0,162,232));change_state.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(customer_details);customer_details.setBounds(50,270,270,50);customer_details.setForeground(new Color(0,162,232));customer_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(approved_loan);approved_loan.setBounds(50,330,270,50);approved_loan.setForeground(new Color(0,162,232));approved_loan.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(payment_details);payment_details.setBounds(50,390,270,50);payment_details.setForeground(new Color(0,162,232));payment_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(report);report.setBounds(50,450,270,50);report.setForeground(new Color(0,162,232));report.setFont(new Font("Arial",Font.BOLD,25));

		add(panel);
		panel.setBounds(400,150,950,550);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		showTable("Select * from loanform1",strHeading);
		back.addActionListener(this);
		add_details.addActionListener(this);
		customer_details.addActionListener(this);
		change_state.addActionListener(this);
		approved_loan.addActionListener(this);
		payment_details.addActionListener(this);
		report.addActionListener(this);
		view.addActionListener(this);
		setUndecorated(true);
		setSize(1400,800);
		setVisible(true);
		tab.addMouseListener(
			new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					int row=tab.getSelectedRow();
					int column=tab.getSelectedColumn();
					new ProofDetails_Image(tab.getValueAt(row,0).toString(),column);
		
				}
			});
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			dispose();
			new SearchDetails();
		}
		else if(e.getSource()==view)
		{
			try
				{
					pst=con.prepareStatement("Select * from loanform1 where cusid=?");
					pst.setString(1,search_txt.getText());
					ResultSet rst=pst.executeQuery();
					if(pst.executeUpdate()>0)
					{
						for(int j=0;j<tab.getRowCount();j++)
						{
						int value=Integer.parseInt(tab.getValueAt(j,0).toString());
						if(value==Integer.parseInt(search_txt.getText()))
						{
							tab.setRowSelectionInterval(j,j);
							tab.setSelectionBackground(new Color(0,124,192));
							JOptionPane.showMessageDialog(this,"Record Found","SQL Information Message",JOptionPane.WARNING_MESSAGE);	
							break;
						}
						}	
					}			
		    		else
					{
					tab.clearSelection();
					JOptionPane.showMessageDialog(this,"Record Not Found","SQL Error Message",JOptionPane.WARNING_MESSAGE);		
					}								
				}
				catch(Exception exce){System.out.println(exce);}
		}
		else if(e.getSource()==customer_details)
		{
			dispose();
			new CustomerDetails();
		}
		else if(e.getSource()==approved_loan)
		{
			dispose();
			new ApprovedLoan();
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
		else if(e.getSource()==change_state)
		{
			dispose();
			new ChangeState();
		}
		else if(e.getSource()==payment_details)
		{
			dispose();
			new RecievePayment();
		}
	}
	void showTable(String query,String st1[])
	{
		try
		{
			pst=con.prepareStatement("Select count(*) from loanform1");
			int row=0;
			rst=pst.executeQuery();
			if(rst.next()){row=rst.getInt(1);}
			value=new Object[row][strHeading.length];
			pst=con.prepareStatement("Select * from loanform1");
			rst=pst.executeQuery();
			int i=0;
			while(rst.next())
			{
				value[i][0]=rst.getInt(25)+"";
				value[i][1]=rst.getString(2);
				
				byte b[]=rst.getBytes(16);
				byte b1[]=rst.getBytes(18);
				byte b2[]=rst.getBytes(20);
				if(b==null)
				{
					value[i][2]=cross;
				}
				if(b1==null)
				{
					value[i][3]=cross;
				}
				if(b2==null)
				{
					value[i][4]=cross;
				}
				if(b!=null)
				{
					value[i][2]=tick;
				}
				if(b1!=null)
				{
					value[i][3]=tick;
				}
				if(b2!=null)
				{
					value[i][4]=tick;
				}
			i++;	
			}
				dfm=new DefaultTableModel(value,strHeading)
				{
					public Class getColumnClass(int column)
					{
						return column==2||column==3||column==4?Icon.class:String.class;
					}
				};
				tab=new JTable(dfm);
				tab.setFont(new Font("Times New Roman",Font.BOLD,20));
				JTableHeader header = tab.getTableHeader();
      			header.setFont(new Font("Arial",Font.BOLD,20));
      			header.setBackground(new Color(0,162,232));
      			header.setForeground(Color.WHITE);
				tab.setPreferredSize(new Dimension(1200,500));
				tab.setRowHeight(40);
				jsp=new JScrollPane(tab);
				jsp.setBounds(50,50,650,450);
				panel.add(jsp);
		}
		catch(Exception e){System.out.println(e);}
	}
}