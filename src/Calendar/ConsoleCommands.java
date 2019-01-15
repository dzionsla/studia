package Calendar;

import java.util.Scanner;

public class ConsoleCommands {
	static Scanner read = new Scanner(System.in);
	CalendarFunctions cal = new CalendarFunctions();
	int actualPage = 0;
	
	void clearWindow(){
		for(int clear = 0; clear < 12; clear++) {
		    System.out.println("\n") ;
		}
	}
	
	void showMainMenu() {
		clearWindow();
		actualPage = 0;
		System.out.println("1. Add event.\n"
				+ "2. Delete event.\n"
				+ "3. Show specific event.\n"
				+ "4. Show month event.\n"
				+ "5. Show all events.\n"
				+ "0. Main Menu\n"
				+ "q. Quit.");
	}
	
	void addEvent() {
		int year, month, day;
		String info;
		
		System.out.println("You want to create new event. Follow instruction:");
		System.out.println("What year?");
		year = Integer.parseInt(read.nextLine());
		System.out.println("What month?");
		month = Integer.parseInt(read.nextLine());
		System.out.println("What day?");
		day = Integer.parseInt(read.nextLine());
		System.out.println("What event?");
		info = read.nextLine();
		
		cal.addEvent(year, month, day, info);
	}
	
	void deleteEvent() {
		int year, month, day;
		
		System.out.println("You want to delete event. Follow instruction:");
		System.out.println("What year?");
		year = Integer.parseInt(read.nextLine());
		System.out.println("What month?");
		month = Integer.parseInt(read.nextLine());
		System.out.println("What day?");
		day = Integer.parseInt(read.nextLine());

		cal.deleteEvent(year, month, day);
	}
	
	void showSpecyficEvent() {
		int year, month, day;
		
		System.out.println("You want to show event. Follow instruction:");
		System.out.println("What year?");
		year = Integer.parseInt(read.nextLine());
		System.out.println("What month?");
		month = Integer.parseInt(read.nextLine());
		System.out.println("What day?");
		day = Integer.parseInt(read.nextLine());
		
		cal.showEvent(year, month, day);
	}
	
	void showMonthEvents() {
		int year, month;
		
		System.out.println("You want to show specific month events. Follow instruction:");
		System.out.println("What year?");
		year = Integer.parseInt(read.nextLine());
		System.out.println("What month?");
		month = Integer.parseInt(read.nextLine());
		
		cal.showMonthEvents(year, month);
	}
	
	void showAllEvents() {
		cal.showAllEvents();
	}
}
