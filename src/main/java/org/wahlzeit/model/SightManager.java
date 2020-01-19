package org.wahlzeit.model;

import java.util.Map;
import java.util.HashMap;

public class SightManager{

	protected static SightManager instance;

	protected Map<String, Sight> sightCache = new HashMap<String, Sight>();
	protected Map<String, SightType> sightTypeCache = new HashMap<String, SightType>();

	private SightManager(){}

	public static SightManager getInstance(){
		if (SightManager.instance == null){
			SightManager.instance = new SightManager();
		}
		return SightManager.instance;
	}

	public Sight createSight(String name, String typeName){
		SightType st=getSightType(typeName);
		Sight result = st.createInstance(name);
		sightCache.put(result.getName(),result);
		return result;
	}
	public Sight createSight(String name, String typeName, Location loc){
		SightType st=getSightType(typeName);
		Sight result = st.createInstance(name,loc);
		sightCache.put(result.getName(),result);
		return result;
	}

	public SightType getSightType(String typeName){
		if (sightTypeCache.containsKey(typeName)){
			return sightTypeCache.get(typeName);
		}else{
			SightType st = new SightType(typeName);
			sightTypeCache.put(typeName,st);
			return st;
		}
	}

	public void makeTypeConnection(SightType supertype, SightType subtype){
		supertype.addSubType(subtype);
		subtype.setSuperType(supertype);
	}

	public int getNrSights(){
		return sightCache.size();
	}
	public int getNrTypes(){
		return sightTypeCache.size();
	}
}