package ua.com.ledison.entity;

public enum LampShape {
	A60("A60"),
	A65("A65"),
	C37("C37"),
	C110("C110"),
	C120("C120"),
	C140("C140"),
	G45("G45"),
	G95("G95"),
	HW("HW"),
	R63("R63");

	private String name;

	LampShape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
