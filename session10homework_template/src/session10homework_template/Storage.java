package session10homework_template;

import dto.Shop;

public class Storage {
	
	public static Shop currentShop = null;
	
	public static final String SHOP_FILE_PATH = "src/db/shop/shop.txt"; 
	
	public static final String CUSTOMER_FILE_PATH = "src/db/"; 
	
	public static final String PRODUCT_FILE_PATH = "src/db/"; 
	
	public static final String LOG_FILE_PATH = "src/log/checkout_log.txt"; 
	
	// Email
	
	public static final String SMTP_HOST = "localhost";
	
	public static final int SMTP_PORT = 2525;
	    
	public static final String SENDER_EMAIL = Storage.SENDER_EMAIL;
	 
	public static final String SENDER_PASSWORD = Storage.SENDER_PASSWORD;  
	
}