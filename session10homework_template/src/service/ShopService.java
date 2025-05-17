package service;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

import dto.Shop;
import session10homework_template.Storage;

import java.util.ArrayList; 

public class ShopService {
	
	public ArrayList<Shop> getAllShops() {
		try {
			File file = new File(Storage.SHOP_FILE_PATH);
			Scanner myReader = new Scanner(file); 
			ArrayList<Shop> list = new ArrayList<>(); 
			myReader.nextLine(); 
			
			while (myReader.hasNextLine()) {
				String row = myReader.nextLine(); 
				Shop s = readRow(row);
				list.add(s);
			}
			myReader.close(); 
			return list; 
		} catch (FileNotFoundException e) {
			System.out.print("An error occured");
			e.printStackTrace();
		}
		
		return null; 
	}
	
	
private Shop readRow(String line) {
	Scanner rowScanner = new Scanner(line); 
	rowScanner.useDelimiter(","); 
	String id = rowScanner.next().trim(); 
	String name = rowScanner.next().trim(); 
	String dbPath = rowScanner.next().trim(); 
	rowScanner.close(); 
	return new Shop(Integer.parseInt(id), name, dbPath); 
	} 
}
