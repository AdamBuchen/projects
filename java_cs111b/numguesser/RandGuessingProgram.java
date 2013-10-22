package numguesser;
import java.util.*;

public class RandGuessingProgram {

	public static void main(String args[]) {
		RandomNumberGuesser guesser = new RandomNumberGuesser(1,100);
		Scanner input = new Scanner(System.in);
		int currentGuess;
		
		char keepPlaying = 'y';
		boolean guessCorrect;
		char lastInput;
		
		do {
			System.out.println("Think of a number between 1 and 100");
			guessCorrect = false;
			
			do {
				try {
					currentGuess = guesser.getCurrentGuess();
					System.out.print("Is the number " + currentGuess + "? (h/l/c): ");
					lastInput = input.next().charAt(0);
					if(lastInput == 'h') {
						guesser.higher();
					} else if(lastInput == 'l') {
						guesser.lower();
					} else if(lastInput == 'c') {
						System.out.println("You picked " + currentGuess + "? Great pick.");
						guesser.reset();
						guessCorrect = true;
					}
				} catch(IllegalStateException e) {
					System.out.println("Error: " + e.getMessage());
					guessCorrect = true;
				}
			} while(!guessCorrect);
			
			guesser.reset();
			
			System.out.print("Do you want to play again: (y/n): ");
			keepPlaying = input.next().charAt(0);
		
		} while(keepPlaying == 'y');	
	}
}
