package GeometricObject;

public class myRectangle extends geometricObject {

	private double width;
	private double height;
	
	
	
	public myRectangle() {
		super();
		this.weight=1.0;
		this.height=2.0;
	}

	public myRectangle(double width, double height, String color, double weight) {
		super(color, weight);
		this.width=width;
		this.height=height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double findArea() {
		return width*height;
	}

	public String toString() {
		return "myRectangle [width=" + width + ", height=" + height + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		myRectangle other = (myRectangle) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	} 
	
	
}
