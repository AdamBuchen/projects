package numguesser;
import java.util.*;

public class RandomNumberGuesser extends NumberGuesser {

	protected int randGuess;
	private boolean randGuessSeeded = false;
	
	public RandomNumberGuesser(int lowerBound, int upperBound) {
		super(lowerBound, upperBound);
	}
	
	public void higher() {
		super.higher();
		setRandGuess();
	}
	
	public void lower() {
		super.lower();
		setRandGuess();
	}
	
	private void setRandGuess() {
		Random rand = new Random();
		randGuess = rand.nextInt(high - low + 1) + low; //In the parent class, high and low are protected ints, so subclass can access
		randGuessSeeded = true;
	}
	
	public int getCurrentGuess() {
		if(!randGuessSeeded) {
			setRandGuess();
		}
		
		return randGuess;
	}
	
}
