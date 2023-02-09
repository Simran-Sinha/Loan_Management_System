import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;	
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class SearchDetails extends JDialog implements ActionListener
{
	JPanel p= new JPanel();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/a11.png",150,150)));;
	JPanel p1=new JPanel();
	JLabel lb = new JLabel("  Search Customer Details");
	JPanel pp=null;
	JPanel button=new JPanel();
	JButton detail_proof=new JButton("Proof Details",new ImageIcon(ImageResize.resize("img/details.png",180,160)));;
	JButton change_state=new JButton("Change State",new ImageIcon(ImageResize.resize("img/active.png",180,160)));;
	JButton approved_loan=new JButton("Approved Loan",new ImageIcon(ImageResize.resize("img/approve.png",180,160)));;
	JButton recieve_payment=new JButton("Payment Details",new ImageIcon(ImageResize.resize("img/payment.png",180,160)));;
	Border thickBorder = new LineBorder(new Color(0,162,232), 5);
	 JButton back = new JButton("Back");
	 JButton add_member1=new JButton("Add Member");
	JButton customer_detail1=new JButton("Customer Details");
	JButton report1=new JButton("Report");
	JButton logout1=new JButton("Logout");

	SearchDetails()
	{
		setLayout(null);
		add(p);
		p.setLayout(null);
		//p.add(p1);
		//p1.setBounds(150,50,1350,100);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.add(back);
		back.setBounds(1000,20,200,60);
		back.setFont(new Font("Arial",Font.BOLD,30));
		back.setForeground(new Color(0,162,232));
		lb.setBounds(150,50,1350,100);
		lb.setFont(new Font("Arial",Font.BOLD,45));
		p.add(lb1);
		lb1.setBounds(0,30,150,150);
		p.setBounds(0,0,1500,1500);
		p.add(change_state);
		p.add(approved_loan);
		p.add(detail_proof);
		p.add(recieve_payment);
		detail_proof.setBounds(500,200,230,220);
		approved_loan.setBounds(500,450,230,220);
		recieve_payment.setBounds(800,450,230,220);
		change_state.setBounds(800,200,230,220);
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));

		detail_proof.setBorder(thickBorder);
		 change_state.setBorder(thickBorder);
		 approved_loan.setBorder(thickBorder);
		 recieve_payment.setBorder(thickBorder);
		 detail_proof.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		change_state.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		approved_loan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		recieve_payment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		detail_proof.setFont(new Font("Arial",Font.BOLD,20));
		recieve_payment.setFont(new Font("Arial",Font.BOLD,20));
		detail_proof.setForeground(new Color(0,162,232));
		recieve_payment.setForeground(new Color(0,162,232));
		//detail_proof.setBorder(new RoundedBorder(50));

		
		change_state.setFont(new Font("Arial",Font.BOLD,20));
		change_state.setForeground(new Color(0,162,232));
		//change_state.setBorder(new RoundedBorder(50));
		
		approved_loan.setFont(new Font("Arial",Font.BOLD,20));
		approved_loan.setForeground(new Color(0,162,232));

		recieve_payment.setVerticalTextPosition(JButton.BOTTOM);
   		recieve_payment.setHorizontalTextPosition(JButton.CENTER);
		detail_proof.setVerticalTextPosition(JButton.BOTTOM);
   		detail_proof.setHorizontalTextPosition(JButton.CENTER);

   		 change_state.setVerticalTextPosition(JButton.BOTTOM);
   		 change_state.setHorizontalTextPosition(JButton.CENTER);

   		 approved_loan.setVerticalTextPosition(JButton.BOTTOM);
   		 approved_loan.setHorizontalTextPosition(JButton.CENTER);
   		 p.add(button);
   		 button.setBounds(100,200,350,500);
   		 button.setLayout(null);
   		 button.setBackground(Color.WHITE);
   		 button.add(logout1);
   		 button.add(report1);
   		 button.add(customer_detail1);
   		 button.add(add_member1);
   		 //add_member1.setForeground(Color.WHITE);customer_detail1.setForeground(Color.WHITE);report1.setForeground(Color.WHITE);logout1.setForeground(Color.WHITE);
   		 add_member1.setBounds(30,30,250,60);add_member1.setForeground(new Color(0,162,232));add_member1.setFont(new Font("Arial",Font.BOLD,25));
   		 customer_detail1.setBounds(30,120,250,60);customer_detail1.setForeground(new Color(0,162,232));customer_detail1.setFont(new Font("Arial",Font.BOLD,25));
   		 report1.setBounds(30,210,250,60);report1.setForeground(new Color(0,162,232));report1.setFont(new Font("Arial",Font.BOLD,25));
   		 logout1.setBounds(30,300,250,60);logout1.setForeground(new Color(0,162,232));logout1.setFont(new Font("Arial",Font.BOLD,25));
   		 setUndecorated(true);
   		 setVisible(true);
   		 setSize(1500,1500);
   		 p.setBackground(Color.WHITE);
   		 back.addActionListener(this);
		detail_proof.addActionListener(this);
		change_state.addActionListener(this);
		approved_loan.addActionListener(this);
		recieve_payment.addActionListener(this);
		add_member1.addActionListener(this);
		customer_detail1.addActionListener(this);
		report1.addActionListener(this);
		logout1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==detail_proof)
		{
			dispose();
			new ProofDetails();
		}
		else if(evt.getSource()==back)
		{
			dispose();			
		}
		else if(evt.getSource()==change_state)
		{
			dispose();
			new ChangeState();
		}
		else if(evt.getSource()==approved_loan)
		{
			dispose();
			new ApprovedLoan();
		}
		else if(evt.getSource()==recieve_payment)
		{
			dispose();
			new RecievePayment();
		}
		else if(evt.getSource()==customer_detail1)
		{
			dispose();
			new CustomerDetails();
		}
		else if(evt.getSource()==add_member1)
		{
			dispose();
			new LoanApplication();
		}
		else if(evt.getSource()==report1)
		{
			dispose();
			new Reports();
		}
	}
}

