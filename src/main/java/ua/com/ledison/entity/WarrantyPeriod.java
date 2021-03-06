package ua.com.ledison.entity;

import ua.com.ledison.validator.WarrantyPeriodAlreadyExists;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WarrantyPeriod implements Serializable {

	private static final long serialVersionUID = -6963336535227746590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer warrantyPeriodId;

	@Min(value = 0, message = "The warranty period must not be less then zero")
	@WarrantyPeriodAlreadyExists
	private Integer warrantyPeriod;

	@OneToMany(mappedBy = "warrantyPeriod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();

	public WarrantyPeriod() {
	}

	public WarrantyPeriod(Integer warrantyPeriod, List<Product> products) {
		this.warrantyPeriod = warrantyPeriod;
		this.products = products;
	}

	public Integer getWarrantyPeriodId() {
		return warrantyPeriodId;
	}

	public void setWarrantyPeriodId(Integer warrantyPeriodId) {
		this.warrantyPeriodId = warrantyPeriodId;
	}

	public Integer getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(Integer warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
