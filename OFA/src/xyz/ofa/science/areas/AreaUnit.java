package xyz.ofa.science.areas;

public enum AreaUnit {
	Barn(System.Metric,10e-28),
	SquareNanometer(System.Metric,10e-18),
	SquareMicrometer(System.Metric,10e-12),
	SquareMillimeter(System.Metric,10e-6),
	SquareCentimeter(System.Metric,10e-4),
	SquareDecimeter(System.Metric,10e-2),
	SquareMeter(System.Metric,10e0),		//Standard
	MetricAcre (System.Metric, 10e2),
	Hectare (System.Metric,10e4),
	SquareKilometer(System.Metric,10e6),
	SquareMegameter(System.Metric,10e12),
	SquareGigameter(System.Metric,10e18),
	
	SquareInch(System.Imperial,1/144),
	SquareFoot(System.Imperial,1),			//Standard
	SquareYard(System.Imperial,9),
	SquareRod(System.Imperial,272.25),
	Rood(System.Imperial,10890),
	ImperialAcre(System.Imperial,43560),
	Homestead(System.Imperial,6969600),
	Township(System.Imperial,1003622400);
	
	
	private System system;
	private double refToStandard;	
	private AreaUnit(System system, double refToStandard){
		this.system = system;
		this.refToStandard = refToStandard;
	}
	
	/**
	 * Convert a value from m2 to ft2
	 * @param sqmeter Squaremeter input
	 * @return Squarefoot output
	 */
	public static float squareMeterToSquareFoot(float sqmeter){
		return sqmeter * 10.76391041671f;
	}
	/**
	 * Convert a value from ft2 to m2
	 * @param sqmeter Squarefoot input
	 * @return Squaremeter output
	 */
	public static float squareFootToSquareMeter(float sqfoot){
		return sqfoot / 10.76391041671f;
	}
	/**
	 * Convert a value from m2 to ft2
	 * @param sqmeter Squaremeter input
	 * @return Squarefoot output
	 */
	public static double squareMeterToSquareFoot(double sqmeter){
		return sqmeter * 10.76391041671;
	}
	/**
	 * Convert a value from ft2 to m2
	 * @param sqmeter Squarefoot input
	 * @return Squaremeter output
	 */
	public static double squareFootToSquareMeter(double sqfoot){
		return sqfoot / 10.76391041671;
	}
	/**
	 * Check if the 2 units are both Metric or both Imperial
	 * @param i Target Unit
	 * @return True if they are in the same System
	 */
	public boolean isSameSystem(AreaUnit i){
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
	
	private enum System{
		Metric,Imperial
	}
}
