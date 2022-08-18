import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
public class Instruction2 extends JDialog implements ActionListener
{
	JPanel panel=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	JPanel pan4=new JPanel();
	JPanel pan5=new JPanel();
	JPanel pan6=new JPanel();
	JButton b1=new JButton("Previous");
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/paper.png",120,120)));;
	JLabel lb2=new JLabel(new ImageIcon(ImageResize.resize("img/acc.png",120,120)));;
	JLabel lb3=new JLabel(new ImageIcon(ImageResize.resize("img/lonapp.png",120,120)));;
	JLabel lb4=new JLabel(new ImageIcon(ImageResize.resize("img/long.png",120,120)));;
	JLabel lb5=new JLabel(new ImageIcon(ImageResize.resize("img/app11.png",120,120)));;
	JLabel lb6=new JLabel(new ImageIcon(ImageResize.resize("img/app1.png",120,120)));;
	JPanel pan_title=new JPanel();
	JLabel pan_title_lbl=new JLabel("                         HOW TO APPLY FOR LOAN");
	JLabel num1=new JLabel("<html><center>01</center></html>");JLabel num2=new JLabel("02");JLabel num3=new JLabel("03");
	JLabel num4=new JLabel("04");JLabel num5=new JLabel("05");JLabel num6=new JLabel("06");
	JLabel dash1=new JLabel("----------------");JLabel dash2=new JLabel("----------------");
	JLabel dash3=new JLabel("----------------");JLabel dash4=new JLabel("----------------");
	JLabel dash5=new JLabel("----------------");JLabel dash6=new JLabel("----------------");
	JLabel title1=new JLabel("<html><center>Purpose</center><center>Application</center><center>Form</center></html>");JLabel title2=new JLabel("<html><center>Account</center><center> Details</center></html>");JLabel title3=new JLabel("<html>Loan Offer <center>Page</center></html>");
	JLabel title4=new JLabel("<html>Scheme Page</html>");JLabel title5=new JLabel("<html><center>Complete </center>Application<center> Form</center></html>");JLabel title6=new JLabel("<html><center>Customer</center> <center>Loan</center> <center>Application</center></html>");
	JLabel body1=new JLabel("<html><p>STEP-1:<br>Open the Loan Purpose Application Form</p></html>");JLabel body2=new JLabel("<html><p>STEP-2:<br>Submit the Account Details in Loan Purpose Form</p></html>");
	JLabel body3=new JLabel("<html><p>STEP-3:<br>As You will submit the details you will be redired to Loan Offer Page.<br>In Loan Offer page you will get the whole details.</p></html>");JLabel body4=new JLabel("<html><p>STEP-4:<br>For more Details visit Scheme Page</p></html>");
	JLabel body5=new JLabel("<html><p>STEP-5:<br>Redirected to Complete Application Form Page.<br>Submit the required Details.</p></html>");JLabel body6=new JLabel("<html><p>STEP-6:<br>Redirected to Customer Loan Application Form.<br>Fill the Form and Submit.</p></html>");
	Instruction2()
	{
		setLayout(null);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,0,1500,900);
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		panel.add(lb6);
		lb1.setBounds(80,140,120,120);
		lb2.setBounds(300,140,120,120);
		lb3.setBounds(510,140,120,120);
		lb4.setBounds(720,140,120,120);
		lb5.setBounds(930,140,120,120);
		lb6.setBounds(1140,140,120,120);

