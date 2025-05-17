package service;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

import dto.Product;
import session10homework_template.Storage;

import java.util.ArrayList; 

public class ProductService {
	
	public ArrayList<Product> getProducts() {
		try {
			File file = new File(Storage.PRODUCT_FILE_PATH + Storage.currentShop.dbPath + "/product.txt");
			Scanner myReader = new Scanner(file); 
			ArrayList<Product> list = new ArrayList<>(); 
			myReader.nextLine(); 
			
			while (myReader.hasNextLine()) {
				String row = myReader.nextLine(); 
				Product p = readRow(row);
				list.add(p);
			}
			myReader.close(); 
			return list; 
		} catch (FileNotFoundException e) {
			System.out.print("An error occured");
			e.printStackTrace();
		}
		
		return null; 
	}
	
	
	private Product readRow(String line) {
	Scanner rowScanner = new Scanner(line); 
	rowScanner.useDelimiter(","); 
	String name = rowScanner.next().trim(); 
	String price = rowScanner.next().trim(); 
	rowScanner.close(); 
    
	return new Product(name, Integer.parseInt(price)); 
	} 
}
