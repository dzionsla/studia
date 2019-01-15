package Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class CalendarFunctions {
	static HashMap<String, String> cal = new HashMap<String, String>();
	static Calendar date = new GregorianCalendar();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	int maxDaysInMonth = 31;
	
	public CalendarFunctions(){
		addEvent(2018, 12, 30 , "Todays event!");
		addEvent(2018, 12, 1 , "Random event 1!");
		addEvent(2018, 12, 23 , "Random event 2!");
//		date.set(Calendar.YEAR, 1989);
//		date.set(Calendar.MONTH, 0);
//		date.set(Calendar.DAY_OF_MONTH, 31);
		addEvent(1989, 1, 31, "My birthday!");
	}
	
	public String getDate(Calendar date) {
		return dateFormat.format(date.getTime());
	}
	
	public void addEvent(int year, int month, int day, String event) {
		String date = createStringDate(year, month, day);
		
		if (cal.containsKey(date)) {
			cal.put(date, cal.get(date) + "\n" + event);
		}
		else {
			cal.put(date, event);
		}
	}
	
	public void deleteEvent(int year, int month, int day) {
		String date = createStringDate(year, month, day);
		
		if (cal.containsKey(date)) {
			cal.remove(date);
		}
		else {
			System.out.println("There are no events in this date");
		}
	}
	
	public void showAllEvents() {
		for(String key : cal.keySet()) {
		    String value = cal.get(key);
		    System.out.println(key + ": \n" + value);
		}
	}
	
	public void showMonthEvents(int year, int month) {
		Calendar localDate = new GregorianCalendar(year, month - 1, 1);
		
		for (int i = 1; i <= maxDaysInMonth; i++) {
			localDate.set(Calendar.DAY_OF_MONTH, i);
			if (cal.containsKey(getDate(localDate))) {
				String value = cal.get(getDate(localDate));
		    	System.out.println(getDate(localDate) + ": \n" + value);
			}
		}
	}
	
//	public void showEvent(String date) {
//		if (cal.containsKey(date)) {
//			String value = cal.get(date);
//	    	System.out.println(date + ": \n" + value);
//		} else {
//			System.out.println(date + ": \nnot exists");
//		}
//	}
	
	public void showEvent(int year, int month, int day) {
		String date = createStringDate(year, month, day);
		if (cal.containsKey(date)) {
			String value = cal.get(date);
	    	System.out.println(date + ": \n" + value);
		} else {
			System.out.println(date + ": \nnot exists");
		}
	}
	
	public String createStringDate(int year, int month, int day) {
		return getDate(new GregorianCalendar(year,month-1,day));
	}
	
	
}
