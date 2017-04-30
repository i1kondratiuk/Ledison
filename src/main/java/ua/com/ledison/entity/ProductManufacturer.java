package ua.com.ledison.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductManufacturer implements Serializable {

	private static final long serialVersionUID = 1226633730318408441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productManufacturerId;

	private String productManufacturerName;

	@OneToMany(mappedBy = "productManufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();

	public ProductManufacturer() {
	}

	public ProductManufacturer(String productManufacturerName, List<Product> products) {
		this.productManufacturerName = productManufacturerName;
		this.products = products;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getProductManufacturerId() {
		return productManufacturerId;
	}

	public void setProductManufacturerId(Integer productManufacturerId) {
		this.productManufacturerId = productManufacturerId;
	}

	public String getProductManufacturerName() {
		return productManufacturerName;
	}

	public void setProductManufacturerName(String productManufacturerName) {
		this.productManufacturerName = productManufacturerName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
