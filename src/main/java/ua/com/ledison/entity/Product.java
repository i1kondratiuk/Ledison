package ua.com.ledison.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotEmpty(message = "The product name must not be empty")
    private String productName;

    @NotEmpty(message = "The product brand name must not be empty")
    private String productBrand;

    @Min(value = 0, message = "The product price must not be less then zero")
    private double productPrice;

    @NotEmpty(message = "The cap type must not be empty")
    private String capType;

    @NotEmpty(message = "The color of glow must not be empty")
    private String glowColor;

    @NotEmpty(message = "The lamp shape must not be empty")
    private String lampShape;

    @NotEmpty(message = "The power must not be empty")
    private int power;

    @NotEmpty(message = "The operating voltage name must not be empty")
    private int operatingVoltage;

    @NotEmpty(message = "The diffuser type must not be empty")
    private String diffuserType;

    @NotEmpty(message = "The service life must not be empty")
    private int serviceLife;

    @NotEmpty(message = "The warranty period must not be empty")
    private int warrantyPeriod;

    @Min(value = 0, message = "The product unit must not be less then zero")
    private int unitInStock;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

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

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
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

	public int getOperatingVoltage() {
		return operatingVoltage;
	}

	public void setOperatingVoltage(int operatingVoltage) {
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

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productBrand='" + productBrand + '\'' +
				", productPrice=" + productPrice +
				", capType='" + capType + '\'' +
				", glowColor='" + glowColor + '\'' +
				", lampShape='" + lampShape + '\'' +
				", power=" + power +
				", operatingVoltage=" + operatingVoltage +
				", diffuserType='" + diffuserType + '\'' +
				", serviceLife=" + serviceLife +
				", warrantyPeriod=" + warrantyPeriod +
				", unitInStock=" + unitInStock +
				", productImage=" + productImage +
				", cartItemList=" + cartItemList +
				'}';
	}
}
