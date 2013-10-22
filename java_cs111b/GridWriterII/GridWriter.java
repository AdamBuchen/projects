package GridWriterII;


public class GridWriter {
	
	private GridItem items[];
	private int size;
	private int rows;
	private int columns;
	private static final int INITIAL_CAPACITY = 4;
	
	public GridWriter(int r, int c) {
		items = new GridItem[INITIAL_CAPACITY];
		size = 0;
		rows = r;
		columns = c;
	}
	
	public int size() {
		return size;
	}
	
	public GridItem get(int index) {
		GridItem gi;
		if(index >= size) {
			throw new IndexOutOfBoundsException("That item doesn't exist!");
		}
		
		gi = items[index];
		return gi;
	}
	
	public void add(GridItem x) {
		if (size == items.length) {
			doubleItemCapacity();
		}
		
		items[size] = x;
		size++;
	}
	
	public void display() {
		int count;
		
		for (int r = rows; r >= 0; r--) {
			for (int c = 0; c < columns; c++) {
				
				count = 0;
				
				for (int i = 0; i < size; i++) {
					if (items[i].containsPoint(c, r)) {
						count++;
					}
				}
				
				if (count == 0) {		
					System.out.print(" .");
				} else {
					System.out.print(" " + count);
				}
			}
			
			System.out.println();
		}
	}
	
	
	
	private void doubleItemCapacity() {
		GridItem temp[] = new GridItem[items.length * 2];
		
		for (int i = 0; i < items.length; i++) {
			temp[i] = items[i];
		}
		
		items = temp;
	}
	
	public MyIterator iterator() {
		return new GridIterator();
	}
	
	
	private class GridIterator implements MyIterator {
		
		private int index = 0;
		
		public boolean hasNext() {
			return index < size;
		}
		
		public Object next() {
			Object returnValue = items[index];
			index++;
			
			return returnValue;
		}
	}
}















