import java.util.regex.*;
public class PatternMatching
{
	public static boolean mobCheck(String x)
	{
		boolean temp;
		Pattern pattern=Pattern.compile("(0|91)?[6-9][0-9]{9}");
		Matcher m=pattern.matcher(x);
		if(m.find() && m.group().equals(x))
		{
			temp=true;
		}
		else
		{
			temp=false;
		}
		return temp;
	}
	public static boolean nameCheck(String x)
	{
		boolean temp;
		Pattern pattern=Pattern.compile("[a-zA-Z .]+");
		Matcher m=pattern.matcher(x);
		if(m.find() && m.group().equals(x))
		{
			temp=true;
		}
		else
		{
			temp=false;
		}
		return temp;
	}
	public static boolean emailCheck(String x)
	{
		boolean temp;
		Pattern pattern=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]+@[a-zA-z0-9]+[.a-zA-z]+");
		Matcher m=pattern.matcher(x);
		if(m.find() && m.group().equals(x))
		{
			temp=true;
		}
		else
		{
			temp=false;
		}
		return temp;
	}

	public static boolean passwordCheck(String x)
	{
		boolean temp;
		Pattern pattern=Pattern.compile("[a-z][A-Z][.#$@_?*][0-9][a-zA-Z0-9]+{4}[a-zA-Z0-9]*");
		Matcher m=pattern.matcher(x);
		if(m.find() && m.group().equals(x))
		{
			temp=true;
		}
		else
		{
			temp=false;
		}
		return temp;
	}

	public static void main(String[]args)
	{
		if(PatternMatching.mobCheck(args[0]))
		{
			System.out.println("Valid Mobile No..");
		}
		else
		{
			System.out.println("In-valid Mobile No..");	
		}

		if(PatternMatching.nameCheck(args[1]))
		{
			System.out.println("Valid Name..");
		}
		else
		{
			System.out.println("In-valid Name..");	
		}

		if(PatternMatching.emailCheck(args[2]))
		{
			System.out.println("Valid Email..");
		}
		else
		{
			System.out.println("In-valid Email..");	
		}

		if(PatternMatching.passwordCheck(args[3]))
		{
			System.out.println("Valid Password..");
		}
		else
		{
			System.out.println("In-valid Password..");	
		}
	}
}