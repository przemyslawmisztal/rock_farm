package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.controllers.ITroopsTrainingResultPresenter;

public interface ITroopsTrainingResultView {
	/**
	 * Sets foot units amount
	 * @param _footUnits
	 */
	public abstract void setFootUnits(long amount);

	/**
	 * Sets ranged units amount
	 * @param _rangedUnits
	 */
	public abstract void setRangedUnits(long amount);

	/**
	 * Sets mounted units amount
	 * @param amount
	 */
	public abstract void setMountedUnits(long amount);

	/**
	 * Sets presenter for troops training result compound view
	 * @param presenter
	 */
	public abstract void setPresenter(ITroopsTrainingResultPresenter presenter);
}