import java.awt.*;
import javax.swing.*;

public class SplashWindow extends JFrame implements Runnable
{
	JPanel panel=new JPanel();
	JProgressBar pro=new JProgressBar(0,100);
	int width,height,vl=0;
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/front.png",700,700)));;
	JLabel lb2=new JLabel("         Loan");
	JLabel lb3=new JLabel("       Management");
	JLabel lb4=new JLabel("        System");
	

	SplashWindow()
	{
		//setLayout(null);
		//add(p);
		//p.setLayout(null);
		//panel.setBounds(0,0,1360,1000);
		panel.setBackground(Color.WHITE);
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));

		lb1.setBounds(0,0,700,700);
		lb2.setBounds(600,150,500,100);
		lb2.setForeground(Color.WHITE);
		lb2.setOpaque(true);
		lb2.setBackground(new Color(0,162,232));
		lb2.setFont(new Font("Arial",Font.BOLD,50));

		lb3.setBounds(600,320,500,100);
		lb3.setForeground(Color.WHITE);
		lb3.setOpaque(true);
		lb3.setBackground(new Color(0,162,232));
		lb3.setFont(new Font("Arial",Font.BOLD,50));

		lb4.setBounds(600,500,500,100);
		lb4.setForeground(Color.WHITE);
		lb4.setOpaque(true);
		lb4.setBackground(new Color(0,162,232));
		lb4.setFont(new Font("Arial",Font.BOLD,50));

		//setSize(1500,1000);
		
		/*super("Medical Billing");
			panel=new JPanel()
			{
			Image img=new ImageIcon("welcome-108.gif").getImage();
			public void paintComponent(Graphics g)
			{
				g.drawImage(img,0,0,width,height,this);
			}
	};*/

	width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();	
	height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();	
	setSize(width,height);
	add(panel);
	panel.setLayout(null);
	pro.setBounds(30,height-100,width-100,20);
	panel.add(pro);
	setVisible(true);
	pro.setStringPainted(true);
	Thread thread=new Thread(this);
	thread.start();
	pro.setForeground(new Color(0,162,232));
	pro.setBackground(Color.GRAY);
	pro.setFont(new Font("Arial",Font.BOLD,20));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	public void run()
	{
		try
		{
			for(;;)
			{
				pro.setValue(vl);
				Thread.sleep(180);
				vl=pro.getValue()+2;
				pro.setString(vl+"% completed");
				if(vl<100)
				pro.setValue(vl);
			else
				break;
			}
			dispose();
			new Start();
		}
		catch(InterruptedException e){}
	}
	public static void main(String[]args)
	{
	new SplashWindow();
	}
}