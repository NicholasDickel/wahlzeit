package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LocationTest {

	@Test
	public void testSetup() {
		double eps=1e-15;

		CartesianCoordinate coord1 = new CartesianCoordinate(1.0, 2.0, 3.0);
		SphericCoordinate coord2 = new SphericCoordinate(0.8, 0.8, 3);
		Location loc1 = new Location(coord1);
		Location loc2 = new Location(coord2);

		assertTrue(loc1.coordinate instanceof CartesianCoordinate);
		assertTrue(loc2.coordinate instanceof SphericCoordinate);


	}
}