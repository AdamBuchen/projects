package GridWriterII;


public class GridItem {
	protected int x;
	protected int y;
	
	public int getX() {return x;}
	public void setX(int value) {x = value;}
	
	public int getY() {return y;}
	public void setY(int value) {y = value;}
	
	public double getArea() {
		return 0;
	}

	public boolean containsPoint(int xValue, int yValue) {
		return x == xValue && y == yValue;
	}	
}