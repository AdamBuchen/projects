package rangefinder;

public class Range {

	private int min, max;
	
	public Range(int lower, int upper) {
		this.min = lower;
		this.max = upper;
	}
	
	public Range(Range r) {
		this.min = r.min;
		this.max = r.max;
	}
	
	public void setLowerBound(int value) {
		this.min = value;
	}
	
	public int getLowerBound() {
		return this.min;
	}
	
	public void setUpperBound(int value) {
		this.max = value;
	}

	public int getUpperBound() {
		return this.max;
	}

	public boolean contains(int value) {
		if(value >= this.min && value <= this.max) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Range r) {
		if(r.min >= this.min && r.max <= this.max) {
			return true;			
		} else {
			return false;
		}
	}
	
	public boolean equals(Range r) {
		if(r.min == this.min && r.max == this.max) {
			return true;
		} else {
			return false;
		}
	}
	
public void expandToContain(Range other) {
	if(other.min < this.min) {
		this.min = other.min;
	}
	
	if(other.max > this.max) {
		this.max = other.max;
	}
}
	
}
