package org.wahlzeit.model;

public class Location{
	public Coordinate coordinate;

	public Location(Coordinate coords){
		setCoordinate(coords);
	}

	private void setCoordinate(Coordinate coords){
		this.coordinate=coords;
	}

}