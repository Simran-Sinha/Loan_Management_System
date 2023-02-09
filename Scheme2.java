import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
public class Scheme2 extends JDialog implements ActionListener
{
	JPanel p= new JPanel();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/school1.jpg",140,130)));;
	JPanel p1=new JPanel();
	JPanel pp=null;
	JLabel lb= new JLabel("  SBI Student Loan Schemes");
	JButton sch1= new JButton("SCHEME 1");
	JButton sch2= new JButton("SCHEME 2");
	JButton sch3= new JButton("SCHEME 3");
	JButton sch4= new JButton("SCHEME 4");
	
	JPanel panel= new JPanel();
	JPanel p2=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	JPanel pan4=new JPanel();
	JPanel pan5=new JPanel();
	JLabel lb2=new JLabel(new ImageIcon(ImageResize.resize("img/hat.png",120,125)));;
	JLabel lb3=new JLabel(new ImageIcon(ImageResize.resize("img/hat.png",120,125)));;
	JLabel lb4=new JLabel(new ImageIcon(ImageResize.resize("img/hat.png",120,125)));;
	JLabel lb5=new JLabel(new ImageIcon(ImageResize.resize("img/hat.png",120,125)));;
	
	JLabel title1=new JLabel("<html>Scholar loan</html>");
	JLabel title2=new JLabel("<html><center>Global-Ed<br>Vantage</center></html>");
	JLabel title3=new JLabel("<html>Skill Loan</html>");
	JLabel title4=new JLabel("<html>Take over of Education Loan</html>");
	JButton logout=new JButton("Previous");
	
