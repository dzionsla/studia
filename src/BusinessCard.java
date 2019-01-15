import java.util.Scanner;

public class BusinessCard {
	
	public BusinessCard() {
		String ulica = "Lipinskiego 1/26123121231";
		int telefon = 606350;
		String calosc1, calosc2;
		int roznica;
				
		Scanner wprowadz = new Scanner(System.in);
		System.out.println("Podaj imie i nazwisko: ");		
		String dane = wprowadz.next();

		calosc1 = ("* " + dane);
		calosc2 =( "* Adres: " + ulica + " Telefon: " + telefon);
		roznica = calosc2.length() - calosc1.length();
				
		if(roznica <= 0) {
			rysujGwiazdki(calosc1.length());
			System.out.println();
			System.out.println(calosc1 + " *");
			System.out.print(calosc2);
			rysujSpacje(Math.abs(roznica));
			System.out.println();
			rysujGwiazdki(calosc1.length());
		}
		else{
			rysujGwiazdki(calosc2.length());
			System.out.println();
			System.out.print(calosc1);
			rysujSpacje(roznica);
			System.out.println();
			System.out.println(calosc2 + " *");
				
			rysujGwiazdki(calosc2.length());
		}
	}
	
	static void rysujGwiazdki(int dlugosc) {
		for(int i = 0; i < dlugosc + 2; i++) {
			System.out.print("*");
		}	
	}
			
	static void rysujSpacje(int dlugosc) {
		for(int i = 0; i < dlugosc + 1; i++) {
			System.out.print(" ");
		}	
		System.out.print("*");
	}

}
