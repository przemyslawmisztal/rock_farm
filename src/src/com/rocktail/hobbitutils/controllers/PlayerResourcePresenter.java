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
	private PlayerResource _model;
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
		this._model.setAmount(amount);
	}
	
	/**
	 * Initializes resource and view
	 * @param resourceType
	 */
	public void initPlayerResource(ResourceType resourceType) {
		this._model = new PlayerResource();
		
		this._model.setResourceType(resourceType);
		this._model.setAmount(this._ZERO_AMOUNT);
		
		setView();
	}
	
	/**
	 * Updates view with new values
	 */
	private void setView() {
		this._view.setAmount(this._model.getAmount());
		this._view.setResource(this._model.getResourceType());
	}
}
