import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class CarSh4 extends JPanel //implements ActionListener
{
	JPanel p= new JPanel();
	JPanel pRight=new JPanel();
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String strHeading[]={"",""};
	JLabel lb = new JLabel(" SBI Nano Youth Car Loan Scheme");
	String data1[][]=new String[][]{
		{"CATEGORY","<html>Under this loan scheme by SBI, The car has to be registered in the name of the first applicant,i.e. Student/ Youngster</html>"},
		{"ELIGIBLE CRITERIA","<html>SBI offers Nano Youth Car Loan Scheme to College going student or youngsters (18 to 25 Years)</html>"},
		{"MIN. AMOUNT","<html>SBI offers Nano Youth Car Loan Scheme for a minimum amount of Rs.1.00 Lac.</html>"},
		{"MAX. AMOUNT","<html>SBI offers Nano Youth Car Loan Scheme for a maximum amount of Rs.2.75 Lac.</html>"},
		{"PROCESSING FEE","<html>No pre-payment penalty is levied for SBINano Youth Car Loan.</html>"},
		{"DOCUMENTS","<html>College ID Card/ latest passing certificate for students.<br>Proof of employment for working professionals.</html>"}
	};

	CarSh4()
	{
		setLayout(new BorderLayout());
		//setLayout(null);
		add(p);
		p.setLayout(null);
		p.setBounds(0,0,900,590);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),10));
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.setBounds(0,0,910,140);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		//p.setBackground(Color.YELLOW);
		setSize(920,630);
		setVisible(true);
		showTable(data1,strHeading);

	}
	void showTable(String st[][],String st1[])
	{
		dfm=new DefaultTableModel(st,st1);
		tab=new JTable(dfm)
		{
			public Component prepareRenderer(TableCellRenderer rendererr,int roww,int column)
			{
				Component componentt= super.prepareRenderer(rendererr,roww,column);
				if(column==0)
				{
					componentt.setBackground(Color.WHITE);
					componentt.setForeground(new Color(0,162,232));

				}
				else if(column==1)
				{
					componentt.setForeground(Color.GRAY);
				}
				return componentt;
			}
		};
		jsp=new JScrollPane(tab);
		tab.getColumnModel().getColumn(0).setPreferredWidth(100);
		tab.getColumnModel().getColumn(1).setPreferredWidth(360);
		tab.setRowHeight(60);
		tab.setFont(new Font("Arial",Font.BOLD,17));
		JTableHeader header = tab.getTableHeader();
		header.setFont(new Font("Arial",Font.BOLD,17));
      	header.setBackground(Color.blue);
      	header.setForeground(Color.white);
      	jsp.setBounds(50,150,800,390);
		p.add(jsp);
	}
	/*public static void main(String []args)
	{
	new CarSh4();
	}*/

}	