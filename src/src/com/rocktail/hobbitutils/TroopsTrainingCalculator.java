package com.rocktail.hobbitutils;

import com.rocktail.hobbitutilst.models.PlayerResources;

/**
 * Handles calculations that provide answer what troops to train to spend most of the resources  
 * @author rocktail
 *
 */
public class TroopsTrainingCalculator {
	private PlayerResources _playerResources;
	
	/**
	 * Creates new instance of {@link TroopsTrainingCalculator}
	 * @param playerResources
	 */
	public TroopsTrainingCalculator(PlayerResources playerResources) {
		this.setPlayerResources(playerResources);
	}

	/**
	 * Gets {@link PlayerResources}
	 * @return
	 */
	public PlayerResources getPlayerResources() {
		return this._playerResources;
	}

	/**
	 * Sets {@link PlayerResources}
	 * @param _playerResources
	 */
	private void setPlayerResources(PlayerResources _playerResources) {
		this._playerResources = _playerResources;
	}

}
