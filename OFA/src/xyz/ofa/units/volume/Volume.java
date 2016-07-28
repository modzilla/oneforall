package xyz.ofa.units.volume;

public abstract class Volume {
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
	public static float convert(float value, VolumeUnit input, VolumeUnit target) {
		if (input.isSameSystem(target)) {
			return target.fromStandard(input.toStandard(value));
		}
		if (input.isMetric() && target.isImperial()) {
			float m3 = input.toStandard(value);
			float in3 = VolumeUnit.cubicMeterToCubicInch(m3);
			return target.fromStandard(in3);
		}
		if (input.isImperial() && target.isMetric()) {
			float in3 = input.toStandard(value);
			float m3 = VolumeUnit.cubicInchToCubicMeter(in3);
			return target.fromStandard(m3);
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
	public static double convert(double value, VolumeUnit input, VolumeUnit target) {
		if (input.isSameSystem(target)) {
			return target.fromStandard(input.toStandard(value));
		}
		if (input.isMetric() && target.isImperial()) {
			double m3 = input.toStandard(value);
			double in3 = VolumeUnit.cubicMeterToCubicInch(m3);
			return target.fromStandard(in3);
		}
		if (input.isImperial() && target.isMetric()) {
			double in3 = input.toStandard(value);
			double m3 = VolumeUnit.cubicInchToCubicMeter(in3);
			return target.fromStandard(m3);
		}
		return -1;
	}
}
