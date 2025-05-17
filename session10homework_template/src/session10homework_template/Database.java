package session10homework_template;

import java.util.*;

import dto.Customer;
import dto.Product;
import dto.Rank;

public class Database {
 
    public static final Map<String, List<Customer>> SHOP_CUSTOMERS = new HashMap<>();
    public static final Map<String, List<Product>> SHOP_PRODUCTS = new HashMap<>();

    static {
        SHOP_CUSTOMERS.put("shop1", Arrays.asList(
            new Customer("1", "1", Rank.GOLD),
            new Customer("2", "2", Rank.SILVER)
        ));
        SHOP_PRODUCTS.put("shop1", Arrays.asList(
            new Product("Coffee", 5),
            new Product("Milk", 3)
        ));

        SHOP_CUSTOMERS.put("shop2", Arrays.asList(
            new Customer("3", "3", Rank.DIAMOND),
            new Customer("4", "4", Rank.NONE)
        ));
        SHOP_PRODUCTS.put("shop2", Arrays.asList(
            new Product("Tea", 4),
            new Product("Juice", 6)
        ));
    }
}
