package xyz.ofa.science.lengths;

/**
 * @author Kenny Krppp
 *
 */
public abstract class Lengths {
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
		} else if (input.isMetric() && target.isImperial()) {
			float meters = input.toStandard(value);
			float inches = LengthUnit.meterToInch(meters);
			return target.fromStandard(inches);
		} else if (input.isImperial() && target.isMetric()) {
			float inches = input.toStandard(value);
			float meters = LengthUnit.inchToMeter(inches);
			return target.fromStandard(meters);
		}
		return -1f;
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
		} else if (input.isMetric() && !target.isMetric()) {
			double meters = input.toStandard(value);
			double inches = LengthUnit.meterToInch(meters);
			return target.fromStandard(inches);
		} else if (!input.isMetric() && target.isMetric()) {
			double inches = input.toStandard(value);
			double meters = LengthUnit.inchToMeter(inches);
			return target.fromStandard(meters);
		}
		return -1f;
	}

}
