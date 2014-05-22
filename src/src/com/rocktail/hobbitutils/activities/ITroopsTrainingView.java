package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.controllers.TroopsTrainingResourcesPresenter;

public interface ITroopsTrainingView {

	public abstract void setPresenter(TroopsTrainingResourcesPresenter presenter);

	/**
	 * Gets amount of food resource provided by user
	 * @return
	 */
	public abstract long getFoodResource();

	/**
	 * Gets amount of wood resource provided by user
	 * @return
	 */
	public abstract long getWoodResource();

	/**
	 * Gets amount of stone resource provided by user
	 * @return
	 */
	public abstract long getStoneResource();

	/**
	 * Gets amount of ore resource provided by user
	 * @return
	 */
	public abstract long getOreResource();
}