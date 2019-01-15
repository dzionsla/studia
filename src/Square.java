
public class Square extends Rectangle{
	int r;

	public Square(int r) {
		this.r = r;
		sides.add(r);

	}
	
	public double surface() {
		return 3.14*r*r;
	}
}
