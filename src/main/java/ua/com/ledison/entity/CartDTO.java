package ua.com.ledison.entity;

import java.util.List;

public class CartDTO {

	private static volatile CartDTO instance;

	public static CartDTO getInstance() {
		CartDTO localInstance = instance;
		if (localInstance == null) {
			synchronized (CartDTO.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new CartDTO();
				}
			}
		}
		return localInstance;
	}

	private List<CartItemDTO> cartItems;

	private double grandTotal;

	public static void setInstance(CartDTO instance) {
		CartDTO.instance = instance;
	}

	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return cartItems.toString();
	}
}