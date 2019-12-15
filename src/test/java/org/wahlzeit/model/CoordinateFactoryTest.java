package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateFactoryTest {

	@Test
	public void testValueObjects(){
		int len1=CoordinateFactory.getCoordinatesAmount();
		Coordinate c1 = CoordinateFactory.newCartesianCoordinate(7,8,9);
		int len2=CoordinateFactory.getCoordinatesAmount();
		Coordinate c2 = CoordinateFactory.newCartesianCoordinate(10,11,12);
		int len3=CoordinateFactory.getCoordinatesAmount();
		Coordinate c3 = CoordinateFactory.newCartesianCoordinate(10,11,12);
		int len4=CoordinateFactory.getCoordinatesAmount();
		//same Coordinate in spheric
		Coordinate c4 = CoordinateFactory.newSphericCoordinate(0.832981,0.891676,19.104973);
		int len5=CoordinateFactory.getCoordinatesAmount();
	

		assertEquals(len1+1,len2);
		assertEquals(len1+2,len3);
		//No additional object should be added, 1 in transformed
		assertEquals(len3,len4);
		assertEquals(len3,len5);

		//Coordinates are still interchangable
		assertFalse(c1.equals(c2));
		assertTrue(c2.equals(c3));
		assertTrue(c2.equals(c4));
	}

}