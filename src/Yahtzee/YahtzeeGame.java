package Yahtzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class YahtzeeGame {
	Boolean started = false;
	static String player1 = "1st Player";
	static String player2 = "2nd Player";
	static Integer resultP1 = 0;
	static Integer resultP2 = 0;
	static Integer resultP1Round = 0;
	static Integer resultP2Round = 0;
	static int round = 0;
	Map<String, ArrayList<Integer>> game = new HashMap<String, ArrayList<Integer>>();
	ArrayList<Boolean> savedP1 = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false));
	ArrayList<Boolean> savedP2 = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false));
	ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(0));
	static Scanner read = new Scanner(System.in);
	
	public YahtzeeGame(int a) {
		game.put(player1, randomGenerator(player1));
		System.out.println(game);
		game.put(player2, randomGenerator(player2));
		System.out.println(game);
	}
	
	public YahtzeeGame() {
		newGame();
		
		game.put(player1, randomGenerator(player1));
		game.put(player2, randomGenerator(player2));
		round++;
		System.out.println("Round " + round);
		showMap();

		sequence();
		sequence();
		sequence();
		
		System.out.println(player1 + " have: " + resultP1);
		System.out.println(player2 + " have: " + resultP2);
		
		
	}
	
	private void sequence() {
		round++;
		play(whichToSave());
		//whichToSave();
		if (round < 4) {
			game.put(player1, randomGenerator(player1));
			game.put(player2, randomGenerator(player2));
			System.out.println("Round " + round);
			showMap();
		}	
		if (round == 3) {
			//checkValue1(player, value);
		}
	}
	
 	private void checkValue1(String player, Integer value) {
		if (player.equals(player)) {
			resultP1 += roundPoints(game.get(player), value);
		} 
//		else if (player.equals(2)) {
//			//resultP2 += roundPoints(game.get(player), value);
//			//resultP2 += roundPointsBiggest(game.get(player));
//		} 
 		System.out.println(player + ": " + roundPoints(game.get(player), value));
	}
	
	private int toSave(int a) {
//		for (Integer integer : values) {
//			if (integer.equals(game.get(player1).get(a-1))) {
//				System.out.println("You already choosed this number. Pick another one!");
//				return 0;
//			}
//		}	
		savedP1.set(a-1, true);
		
		for (int i = 0; i < 5; i++) {
			if (game.get(player1).get(a-1).equals(game.get(player1).get(i)))  {
				savedP1.set(i, true);
			}
		}
		
		values.add(game.get(player1).get(a-1)); // zapamietaj liczbe wpisana przez gracza
		return game.get(player1).get(a-1);
		
	}
	
	private int whichToSave() {
		System.out.println("Choose which should be saved or (n)ext");
		int result = 0;
		
		outerloop:
		while (true) {
			String input = read.nextLine();
			switch (input) {
			case "1":
				result = toSave(1);
				break;
			case "2":
				result = toSave(2);
				break;
			case "3":
				result = toSave(3);
				break;
			case "4":
				result = toSave(4);
				break;
			case "5":
				result = toSave(5);
				break;
			case "6":
				result = toSave(6);
				break;
			case "n":
				break outerloop;
			default:		
				System.out.println("No such an option. Try again!"); 
				break;
			}
		}
		
		
		return result;
	}
	
	private void play(int input) {
		switch (input) {
		case 1:
			checkValue(player1, 1);
			checkValue(player2);
			break;
		case 2:
			checkValue(player1, 2);
			checkValue(player2);
			break;
		case 3:
			checkValue(player1, 3);
			checkValue(player2);
			break;
		case 4:
			checkValue(player1, 4);
			checkValue(player2);
			break;
		case 5:
			checkValue(player1, 5);
			checkValue(player2);
			break;
		case 6:
			checkValue(player1, 6);
			checkValue(player2);
			break;
		default:		
			System.out.println("No such an option. Try again1111!"); 
			break;
		}
	}

 	private void checkValue(String player, Integer value) {
		if (player.equals(player)) {
			resultP1 += roundPoints(game.get(player), value);
		} 
//		else if (player.equals(2)) {
//			//resultP2 += roundPoints(game.get(player), value);
//			//resultP2 += roundPointsBiggest(game.get(player));
//		} 
 		System.out.println(player + ": " + roundPoints(game.get(player), value));
	}
 	
 	private void checkValue(String player) {
		resultP2 += roundPointsBiggest(game.get(player));
 		System.out.println(player + ": " + roundPointsBiggest(game.get(player)));
	}
	
	private void checkResults() {
		//checkPlayer(player1);
		//checkPlayer(player2);
	}
	
	private void checkPlayer(String player) {
		System.out.println("Player: " + player + " " + roundPoints(game.get(player)));
			
	}
	
	private int roundPoints(ArrayList<Integer> round) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i < 7; i++) {
			map.put(i, Collections.frequency(round, i));
		}

		for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
		    result += pair.getKey() * pair.getValue();
		}
		return result;
	}
	
	public Entry<Integer, Integer> getMaxEntry(Map<Integer, Integer> map){        
	    Entry<Integer, Integer> maxEntry = null;
	    Integer max = Collections.max(map.values());

	    for(Entry<Integer, Integer> entry : map.entrySet()) {
	        Integer value = entry.getValue();
	        if(null != value && max == value) {
	            maxEntry = entry;
	        }
	    }
	    return maxEntry;
	}
	
	private int roundPointsBiggest(ArrayList<Integer> round) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i < 7; i++) {
			map.put(i, Collections.frequency(round, i)*i);
		}

		return getMaxEntry(map).getValue();
	}
	
	private Integer roundPoints(ArrayList<Integer> round, Integer value) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i < 7; i++) {
			map.put(i, Collections.frequency(round, i));
		}

		return map.get(value)*value;
	}
		
	private Integer valueFromMap(int i) {
		//ArrayList<Integer> list = new ArrayList<Integer>();
		return game.get(player1).get(i);
	}
	
	private ArrayList<Integer> randomGenerator(String player) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random generator = new Random();
		
		for(int i=0; i<5; i++) {
			if (savedP1.get(i) && player.equals(player1)) {
				list.add(valueFromMap(i));
			} else {
				list.add(generator.nextInt(6) + 1);
			}
		}

		return list;
	}

	private void showMap() {
		System.out.println(game);
	}
	
	private void newGame() {
		resultP1 = 0;
		resultP2 = 0;
		round = 0;
	}
    
//	public static void main(String[] args) {
//		new YahtzeeGame(1);
//	}

}


