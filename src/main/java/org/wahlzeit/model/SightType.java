package org.wahlzeit.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SightType{

	protected String type; // e.g. Cathedral, Lake, Bridge, ...
	protected SightType superType=null;
	protected Set<SightType> subTypes = new HashSet<SightType>();


	public SightType(String t){
		type=t;
	}

	public Sight createInstance(String sn){
		return new Sight(sn,this);
	}
	public Sight createInstance(String sn, Location loc){
		return new Sight(sn,this,loc);
	}

	public SightType getSuperType(){
		return superType;
	}
	public Iterator<SightType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	public void addSubType(SightType st){
		assert (st != null);
		if(subTypes.contains(st)){
			return;
		}
		subTypes.add(st);
	}
	public void setSuperType(SightType st){
		superType=st;
	}
	public boolean hasInstance(Sight s){
		assert (s != null);

		if (s.getType()==this){
			return true;
		}
		for (SightType type : subTypes){
			if(type.hasInstance(s)){
				return true;
			}
		}
		return false;
	}

	//Checks if this type object is a subtype of the argument st
	public boolean isSubtype(SightType st){
		assert (st != null);
		if(st==this){
			return true;
		}
		if (superType==null){
			return false;
		}else{
			return superType.isSubtype(st);
		}
	}

	//Checks if this type object is a supertype of the argument st
	public boolean isSupertype(SightType st){
		assert (st != null);
		if(st==this){
			return true;
		}
		for (SightType type : subTypes){
			if(type.isSupertype(st)){
				return true;
			}
		}
		return false;
	}
}