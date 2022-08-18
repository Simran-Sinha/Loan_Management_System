import java.awt.*;
import javax.swing.*;
//import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class Offer extends JDialog implements ActionListener
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

	JPanel p=new JPanel();
	JPanel p1 = new JPanel();
	Border thickBorder = new LineBorder(new Color(0,0,160), 5);
	JLabel lb = new JLabel("           CHECK ELIGIBILITY CRITERIA");
	JButton purpose=new JButton("Save");
	JButton offer=new JButton("Search");
	JButton appli=new JButton("Reset");

	Offer()
	{
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,800,50);
		p1.setBackground(new Color(0,0,121));
		p1.add(lb);
		lb.setBounds(0,0,800,50);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,800,600);
		p.setLayout(null);
		p.add(purpose);
		p.add(offer);
		p.add(appli);
		purpose.setBounds(200,30,280,150);
		offer.setBounds(170,210,350,170);
		appli.setBounds(140,410,450,170);

		setVisible(true);
		setSize(800,700);
		purpose.addActionListener(this);
		offer.addActionListener(this);
		appli.addActionListener(this);

		purpose.setLabel("");
		purpose.setContentAreaFilled(false);
		purpose.setBorderPainted(false);
		purpose.setIcon(new ImageIcon(ImageResize.resize("img/button.png",280,150)));

		offer.setLabel("");
		offer.setContentAreaFilled(false);
		offer.setBorderPainted(false);
		offer.setIcon(new ImageIcon(ImageResize.resize("img/offer.png",350,170)));

		appli.setLabel("");
		appli.setContentAreaFilled(false);
		appli.setBorderPainted(false);
		appli.setIcon(new ImageIcon(ImageResize.resize("img/appli.png",450,170)));
	//	btnReset.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent evt)
	{

		if(evt.getSource()==purpose)
		{
					
				Purpose obj=new Purpose();

			     obj.setPreferredSize(new Dimension(815,690));
			     obj.setBounds(0,0,815,690);
					
			   //add(b1);
			   //  dispose();
			    obj.setVisible(true);
		}
		else if(evt.getSource()==appli)
		{
					
				Application obj=new Application();

			     obj.setPreferredSize(new Dimension(915,750));
			     obj.setBounds(0,0,915,750);
					
			   //add(b1);
			   //  dispose();
			    obj.setVisible(true);
		}
		else if(evt.getSource()==offer)
		{
					
				Offer1 obj=new Offer1();

			     obj.setPreferredSize(new Dimension(900,650));
			     obj.setBounds(0,0,900,650);
					
			   //add(b1);
			   //  dispose();
			    obj.setVisible(true);
		}
	}
	public static void main(String []args)
	{
		new Offer();
	}
}		