package xyz.ofa.units.area;

public abstract class Area {
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
	public static float convert(float value, AreaUnit input, AreaUnit target) {
		if (input.isSameSystem(target)) {
			return target.fromStandard(input.toStandard(value));
		}
		if (input.isMetric() && target.isImperial()) {
			float sqm = input.toStandard(value);
			float sqf = AreaUnit.squareMeterToSquareFoot(sqm);
			return target.fromStandard(sqf);

		}
		if (input.isImperial() && target.isMetric()) {
			float sqf = input.toStandard(value);
			float sqm = AreaUnit.squareFootToSquareMeter(sqf);
			return target.fromStandard(sqm);
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
	public static double convert(double value, AreaUnit input, AreaUnit target) {
		if (input.isSameSystem(target)) {
			return target.fromStandard(input.toStandard(value));
		}
		if (input.isMetric() && target.isImperial()) {
			double sqm = input.toStandard(value);
			double sqf = AreaUnit.squareMeterToSquareFoot(sqm);
			return target.fromStandard(sqf);

		}
		if (input.isImperial() && target.isMetric()) {
			double sqf = input.toStandard(value);
			double sqm = AreaUnit.squareFootToSquareMeter(sqf);
			return target.fromStandard(sqm);
		}
		return -1;
	}
}
