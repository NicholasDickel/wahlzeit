package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

	public abstract CartesianCoordinate asCartesianCoordinate();
	public abstract double getCartesianDistance(Coordinate c);
	public abstract SphericCoordinate asSphericCoordinate();
	public abstract double getCentralAngle(Coordinate c);
	public abstract boolean isEqual(Coordinate c);

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