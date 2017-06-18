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

	private List<CartItemDTO> cartItemsDTO;

	private double grandTotal;

	public static void setInstance(CartDTO instance) {
		CartDTO.instance = instance;
	}

	public List<CartItemDTO> getCartItemsDTO() {
		return cartItemsDTO;
	}

	public void setCartItemsDTO(List<CartItemDTO> cartItemsDTO) {
		this.cartItemsDTO = cartItemsDTO;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return 	cartItemsDTO.toString();
	}
}