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
	 * Sets icon to display to the user
	 * @param iconName
	 */
	void setResource(ResourceType resourceType);
	
	/**
	 * Gets {@link ResourceType} this compound view is representing
	 * @return
	 */
	ResourceType getResourceType();
	
	/**
	 * Gets user entered amount
	 * @return
	 */
	long getAmount();
}
