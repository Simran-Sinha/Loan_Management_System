import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.*;
import java.text.*;
import java.io.*;
public class Appli extends JDialog implements ActionListener
{
	Connection con;
		PreparedStatement pst;
		ResultSet rst;
		String path="";
		String path1="";
		FileInputStream fin;
		File f=null,f1=null,f2=null,f3=null,f4=null,f5=null;		{
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
			}
			catch(Exception e){}
		}

	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JLabel lb = new JLabel("        LOAN  APPLICATION  FORM");
	JLabel photo = new JLabel("  Your Photograph");
	JLabel name = new JLabel("Full Name:");
	JLabel gender = new JLabel("Gender:");
	JLabel dob = new JLabel("Date of Birth");
	JLabel martial = new JLabel("Martial Status");
	JLabel spouse = new JLabel("Spouse's Name");
	JLabel father = new JLabel("Father's Name");
	JLabel mother = new JLabel("Mother's Name");
	JLabel nation = new JLabel("Nationality");
	JLabel cate = new JLabel("Category");
	JLabel reli = new JLabel("Religion");
	JLabel placeb = new JLabel("Place of Birth");
	JLabel edu = new JLabel("Educational Qualification");
	JLabel idp = new JLabel("Identity Proof");
	JLabel addressp = new JLabel("Address Proof");
	JLabel incomep = new JLabel("Income Proof");
	JLabel residence = new JLabel("Residence");
	JLabel peradd = new JLabel("<html>Permanent<br>   Address</html>");
	JLabel localadd = new JLabel("<html>Local<br> Address</html>");
	JLabel sign = new JLabel("Signature");
	JTextField name1 = new JTextField();
	JCheckBox g1= new JCheckBox("Male");
	JCheckBox g2= new JCheckBox("Female");
	JDateChooser calendar1=new JDateChooser(new java.util.Date());
	JCheckBox m1= new JCheckBox("Married");
	JCheckBox m2= new JCheckBox("Unmarried");
	JTextField father1=new JTextField();
	JTextField spouse1=new JTextField();
	JTextField mother1=new JTextField();
	JTextField nation1= new JTextField();
	JCheckBox c1= new JCheckBox("SC");
	JCheckBox c2= new JCheckBox("OBC");
	JCheckBox c3= new JCheckBox("ST");
	JCheckBox c4= new JCheckBox("General");
	JCheckBox r1= new JCheckBox("Hindu");
	JCheckBox r2= new JCheckBox("Muslim");
	JCheckBox r3= new JCheckBox("Christian");
	JCheckBox r4= new JCheckBox("Sikh");
	JCheckBox r5= new JCheckBox("Other Minority");
	JTextField placeb1=new JTextField();
	JComboBox edu1 = new JComboBox();
	JComboBox add1= new JComboBox();
	JComboBox id1 = new JComboBox();
	JComboBox income1= new JComboBox();
	JButton b1= new JButton("Upload");
	JButton b2= new JButton("Upload");
	JButton b3= new JButton("Upload");
	JButton b4= new JButton("Upload");
	JTextArea per1=new JTextArea();
	JTextArea loc1=new JTextArea();
	JLabel sign1=new JLabel("Your Signature");
	JButton sign11= new JButton("upload");
	JButton submit= new JButton("Submit");
	JButton photo1= new JButton("Upload");

	Appli()
	{
		add(p);
		p.add(p1);
		p1.setBounds(0,0,1100,100);
		p1.setBackground(new Color(0,162,232));
		p1.add(lb);
		lb.setBounds(0,0,1100,100);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,55));
		p.setBounds(0,80,1400,1200);
		p.setLayout(null);
		p1.setLayout(null);
		p.add(photo);
		p.add(name);p.add(gender);p.add(dob);p.add(martial);p.add(spouse);
		p.add(father);p.add(mother);p.add(nation);p.add(cate);p.add(reli);
		p.add(placeb);p.add(edu);p.add(idp);p.add(addressp);p.add(incomep);p.add(sign);
		p.add(name1);p.add(g1);p.add(g2);p.add(calendar1);p.add(r1);p.add(r2);p.add(r3);p.add(r4);p.add(r5);p.add(spouse1);
		p.add(father1);p.add(mother1);p.add(nation1);p.add(c1);p.add(c2);p.add(m1);p.add(m2);
		p.add(placeb1);p.add(r5);p.add(c3);p.add(c4);p.add(add1);p.add(income1);p.add(edu1);
		p.add(id1);p.add(per1);p.add(loc1);p.add(b1);p.add(b2);p.add(b3);p.add(b4);
		p.add(residence);p.add(sign1);p.add(sign11);p.add(submit);
		p.add(localadd);p.add(photo1);
		p.add(peradd);
		photo.setBounds(1110,10,200,200);
		photo1.setBounds(1130,220,100,30);
		photo.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		photo.setFont(new Font("Arial",Font.BOLD,15));
		name.setBounds(50,110,100,50);
		name1.setBounds(200,110,250,40);
		name.setFont(new Font("Arial",Font.BOLD,15));
		gender.setBounds(50,160,100,50);
		g1.setBounds(200,160,100,40);
		g2.setBounds(300,160,100,40);
		g1.setFont(new Font("Arial",Font.BOLD,15));
		g2.setFont(new Font("Arial",Font.BOLD,15));
		gender.setFont(new Font("Arial",Font.BOLD,15));
		dob.setBounds(50,210,140,50);
		calendar1.setBounds(200,210,250,40);
		dob.setFont(new Font("Arial",Font.BOLD,15));
		martial.setBounds(50,260,140,50);
		m1.setBounds(200,260,100,40);
		m2.setBounds(300,260,140,40);
		m1.setFont(new Font("Arial",Font.BOLD,15));
		m2.setFont(new Font("Arial",Font.BOLD,15));
		martial.setFont(new Font("Arial",Font.BOLD,15));
		spouse.setBounds(50,310,160,50);
		spouse1.setBounds(200,310,250,40);
		spouse.setFont(new Font("Arial",Font.BOLD,15));
		father.setBounds(50,360,140,50);
		father1.setBounds(200,360,250,40);
		father.setFont(new Font("Arial",Font.BOLD,15));
		mother.setBounds(50,410,160,50);
		mother1.setBounds(200,410,250,40);
		mother.setFont(new Font("Arial",Font.BOLD,15));
		nation.setBounds(50,460,100,50);
		nation1.setBounds(200,460,250,40);
		nation.setFont(new Font("Arial",Font.BOLD,15));
		cate.setBounds(50,510,100,50);
		c1.setBounds(200,510,100,40);
		c2.setBounds(300,510,100,40);
		c3.setBounds(400,510,70,40);
		c4.setBounds(500,510,100,40);
		
		cate.setFont(new Font("Arial",Font.BOLD,15));
		reli.setBounds(50,560,100,50);
		r1.setBounds(200,560,100,40);
		r2.setBounds(300,560,100,40);
		r3.setBounds(400,560,150,40);
		r4.setBounds(200,600,100,40);
		r5.setBounds(300,600,180,40);
		r5.setFont(new Font("Arial",Font.BOLD,15));
		reli.setFont(new Font("Arial",Font.BOLD,15));
		placeb.setBounds(50,640,160,50);
		placeb1.setBounds(200,645,250,40);
		placeb.setFont(new Font("Arial",Font.BOLD,15));
	//	edu.setBounds(50,750,70,50);
		edu.setFont(new Font("Arial",Font.BOLD,15));
		
		c1.setFont(new Font("Arial",Font.BOLD,15));
		c2.setFont(new Font("Arial",Font.BOLD,15));
		c3.setFont(new Font("Arial",Font.BOLD,15));
		c4.setFont(new Font("Arial",Font.BOLD,15));
		r1.setFont(new Font("Arial",Font.BOLD,15));
		r2.setFont(new Font("Arial",Font.BOLD,15));
		r3.setFont(new Font("Arial",Font.BOLD,15));
		r4.setFont(new Font("Arial",Font.BOLD,15));

		edu.setBounds(500,110,250,50);
		edu.setFont(new Font("Arial",Font.BOLD,15));
		edu1.setBounds(750,110,250,40);
		b1.setBounds(540,150,100,30);

		idp.setBounds(500,180,160,50);
		id1.setBounds(750,180,250,40);
		b2.setBounds(540,220,100,30);
		idp.setFont(new Font("Arial",Font.BOLD,15));

		addressp.setBounds(500,250,160,50);
		add1.setBounds(750,250,250,40);
		b3.setBounds(540,290,100,30);
		addressp.setFont(new Font("Arial",Font.BOLD,15));

		incomep.setBounds(500,320,160,50);
		income1.setBounds(750,320,250,40);
		b4.setBounds(540,360,100,30);
		incomep.setFont(new Font("Arial",Font.BOLD,15));

		residence.setBounds(500,400,160,30);
		residence.setFont(new Font("Arial",Font.BOLD,25));


		peradd.setBounds(610,440,160,90);
		per1.setBounds(700,440,250,90);
		peradd.setFont(new Font("Arial",Font.BOLD,16));

		localadd.setBounds(1000,440,160,50);
		loc1.setBounds(1100,440,250,90);
		localadd.setFont(new Font("Arial",Font.BOLD,16));

		sign.setBounds(550,540,160,50);
		sign.setFont(new Font("Arial",Font.BOLD,15));
		sign1.setFont(new Font("Arial",Font.BOLD,18));


		sign1.setBounds(700,540,160,100);
		sign11.setBounds(700,650,100,30);
		sign1.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		submit.setBounds(1000,590,170,70);
		submit.setFont(new Font("Arial",Font.BOLD,30));
		submit.setForeground(new Color(0,162,232));
		p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),10));
			edu1.addItem("10th Marksheet");
			edu1.addItem("12th Marksheet");
			edu1.addItem("Graduate Marksheet");
			id1.addItem("Aadhar Card");
			id1.addItem("PAN Card");
			id1.addItem("Driving Licence");
			id1.addItem("Passport");
			add1.addItem("Your Address proof documment");
			income1.addItem("salary slip");
		setVisible(true);
		setSize(1350,740);
		sign11.addActionListener(this);
		photo1.addActionListener(this);
		b1.addActionListener(this);
		submit.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==sign11)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				 f1=fchooser.getSelectedFile();
				path=f1.getAbsolutePath();
				System.out.println(path);
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				sign1.setIcon(new ImageIcon(img1));
			}
		}
	else if(evt.getSource()==b1)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				 f2=fchooser.getSelectedFile();
				/*path=f2.getAbsolutePath();
				System.out.println(path2);
				Image img=Toolkit.getDefaultToolkit().getImage(path2);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				sign1.setIcon(new ImageIcon(img1));*/
			}
		}
		else if(evt.getSource()==b2)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				 f3=fchooser.getSelectedFile();
				/*path=f1.getAbsolutePath();
				System.out.println(path);
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				sign1.setIcon(new ImageIcon(img1));*/
			}
		}
		else if(evt.getSource()==b3)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				 f4=fchooser.getSelectedFile();
				/*path=f1.getAbsolutePath();
				System.out.println(path);
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				sign1.setIcon(new ImageIcon(img1));*/
			}
		}
	else if(evt.getSource()==b4)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				 f5=fchooser.getSelectedFile();
				/*path=f1.getAbsolutePath();
				System.out.println(path);
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				sign1.setIcon(new ImageIcon(img1));*/
			}
		}
		else if(evt.getSource()==photo1)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				 f=fchooser.getSelectedFile();
				path1=f.getAbsolutePath();
				System.out.println(path1);
				Image img=Toolkit.getDefaultToolkit().getImage(path1);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				photo.setIcon(new ImageIcon(img1));
			}
		}
	else if(evt.getSource()==submit)
		{
			String gen="";
			if(g1.isSelected()){gen="Male";}
			else if(g2.isSelected()){gen="Female";}
			String stat="";
			if(m1.isSelected()){stat="Married";}
			else if(m2.isSelected()){stat="Unmarried";}

			String cate="";
			if(c1.isSelected()){cate="SC";}
			else if(c2.isSelected()){cate="OBC";}
			else if(c3.isSelected()){cate="ST";}
			else if(c4.isSelected()){cate="General";}

			String rel="";
			if(r1.isSelected()){rel="Hindu";}
			else if(r2.isSelected()){rel="Muslim";}
			else if(r3.isSelected()){rel="Christian";}
			else if(r4.isSelected()){rel="Sikh";}
			else if(r5.isSelected()){rel="Other Minority";}



			/*if(txt1.getText().equals("")||txt3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Fill the Details ....");
				return;
			}*/
			 /*if(check.isSelected())
			 {
			 	insert.setVisible(true);

			 }*/
			try
			{
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
				String st=sdf.format(calendar1.getDate());
				System.out.println(st);
				pst=con.prepareStatement("insert into loanform1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				fin = new FileInputStream(f);
				pst.setBinaryStream(1,fin,(int)f.length());
				pst.setString(2,name1.getText());
				pst.setString(3,gen);
				pst.setString(4,st);
				pst.setString(5,stat);
				pst.setString(6,spouse1.getText());
				pst.setString(7,father1.getText());
				pst.setString(8,mother1.getText());
				pst.setString(9,nation1.getText());
				pst.setString(10,cate);
				pst.setString(11,rel);
				pst.setString(12,placeb1.getText());
				pst.setString(13,edu1.getSelectedItem().toString());
				fin = new FileInputStream(f2);
				pst.setBinaryStream(14,fin,(int)f2.length());

				pst.setString(15,id1.getSelectedItem().toString());
				fin = new FileInputStream(f3);
				pst.setBinaryStream(16,fin,(int)f3.length());

				pst.setString(17,add1.getSelectedItem().toString());
				fin = new FileInputStream(f4);
				pst.setBinaryStream(18,fin,(int)f4.length());

				pst.setString(19,income1.getSelectedItem().toString());
				fin = new FileInputStream(f5);
				pst.setBinaryStream(20,fin,(int)f5.length());

				pst.setString(21,per1.getText());
				pst.setString(22,loc1.getText());
				fin = new FileInputStream(f1);
				pst.setBinaryStream(23,fin,(int)f1.length());

				
				
				
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"Data Saved","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
					
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Data Not Saved","Error Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}	

	
	public static void main(String []args)
	{
		new Appli();
	}


}		