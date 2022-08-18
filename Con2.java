import java.awt.*;
import javax.swing.*;
public class Con2 extends JDialog implements Runnable
{
	
	JProgressBar prog=new JProgressBar();
	JPanel p=new JPanel();
	JLabel lb1=new JLabel(new ImageIcon(ImageResize.resize("img/a11.png",160,160)));;
	JLabel lb = new JLabel("           Thankyou for giving your Feedback!!!");
	
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			
			prog.setValue(i);
			try
			{
				Thread.sleep(20);
			}
			catch(Exception e){}
		}
		/*try
			{
				Thread.sleep(100);
			}
			catch(Exception e){}*/
		//JOptionPane.showMessageDialog(this,"Progress Completed.....");
		dispose();
		//new Main2();
	}
	Con2()
	{
		Thread t=new Thread(this);
		t.start();
		add(p);
		//p.setBorder(BorderFactory.createLineBorder(new Color(0,162,232),15));

		setLayout(null);
		p.setBounds(0,0,1200,500);
		p.setLayout(null);
		lb.setBackground(new Color(0,162,232));
		lb.setForeground(Color.WHITE);
		lb.setOpaque(true);
		p.add(lb);
		lb.setBounds(0,170,1200,150);
		lb.setFont(new Font("Arial",Font.BOLD,50));
		p.add(lb1);
		lb1.setBounds(400,20,200,180);
		setSize(1200,500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String []args)
	{
		new Con2();
	}
}
