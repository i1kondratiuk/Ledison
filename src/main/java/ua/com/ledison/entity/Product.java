package ua.com.ledison.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -5593112655583906933L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@NotBlank(message = "The product name must not be empty")
	private String productName;

	@NotBlank(message = "The product category name must not be empty")
	private String productCategory;

	@ManyToOne
	@JoinColumn(name = "productManufacturerId")
	@JsonIgnore
	private ProductManufacturer productManufacturer;

	@Min(value = 0, message = "The product price must not be less then zero")
	private double productPrice;

	private String capType;

	private String glowColor;

	private String lampShape;

	@Min(value = 0, message = "The power must not be less then zero")
	@Max(value = 200, message = "The power must not be more then 200")
	private int power;

	private String operatingVoltage;

	private String diffuserType;

	@Min(value = 0, message = "The service period must not be less then zero")
	private int serviceLife;

	@Min(value = 0, message = "The warranty period must not be less then zero")
	private int warrantyPeriod;

	@Min(value = 0, message = "The product unit must not be less then zero")
	private int unitInStock;

	@Transient
	private MultipartFile productImage;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItemList;

	private long productViewCounter;

	public void fetchLazyCollection() {
		if (this.cartItemList != null) {
			getCartItemList().size();
		}
	}

	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public ProductManufacturer getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(ProductManufacturer productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCapType() {
		return capType;
	}

	public void setCapType(String capType) {
		this.capType = capType;
	}

	public String getGlowColor() {
		return glowColor;
	}

	public void setGlowColor(String glowColor) {
		this.glowColor = glowColor;
	}

	public String getLampShape() {
		return lampShape;
	}

	public void setLampShape(String lampShape) {
		this.lampShape = lampShape;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getOperatingVoltage() {
		return operatingVoltage;
	}

	public void setOperatingVoltage(String operatingVoltage) {
		this.operatingVoltage = operatingVoltage;
	}

	public String getDiffuserType() {
		return diffuserType;
	}

	public void setDiffuserType(String diffuserType) {
		this.diffuserType = diffuserType;
	}

	public int getServiceLife() {
		return serviceLife;
	}

	public void setServiceLife(int serviceLife) {
		this.serviceLife = serviceLife;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public long getProductViewCounter() {
		return productViewCounter;
	}

	public void setProductViewCounter(long productViewCounter) {
		this.productViewCounter = productViewCounter;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productCategory='" + productCategory + '\'' +
				", productManufacturer=" + productManufacturer +
				", productPrice=" + productPrice +
				", capType='" + capType + '\'' +
				", glowColor='" + glowColor + '\'' +
				", lampShape='" + lampShape + '\'' +
				", power=" + power +
				", operatingVoltage='" + operatingVoltage + '\'' +
				", diffuserType='" + diffuserType + '\'' +
				", serviceLife=" + serviceLife +
				", warrantyPeriod=" + warrantyPeriod +
				", unitInStock=" + unitInStock +
				", productImage=" + productImage +
				", cartItemList=" + cartItemList +
				", productViewCounter=" + productViewCounter +
				'}';
	}
}