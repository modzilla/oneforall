package xyz.ofa.physics;

public class Temperatures {

	private static final float FACTOR_KELVIN = 273.15f;
	private static final float FACTOR_FAHRENHEIT = (float) 9 / (float) 5;

	public static float celsiusToKelvin(float temp) {
		return temp + FACTOR_KELVIN;
	}
	public static float kelvinToCelsius(float temp) {
		return temp - FACTOR_KELVIN;
	}
	public static double celsiusToKelvin(double temp) {
		return temp + FACTOR_KELVIN;
	}
	public static double kelvinToCelsius(double temp) {
		return temp - FACTOR_KELVIN;
	}
	public static float fahrenheitToCelsius(float temp) {
		return (temp - 32f) / 1.8f;
	}
	public static double fahrenheitToCelsius(double temp) {
		return (temp - 32) / 1.8;
	}
	public static float celsiusToFahrenheit(float temp) {
		return (temp * FACTOR_FAHRENHEIT) + 32f;
	}
	public static double celsiusToFahrenheit(double temp) {
		return (temp * FACTOR_FAHRENHEIT) + 32;
	}
	public static float fahrenheitToKelvin(float temp) {
		return ((temp - 32f) / 1.8f) - FACTOR_KELVIN;
	}
	public static double fahrenheitToKelvin(double temp) {
		return ((temp - 32) / 1.8) - FACTOR_KELVIN;
	}
	public static float kelvinToFahrenheit(float temp) {
		return 1.8f * (temp - FACTOR_KELVIN) + 32f;
	}
	public static double kelvinToFahrenheit(double temp) {
		return 1.8 * (temp - FACTOR_KELVIN) + 32;
	}

}
