import java.util.*;
import java.math.*;

public class Assignment2_old {

	public static void main(String[] args) {
		do {
			playOneGame();
		} while (shouldPlayAgain());
	}

	/**
	 * Wrap complete game within this static method.
	 * @return void
	 */
	public static void playOneGame() {
		
		int low = 1;
		int high = 100;
		int guess;
		int oldguess = 0;
		
		char userResponse;

		Scanner input = new Scanner(System.in);
		
		System.out.print("Guess a number between 1 and 100. [Press Enter]");
		input.nextLine();
		
		do {
			guess = getMidpoint(low, high);
			if(oldguess == guess && guess == 99) { //Guess can be up to 100, so handle that edge case.
				guess = 100;
			}
			
			userResponse = getUserResponseToGuess(guess);
			
			if(userResponse == 'l') {
				high = guess;
			} else if(userResponse == 'h') {
				low = guess;
			}
			
			oldguess = guess;
			
		} while(userResponse != 'c');
		
	}
	
	/**
	 * Prompt user to determine if they want to play again. Return true if character is 'y'
	 * else return false.
	 * @return boolean
	 */
	public static boolean shouldPlayAgain() {
		Scanner input = new Scanner(System.in);
		char playAgain;
		
		do {
			System.out.print("Great! Do you want to play again? (y/n): ");
			playAgain = input.next().charAt(0);
		} while(playAgain != 'y' && playAgain != 'n');
		
		if(playAgain == 'y') {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This is the method that gets "h/l/c" and should return one.
	 * @param guess 
	 * @return char
	 */
	public static char getUserResponseToGuess(int guess) {
		Scanner input = new Scanner(System.in);
		char retval;
		
		do {
			System.out.print("Is it " + guess + "? (h/l/c): ");
			retval = input.next().charAt(0);
		} while(retval != 'h' && retval != 'l' && retval != 'c');
		
		return retval;
	}

	/**
	 * Given a low and high int, return the number in the middle (round down if necessary)
	 * @param low
	 * @param high
	 * @return int
	 */
	public static int getMidpoint(int low, int high) {
		int diff = high - low;
		int halfOfDiff = (int) Math.floor(diff / 2);
		int midpoint = low + halfOfDiff;
		
		return midpoint;
	}

}
