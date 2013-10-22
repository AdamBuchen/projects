package rangefinder;

public class RangeTester {

	public static void main(String args[]) {
		
		Range r1 = new Range(1,100);
		Range r2 = new Range(20,30);
		Range r3 = new Range(r1);
		
		int x = 50;
		int y = 103;
		
		if(r1.contains(x)) {
			System.out.println("yes 1");
		}
		
		if(r1.contains(y)) {
			System.out.println("no 1");
		}
		
		if(r1.contains(r2)) {
			System.out.println("yes 2");
		}
		
		if(r2.contains(r1)) {
			System.out.println("no 2");
		}
		
		if(r1.equals(r3)) {
			System.out.println("yes 3");
		}
		
		if(r2.equals(r3)) {
			System.out.println("no 3");
		}
	}
	
}
