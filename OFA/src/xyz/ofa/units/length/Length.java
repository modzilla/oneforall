package xyz.ofa.units.length;

/**
 * @author Kenny Krppp
 *
 */
public abstract class Length {
	/**
	 * Convert a value from the given Unit to another Unit (also cross-system)
	 * 
	 * @param value
	 *            Your input value
	 * @param input
	 *            The unit of your input
	 * @param target
	 *            The wanted output unit
	 * @return The converted Value
	 */
	public static float convert(float value, LengthUnit input, LengthUnit target) {
		if (input.isSameSystem(target)) {
			return target.fromStandard(input.toStandard(value));
		}
		if (input.isMetric() && target.isImperial()) {
			float meters = input.toStandard(value);
			float inch = LengthUnit.meterToInch(meters);
			return target.fromStandard(inch);
		}
		if (input.isImperial() && target.isMetric()) {
			float inches = input.toStandard(value);
			float meters = LengthUnit.inchToMeter(inches);
			return target.fromStandard(meters);
		}
		return -1;
	}

	/**
	 * Convert a value from the given Unit to another Unit (also cross-system)
	 * 
	 * @param value
	 *            Your input value
	 * @param input
	 *            The unit of your input
	 * @param target
	 *            The wanted output unit
	 * @return The converted Value
	 */
	public static double convert(double value, LengthUnit input, LengthUnit target) {
		if (input.isSameSystem(target)) {
			return target.fromStandard(input.toStandard(value));
		}
		if (input.isMetric() && target.isImperial()) {
			double meters = input.toStandard(value);
			double inch = LengthUnit.meterToInch(meters);
			return target.fromStandard(inch);
		}
		if (input.isImperial() && target.isMetric()) {
			double inches = input.toStandard(value);
			double meters = LengthUnit.inchToMeter(inches);
			return target.fromStandard(meters);
		}
		return -1;
	}

}
