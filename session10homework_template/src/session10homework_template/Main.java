package session10homework_template;

import java.util.*;

import dto.Cart;
import dto.CartItem;
import dto.Customer;
import dto.Product;
import dto.Shop;
import service.AuthenService;
import service.CheckOutService;
import service.ProductService;
import service.ShopService;
import service.ShoppingCartService;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Cart cart = new Cart();
    static AuthenService authenService = new AuthenService();
    static ShoppingCartService cartService = new ShoppingCartService();
    static CheckOutService checkoutService = new CheckOutService();

    static Shop selectedShop;
    static Customer customer; 
    
    static List<Product> currentProductList;

    static final int VIEW_CART_OPTION_ON_MENU = 1; 
    static final int ADD_PRODUCT_TO_CART = 2;
    static final int SHOW_CART = 3;
    static final int CHECK_OUT = 4;
    static final int EXIT = 0; 

    public static void main(String[] args) {
    	
    	selectedShop = selectShop();
    	

        boolean isLoggedin; 
       
        // Create an environment variable
      
        Storage.currentShop = selectedShop; 
    	
        // Log in
        do {
          	 isLoggedin = doLogin();
          } while (!isLoggedin);
        
        do {
        	showMenu(); 
        	
        	System.out.println("\n--- Options ---");
            System.out.println("1. View Cart");
            System.out.println("2. Add to Cart");
            System.out.println("3. Show cart");
            System.out.println("4. Checkout");
            System.out.println("0. Exit");
        	
        	System.out.println("Enter an option: ");
        	int option = scan.nextInt(); 
        	scan.nextLine(); 
        	
            switch(option) {
            case VIEW_CART_OPTION_ON_MENU:
                cartService.showCart(cart);
                break;
            case ADD_PRODUCT_TO_CART:
                doAddProductToCart();
                break;
            case SHOW_CART:
            	cartService.showCart(cart);;
                break;
            case CHECK_OUT:
                if (selectedShop.name.equals("Shop 1")) {
                	checkoutService.checkoutShop1(cart, customer); 
                }
                if (selectedShop.name.equals("Shop 3")) {
                	checkoutService.checkoutShop3(cart, customer); 
                }
                else {
                	checkoutService.checkOut(cart, customer); 
                }
                System.out.println("Checkout completed. Thank you for your purchase!");
                return;
            case EXIT:
                System.out.println("Exiting the program");
                return;
            default:
                System.out.println("Invalid option. Please select a valid option");
                break;
        }  
    }
        while (true);
    }
        
    
    private static Shop selectShop() {
    	ShopService shopService = new ShopService();
    	ArrayList<Shop> shops = shopService.getAllShops(); 
    			
    	System.out.println("----Shop----");
    	
    	for (int i = 0; i < shops.size(); i++) {
    		System.out.println((i + 1) + ". " + shops.get(i).name);
    	}
    	
    	System.out.println("------------");
        System.out.println("Select a shop: ");
        int option = scan.nextInt();
        scan.nextLine();
        
        return shops.get(option-1); 
    }

    private static boolean doLogin() {
        System.out.print("Enter ID: ");
        String userID = scan.nextLine();
        
        System.out.print("Enter Password: ");
        String userPassword = scan.nextLine();
        	
        boolean isLoggedin = false; 
        
        customer = authenService.login(userID, userPassword); 
        if (customer != null) {
        	cart = new Cart(); 
        	cart.items = new ArrayList<CartItem>(); 
        	isLoggedin = true; 
        }
        return isLoggedin;
    }

    private static void showMenu() {
    	ProductService productService = new ProductService(); 
    	currentProductList = productService.getProducts();
    	
        System.out.println("--- Menu ---");
        for (int i = 0; i <currentProductList.size(); i++) {
            System.out.println((i+1) + ". " +  currentProductList.get(i).name + " : " +  currentProductList.get(i).price);
        }
        System.out.println("-----------");
    }
    

    private static void doAddProductToCart() {
        showMenu();
        System.out.print("Choose product number: ");
        int index = Integer.parseInt(scan.nextLine()) - 1;
        if (index < 0 || index >= currentProductList.size()) {
            System.out.println("Invalid product.");
            return;
        }

        Product product = currentProductList.get(index);
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scan.nextLine());

        cartService.addToCart(cart, product, qty);
    }
    
}
