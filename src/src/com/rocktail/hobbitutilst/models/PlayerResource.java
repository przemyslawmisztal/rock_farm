package com.rocktail.hobbitutilst.models;

import com.rocktail.hobbitutils.vos.ResourceType;

/**
 * Class contains properties of single resource
 * @author rocktail
 *
 */
public class PlayerResource {
	private ResourceType _resourceType;
	private long _amount;
	
	/**
	 * Gets {@link ResourceType}
	 * @return
	 */
	public ResourceType getResourceType() {
		return _resourceType;
	}
	
	/**
	 * Sets {@link ResourceType}
	 * @param _resourceType
	 */
	public void setResourceType(ResourceType _resourceType) {
		this._resourceType = _resourceType;
	}
	
	/**
	 * Gets owned amount of current resource
	 * @return
	 */
	public long getAmount() {
		return _amount;
	}
	
	/**
	 * Sets amount of current resource
	 * @param _amount
	 */
	public void setAmount(long _amount) {
		this._amount = _amount;
	}
}
