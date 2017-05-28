package ua.com.ledison.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Power implements Serializable {

	private static final long serialVersionUID = -5620537590058547740L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer powerId;

	@Min(value = 0, message = "The power must not be less then zero")
	@Max(value = 200, message = "The power must not be more then 200")
	private double power;

	@OneToMany(mappedBy = "power", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();

	public Power() {
	}

	public Power(double power, List<Product> products) {
		this.power = power;
		this.products = products;
	}

	public Integer getPowerId() {
		return powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
