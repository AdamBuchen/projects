import java.util.*;

public class BlackJackGame {

	public static void main(String args[]) {
		
		int playerTotal = 0, dealerTotal = 0;
		int firstPlayerCard, secondPlayerCard;
		int nextPlayerCard, nextDealerCard;
		final int MAX_SCORE = 21;
		final int MIN_DEALER_SCORE = 17;
		
		char continuePlaying = 'y'; //Whether the user is going to continue playing after each hand.
		char continueChar = 'c';
		char hitChar = 'y';
		char standChar = 'n';
		char lastInput = 'y';
		
		boolean playerBusted;
		
		boolean playerContinueDealing; //Whether the player is going to continue getting cards during each hand
		boolean dealerContinueDealing; //Whether the dealer is going to continue getting cards
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		while(continuePlaying != 'n') {			
			//New hand, reset
			playerBusted = false;
			playerContinueDealing = true;
			dealerContinueDealing = true;
			
			//We only know the dealer's first card
			dealerTotal = random.nextInt(10) + 1;
			
			//We need to know the values of the first two cards drawn to output to the user, plus running total
			firstPlayerCard = random.nextInt(10) + 1;
			secondPlayerCard = random.nextInt(10) + 1;
			playerTotal = firstPlayerCard + secondPlayerCard;
			
			System.out.println("The dealer starts with a " + dealerTotal);
			System.out.println("Your first cards: " + firstPlayerCard + ", " + secondPlayerCard);
			System.out.println("Total: " + playerTotal);

			while(playerContinueDealing == true) {
				//Just keep prompting the user to enter a valid character
				System.out.print("Hit? (y/n): ");
				lastInput = input.next().charAt(0);
				
				if(lastInput == hitChar) {
					nextPlayerCard = random.nextInt(10) + 1;
					playerTotal += nextPlayerCard;
					System.out.println("Card: " + nextPlayerCard);
					System.out.println("Total: " + playerTotal);
					if(playerTotal > MAX_SCORE) {
						System.out.println("Busted! You lose!");
						playerBusted = true;
						playerContinueDealing = false;
					}
				} else if(lastInput == standChar) {
					playerContinueDealing = false;
				}
				
				//We'll only reach here if an invalid character was entered, re-prompt.
			}
			
			//The dealer only continues playing if the player hasn't busted
			if(playerBusted == false) {
				System.out.println("Dealer has a " + dealerTotal + "...");
				
				while(dealerContinueDealing == true) {
					//Keep prompting user to hit c to continue until they do...
					while(lastInput != continueChar) {
						System.out.print("(c to continue) ");
						lastInput = input.next().charAt(0);
					}
					
					lastInput = ' ';
					nextDealerCard = random.nextInt(10) + 1;
					dealerTotal += nextDealerCard;
					System.out.println("Dealer gets a " + nextDealerCard);
					System.out.println("Total: " + dealerTotal);
					if(dealerTotal >= MIN_DEALER_SCORE) {
						dealerContinueDealing = false;
					}
				}
			
				if(dealerTotal > MAX_SCORE) {
					System.out.println("Dealer busts. You win!");
				} else if(dealerTotal == playerTotal) {
					System.out.println("Push!");
				} else if(dealerTotal > playerTotal) {
					System.out.println("Dealer Wins!");
				} else {
					System.out.println("You win!");
				}
			
			}
			
			lastInput = ' ';
			while(lastInput != 'y' && lastInput != 'n') {
				System.out.print("Play Again? (y/n): ");
				lastInput = input.next().charAt(0);
			}
			
			continuePlaying = lastInput;
		}
		
	}
		
}