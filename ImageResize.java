import java.awt.*;
public class ImageResize
{
	public static Image resize(String str,int width,int h)
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Image img=toolkit.getImage(str);
		img=img.getScaledInstance(width,h,Image.SCALE_SMOOTH);
		return img;
	}
}