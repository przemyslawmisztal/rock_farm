package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.vos.UnitType;

/**
 * Contract for compound view displaying result of troops calculations
 * @author rocktail
 *
 */
public interface ITroopsAmountView {

	/**
	 * Assigns this tile to specific type of unit.
	 * It allows application to load correct icon and description from resource files 
	 * @param unitType
	 */
	public abstract void setUnitType(UnitType unitType);

	/**
	 * Sets amount of units to produce
	 * @param amount
	 */
	public abstract void setAmount(long amount);

}