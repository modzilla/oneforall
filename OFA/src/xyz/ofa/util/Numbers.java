package xyz.ofa.util;

import java.nio.ByteBuffer;

import xyz.ofa.error.NotEnoughBytesException;

public class Numbers {
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

	// Byte Reversing
	public static short reverseBytes(short number) {
		return Short.reverseBytes(number);
	}

	public static int reverseBytes(int number) {
		return Integer.reverseBytes(number);
	}

	public static long reverseBytes(long number) {
		return Long.reverseBytes(number);
	}

	// Bit Reversing
	public static int reverseBits(int number) {
		return Integer.reverse(number);
	}

	public static long reverseBits(long number) {
		return Long.reverse(number);
	}

	// Extracting Bytes
	private static byte[] getBytes(Number o) {
		if (o instanceof Integer)
			return getBytes((int) o);
		if (o instanceof Long)
			return getBytes((long) o);
		if (o instanceof Double)
			return getBytes((double) o);
		if (o instanceof Float)
			return getBytes((float) o);
		return null;
	}

	public static byte[] getBytes(int number) {
		return ByteBuffer.allocate(Integer.BYTES).putInt(number).array();
	}

	public static byte[] getBytes(long number) {
		return ByteBuffer.allocate(Long.BYTES).putLong(number).array();
	}

	public static byte[] getBytes(double number) {
		return ByteBuffer.allocate(Double.BYTES).putDouble(number).array();
	}

	public static byte[] getBytes(float number) {
		return ByteBuffer.allocate(Float.BYTES).putFloat(number).array();
	}

	public static byte[] getBytes(short number) {
		return ByteBuffer.allocate(Short.BYTES).putShort(number).array();
	}

	// Packing Bytes
	public static int intFromBytes(byte[] number) throws NotEnoughBytesException {
		if (number.length < Integer.BYTES || number == null)
			throw new NotEnoughBytesException(Integer.BYTES);
		return ByteBuffer.allocate(Integer.BYTES).put(number).getInt(0);
	}

	public static long longFromBytes(byte[] number) throws NotEnoughBytesException {
		if (number.length < Long.BYTES || number == null)
			throw new NotEnoughBytesException(Long.BYTES);
		return ByteBuffer.allocate(Long.BYTES).put(number).getLong(0);
	}

	public static double doubleFromBytes(byte[] number) throws NotEnoughBytesException {
		if (number.length < Double.BYTES || number == null)
			throw new NotEnoughBytesException(Double.BYTES);
		return ByteBuffer.allocate(Double.BYTES).put(number).getDouble(0);
	}

	public static float floatFromBytes(byte[] number) throws NotEnoughBytesException {
		if (number.length < Float.BYTES || number == null)
			throw new NotEnoughBytesException(Float.BYTES);
		return ByteBuffer.allocate(Float.BYTES).put(number).getFloat(0);
	}

	public static short shortFromBytes(byte[] number) throws NotEnoughBytesException {
		if (number.length < Short.BYTES || number == null)
			throw new NotEnoughBytesException(Short.BYTES);
		return ByteBuffer.allocate(Short.BYTES).put(number).getShort(0);
	}

	public static byte firstHalf(byte v) {
		return (byte) (v & 0xf0);
	}
	public static int firstHalfValue(byte v){
		return (int) ((v & 0xf0) >> 4);
	}
	public static byte secondHalf(byte v) {
		return (byte) (v & 0x0f);
	}
	public static int secondHalfValue(byte v){
		return (int) ((v & 0x0f) >> 0);
	}
	public static byte joinHalves(byte a, byte b) {
		return (byte) ((a & 0xf0) | (b & 0x0f));
	}
	public static byte[] splitQuad(byte b){
		return new byte[]
				{
					(byte) ((b & 0b11000000) >> 6),
					(byte) ((b & 0b00110000) >> 4),
					(byte) ((b & 0b00001100) >> 2),
					(byte) ((b & 0b00000011) >> 0),
				};
	}

	// MISC
	public static int unsignedValue(byte number) {
		return number & 0xFF;
	}

	public static String decDump(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			sb.append(' ');
			if (i % 8 == 0)
				sb.append(' ');
			if (i % 16 == 0)
				sb.append('\n');

			sb.append(String.format("%03d", unsignedValue(b)));
		}
		return sb.toString().trim();
	}

	public static String hexDump(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			sb.append(' ');
			if (i % 8 == 0)
				sb.append(' ');
			if (i % 16 == 0)
				sb.append('\n');
			sb.append(hexArray[(b & 0xf0) >> 4]);
			sb.append(hexArray[(b & 0x0f) >> 0]);
		}
		return sb.toString().trim();
	}

	public static String prettyHexDump(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		String fl = "DUMP    0  1  2  3  4  5  6  7   8  9  A  B  C  D  E  F\n";
		sb.append(fl + Text.padLeft("", fl.length(), ' '));
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			sb.append(' ');
			if (i % 8 == 0)
				sb.append(' ');
			if (i % 16 == 0)
				sb.append(String.format("\n%04X   ", i));
			sb.append(hexArray[(b & 0xf0) >> 4]);
			sb.append(hexArray[(b & 0x0f) >> 0]);

		}
		return sb.toString().trim();
	}

}
