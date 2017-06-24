package ua.com.ledison.entity;

import java.util.ArrayList;
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

	private int userId;

	private List<CartItemDTO> cartItems;

	private double grandTotal;

	public static void setInstance(CartDTO instance) {
		CartDTO.instance = instance;
	}

	public Cart convertCartDTOToCart() {
		Cart cart = new Cart();
		cart.setCartItems(this.convertCartItemsDTOToCartItems());
		cart.setGrandTotal(this.getGrandTotal());
		return cart;
	}

	private List<CartItem> convertCartItemsDTOToCartItems() {
		List<CartItem> cartItems = new ArrayList<>();
		for (CartItemDTO cartItemDTO : this.getCartItems()) {
			cartItems.add(cartItemDTO.convertCartItemDTOToCartItem());
		}

		return cartItems;
	}


	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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