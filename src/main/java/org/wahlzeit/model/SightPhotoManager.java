package org.wahlzeit.model;

public class SightPhotoManager extends PhotoManager{

	protected static final SightPhotoManager instance = new SightPhotoManager();

	public SightPhotoManager() {
		photoTagCollector = SightPhotoFactory.getInstance().createPhotoTagCollector();
	}

}