import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.*;
public class RecievePayment extends JDialog implements ActionListener
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
	JLabel lb = new JLabel("Recieved Payment");
	JButton back=new JButton("Back");
	JLabel search=new JLabel("Enter Customer Id:");
	JTextField search_txt=new JTextField();
	JButton view=new JButton("Search");
	
	JButton add_details=new JButton(" Add Detail");
	JButton customer_details=new JButton("Customer Details");
	JButton detail_proof=new JButton("Proof Details");
	JButton approved_loan=new JButton("Approved Loan");
	JButton change_state=new JButton("Change State");
	JButton report=new JButton("Report");
	
	
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp_tab=null;
	String strHeading[]={"Customer ID","Reciept No","No Of Payment","Reciept Date","Emi Date","Emi Amount","Late Fine","Total Amount","Action"};
	Object data1[][];
	JButton add=new JButton("Add");
	JButton update=new JButton("Update");
	JButton delete=new JButton("Delete");
	JButton refresh=new JButton("Refresh");
	RecievePayment()
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
		extra2.add(customer_details);customer_details.setBounds(50,210,270,50);customer_details.setForeground(new Color(0,162,232));customer_details.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(detail_proof);detail_proof.setBounds(50,270,270,50);detail_proof.setForeground(new Color(0,162,232));detail_proof.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(approved_loan);approved_loan.setBounds(50,330,270,50);approved_loan.setForeground(new Color(0,162,232));approved_loan.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(change_state);change_state.setBounds(50,390,270,50);change_state.setForeground(new Color(0,162,232));change_state.setFont(new Font("Arial",Font.BOLD,25));
		extra2.add(report);report.setBounds(50,450,270,50);report.setForeground(new Color(0,162,232));report.setFont(new Font("Arial",Font.BOLD,25));
		
		add(panel);
		panel.setBounds(400,150,950,550);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.add(add);add.setFont(new Font("Arial",Font.BOLD,15));
		add.setBounds(200,400,150,50);
		panel.add(update);update.setFont(new Font("Arial",Font.BOLD,15));
		update.setBounds(370,400,150,50);
		panel.add(delete);delete.setFont(new Font("Arial",Font.BOLD,15));
		delete.setBounds(530,400,150,50);
		panel.add(refresh);refresh.setFont(new Font("Arial",Font.BOLD,15));
		refresh.setBounds(690,400,150,50);
		showTable("Select * from Recieve_emi",strHeading);
		back.addActionListener(this);
		customer_details.addActionListener(this);
		delete.addActionListener(this);
		add.addActionListener(this);
		update.addActionListener(this);
		add_details.addActionListener(this);
		customer_details.addActionListener(this);
		detail_proof.addActionListener(this);
		approved_loan.addActionListener(this);
		change_state.addActionListener(this);
		report.addActionListener(this);
		refresh.addActionListener(this);
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
		else if(e.getSource()==detail_proof)
		{
			dispose();
			new ProofDetails();
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
		else if(e.getSource()==customer_details)
		{
			dispose();
			new CustomerDetails();
		}
		else if(e.getSource()==change_state)
		{
			dispose();
			new ChangeState();
		}
		else if(e.getSource()==refresh)
		{
			showTable("Select * from Recieve_emi",strHeading);
		}
		else if(e.getSource()==delete)
		{
			for(int i=0;i<dfm.getRowCount();i++)
					{
						Boolean checked=(Boolean)dfm.getValueAt(i,8);
						if(checked)
						{
							try
							{
								pst=con.prepareStatement("Delete from recieve_emi where customer_id=?");
								pst.setInt(1,Integer.parseInt(dfm.getValueAt(i,0).toString()));
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
		else if(e.getSource()==add)
		{
			new RecievePayment_Add();
			showTable("Select * from Recieve_emi",strHeading);
		}
		else if(e.getSource()==update)
		{
			new RecievePayment_Update();
			showTable("Select * from Recieve_emi",strHeading);
		}
		else if(e.getSource()==view)
		{
			try
				{
					pst=con.prepareStatement("Select * from Recieve_emi where customer_id=?");
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
	}
	void showTable(String query,String st1[])
	{
		try
		{
			pst=con.prepareStatement("Select count(*) from recieve_emi");
			int row=0;
			rst=pst.executeQuery();
			if(rst.next()){row=rst.getInt(1);}
			data1=new Object[row][st1.length];
			if(row!=0)
			{
				pst=con.prepareStatement(query);
				rst=pst.executeQuery();
				int j=0;
				while(rst.next())
				{
					for(int i=0;i<st1.length-1;i++)
					data1[j][i]=rst.getString(i+1);
					data1[j][st1.length-1]=false;
					j++;
				}
				dfm=new DefaultTableModel(data1,st1)
				{
					public  Class<?> getColumnClass(int column) {
					return column==8?Boolean.class:String.class;
					}
				};
				tab=new JTable(dfm);
				tab.setFont(new Font("Times New Roman",Font.BOLD,15));
				JTableHeader header = tab.getTableHeader();
      			header.setFont(new Font("Arial",Font.BOLD,15));
      			header.setBackground(new Color(0,162,232));
      			header.setForeground(Color.white);
				tab.setPreferredSize(new Dimension(1200,500));
				tab.setRowHeight(30);
				jsp_tab=new JScrollPane(tab);
				jsp_tab.setBounds(30,20,900,350);
				panel.add(jsp_tab);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Record Not Found.");
			}
		}
		catch(Exception e){JOptionPane.showMessageDialog(this,e);}
	}
}