	JLabel body1=new JLabel("<html><p>Education loan for Courses at select leading Institutions in India like IITs, IIMs, NITs and other premier Institutions. Loan amount upto Rs. 40 lacs..</p></html>");
	JLabel body2=new JLabel("<html><p>Education loan exclusively for full-time regular courses at foreign Colleges/Universities. Loan amount from Rs 20 lacs upto Rs 1.5 Crores.</p></html>");
	JLabel body3=new JLabel("<html><p>Skill Loan for pursuing Vocational Education and Training in India where admission has been secured</p></html>");
	JLabel body4=new JLabel("<html><p>With SBI Take-over of Education Loans, you can switch your existing high cost Education Loan to SBI and reduce your monthly EMIs.</p></html>");
	JPanel pp2=new JPanel();
	JPanel ppp=null;
	Scheme2()
	{
		setLayout(null);
		add(panel);
		panel.add(p);
		panel.add(p1);
		panel.add(pp2);
		pp2.setBounds(380,130,900,550);
		pp2.setLayout(new BorderLayout());
		panel.setBounds(0,0,1500,1400);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));
		p.setLayout(null);
		p.setBounds(20,10,1340,130);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.add(logout);
		logout.setBounds(900,30,150,50);
		lb.setBounds(180,10,1200,130);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		p.add(lb1);
		lb1.setBounds(20,0,140,130);
		p1.setBounds(50,210,280,440);
		p1.setBackground(new Color(0,162,232));
		p1.setLayout(null);
		p1.add(sch1);
		p1.add(sch2);
		p1.add(sch3);
		p1.add(sch4);
		panel.setBackground(Color.WHITE);
		
		sch1.setBounds(40,60,200,50);
		sch2.setBounds(40,140,200,50);
		sch3.setBounds(40,220,200,50);
		sch4.setBounds(40,300,200,50);
		
		sch1.setFont(new Font("Arial",Font.BOLD,20));
		sch1.setForeground(new Color(0,162,232));
		 sch2.setFont(new Font("Arial",Font.BOLD,20));
		 sch2.setForeground(new Color(0,162,232));
		sch3.setFont(new Font("Arial",Font.BOLD,20));
		sch3.setForeground(new Color(0,162,232));
		sch4.setFont(new Font("Arial",Font.BOLD,20));
		sch4.setForeground(new Color(0,162,232));
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		lb2.setBounds(410,140,120,125);
		lb3.setBounds(650,140,120,125);
		lb4.setBounds(870,140,120,125);
		lb5.setBounds(1100,140,120,125);
		panel.add(pan1);pan1.setBackground(new Color(0,162,232));
		panel.add(pan2);pan2.setBackground(Color.WHITE);
		panel.add(pan3);pan3.setBackground(new Color(0,162,232));
		panel.add(pan4);pan4.setBackground(Color.WHITE);
		panel.add(pan5);pan5.setBackground(new Color(0,162,232));
		pan1.setBounds(380,250,200,400);
		pan1.setLayout(null);
		pan1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan2.setBounds(620,250,200,400);
		pan2.setLayout(null);
		pan2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan3.setBounds(840,250,200,400);
		pan3.setLayout(null);
		pan3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan4.setBounds(1070,250,200,400);
		pan4.setLayout(null);
		pan4.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan1.add(title1);title1.setBounds(30,90,150,70);title1.setForeground(new Color(0,0,121));title1.setFont(new Font("Arial",Font.BOLD,20));
		pan2.add(title2);title2.setBounds(30,90,150,70);title2.setForeground(new Color(0,0,121));title2.setFont(new Font("Arial",Font.BOLD,20));
		pan3.add(title3);title3.setBounds(30,90,150,70);title3.setForeground(new Color(0,0,121));title3.setFont(new Font("Arial",Font.BOLD,20));
		pan4.add(title4);title4.setBounds(30,90,150,70);title4.setForeground(new Color(0,0,121));title4.setFont(new Font("Arial",Font.BOLD,20));
		pan1.add(body1);body1.setBounds(10,170,180,200);body1.setForeground(new Color(0,0,121));body1.setFont(new Font("Arial",Font.BOLD,18));
		pan2.add(body2);body2.setBounds(10,170,180,200);body2.setForeground(new Color(0,0,121));body2.setFont(new Font("Arial",Font.BOLD,18));
		pan3.add(body3);body3.setBounds(10,170,180,200);body3.setForeground(new Color(0,0,121));body3.setFont(new Font("Arial",Font.BOLD,18));
		pan4.add(body4);body4.setBounds(10,170,180,200);body4.setForeground(new Color(0,0,121));body4.setFont(new Font("Arial",Font.BOLD,18));
		pp2.setVisible(false);
		setUndecorated(true);
		setSize(1500,1400);
		setVisible(true);
		sch1.addActionListener(this);
		sch2.addActionListener(this);
		sch3.addActionListener(this);
		sch4.addActionListener(this);
		logout.addActionListener(this);


	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==logout)
		{
				dispose();
				

		}
	else if(evt.getSource()==sch1)
		{
				if(ppp!=null)
					{
					ppp.setVisible(false);
					ppp=null;
					}
					ppp= new EduSh1();
					ppp.setPreferredSize(new Dimension(910,600));
					ppp.setBounds(380,160,910,600);
					pp2.add(ppp);
					//repaint();
					pp2.setVisible(false);
					pp2.setVisible(true);

		}
		if(evt.getSource()==sch2)
		{
			if(ppp!=null)
					{
					ppp.setVisible(false);
					ppp=null;
					}
					ppp= new EduSh2();
					ppp.setPreferredSize(new Dimension(910,600));
					ppp.setBounds(380,160,910,600);
					pp2.add(ppp);
					//repaint();
					pp2.setVisible(false);
					pp2.setVisible(true);

		}
		if(evt.getSource()==sch3)
		{
				if(ppp!=null)
					{
					ppp.setVisible(false);
					ppp=null;
					}
					ppp= new EduSh3();
					ppp.setPreferredSize(new Dimension(910,600));
					ppp.setBounds(380,160,910,600);
					pp2.add(ppp);
					//repaint();
					pp2.setVisible(false);
					pp2.setVisible(true);

		}
		if(evt.getSource()==sch4)
		{
				if(ppp!=null)
					{
					ppp.setVisible(false);
					ppp=null;
					}
					ppp= new EduSh4();
					ppp.setPreferredSize(new Dimension(910,600));
					ppp.setBounds(380,160,910,600);
					pp2.add(ppp);
					//repaint();
					pp2.setVisible(false);
					pp2.setVisible(true);

		}
	}
	public static void main(String []args)
{
	new Scheme2();
}

}