		panel.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),10));
		panel.add(pan_title);pan_title.setBounds(30,10,1300,100);pan_title.setLayout(null);pan_title.add(pan_title_lbl);pan_title_lbl.setBounds(30,10,1300,90);
		pan_title.setBackground(Color.WHITE);
		pan_title_lbl.add(b1);
		pan_title.setFont(new Font("Arial",Font.BOLD,40));
		b1.setBounds(1100,30,150,50);
		pan_title_lbl.setBackground(new Color(0,162,232));
		pan_title_lbl.setForeground(Color.WHITE);pan_title_lbl.setOpaque(true);
		pan_title_lbl.setFont(new Font("Arial",Font.BOLD,45));
		panel.add(pan1);pan1.setBackground(new Color(0,162,232));
		panel.add(pan2);pan2.setBackground(Color.WHITE);
		panel.add(pan3);pan3.setBackground(new Color(0,162,232));
		panel.add(pan4);pan4.setBackground(Color.WHITE);
		panel.add(pan5);pan5.setBackground(new Color(0,162,232));
		panel.add(pan6);pan6.setBackground(Color.WHITE);
		pan1.setBounds(60,250,200,400);
		pan1.setLayout(null);
		pan1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan2.setBounds(280,250,200,400);
		pan2.setLayout(null);
		pan2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan3.setBounds(490,250,200,400);
		pan3.setLayout(null);
		pan3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan4.setBounds(700,250,200,400);
		pan4.setLayout(null);
		pan4.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan5.setBounds(910,250,200,400);
		pan5.setLayout(null);
		pan5.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan6.setBounds(1120,250,200,400);
		pan6.setLayout(null);
		pan6.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		pan1.add(num1);
		num1.setBounds(80,10,100,40);
		num1.setForeground(new Color(0,0,121));
		num1.setFont(new Font("Arial",Font.BOLD,40));
		pan2.add(num2);
		num2.setBounds(80,10,100,40);
		num2.setForeground(new Color(0,0,121));
		num2.setFont(new Font("Arial",Font.BOLD,40));
		pan3.add(num3);
		num3.setBounds(80,10,100,40);
		num3.setForeground(new Color(0,0,121));
		num3.setFont(new Font("Arial",Font.BOLD,40));
		pan4.add(num4);
		num4.setBounds(80,10,100,40);
		num4.setForeground(new Color(0,0,121));
		num4.setFont(new Font("Arial",Font.BOLD,40));
		pan5.add(num5);
		num5.setBounds(80,10,100,40);
		num5.setForeground(new Color(0,0,121));
		num5.setFont(new Font("Arial",Font.BOLD,40));
		pan6.add(num6);
		num6.setBounds(80,10,100,40);
		num6.setForeground(new Color(0,0,121));
		num6.setFont(new Font("Arial",Font.BOLD,40));
		pan1.add(dash1);
		dash1.setBounds(0,60,150,20);
		dash1.setForeground(new Color(0,0,121));
		dash1.setFont(new Font("Arial",Font.BOLD,20));
		pan2.add(dash2);dash2.setBounds(0,60,150,20);dash2.setForeground(new Color(0,0,121));dash2.setFont(new Font("Arial",Font.BOLD,20));
		pan3.add(dash3);dash3.setBounds(0,60,150,20);dash3.setForeground(new Color(0,0,121));dash3.setFont(new Font("Arial",Font.BOLD,20));
		pan4.add(dash4);dash4.setBounds(0,60,150,20);dash4.setForeground(new Color(0,0,121));dash4.setFont(new Font("Arial",Font.BOLD,20));
		pan5.add(dash5);dash5.setBounds(0,60,150,20);dash5.setForeground(new Color(0,0,121));dash5.setFont(new Font("Arial",Font.BOLD,20));
		pan6.add(dash6);dash6.setBounds(0,60,150,20);dash6.setForeground(new Color(0,0,121));dash6.setFont(new Font("Arial",Font.BOLD,20));
		pan1.add(title1);title1.setBounds(30,90,150,70);title1.setForeground(new Color(0,0,121));title1.setFont(new Font("Arial",Font.BOLD,20));
		pan2.add(title2);title2.setBounds(30,90,150,70);title2.setForeground(new Color(0,0,121));title2.setFont(new Font("Arial",Font.BOLD,20));
		pan3.add(title3);title3.setBounds(30,90,150,70);title3.setForeground(new Color(0,0,121));title3.setFont(new Font("Arial",Font.BOLD,20));
		pan4.add(title4);title4.setBounds(30,90,150,70);title4.setForeground(new Color(0,0,121));title4.setFont(new Font("Arial",Font.BOLD,20));
		pan5.add(title5);title5.setBounds(30,90,150,70);title5.setForeground(new Color(0,0,121));title5.setFont(new Font("Arial",Font.BOLD,20));
		pan6.add(title6);title6.setBounds(30,90,150,70);title6.setForeground(new Color(0,0,121));title6.setFont(new Font("Arial",Font.BOLD,20));
		pan1.add(body1);body1.setBounds(10,170,180,200);body1.setForeground(new Color(0,0,121));body1.setFont(new Font("Arial",Font.BOLD,15));
		pan2.add(body2);body2.setBounds(10,170,180,200);body2.setForeground(new Color(0,0,121));body2.setFont(new Font("Arial",Font.BOLD,15));
		pan3.add(body3);body3.setBounds(10,170,180,200);body3.setForeground(new Color(0,0,121));body3.setFont(new Font("Arial",Font.BOLD,15));
		pan4.add(body4);body4.setBounds(10,170,180,200);body4.setForeground(new Color(0,0,121));body4.setFont(new Font("Arial",Font.BOLD,15));
		pan5.add(body5);body5.setBounds(10,170,180,200);body5.setForeground(new Color(0,0,121));body5.setFont(new Font("Arial",Font.BOLD,15));
		pan6.add(body6);body6.setBounds(10,170,180,200);body6.setForeground(new Color(0,0,121));body6.setFont(new Font("Arial",Font.BOLD,15));
		setUndecorated(true);
		setSize(1500,900);
		setVisible(true);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{

		if(evt.getSource()==b1)
		{
				dispose();	
		}
	}
	public static void main(String ar[])
	{
		new Instruction2();
	}
}