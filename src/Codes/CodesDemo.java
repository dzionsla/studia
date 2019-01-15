package Codes;

import java.util.Scanner;

public class CodesDemo {
	static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args) {

		ConsoleCommands console = new ConsoleCommands();
		console.showMainMenu();
		outerloop:
			while(true) {
				String input = read.nextLine();
				
				switch (input) {
				case "q":
					break outerloop;
				case "1":		
					console.cezarCode();
					break;
				case "2":
					console.cezarDecode();
					break;
				case "3":
					console.vigenereCode();
					break;
				case "4":
					console.vigenereDecode();
					break;
				case "5":
//					console.showAllEvents();
					break;
				case "0":
//					console.showMainMenu();
					break;
				default:
					System.out.println("Not known command");	
					break;
				}
			}

	}

}
