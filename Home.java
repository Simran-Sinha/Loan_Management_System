import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*; 
import java.util.logging.*;
public class Home extends JDialog implements ActionListener
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
	JLabel lb = new JLabel("           OTP");
	JPanel p1= new JPanel();
	JLabel key = new JLabel("To");
	JLabel sender1 = new JLabel("Subject");	
	JLabel mess = new JLabel("Message");	
	//JLabel contact = new JLabel("Contact");	
	JTextField  txtto = new JTextField();
	JTextField  txtemailSubjectTxt= new JTextField();
	JTextField txtarea_message = new JTextField();
	
	JButton b1 = new JButton("Send");
	public static String emailMsgTxt = "";
	public static String emailSubjectTxt = "";
	public static String emailFromAddress = "";
// Add List of Email address to who email needs to be sent to
	private static String[] emailList = new String[10];
	Home()
	{
		setLayout(null);
		add(p);
		add(p1);
		p1.setLayout(null);
		p1.setBounds(0,0,900,50);
		p1.setBackground(new Color(0,0,121));
		p1.add(lb);
		lb.setBounds(0,0,900,50);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Times New Roman",Font.BOLD,35));
		p.setBounds(0,50,900,800);
		p.setLayout(null);
		p.add(sender1);
		p.add(mess);
		
		p.add(key);
		p.add(txtto);
		p.add(txtemailSubjectTxt);
		p.add(txtarea_message);
		
		p.add(b1);


		key.setBounds(60,50,200,30);
		key.setForeground(new Color(0,0,121));
		key.setFont(new Font("Times New Roman",Font.BOLD,30));
		txtto.setBounds(300,50,300,40);
		txtto.setFont(new Font("Times New Roman",Font.BOLD,20));

		sender1.setBounds(60,100,200,30);
		sender1.setForeground(new Color(0,0,121));
		sender1.setFont(new Font("Times New Roman",Font.BOLD,30));
		 txtemailSubjectTxt.setBounds(300,100,300,40);
		 txtemailSubjectTxt.setFont(new Font("Times New Roman",Font.BOLD,20));

		mess.setBounds(60,150,200,130);
		mess.setForeground(new Color(0,0,121));
		mess.setFont(new Font("Times New Roman",Font.BOLD,30));
		txtarea_message.setBounds(300,150,300,100);
		txtarea_message.setFont(new Font("Times New Roman",Font.BOLD,20));

		

		b1.setBounds(200,300,150,60);
		b1.addActionListener(this);

		setSize(700,600);
		setVisible(true);
	
	
	
	}
	public void actionPerformed(ActionEvent evt)
	
	{
		
	 if(evt.getSource()==b1)
	{

		 emailMsgTxt = txtarea_message.getText();
        emailSubjectTxt = txtemailSubjectTxt.getText();
        emailFromAddress = SendMailUsingAuthentication.SMTP_AUTH_USER;

        // Add List of Email address to who email needs to be sent to
        StringBuffer sb = new StringBuffer(txtto.getText());
        StringTokenizer st = new StringTokenizer(txtto.getText());
        int i = 0;
        while (st.hasMoreTokens()) {
            emailList[i] = st.nextToken(",");
            System.err.println(emailList[i]);
            i++;
        }
        String emailReceipeint[] = new String[i];
        for (int j = 0; j < i; j++) {
            emailReceipeint[j] = emailList[j];
            System.out.println("Actually emails are " + j);
        }


        SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
        try {
            smtpMailSender.postMail(emailReceipeint, emailSubjectTxt, emailMsgTxt, emailFromAddress);
        } catch (MessagingException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucessfully Sent mail to All Users");



	}
		

	}

	public static void main(String[]args)
	{
		new Home();
	}


}		