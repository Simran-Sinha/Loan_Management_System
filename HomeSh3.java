import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class HomeSh3 extends JPanel //implements ActionListener
{
	JPanel p= new JPanel();
	JPanel pRight=new JPanel();
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String strHeading[]={"",""};
	JLabel lb = new JLabel("  SBI Flexipay Home Loan");
	String data1[][]=new String[][]{
		{"BORROWER TYPE","Resident Indians"},
		{"EMPLOYMENT TYPE","Salaried and Self Employed Professionals"},
		{"LOAN AMOUNT","As per the applicants credit profile"},
		{"INTEREST RATE","Varies from one case to another"},
		{"LOAN TENURE","Upto 30 years"},
		{"PROCESSING FEE","0.35% of the loan amount (Min. of Rs. 2,000 & Max. of Rs. 10,000)"},
		{"PRE PAYMENT CHARGES","Nil for floating rates"},
		{"AGE LIMIT","21 to 45 years (to apply for a loan) & 70 years (for loan repayment)"}
	};

	HomeSh3()
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
		tab.setRowHeight(40);
		tab.setFont(new Font("Arial",Font.BOLD,17));
		JTableHeader header = tab.getTableHeader();
		header.setFont(new Font("Arial",Font.BOLD,17));
      	header.setBackground(Color.blue);
      	header.setForeground(Color.white);
      	jsp.setBounds(50,180,800,350);
		p.add(jsp);
	}
	/*public static void main(String []args)
	{
	new HomeSh3();
	}*/

}	