package org.wahlzeit.model;

public final class SphericCoordinate extends AbstractCoordinate{
	private final double phi, theta, radius;

	public SphericCoordinate(double phi, double theta, double radius){
		try{
			assert 0 <= phi && phi <= Math.PI;
			assert 0 <= theta && theta <= 2 * Math.PI;
			assert radius >= 0;
			this.phi=phi;
			this.theta=theta;
			this.radius=radius;
			assertClassInvariants();
		}catch(NullPointerException e){
			throw new IllegalArgumentException();
		}catch(AssertionError ae){
			throw new IllegalArgumentException();
		}
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

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate(){
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		return CoordinateFactory.newCartesianCoordinate(x,y,z);
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
	protected boolean doIsEqual(Coordinate c){
		SphericCoordinate coord = c.asSphericCoordinate();
		double eps=1e-5;
		if(Math.abs(this.getPhi()-coord.getPhi())<eps && Math.abs(this.getTheta()-coord.getTheta())<eps && Math.abs(this.getRadius()-coord.getRadius())<eps){
			return true;
		}
		else{
			return false;
		}
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