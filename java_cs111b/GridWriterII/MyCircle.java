package GridWriterII;


public class MyCircle extends GridItem {

	private int radius;
	
	public MyCircle(int xValue, int yValue, int r) {
		x = xValue;
		y = yValue;
		radius = r;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public boolean containsPoint(int xValue, int yValue) {
		double dx = x - xValue;
		double dy = y - yValue;
		double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		
		return distance <= radius;
	}
}