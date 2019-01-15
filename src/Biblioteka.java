import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Biblioteka {
	private static String[] BOOKS = {"Priests Of Dawn",
            "Chicken Abroad",
            "Lord With Sins",
            "Chicken Abroad",
            "Fish And Horses",
            "Mistress Of Devotion",
            "Bandit Of The Void",
            "Lord With Sins",
            "Guardians And Gangsters",
            "Lions Of Dread",
            "Chicken Abroad",
            "Future Of Fire",
            "Priests Of Dawn",
            "Fish And Horses",
            "Chicken Abroad",
            "Fish And Horses",
            "Guardians And Gangsters",
            "Inception Of Heaven",
            "Lord With Sins",
            "Future Of Fire",
            "Driving Into The Depths",
            "Starting The Demons",
            "Maid With Blue Eyes",
            "Mistress Of Devotion",
            "Lovers In The Forest",
            "Fish And Horses",
            "Maid With Blue Eyes",
            "Destruction Of The Faceless Ones",
            "Guardians And Gangsters",
            "Chicken Abroad"};
	
	public Biblioteka() {
		HashMap<String, Integer> myMap = createBooksCounter();
		for (int i = 0; i < BOOKS.length; i++) {
			countBook(myMap, BOOKS[i]);
		}

		ArrayList<String> myList = findWhiteRavens(myMap);
		printWhiteRavens(myList);
		printUsingSet(BOOKS);
		printUsingTreeSet(BOOKS);
	}
	
	public static HashMap<String, Integer> createBooksCounter() {
		HashMap<String, Integer> mapa = new HashMap<>();
		
		return mapa;
    }

    public static void countBook(HashMap<String, Integer> booksCounter, String book) {
    	if (booksCounter.containsKey(book)) {
    		booksCounter.put(book, booksCounter.get(book) + 1);
		}
    	else {
    		booksCounter.put(book, 1);
    	}
    }

    public static ArrayList<String> findWhiteRavens(HashMap<String, Integer> booksCounter) {
        //booksCounter.
    	ArrayList<String> list = new ArrayList<>();
//    	for (java.util.Map.Entry<String, Integer> entry : booksCounter.entrySet()) {
//    		if (entry.getValue() == 1) {
//				list.add(entry.getKey());
//			}
//		}
    	for (String key : booksCounter.keySet()) {
    		if (booksCounter.get(key) == 1) {
				list.add(key);
			}
		}
    	return list;
    }

    public static void printWhiteRavens(ArrayList<String> whiteRavens) {
    	System.out.println("Biale kruki uzywajac kolekcji ArrayList: ");
    	for (String string : whiteRavens) {
			System.out.println(string);
		}
    }
	
    public static void printUsingSet(String[] books) {
    	Set<String> mySet = new HashSet<String>();
    	for (int i = 0; i < books.length; i++) {
			mySet.add(books[i]);
		}
    	System.out.println();
    	System.out.println("Wypisanie nazw ksiazek bez powtorek z kolekcja Set: ");
    	for (String string : mySet) {
			System.out.println(string);
		}
    }
    
    public static void printUsingTreeSet(String[] books) {
    	Set<String> mySet = new TreeSet<String>();
    	for (int i = 0; i < books.length; i++) {
			mySet.add(books[i]);
		}
    	System.out.println();
    	System.out.println("Wypisanie nazw ksiazek uporzadkowanych alfabetycznie z kolekcja Set: ");
    	for (String string : mySet) {
			System.out.println(string);
		}
    }
}
