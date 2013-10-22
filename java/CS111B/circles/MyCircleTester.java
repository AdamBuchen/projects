package circles;
import java.util.*;

public class MyCircleTester {

	public static void main(String args[]) {
		
		MyCircle circle1 = new MyCircle();
		MyCircle circle2 = new MyCircle();
		MyCircle circle3 = new MyCircle();
		MyCircle circle4 = new MyCircle();
		
		float area1, area2, area3, area4;
		
		//Circle 1 will be in the center of the grid, radius 10
		circle1.setRadius(10);
		circle1.setX(0);
		circle1.setY(0);
		area1 = circle1.getArea();
		System.out.println("The area of Circle 1 is " + area1);
		
		//Circle 2 will be offset by +20 horizontally, and +5 vertically
		circle2.setRadius(20);
		circle2.setX(15);
		circle2.setY(-5);
		area2 = circle2.getArea();
		System.out.println("The area of Circle 2 is " + area2);
		
		//Circle 3
		circle3.setRadius(25);
		circle3.setX(-50);
		circle3.setY(-10);
		area3 = circle3.getArea();
		System.out.println("The area of Circle 3 is " + area3);
		
		//Circle 4
		circle4.setRadius(45);
		circle4.setX(-45);
		circle4.setY(-8);
		area4 = circle4.getArea();
		System.out.println("The area of Circle 4 is " + area4);
		
		if(circle1.doesOverlap(circle2)) {
			System.out.println("Circles 1 and 2 overlap");
		} else {
			System.out.println("Circles 1 and 2 do not overlap");
		}
		
		if(circle1.doesOverlap(circle3)) {
			System.out.println("Circles 1 and 3 overlap");
		} else {
			System.out.println("Circles 1 and 3 do not overlap");
		}
		
		if(circle1.doesOverlap(circle4)) {
			System.out.println("Circles 1 and 4 overlap");
		} else {
			System.out.println("Circles 1 and 4 do not overlap");
		}

		if(circle2.doesOverlap(circle3)) {
			System.out.println("Circles 2 and 3 overlap");
		} else {
			System.out.println("Circles 2 and 3 do not overlap");
		}
		
		if(circle2.doesOverlap(circle4)) {
			System.out.println("Circles 2 and 4 overlap");
		} else {
			System.out.println("Circles 2 and 4 do not overlap");
		}
		
		if(circle3.doesOverlap(circle4)) {
			System.out.println("Circles 3 and 4 overlap");
		} else {
			System.out.println("Circles 3 and 4 do not overlap");
		}
	}
	
	
}
