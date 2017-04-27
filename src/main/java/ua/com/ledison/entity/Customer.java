package ua.com.ledison.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -1514573522236596110L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@NotEmpty(message = "The customer name must not be null")
	private String customerName;

	@NotEmpty(message = "The customer surname must not be null")
	private String customerSurname;

	@NotEmpty(message = "The customer email must not be null")
	private String customerEmail;

	@NotEmpty(message = "The customer phone must not be null")
	private String customerPhone;

	private boolean enabled = true;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	public Customer() {
	}

	public Customer(String customerName, String customerSurname, String customerEmail, String customerPhone) {
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	public int getCutomerId() {
		return customerId;
	}

	public void setCutomerId(int cutomerId) {
		this.customerId = cutomerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}