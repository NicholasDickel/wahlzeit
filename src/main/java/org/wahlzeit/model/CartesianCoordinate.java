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
		assertClassInvariants();
		return x;
	}
	public double getY(){
		assertClassInvariants();
		return y;
	}
	public double getZ(){
		assertClassInvariants();
		return z;
	}
	public void setX(double newX){
		assertNotNull(newX);
		this.x=newX;
		assertClassInvariants();
	}
	public void setY(double newY){
		assertNotNull(newY);
		this.y=newY;
		assertClassInvariants();
	}
	public void setZ(double newZ){
		assertNotNull(newZ);
		this.z=newZ;
		assertClassInvariants();
	}

	private double getDistance(CartesianCoordinate coord){
		return Math.sqrt(Math.pow(this.getX() - coord.getX(), 2) + Math.pow(this.getY() - coord.getY(), 2) + Math.pow(this.getZ() - coord.getZ(), 2));
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate(){
		return this;
	}

	@Override
	protected SphericCoordinate doAsSphericCoordinate(){
		CartesianCoordinate ground=new CartesianCoordinate(0,0,0);
		double radius=getDistance(ground);
		double theta=Math.acos(z/radius);
		double phi=Math.asin(y/(Math.sqrt((x*x)+(y*y))));
		return new SphericCoordinate(phi,theta,radius);

	}

	@Override
	protected double doGetCartesianDistance(Coordinate coord){
		CartesianCoordinate c = coord.asCartesianCoordinate();
		return getDistance(c);
	}

	@Override
	protected double doGetCentralAngle(Coordinate coord){
		return asSphericCoordinate().getCentralAngle(coord);
	}

	@Override
	protected boolean doIsEqual(Coordinate c){
		CartesianCoordinate coord = c.asCartesianCoordinate();
		double eps=1e-5;
		if(Math.abs(this.getX()-coord.getX())<eps && Math.abs(this.getY()-coord.getY())<eps && Math.abs(this.getZ()-coord.getZ())<eps){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void assertClassInvariants(){
		assertNotNull(x);
		assertNotNull(y);
		assertNotNull(z);
	}

}