package Yahtzee;

import java.util.Scanner;

public class YahtzeeDemo {
	static Scanner odczyt = new Scanner(System.in);
	
	public static void main(String[] args) {
		ConsoleCommands console = new ConsoleCommands();
		console.showMainMenu();
		
		outerloop:
		while(true) {
			String input = odczyt.nextLine();
			
			switch (input) {
			case "q":
				break outerloop;
			case "1":
				//console.showGame();
				new YahtzeeV3();
				console.showMainMenuV1();
				break;
			case "2":
				console.showRules();
				break;
			case "0":
				console.showMainMenu();
				break;
			default:
				console.showMainMenu();				
				System.out.println("No such an option. Try again!"); 
				break;
			}
			
			

		}
	}
	
}
