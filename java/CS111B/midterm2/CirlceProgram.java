package midterm2;

public class CirlceProgram {

	public static void main(String args[]) {
		
		Circle circles[] = new Circle[5];
		for(int i=0; i < circles.length; i++) {
			circles[i] = new Circle();
			if(i == 4) {
				circles[i].setRadius(50);
				System.out.println(circles[i].getTopSpeed());
			}
		}
		
	}
	
}
