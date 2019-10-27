package org.wahlzeit.model;

public class Location{
	public Coordinate coordinate;

	public Location(){
		this.coordinate=new Coordinate();
	}
	public Location(double x, double y, double z){
		setCoordinate(x,y,z);
	}
	public Location(Coordinate coords){
		setCoordinate(coords);
	}

	private void setCoordinate(Coordinate coords){
		this.coordinate=coords;
	}
	private void setCoordinate(double x, double y, double z){
		this.coordinate=new Coordinate(x,y,z);
	}
}