import java.util.ArrayList;

public class Polygon {
	public ArrayList<Integer> sides = new ArrayList<>();
	
	public Polygon() {
		
	}
	
	public Polygon(ArrayList<Integer> sides) {
		this.sides = sides;
	}
		
	public double perimeter() {
		Integer result = 0;
		
		for (Integer integer : sides) {
			result = result + integer;
			//System.out.println(integer);
		}
		
		return result;
	};
	public double surface() {
		return 0;
	}
}
