package highscores_improved;
import java.util.*;

public class HighScoresProgram {

	public static void main(String args[]) {
		final int NUM_SCORES = 5;
		HighScores[] scores = new HighScores[NUM_SCORES];
		
		initialize(scores);
		sort(scores);
		display(scores);
		
	}
	
	public static void initialize(HighScores[] scores) {
		Scanner input = new Scanner(System.in);
		String currentName;
		int currentScore;
		int counter;
		
		HighScores thisScore;
		
		for(int i=0; i<scores.length; i++) {
			counter = i + 1;
			System.out.print("Enter the name for score #" + counter + ": ");
			currentName = input.next();
			System.out.print("Enter the score for score #" + counter + ": ");
			currentScore = input.nextInt();
			scores[i] = new HighScores(currentName,currentScore);
		}	
	}
	
	public static void sort(HighScores[] scores) {

		int maxIndex;
		int maxScore;
		String maxScoreName;
		HighScores scoreObj, currentScoreObj;
		
		int currentIndex;
		int currentValue;
		
		//Temporary storage for the swap.
		int tempScore;
		String tempName;
		
		//For each slot...
		for(int i=0; i < scores.length; i++) {
			maxIndex = i;
			scoreObj = scores[i];
			maxScore = scoreObj.getScore();
			maxScoreName = scoreObj.getName();
			
			for(int k=i+1; k < scores.length; k++) {
				currentIndex = k;
				currentScoreObj = scores[k];
				currentValue = currentScoreObj.getScore();
				if(currentValue > maxScore) {
					maxScore = currentValue;
					maxIndex = currentIndex;
					maxScoreName = currentScoreObj.getName();
				}
			}
			
			//move stuff from i to temp
			//move stuff from maxIndex to i
			//move stuff from temp to maxIndex
			
			//Now let's swap...
			tempScore = scoreObj.getScore();
			tempName = scoreObj.getName();
			
			scoreObj.setName(maxScoreName);
			scoreObj.setScore(maxScore);

			currentScoreObj = scores[maxIndex];
			currentScoreObj.setName(tempName);
			currentScoreObj.setScore(tempScore);

		}
	}
	
	public static void display(HighScores[] scores) {
		HighScores thisScore;
		String currentName;
		int currentScore;
		
		System.out.println("Top Scorers:");
		
		for(int i=0; i<scores.length; i++) {
			thisScore = scores[i];
			currentName = thisScore.getName();
			currentScore = thisScore.getScore();
			
			System.out.println(currentName + ": " + currentScore);
			
		}
	}
	
}
