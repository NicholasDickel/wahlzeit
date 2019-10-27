package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocationTest {

	@Test
	public void setupTest() {
		double eps=1e-15;
		Location loc = new Location();
		assertEquals(0.0, loc.coordinate.getX(),eps);
		assertEquals(0.0, loc.coordinate.getY(),eps);
		assertEquals(0.0, loc.coordinate.getZ(),eps);

		Location loc2 = new Location(1.0, 2.0, 3.0);
		assertEquals(1.0, loc2.coordinate.getX(),eps);
		assertEquals(2.0, loc2.coordinate.getY(),eps);
		assertEquals(3.0, loc2.coordinate.getZ(),eps);

		Coordinate coord = new Coordinate(1.0, 2.0, 3.0);
		Location loc3 = new Location(coord);
		assertEquals(1.0, loc3.coordinate.getX(),eps);
		assertEquals(2.0, loc3.coordinate.getY(),eps);
		assertEquals(3.0, loc3.coordinate.getZ(),eps);

	}
}