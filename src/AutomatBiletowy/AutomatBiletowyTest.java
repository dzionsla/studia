package AutomatBiletowy;

import java.util.Scanner;

public class AutomatBiletowyTest {
	static int actualPage = 0;
	static Scanner odczyt = new Scanner(System.in);
	static int actualMoney = 100;
	
	public static void main(String[] args) throws InterruptedException {	
		
		showMainMenu();
		outerloop:
		while(true) {
			
			String input = odczyt.nextLine();
			
			switch (input) {
			case "q":
				break outerloop;
			case "1":
				showTicketMenu();
				break;
			case "11":
				Ticket(11);
				break;
			case "12":
				Ticket(12);
				break;
			case "2":
				showRozkladMenu(); 
				break;
			case "3":
				showNewsMenu() ; 
				break;
			case "4":
				checkMoney();
				break;
			case "0":
				showMainMenu();
				break;
			default:
				showMainMenu();				
				//System.out.println("Nie ma takiej opcji. Wybierz ponownie"); 
				break;
			}  
		}
		System.out.println("koniec programu");
	}
	
	static void clearWindow(){
		for(int clear = 0; clear < 10; clear++) {
		    System.out.println("\n") ;
		}
	}
	
	static void showMainMenu() {
		actualPage = 0;
		clearWindow();
		System.out.println("1. Kup bilet.\n"
				+ "2. Sprawdz rozklad.\n"
				+ "3. Zobacz aktualnosci\n"
				+ "4. Kasa\n"
				+ "0. Menu glowne\n"
				+ "(Q)uit");
	}
	
	static void showTicketMenu() {
		clearWindow();
		actualPage = 1;
		System.out.println("11. Bilet normalny.\n"
				+ "12. Bilet ulgowy.\n"
				+ "0. Menu glowne");
	}
	
	static void showRozkladMenu() {
		actualPage = 2;
		clearWindow();
		System.out.println("Tutaj jest rozklad bla bla bla\n"
				+ "0. Menu glowne");
		
	}
	
	static void showNewsMenu() {
		actualPage = 3;
		clearWindow();
		System.out.println("Tutaj sa aktualnosci bla bla bla\n"
				+ "0. Menu glowne");
	}
	
	static void Ticket(int type) throws InterruptedException {
		int price = 0;
		clearWindow();
		if (type == 11) {
			actualPage = 11;
			price = 2;
		} else if (type == 12) {
			actualPage = 12;
			price = 4;
		} 
		else {
			actualPage = 1;
			clearWindow();
			showTicketMenu();
		}
		System.out.println("Cena biletu = " + price + "\n"
				+ "Ile biletow chcesz zakupic?\n"
				+ "0. Menu glowne\n");
		int pay = ticketPrice(odczyt.nextInt(), price);
		System.out.println("Do zaplaty " + pay + " Ile wsadzasz?\n");
		int payed = odczyt.nextInt();
		System.out.println("Wplaciles " + payed + ". Reszta wynosi: " + (payed - pay));
		if ((payed - pay) >= 0) {
			System.out.println("Dziekujemy za zakup.");
			takeMoney(pay);
		} else {
			System.out.println("Wplacono za malo pieniedzy. Prosze ponowic proces od poczatku!!");
		}
		Thread.sleep(2000);
		showMainMenu();
	}
	
	static int ticketPrice(int amount, int price) {	
		return amount*price;	
	}
	
	static void takeMoney(int money) {
		actualMoney = actualMoney + money;
	}
	
	static void checkMoney() {
		clearWindow();
		System.out.println("Aktualnie w kasie: " + actualMoney + "\n" + "0. Menu glowne");
	}

}
