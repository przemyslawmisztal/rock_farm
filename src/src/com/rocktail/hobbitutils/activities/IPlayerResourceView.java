package com.rocktail.hobbitutils.activities;

/**
 * Interface for view in player resources UI component
 * @author rocktail
 *
 */
public interface IPlayerResourceView {
	/**
	 * Sets default value for amount
	 * @param resourceAmount
	 */
	void setAmount(long resourceAmount);
	
	/**
	 * Sets component title that is meant to be displayed to the user
	 * @param text
	 */
	void setResourceName(String text);
	
	/**
	 * Sets icon to display to the user
	 * @param iconName
	 */
	void setResourceIcon(String iconName);
}
