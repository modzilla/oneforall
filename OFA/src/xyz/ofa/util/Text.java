package xyz.ofa.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * @author Kenny Kropp This is a general Purpose Text modification File
 */
public class Text {

	public static final Charset UTF8 = Charset.forName("UTF-8");
	public static final Charset ASCII = Charset.forName("US-ASCII");
	public static final Charset ISO8859 = Charset.forName("ISO-8859-1");
	public static final String ELLIPSIS_UTF8 = "\u2026";
	public static final String ELLIPSIS_ASCII = "...";
	public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr,\n"
			+ "sed diam nonumy eirmod tempor invidunt ut labore et dolore\n"
			+ "magna aliquyam erat, sed diam voluptua. At vero eos et accusam\n"
			+ "et justo duo dolores et ea rebum. Stet clita kasd gubergren, no\n"
			+ "sea takimata sanctus est Lorem ipsum dolor sit amet.\n";

	/**
	 * Encodes a String in the given Charset
	 * 
	 * @param text
	 *            String you want to convert
	 * @param charset
	 *            Target Charset (Encoding)
	 * @return Your String encoded into your Charset
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] toBytes(String text, Charset charset) throws UnsupportedEncodingException {
		return text.getBytes(charset);
	}

	/**
	 * Decodes a byte-array with the given Charset
	 * 
	 * @param text
	 *            Input text
	 * @param charset
	 *            Input Charset
	 * @return Your String decoded from the Charset
	 * @throws UnsupportedEncodingException
	 */
	public static String fromBytes(byte[] text, Charset charset) throws UnsupportedEncodingException {
		return new String(text, charset);
	}

	/**
	 * Please use the {@link Text#toBytes(String, Charset)} Method with the
	 * {@link Text#ASCII} Charset
	 * 
	 * @param text
	 * @return
	 */
	@Deprecated
	public static byte[] toASCIIBytes(String text) {
		ByteBuffer b = ByteBuffer.allocate(countASCII(text));
		for (char c : keepASCII(text).toCharArray()) {
			b.put((byte) c);
		}
		return b.array();
	}

	/**
	 * Please use the {@link Text#fromBytes(byte[], Charset)} Method with the
	 * {@link Text#ASCII} Charset
	 * 
	 * @param text
	 * @return
	 */
	@Deprecated
	public static String fromASCIIBytes(byte[] text) {
		StringBuilder sb = new StringBuilder(text.length);
		for (byte b : text)
			sb.append((char) b);
		return sb.toString().trim();
	}

	/**
	 * Replaces all non ASCII characters with nothing
	 * 
	 * @param text
	 *            Your text containing non-ASCII characters
	 * @return Your text only containing ASCII characters
	 */
	public static char[] keepASCII(char[] text) {
		return new String(text).replaceAll("[^\\x00-\\x7F]", "").toCharArray();
	}

	/**
	 * Replaces all non ASCII characters with nothing
	 * 
	 * @param text
	 *            Your text containing non-ASCII characters
	 * @return Your text only containing ASCII characters
	 */
	public static String keepASCII(String text) {
		return text.replaceAll("[^\\x00-\\x7F]", "");
	}

	/**
	 * Counts the amount of ASCII characters in the String
	 * 
	 * @param text
	 *            Your Text
	 * @return Amount of ASCII characters
	 */
	public static int countASCII(String text) {
		return keepASCII(text).length();
	}

	/**
	 * Checks if your String contains any non-ASCII characters
	 * 
	 * @param text
	 *            Your String under Test
	 * @return whether your String contains non-ASCII characters
	 */
	public static boolean hasNonASCII(String text) {
		return text.length() > countASCII(text);
	}

	/**
	 * Abbreviates a String to the given Length and appending a
	 * {@link Text#ELLIPSIS_UTF8}
	 * 
	 * @param text
	 *            Your long input String
	 * @param length
	 *            Your desired Length
	 * @return Substring of your String from 0 to length and an appended
	 *         Ellipsis
	 */
	public static String abbreviate(String text, int length) {
		if (countASCII(text) > text.length())
			return text.substring(0, length) + ELLIPSIS_UTF8;
		else
			return text.substring(0, length) + ELLIPSIS_ASCII;
	}

	/**
	 * Places the given Character to the left of the String N times
	 * 
	 * @param text
	 *            Your input text
	 * @param amount
	 *            The padding amount
	 * @param padChar
	 *            The padding character
	 * @return Your padded String
	 */
	public static String padLeft(String text, int amount, char padChar) {
		for (int i = 0; i < amount; i++) {
			text = padChar + text;
		}
		return text;
	}

