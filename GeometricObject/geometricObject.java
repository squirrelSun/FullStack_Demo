package GeometricObject;

public class geometricObject {

	protected String color;
	protected double weight;
	
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public geometricObject() {
		super();
		this.color= "white";
		this.weight=1.0;
	}
	
	public geometricObject(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		geometricObject other = (geometricObject) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	public String toString() {
		return "geometricObject [color=" + color + ", weight=" + weight + "]";
	}
	
	public double findArea() {
		return 0.0;
	} 
}
