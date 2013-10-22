package circles_improved;

public class CircleTester {

	public static void main(String args[]) {
		Circle circle1, circle2, circle3, circle4;
		Point point1;
		
		//First, let's create a circle with the 2-argument constructor
		point1 = new Point(5,-3);
		circle1 = new Circle(point1,10);
		
		//Now, three argument constructor
		circle2 = new Circle(-40,2,10);
		
		//Circle created with no-argument default value constructor
		circle3 = new Circle();
		
		//Now let's create a circle using the copy constructor that will equal circle1
		circle4 = new Circle(circle1);
		
		//First, let's output each of the circles' data with the toString method.
		System.out.println(circle1);
		System.out.println(circle2);
		System.out.println(circle3);
		System.out.println(circle4);
		
		//Circle 1 should not overlap with circle 2, let's check that.
		if(circle1.doesOverlap(circle2)) {
			System.out.println("Circles 1 and 2 overlap");
		} else {
			System.out.println("Circles 1 and 2 do not overlap");
		}
		
		//Circle 1 should overlap with circle 3, let's check that.
		if(circle1.doesOverlap(circle3)) {
			System.out.println("Circles 1 and 3 overlap");
		} else {
			System.out.println("Circles 1 and 3 do not overlap");
		}
		
		//Circle 1 should equal circle 4, let's verify
		if(circle1.equals(circle4)) {
			System.out.println("Circles 1 and 4 are equal");
		} else {
			System.out.println("Circles 1 and 4 are not equal");
		}
		
		//Circle 3 should not equal circle 4, let's check
		if(circle3.equals(circle4)) {
			System.out.println("Circles 3 and 4 are equal");
		} else {
			System.out.println("Circles 3 and 4 are not equal");
		}
		
	}
	
}
