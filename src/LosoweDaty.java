import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class LosoweDaty {
	public LosoweDaty(){
		System.out.println("Wybierz odpowiednie: ");
		System.out.println("1: Twoja data! ");
		System.out.println("2: Losowa data! ");
		
		Scanner wprowadz = new Scanner(System.in);
		int a = wprowadz.nextInt();
		LocalDate dateNow = LocalDate.now();
		
		switch(a) {
		case 1:
			LocalDate dateUser = loadUserDate();
			System.out.println("dateUser: " + dateUser);
			System.out.println("Roznica miedzy dzisiaj a dateUser: " + (dateNow.until(dateUser)));
		break;
		case 2:
			LocalDate dateRand = loadRandomDate();
			System.out.println("dateRand: " + dateRand);
			System.out.println("Roznica miedzy dzisiaj a dateRand: " + (dateNow.until(dateRand)));
		break;
		default:
			System.out.println("Podales nieistniejaca opcje!!");
		break;
		}
	}
	
	
	static LocalDate loadUserDate() {
		int dzien, miesiac, rok;
		Scanner wprowadz = new Scanner(System.in);
		System.out.print("Podaj dzien: ");
		dzien = wprowadz.nextInt();
		System.out.print("Podaj miesiac: ");
		miesiac = wprowadz.nextInt();
		System.out.print("Podaj rok: ");
		rok = wprowadz.nextInt();
		LocalDate date = LocalDate.of(rok, miesiac, dzien);
		
		return date;
	}
	
	static LocalDate loadRandomDate(){
		int dzien, miesiac, rok;
		dzien = generateRandomNumber(1, 28);
		miesiac = generateRandomNumber(1, 12);
		rok = generateRandomNumber(1900, 2015);
		LocalDate date = LocalDate.of(rok, miesiac, dzien);

		return date;
	}
	
	static int generateRandomNumber(int from, int to){
		Random random = new Random();
		
		return random.nextInt((to - from) + 1) + from;
	}
}
