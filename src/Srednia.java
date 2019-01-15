import java.util.Scanner;

public class Srednia {
	
	public Srednia() {
		double suma = 0.0;
		Scanner wprowadz = new Scanner(System.in);
		System.out.print("Podaj ilosc ocen: ");
		int ileOcen = wprowadz.nextInt();
		double[] tablOcen = new double[ileOcen];
		System.out.println("Podaj oceny ucznia: ");
		
		for(int i = 0; i < ileOcen; i++) {
			int oceny = wprowadz.nextInt();
			tablOcen[i] = (double)oceny;
		}	
		
		System.out.println("Srednia to: " + average(tablOcen));
		System.out.println("Najwyzsza ocena to: " + biggest(tablOcen));
	}
	
	public double average(double[] marks) {
	    double sum = 0;

	    for(int i=0; i<marks.length; i++) {
	        sum += marks[i];
	    }

	    return sum/(double)marks.length;
	}
	
	public double biggest(double[] marks) {
		double value = marks[0];
		
		for(int i=0; i < marks.length; i++) {
			if (value < marks[i]) {
				value = marks[i];
			}
	    }

		return value;	
	}
}
