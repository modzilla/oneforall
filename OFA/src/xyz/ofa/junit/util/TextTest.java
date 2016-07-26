/**
 * 
 */
package xyz.ofa.junit.util;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import xyz.ofa.util.Numbers;
import xyz.ofa.util.Text;

/**
 * @author lauch
 *
 */
public class TextTest {

	private String ascii_test_string = "Hello, I'm OFA!";
	private String utf_test_string = "Hello, I'm \u07C0\u2131\u15C5";

	private byte[] ascii_bytes = new byte[] { 72, 101, 108, 108, 111, 44, 32, 73, 39, 109, 32, 79, 70, 65, 33 };
	private byte[] utf_bytes = new byte[] { 72, 101, 108, 108, 111, 44, 32, 73, 39, 109, 32, (byte) 223, (byte) 128,
			(byte) 226, (byte) 132, (byte) 177, (byte) 225, (byte) 151, (byte) 133 };

	@Test
	public void test() throws UnsupportedEncodingException {
		assertArrayEquals(ascii_bytes, Text.toBytes(ascii_test_string, Text.ASCII));
		assertArrayEquals(utf_bytes, Text.toBytes(utf_test_string, Text.UTF8));
	}
}
