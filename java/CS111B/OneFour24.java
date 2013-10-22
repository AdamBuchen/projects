import java.util.*;

public class OneFour24 {

	public static void main(String[] args) {
		do {
			playOneGame();
		} while(playAgain());
	}

	public static void playOneGame() {
		final int NUM_DICE = 6;
		
		int numRemainingDice = NUM_DICE;
		int currentHandIndex = 0; //Where to start filling in selected dice in the hand array
		int diceKept; //You must keep at least one die per roll
		int totalHandValue = 0; //Running total of your hand's value
		int diceValue;
		
		int[] hand = new int[NUM_DICE]; //The ever-growing dice hand - max size is the total number of dice you can play
		int[] diceRolled;
		
		boolean hasQualified = false;
		boolean hasOne = false; //We won't accumulate the total with the first one and first four retained - used for qualifying
		boolean hasFour = false;
		
		char keepDice;
		
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		
		while(numRemainingDice > 0) {
			System.out.print("Rolling " + numRemainingDice + " dice. [Press Enter]");
			input.nextLine();
			diceRolled = new int[numRemainingDice];
			for(int i=0; i < numRemainingDice; i++) {
				diceRolled[i] = random.nextInt(6) + 1;
			}
			
			System.out.print("Your roll is: ");
			for(int i=0; i < numRemainingDice; i++) {
				System.out.print(diceRolled[i] + " ");
			}
			
			System.out.print("[Press Enter]");
			input.nextLine();
			
			diceKept = 0;
			do {
				for(int i=0; i < numRemainingDice; i++) {
					diceValue = diceRolled[i];
					do {
						System.out.print("Keep the " + diceValue + "? (y/n): ");
						keepDice = input.next().charAt(0);
					} while(keepDice != 'y' && keepDice != 'n');
				
					if(keepDice == 'y') {
						if(diceValue == 1 && !hasOne) {
							hasOne = true;
						} else if(diceValue == 4 && !hasFour) {
							hasFour = true;
						} else {
							totalHandValue += diceValue;
						}
						
						hand[currentHandIndex] = diceValue;
						currentHandIndex++;
						diceKept++;
					}
				}
				
				numRemainingDice = numRemainingDice - diceKept;
				
				if(diceKept == 0) {
					System.out.println("You must keep at least one dice!");
				}
			} while(diceKept == 0);
			
			System.out.print("Your current hand: ");
			for(int i=0; i < hand.length; i++) {
				if(hand[i] > 0) {
					System.out.print(hand[i] + " ");
				}
			}
			System.out.print("[Press Enter]\n");
			input.nextLine();
			
			System.out.println("Your current hand total is " + totalHandValue + " [Press Enter]");
			if(!hasOne) {
				System.out.println("You still need a 1 to qualify. [Press Enter]");
			}
			
			if(!hasFour) {
				System.out.println("You still need a 4 to qualify. [Press Enter]");
			}
			
			if(hasOne && hasFour) {
				System.out.println("You have a qualifying hand!");
			}
			
		}
		
		if(!hasOne || !hasFour) {
			System.out.println("Your hand does not qualify. Sorry, you lose!");
		} else {
			System.out.println("Your hand qualifies! Total value: " + totalHandValue);
		}
		
		
	}
	
	public static boolean doesHandQualify(int[] hand) {
		boolean hasFour = false;
		boolean hasOne = false;
		int value;
		
		for(int i = 0; i < hand.length; i++) {
			value = hand[i];
			if(value == 1) {
				hasOne = true;
			} else if(value == 4) {
				hasFour = true;
			}
		}
		
		if(hasOne && hasFour) {
			return true;
		} else {	
			return false;
		}
	}
	
	public static boolean playAgain() {
		
		return false;
	}
	
	    
}