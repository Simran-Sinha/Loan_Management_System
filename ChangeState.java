import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.*;
public class ChangeState extends JDialog implements ActionListener
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
	JButton proof_details=new JButton("Proof Details");
	JButton customer_details=new JButton("Customer Details");
	JButton approved_loan=new JButton("Approved Loan");
	JButton payment_details=new JButton("Payment Details");
	JButton report=new JButton("Report");
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String data1[][];
	String strHeading[]={"ID","NAME","STATUS","ACTION"};
	Object obj[][];
	Object value[][];
	JButton update=new JButton("Change Status");
	JButton delete=new JButton("Delete");
	ChangeState()
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
		extra2.add(proof_details);proof_details.setBounds(50,210,270,50);proof_details.setForeground(new Color(0,162,232));proof_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(customer_details);customer_details.setBounds(50,270,270,50);customer_details.setForeground(new Color(0,162,232));customer_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(approved_loan);approved_loan.setBounds(50,330,270,50);approved_loan.setForeground(new Color(0,162,232));approved_loan.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(payment_details);payment_details.setBounds(50,390,270,50);payment_details.setForeground(new Color(0,162,232));payment_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(report);report.setBounds(50,450,270,50);report.setForeground(new Color(0,162,232));report.setFont(new Font("Arial",Font.BOLD,25));
		add(panel);
		panel.setBounds(400,150,950,550);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.add(update);update.setFont(new Font("Arial",Font.BOLD,15));
		update.setBounds(720,100,200,50);
		panel.add(delete);delete.setFont(new Font("Arial",Font.BOLD,15));
		delete.setBounds(720,170,200,50);
		showTable("Select * from loanform1",strHeading);
		back.addActionListener(this);
		add_details.addActionListener(this);
		customer_details.addActionListener(this);
		proof_details.addActionListener(this);
		approved_loan.addActionListener(this);
		payment_details.addActionListener(this);
		report.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		view.addActionListener(this);
		setUndecorated(true);
		setSize(1400,800);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			dispose();
			new SearchDetails();
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
		else if(e.getSource()==proof_details)
		{
			dispose();
			new ProofDetails();
		}
		else if(e.getSource()==payment_details)
		{
			dispose();
			new RecievePayment();
		}
		else if(e.getSource()==delete)
		{
			for(int i=0;i<dfm.getRowCount();i++)
					{
						Boolean checked=(Boolean)dfm.getValueAt(i,3);
						if(checked)
						{
							try
							{
								pst=con.prepareStatement("Delete from loanform1 where cusid=?");
								pst.setInt(1,Integer.parseInt(tab.getValueAt(i,0).toString()));
								if(pst.executeUpdate()>0)
								{
								dfm.removeRow(i);
								i--;
								}	
								else{
									JOptionPane.showMessageDialog(this,"data not deleted");

								}							
							}
							catch(Exception ex){System.out.println(ex);}
						}
					}	
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
		else if(e.getSource()==update)
		{
			String status_txt="Active";
			int value=0;
		try
			{
			pst=con.prepareStatement("update loanform1 set status=? where cusid=?");
			for(int j=0;j<tab.getRowCount();j++)
			{
				value=Integer.parseInt(tab.getValueAt(j,0).toString());
				System.out.println(value);//+"\t"+tab.getValueAt(j,3).toString());
				boolean b=Boolean.parseBoolean(tab.getValueAt(j,3).toString());
				if(b)
				{break;}
			}

			pst.setString(1,status_txt);
			pst.setInt(2,value);
			
			if(pst.executeUpdate()>0)
			{
				JOptionPane.showMessageDialog(this,"Data Updated!!","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
				showTable("Select * from loanform1",strHeading);
							try {

	           			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	       			}
	       		catch (Exception ex)
	       		{
	            	ex.printStackTrace();
	        	}
	            SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new SwingEmailSender().setVisible(true);
	            }
	        	});
				
					
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Data Not Updated","Error Message",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		catch(Exception exc)
		{
			System.out.println(exc);
		}
			
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
				value[i][2]=rst.getString(26);
				value[i][3]=false;
				i++;
			}
				dfm=new DefaultTableModel(value,strHeading)
				{
					public Class getColumnClass(int column)
					{
						return column==3?Boolean.class:String.class;
					}
				};
				tab=new JTable(dfm);
				tab.setFont(new Font("Times New Roman",Font.BOLD,20));
				JTableHeader header = tab.getTableHeader();
      			header.setFont(new Font("Arial",Font.BOLD,20));
      			header.setBackground(new Color(0,162,232));
      			header.setForeground(Color.white);
				tab.setPreferredSize(new Dimension(1200,500));
				tab.setRowHeight(40);
				jsp=new JScrollPane(tab);
				jsp.setBounds(50,50,650,450);
				panel.add(jsp);
		}
		catch(Exception e){System.out.println(e);}
	}
}