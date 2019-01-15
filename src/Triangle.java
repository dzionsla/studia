
public class Triangle extends Polygon{
	int a,b,c;

	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		sides.add(a);
		sides.add(b);
		sides.add(c);
	}
	
	public double surface() {
		double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

}
