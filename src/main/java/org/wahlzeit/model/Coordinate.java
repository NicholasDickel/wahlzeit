package org.wahlzeit.model;

public class Coordinate{

	private double x, y, z;

	public Coordinate(){
		setCoordinates(0.0,0.0,0.0);
	}

	public Coordinate(double x, double y, double z){
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

	public double getDistance(Coordinate coord){
		return Math.sqrt(Math.pow(this.getX() - coord.getX(), 2) + Math.pow(this.getY() - coord.getY(), 2) + Math.pow(this.getZ() - coord.getZ(), 2));
	}

	public boolean isEqual(Coordinate coord){
		double eps=1e-5;
		if(Math.abs(this.getX()-coord.getX())<eps && Math.abs(this.getY()-coord.getY())<eps && Math.abs(this.getZ()-coord.getZ())<eps){
			return true;
		}
		else{
			return false;
		}
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