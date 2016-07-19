package xyz.ofa.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Text {

	public static final Charset UTF8 = Charset.forName("UTF-8");
	public static final Charset ASCII = Charset.forName("US-ASCII");
	public static final Charset ISO8859 = Charset.forName("ISO-8859-1");
	public static final String ELLIPSIS_UTF8 = "\u2026";
	public static final String ELLIPSIS_ASCII = "...";

	public static byte[] toBytes(String text, Charset charset) throws UnsupportedEncodingException {
		return text.getBytes(charset);
	}

	public static String fromBytes(byte[] text, Charset charset) throws UnsupportedEncodingException {
		return new String(text, charset);
	}

	@Deprecated
	public static byte[] toASCIIBytes(String text) {
		ByteBuffer b = ByteBuffer.allocate(countASCII(text));
		for (char c : keepASCII(text).toCharArray()) {
			b.put((byte) c);
		}
		return b.array();
	}

	@Deprecated
	public static String fromASCIIBytes(byte[] text) {
		StringBuilder sb = new StringBuilder(text.length);
		for (byte b : text)
			sb.append((char) b);
		return sb.toString().trim();
	}

	public static char[] keepASCII(char[] text) {
		return new String(text).replaceAll("[^\\x00-\\x7F]", "").toCharArray();
	}

	public static String keepASCII(String text) {
		return text.replaceAll("[^\\x00-\\x7F]", "");
	}

	public static int countASCII(String text) {
		return keepASCII(text).length();
	}

	public static boolean hasNonASCII(String text) {
		return text.length() > countASCII(text);
	}

	public static String abbreviate(String text, int length) {
		if (countASCII(text) > text.length())
			return text.substring(0, length) + ELLIPSIS_UTF8;
		else
			return text.substring(0, length) + ELLIPSIS_ASCII;
	}

	public static String padLeft(String text, int amount, char padChar) {
		for (int i = 0; i < amount; i++) {
			text = padChar + text;
		}
		return text;
	}

	public static String padLeft(String text, int amount) {
		return padLeft(text, amount, '*');
	}

	public static String padRight(String text, int amount, char padChar) {
		for (int i = 0; i < amount; i++) {
			text += padChar;
		}
		return text;
	}

	public static String padRight(String text, int amount) {
		return padRight(text, amount, '*');
	}

	public static String fillLeft(String text, int length, char fillChar) {
		for (int i = 0; i < text.length() - length; i++)
			text = fillChar + text;
		return text;
	}

	public static String fillLeft(String text, int length) {
		return fillLeft(text, length, ' ');
	}

	public static String fillRight(String text, int length, char fillChar) {
		for (int i = 0; i < text.length() - length; i++)
			text += fillChar;
		return text;
	}

	public static String fillRight(String text, int length) {
		return fillRight(text,length,' ');
	}

	public static byte[] swapEncoding(byte[] text, Charset input, Charset output) throws UnsupportedEncodingException {
		return toBytes(fromBytes(text, input), output);
	}

}
