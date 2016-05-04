package Exercise2;

import java.util.Scanner;

public class PrintStars 
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter the number of loops: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		
		for(int i = 1; i <= n; i++)
		{
			for(int k = 1; k <= i; k++)
				System.out.print("*");
				System.out.println();
		}
	}
}