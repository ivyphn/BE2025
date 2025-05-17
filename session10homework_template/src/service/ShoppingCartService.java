package service;

import dto.Cart;
import dto.CartItem;
import dto.Product;

public class ShoppingCartService {

	public void addToCart(Cart cart, Product product, int quantity) {
		CartItem item = findProduct(cart, product);

		if (item != null) {
			item.quantity += quantity;
		} else {
			cart.items.add(new CartItem(product, quantity));
		}
	}

	private CartItem findProduct(Cart cart, Product product) {
		for (CartItem item : cart.items) {
			if (item.name.equals(product.name)) {
				return item;
			}
		}
		return null;
	}

	public void showCart(Cart cart) {
		if (cart.items.size() == 0) {
			System.out.println("Your cart is empty");
			return;
		}
		for (CartItem i : cart.items) {
			System.out.println(i.name + " = " + i.price + ". quantity = " + i.quantity);
		}
	}
}

