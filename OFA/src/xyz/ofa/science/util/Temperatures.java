package xyz.ofa.science.util;

/**
 * 
 * @author Kenny Kropp
 * <b>A Temperature-Oriented Utility Class</b>
 *
 */
public class Temperatures {

	private static final float FACTOR_KELVIN = 273.15f;
	private static final float FACTOR_FAHRENHEIT = (float) 9 / (float) 5;

	/**
	 * °C to °K
	 * 
	 * @param temp
	 *            Temperature in °C
	 * @return Temperature in °K
	 */
	public static float celsiusToKelvin(float temp) {
		return temp + FACTOR_KELVIN;
	}

	/**
	 * °C to °K
	 * 
	 * @param temp
	 *            Temperature in °C
	 * @return Temperature in °K
	 */
	public static double celsiusToKelvin(double temp) {
		return temp + FACTOR_KELVIN;
	}

	/**
	 * °K to °C
	 * 
	 * @param temp
	 *            Temperature in °K
	 * @return Temperature in °C
	 */
	public static float kelvinToCelsius(float temp) {
		return temp - FACTOR_KELVIN;
	}

	/**
	 * °K to °C
	 * 
	 * @param temp
	 *            Temperature in °K
	 * @return Temperature in °C
	 */
	public static double kelvinToCelsius(double temp) {
		return temp - FACTOR_KELVIN;
	}

	/**
	 * °F to °C
	 * 
	 * @param temp
	 *            Temperature in °F
	 * @return Temperature in °C
	 */
	public static float fahrenheitToCelsius(float temp) {
		return (temp - 32f) / 1.8f;
	}

	/**
	 * °F to °C
	 * 
	 * @param temp
	 *            Temperature in °F
	 * @return Temperature in °C
	 */
	public static double fahrenheitToCelsius(double temp) {
		return (temp - 32) / 1.8;
	}

	/**
	 * °C to °F
	 * 
	 * @param temp
	 *            Temperature in °C
	 * @return Temperature in °F
	 */
	public static float celsiusToFahrenheit(float temp) {
		return (temp * FACTOR_FAHRENHEIT) + 32f;
	}

	/**
	 * °C to °F
	 * 
	 * @param temp
	 *            Temperature in °C
	 * @return Temperature in °F
	 */
	public static double celsiusToFahrenheit(double temp) {
		return (temp * FACTOR_FAHRENHEIT) + 32;
	}

	/**
	 * °F to °K
	 * 
	 * @param temp
	 *            Temperature in °F
	 * @return Temperature in °K
	 */
	public static float fahrenheitToKelvin(float temp) {
		return ((temp - 32f) / 1.8f) - FACTOR_KELVIN;
	}

	/**
	 * °F to °K
	 * 
	 * @param temp
	 *            Temperature in °F
	 * @return Temperature in °K
	 */
	public static double fahrenheitToKelvin(double temp) {
		return ((temp - 32) / 1.8) - FACTOR_KELVIN;
	}

	/**
	 * °K to °F
	 * 
	 * @param temp
	 *            Temperature in °K
	 * @return Temperature in °F
	 */
	public static float kelvinToFahrenheit(float temp) {
		return 1.8f * (temp - FACTOR_KELVIN) + 32f;
	}

	/**
	 * °K to °F
	 * 
	 * @param temp
	 *            Temperature in °K
	 * @return Temperature in °F
	 */
	public static double kelvinToFahrenheit(double temp) {
		return 1.8 * (temp - FACTOR_KELVIN) + 32;
	}

}
