package circles;
import java.math.*;

public class MyCircle {
	/**
	 * The radius of the circle.
	 */
	private float radius;
	
	/**
	 * Circle's horizontal position
	 */
	private float x;
	
	/**
	 * Circle's vertical position
	 */
	private float y;
	
	public void setX(float value) {
		x = value;
	}
	
	public float getX() {
		return x;
	}
	
	public void setY(float value) {
		y = value;
	}
	
	public float getY() {
		return y;
	}
	
	public void setRadius(float value) {
		radius = value;
	}
	
	public float getRadius() {
		return radius;
	}
	
	/**
	 * Area = pi * r^2
	 * @return Area of the circle
	 */
	public float getArea() {
		float area;
		area = (float) Math.PI * (radius * radius);		
		return area;
	}
	
	/**
	 * @param otherCircle
	 * @return Does this circle overlap with otherCircle?
	 * Two circles overlap if the sum of their radius is greater than the distance between the two centers
	 * To find the distance between the centers, the formula is sqrt((x1-x2)^2 + (y1-y2)^2)
	 */
	public boolean doesOverlap(MyCircle otherCircle) {
		float distanceBetweenCenters;
		float radiusSum;
		float xDiff, yDiff;
		
		xDiff = x - otherCircle.getX();
		yDiff = y - otherCircle.getY();
		
		distanceBetweenCenters = (float) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
		radiusSum = radius + otherCircle.getRadius();
		
		if(radiusSum > distanceBetweenCenters) {
			return true;
		} else {
			return false;
		}
	}
	
}
