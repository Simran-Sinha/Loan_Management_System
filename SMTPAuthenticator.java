import javax.mail.*;                                                                                                                
import javax.mail.internet.*;                                                                                                    
import java.util.*; 
/** 
* SimpleAuthenticator is used to do simple authentication 
* when the SMTP server requires it. 
*/ 
public class SMTPAuthenticator extends javax.mail.Authenticator 
{ 

@Override 
public PasswordAuthentication getPasswordAuthentication() 
{ 
String username = SendMailUsingAuthentication.SMTP_AUTH_USER; 
String password = SendMailUsingAuthentication.SMTP_AUTH_PWD; 
return new PasswordAuthentication(username, password); 
} 
} 
