package xyz.ofa.physics;

import static xyz.ofa.physics.ElementType.Actinide;
import static xyz.ofa.physics.ElementType.AlkaliMetal;
import static xyz.ofa.physics.ElementType.AlkalineEarthMetal;
import static xyz.ofa.physics.ElementType.Halogen;
import static xyz.ofa.physics.ElementType.Lanthanide;
import static xyz.ofa.physics.ElementType.Metalloid;
import static xyz.ofa.physics.ElementType.NobleGas;
import static xyz.ofa.physics.ElementType.None;
import static xyz.ofa.physics.ElementType.OtherNonMetal;
import static xyz.ofa.physics.ElementType.PostTransitionMetal;
import static xyz.ofa.physics.ElementType.TransitionMetal;

import xyz.ofa.error.NoSuchElementException;

public class Elements {
	public static String[] ELEMENT_NAMES = new String[] { "None", "Hydrogen", "Helium", "Lithium", "Beryllium",
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

	public static String[] ELEMENT_SYMBOLS = new String[] { "None", "H", "He", "Li", "Be", "B", "C", "N", "O", "F",
			"Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co",
			"Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh",
			"Od", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu",
			"Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl",
			"Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es",
			"Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Uut", "Fl", "Uup", "Lv",
			"Uus", "Uuo" };

	public static ElementType[] ELEMENT_TYPES = new ElementType[] { None, OtherNonMetal, NobleGas, AlkaliMetal,
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

	public static float[] ELEMENT_ATOMIC_WEIGHTS = new float[] { -1f, 1.008f, 4.002602f, 6.94f, 9.0121831f, 10.81f,
			12.011f, 14.007f, 15.999f, 18.998403163f, 20.1797f, 22.98976928f, 24.305f, 26.9815385f, 28.085f, 30.973761998f, 32.06f,
			35.45f, 39.948f, 39.0983f, 40.078f, 44.955908f, 47.867f, 50.9415f, 51.9961f, 54.938044f, 55.845f,
			58.933194f, 58.6934f, 63.546f, 65.38f, 69.723f, 72.630f, 74.921595f, 78.971f, 79.904f, 83.798f, 85.4678f,
			87.62f, 88.90584f, 91.224f, 92.90637f, 95.95f, 98f, 101.07f, 102.90550f, 106.42f, 107.8682f, 112.414f,
			114.818f, 118.710f, 121.760f, 127.60f, 126.90447f, 131.293f, 132.90545196f, 137.327f, 138.90547f, 140.116f,
			140.90766f, 144.242f, 145f, 150.36f, 151.964f, 157.25f, 158.92535f, 162.500f, 164.93033f, 167.259f,
			168.93422f, 173.045f, 174.9668f, 178.49f, 180.94788f,183.84f, 186.207f, 190.23f, 192.217f, 195.084f, 196.966569f, 200.592f,
			204.38f, 207.2f, 208.98040f, 209f, 210f, 222f, 223f, 226f, 227f, 232.0377f, 231.03588f, 238.02891f, 237f,
			244f, 243f, 247f, 247f, 251f, 252f, 257f, 258f, 259f, 266f, 267f, 268f, 269f, 270f, 269f, 278f, 281f, 282f,
			285f, 286f, 289f, 289f, 293f, 294f, 294f

	};

	public static int atomicNumberForName(String name) throws NoSuchElementException {
		for (int i = 0; i < ELEMENT_NAMES.length; i++) {
			if (ELEMENT_NAMES[i].equalsIgnoreCase(name)) {
				return i;
			}
		}
		throw new NoSuchElementException(name);
	}

	public static ElementType typeForAtomicNumber(int number) throws NoSuchElementException {
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
