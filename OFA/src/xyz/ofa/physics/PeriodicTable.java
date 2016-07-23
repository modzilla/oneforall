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

import java.util.LinkedList;
import java.util.List;

import xyz.ofa.error.NoSuchElementException;

public class PeriodicTable {
	private static PeriodicTable instance = null;
	private List<Element> elements;

	private final static String[] ELEMENT_NAMES = new String[] { "None", "Hydrogen", "Helium", "Lithium", "Beryllium",
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

	private final static String[] ELEMENT_SYMBOLS = new String[] { "None", "H", "He", "Li", "Be", "B", "C", "N", "O",
			"F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co",
			"Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh",
			"Od", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu",
			"Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl",
			"Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es",
			"Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Uut", "Fl", "Uup", "Lv",
			"Uus", "Uuo" };

	private final static ElementType[] ELEMENT_TYPES = new ElementType[] { None, OtherNonMetal, NobleGas, AlkaliMetal,
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

	private final static float[] ELEMENT_ATOMIC_WEIGHTS = new float[] { -1f, 1.008f, 4.002602f, 6.94f, 9.0121831f,
			10.81f, 12.011f, 14.007f, 15.999f, 18.998403163f, 20.1797f, 22.98976928f, 24.305f, 26.9815385f, 28.085f,
			30.973761998f, 32.06f, 35.45f, 39.948f, 39.0983f, 40.078f, 44.955908f, 47.867f, 50.9415f, 51.9961f,
			54.938044f, 55.845f, 58.933194f, 58.6934f, 63.546f, 65.38f, 69.723f, 72.630f, 74.921595f, 78.971f, 79.904f,
			83.798f, 85.4678f, 87.62f, 88.90584f, 91.224f, 92.90637f, 95.95f, 98f, 101.07f, 102.90550f, 106.42f,
			107.8682f, 112.414f, 114.818f, 118.710f, 121.760f, 127.60f, 126.90447f, 131.293f, 132.90545196f, 137.327f,
			138.90547f, 140.116f, 140.90766f, 144.242f, 145f, 150.36f, 151.964f, 157.25f, 158.92535f, 162.500f,
			164.93033f, 167.259f, 168.93422f, 173.045f, 174.9668f, 178.49f, 180.94788f, 183.84f, 186.207f, 190.23f,
			192.217f, 195.084f, 196.966569f, 200.592f, 204.38f, 207.2f, 208.98040f, 209f, 210f, 222f, 223f, 226f, 227f,
			232.0377f, 231.03588f, 238.02891f, 237f, 244f, 243f, 247f, 247f, 251f, 252f, 257f, 258f, 259f, 266f, 267f,
			268f, 269f, 270f, 269f, 278f, 281f, 282f, 285f, 286f, 289f, 289f, 293f, 294f, 294f };

	private final static float[] ELEMENT_DENSITIES = new float[] { -1f, 0.00008988f, 0.0001785f, 0.534f, 1.85f, 2.34f,
			2.267f, 0.0012506f, 0.001429f, 0.001696f, 0.0008999f, 0.971f, 1.738f, 2.698f, 2.3296f, 1.82f, 2.067f,
			0.003214f, 0.0017837f, 0.862f, 1.54f, 2.989f, 4.54f, 6.11f, 7.15f, 7.44f, 7.874f, 8.86f, 8.912f, 8.96f,
			7.134f, 5.907f, 5.323f, 5.776f, 4.809f, 3.122f, 0.003733f, 1.532f, 2.64f, 4.469f, 6.506f, 8.57f, 10.22f,
			11.5f, 12.37f, 12.41f, 12.02f, 10.501f, 8.69f, 7.31f, 7.287f, 6.685f, 6.232f, 4.93f, 0.005887f, 1.873f,
			3.594f, 6.145f, 6.77f, 6.773f, 7.007f, 7.26f, 7.52f, 5.243f, 7.895f, 8.229f, 8.55f, 8.795f, 9.066f, 9.321f,
			6.965f, 9.84f, 13.31f, 16.654f, 19.25f, 21.02f, 22.61f, 22.56f, 21.46f, 19.282f, 13.5336f, 11.85f, 11.342f,
			9.807f, 9.32f, 7f, 0.00973f, 1.87f, 5.5f, 10.07f, 11.72f, 15.37f, 18.95f, 20.45f, 19.84f, 13.69f, 13.51f,
			14.79f, 15.1f, 8.84f, 9.7f, 10.3f, 9.9f, 15.6f, 23.2f, 29.3f, 35.0f, 37.1f, 40.7f, 37.4f, 34.8f, 28.7f,
			23.7f, 16f, 14f, 13.5f, 12.9f, 7.2f, 5.0f, };

	private final static float[] ELEMENT_MELTING_POINTS = new float[] { -1f, 14.01f, 0.956f, 453.69f, 1560f, 2349f,
			3800f, 63.15f, 54.36f, 53.53f, 24.56f, 370.87f, 923f, 933.47f, 1687f, 317.30f, 388.36f, 171.6f, 83.80f,
			336.53f, 1115f, 1814f, 1941f, 2183f, 2180f, 1519f, 1811f, 1768f, 1728f, 1357.77f, 692.88f, 302.9146f,
			1211.40f, 1090f, 453f, 265.8f, 115.79f, 312.46f, 1050f, 1799f, 2128f, 2750f, 2896f, 2430f, 2607f, 2237f,
			1828.05f, 1234.93f, 594.22f, 429.75f, 505.08f, 903.78f, 722.66f, 386.85f, 161.4f, 301.59f, 1000f, 1193f,
			1068f, 1208f, 1297f, 1315f, 1345f, 1099f, 1585f, 1629f, 1680f, 1734f, 1802f, 1818f, 1097f, 1925f, 2506f,
			3290f, 3695f, 3459f, 3306f, 2719f, 2041.4f, 1337.33f, 234.43f, 577f, 600.61f, 544.7f, 527f, 575f, 202f,
			300f, 973f, 1323f, 2115f, 1841f, 1405.3f, 917f, 912.5f, 1449f, 1613f, 1259f, 1173f, 1133f, 1125f, 1100f,
			1100f, 1900f, 2400f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, 700f, 340f, 700f, 709f, 723f, 258f };

	private final static float[] ELEMENT_BOILING_POINTS = new float[] { -11f, 20.28f, 4.22f, 1560f, 2742f, 4200f, 4300f,
			77.36f, 90.20f, 85.03f, 27.07f, 1156f, 1363f, 2792f, 3538f, 550f, 717.87f, 239.11f, 87.30f, 1032f, 1757f,
			3109f, 3560f, 3680f, 2944f, 2334f, 3134f, 3200f, 3186f, 2835f, 1180f, 2477f, 3106f, 887f, 958f, 332.0f,
			119.93f, 961f, 1655f, 3609f, 4682f, 5017f, 4912f, 4538f, 4423f, 3968f, 3236f, 2435f, 1040f, 2345f, 2875f,
			1860f, 1261f, 457.4f, 165.03f, 944f, 2170f, 3737f, 3716f, 3793f, 3347f, 3273f, 2067f, 1802f, 3546f, 3503f,
			2840f, 2993f, 3141f, 2223f, 1469f, 3675f, 4876f, 5731f, 5828f, 5869f, 5285f, 4701f, 4098f, 3129f, 629.88f,
			1746f, 2022f, 1837f, 1235f, 610f, 211.3f, 950f, 2010f, 3471f, 5061f, 4300f, 4404f, 4273f, 3501f, 2880f,
			3383f, 2900f, 1743f, 1269f, -1f, -1f, -1f, -1f, 5800f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, 357f, 1400f, 420f,
			1400f, 1085f, 883f, 263f, };

	private final static float[] ELEMENT_HEAT_CAPACITY = new float[] { -1f, 14.304f, 5.193f, 3.582f, 1.825f, 1.026f,
			0.709f, 1.04f, 0.918f, 0.824f, 1.03f, 1.228f, 1.023f, 0.897f, 0.705f, 0.769f, 0.71f, 0.479f, 0.52f, 0.757f,
			0.647f, 0.568f, 0.523f, 0.489f, 0.449f, 0.479f, 0.449f, 0.421f, 0.444f, 0.385f, 0.388f, 0.371f, 0.32f,
			0.329f, 0.321f, 0.474f, 0.248f, 0.363f, 0.301f, 0.298f, 0.278f, 0.265f, 0.251f, -1f, 0.238f, 0.243f, 0.244f,
			0.235f, 0.232f, 0.233f, 0.228f, 0.207f, 0.202f, 0.214f, 0.158f, 0.242f, 0.204f, 0.195f, 0.192f, 0.193f,
			0.19f, -1f, 0.197f, 0.182f, 0.236f, 0.182f, 0.17f, 0.165f, 0.168f, 0.16f, 0.155f, 0.154f, 0.144f, 0.14f,
			0.132f, 0.137f, 0.13f, 0.131f, 0.133f, 0.129f, 0.14f, 0.129f, 0.129f, 0.122f, -1f, -1f, 0.094f, -1f, 0.094f,
			0.12f, 0.113f, -1f, 0.116f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f,
			-1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, };

	private final static float[] ELEMENT_ELECTRONEGATIVITY = new float[] { -1f, 2.20f, -1f, 0.98f, 1.57f, 2.04f, 2.55f,
			3.04f, 3.44f, 3.98f, -1f, 0.93f, 1.31f, 1.61f, 1.9f, 2.19f, 2.58f, 3.16f, -1f, 0.82f, 1f, 1.36f, 1.54f,
			1.63f, 1.66f, 1.55f, 1.83f, 1.88f, 1.91f, 1.9f, 1.65f, 1.81f, 2.01f, 2.18f, 2.55f, 2.96f, 3f, 0.82f, 0.95f,
			1.22f, 1.33f, 1.6f, 2.16f, 1.9f, 2.2f, 2.28f, 2.2f, 1.93f, 1.69f, 1.78f, 1.96f, 2.05f, 2.1f, 2.66f, 2.6f,
			0.79f, 0.89f, 1.1f, 1.12f, 1.13f, 1.14f, 1.13f, 1.17f, 1.2f, 1.2f, 1.2f, 1.22f, 1.23f, 1.24f, 1.25f, 1.1f,
			1.27f, 1.3f, 1.5f, 2.36f, 1.9f, 2.2f, 2.2f, 2.28f, 2.54f, 2f, 1.62f, 1.87f, 2.02f, 2.0f, 2.2f, 2.2f, 0.7f,
			0.9f, 1.1f, 1.3f, 1.5f, 1.38f, 1.36f, 1.28f, 1.13f, 1.28f, 1.3f, 1.3f, 1.3f, 1.3f, 1.3f, 1.3f, 1.3f, -1f,
			-1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, -1f, };

	private final static float[] ELEMENT_ABUNDANCE = new float[] { -1f, 1400f, 0.008f, 20f, 2.8f, 10f, 200f, 19f,
			461000f, 585f, 0.005f, 23600f, 23300f, 82300f, 282000f, 1050f, 350f, 145f, 3.5f, 20900f, 41500f, 22f, 5650f,
			120f, 102f, 950f, 56300f, 25f, 84f, 60f, 70f, 19f, 1.5f, 1.8f, 0.05f, 2.4f, .0001f, 90f, 370f, 33f, 165f,
			20f, 1.2f, .000000003f, 0.001f, 0.001f, 0.015f, 0.075f, 0.159f, 0.25f, 2.3f, 0.2f, 0.001f, 0.45f, .00003f,
			3f, 425f, 39f, 66.5f, 9.2f, 41.5f, .0000000000000000002f, 7.05f, 2f, 6.2f, 1.2f, 5.2f, 1.3f, 3.5f, 0.52f,
			3.2f, 0.8f, 3f, 2f, 1.3f, .0007f, 0.002f, 0.001f, 0.005f, 0.004f, 0.085f, 0.85f, 14f, 0.009f, .0000000002f,
			0.000000000000000000003f, .0000000000004f, 0.000000000000000001f, .0000009f, .00000000055f, 9.6f, .0000014f,
			2.7f, 0.000000000003f, 0.00000000003f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f,
			0f, 0f, 0f, 0f, 0f, 0f, 0f, };

	private PeriodicTable() {
		elements = new LinkedList<>();
		for (int i = 0; i < ELEMENT_NAMES.length; i++) {
			elements.add(new Element(ELEMENT_NAMES[i], ELEMENT_SYMBOLS[i], ELEMENT_ATOMIC_WEIGHTS[i],
					ELEMENT_DENSITIES[i], ELEMENT_MELTING_POINTS[i], ELEMENT_BOILING_POINTS[i],
					ELEMENT_HEAT_CAPACITY[i], ELEMENT_ELECTRONEGATIVITY[i], ELEMENT_ABUNDANCE[i]));
		}
	}

	public static PeriodicTable getInstance() {
		if (instance == null)
			instance = new PeriodicTable();
		return instance;
	}

	public List<Element> getAllElements() {
		return elements;
	}

	public Element getElementByNumber(int number) throws NoSuchElementException {
		if (number > elements.size())
			throw new NoSuchElementException(number);
		return elements.get(number);
	}

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
