package xyz.ofa.physics;

public class Elements {
	public static String[] ELEMENT_NAMES = new String[] { "None", "Hydrogen", "Helium", "Lithium", "Beryllium", "Boron",
			"Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminium", "Silicon",
			"Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium",
			"Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic",
			"Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum",
			"Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony",
			"Tellurium", "Iodine", "Xenon", "Caesium", "Barium", "Lanthanum", "Cerium", "Praseodymium", "Neodymium",
			"Promethium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium",
			"Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum",
			"Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium",
			"Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium",
			"Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium",
			"Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meiterium", "Darmstadtium", "Roentgenium",
			"Copernicium" };
	public static String[] ELEMENT_SYMBOLS = new String[] { "None", "H", "He", "Li", "Be", "B", "C", "N", "O", "F",
			"Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co",
			"Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh",
			"Od", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",

	};

	public static int atomicNumberForName(String name) {
		for (int i = 0; i < ELEMENT_NAMES.length; i++) {
			if (ELEMENT_NAMES[i].equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
}
