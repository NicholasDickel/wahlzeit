package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

	@Test
	public void testEqualsCartesian() {
		Coordinate c1 = new CartesianCoordinate(2.453,6.123,2.435);
		assertTrue(c1.equals(c1));
		Coordinate c2 = new CartesianCoordinate(2.453,6.123,2.435);
		assertTrue(c1.equals(c2));
		Coordinate c3 = new CartesianCoordinate(3.511,4.521,7.352);
		assertFalse(c1.equals(c3));
	}

	@Test
	public void testEqualsSpheric() {
		Coordinate c1 = new SphericCoordinate(0.8,0.8,3);
		assertTrue(c1.equals(c1));
		Coordinate c2 = new SphericCoordinate(0.8,0.8,3);
		assertTrue(c1.equals(c2));
		Coordinate c3 = new SphericCoordinate(0.9,0.6,2);
		assertFalse(c1.equals(c3));
	}

	@Test
	public void testEqualsMixed() {
		CartesianCoordinate c1 = new CartesianCoordinate(4,5,6);
		SphericCoordinate c2 = new SphericCoordinate(0.896055,0.817888,8.774964);
		assertTrue(c1.equals(c2));
	}


	@Test
	public void testDistanceCartesian() {
		CartesianCoordinate c1 = new CartesianCoordinate(1,2,3);
		CartesianCoordinate c2 = new CartesianCoordinate(3,5,7);
		assertEquals(5.3851648,c1.getCartesianDistance(c2),1e-7);
	}

	@Test
	public void testCoordinateConversion() {
		CartesianCoordinate c1 = new CartesianCoordinate(1,2,3);
		SphericCoordinate c2 = c1.asSphericCoordinate();

		SphericCoordinate c3 = new SphericCoordinate(0.8,0.8,3);
		CartesianCoordinate c4 = c3.asCartesianCoordinate();

		assertTrue(c1.equals(c2));
		assertTrue(c3.equals(c4));

		//Convert twice
		CartesianCoordinate c5 = c2.asCartesianCoordinate();
		SphericCoordinate c6 = c4.asSphericCoordinate();
				
		assertTrue(c1.equals(c5));
		assertTrue(c3.equals(c6));

	}

	@Test
	public void testIllegalArguments(){
		CartesianCoordinate c = new CartesianCoordinate(1,2,3);
		SphericCoordinate s = new SphericCoordinate(0.8,0.8,3);

		try {
			c.assertClassInvariants();
		} 
		catch(Exception e) {
			assertTrue(false);
		}

		try {
			s.assertClassInvariants();
		} 
		catch(Exception e) {
			assertTrue(false);
		}
		
		//exception wanted!
		try {
			s.setPhi(-1);
			assertTrue(false);
		} 
		catch(AssertionError ae) {}		

		try {
			s.setTheta(-1);
			assertTrue(false);
		} 
		catch(AssertionError ae) {}	

		try {
			s.setRadius(-1);
			assertTrue(false);
		} 
		catch(AssertionError ae) {}	

		try{
			c.assertNotNull(null);
			assertTrue(false);
		}
		catch(NullPointerException ne) {}
		
	}


	
}