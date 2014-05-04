package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutils.activities.IPlayerResourceView;
import com.rocktail.hobbitutils.vos.ResourceType;
import com.rocktail.hobbitutilst.models.PlayerResource;

/**
 * Presenter for player resources compound view
 * @author rocktail
 *
 */
public class PlayerResourcePresenter {
	private IPlayerResourceView _view;
	private PlayerResource _playerResource;
	private long _ZERO_AMOUNT = 0;
	
	/**
	 * Constructor allows DI of view instance 
	 * @param view
	 */
	public PlayerResourcePresenter(IPlayerResourceView view) {
		this._view = view;
	}
	
	/**
	 * Sets new resource amount
	 * @param amount
	 */
	public void SavePlayerResource(long amount) {
		this.getPlayerResource().setAmount(amount);
	}
	
	/**
	 * Initialises resource and view
	 * @param resourceType
	 */
	public void initPlayerResource(ResourceType resourceType) {
		this.setPlayerResource(new PlayerResource());
		
		this.getPlayerResource().setResourceType(resourceType);
		this.getPlayerResource().setAmount(this._ZERO_AMOUNT);
		
		setView();
	}
	
	/**
	 * Updates view with new values
	 */
	private void setView() {
		this._view.setAmount(this.getPlayerResource().getAmount());
		this._view.setResource(this.getPlayerResource().getResourceType());
	}

	/**
	 * Gets {@link PlayerResource}
	 * @return
	 */
	public PlayerResource getPlayerResource() {
		return _playerResource;
	}

	/**
	 * Sets {@link PlayerResource}
	 * @param _playerResource
	 */
	private void setPlayerResource(PlayerResource _playerResource) {
		this._playerResource = _playerResource;
	}
}
