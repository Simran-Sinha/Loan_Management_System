import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class EduSh3 extends JPanel //implements ActionListener
{
	JPanel p= new JPanel();
	JPanel pRight=new JPanel();
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String strHeading[]={"",""};
	JLabel lb = new JLabel("  SBI Skill Loan Scheme");
	String data1[][]=new String[][]{
		{"ELIGIBILITY","<html>Training Institutes/ Courses: Courses run by Industrial Training Institutes (ITIs), National Skill Development Corporation (NSDC</html>"},
		{"LOAN AMOUNT","<html>Minimum Loan Amount: Rs. 5000 <br>Maximum loan amount: Rs. 1,50,000</html>"},
		{"REPAYMENT TENURE","<html>Loans upto Rs 50,000- Upto 3 years</html>"},
		{"TIMELINE FOR APPLICATION","<html>Maximum 6 days, after the receipt of duly completed application with supporting documents.</html>"},
		{"EXPENSES CONSIDERED","<html>Tuition / Course Fee,Examination / Library / Laboratory fee,Purchase of books,equipments and instruments</html>"},
		{"SECURITY","<html>No collateral or third party guarantee will be taken.</html>"}
	};

	EduSh3()
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
		tab.setRowHeight(57);
		tab.setFont(new Font("Arial",Font.BOLD,17));
		JTableHeader header = tab.getTableHeader();
		header.setFont(new Font("Arial",Font.BOLD,17));
      	header.setBackground(Color.blue);
      	header.setForeground(Color.white);
      	jsp.setBounds(50,150,800,350);
		p.add(jsp);
	}
	/*public static void main(String []args)
	{
	new EduSh3();
	}*/

}	