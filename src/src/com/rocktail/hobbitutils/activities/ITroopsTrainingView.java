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
	
	/**
	 * Sets amount of food resource
	 * @param foodAmount
	 */
	public abstract void setFoodResource(long foodAmount);

	/**
	 * Sets amount of wood resource
	 * @param foodAmount
	 */	
	public abstract void setWoodResource(long woodAmount);
	
	/**
	 * Sets amount of stone resource
	 * @param foodAmount
	 */	
	public abstract void setStoneResource(long stoneAmount);
	
	/**
	 * Sets amount of ore resource
	 * @param foodAmount
	 */	
	public abstract void setOreResource(long oreAmount);
}