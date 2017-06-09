package ua.com.ledison.util;

public class Math {

	public static double roundDoubleValue(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) java.lang.Math.pow(10, places);
		value = value * factor;
		long tmp = java.lang.Math.round(value);
		return (double) tmp / factor;
	}

}
