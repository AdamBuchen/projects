import java.util.Scanner;

public class Assignment1 {
	
	public static void main(String args[])
	{
		int total;
		char goAgain = 'y';
		Scanner input = new Scanner(System.in);
		
		while (goAgain != 'n') {
			System.out.print("How many asterisks?: ");
			total = input.nextInt();
			for (int i = 0; i < total; i++) {
				System.out.print('*');
			}
			
			System.out.println();
			System.out.print("Go again? (y/n): ");
			goAgain = input.next().charAt(0);
		}
	}

}