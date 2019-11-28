package org.wahlzeit.model;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractCoordinate implements Coordinate{

	public CartesianCoordinate asCartesianCoordinate(){
		//Preconditions
		assertClassInvariants();

		//do
		CartesianCoordinate coord = doAsCartesianCoordinate();

		//Postconditions
		assertClassInvariants();
		coord.assertClassInvariants();

		return coord;
	}
	public double getCartesianDistance(Coordinate c){
		//Preconditions
		assertNotNull(c);

		assertClassInvariants();
		c.assertClassInvariants();

		//do
		double distance = doGetCartesianDistance(c);

		//Postconditions
		assert distance >= 0;

		assertClassInvariants();
		c.assertClassInvariants();

		return distance;
	}
	public SphericCoordinate asSphericCoordinate(){
		//Preconditions
		assertClassInvariants();

		//do
		SphericCoordinate coord = doAsSphericCoordinate();

		//Postconditions
		assertNotNull(coord);

		assertClassInvariants();
		coord.assertClassInvariants();

		return coord;
	}
	public double getCentralAngle(Coordinate c){
		//Preconditions
		assertNotNull(c);

		assertClassInvariants();
		c.assertClassInvariants();

		//do
		double angle = doGetCentralAngle(c);

		//Postconditions
		assert 0 <= angle && angle <= 2*Math.PI;

		assertClassInvariants();
		c.assertClassInvariants();

		return angle;
	}
	public boolean isEqual(Coordinate c){
		//Preconditions
		assertNotNull(c);

		assertClassInvariants();
		c.assertClassInvariants();

		//do
		boolean eq = doIsEqual(c);

		//Postconditions
		assertClassInvariants();
		c.assertClassInvariants();

		return eq;
	}

	public abstract CartesianCoordinate doAsCartesianCoordinate();
	public abstract double doGetCartesianDistance(Coordinate c);
	public abstract SphericCoordinate doAsSphericCoordinate();
	public abstract double doGetCentralAngle(Coordinate c);
	public abstract boolean doIsEqual(Coordinate c);


	//Design by Contract
	protected abstract void assertClassInvariants();

	@Override
	public boolean equals(Object o){
		if (o==this){
			return true;
		}
		if (!(o instanceof Coordinate)){
			return false;
		}
		Coordinate c = (Coordinate) o;
		return isEqual(c);

	}

}