import java.util.*;

public class Assignment2 {

	public static void main(String[] args) {
		for (int i=10; i >= 0; i--) { System.out.println(i); }
		do {
			//playOneGame();
		} while(playAgain());
	}
	
	public static void playOneGame() {
		final int NUM_CARDS_IN_HAND = 5;
		final int MIN_CARD_VALUE = 2;
		final int MAX_CARD_VALUE = 9;
		
		int currentHandIndex = 0;
		int currentCard;
		
		String handTitle;
		
		int[] hand = new int[NUM_CARDS_IN_HAND];
		
		Scanner input = new Scanner(System.in);
		
		for(int i=1; i<=NUM_CARDS_IN_HAND; i++) {
			do {
				System.out.print("Card " + i + ": ");
				currentCard = input.nextInt();
			} while(currentCard < MIN_CARD_VALUE || currentCard > MAX_CARD_VALUE);
			
			hand[currentHandIndex] = currentCard;
			currentHandIndex++;
		}
		
		Arrays.sort(hand);
		
		if(containsFourOfaKind(hand)) {
			handTitle = "Four of a Kind";
		} else if(containsFullHouse(hand)) {
			handTitle = "Full House";
		} else if(containsStraight(hand)) {
			handTitle = "Straight";
		} else if(containsThreeOfaKind(hand)) {
			handTitle = "Three of a Kind";
		} else if(containsTwoPair(hand)) {
			handTitle = "Two Pair";
		} else if(containsPair(hand)) {
			handTitle = "Pair";
		} else {
			handTitle = "High Card";
		}
		
		System.out.println(handTitle + "!");
	}
	
	public static boolean containsPair(int hand[]) {
		int[] counter = getCountByCard(hand);
		int numAppearances;
		
		for(int i=0; i < counter.length; i++) {
			numAppearances = counter[i];
			if(numAppearances == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean containsTwoPair(int hand[]) {
		boolean hasOnePair = false;
		int[] counter = getCountByCard(hand);
		int numAppearances;
		
		for(int i=0; i < counter.length; i++) {
			numAppearances = counter[i];
			if(numAppearances == 2 && hasOnePair) {
				return true;
			} else if(numAppearances == 2) {
				hasOnePair = true;
			}
		}
		
		return false;
	}
	
	public static boolean containsThreeOfaKind(int hand[]) {
		int[] counter = getCountByCard(hand);
		int numAppearances;
		
		for(int i=0; i < counter.length; i++) {
			numAppearances = counter[i];
			if(numAppearances == 3) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean containsStraight(int hand[]) {
		//Comes in sorted, so we can find the minimum and maximum
		int min = hand[0];
		int nextCardForStraight;
		int currentCard;
		
		for(int i=1; i < hand.length; i++) {
			currentCard = hand[i];
			nextCardForStraight = min + i;
			if(currentCard != nextCardForStraight) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean containsFullHouse(int hand[]) {
		boolean hasPair = false;
		boolean hasThree = false;
		int[] counter = getCountByCard(hand);
		int numAppearances;
		
		for(int i=0; i < counter.length; i++) {
			numAppearances = counter[i];
			if(numAppearances == 3) {
				hasThree = true;
			} else if(numAppearances == 2) {
				hasPair = true;
			}
		}
			
		if(hasPair && hasThree) {
			return true;
		}
		
		return false;
	}
	
	public static boolean containsFourOfaKind(int hand[]) {
		int[] counter = getCountByCard(hand);
		int numAppearances;
		
		for(int i=0; i < counter.length; i++) {
			numAppearances = counter[i];
			if(numAppearances >= 4) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int[] getCountByCard(int hand[]) {
		int[] countArray = new int[10]; //Indexed by type of card
		int cardValue;
		
		for(int i=0; i<hand.length; i++) {
			cardValue = hand[i];
			countArray[cardValue]++;
		}
			
		return countArray;
	}
	
	public static boolean playAgain() {
		Scanner input = new Scanner(System.in);
		char lastInput;

		do {
			System.out.print("Play again? (y/n): ");
			lastInput = input.next().charAt(0);
		} while(lastInput != 'y' && lastInput != 'n');
		
		if(lastInput == 'y') {
			return true;
		} else {
			return false;
		}
	}
	
}
