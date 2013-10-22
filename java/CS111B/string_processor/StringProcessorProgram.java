package string_processor;
import java.util.*;

public class StringProcessorProgram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		char wantsToContinue = 'y';
		StringProcessor sp = new StringProcessor();
		
		do {
			System.out.print("Enter a line of text: ");
			input = scanner.nextLine();
			sp.setString(input);
			System.out.println("words: " + sp.wordCount());
			System.out.println("uppercase: " + sp.uppercaseCount());
			System.out.println("digits: " + sp.digitCount());
			System.out.println("digit words: " + sp.digitWordCount());
			System.out.println("line with whitespace removed: " + sp.getNoSpaceString());
			System.out.println("line with vowels replaced: " + sp.getNoVowelString());
			System.out.println("line with digit words replaced: " + sp.getNoDigitWordString());
			System.out.print("do you want to enter another? (y/n): ");
			do {
				input = scanner.nextLine();
				wantsToContinue = input.charAt(0);
				wantsToContinue = Character.toLowerCase(wantsToContinue);
			} while(wantsToContinue != 'y' && wantsToContinue != 'n');
			
		} while(wantsToContinue != 'n');
		
	}
	
}
