package dto;

public class CartItem extends Product {

    public int quantity;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        super(product.name, product.price);
        this.quantity = quantity;
    }
}
