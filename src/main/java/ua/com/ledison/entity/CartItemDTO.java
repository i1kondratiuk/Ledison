package ua.com.ledison.entity;

public class CartItemDTO {

	private int productId;
	private int quantity;
	private double totalPrice;

	public CartItemDTO() {
	}

	public CartItemDTO(int productId, int quantity, double totalPrice) {
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return 	"productId=" + productId +
				"quantity=" + quantity +
				"totalPrice=" + totalPrice
				;
	}
}