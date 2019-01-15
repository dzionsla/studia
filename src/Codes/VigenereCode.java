package Codes;

public class VigenereCode {
	String key = null;
	public final int LETTERS_START = 'a';
	public final int LETTERS_IN_ALPHABET = 'z'-'a'+1;
    private char[][] alphabetTable = new char[LETTERS_IN_ALPHABET][LETTERS_IN_ALPHABET];

    
    public VigenereCode() {
    	createVigenereTable();
    }
    
    int findCharInArray(String array, char character) {
    	return array.indexOf(character);
    }
    
    void createVigenereTable() {
    	int c = 0;
    	for (int i = 0; i < alphabetTable.length; i++) {
			for (int j = 0; j < alphabetTable.length; j++) {
				if ((char)('a' + j + i) > 'z') {
					alphabetTable[i][j] = (char)('a' + j + i - LETTERS_IN_ALPHABET);
				}
				else {
					alphabetTable[i][j] = (char)('a' + j + i);
				}
				System.out.print(alphabetTable[i][j] + " ");
			}
			System.out.println();
		}
    	
    }
    
    String createKey(String key, String msg) {
    	int cnt = 0;
    	char[] myMsgChars = msg.toCharArray();
    	
    	for (int i = 0; i < myMsgChars.length; i++) {
			if (myMsgChars[i] != ' ') {
				myMsgChars[i] = key.charAt(cnt);
				cnt++;
				if (cnt == key.length()) {
					cnt = 0;
				}
			}
		}
    	//System.out.println(msg);
    	//System.out.println(String.valueOf(myMsgChars));
    	return String.valueOf(myMsgChars);
    	
    }
  
    String encode(String msg, String key) {
    	String localKey = createKey(key, msg);
    	int row = 0;
    	int col = 0;
    	
    	char[] msgChars = msg.toCharArray();
    	char[] keyChars = localKey.toCharArray();
    	
    	for (int i = 0; i < msgChars.length; i++) {
			for (int j = 0; j < LETTERS_IN_ALPHABET; j++) {
				if (msgChars[i] == alphabetTable[0][j]) {
					col = j;
				}
				if (keyChars[i] == alphabetTable[j][0]) {
					row = j;
				}
			}
			if (msgChars[i] == ' ') {
				msgChars[i] = ' ';
			} else {
				msgChars[i] = alphabetTable[row][col];
			}
    		
		}
        return String.valueOf(msgChars);
    }
		
	String decode(String msgCoded, String key) {
		String localKey = createKey(key, msgCoded);
    	int row = 0;
    	int col = 0;
    	
    	char[] msgChars = msgCoded.toCharArray();
    	char[] keyChars = localKey.toCharArray();
    	
    	for (int i = 0; i < msgChars.length; i++) {
			for (int j = 0; j < LETTERS_IN_ALPHABET; j++) {
				if (keyChars[i] == alphabetTable[0][j]) {
					for (int j2 = 0; j2 < alphabetTable[j].length; j2++) {
						if (msgChars[i] == alphabetTable[j2][j]) {
							row = j2;
							break;
						}
					}
				}
			}
			if (msgChars[i] == ' ') {
				msgChars[i] = ' ';
			} else {
				msgChars[i] = alphabetTable[row][0];
			}
    		
		}
        return String.valueOf(msgChars);
	}
}
