package xyz.ofa.science.lengths;

/**
 * 
 * @author Kenny Kropp
 *
 */
public enum LengthUnit {
	Nanometer (System.Metric,10e-9),
	Micrometer (System.Metric,10e-6),
	Millimeter (System.Metric,10e-3),
	Centimeter (System.Metric,10e-2),
	Decimeter (System.Metric,10),
	Meter (System.Metric, 1),			//Standard
	Kilometer (System.Metric,10e3),
	Megameter (System.Metric,10e6),
	Gigameter (System.Metric,10e9),
	
	Thou (System.Imperial,10e-3),
	Inch (System.Imperial,1),			//Standard
	Foot (System.Imperial,12),
	Yard (System.Imperial,36),
	Mile (System.Imperial,63360);
	
	private System system;
	private double refToStandard;
	/**
	 * Enum internal Constructor for defining System and Factor
	 * @param system Either Metric or Imperial
	 * @param refToStandard Factor from this unit to the standard
	 */
	private LengthUnit(System system, double refToStandard){
		this.system = system;
		this.refToStandard = refToStandard;
	}	
	/**
	 * Check if the 2 units are both Metric or both Imperial
	 * @param i Target Unit
	 * @return True if they are in the same System
	 */
	public boolean isSameSystem(LengthUnit i){
		return i == this;
	}
	/**
	 * Converts this unit to the Standard unit
	 * @param val A Value
	 * @return The value in the format of the standard
	 */
	public double toStandard(double val){
		return val * refToStandard;
	}
	/**
	 * Converts this unit to the Standard unit
	 * @param val A Value
	 * @return The value in the format of the standard
	 */
	public float toStandard(float val){
		return val * (float)refToStandard;
	}
	/**
	 * Converts a value in standard to this value
	 * @param val A Value in a standard Unit (Meters,Inches)
	 * @return The Value in this format
	 */
	public double fromStandard(double val){
		return val * refToStandard;
	}
	/**
	 * Converts a value in standard to this value
	 * @param val A Value in a standard Unit (Meters,Inches)
	 * @return The Value in this format
	 */
	public float fromStandard(float val){
		return val * (float)refToStandard;
	}	
	/**
	 * Check if this unit is in the metric system
	 * @return True if the Unit is metric
	 */
    public boolean isMetric() {
        return this.system == System.Metric;
    }
	/**
	 * Check if this unit is in the imperial system
	 * @return True if the Unit is imperial
	 */
    public boolean isImperial(){
    	return this.system == System.Imperial;
    }
    /**
     * Approximate Conversion from Meters to Inches
     * @param val Length in meters
     * @return Length in inches
     */
    public static float meterToInch(float val){
    	return val * 39.37008f;
    }
    /**
     * Approximate Conversion from Meters to Inches
     * @param val Length in meters
     * @return Length in inches
     */
    public static double meterToInch(double val){
    	return val * 39.37008;
    }
    /**
     * Approximate Conversion from Inches to Meters
     * @param val Length in inches
     * @return Length in meters
     */
    public static float inchToMeter(float val){
    	return val * 39.37008f;
    }
    /**
     * Approximate Conversion from Inches to Meters
     * @param val Length in inches
     * @return Length in meters
     */
    public static double inchToMeter(double val){
    	return val * 39.37008;
    }
	private enum System{
		Metric,Imperial;
	}
}
