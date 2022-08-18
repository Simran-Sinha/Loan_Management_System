import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class EduSh4 extends JPanel //implements ActionListener
{
	JPanel p= new JPanel();
	JPanel pRight=new JPanel();
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String strHeading[]={"",""};
	JLabel lb = new JLabel("  SBI Global Ed-Vantage Scheme");
	String data1[][]=new String[][]{
		{"ELIGIBlLE COURSES","<html>Regular Graduate/ Post Graduate/ Doctorate Courses in any discipline offered by foreign Institutes/ Universities in USA</html>"},
		{"ELIGIBLE EXPENSES","<html>Fee payable to college,school,hostel,Examination,Library passage money for studies abroad</html>"},
		{"QUANTUM OF FINANCE","<html>Minimum Loan Amount: Rs. 20 Lacs<br>Maximum Loan Amount: Rs. 1.5 Cr</html>"},
		{"PROCESSING FEE","<html>Rs. 10,000/- per application.</html>"},
		{"RATE OF INTEREST","<html>Simple Interest will be charged during Course Period + Moratorium Period</html>"},
		{"MARGIN","<html>Scholarship/assistantship to be included in margin.<BR>Margin to be brought in on year-on-year basis as.</html>"},
		{"REPAYMENT AND HOLIDAY","<html>Accrued interest during the moratorium to be added,EMI fixed.</html>"}
	};

	EduSh4()
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
		tab.setRowHeight(62);
		tab.setFont(new Font("Arial",Font.BOLD,17));
		JTableHeader header = tab.getTableHeader();
		header.setFont(new Font("Arial",Font.BOLD,17));
      	header.setBackground(Color.blue);
      	header.setForeground(Color.white);
      	jsp.setBounds(50,150,800,380);
		p.add(jsp);
	}
	/*public static void main(String []args)
	{
	new EduSh4();
	}*/

}	