package GeometricObject;

public class geometric_test {

	public static void main(String[] args) {
		geometric_test test=new geometric_test();
		
		circle c1=new circle(2.3, "yellow", 1.0);
		test.displayGeometricObject(c1);
		circle c2=new circle(3.3, "yellow", 1.0);
		test.displayGeometricObject(c2);
		boolean isEquals=test.equalsArea(c1, c2);
		System.out.println("面积是否相等"+isEquals);
		
		myRectangle r1=new myRectangle(2, 3, "whith", 2.0);
		test.displayGeometricObject(r1);
		myRectangle r2=new myRectangle(3, 3, "whith", 3.0);
		test.displayGeometricObject(r2);
		boolean isEquals2=test.equalsArea(r1, r2);
		System.out.println("面积是否相等"+isEquals2);
	}
	
	public void displayGeometricObject(geometricObject o) {
		System.out.println("面积为："+o.findArea());
	}
	
	//面积是否相等
	public boolean equalsArea(geometricObject o1,geometricObject o2) {
		return o1.findArea() == o2.findArea();
	}
	
}
