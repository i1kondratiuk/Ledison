package ua.com.ledison.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	private int warrantyPeriod;

	@OneToMany(mappedBy = "warrantyPeriod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();

	public WarrantyPeriod() {
	}

	public WarrantyPeriod(int warrantyPeriod, List<Product> products) {
		this.warrantyPeriod = warrantyPeriod;
		this.products = products;
	}

	public Integer getWarrantyPeriodId() {
		return warrantyPeriodId;
	}

	public void setWarrantyPeriodId(Integer warrantyPeriodId) {
		this.warrantyPeriodId = warrantyPeriodId;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
