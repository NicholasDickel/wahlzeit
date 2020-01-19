package org.wahlzeit.model;

public class Sight{

	protected String sightName; // e.g. Notre-Dame, Loch Ness, Golden Gate Bridge, ...
	protected SightType sightType;
	protected Location location;

	public Sight(String sn, SightType st){
		sightName=sn;
		sightType=st;
	}
	public Sight(String sn, SightType st, Location loc){
		sightName=sn;
		sightType=st;
		location=loc;
	}
	public String getName(){
		return sightName;
	}
	public SightType getType(){
		return sightType;
	}
	public Location getLocation(){
		return location;
	}
	public void setName(String sn){
		sightName=sn;
	}
	public void setType(SightType st){
		sightType=st;
	}
	public void setLocation(Location l){
		location=l;
	}
}