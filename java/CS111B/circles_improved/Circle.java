package circles_improved;
import java.util.*;

public class Circle {

	private Point origin;
	
	private double radius;
	
	/**
	 * 2-argument constructor
	 * @param origin Point object
	 * @param radius Radius of the circle
	 */
	public Circle(Point o, double r) {
		this.origin = new Point(o);
		this.radius = r;
	}
	
	/**
	 * 3-argument constructor
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(double xValue, double yValue, double r) {
		this.origin = new Point(xValue,yValue);
		this.radius = r;
	}
	
	/**
	 * No-argument constructor, use default values
	 */
	public Circle() {
		this.origin = new Point(0,0);
		this.radius = 1.0;
	}
	
	/**
	 * The copy constructor
	 * @param originalCircle The circle whose properties to copy
	 */
	public Circle(Circle c) {
		this.origin = new Point(c.origin);
		this.radius = c.radius;
	}
	
	/**
	 * Return a new copy of the origin object (of type Point)
	 * @return Point A copy of the origin object, returned by value
	 */
	public Point getOrigin() {
		return new Point(this.origin);
	}	
	
	/**
	 * Overwrite the origin field with an instance of an outside supplied Point object
	 * @param newOrigin Point
	 */
	public void setOrigin(Point newOrigin) {
		this.origin = new Point(newOrigin);
	}
	
	/**
	 * Set the X value in the origin object
	 * @param xVal double
	 */
	public void setX(double value) {
		this.origin.setX(value);
	}
	
	/**
	 * Get the origin object's x value
	 * @return double The x-coordinate
	 */
	public double getX() {
		return this.origin.getX();
	}
	
	/**
	 * Set the Y value in the origin object
	 * @param yVal double
	 */
	public void setY(double value) {
		this.origin.setY(value);
	}
	
	/**
	 * Get the origin object's y value
	 * @return double The y-coordinate
	 */
	public double getY() {
		return this.origin.getY();
	}
	
	/**
	 * Set the radius of the circle
	 * @param value double Radius of the circle
	 */
	public void setRadius(double value) {
		this.radius = value;
	}
	
	/**
	 * Get the radius of the circle
	 * @return double Radius of the circle
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Get the area of the circle
	 * @return double The area of the circle
	 */
	public double getArea() {
		double area;
		area = (double) Math.PI * (Math.pow(this.radius, 2));		
		return area;
	}
	
	/**
	 * Get a string displaying the circle's properties
	 * @return string
	 */
	public String toString() {
		String str = "Properties for circle\n";
		str += "X: " + this.getX() + "\n";
		str += "Y: " + this.getY() + "\n";
		str += "Radius: " + this.getRadius() + "\n";
		
		return str;
	}
	
	/**
	 * Determine if another circle has the same coordinates and radius as this instance of the circle
	 * @param c Another circle object
	 * @return boolean Whether or not the circles are the same in terms of coordinate and radius
	 */
	public boolean equals(Circle c) {
		if(this.getX() == c.getX() && this.getY() == c.getY() && this.getRadius() == c.getRadius()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param c The circle to compare against
	 * @return Does this circle overlap with otherCircle?
	 * Two circles overlap if the sum of their radius is greater than the distance between the two centers
	 * To find the distance between the centers, the formula is sqrt((x1-x2)^2 + (y1-y2)^2)
	 */
	public boolean doesOverlap(Circle c) {
		double distanceBetweenCenters;
		double radiusSum;
		double xDiff, yDiff;
		
		xDiff = this.getX() - c.getX();
		yDiff = this.getY() - c.getY();
		
		distanceBetweenCenters = (double) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
		radiusSum = this.radius + c.getRadius();
		
		if(radiusSum > distanceBetweenCenters) {
			return true;
		} else {
			return false;
		}
	}
	
}
