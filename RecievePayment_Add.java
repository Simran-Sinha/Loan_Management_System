import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
public class RecievePayment_Add extends JDialog implements ActionListener
{
	JPanel pan_form=new JPanel();
	JLabel c_id=new JLabel("Customer ID");
	JLabel recipt_no=new JLabel("Reciept No");
	JLabel no_of_pay=new JLabel("Number Of Payment");
	JLabel recipt_date=new JLabel("Reciept Date");
	JLabel emi_date=new JLabel("Emi Date");
	JLabel emi_amount=new JLabel("Emi Amount");
	JLabel late_fine=new JLabel("Late Fine");
	JLabel total_amount=new JLabel("Total Amount");
	JTextField c_id_txt=new JTextField();
	JTextField recipt_no_txt=new JTextField();
	JTextField no_of_pay_txt=new JTextField();
	JTextField recipt_date_txt=new JTextField();
	JTextField emi_date_txt=new JTextField();
	JTextField emi_amount_txt=new JTextField();
	JTextField late_fine_txt=new JTextField();
	JTextField total_amount_txt=new JTextField();
	JButton insert=new JButton("Insert");
	JButton cancel=new JButton("Cancel");
	Connection con;
	ResultSet rst;
	PreparedStatement pst;
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp_tab=null;
	String strHeading[]={"Customer ID","Reciept No","No Of Payment","Reciept Date","Emi Date","Emi Amount","Late Fine","Total Amount","Action"};
	Object data1[][];
	{try
		{	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	RecievePayment_Add()
	{
		setLayout(null);
		add(pan_form);
		pan_form.setLayout(null);
		pan_form.setBackground(new Color(215,215,255));
		pan_form.setBounds(0,0,600,700);
		addComponent(pan_form,c_id,50,50,150,40);addComponent(pan_form,c_id_txt,220,50,200,40);
		addComponent(pan_form,recipt_no,50,100,150,40);addComponent(pan_form,recipt_no_txt,220,100,200,40);
		addComponent(pan_form,no_of_pay,50,150,150,40);addComponent(pan_form,no_of_pay_txt,220,150,200,40);
		addComponent(pan_form,recipt_date,50,200,150,40);addComponent(pan_form,recipt_date_txt,220,200,200,40);
		addComponent(pan_form,emi_date,50,250,150,40);addComponent(pan_form,emi_date_txt,220,250,200,40);
		addComponent(pan_form,emi_amount,50,300,150,40);addComponent(pan_form,emi_amount_txt,220,300,200,40);
		addComponent(pan_form,late_fine,50,350,150,40);addComponent(pan_form,late_fine_txt,220,350,200,40);
		addComponent(pan_form,total_amount,50,400,150,40);addComponent(pan_form,total_amount_txt,220,400,200,40);
		addComponent(pan_form,insert,80,460,150,50);addComponent(pan_form,cancel,250,460,150,50);
		javax.swing.border.TitledBorder titleBorder=BorderFactory.createTitledBorder("Reciept Details");
		titleBorder.setTitleJustification(2);
		titleBorder.setTitleFont(new Font("Monotype Corsiva",Font.BOLD,30));
		pan_form.setBorder(titleBorder);
		insert.addActionListener(this);
		cancel.addActionListener(this);
		setUndecorated(true);
		setSize(600,700);
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
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==cancel)
		{
			dispose();
		}
		else if(evt.getSource()==insert)
		{
			try
		      {
				pst=con.prepareStatement("insert into recieve_emi values(?,?,?,?,?,?,?,?)");
				pst.setString(1,c_id_txt.getText());
				pst.setString(2,recipt_no_txt.getText());
				pst.setString(3,no_of_pay_txt.getText());
				pst.setString(4,recipt_date_txt.getText());
				pst.setString(5,emi_date_txt.getText());
				pst.setString(6,emi_amount_txt.getText());
				pst.setString(7,late_fine_txt.getText());
				pst.setString(8,total_amount_txt.getText());
				rst=pst.executeQuery();
				if(rst.next())
				{
					JOptionPane.showMessageDialog(this,"DATA INSERTED","SQL Error Message",JOptionPane.INFORMATION_MESSAGE);
				showTable("Select * from Recieve_emi",strHeading);
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
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Record Not Found.");
			}
		}
		catch(Exception e){JOptionPane.showMessageDialog(this,e);}
	}
}