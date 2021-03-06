package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	PersistenceTestSuite.class,
	AccessRightsTest.class,
	CoordinateTest.class,
	CoordinateFactoryTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	LocationTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	TypeObjectTest.class,
	UserStatusTest.class,
	ValueTest.class,
})

public class ModelTestSuite {   
}  	
