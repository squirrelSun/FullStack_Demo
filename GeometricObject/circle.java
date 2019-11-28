package GeometricObject;

public class circle extends geometricObject {

	private double radius;
	
	
	public circle() {
		super();
		this.radius=1.0;
	}

	public circle(double radius,String color, double weight) {
		super(color, weight);
		this.radius=radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double findArea() {
		return 3.14*radius*radius;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		circle other = (circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	public String toString() {
		return "circle [radius=" + radius + "]";
	} 
	
	
}
