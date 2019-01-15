import java.util.HashSet;

public class Kolekcja {
	public Kolekcja() {
		String[] names = new String[]{"Ala", "Ola", "Asia", "Basia", "Asia", "Ola", "Ela", "Ela", "Ewa"};
		//ArrayList<String> myList = new ArrayList<String>();
		HashSet<String> myList = new HashSet<String>();
		
		for(int i = 0; i < names.length; i++) {
			myList.add(names[i]);
		}	
		
		for(String p : myList) {
			System.out.print(p + " ");
		}
		
		// ArrayList
		//System.out.println();
		//System.out.println(myList.get(0));
		//System.out.println(myList.contains("Ola"));
		//myList.remove(0);
		//for(String p : myList) {
			//System.out.print(p + " ");
		//}
		
		//HashList
		System.out.println();
		//System.out.println(myList.get(0));
		System.out.println(myList.contains("Ola"));
		myList.remove("Ala");
		for(String p : myList) {
			System.out.print(p + " ");
		}
	}
	
}
