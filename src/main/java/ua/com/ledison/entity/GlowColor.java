package ua.com.ledison.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GlowColor implements Serializable {

	private static final long serialVersionUID = 7330872592308732889L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int glowColorId;

	@NotEmpty(message = "The glow color must not be empty")
	private String glowColorName;

	public GlowColor() {
	}

	public GlowColor(String glowColorName) {
		this.glowColorName = glowColorName;
	}

	public int getGlowColorId() {
		return glowColorId;
	}

	public void setGlowColorId(int glowColorId) {
		this.glowColorId = glowColorId;
	}

	public String getGlowColorName() {
		return glowColorName;
	}

	public void setGlowColorName(String glowColorName) {
		this.glowColorName = glowColorName;
	}
}
