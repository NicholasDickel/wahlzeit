package org.wahlzeit.model;

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

	protected abstract CartesianCoordinate doAsCartesianCoordinate();
	protected abstract double doGetCartesianDistance(Coordinate c);
	protected abstract SphericCoordinate doAsSphericCoordinate();
	protected abstract double doGetCentralAngle(Coordinate c);
	protected abstract boolean doIsEqual(Coordinate c);


	//Design by Contract
	public abstract void assertClassInvariants();

	protected void assertNotNull(Object o) throws NullPointerException{
		if(o==null){
			throw new NullPointerException();
		}
	}

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