import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Emi5 extends JDialog implements ActionListener
{
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JLabel lb1 = new JLabel("Rs.");
	JLabel lb2 = new JLabel("Months");
	JLabel lb3 = new JLabel("%");
	JLabel lb4 = new JLabel("Rs.");
	JLabel lb5 = new JLabel("Rs.");
	JLabel lb = new JLabel("           CALCULATE  EMI  FOR");
	JLabel pri= new JLabel("Amount:");
	JLabel tensure= new JLabel("Duration:");
	JLabel rate= new JLabel("Interest Rate:");
	JLabel emi= new JLabel("EMI Calculated:");
	JLabel interest= new JLabel("Total Interest:");
	JButton calculate = new JButton("Calculate");
	JButton reset = new JButton("Reset");
	JTextField pri1 = new JTextField();
	JTextField tensure1 = new JTextField();
	JTextField rate1 = new JTextField();
	JTextField emi1 = new JTextField();
	JTextField interest1 = new JTextField();
	Emi5()
	{
		setLayout(null);
		add(p);
		p.setLayout(null);
		p1.setLayout(null);
		p1.setBackground(new Color(0,162,232));
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(new Color(0,162,232));
		
		p1.add(lb);
		lb.setBounds(0,20,900,100);
		lb.setForeground(Color.WHITE);

		lb.setFont(new Font("Times New Roman",Font.BOLD,40));
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.setBounds(0,0,900,640);
		 p1.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),4));
		 p2.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),4));
		 p3.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),4));
		 p4.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),4));

		p1.setBounds(0,0,900,100);
		p2.setBounds(0,100,450,400);
		p3.setBounds(450,100,450,400);
		p4.setBounds(0,500,900,100);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);

		p2.add(pri);
		p2.add(pri1);
		p2.add(tensure);
		p2.add(tensure1);
		p2.add(rate);
		p2.add(rate1);
		p2.add(lb1);
		p2.add(lb2);
		p2.add(lb3);
		p3.add(emi);
		p3.add(emi1);
		p3.add(interest);
		p3.add(interest1);
		p3.add(lb4);
		p3.add(lb5);
		p4.add(calculate);
		p4.add(reset);

		pri.setBounds(50,0,200,50);
		pri1.setBounds(50,50,200,50);
		lb1.setBounds(250,50,100,50);

		tensure.setBounds(50,100,200,50);
		tensure1.setBounds(50,150,200,50);
		lb2.setBounds(250,150,100,50);

		rate.setBounds(50,200,200,50);
		rate1.setBounds(50,250,200,50);
		lb3.setBounds(250,250,100,50);

		emi.setBounds(50,80,200,50);
		emi1.setBounds(50,130,200,50);
		lb4.setBounds(250,130,100,50);

		interest.setBounds(50,180,200,50);
		interest1.setBounds(50,220,200,50);
		lb5.setBounds(250,220,100,50);

		calculate.setBounds(200,10,150,60);
		reset.setBounds(400,10,150,60);


		pri.setFont(new Font("Times New Roman",Font.BOLD,25));
		tensure.setFont(new Font("Times New Roman",Font.BOLD,25));
		calculate.setFont(new Font("Times New Roman",Font.BOLD,25));
		reset.setFont(new Font("Times New Roman",Font.BOLD,25));
		rate.setFont(new Font("Times New Roman",Font.BOLD,25));
		emi.setFont(new Font("Times New Roman",Font.BOLD,25));
		interest.setFont(new Font("Times New Roman",Font.BOLD,25));

		pri1.setFont(new Font("Times New Roman",Font.BOLD,20));
		tensure1.setFont(new Font("Times New Roman",Font.BOLD,20));
		rate1.setFont(new Font("Times New Roman",Font.BOLD,20));
		emi1.setFont(new Font("Times New Roman",Font.BOLD,20));
		interest1.setFont(new Font("Times New Roman",Font.BOLD,20));

		lb1.setFont(new Font("Times New Roman",Font.BOLD,25));
		lb2.setFont(new Font("Times New Roman",Font.BOLD,25));
		lb3.setFont(new Font("Times New Roman",Font.BOLD,25));
		lb4.setFont(new Font("Times New Roman",Font.BOLD,25));
		lb5.setFont(new Font("Times New Roman",Font.BOLD,25));
		lb1.setForeground(new Color(0,162,232));
		lb2.setForeground(new Color(0,162,232));
		lb3.setForeground(new Color(0,162,232));
		lb4.setForeground(new Color(0,162,232));
		lb5.setForeground(new Color(0,162,232));
		//setUndecorated(true);



		
		setVisible(true);
		setSize(900,610);
		
		calculate.addActionListener(this);
		reset.addActionListener(this);


	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==calculate)
		{

		try
		{

		if(pri1.getText().equals("")||rate1.getText().equals("")||tensure1.getText().equals(""))
		{
			//JOptionPane.showMessageDialog(this,"Fields are Blank!!please enter numeric value");
			//JOptionPane.showMessageDialog(this,"Please Enter the numeric value","Error Message",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(this,"Fields are Blank!!Please Enter Numeric Value","Information Message",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(ImageResize.resize("img/emi1.png",50,50)));
			//ERROR_MESSAGE,WARNING_MESSAGE,INFORMATION_MESSAGE,QUESTION_MESSAGE,PLAIN_MESSAGE
		}

		
		
		else
		{
			double p1=0,t1=0,r1=0;
			double emical,si;
			p1=Double.parseDouble(pri1.getText());
			t1=Double.parseDouble(rate1.getText());
			r1=Double.parseDouble(tensure1.getText());
			r1 = r1 / (12 * 100); // one month interest 
       		t1 = t1 * 12; // one month period 
       		emical = (p1 * r1 *Math.pow(1 + r1, t1))/(Math.pow(1 + r1, t1) - 1); 
      
				si=(p1*r1*t1)/100;
				emi1.setText(String.valueOf((long)emical));
				interest1.setText(String.valueOf((long)si));

				}
			}
			catch(Exception ev)
			{
				System.out.println(ev);
			}
		}
		else if(e.getSource()==reset)
				{
					rate1.setText("");
					pri1.setText("");
					tensure1.setText("");
					emi1.setText("");
					interest1.setText("");
				}
	}


	public static void main(String[] args)
	 {
		new Emi5();
	}
}