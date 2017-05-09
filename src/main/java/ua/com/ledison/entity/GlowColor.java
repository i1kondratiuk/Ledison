package ua.com.ledison.entity;

public enum GlowColor {
	NEUTRAL_WHITE("Neutral white"),
	COOL_WHITE("Cool white"),
	WARM_WHITE("Warm white");

	private String name;

	GlowColor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}