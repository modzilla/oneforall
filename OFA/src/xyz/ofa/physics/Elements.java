package xyz.ofa.physics;

import javax.print.attribute.standard.MediaSize.Other;

import xyz.ofa.error.NoSuchElementException;
import static xyz.ofa.physics.ElementType.*;

public class Elements {
	private static String[] ELEMENT_NAMES = new String[] { "None", "Hydrogen", "Helium", "Lithium", "Beryllium",
			"Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminium", "Silicon",
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
			"Copernicium", "Ununtrium", "Flerovium", "Ununpentium", "Livermorium", "Ununspetium", "Ununoctium" };
	private static String[] ELEMENT_SYMBOLS = new String[] { "None", "H", "He", "Li", "Be", "B", "C", "N", "O", "F",
			"Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co",
			"Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh",
			"Od", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu",
			"Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl",
			"Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es",
			"Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Uut", "Fl", "Uup", "Lv",
			"Uus", "Uuo" };
	private static ElementType[] ELEMENT_TYPES = new ElementType[] { None, OtherNonMetal, NobleGas, AlkaliMetal,
			AlkalineEarthMetal, Metalloid, OtherNonMetal, OtherNonMetal, OtherNonMetal, Halogen, NobleGas, AlkaliMetal, // Na
			AlkalineEarthMetal, PostTransitionMetal, Metalloid, OtherNonMetal, OtherNonMetal, Halogen, NobleGas,
			AlkaliMetal, AlkalineEarthMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal,
			TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal,
			PostTransitionMetal, Metalloid, Metalloid, OtherNonMetal, Halogen, NobleGas, AlkaliMetal,
			AlkalineEarthMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal,
			TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, PostTransitionMetal,
			PostTransitionMetal, Metalloid, Metalloid, Halogen, NobleGas, AlkaliMetal, AlkalineEarthMetal, Lanthanide,
			Lanthanide, Lanthanide, Lanthanide, Lanthanide, Lanthanide, Lanthanide, Lanthanide, Lanthanide, Lanthanide,
			Lanthanide, Lanthanide, Lanthanide, Lanthanide, Lanthanide, TransitionMetal, TransitionMetal,
			TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal,
			TransitionMetal, PostTransitionMetal, PostTransitionMetal, PostTransitionMetal, PostTransitionMetal,
			Halogen, NobleGas, AlkaliMetal, AlkalineEarthMetal, Actinide, Actinide, Actinide, Actinide, Actinide,
			Actinide, Actinide, Actinide, Actinide, Actinide, Actinide, Actinide, Actinide, Actinide, Actinide,
			TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, TransitionMetal, PostTransitionMetal,
			PostTransitionMetal, PostTransitionMetal, TransitionMetal, PostTransitionMetal, PostTransitionMetal,
			PostTransitionMetal, PostTransitionMetal, PostTransitionMetal, PostTransitionMetal };

	public static int atomicNumberForName(String name) throws NoSuchElementException {
		for (int i = 0; i < ELEMENT_NAMES.length; i++) {
			if (ELEMENT_NAMES[i].equalsIgnoreCase(name)) {
				return i;
			}
		}
		throw new NoSuchElementException(name);
	}
	public static ElementType typeForAtomicNumber(int number) throws NoSuchElementException{
		if (number < 0 || number >= ELEMENT_NAMES.length)
			throw new NoSuchElementException(number);
		return ELEMENT_TYPES[number];
	}
	public static int atomicNumberForSymbol(String symbol) throws NoSuchElementException {
		for (int i = 0; i < ELEMENT_SYMBOLS.length; i++) {
			if (ELEMENT_SYMBOLS[i].equalsIgnoreCase(symbol)) {
				return i;
			}
		}
		throw new NoSuchElementException(symbol);
	}

	public static String nameForAtomicNumber(int number) throws NoSuchElementException {
		if (number < 0 || number >= ELEMENT_NAMES.length)
			throw new NoSuchElementException(number);
		return ELEMENT_NAMES[number];
	}

	public static String symbolForAtomicNumber(int number) throws NoSuchElementException {
		if (number < 0 || number >= ELEMENT_NAMES.length)
			throw new NoSuchElementException(number);
		return ELEMENT_SYMBOLS[number];
	}
}
