package ua.com.ledison.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 5264396247343708823L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItems;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	private double grandTotal;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return 	"cartItems=" + cartItems +
				"&user=" + user +
				"&grandTotal=" + grandTotal
				;
	}
}