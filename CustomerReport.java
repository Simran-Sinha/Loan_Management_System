import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.awt.print.*;
import javax.swing.table.*;
import java.awt.print.*;
public class CustomerReport extends JDialog implements Printable,ActionListener
{
	JPanel panel=new JPanel();
	JScrollPane jsp=new JScrollPane(panel);
	JLabel title=new JLabel("                  Loan Application Form");
	JLabel full_name=new JLabel("Full Name");JLabel full_name_txt=new JLabel();
	JLabel gender=new JLabel("Gender");
	JLabel dob=new JLabel("Date Of Birth");JLabel dob_txt=new JLabel();
	JLabel martial_status=new JLabel("Martial Status");
	JLabel spouse_name=new JLabel("Spouse's Name");JLabel spouse_name_txt=new JLabel();
	JLabel father_name=new JLabel("Father's Name");JLabel father_name_txt=new JLabel();
	JLabel mother_name=new JLabel("Mother's Name");JLabel mother_name_txt=new JLabel();
	JLabel nationality=new JLabel("Nationality");JLabel nationality_txt=new JLabel();
	JLabel category=new JLabel("Category");
	JLabel religion=new JLabel("Religion");
	JLabel place_of_birth=new JLabel("Place Of Birth");JLabel place_of_birth_txt=new JLabel();
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
	JLabel phone=new JLabel("Phone Number");
	JLabel phone_txt=new JLabel();
	JLabel customer=new JLabel("Customer Id");
	JLabel customer_txt=new JLabel();
	JLabel status=new JLabel("Status");
	JLabel status_txt=new JLabel("Inactive");
	FileInputStream fin;
	String path="";
	File file;
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	String path1="";
	File f=null,f1=null,f2=null,f3=null,f4=null,f5=null;		
	JButton print=new JButton("Print");
	{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
	}
	catch(Exception e){}
	}
	String id;
	CustomerReport()
	{
		id=JOptionPane.showInputDialog(this,"Enter Customer ID:");
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
		addComponent(panel,dob,50,200,200,40);addComponent(panel,dob_txt,250,200,200,40);
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
		addComponent(panel,phone,50,1110,200,40);addComponent(panel,phone_txt,250,1110,200,40);
		addComponent(panel,customer,50,1160,200,40);addComponent(panel,customer_txt,250,1160,200,40);
		addComponent(panel,status,50,1210,200,40);addComponent(panel,status_txt,250,1210,200,40);
		addComponent(panel,print,200,1260,150,50);
		status_txt.setEnabled(false);
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
		panel.setPreferredSize(new Dimension(900,1320));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),10));
		
		try
			{
			pst=con.prepareStatement("select * from loanform1 where cusid=?");
				pst.setInt(1,Integer.parseInt(id));
				rst=pst.executeQuery();
				if(rst.next())
				{
					full_name_txt.setText(rst.getString(2));
					String gend=rst.getString("Gender");//3
					if(gend.equals("Male"))
						gen1.setSelected(true);
					else if(gend.equals("Female"))
						gen2.setSelected(true);
					dob_txt.setText(rst.getString(4));
					String martial1=rst.getString("Mar");//5
					if(martial1.equals("Married"))
						mar1.setSelected(true);
					else if(martial1.equals("Unmarried"))
						mar2.setSelected(true);
					spouse_name_txt.setText(rst.getString(6));
					father_name_txt.setText(rst.getString(7));
					mother_name_txt.setText(rst.getString(8));
					nationality_txt.setText(rst.getString(9));
					String categ=rst.getString("cate");//10
					if(categ.equals("SC"))
						cat1.setSelected(true);
					else if(categ.equals("OBC"))
						cat2.setSelected(true);
					else if(categ.equals("ST"))
						cat3.setSelected(true);
					else if(categ.equals("General"))
						cat4.setSelected(true);
					String relig=rst.getString("reli");//11
					if(relig.equals("Hindu"))
						rel1.setSelected(true);
					else if(relig.equals("Muslim"))
						rel2.setSelected(true);
					else if(relig.equals("Christian"))
						rel3.setSelected(true);
					else if(relig.equals("Sikh"))
						rel4.setSelected(true);
					else if(relig.equals("Other Minority"))
						rel5.setSelected(true);
					place_of_birth_txt.setText(rst.getString(12));
					byte b[]=rst.getBytes(16);
					Image img=Toolkit.getDefaultToolkit().createImage(b);
					img=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
					photograph.setIcon(new ImageIcon(img));
					permanent_add_txt.setText(rst.getString(21));
					local_add_txt.setText(rst.getString(22));
					education_txt_1.setText("File Uploaded");
					identity_txt_1.setText("File Uploaded");
					income_txt_1.setText("File Uploaded");
					property_txt_1.setText("File Uploaded");
					byte b1[]=rst.getBytes(23);
					Image img1=Toolkit.getDefaultToolkit().createImage(b1);
					img1=img1.getScaledInstance(200,100,Image.SCALE_SMOOTH);
					signature_txt.setIcon(new ImageIcon(img1));
					phone_txt.setText(rst.getString(24));
					customer_txt.setText(rst.getString(25));
					status_txt.setText(rst.getString(26));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found","",JOptionPane.INFORMATION_MESSAGE);		
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
		photo_btn.addActionListener(this);
		sign_btn.addActionListener(this);
		education_btn.addActionListener(this);
		identity_btn.addActionListener(this);
		income_btn.addActionListener(this);
		property_btn.addActionListener(this);
		print.addActionListener(this);
		//setUndecorated(true);
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
	public int print(Graphics g,PageFormat pg,int i) throws PrinterException
	{
    	if(i<0)
        return NO_SUCH_PAGE;
    	Graphics2D g2d=(Graphics2D)g;
    	g2d.translate(pg.getImageableX(),pg.getImageableY());
    	this.printAll(g);
    	return PAGE_EXISTS ;
    }
	public void actionPerformed(ActionEvent evt)
	{
			print.setVisible(false);
        	PrinterJob printJob = PrinterJob.getPrinterJob();
        	PageFormat pf=printJob.pageDialog(printJob.defaultPage());
          	printJob.setPrintable(this,pf);
          	if (printJob.printDialog()) 
          	{
            try 
            {
               printJob.print();
            } 
            catch (Exception PrintException) 
            {
               PrintException.printStackTrace();
            }
           }
           print.setVisible(true);
	}
}