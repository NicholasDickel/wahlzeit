package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TypeObjectTest {

	@Test
	public void testObjectCreation() {
		SightManager sm = SightManager.getInstance();
		int nrSights = sm.getNrSights();
		int nrTypes = sm.getNrTypes();
		Sight s1 = sm.createSight("Eiffel Tower","Tower");
		Sight s2 = sm.createSight("Loch Ness","Lake");
		Sight s3 = sm.createSight("Tokyo Skytree","Tower");
		assertEquals(sm.getNrSights()-nrSights,3);
		assertEquals(sm.getNrTypes()-nrTypes,2);
	}

	@Test
	public void testHirarchy() {
		SightManager sm = SightManager.getInstance();
		SightType top=sm.getSightType("Architecture");
		SightType middle1=sm.getSightType("Bridge");
		SightType middle2=sm.getSightType("Cathedral");
		SightType bottom1=sm.getSightType("Arch Bridge");
		SightType bottom2=sm.getSightType("Truss Bridge");
		sm.makeTypeConnection(top,middle1);
		sm.makeTypeConnection(top,middle2);
		sm.makeTypeConnection(middle1,bottom1);
		sm.makeTypeConnection(middle1,bottom2);
		Sight sight = sm.createSight("Lake Pontchartrain Causeway","Bridge");

		assertTrue(top.hasInstance(sight));
		assertTrue(middle1.hasInstance(sight));

		assertFalse(middle2.hasInstance(sight));
		assertFalse(bottom1.hasInstance(sight));
		assertFalse(bottom2.hasInstance(sight));

		assertTrue(middle1.isSubtype(top));
		assertTrue(middle2.isSubtype(top));
		assertTrue(bottom1.isSubtype(top));
		assertTrue(bottom2.isSubtype(top));
		assertTrue(bottom1.isSubtype(middle1));
		assertTrue(bottom2.isSubtype(middle1));

		assertFalse(top.isSubtype(middle1));
		assertFalse(top.isSubtype(middle2));
		assertFalse(top.isSubtype(bottom1));
		assertFalse(top.isSubtype(bottom2));
		assertFalse(middle2.isSubtype(middle1));
		assertFalse(middle1.isSubtype(middle2));
		assertFalse(bottom1.isSubtype(middle2));
		assertFalse(bottom2.isSubtype(middle2));

		assertFalse(middle1.isSupertype(top));
		assertFalse(middle2.isSupertype(top));
		assertFalse(bottom1.isSupertype(top));
		assertFalse(bottom2.isSupertype(top));
		assertFalse(bottom1.isSupertype(middle1));
		assertFalse(bottom2.isSupertype(middle1));
		assertFalse(middle2.isSupertype(middle1));
		assertFalse(middle1.isSupertype(middle2));
		assertFalse(bottom1.isSupertype(middle2));
		assertFalse(bottom2.isSupertype(middle2));
		assertFalse(middle2.isSupertype(bottom1));
		assertFalse(middle2.isSupertype(bottom2));

		assertTrue(top.isSupertype(middle1));
		assertTrue(top.isSupertype(middle2));
		assertTrue(top.isSupertype(bottom1));
		assertTrue(top.isSupertype(bottom2));
		assertTrue(middle1.isSupertype(bottom1));
		assertTrue(middle1.isSupertype(bottom2));
		


	}
}