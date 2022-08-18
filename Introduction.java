import java.awt.*;
import javax.swing.*;
public class Introduction extends JFrame implements Runnable
{
	JLabel lbl1=new JLabel(new ImageIcon(ImageResize.resize("img/5.jpeg",1400,150)));
	JLabel lbl2=new JLabel(new ImageIcon(ImageResize.resize("img/4.jpeg",250,200)));
	JLabel lbl3=new JLabel(new ImageIcon(ImageResize.resize("img/3.jpeg",250,200)));
	JLabel lbl4=new JLabel(new ImageIcon(ImageResize.resize("img/2.jpg",250,200)));
	JLabel lbl5=new JLabel(new ImageIcon(ImageResize.resize("img/1.jpg",250,200)));
	JLabel lbl6=new JLabel("LOAN");
	JLabel lbl7=new JLabel("MANAGEMENT");
	JLabel lbl8=new JLabel("SYSTEM");
	Font f2 = new Font("Times New Roman", Font.BOLD,50);
	JPanel p=new JPanel();
	JProgressBar prog=new JProgressBar();
	public void run()
	{
		for(int i=0;i<100;i++)
		{
		prog.setValue(i);
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e){}
		}
		dispose();
		new Start();
	}
	Introduction()
	{
		Thread t=new Thread(this);
		t.start();
		setSize(1400,800);
		add(p);
		p.setBackground(Color.WHITE);
		p.setLayout(null);
		lbl1.setBounds(0,0,1400,150);
		lbl2.setBounds(100,170,250,200);
		lbl3.setBounds(1000,400,250,200);
		lbl4.setBounds(1000,170,250,200);
		lbl5.setBounds(100,400,250,200);
		lbl6.setBounds(600,200,750,100);
		lbl7.setBounds(500,300,750,100);
		lbl8.setBounds(550,400,750,100);
		lbl6.setFont(f2);
		lbl6.setForeground(new Color(102,102,255));
		lbl7.setForeground(new Color(102,102,255));
		lbl8.setForeground(new Color(102,102,255));
		lbl7.setFont(f2);
		lbl8.setFont(f2);
		p.add(lbl1);
		p.add(lbl2);
		p.add(lbl3);
		p.add(lbl4);
		p.add(lbl5);
		p.add(lbl6);
		p.add(lbl7);
		p.add(lbl8);
		prog.setBounds(0,660,1400,40);
		p.add(prog);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[]args)
	{
		new Introduction();
	}
}