package service;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

import dto.Customer;
import dto.Rank;
import session10homework_template.Storage;

import java.util.ArrayList; 

public class CustomerService {
	
	public ArrayList<Customer> getCustomers() {
		try {
			File file = new File(Storage.CUSTOMER_FILE_PATH + Storage.currentShop.dbPath + "/customer.txt");
			Scanner myReader = new Scanner(file); 
			ArrayList<Customer> list = new ArrayList<>(); 
			myReader.nextLine(); 
			
			while (myReader.hasNextLine()) {
				String row = myReader.nextLine(); 
				Customer c = readRow(row);
				list.add(c);
			}
			myReader.close(); 
			return list; 
		} catch (FileNotFoundException e) {
			System.out.print("An error occured");
			e.printStackTrace();
		}
		
		return null; 
	}
	
	
	private Customer readRow(String line) {
	Scanner rowScanner = new Scanner(line); 
	rowScanner.useDelimiter(","); 
	String id = rowScanner.next().trim(); 
	String password = rowScanner.next().trim(); 
	String rankStr = rowScanner.next().trim(); 
	rowScanner.close(); 
	
    Rank rank = null;
    try {
        rank = Rank.valueOf(rankStr); 
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid rank: " + rankStr + ". Assigning default rank NONE.");
        rank = Rank.NONE; 
    }
    
	return new Customer(id, password, rank); 
	} 
}
