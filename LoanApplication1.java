import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import com.toedter.calendar.*;
import java.text.*;
public class LoanApplication1 extends JDialog implements ActionListener
{
	JPanel panel=new JPanel();
	JScrollPane jsp=new JScrollPane(panel);
	JLabel title=new JLabel("                  Loan Application Form");
	JLabel full_name=new JLabel("Full Name");JTextField full_name_txt=new JTextField();
	JLabel gender=new JLabel("Gender");
	JLabel dob=new JLabel("Date Of Birth");//JTextField dob_txt=new JTextField();
	JLabel martial_status=new JLabel("Martial Status");
	JLabel spouse_name=new JLabel("Spouse's Name");JTextField spouse_name_txt=new JTextField();
	JLabel father_name=new JLabel("Father's Name");JTextField father_name_txt=new JTextField();
	JLabel mother_name=new JLabel("Mother's Name");JTextField mother_name_txt=new JTextField();
	JLabel nationality=new JLabel("Nationality");JTextField nationality_txt=new JTextField();
	JLabel category=new JLabel("Category");
	JLabel religion=new JLabel("Religion");
	JLabel place_of_birth=new JLabel("Place Of Birth");JTextField place_of_birth_txt=new JTextField();
	JLabel permanent_add=new JLabel("Permanent Address");JTextArea permanent_add_txt=new JTextArea();JScrollPane jsp1=new JScrollPane(permanent_add_txt);
	JLabel local_add=new JLabel("Local Address");JTextArea local_add_txt=new JTextArea();JScrollPane jsp2=new JScrollPane(local_add_txt);
	JLabel education=new JLabel("Education Qualification");JComboBox education_txt=new JComboBox();JLabel education_txt_1=new JLabel();
	JLabel identity=new JLabel("Identity Proof");JComboBox identity_txt=new JComboBox();JLabel identity_txt_1=new JLabel();
	JLabel income=new JLabel("Income Proof");JComboBox income_txt=new JComboBox();JLabel income_txt_1=new JLabel();
	JLabel property=new JLabel("Property Proof");JComboBox property_txt=new JComboBox();JLabel property_txt_1=new JLabel();
	JLabel photograph=new JLabel("  Upload Photo Graph");
	JLabel signature=new JLabel("Signature");JLabel signature_txt=new JLabel("        Upload Signature");
	JButton sign_btn=new JButton("Upload");
	JButton photo_btn=new JButton("Upload");
	JButton education_btn=new JButton("Upload");
	JButton identity_btn=new JButton("Upload");
	JButton income_btn=new JButton("Upload");
	JButton property_btn=new JButton("Upload");
	JDateChooser calendar1=new JDateChooser(new java.util.Date());
	JCheckBox gen1= new JCheckBox("Male");ButtonGroup bg1=new ButtonGroup();
	JCheckBox gen2= new JCheckBox("Female");
	JCheckBox cat1= new JCheckBox("SC");ButtonGroup bg2=new ButtonGroup();
	JCheckBox cat2= new JCheckBox("OBC");
	JCheckBox cat3= new JCheckBox("ST");
	JCheckBox cat4= new JCheckBox("General");
	JCheckBox rel1= new JCheckBox("Hindu");ButtonGroup bg3=new ButtonGroup();
	JCheckBox rel2= new JCheckBox("Muslim");
	JCheckBox rel3= new JCheckBox("Christian");
	JCheckBox rel4= new JCheckBox("Sikh");
	JCheckBox rel5= new JCheckBox("Other Minority");
	JCheckBox mar1=new JCheckBox("Married");ButtonGroup bg4=new ButtonGroup();
	JCheckBox mar2=new JCheckBox("Un-Married");
	FileInputStream fin;
	String path="";
	File file;
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	String path1="";
	File f=null,f1=null,f2=null,f3=null,f4=null,f5=null;		
	JButton cancel=new JButton("CANCEL");
	JButton submit=new JButton("SUBMIT");
	{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
	}
	catch(Exception e){}
	}
	LoanApplication1()
	{
		setLayout(null);
		add(jsp);
		jsp.setBounds(0,0,900,600);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		addComponent(panel,title,0,0,900,80);
		title.setForeground(Color.WHITE);title.setBackground(new Color(0,162,232));title.setOpaque(true);title.setFont(new Font("Arial",Font.BOLD,40));
		addComponent(panel,full_name,50,100,200,40);addComponent(panel,full_name_txt,250,100,200,40);
		addComponent(panel,photograph,660,100,200,200);addComponent(panel,photo_btn,710,310,100,40);photograph.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		addComponent(panel,gender,50,150,200,40);addComponent(panel,gen1,250,150,100,40);addComponent(panel,gen2,360,150,100,40);gen2.setOpaque(false);gen1.setOpaque(false);
		bg1.add(gen1);bg1.add(gen2);
		addComponent(panel,dob,50,200,200,40);addComponent(panel,calendar1,250,200,200,40);
		addComponent(panel,martial_status,50,250,200,40);addComponent(panel,mar1,250,250,100,40);addComponent(panel,mar2,360,250,200,40);mar1.setOpaque(false);mar2.setOpaque(false);
		bg4.add(mar1);bg4.add(mar2);
		addComponent(panel,spouse_name,50,300,200,40);addComponent(panel,spouse_name_txt,250,300,200,40);
		addComponent(panel,father_name,50,350,200,40);addComponent(panel,father_name_txt,250,350,200,40);
		addComponent(panel,mother_name,50,400,200,40);addComponent(panel,mother_name_txt,250,400,200,40);
		addComponent(panel,nationality,50,450,200,40);addComponent(panel,nationality_txt,250,450,200,40);
		addComponent(panel,category,50,500,200,40);addComponent(panel,cat1,250,500,100,40);addComponent(panel,cat2,360,500,100,40);addComponent(panel,cat3,470,500,100,40);addComponent(panel,cat4,580,500,100,40);cat4.setOpaque(false);cat3.setOpaque(false);cat2.setOpaque(false);cat1.setOpaque(false);
		bg2.add(cat1);bg2.add(cat2);bg2.add(cat3);bg2.add(cat4);
		addComponent(panel,religion,50,550,200,40);addComponent(panel,rel1,250,550,100,40);addComponent(panel,rel2,360,550,100,40);addComponent(panel,rel3,470,550,100,40);addComponent(panel,rel4,580,550,100,40);addComponent(panel,rel5,690,550,200,40);rel5.setOpaque(false);rel4.setOpaque(false);rel3.setOpaque(false);rel2.setOpaque(false);rel1.setOpaque(false);
		bg3.add(rel1);bg3.add(rel2);bg3.add(rel3);bg3.add(rel4);bg3.add(rel5);
		addComponent(panel,place_of_birth,50,600,200,40);addComponent(panel,place_of_birth_txt,250,600,200,40);
		addComponent(panel,permanent_add,50,650,200,40);addComponent(panel,jsp1,250,650,200,60);
		addComponent(panel,local_add,50,720,200,40);addComponent(panel,jsp2,250,720,200,60);
		addComponent(panel,education,50,800,200,40);addComponent(panel,education_txt,250,800,200,40);addComponent(panel,education_btn,460,800,100,40);addComponent(panel,education_txt_1,570,800,100,40);
		addComponent(panel,identity,50,850,200,40);addComponent(panel,identity_txt,250,850,200,40);addComponent(panel,identity_btn,460,850,100,40);addComponent(panel,identity_txt_1,570,850,100,40);
		addComponent(panel,income,50,900,200,40);addComponent(panel,income_txt,250,900,200,40);addComponent(panel,income_btn,460,900,100,40);addComponent(panel,income_txt_1,570,900,100,40);
		addComponent(panel,property,50,950,200,40);addComponent(panel,property_txt,250,950,200,40);addComponent(panel,property_btn,460,950,100,40);addComponent(panel,property_txt_1,570,950,100,40);
		addComponent(panel,signature,50,1000,200,40);addComponent(panel,signature_txt,250,1000,200,100);addComponent(panel,sign_btn,460,1030,100,40);
		addComponent(panel,cancel,400,1150,150,50);
		addComponent(panel,submit,200,1150,150,50);
		signature_txt.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		education_txt.addItem("10th Marksheet");
		education_txt.addItem("12th Marksheet");
		education_txt.addItem("Graduate Marksheet");
		identity_txt.addItem("Aadhar Card");
		identity_txt.addItem("PAN Card");
		identity_txt.addItem("Driving Licence");
		identity_txt.addItem("Passport");
		property_txt.addItem("Your Address proof documment");
		income_txt.addItem("salary slip");
		panel.setPreferredSize(new Dimension(900,1270));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),10));
		photo_btn.addActionListener(this);
		sign_btn.addActionListener(this);
		education_btn.addActionListener(this);
		identity_btn.addActionListener(this);
		income_btn.addActionListener(this);
		property_btn.addActionListener(this);
		cancel.addActionListener(this);
		submit.addActionListener(this);
		setSize(920,650);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void addComponent(Component comp,Component comp1,int x,int y,int w,int h)
	{
		JPanel panel=(JPanel)comp;
		comp1.setBounds(x,y,w,h);
		panel.add(comp1);
		comp1.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==photo_btn)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				f=fchooser.getSelectedFile();
				path=f.getAbsolutePath();
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				photograph.setIcon(new ImageIcon(img1));
			}
		}
		else if(evt.getSource()==sign_btn)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				f1=fchooser.getSelectedFile();
				path=f1.getAbsolutePath();
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				signature_txt.setIcon(new ImageIcon(img1));
			}
		}
		else if(evt.getSource()==education_btn)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				f2=fchooser.getSelectedFile();
				path=f2.getAbsolutePath();
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				//education_txt_1.setIcon(new ImageIcon(img1));
				education_txt_1.setText("File Uploaded");
			}
		}
		else if(evt.getSource()==identity_btn)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				f3=fchooser.getSelectedFile();
				path=f3.getAbsolutePath();
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				//identity_txt_1.setIcon(new ImageIcon(img1));
				identity_txt_1.setText("File Uploaded");
			}
		}
		else if(evt.getSource()==income_btn)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				f5=fchooser.getSelectedFile();
				path=f5.getAbsolutePath();
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				//income_txt_1.setIcon(new ImageIcon(img1));
				income_txt_1.setText("File Uploaded");
			}
		}
		else if(evt.getSource()==property_btn)
		{
			JFileChooser fchooser=new JFileChooser();
			int opt=fchooser.showOpenDialog(this);
			if(opt==JFileChooser.OPEN_DIALOG)
			{
				f4=fchooser.getSelectedFile();
				path=f4.getAbsolutePath();
				System.out.println(path);
				Image img=Toolkit.getDefaultToolkit().getImage(path);
				Image img1=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
				//property_txt_1.setIcon(new ImageIcon(img1));
				property_txt_1.setText("File Uploaded");
			}
		}
		else if(evt.getSource()==cancel)
		{
			dispose();
		}
		else if(evt.getSource()==submit)
		{
			String gen="";
			if(gen1.isSelected()){gen="Male";}
			else if(gen2.isSelected()){gen="Female";}
			String stat="";
			if(mar1.isSelected()){stat="Married";}
			else if(mar2.isSelected()){stat="Unmarried";}

			String cate="";
			if(cat1.isSelected()){cate="SC";}
			else if(cat2.isSelected()){cate="OBC";}
			else if(cat3.isSelected()){cate="ST";}
			else if(cat4.isSelected()){cate="General";}

			String rel="";
			if(rel1.isSelected()){rel="Hindu";}
			else if(rel2.isSelected()){rel="Muslim";}
			else if(rel3.isSelected()){rel="Christian";}
			else if(rel4.isSelected()){rel="Sikh";}
			else if(rel5.isSelected()){rel="Other Minority";}
			try
			{
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
				String st=sdf.format(calendar1.getDate());
				pst=con.prepareStatement("insert into loanform1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				fin = new FileInputStream(f);
				pst.setBinaryStream(1,fin,(int)f.length());
				pst.setString(2,full_name_txt.getText());
				pst.setString(3,gen);
				pst.setString(4,st);
			//	pst.setString(4,calendar1.getText());
				pst.setString(5,stat);
				pst.setString(6,spouse_name_txt.getText());
				pst.setString(7,father_name_txt.getText());
				pst.setString(8,mother_name_txt.getText());
				pst.setString(9,nationality_txt.getText());
				pst.setString(10,cate);
				pst.setString(11,rel);
				pst.setString(12,place_of_birth_txt.getText());
				pst.setString(13,education_txt.getSelectedItem().toString());
				fin = new FileInputStream(f2);
				pst.setBinaryStream(14,fin,(int)f2.length());
				pst.setString(15,identity_txt.getSelectedItem().toString());
				fin = new FileInputStream(f3);
				pst.setBinaryStream(16,fin,(int)f3.length());
				pst.setString(17,property_txt.getSelectedItem().toString());
				fin = new FileInputStream(f4);
				pst.setBinaryStream(18,fin,(int)f4.length());
				pst.setString(19,income_txt.getSelectedItem().toString());
				fin = new FileInputStream(f5);
				pst.setBinaryStream(20,fin,(int)f5.length());
				pst.setString(21,permanent_add_txt.getText());
				pst.setString(22,local_add_txt.getText());
				fin = new FileInputStream(f1);
				pst.setBinaryStream(23,fin,(int)f1.length());
				if(pst.executeUpdate()>0)
				{
					JOptionPane.showMessageDialog(this,"Data Saved","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new Con1();
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
	public static void main(String ar[])
	{
		new LoanApplication1();
	}
}