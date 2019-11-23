package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

	private double x, y, z;

	public CartesianCoordinate(){
		setCoordinates(0.0,0.0,0.0);
	}

	public CartesianCoordinate(double x, double y, double z){
		setCoordinates(x,y,z);
	}

	public void setCoordinates(double x, double y, double z){
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getZ(){
		return this.z;
	}
	public void setX(double x){
		this.x=x;
	}
	public void setY(double y){
		this.y=y;
	}
	public void setZ(double z){
		this.z=z;
	}

	public double getDistance(CartesianCoordinate coord){
		return Math.sqrt(Math.pow(this.getX() - coord.getX(), 2) + Math.pow(this.getY() - coord.getY(), 2) + Math.pow(this.getZ() - coord.getZ(), 2));
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate(){
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate(){
		CartesianCoordinate ground=new CartesianCoordinate(0,0,0);
		double radius=getDistance(ground);
		double theta=Math.acos(z/radius);
		double phi=Math.asin(y/(Math.sqrt((x*x)+(y*y))));
		return new SphericCoordinate(phi,theta,radius);

	}

	@Override
	public double getCartesianDistance(Coordinate coord){
		CartesianCoordinate c = coord.asCartesianCoordinate();
		return getDistance(c);
	}

	@Override
	public double getCentralAngle(Coordinate coord){
		return asSphericCoordinate().getCentralAngle(coord);
	}

	@Override
	public boolean isEqual(Coordinate c){
		CartesianCoordinate coord = c.asCartesianCoordinate();
		double eps=1e-5;
		if(Math.abs(this.getX()-coord.getX())<eps && Math.abs(this.getY()-coord.getY())<eps && Math.abs(this.getZ()-coord.getZ())<eps){
			return true;
		}
		else{
			return false;
		}
	}

	


}