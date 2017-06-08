package ua.com.ledison.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SoldUnit implements Serializable {

	private static final long serialVersionUID = 7786224828586235224L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int soldUnitId;

	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;

	private int quantity;

	private double totalPrice;

	public SoldUnit() {
	}

	public SoldUnit(Product product, int quantity, double totalPrice) {
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getSoldUnitId() {
		return soldUnitId;
	}

	public void setSoldUnitId(int soldUnitId) {
		this.soldUnitId = soldUnitId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
		return "SoldUnit{" +
				"soldUnitId=" + soldUnitId +
				", product=" + product +
				", quantity=" + quantity +
				", totalPrice=" + totalPrice +
				'}';
	}
}
