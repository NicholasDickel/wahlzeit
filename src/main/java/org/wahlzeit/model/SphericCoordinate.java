package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
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
		return this.phi;
	}
	public double getTheta(){
		return this.theta;
	}
	public double getRadius(){
		return this.radius;
	}
	public void setPhi(double phi){
		this.phi=phi;
	}
	public void setTheta(double theta){
		this.theta=theta;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate(){
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public double getCartesianDistance(Coordinate coord){
		return asCartesianCoordinate().getCartesianDistance(coord);
	}

	@Override
	public SphericCoordinate asSphericCoordinate(){
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coord){
		SphericCoordinate c = coord.asSphericCoordinate();
		return Math.acos(Math.sin(theta)*Math.sin(c.getTheta()) + Math.cos(theta)*Math.cos(c.getTheta())*Math.cos(Math.abs(phi-c.getPhi())));
	}

	@Override
	public boolean isEqual(Coordinate coord){
		return asCartesianCoordinate().isEqual(coord);
	}

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