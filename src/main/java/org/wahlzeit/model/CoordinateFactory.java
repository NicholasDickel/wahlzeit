package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;
import org.wahlzeit.model.PatternInstance;

@PatternInstance(
	patternName="Abstract Factory",
	participants={"AbstractFactory","ConcreteFactory"}
)
public class CoordinateFactory{
	//the two lists are always the same length. 
	private static List<SphericCoordinate> sphericCoordinates = new ArrayList<SphericCoordinate>();
	private static List<CartesianCoordinate> cartesianCoordinates = new ArrayList<CartesianCoordinate>();

	public static CartesianCoordinate newCartesianCoordinate(double x, double y, double z){
		CartesianCoordinate newCoord = new CartesianCoordinate(x,y,z);
		CartesianCoordinate oldCoord = cartesianCoordinates.stream().filter(coordinate -> newCoord.equals(coordinate)).findAny().orElse(null);
		
		if(oldCoord == null){
			cartesianCoordinates.add(newCoord);
			//this will generate sphericCoordinates entry
			newCoord.asSphericCoordinate();
			return newCoord;
		}else{
			return oldCoord;
		}
	}

	public static SphericCoordinate newSphericCoordinate(double phi, double theta, double radius){
		SphericCoordinate newCoord = new SphericCoordinate(phi,theta,radius);
		SphericCoordinate oldCoord = sphericCoordinates.stream().filter(coordinate -> newCoord.equals(coordinate)).findAny().orElse(null);
		if(oldCoord == null){
			sphericCoordinates.add(newCoord);
			//this will generate cartesianCoordinates entry
			newCoord.asCartesianCoordinate();
			return newCoord;
		}else{
			return oldCoord;
		}
	}

	public static int getCoordinatesAmount(){
		assert cartesianCoordinates.size() == sphericCoordinates.size();
		return cartesianCoordinates.size();
	}

}