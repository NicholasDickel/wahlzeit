package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

	public CartesianCoordinate asCartesianCoordinate() throws NullPointerException{
		//Preconditions
		assertClassInvariants();

		//do
		CartesianCoordinate coord = doAsCartesianCoordinate();

		//Postconditions
		assertClassInvariants();
		coord.assertClassInvariants();

		return coord;
	}
	public double getCartesianDistance(Coordinate c) throws NullPointerException{
		//Preconditions
		assertNotNull(c);

		assertClassInvariants();

		//do
		double distance = doGetCartesianDistance(c);

		//Postconditions
		assert distance >= 0;

		assertClassInvariants();

		return distance;
	}
	public SphericCoordinate asSphericCoordinate() throws NullPointerException{
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
	public double getCentralAngle(Coordinate c) throws NullPointerException{
		//Preconditions
		assertNotNull(c);

		assertClassInvariants();

		//do
		double angle = doGetCentralAngle(c);

		//Postconditions
		assert 0 <= angle && angle <= 2*Math.PI;

		assertClassInvariants();

		return angle;
	}
	public boolean isEqual(Coordinate c) throws NullPointerException{
		//Preconditions
		assertNotNull(c);

		assertClassInvariants();

		//do
		boolean eq = doIsEqual(c);

		//Postconditions
		assertClassInvariants();

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