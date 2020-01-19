package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.PatternInstance;

@PatternInstance(
	patternName="Abstract Factory",
	participants={"AbstractFactory","ConcreteFactory"}
)
@Entity
public class SightPhoto extends Photo{

	private Sight sight;

	public SightPhoto(){
		super();
	}
	public SightPhoto(PhotoId myId){
		super(myId);
	}

	public Sight getSight(){
		return sight;
	}

	public void setSight(Sight s) throws NullPointerException{
		sight=s;
	}
}