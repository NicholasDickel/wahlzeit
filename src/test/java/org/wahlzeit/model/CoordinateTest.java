package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

	@Test
	public void testEquals() {
		Coordinate c1 = new Coordinate(2.453,6.123,2.435);
		assertTrue(c1.equals(c1));
		Coordinate c2 = new Coordinate(2.453,6.123,2.435);
		assertTrue(c1.equals(c2));
		Coordinate c3 = new Coordinate(3.511,4.521,7.352);
		assertFalse(c1.equals(c3));

	}

	@Test
	public void testDistance() {
		Coordinate c1 = new Coordinate(1,2,3);
		Coordinate c2 = new Coordinate(3,5,7);
		assertEquals(5.3851648,c1.getDistance(c2),1e-7);

	}
}