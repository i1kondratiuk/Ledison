package ua.com.ledison.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CapType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int capTypeId;

	@NotEmpty(message = "The cap type name must not be empty")
	private String capTypeName;

	public CapType() {
	}

	public CapType(String capTypeName) {
		this.capTypeName = capTypeName;
	}

	public int getCapTypeId() {
		return capTypeId;
	}

	public void setCapTypeId(int capTypeId) {
		this.capTypeId = capTypeId;
	}

	public String getCapTypeName() {
		return capTypeName;
	}

	public void setCapTypeName(String capTypeName) {
		this.capTypeName = capTypeName;
	}
}