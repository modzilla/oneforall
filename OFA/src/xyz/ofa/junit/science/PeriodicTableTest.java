/**
 * 
 */
package xyz.ofa.junit.science;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.ofa.science.element.PeriodicTable;

/**
 * @author lauch
 *
 */
public class PeriodicTableTest {

	private int num_elements = 119;	
	@Test
	public void test() {
		PeriodicTable p = PeriodicTable.getInstance();
		assertEquals(num_elements, p.getAllElements().size());
	}

}
