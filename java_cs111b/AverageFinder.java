import java.util.*;

public class AverageFinder {

	public static void main(String[] args) {
		printAsterisks(4);
		
		System.exit(0);
		int lastInput;
		int totalSum = 0;
		int numValuesAboveAverage = 0;
		int counter;

		double average = 0.0;
		int[] values = new int[5];
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i<5; i++) { //Fix the less than sign
			counter = i + 1;
			System.out.print("Value " + counter + ": ");
			lastInput = input.nextInt();
			values[i] = lastInput;
			totalSum += lastInput;
		}

		if(totalSum > 0) {
			average = totalSum / 5;
		}

		for(int i=0; i<5; i++) { //Fix the less than sign
			if(values[i] > average) {
				numValuesAboveAverage++;
			}
		}

		System.out.println("values greater than average: " + numValuesAboveAverage);

	}

	public static void printAsterisks(int numInBaseRow) {
		String line;
		
		for(int i = numInBaseRow; i > 0; i--) {
			line = "";

			for(int j=0; j<i; j++) { //replace the lt
				line += "*";
			}
		
			System.out.println(line);
		}
		
	}
	
	


}