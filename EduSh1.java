import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class EduSh1 extends JPanel //implements ActionListener
{
	JPanel p= new JPanel();
	JPanel pRight=new JPanel();
	JTable tab=null;
	DefaultTableModel dfm=null;
	JScrollPane jsp=null;
	String strHeading[]={"",""};
	JLabel lb = new JLabel("  SBI Student Loan Scheme");
	String data1[][]=new String[][]{
		{"ELIGIBILITY","<html>A term loan granted to Indian Nationals for pursuing higher education in India or abroad where admission has been secured</html>"},
		{"COURSES COVERED","<html>Studies in India & Studies in Abroad</html>"},
		{"REPAYMENT","<html>Repayment will commence one year after completion of course <br>Loan to be repaid in 15 years after the commencement of repayment</html>"},
		{"INTEREST RATE","<html>Varies as per the selection of the courses and year involved</html>"},
		{"LOAN AMOUNT","<html>For studies in India - maximum Rs. 10 lacs <br>Studies abroad - maximum Rs. 20 lacs</html>"},
		{"EMI GENERATION","<html>The accrued interest during the moratorium period and course period is added to the principle and repayment is fixed Equated Monthly.</html>"},
		{"SECURITY","<html>Particular Security Upto Rs. 7.5 Lacs<br>Only Parent/ Guardian as co-borrower. </html>"}
	};

	EduSh1()
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
		tab.setRowHeight(55);
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
	new EduSh1();
	}*/

}	