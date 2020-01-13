package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import java.util.logging.Logger;
import org.wahlzeit.model.PatternInstance;

@PatternInstance(
	patternName="Abstract Factory",
	participants={"AbstractFactory","ConcreteFactory"}
)
public class SightPhotoFactory extends PhotoFactory{

	private static final Logger log = Logger.getLogger(SightPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static SightPhotoFactory instance = null;

	/**
	 *
	 */
	protected SightPhotoFactory() {
		// do nothing
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized SightPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting SightPhotoFactory").toString());
			setInstance(new SightPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(SightPhotoFactory photoFactory) throws NullPointerException{
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public SightPhoto createPhoto() {
		return new SightPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public SightPhoto createPhoto(PhotoId id) throws NullPointerException {
		return new SightPhoto(id);
	}

}
