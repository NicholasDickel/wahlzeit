package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class SightPhoto extends Photo{

	private String sightName; // e.g. Notre-Dame, Loch Ness, Golden Gate Bridge, ...
	private String sightType; // e.g. Cathedral, Lake, Bridge, ...


	public SightPhoto(){
		super();
	}
	public SightPhoto(PhotoId myId){
		super(myId);
	}

	public String getSightName(){
		return sightName;
	}
	public String getSightType(){
		return sightType;
	}
	public void setSightName(String name){
		sightName=name;
	}
	public void setSightType(String type){
		sightType=type;
	}



}