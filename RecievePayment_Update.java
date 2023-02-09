import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
public class RecievePayment_Update extends JDialog implements ActionListener
{
	JPanel pan_form=new JPanel();
	JLabel c_id=new JLabel("Customer ID");
	JLabel recipt_no=new JLabel("Reciept No");
	JLabel no_of_pay=new JLabel("Number Of Payment");
	JLabel recipt_date=new JLabel("Reciept Date");
	JLabel emi_date=new JLabel("Emi Date");
	JLabel emi_amount=new JLabel("Emi Amount");
	JLabel late_fine=new JLabel("Late Fine");
	JLabel total_amount=new JLabel("Total Amount");
	JTextField c_id_txt=new JTextField();
	JTextField recipt_no_txt=new JTextField();
	JTextField no_of_pay_txt=new JTextField();
	JTextField recipt_date_txt=new JTextField();
	JTextField emi_date_txt=new JTextField();
	JTextField emi_amount_txt=new JTextField();
	JTextField late_fine_txt=new JTextField();
	JTextField total_amount_txt=new JTextField();
	JButton update=new JButton("Update");
	JButton cancel=new JButton("Cancel");
	Connection con;
	ResultSet rst;
	PreparedStatement pst;
	{
		try
		{	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	RecievePayment_Update()
	{
		setLayout(null);
		add(pan_form);
		pan_form.setLayout(null);
		pan_form.setBackground(new Color(215,215,255));
		pan_form.setBounds(0,0,600,700);
		addComponent(pan_form,c_id,50,50,150,40);addComponent(pan_form,c_id_txt,220,50,200,40);
		addComponent(pan_form,recipt_no,50,100,150,40);addComponent(pan_form,recipt_no_txt,220,100,200,40);
		addComponent(pan_form,no_of_pay,50,150,150,40);addComponent(pan_form,no_of_pay_txt,220,150,200,40);
		addComponent(pan_form,recipt_date,50,200,150,40);addComponent(pan_form,recipt_date_txt,220,200,200,40);
		addComponent(pan_form,emi_date,50,250,150,40);addComponent(pan_form,emi_date_txt,220,250,200,40);
		addComponent(pan_form,emi_amount,50,300,150,40);addComponent(pan_form,emi_amount_txt,220,300,200,40);
		addComponent(pan_form,late_fine,50,350,150,40);addComponent(pan_form,late_fine_txt,220,350,200,40);
		addComponent(pan_form,total_amount,50,400,150,40);addComponent(pan_form,total_amount_txt,220,400,200,40);
		addComponent(pan_form,update,80,460,150,50);addComponent(pan_form,cancel,250,460,150,50);
		javax.swing.border.TitledBorder titleBorder=BorderFactory.createTitledBorder("Reciept Details");
		titleBorder.setTitleJustification(2);
		titleBorder.setTitleFont(new Font("Monotype Corsiva",Font.BOLD,30));
		pan_form.setBorder(titleBorder);
		update.addActionListener(this);
		cancel.addActionListener(this);
		setUndecorated(true);
		setSize(600,700);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void addComponent(Component comp,Component comp1,int x,int y,int w,int h)
	{
		JPanel pan_form=(JPanel)comp;
		comp1.setBounds(x,y,w,h);
		pan_form.add(comp1);
		comp1.setFont(new Font("ARIAL",Font.BOLD,15));
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==cancel)
		{
			dispose();
		}
		else if(evt.getSource()==update)
		{
			try
		      {
				pst=con.prepareStatement("update recieve_emi set reciept_no=?,number_of_payment=?,reciept_date=?,emi_date=?,emi_amount=?,late_fine=?,total_amount=? where customer_id=?");
				pst.setString(1,recipt_no_txt.getText());
				pst.setString(2,no_of_pay_txt.getText());
				pst.setString(3,recipt_date_txt.getText());
				pst.setString(4,emi_date_txt.getText());
				pst.setString(5,emi_amount_txt.getText());
				pst.setString(6,late_fine_txt.getText());
				pst.setString(7,total_amount_txt.getText());
				pst.setString(8,c_id_txt.getText());
				rst=pst.executeQuery();
				if(rst.next())
				{
					JOptionPane.showMessageDialog(this,"DATA UPDATED","SQL Error Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"DATA NOT UPDATED","SQL Error Message",JOptionPane.WARNING_MESSAGE);		
				}
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
	}
}