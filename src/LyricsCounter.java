import java.util.HashMap;
import java.util.LinkedList;

public class LyricsCounter {
		public LyricsCounter() {
			//System.out.println(getWordsInLyrics().length);
			//printSplittedString();
			HashMap<String, LinkedList<String>> wordBegins = new HashMap<>();
			String[] tablica = getWordsInLyrics();
			countLetters(wordBegins, tablica);
//			for (String key : wordBegins.keySet()) {
//				System.out.println(key + " " + wordBegins.get(key));
//			}
			findMost(wordBegins);
			
		}
	
		private static final String LYRICS = "Dwunastu braci, wierzac w sny, zbadalo mur od marzen strony,\n" +
	            "A poza murem plakal glos, dziewczecy glos zaprzepaszczony.\n" +
	            "I pokochali glosu dzwiek i chetny domysl o Dziewczynie,\n" +
	            "I zgadywali ksztalty ust po tym, jak spiew od zalu ginie...\n" +
	            "Mowili o niej: \"lka, wiec jest!\" - I nic innego nie mowili,\n" +
	            "I przezegnali caly swiat - i swiat zadumal sie w tej chwili...\n" +
	            "Porwali mloty w twarda dlon i jeli w mury tluc z loskotem!\n" +
	            "I nie wiedziala slepa noc, kto jest czlowiekiem, a kto mlotem?\n" +
	            "\"O, predzej skruszmy zimny glaz, nim smierc Dziewczyne rdza powlecze!\" -\n" +
	            "Tak, walac w mur, dwunasty brat do jedenastu innych rzecze.\n" +
	            "Ale daremny byl ich trud, daremny ramion sprzeg i usil!\n" +
	            "Oddali ciala swe na strwon owemu snowi, co ich kusil!\n" +
	            "lamia sie piersi, trzeszczy kosc, prochnieja dlonie, twarze bledna...\n" +
	            "I wszyscy w jednym zmarli dniu i noc wieczysta mieli jedna!\n" +
	            "Lecz cienie zmarlych - Boze moj! - nie wypuscily mlotow z dloni!\n" +
	            "I tylko inny plynie czas - i tylko mlot inaczej dzwoni...\n" +
	            "I dzwoni w przod! I dzwoni wspak! I wzwyz za kazdym grzmi nawrotem!\n" +
	            "I nie wiedziala slepa noc, kto tu jest cieniem, a kto mlotem?\n" +
	            "\"O, predzej skruszmy zimny glaz, nim smierc Dziewczyne rdza powlecze!\" -\n" +
	            "Tak, walac w mur, dwunasty cien do jedenastu innych rzecze.\n" +
	            "Lecz cieniom zbraklo nagle sil, a cien sie mrokom nie opiera!\n" +
	            "I powymarly jeszcze raz, bo nigdy dosc sie nie umiera...\n" +
	            "I nigdy dosc, i nigdy tak, jak pragnie tego ow, co kona!...\n" +
	            "I znikla tresc - i zginal slad - i powiesc o nich juz skonczona!\n" +
	            "Lecz dzielne mloty - Boze moj - mdlej nie poddaly sie zalobie!\n" +
	            "I same przez sie bily w mur, huczaly spizem same w sobie!\n" +
	            "Huczaly w mrok, huczaly w blask i ociekaly ludzkim potem!\n" +
	            "I nie wiedziala slepa noc, czym bywa mlot, gdy nie jest mlotem?\n" +
	            "\"O, predzej skruszmy zimny glaz, nim smierc Dziewczyne rdza powlecze!\" -\n" +
	            "Tak, walac w mur, dwunasty mlot do jedenastu innych rzecze.\n" +
	            "I runal mur, tysiacem ech wstrzasajac wzgorza i doliny!\n" +
	            "Lecz poza murem - nic i nic! Ni zywej duszy, ni Dziewczyny!\n" +
	            "Niczyich oczu ani ust! I niczyjego w kwiatach losu!\n" +
	            "Bo to byl glos i tylko - glos, i nic nie bylo oprocz glosu!\n" +
	            "Nic - tylko placz i zal i mrok i niewiadomosc i zatrata!\n" +
	            "Takiz to swiat! Niedobry swiat! Czemuz innego nie ma swiata?\n" +
	            "Wobec klamliwych jawnie snow, wobec zmarnialych w nicosc cudow,\n" +
	            "Potezne mloty legly w rzad, na znak spelnionych godnie trudow.\n" +
	            "I byla zgroza naglych cisz. I byla proznia w calym niebie!\n" +
	            "A ty z tej prozni czemu drwisz, kiedy ta proznia nie drwi z ciebie?";

	    private String[] getWordsInLyrics() {
	        return LYRICS.split("\\W+");
	    }
	    
	    private void printSplittedString() {
	    	String[] tablica = getWordsInLyrics();
	    	for (int i = 0; i < tablica.length; i++) {
				System.out.print(tablica[i] + " ");
			}
	    }

	    private String takeFirstLetter(String str) {
	    	return str.substring(0, 1).toLowerCase();
	    }

	    private LinkedList<String> createList(String str) {

	    	LinkedList<String> list = new LinkedList<>();
	    	list.add(str);

	    	return list;
	    }
	    
	    private LinkedList<String> updateList(LinkedList<String> list, String str) {

	    	list.add(str);

	    	return list;
	    }
	    
	    private void countLetters(HashMap<String, LinkedList<String>> letterCounter, String[] table) {
	    	
	    	for (int i = 0; i < table.length; i++) {
	    		if (letterCounter.containsKey(takeFirstLetter(table[i]))) {
	    			letterCounter.put(takeFirstLetter(table[i]), updateList(letterCounter.get(takeFirstLetter(table[i])), table[i]));
				}
		    	else {
		    		letterCounter.put(takeFirstLetter(table[i]), createList(table[i]));
		    	}
			}
	    }
	    
	    private void findMost(HashMap<String, LinkedList<String>> map) {
	    	int size = 0;
	    	String letter = null;
	    	for (String str : map.keySet()) {
				int sizeInside;
				sizeInside = map.get(str).size();
				if (sizeInside > size) {
					size = sizeInside;
					letter = str;
				}		
			}
	    	System.out.println(letter + ": " + map.get(letter));
	    	
	    }
	    
}
