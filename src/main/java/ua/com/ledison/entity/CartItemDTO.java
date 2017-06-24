package ua.com.ledison.entity;

public class CartItemDTO {

	private int cartItemId;
	private int productId;
	private Product product;
	private Cart cart;
	private int quantity;
	private double totalPrice;

	public CartItemDTO() {
	}

	public CartItemDTO(int productId, int quantity, double totalPrice) {
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public CartItem convertCartItemDTOToCartItem() {
		CartItem cartItem = new CartItem();
		cartItem.setProduct(this.getProduct());
		cartItem.setCart(this.getCart());
		cartItem.setQuantity(this.getQuantity());
		cartItem.setTotalPrice(this.getTotalPrice());
		return cartItem;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getProductId() {
		return productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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
				"+quantity=" + quantity +
				"+totalPrice=" + totalPrice
				;
	}
}