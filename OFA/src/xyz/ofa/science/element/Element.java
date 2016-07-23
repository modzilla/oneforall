package xyz.ofa.science.element;

/**
 * @author Kenny Kropp
 */
public class Element {
	private String name, symbol;
	private int number;
	private ElementType type;
	private float weight, density, melt, boil, heatcap, negativity, abundance;

	
	/**
	 * This a generic class for an Element
	 * <b>Use -1f for undefined floats</b>
	 * @param num Atomic number
	 * @param name Full name (English Locale)
	 * @param symbol Elemental Symbol (capitalized)
	 * @param type Type of the element see {@link ElementType}
	 * @param weight The molecular weight of the Element (in atomic mass units)
	 * @param density The density of the Element (in g/cm3)
	 * @param melt The melting temperature of the Element (in degK)
	 * @param boil The boiling temperature of the Element (in degK)
	 * @param heatcap The specific Heat-Capacity of the Element (in J/g*K)
	 * @param negativity The Electronegativity of the Element
	 * @param abundance The abundance of the Element (in mg/kg)
	 */
	protected Element(int num, String name, String symbol, ElementType type, float weight, float density, float melt, float boil, float heatcap,
			float negativity, float abundance) {
		this.type = type;
		this.number = num;
		this.name = name;
		this.symbol = symbol;
		this.weight = weight;
		this.density = density;
		this.melt = melt;
		this.boil = boil;
		this.heatcap = heatcap;
		this.negativity = negativity;
		this.abundance = abundance;
	}
	/**
	 * Get the atomic number
	 * @return The atomic number
	 */
	public int getAtomicNumber(){
		return number;
	}
	/**
	 * Get the element name
	 * @return The element name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Get the element symbol
	 * @return The element Symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * Get the atomic weight
	 * @return The atomic weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * Get the density
	 * @return The density
	 */
	public float getDensity() {
		return density;
	}
	/**
	 * Get the melting point (in degK)
	 * @return The melting point
	 */
	public float getMeltingPoint() {
		return melt;
	}
	/**
	 * Get the boiling point (in degK)
	 * @return The boiling point
	 */
	public float getBoilingPoint() {
		return boil;
	}
	/**
	 * Get the specify Heat-Capacity
	 * @return The Heat-Capacity
	 */
	public float getHeatCapacity() {
		return heatcap;
	}
	/**
	 * Get the Electronegativity
	 * @return The Electronegativity
	 */
	public float getElectroNegativity() {
		return negativity;
	}
	/**
	 * Get the Abundance
	 * @return The Abundance
	 */
	public float getAbundance() {
		return abundance;
	}
	/**
	 * Pretty print the Element
	 * @return A Pretty view of the Element
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Element Number: "  + number + "\n");
		sb.append("Name: " + name + "\n");
		sb.append("Symbol: " + symbol + "\n");
		sb.append("Type: " + type + "\n");
		sb.append("Weight: " + weight + "\n");
		sb.append("Density: " + density + "\n");
		sb.append("Melt (degK): " + melt + "\n");
		sb.append("Boil (degK): " + boil + "\n");
		sb.append("Heat Capacity: " + heatcap + "\n");
		sb.append("Electronegativity: " + negativity + "\n");
		sb.append("Abundance: " + abundance + "\n");		
		return sb.toString();
	}
}
