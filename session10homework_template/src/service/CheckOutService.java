package service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import dto.Cart;
import dto.CartItem;
import dto.Customer;
import dto.Rank;
import session10homework_template.Storage;

public class CheckOutService {

    private static final DecimalFormat df = new DecimalFormat("#0.00");
    
    // Standard for shop 2
    public double checkOut(Cart cart, Customer customer) {
        List<CartItem> items = cart.items;
        
        // If Cart is blank

        if (items == null || items.isEmpty()) {
            System.out.println("Your cart is empty. Please add items to the cart before checking out.");
            return 0;
        }
        
        // Summarise item list
        System.out.println("----- Checkout Summary -----");
        for (CartItem item : items) {
            double itemTotal = item.price * item.quantity;
            System.out.println(item.name + " x " + item.quantity + " = $" + df.format(itemTotal));
        }
        
        double total = calculateFinalFee(cart, customer);
      
        // Clear cart after checkout
        cart.items.clear();
        return total;
    }
    
    public static double calculateFinalFee(Cart cart, Customer customer) {
    	DecimalFormat df = new DecimalFormat("#.##");
    	Rank rank = customer.rank; 
        double shippingFee = 5.0; 
          
        if (rank != Rank.NONE) {
            shippingFee *= 0.5; 
        }
          
        double discountRate = 0;
        if (rank == Rank.GOLD) {
            discountRate = 0.02; 
        } else if (rank == Rank.DIAMOND) {
              discountRate = 0.03; 
        }

        double total = 0.0;
        for (CartItem item : cart.items) {
            total += item.price * item.quantity; 
        }

        double discount = total * discountRate;
        total = total - discount + shippingFee;
        
        System.out.println("Subtotal: $" + df.format(total + discount - shippingFee));
        System.out.println("Discount: -$" + df.format(discount));
        System.out.println("Shipping Fee: $" + df.format(shippingFee));
        System.out.println("Total Amount: $" + df.format(total));

        return total;
    }
    
    // Shop 1 
    
    public static void sendCheckOutEmail(double total) {
 
        String receiver = "admin@example.com";  
        String subject = "Checkout Confirmation";
        String body = "Your total checkout amount is: $" + total;

        EmailService.sendEmail(receiver, subject, body);
    }

    
    public static void checkoutShop1(Cart cart, Customer customer) {
        double total = calculateFinalFee(cart, customer);
        sendCheckOutEmail(total); 
    }
    
    // Shop 3
    
    public static void checkoutShop3(Cart cart, Customer customer) {
        double total = calculateFinalFee(cart, customer);
        logCheckoutToFile(customer.id, total);
    }
    
    private static void logCheckoutToFile(String userId, double total) {
        try {
        	
        	String logFilePath = Storage.LOG_FILE_PATH; 
            FileWriter writer = new FileWriter(logFilePath, true);
            
            writer.write("User: " + userId + " checked out. Total: $" + total + " at " + java.time.LocalDateTime.now() + "\n");
            writer.close();
            System.out.println("Checkout details logged for user: " + userId);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
    
   
}




