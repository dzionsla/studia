package Yahtzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class YahtzeeV3 {
	static String player1 = "1st Player";
	static String player2 = "2nd Player";
	static Integer resultP1 = 0;
	static Integer resultP2 = 0;
	static Integer resultP1Round = 0;
	static Integer resultP2Round = 0;
	static int roundP1 = 0;
	static int roundP2 = 0;
	static int roundP1Main = 1;
	static int roundP2Main = 1;
	static int rounds = 3;
	static int roundsGame = 6;
	Map<String, ArrayList<Integer>> game = new HashMap<String, ArrayList<Integer>>();
	ArrayList<Boolean> savedP1 = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false));
	ArrayList<Boolean> savedP2 = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false));
	ArrayList<Integer> valuesP1 = new ArrayList<Integer>(Arrays.asList(null,null,null,null,null,null));
	ArrayList<Integer> valuesP2 = new ArrayList<Integer>(Arrays.asList(null,null,null,null,null,null));
	static Scanner read = new Scanner(System.in);
	
	public YahtzeeV3() {
		newGame();
		for (int i = 1; i <= roundsGame; i++) {
			sequenceV1(player1);
			sequenceV1(player2);
		}
		whoWon();
	}
	
	private void sequenceV1(String player) {
		if (player.equals(player1)) {
			for (int i = 1; i <= rounds; i++) {
				if (roundP1 == 0) {
					System.out.println(player1 + " starting now!");
				}
				roundP1++;
				game.put(player1, randomGenerator(player1));
				System.out.println("Round " + roundP1);
				showMap(player1);
				whichToSave(player1);
				if (roundP1 == 3) {
					countPoints(player1);
					roundP1Main++;
					roundP1 = 0;
					clearArray(player1);
				}
			}
		} else {
			for (int i = 1; i <= rounds; i++) {
				if (roundP2 == 0) {
					System.out.println(player2 + " starting now!");
				}
				roundP2++;
				game.put(player2, randomGenerator(player2));
				System.out.println("Round " + roundP2);
				showMap(player2);
				whichToSave(player2);
				if (roundP2 == 3) {
					countPoints(player2);
					roundP2Main++;
					roundP2 = 0;
					clearArray(player2);
				}
			}
		}
	}
	
	private void saveRoundValue(String player) {
		if (player.equals(player1)) {
			valuesP1.set(resultP1Round - 1, resultP1Round);
			System.out.println(valuesP1);
		} else {
			valuesP2.set(resultP2Round - 1, resultP2Round);
			System.out.println(valuesP2);
		}
	}
	
	private void countPoints(String player) {
		if (player.equals(player1)) {
			for (int i = 0; i < savedP1.size(); i++) {
				if (savedP1.get(i)) {
					resultP1 += valueFromMap(i, player1);
				}
			}
			saveRoundValue(player1);
			System.out.println(player1 + ": " + resultP1 + " points\n");
		} else {
			for (int i = 0; i < savedP2.size(); i++) {
				if (savedP2.get(i)) {
					resultP2 += valueFromMap(i, player2);
				}
			}
			saveRoundValue(player2);
			System.out.println("\n" + player1 + ": " + resultP1 + " points");
			System.out.println("Choosed values " + valuesP1);
			System.out.println(player2 + ": " + resultP2 + " points");
			System.out.println("Choosed values " + valuesP2 + "\n");
			
		}
	}
	
	private int toSave(int a, String player) {
		
		for (int i = 0; i < 5; i++) {
			if (game.get(player).get(a-1).equals(game.get(player).get(i)))  {
				if (player.equals(player1)) {
					savedP1.set(i, true);
					resultP1Round = game.get(player).get(a-1);
				} else {
					savedP2.set(i, true);
					resultP2Round = game.get(player).get(a-1);
				}
			}
		}
		
		return game.get(player).get(a-1);
	}
	
	private void whichToSave(String player) {
		System.out.println("Choose which index should be saved or (r)eset and then (n)ext for " + player);
		
		outerloop:
		while (true) {
			String input = read.nextLine();
			switch (input) {
			case "1":
				toSave(1,player);
				break;
			case "2":
				toSave(2,player);
				break;
			case "3":
				toSave(3,player);
				break;
			case "4":
				toSave(4,player);
				break;
			case "5":
				toSave(5,player);
				break;
			case "6":
				toSave(6,player);
				break;
			case "n":
				break outerloop;
			case "r":
				if (player.equals(player1)) {
					reset(savedP1);
				}
				else {
					reset(savedP2);
				}
				System.out.println("Reseted!! Choose wisely!");
				break;
			default:		
				System.out.println("No such an option. Try again!"); 
				break;
			}
		}
	}

	private ArrayList<Integer> randomGenerator(String player) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random generator = new Random();
		
		for(int i=0; i<5; i++) {
			if (savedP1.get(i) && player.equals(player1)) {
				list.add(valueFromMap(i, player1));
			} else if (savedP2.get(i) && player.equals(player2)) {
				list.add(valueFromMap(i, player2));
			} else {
				list.add(generator.nextInt(6) + 1);
			}
		}
		return list;
	}
	
	private Integer valueFromMap(int i, String player) {
		return game.get(player).get(i);
	}
	
	private void clearArray(String player) {
		if (player.equals(player1)) {
			for (int i = 0; i < savedP1.size(); i++) {
				savedP1.set(i, false);
			}
		} else {
			for (int i = 0; i < savedP2.size(); i++) {
				savedP2.set(i, false);
			}
		}
	}
	
	private void showMap(String player) {
		System.out.println(game.get(player));
	}
	
	private void reset(ArrayList<Boolean> list) {
		for (int i = 0; i < 5; i++) {
			list.set(i, false);
		}
	}
	
	private void newGame() {
		resultP1 = 0;
		resultP2 = 0;
		reset(savedP1);
		reset(savedP2);
	}

	private void whoWon() {
		System.out.println(player1 + " have " + resultP1 + " points");
		System.out.println(player2 + " have " + resultP2 + " points\n");
		if (resultP1 > resultP2) {
			System.out.println(player1 + " WON\n");
		} else if (resultP1 < resultP2) {
			System.out.println(player2 + " WON\n");
		} else {
			System.out.println("We have tight\n");
		}	
	}
}