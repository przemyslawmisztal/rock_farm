package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.vos.ResourceType;

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
	void setResourceIcon(ResourceType resourceType);
}
