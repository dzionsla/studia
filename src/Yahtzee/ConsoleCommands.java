package Yahtzee;

public class ConsoleCommands {
	int actualPage = 0;
	
	void clearWindow(){
		for(int clear = 0; clear < 12; clear++) {
		    System.out.println("\n") ;
		}
	}
	
	void showMainMenu() {
		clearWindow();
		actualPage = 0;
		System.out.println("1. Start The Game !.\n"
				+ "2. Rules.\n"
				+ "0. Main Menu\n"
				+ "q. Quit.");
	}
	void showMainMenuV1() {
		actualPage = 0;
		System.out.println("\n1. Start The Game !.\n"
				+ "2. Rules.\n"
				+ "0. Main Menu\n"
				+ "q. Quit.");
	}
	
	void showGame() {
		clearWindow();
		actualPage = 1;
		System.out.println("11. Game GAME Game.");
	}
	
	void showRules() {
		clearWindow();
		actualPage = 2;
		System.out.println("Rules BLA BLA BLA");
	}
}
