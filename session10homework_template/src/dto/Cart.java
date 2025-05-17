package dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<CartItem> items; 

    public Cart() {
        this.items = new ArrayList<>(); 
    }
}
