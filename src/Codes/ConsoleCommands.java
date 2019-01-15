package Codes;

import java.util.Scanner;

public class ConsoleCommands {
	static Scanner read = new Scanner(System.in);
	CezarCode cezar = new CezarCode();
	VigenereCode vigenere = new VigenereCode();
	int actualPage = 0;
	
	void clearWindow(){
		for(int clear = 0; clear < 12; clear++) {
		    System.out.println("\n") ;
		}
	}
	
	void showMainMenu() {
		clearWindow();
		actualPage = 0;
		System.out.println("1. Cezar coding.\n"
				+ "2. Cezar decoding.\n"
				+ "3. Vinegere coding.\n"
				+ "4. Vinegere decoding.\n"
				+ "0. Main Menu\n"
				+ "q. Quit.");
	}
	
	void cezarCode() {
		String msg;
		
		System.out.println("You want to create Cezar coding!");
		System.out.println("What message should be coded?");
		msg = read.nextLine();
		
		System.out.println(cezar.encode(msg));
	}
	
	void cezarDecode() {
		String msg;
		
		System.out.println("You want to create Cezar decoding!");
		System.out.println("What message should be decoded?");
		msg = read.nextLine();
		
		System.out.println(cezar.decode(msg));
	}
	
	void vigenereCode() {
		String msg, code;
		
		System.out.println("You want to create Vigenere coding!");
		System.out.println("What message should be coded?");
		msg = read.nextLine();
		System.out.println("What key should be used?");
		code = read.nextLine();
		
		System.out.println(vigenere.encode(msg, code));
	}
	
	void vigenereDecode() {
		String msg, code;
		
		System.out.println("You want to create Vigenere decoding!");
		System.out.println("What message should be decoded?");
		msg = read.nextLine();
		System.out.println("What key should be used?");
		code = read.nextLine();
		
		System.out.println(vigenere.decode(msg, code));
	}
	
}