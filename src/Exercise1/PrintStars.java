package Exercise1;

public class PrintStars 
{
	public static void main(String[] args)
	{
		for(int i = 1; i < 11; i++)
		{
			for(int k = 1; k <= i; k++)
				System.out.print("*");
				System.out.println();
		}
	}
}