package highscores_improved;

public class HighScores {

	private String name;
	private int score;
	
	public HighScores(String n, int s) {
		this.name = n;
		this.score = s;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setScore(int s) {
		this.score = s;
	}
	
	public int getScore() {
		return this.score;
	}
	
}
