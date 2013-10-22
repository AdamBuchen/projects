package GridWriterII;


public class GridWriterProgram {
	
	public static void main(String[] args) {
		GridWriter gw = new GridWriter(40, 50);
		
		gw.add(new MyCircle(10, 10, 9));
		gw.add(new MyCircle(25, 20, 12));
		gw.add(new MyCircle(25, 20, 5));
		
		try {
			GridItem i = gw.get(30);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		gw.add(new MyRectangle(25, 25, 20, 15));
		
		gw.add(new MySquare(10,5,10));
		gw.add(new MySquare(20,10,10));
		gw.add(new MySquare(5,50,4));
		gw.add(new MySquare(-10,-10,30));
		
		gw.display();
		
		MyIterator it = gw.iterator();
		
		while (it.hasNext()) {
			System.out.println("Item: " + it.next());
		}
	}
	
}