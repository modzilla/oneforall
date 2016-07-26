/**
 * 
 */
package xyz.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import xyz.ofa.error.NotEnoughBytesException;
import xyz.ofa.util.Numbers;

/**
 * @author lauch
 *
 */
public class NumbersTest {

	// Byte Reversing In/Outputs
	private short a1 = 12, b1 = 3072;
	private int a2 = 24, b2 = 402653184;
	private long a3 = 837589578, b3 = Long.parseLong("5375868800417660928");
	// Bit Reversing In/Outputs
	private int a4 = 124, b4 = 1040187392;
	private long a5 = 12445523, b5 = Long.parseLong("-3825881550730297344");
	// Byte Gathering
	private short a6 = 95;
	private byte[] b6 = new byte[] { 0, 95 };
	private int a7 = 3548;
	private byte[] b7 = new byte[] { 0, 0, 13, -36 };
	private long a8 = 245;
	private byte[] b8 = new byte[] { 0, 0, 0, 0, 0, 0, 0, -11 };
	private float a9 = 24.5f;
	private byte[] b9 = new byte[] { 65, -60, 0, 0 };
	private double aA = 14.4;
	private byte[] bA = new byte[] { 64, 44, -52, -52, -52, -52, -52, -51 };

	private byte aB = (byte) -118;
	private byte bB = (byte) -128;
	private byte cB = (byte) 10;
	private int dB = 8, eB = 10;

	private byte aC = (byte) -14;
	private int bC = 242;

	private float aD = 2893457.5342f;
	private String bD = "4A 30 9A 46";
	private String cD = "074 048 154 070";

	@Test
	public void test() throws NotEnoughBytesException {
		assertEquals(b1, Numbers.reverseBytes(a1));
		assertEquals(b2, Numbers.reverseBytes(a2));
		assertEquals(b3, Numbers.reverseBytes(a3));

		assertEquals(b4, Numbers.reverseBits(a4));
		assertEquals(b5, Numbers.reverseBits(a5));

		assertArrayEquals(b6, Numbers.getBytes(a6));
		assertArrayEquals(b7, Numbers.getBytes(a7));
		assertArrayEquals(b8, Numbers.getBytes(a8));
		assertArrayEquals(b9, Numbers.getBytes(a9));
		assertArrayEquals(bA, Numbers.getBytes(aA));

		assertEquals(a6, Numbers.shortFromBytes(b6));
		assertEquals(a7, Numbers.intFromBytes(b7));
		assertEquals(a8, Numbers.longFromBytes(b8));

		assertEquals(bB, Numbers.firstHalf(aB));
		assertEquals(cB, Numbers.secondHalf(aB));

		assertEquals(dB, Numbers.firstHalfValue(aB));
		assertEquals(eB, Numbers.secondHalfValue(aB));

		assertEquals(bC, Numbers.unsignedValue(aC));

		assertEquals(bD, Numbers.hexDump(Numbers.getBytes(aD)));
		assertEquals(cD, Numbers.decDump(Numbers.getBytes(aD)));
	}

}
