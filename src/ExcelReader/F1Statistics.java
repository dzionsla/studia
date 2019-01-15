package ExcelReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class F1Statistics {
	Workbook wb;
	Sheet sheet;
	Row row;
	Cell cell;
	HashSet<String> set = new HashSet<String>();
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	ArrayList<String> columnName = new ArrayList<String>();
	
	public F1Statistics(String name) {
		//createExcel(name);
		//writeCell(1, 2, 123);
		//System.out.println(readCell(0, 1, 1));
		//closeExcel(name);

		//zad1(name);
		//zad2(name, "Lewis Hamilton HAM");
		//zad2(name, "Daniel Ricciardo RIC");
		//zad2(name, "Sebastian Vettel VET");
//		zad3(name, "Ferrari");
//		zad3(name, "Mercedes");
		//zad4(name);
		zad5(name);
		
	}
	
	public void zad1(String name) {
		openExcel(name);
		//System.out.println(readCell(0, 0, 2));
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			set.add(readCell(i, 0, 2));
		}
		System.out.println(set);
	}
	
	public void zad2(String dir, String player) {
		int points = 0;
		
		openExcel(dir);
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			for (int j = 0; j < 20; j++) {
				if (readCell(i, j, 2).equals(player)) {
					points += Integer.parseInt(readCell(i, j, 5));
				}
			}
		}
		System.out.println(player + " zdobyl: " + points);
	}
	
	public void zad3(String dir, String mark) {
		int points = 0;
		
		openExcel(dir);
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			for (int j = 0; j < 20; j++) {
				if (readCell(i, j, 3).equals(mark)) {
					points += Integer.parseInt(readCell(i, j, 5));
				}
			}
		}
		System.out.println(mark + " zdobylo: " + points);
	}
	
	public void zad4(String dir) {	
		HashMap<String, Integer> localMap = new HashMap<String, Integer>();
		openExcel(dir);
		int i = 0;
		int j = 0;

		for (i = 0; i < wb.getNumberOfSheets(); i++) {
			for (j = 0; j < 20; j++) {
				if (localMap.containsKey(readCell(i, j, 2))) {
					localMap.put(readCell(i, j, 2), localMap.get(readCell(i, j, 2)) + Integer.parseInt(readCell(i, j, 5)));
				} else {
					localMap.put(readCell(i, j, 2), Integer.parseInt(readCell(i, j, 5)));
				}
				//map.put(readCell(i, j, 2), map.get(readCell(i, j, 2)) + Integer.parseInt(readCell(i, j, 5)));
			}
		}
		Map<String, Integer> sortedMapAsc = sortByValue(localMap, false);
		//printMap(localMap);
		System.out.println();
		printMap(sortedMapAsc);
		//System.out.println(localMap);
		
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    }

    private static void printMap(Map<String, Integer> map)
    {
//    	int ctr = 0;
//    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
//    		ctr++;
//    	    System.out.println(ctr + ". " + entry.getKey() + " = " + entry.getValue());
//    	}
    	int ctr = 0;
    	for (String key : map.keySet()) {
    		ctr++;
    	    Integer value = map.get(key);
    	    System.out.println(ctr + ". " + key + " = " + value);
    	}
    }
	
	public void zad5(String name) {
		HashMap<String, ArrayList<Integer>> localMap = new HashMap<String, ArrayList<Integer>>();
		openExcel(name);
		int i = 0;
		int j = 0;

		for (i = 0; i < wb.getNumberOfSheets(); i++) {
			for (j = 0; j < 20; j++) {
				if (localMap.containsKey(readCell(i, j, 2))) {
					localMap.put(readCell(i, j, 2),  addPoints(localMap.get(readCell(i, j, 2)), newPoints(i, j, localMap)));
				} else {
					localMap.put(readCell(i, j, 2), addPoints( new ArrayList<Integer>(), Integer.parseInt(readCell(i, j, 5))));
					//System.out.println(i + " " + j);
				}
			}
		}
		//printMap2(localMap);
		for (i = 0; i < wb.getNumberOfSheets(); i++) {
			columnName.add(wb.getSheetName(i));
			//System.out.println(wb.getSheetName(i));
		}
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		createExcel("Results_" + name);
		row = sheet.createRow(0);
		for (int z = 0; z <  columnName.size(); z++) {
			writeCellString(0, z+1, columnName.get(z));
		}
//		System.out.println(localMap.keySet().size());
//		System.out.println(columnName.size());		
		for (int z = 0; z <  localMap.keySet().size(); z++) {
			row = sheet.createRow(z+1);
			writeCellString(z+1, 0, readKey(z, localMap));
		}
		
		for (int k = 0; k < localMap.keySet().size(); k++) {
			//System.out.println( localMap.get(readKey(k, localMap)) );
			int p=0;
			for (Integer value : localMap.get(readKey(k, localMap))) {
				//System.out.println( localMap.get(readKey(k, localMap)).get(p) );
				writeCellInt(k+1, p+1, localMap.get(readKey(k, localMap)).get(p) );
				p++;
			}
		}
		closeExcel("Results_" + name);
	}
		
	private Integer newPoints(int i, int j, HashMap<String, ArrayList<Integer>> map) {
		return map.get(readCell(i, j, 2)).get(map.get(readCell(i, j, 2)).size()-1) + Integer.parseInt(readCell(i, j, 5));
	}
	
	private static ArrayList<Integer> addPoints(ArrayList<Integer> list, Integer points) {
		//ArrayList<Integer> list = new ArrayList<>();
		list.add(points);
		
		return list;
	}
	
	private static void printMap2(Map<String, ArrayList<Integer>> map)
    {
//    	int ctr = 0;
//    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
//    		ctr++;
//    	    System.out.println(ctr + ". " + entry.getKey() + " = " + entry.getValue());
//    	}
    	int ctr = 0;
    	for (String key : map.keySet()) {
    		ctr++;
    	    System.out.println(key + " = " + map.get(key));
    	}
    }

	private String readKey(int i, HashMap<String, ArrayList<Integer>> map) {
		return (String) map.keySet().toArray()[i];
	}
	
	public void createExcel(String name) {
		wb = new XSSFWorkbook();
		createSheet("Results");
	}
	
	public void openExcel(String name) {
		try {
			wb = WorkbookFactory.create(new File(name));
		    } 
		catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createSheet(String name) {
		sheet = wb.createSheet(name);
	}
	
	public void writeCellInt(int rowNumber, int cellColumn, int cellValue) {
		row = sheet.getRow(rowNumber);
		cell = row.createCell(cellColumn);
		cell.setCellValue(cellValue);
	}
	
	public void writeCellString(int rowNumber, int cellColumn, String cellValue) {
		row = sheet.getRow(rowNumber);
		cell = row.createCell(cellColumn);
		cell.setCellValue(cellValue);
	}
	
	public String readCell(int sheetIndex, int rowNumber, int cellColumn) {
		sheet = wb.getSheetAt(sheetIndex);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(cellColumn);
		String stringValue = cell.getStringCellValue();
		
		return stringValue;
	}
	
	public String readSheetName(int i) {
		
		
		return null;
	}
	
	public void closeExcel(String name) {
		FileOutputStream fileOut;
		try {
		    fileOut = new FileOutputStream(name);
		    wb.write(fileOut);
		    fileOut.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
