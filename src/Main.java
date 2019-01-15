import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//BusinessCard test = new BusinessCard();
		//PoleTrojkata test = new PoleTrojkata();
		//Srednia test = new Srednia();
		//Dzielnik test = new Dzielnik();
		//Login test = new Login();
		//Sort test = new Sort();
		//LosoweDaty test = new LosoweDaty();
		//Kolekcja test = new Kolekcja();
		//Biblioteka test = new Biblioteka();
		//LyricsCounter test = new LyricsCounter();
		
		/*Guitar i1 = new Guitar();
		Flute i2 = new Flute();
		Instrument i3 = new Trombone();
		Orchestra o = new Orchestra();
		
		o.addInstrument(i1);
		o.addInstrument(i2);
		o.addInstrument(i3);
		o.play();*/
		
		ArrayList<Integer> pol = new ArrayList<>();
		pol.add(20);
		pol.add(20);
		pol.add(20);
		//Polygon p = new Polygon(pol);

		Polygon r = new Rectangle(10,10);
		System.out.println(r.perimeter() + " " + r.surface());
		Polygon t = new Triangle(10,10,10);
		System.out.println(t.perimeter() + " " + t.surface());
		Polygon s = new Square(10);
		System.out.println(s.perimeter() + " " + s.surface());
		Polygon poli = new Polygon(pol);
		System.out.println(poli.perimeter() + " " + poli.surface());
		
		
		//ArrayList<Integer> pol = new ArrayList<>();
		//Polygon p = new Polygon(1);
	}			
}
