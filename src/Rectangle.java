
public class Rectangle extends Polygon{
	int a,b;

	public Rectangle() {
	}
	
	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
		sides.add(a);
		sides.add(b);
	}

	public double surface() {
		return a*b;
	}


}
