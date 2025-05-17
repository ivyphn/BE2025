package dto;

public class Product {
    public String name;
    public int price;

    // Default constructor
    public Product() {
    }

    // Constructor to initialize fields
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
