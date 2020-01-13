package org.wahlzeit.model;

import org.wahlzeit.model.PatternInstance;

@PatternInstance(
	patternName="Value Object",
	participants={"Value Object"}
)
public final class CartesianCoordinate extends AbstractCoordinate{

	private final double x, y, z;

	public CartesianCoordinate(double x, double y, double z){
		try{
			this.x=x;
			this.y=y;
			this.z=z;
			assertClassInvariants();
		}catch(NullPointerException npe){
			throw new IllegalArgumentException();
		}catch(AssertionError ae){
			throw new IllegalArgumentException();
		}
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
	

	private double getDistance(CartesianCoordinate coord){
		return Math.sqrt(Math.pow(this.getX() - coord.getX(), 2) + Math.pow(this.getY() - coord.getY(), 2) + Math.pow(this.getZ() - coord.getZ(), 2));
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate(){
		return this;
	}

	@Override
	protected SphericCoordinate doAsSphericCoordinate(){
		//ground is just a helper, so no need to use the factory here
		CartesianCoordinate ground=new CartesianCoordinate(0,0,0);
		double radius=getDistance(ground);
		double theta=Math.acos(z/radius);
		double phi=Math.asin(y/(Math.sqrt((x*x)+(y*y))));
		return CoordinateFactory.newSphericCoordinate(phi,theta,radius);

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