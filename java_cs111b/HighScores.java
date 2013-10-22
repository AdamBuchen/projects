import java.util.*;


public class HighScores {

	public static void main(String args[]) {

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		initialize(names, scores);
		sort(names, scores);
		display(names, scores);
	}
	
	/**
	 * @param names ArrayList<String>
	 * @param scores ArrayList<Integer>
	 * Collect user data to populate the ArrayLists
	 */
	public static void initialize(ArrayList names, ArrayList scores) {
		final int NUM_ENTRIES = 5;
		int currentEntry;
		
		String name;
		int score;
		
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i<NUM_ENTRIES; i++) {
			currentEntry = i + 1;
			System.out.print("Enter the name for score #" + currentEntry + ": ");
			name = input.next();
			System.out.print("Enter the score for score #" + currentEntry + ": ");
			score = input.nextInt();
			names.add(name);
			scores.add(score);
		}
	}
	
	/**
	 * @param names
	 * @param scores
	 * Sort the scores array in ascending order, keep names list matched up
	 */
	public static void sort(ArrayList names, ArrayList scores) {
		
		int maxIndex;
		int maxScore;
		String maxScoreName;
		
		int currentIndex;
		int currentValue;
		
		//Temporary storage for the swap.
		int tempScore;
		String tempName;
		
		//For each slot...
		for(int i=0; i < names.size(); i++) {
			maxIndex = i;
			maxScore = (Integer) scores.get(i);
			maxScoreName = (String) names.get(i);
			
			for(int k=i+1; k < names.size(); k++) {
				currentIndex = k;
				currentValue = (Integer) scores.get(k);
				if(currentValue > maxScore) {
					maxScore = currentValue;
					maxIndex = currentIndex;
					maxScoreName = (String) names.get(k);
				}
			}
			
			//move stuff from i to temp
			//move stuff from minIndex to i
			//move stuff from temp to minIndex
			
			//Now let's swap...
			tempScore = (Integer) scores.get(i);
			tempName = (String) names.get(i);
			
			names.set(i, maxScoreName);
			scores.set(i, maxScore);
			
			names.set(maxIndex, tempName);
			scores.set(maxIndex, tempScore);
			
		}
		
	}
	
	/**
	 * @param names
	 * @param scores
	 * Display the sorted lists
	 */
	public static void display(ArrayList names, ArrayList scores) {
		int score;
		String name;
		
		System.out.println("\nTop Scorers:");
		for(int i=0; i<scores.size(); i++) {
			score = (Integer) scores.get(i);
			name = (String) names.get(i);
			System.out.println(name + ": " + score);
		}
	}
}
