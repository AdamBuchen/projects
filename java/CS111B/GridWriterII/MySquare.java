package GridWriterII;

public class MySquare extends MyRectangle {

	private int side;
	
	public MySquare(int xValue, int yValue, int s) {
		super(xValue,yValue,s,s);
	}
	
	/**
	public double getArea() {
		return Math.pow(side, 2);
	}

	public boolean containsPoint(int xValue, int yValue) {
		return xValue >= x && xValue <= x + side && yValue >= y && yValue <= y + side;
	}
*/
	
}
