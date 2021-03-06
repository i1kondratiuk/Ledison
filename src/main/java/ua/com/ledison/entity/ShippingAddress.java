package ua.com.ledison.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = -2301841381687322121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shippingAddressId;
	@NotBlank(message = "The street name must not be blank")
	private String streetName;
	@NotBlank(message = "The apartment number must not be blank")
	private String apartmentNumber;
	@NotBlank(message = "The city name must not be blank")
	private String city;
	@NotBlank(message = "The state name must not be blank")
	private String state;
	@NotBlank(message = "The country name must not be blank")
	private String country;

	@OneToOne
	private User user;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ShippingAddress{" +
				"streetName='" + streetName + '\'' +
				", apartmentNumber='" + apartmentNumber + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}