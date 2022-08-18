import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class CarSh3 extends JPanel //implements ActionListener
{
	JPanel p= new JPanel();
	JPanel pRight=new JPanel();
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String strHeading[]={"",""};
	JLabel lb = new JLabel(" SBI Loyalty Car Loan Scheme");
	String data1[][]=new String[][]{
		{"CATEGORY","<html>Self-employed, salaried, and agriculturist individuals are <br>eligible to apply for SBI Loyalty Car Loan Scheme</html>"},
		{"INCOME CRITERIA","<html>Minimum required income of applicant and/or co applicant is Rs. 2,00,000/-</html>"},
		{"BANK CHARGES","<html>Under the SBI Loyalty Car Loan Scheme, bank charges 0.50% above 1 year MCLR i.e. 9.70% p.a. from men; and 0.45% above 1y.</html>"},
		{"ASSURANCE","<html>For car loans not exceeding Rs. 500,000, bank needs to be provided copy of authorization letter signed by borrower.</html>"},
		{"PROCESSING FEE","<html>No pre-payment penalty is levied for SBI Loyalty Car Loan Scheme.</html>"},
		{"AGE LIMIT","Loan provided to applicants between 21- 65 years."}
	};

	CarSh3()
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
	new CarSh3();
	}*/

}	