package xyz.ofa.units.volume;

public enum VolumeUnit {
	
	CubicMillimeter(System.Metric,10e-9),
	MicroLiter(System.Metric,10e-9),
	CubicCentimeter(System.Metric,10e-6),
	MilliLiter(System.Metric,10e-6),
	CentiLiter(System.Metric,10e-5),
	CubicDecimeter(System.Metric,10e-3),
	Liter(System.Metric,10e-3),
	DekaLiter(System.Metric,10e-2),
	HectoLiter(System.Metric,10e-11),
	CubicMeter(System.Metric,1),   		// Standard
	KiloLiter(System.Metric,1),
	
	CubicInch(System.Imperial,1), 		// Standard
	CubicFoot(System.Imperial,1728),
	CubicYard(System.Imperial,46656),
	AcreFoot(System.Imperial,75271680),
	
	Minim(System.Imperial,0.00376),
	USFluidDram(System.Imperial,0.2256),
	Teaspoon(System.Imperial,0.300781),
	Tablespoon(System.Imperial,0.902344),
	USFluidOunce(System.Imperial,1.805),
	USShot(System.Imperial,2.7069),          //FIX
	USGill(System.Imperial,7.219),
	USCup(System.Imperial,14.6457),
	USPint(System.Imperial,28.875),
	USQuart(System.Imperial,57.75),
	USGallon(System.Imperial,231),
	Barrel(System.Imperial,7277),
	OilBarrel(System.Imperial,9702),
	Hogshead(System.Imperial,14553)
	
	;
	private System system;
	private double refToStandard;
	
	private VolumeUnit(System system, double refToStandard){
		this.system = system;
		this.refToStandard = refToStandard;
	}
	public boolean isSameSystem(VolumeUnit i){
		return i.system == this.system;
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
		return val / refToStandard;
	}
	/**
	 * Converts a value in standard to this value
	 * @param val A Value in a standard Unit (Meters,Inches)
	 * @return The Value in this format
	 */
	public float fromStandard(float val){
		return val / (float)refToStandard;
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
     * Cubic meter to Cubic inch Conversion
     * @param val Input in m3
     * @return Output in in3
     */
    public static float cubicMeterToCubicInch(float val){
    	return val * 61023.74409f;
    }
    /**
     * Cubic meter to Cubic inch Conversion
     * @param val Input in m3
     * @return Output in in3
     */
    public static double cubicMeterToCubicInch(double val){
    	return val * 61023.74409;
    }
    /**
     * Cubic inch to Cubic meter Conversion
     * @param val Input in in3
     * @return Output in m3
     */
    public static float cubicInchToCubicMeter(float val){
    	return val / 61023.74409f;
    }
    /**
     * Cubic inch to Cubic meter Conversion
     * @param val Input in in3
     * @return Output in m3
     */
    public static double cubicInchToCubicMeter(double val){
    	return val / 61023.74409;
    }
    
	public enum System{
		Metric,Imperial
	}
}
