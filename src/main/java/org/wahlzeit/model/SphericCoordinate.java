package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{
	private double phi, theta, radius;

	public SphericCoordinate(){
		setCoordinates(0.0,0.0,0.0);
	}

	public SphericCoordinate(double phi, double theta, double radius){
		setCoordinates(phi,theta,radius);
	}

	public void setCoordinates(double phi, double theta, double radius){
		setPhi(phi);
		setTheta(theta);
		setRadius(radius);
	}
	
	public double getPhi(){
		assertClassInvariants();
		return phi;
	}
	public double getTheta(){
		assertClassInvariants();
		return this.theta;
	}
	public double getRadius(){
		assertClassInvariants();
		return this.radius;
	}
	public void setPhi(double newPhi){
		assert 0 <= newPhi && newPhi <= Math.PI;
		this.phi=newPhi;
		assertClassInvariants();
	}
	public void setTheta(double newTheta){
		assert 0 <= newTheta && newTheta <= 2 * Math.PI;
		this.theta=newTheta;
		assertClassInvariants();
	}
	public void setRadius(double newRadius){
		assert newRadius >= 0;
		this.radius=newRadius;
		assertClassInvariants();
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate(){
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	protected double doGetCartesianDistance(Coordinate coord){
		return asCartesianCoordinate().getCartesianDistance(coord);
	}

	@Override
	protected SphericCoordinate doAsSphericCoordinate(){
		return this;
	}

	@Override
	protected double doGetCentralAngle(Coordinate coord){
		SphericCoordinate c = coord.asSphericCoordinate();
		return Math.acos(Math.sin(theta)*Math.sin(c.getTheta()) + Math.cos(theta)*Math.cos(c.getTheta())*Math.cos(Math.abs(phi-c.getPhi())));
	}

	@Override
	protected boolean doIsEqual(Coordinate coord){
		return asCartesianCoordinate().isEqual(coord);
	}

	@Override
	public void assertClassInvariants(){
		assertNotNull(phi);
		assertNotNull(theta);
		assertNotNull(radius);

		assert 0 <= phi && phi <= Math.PI;
		assert 0 <= theta && theta <= 2 * Math.PI;
		assert radius >= 0;
	}
}