package xyz.ofa.science.util;

/**
 * 
 * @author Kenny Kropp
 * <b>A Temperature-Oriented Utility Class</b>
 *
 */
public abstract class Temperatures {

	private static final float FACTOR_KELVIN = 273.15f;
	private static final float FACTOR_FAHRENHEIT = (float) 9 / (float) 5;

	/**
	 * degC to degK
	 * 
	 * @param temp
	 *            Temperature in degC
	 * @return Temperature in degK
	 */
	public static float celsiusToKelvin(float temp) {
		return temp + FACTOR_KELVIN;
	}

	/**
	 * degC to degK
	 * 
	 * @param temp
	 *            Temperature in degC
	 * @return Temperature in degK
	 */
	public static double celsiusToKelvin(double temp) {
		return temp + FACTOR_KELVIN;
	}

	/**
	 * degK to degC
	 * 
	 * @param temp
	 *            Temperature in degK
	 * @return Temperature in degC
	 */
	public static float kelvinToCelsius(float temp) {
		return temp - FACTOR_KELVIN;
	}

	/**
	 * degK to degC
	 * 
	 * @param temp
	 *            Temperature in degK
	 * @return Temperature in degC
	 */
	public static double kelvinToCelsius(double temp) {
		return temp - FACTOR_KELVIN;
	}

	/**
	 * degF to degC
	 * 
	 * @param temp
	 *            Temperature in degF
	 * @return Temperature in degC
	 */
	public static float fahrenheitToCelsius(float temp) {
		return (temp - 32f) / 1.8f;
	}

	/**
	 * degF to degC
	 * 
	 * @param temp
	 *            Temperature in degF
	 * @return Temperature in degC
	 */
	public static double fahrenheitToCelsius(double temp) {
		return (temp - 32) / 1.8;
	}

	/**
	 * degC to degF
	 * 
	 * @param temp
	 *            Temperature in degC
	 * @return Temperature in degF
	 */
	public static float celsiusToFahrenheit(float temp) {
		return (temp * FACTOR_FAHRENHEIT) + 32f;
	}

	/**
	 * degC to degF
	 * 
	 * @param temp
	 *            Temperature in degC
	 * @return Temperature in degF
	 */
	public static double celsiusToFahrenheit(double temp) {
		return (temp * FACTOR_FAHRENHEIT) + 32;
	}

	/**
	 * degF to degK
	 * 
	 * @param temp
	 *            Temperature in degF
	 * @return Temperature in degK
	 */
	public static float fahrenheitToKelvin(float temp) {
		return ((temp - 32f) / 1.8f) - FACTOR_KELVIN;
	}

	/**
	 * degF to degK
	 * 
	 * @param temp
	 *            Temperature in degF
	 * @return Temperature in degK
	 */
	public static double fahrenheitToKelvin(double temp) {
		return ((temp - 32) / 1.8) - FACTOR_KELVIN;
	}

	/**
	 * degK to degF
	 * 
	 * @param temp
	 *            Temperature in degK
	 * @return Temperature in degF
	 */
	public static float kelvinToFahrenheit(float temp) {
		return 1.8f * (temp - FACTOR_KELVIN) + 32f;
	}

	/**
	 * degK to degF
	 * 
	 * @param temp
	 *            Temperature in degK
	 * @return Temperature in degF
	 */
	public static double kelvinToFahrenheit(double temp) {
		return 1.8 * (temp - FACTOR_KELVIN) + 32;
	}

}
