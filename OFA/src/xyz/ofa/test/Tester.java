package xyz.ofa.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import xyz.ofa.cmd.NonFlag;
import xyz.ofa.util.Numbers;

public class Tester {

	@Test
	public void testNumbers() throws Exception {
		int ival = 99512;
		short sval = 42;
		long lval = Long.MAX_VALUE / 2;
		double dval = 1.0012;
		float fval = 4.0234f;

		byte[] iArr = new byte[] { 0, 1, -124, -72 };
		byte[] lArr = new byte[] { 63, -1, -1, -1, -1, -1, -1, -1 };
		byte[] dArr = new byte[] { 63, -16, 4, -22, 74, -116, 21, 77 };
		byte[] fArr = new byte[] { 64, -128, -65, -79 };		
		
		assertEquals(488734720, Numbers.reverseBits(ival));
		assertEquals(-4, Numbers.reverseBits(lval));

		assertEquals(10752, Numbers.reverseBytes(sval));
		assertEquals(-1199308544, Numbers.reverseBytes(ival));
		assertEquals(-193, Numbers.reverseBytes(lval));

		assertArrayEquals(iArr, Numbers.getBytes(Numbers.intFromBytes(iArr)));
		assertArrayEquals(lArr, Numbers.getBytes(Numbers.longFromBytes(lArr)));
		assertArrayEquals(dArr, Numbers.getBytes(Numbers.doubleFromBytes(dArr)));
		assertArrayEquals(fArr, Numbers.getBytes(Numbers.floatFromBytes(fArr)));
		
		assertEquals("[Double]40 7A 4B 0A 3D 70 A3 D7", Numbers.hexNumberDump(420.69));		
	}
	@Test
	public void testText() throws Exception{
		
	}
}
