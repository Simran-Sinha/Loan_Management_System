import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;
public class RecievePaymentReport extends JDialog implements Printable,ActionListener
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
	JLabel c_id_txt=new JLabel();
	JLabel recipt_no_txt=new JLabel();
	JLabel no_of_pay_txt=new JLabel();
	JLabel recipt_date_txt=new JLabel();
	JLabel emi_date_txt=new JLabel();
	JLabel emi_amount_txt=new JLabel();
	JLabel late_fine_txt=new JLabel();
	JLabel total_amount_txt=new JLabel();
	JButton print=new JButton("Print");
	Connection con;
	PreparedStatement pst;
	ResultSet rst;
	String path="";
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
		}
		catch(Exception e){}
	}
	String id;
	RecievePaymentReport()
	{
		id=JOptionPane.showInputDialog(this,"Enter Customer ID:");
		setLayout(null);
		add(pan_form);
		pan_form.setLayout(null);
		pan_form.setBackground(new Color(215,215,255));
		pan_form.setBounds(0,0,600,700);
		addComponent(pan_form,c_id,50,50,150,40);addComponent(pan_form,c_id_txt,220,50,200,40);c_id_txt.setEnabled(false); 
		addComponent(pan_form,recipt_no,50,100,150,40);addComponent(pan_form,recipt_no_txt,220,100,200,40);recipt_no_txt.setEnabled(false);
		addComponent(pan_form,no_of_pay,50,150,150,40);addComponent(pan_form,no_of_pay_txt,220,150,200,40);no_of_pay_txt.setEnabled(false);
		addComponent(pan_form,recipt_date,50,200,150,40);addComponent(pan_form,recipt_date_txt,220,200,200,40);recipt_date_txt.setEnabled(false);
		addComponent(pan_form,emi_date,50,250,150,40);addComponent(pan_form,emi_date_txt,220,250,200,40);emi_date_txt.setEnabled(false);
		addComponent(pan_form,emi_amount,50,300,150,40);addComponent(pan_form,emi_amount_txt,220,300,200,40);emi_amount_txt.setEnabled(false);
		addComponent(pan_form,late_fine,50,350,150,40);addComponent(pan_form,late_fine_txt,220,350,200,40);late_fine_txt.setEnabled(false);
		addComponent(pan_form,total_amount,50,400,150,40);addComponent(pan_form,total_amount_txt,220,400,200,40);total_amount_txt.setEnabled(false);
		addComponent(pan_form,print,80,460,150,50);
		javax.swing.border.TitledBorder titleBorder=BorderFactory.createTitledBorder("Reciept Details");
		titleBorder.setTitleJustification(2);
		titleBorder.setTitleFont(new Font("Monotype Corsiva",Font.BOLD,30));
		pan_form.setBorder(titleBorder);
		print.addActionListener(this);
		//ssetUndecorated(true);
		
		setSize(600,700);
		setLocationRelativeTo(null);
		try
			{
				pst=con.prepareStatement("select * from recieve_emi where customer_id=?");
				pst.setString(1,id);
				rst=pst.executeQuery();
				if(rst.next())
				{
					c_id_txt.setText(rst.getString(1));
					recipt_no_txt.setText(rst.getString(2));
					no_of_pay_txt.setText(rst.getString(3));
					recipt_date_txt.setText(rst.getString(4));
					emi_date_txt.setText(rst.getString(5));
					emi_amount_txt.setText(rst.getString(6));
					late_fine_txt.setText(rst.getString(7));
					total_amount_txt.setText(rst.getString(8));
					setVisible(true);

				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found","SQL Error Message",JOptionPane.WARNING_MESSAGE);
					setVisible(false);	
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.toString(),"SQL Error Message",JOptionPane.WARNING_MESSAGE);
			}
	}
	void addComponent(Component comp,Component comp1,int x,int y,int w,int h)
	{
		JPanel pan_form=(JPanel)comp;
		comp1.setBounds(x,y,w,h);
		pan_form.add(comp1);
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