package com.rocktail.hobbitutils.activities;

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

}