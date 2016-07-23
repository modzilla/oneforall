package xyz.ofa.physics;

public class Element {
	private String name, symbol;
	private float weight, density, melt, boil, heatcap, negativity, abundance;

	public Element(String name, String symbol, float weight, float density, float melt, float boil, float heatcap,
			float negativity, float abundance) {
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

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public float getWeight() {
		return weight;
	}

	public float getDensity() {
		return density;
	}

	public float getMeltingPoint() {
		return melt;
	}

	public float getBoilingPoint() {
		return boil;
	}

	public float getHeatCapacity() {
		return heatcap;
	}

	public float getElectroNegativity() {
		return negativity;
	}

	public float getAbundance() {
		return abundance;
	}
}
