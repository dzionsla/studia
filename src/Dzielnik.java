import java.util.Scanner;

public class Dzielnik {
	public Dzielnik() {
		int liczba = readNumber();
		int[] result = findDividers(liczba);
		printDividers(result);
	}
	
	public int readNumber() {
		System.out.println("Podaj liczbe naturalna: ");
		Scanner wprowadz = new Scanner(System.in);
		int liczbaNatruralna = wprowadz.nextInt();
		return liczbaNatruralna;
	}
	
	public boolean checkDivider(int numberToCheck, int divider) {
		return numberToCheck % divider == 0;
	}

	public int[] findDividers(int numberToCheck) {
		int[] tempArray = new int[numberToCheck/2];
		int lengthArray = 0;
		for (int i = 1; i <= tempArray.length; i++) {
			if (checkDivider(numberToCheck, i)) {
				tempArray[lengthArray] = i;
				lengthArray++;
			} 
		}
		
		int[] array = new int[lengthArray];
		for (int i = 0; i < array.length; i++) {
			array[i] = tempArray[i];
		}

		return array;
	}
	
	public void printDividers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
