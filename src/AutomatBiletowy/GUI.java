package AutomatBiletowy;

import java.util.Scanner;

public class GUI extends Buttons{
	Scanner keyboard = new Scanner(System.in);
	
	public GUI() {
		System.out.println("Dzien dobry !!\n"
				+ "Nacisnij 's' zeby wystartowac!");

		Buttons test = new Buttons();
	}
	
	void clearWindow(){
		for(int clear = 0; clear < 10; clear++) {
		    System.out.println("\n") ;
		}
	}
	
	void stopProgram() {
		
	}
	
	
	
	
}