	/**
	 * Places the character '*' to the left of the String N times
	 * 
	 * @param text
	 *            Your input text
	 * @param amount
	 *            The padding amount
	 * @return Your padded String
	 */
	public static String padLeft(String text, int amount) {
		return padLeft(text, amount, '*');
	}

	/**
	 * Places the given Character to the right of the String N times
	 * 
	 * @param text
	 *            Your input text
	 * @param amount
	 *            The padding amount
	 * @param padChar
	 *            The padding character
	 * @return Your padded String
	 */
	public static String padRight(String text, int amount, char padChar) {
		for (int i = 0; i < amount; i++) {
			text += padChar;
		}
		return text;
	}

	/**
	 * Places the character '*' to the right of the String N times
	 * 
	 * @param text
	 *            Your input text
	 * @param amount
	 *            The padding amount
	 * @return Your padded String
	 */
	public static String padRight(String text, int amount) {
		return padRight(text, amount, '*');
	}

	/**
	 * Fills the String on the left with the given char to a given length
	 * 
	 * @param text
	 *            Your input String
	 * @param length
	 *            The maximum total length
	 * @param fillChar
	 *            Your fill-Char
	 * @return A String filled to length with your fill-Char
	 */
	public static String fillLeft(String text, int length, char fillChar) {
		for (int i = 0; i < text.length() - length; i++)
			text = fillChar + text;
		return text;
	}

	/**
	 * Fills the String on the left with ' ' to a given length
	 * 
	 * @param text
	 *            Your input String
	 * @param length
	 *            The maximum total length
	 * @return A String filled to length with your fill-Char
	 */
	public static String fillLeft(String text, int length) {
		return fillLeft(text, length, ' ');
	}

	/**
	 * Fills the String on the right with the given char to a given length
	 * 
	 * @param text
	 *            Your input String
	 * @param length
	 *            The maximum total length
	 * @param fillChar
	 *            Your fill-Char
	 * @return A String filled to length with your fill-Char
	 */
	public static String fillRight(String text, int length, char fillChar) {
		for (int i = 0; i < text.length() - length; i++)
			text += fillChar;
		return text;
	}

	/**
	 * Fills the String on the right with ' ' to a given length
	 * 
	 * @param text
	 *            Your input String
	 * @param length
	 *            The maximum total length
	 * @return A String filled to length with your fill-Char
	 */
	public static String fillRight(String text, int length) {
		return fillRight(text, length, ' ');
	}

	/**
	 * Swaps the encoding of the given byte-array to another encoding
	 * 
	 * @param text
	 *            Your input "text"
	 * @param input
	 *            The charset in which the text is encoded
	 * @param output
	 *            The charset you wish the output to be in
	 * @return A Byte-Array with the Output encoding containing the letters in
	 *         the input
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] swapEncoding(byte[] text, Charset input, Charset output) throws UnsupportedEncodingException {
		return toBytes(fromBytes(text, input), output);
	}

	/**
	 * Sorts the letters in the given Input Ascending
	 * 
	 * @param input
	 *            Your text
	 * @return Your text but sorted Ascending
	 */
	public static String sortLetters(String input) {
		char[] d = input.toCharArray();
		Arrays.sort(d);
		return new String(d);
	}

	/**
	 * Repeats a given String N times
	 * 
	 * @param text
	 *            Input String
	 * @param amount
	 *            Amount of repeats
	 * @return The repeated String
	 */
	public static String repeat(String text, int amount) {
		String v = text;
		for (int i = 0; i < amount; i++) {
			v += text;
		}
		return v;
	}

	/**
	 * Copies the String as often as it is required to match a N length String
	 * also precisely adjusting the length via substring
	 * 
	 * @param text
	 *            Input String
	 * @param length
	 *            Char-Count of the output
	 * @return Output-String
	 */
	public static String repeatFill(String text, int length) {
		int rough = (int) Math.ceil((double) length / text.length());
		String s = String.join("", Collections.nCopies(rough, text));
		s = s.substring(0, length);
		return s;
	}

	/**
	 * Generates a Lorem Ipsum string
	 * 
	 * @param length
	 *            The Amount of characters
	 * @param newlines
	 *            include "\n" ?
	 * @return Lorem Ipsum String
	 */
	public static String generateLoremIpsum(int length, boolean newlines) {
		return repeatFill(newlines ? LOREM_IPSUM : LOREM_IPSUM.replace("\n", ""), length);
	}
	
}
