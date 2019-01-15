package Codes;

public class CezarCode {
	int key = 3; // klucz
    public final int LETTERS_IN_ALPHABET = 'z'-'a'+1;
    public final int LETTERS_START = 'a';
    
    String encode(String msg) {
        int localKey = key % LETTERS_IN_ALPHABET;

        StringBuilder result = new StringBuilder(msg);
        
        for (int i = 0; i < msg.length(); i++) {
        	 char c = msg.charAt(i);
        	 if (c >= LETTERS_START && c < LETTERS_START + LETTERS_IN_ALPHABET) {
        		 c = (char)((msg.charAt(i) - LETTERS_START + localKey) % LETTERS_IN_ALPHABET + LETTERS_START);
        		 result.setCharAt(i, c);
        	 }
        }
        return result.toString();
    }
	
	String decode(String msg) {
        int localKey = key % LETTERS_IN_ALPHABET;

        System.out.println(localKey);
        StringBuilder result = new StringBuilder(msg);

        for (int i = 0; i < msg.length(); i++) {
        	 char c = msg.charAt(i);
        	 if (c >= LETTERS_START && c < LETTERS_START + LETTERS_IN_ALPHABET) {
        		 c = (char)((msg.charAt(i) - LETTERS_START - localKey) % LETTERS_IN_ALPHABET + LETTERS_START);
        		 result.setCharAt(i, c);
        	 }
        }
        return result.toString();
	}
}
