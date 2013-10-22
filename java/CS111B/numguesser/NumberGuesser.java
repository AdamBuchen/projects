package numguesser;
import java.util.ArrayList;

public class NumberGuesser {

	protected int low, high, originalLow, originalHigh, oldGuess;
	private boolean firstTime = true;
	protected ArrayList<Integer> previousGuesses = new ArrayList<Integer>();
	
	public NumberGuesser(int lowerBound, int upperBound) {
		low = lowerBound;
		originalLow = lowerBound;
		
		high = upperBound;
		originalHigh = upperBound;
		
		this.previousGuesses = new ArrayList<Integer>(originalHigh);		  
		oldGuess = getCurrentGuess();
		firstTime = true;
	}

	public void higher() {
		low = oldGuess;
	}
	
	public void lower() {
		high = oldGuess;
	}
	
	public int getCurrentGuess() {
		int diff = high - low;
		int halfOfDiff = (int) Math.floor(diff / 2);
		int guess = low + halfOfDiff;
		
		if(guess == oldGuess && (guess + 1) == originalHigh) {
			guess++;
		} else if(guess == oldGuess && (guess + 1) == high && !wasPreviouslyGuessed(guess)) {
			guess++;
		} else if (guess == oldGuess && !firstTime) {
			throw new IllegalStateException("You're a cheater!");
		} else if ((guess <= low && guess != originalLow) || (guess >= high && guess != originalHigh)) {
			throw new IllegalStateException("You're a cheater!");
		} else if(wasPreviouslyGuessed(guess) && !firstTime) {
			throw new IllegalStateException("You're a cheater!");
		}
		
		oldGuess = guess;
		firstTime = false;
		
		previousGuesses.add(guess);
		
		return guess;		
	}
	
	public void reset() {
		low = originalLow;
		high = originalHigh;
		firstTime = true;
		this.previousGuesses = new ArrayList<Integer>(originalHigh);
	}
	
	protected boolean wasPreviouslyGuessed(int i) {
		for(int index = 0; index < previousGuesses.size(); index++) {
			int value = (Integer) previousGuesses.get(index);
			if(i == value) {
				return true;
			}
		}
		
		return false;
	}
	
}
