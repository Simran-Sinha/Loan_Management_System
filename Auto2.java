import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
public class Auto2 extends JDialog implements ActionListener
{
	Connection con;
		PreparedStatement pst;
		ResultSet rst;
		{
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
			}
			catch(Exception e){}
		}
	
	JPanel main1= new JPanel();
	
	{
	home=new JButton("Terms and Conditions",new ImageIcon(ImageResize.resize("img/term1.png",180,160)));;
	cusdetail=new JButton("Application form",new ImageIcon(ImageResize.resize("img/appl.jpg",180,160)));;
	loandetail=new JButton("Emi Calculator",new ImageIcon(ImageResize.resize("img/emi44.png",180,160)));;
	emidetail=new JButton("Eligibility",new ImageIcon(ImageResize.resize("img/tick.jfif",180,160)));;
	}
	JButton home;
	JButton cusdetail;
	JButton loandetail;
	JButton emidetail;
	 Border thickBorder = new LineBorder(new Color(0,162,232), 5);
	JPanel panjtree=new JPanel();
	JLabel img = new JLabel();
	JPanel pp=null;
	JPanel p = new JPanel();
	{
	img=new JLabel(new ImageIcon(ImageResize.resize("img/sbi.png",120,120)));;
	
	}
	JLabel lb = new JLabel("          Auto Loan");
	DefaultMutableTreeNode main=new DefaultMutableTreeNode("SBI Auto Loan Details");
	DefaultMutableTreeNode home1=new DefaultMutableTreeNode("Auto Loan");
	Image img4=Toolkit.getDefaultToolkit().getImage("img/bank.jpg").getScaledInstance(20,20,Image.SCALE_SMOOTH);
	Image img5=Toolkit.getDefaultToolkit().getImage("img/bank.jpg").getScaledInstance(20,20,Image.SCALE_SMOOTH);
	DefaultMutableTreeNode cus1=new DefaultMutableTreeNode("Scheme");
	DefaultMutableTreeNode loan1=new DefaultMutableTreeNode("How to Apply");
	DefaultMutableTreeNode payment1=new DefaultMutableTreeNode("Logout");
	DefaultMutableTreeNode reports1=new DefaultMutableTreeNode("Feedback");
	DefaultMutableTreeNode help=new DefaultMutableTreeNode("Help");
	JTree tree;
	JScrollPane jsp;
	JButton logout = new JButton("Go to UserPortal");
	JDialog pp1=null;
	JButton b1= new JButton("Email Confirmation Info");
	Auto2()
	{
		setLayout(null);
		panjtree.setBounds(50,200,270,490);
		add(panjtree);
		panjtree.setLayout(new BorderLayout());
		main.add(home1);
		main.add(cus1);
		main.add(loan1);
		main.add(payment1);
		main.add(reports1);
		main.add(help);
		tree=new JTree(main);
		jsp=new JScrollPane(tree);
		panjtree.add(jsp);
		DefaultTreeCellRenderer cr = new DefaultTreeCellRenderer();
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
		tree.setCellRenderer(cr);
		 tree.setBackground(new Color(0,162,232));
		 tree.setFont(new Font("Arial",Font.BOLD,20));
		 renderer.setBackgroundNonSelectionColor(Color.WHITE);
        renderer.setBorderSelectionColor(Color.YELLOW);
        
tree.addMouseListener(
		new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt)
			{
				Object o=tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode tn=(DefaultMutableTreeNode)o;
				String title=(String)tn.getUserObject();
				if(title.equals("Logout"))
				{
					dispose();
					//new Main2();
					
				}
				else if(title.equals("How to Apply"))
				{
				new Instruction2();
					
				}
				else if(title.equals("Scheme"))
				{
				new Scheme1();
					
				}
				else if(title.equals("Auto Loan"))
				{
				new Main11();
					
				}
				else if(title.equals("Help"))
				{
				new HelpCar();
					
				}
				else if(title.equals("Feedback"))
				{
				
				if(pp1!=null)
					{
					pp1.setVisible(false);
					pp1=null;
					}
					pp1= new Feedback();
					pp1.setPreferredSize(new Dimension(600,620));
					pp1.setBounds(430,120,600,620);				
				 // new Feedback();
				}
			
			}
		}
		);
	
		
		add(p);
		p.setLayout(null);
		p.setBounds(0,0,1500,150);

		p.add(lb);
		p.add(img);
		lb.add(logout);
		lb.add(b1);
		b1.setFont(new Font("Arial",Font.BOLD,25));
		b1.setForeground(new Color(0,162,232));
		b1.setBounds(1050,90,310,50);
		logout.setBounds(1050,30,260,50);
		logout.setFont(new Font("Arial",Font.BOLD,25));
		logout.setForeground(new Color(0,162,232));
		img.setBounds(5,10,140,140);
		lb.setBounds(0,0,1500,150);
		p.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setVerticalTextPosition(JLabel.TOP);
		lb.setHorizontalTextPosition(JLabel.RIGHT);
		lb.setFont(new Font("Arial",Font.BOLD,50));
		add(main1);
		 main1.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),30));

		main1.setBounds(0,150,1500,1050);
		main1.setLayout(null);
		main1.setBackground(Color.WHITE);
		main1.add(home);
  		main1.add(cusdetail);
		main1.add(loandetail);
		main1.add(emidetail);
		
		
		 home.setBorder(thickBorder);
		 cusdetail.setBorder(thickBorder);
		 loandetail.setBorder(thickBorder);
		 emidetail.setBorder(thickBorder);
		 cusdetail.setForeground(new Color(0,162,232));
		 loandetail.setForeground(new Color(0,162,232));
		 emidetail.setForeground(new Color(0,162,232));
		 home.setForeground(new Color(0,162,232));
		 home.setBounds(400,50,230,220);
		loandetail.setBounds(400,300,230,220);
		emidetail.setBounds(800,50,230,220);
		cusdetail.setBounds(800,300,230,220);
		home.setFont(new Font("Arial",Font.BOLD,20));
		cusdetail.setFont(new Font("Arial",Font.BOLD,20));
		loandetail.setFont(new Font("Arial",Font.BOLD,20));
		emidetail.setFont(new Font("Arial",Font.BOLD,20));
		home.setVerticalTextPosition(JButton.BOTTOM);
   		home.setHorizontalTextPosition(JButton.CENTER);
		 cusdetail.setVerticalTextPosition(JButton.BOTTOM);
   		 cusdetail.setHorizontalTextPosition(JButton.CENTER);
		loandetail.setVerticalTextPosition(JButton.BOTTOM);
   		 loandetail.setHorizontalTextPosition(JButton.CENTER);
		 emidetail.setVerticalTextPosition(JButton.BOTTOM);
   		 emidetail.setHorizontalTextPosition(JButton.CENTER);
   		 setUndecorated(true);
		setVisible(true);
		setSize(1500,1000);
		cusdetail.addActionListener(this);
	//	logout.addActionListener(this);
		loandetail.addActionListener(this);
		emidetail.addActionListener(this);
		home.addActionListener(this);
		b1.addActionListener(this);
		logout.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{

		if(evt.getSource()==home)
		{
					
		try
		{
		Desktop.getDesktop().open(new java.io.File("img/auto.pdf"));
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		}
		
		
		
		else if(evt.getSource()==loandetail)
		{
					
				Emi5 b1=new Emi5();

			     b1.setPreferredSize(new Dimension(900,640));
			     b1.setBounds(350,120,900,640);
					
			   //add(b1);
			    b1.setVisible(true);
		}
		else if(evt.getSource()==b1)
		{
			Email b2=new Email();
			 b2.setPreferredSize(new Dimension(520,490));
			 b2.setBounds(400,150,520,490);
			 b2.setVisible(true);	

		}
		else if(evt.getSource()==emidetail)
		{
					
				Purpose1 b1=new Purpose1();
				 b1.setPreferredSize(new Dimension(820,690));
			     b1.setBounds(350,50,820,690);
				 b1.setVisible(true);
		}
	
	else if(evt.getSource()==logout)
		{
				dispose();	
				new User();

		}
	
		else if(evt.getSource()==cusdetail)
		{
					
				LoanApplication b1=new LoanApplication();
				 b1.setPreferredSize(new Dimension(920,650));
			     b1.setBounds(350,60,920,650);
				 b1.setVisible(true);
		}

	}
		
	public static void main(String []args)
	{
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            
        }
		new Auto2();
	}
}
