package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutilst.models.PlayerResources;

public class TroopsTrainingController {

	private PlayerResources _playerResources;
	
	public TroopsTrainingController(PlayerResources playerResources) {
		this.setPlayerResources(playerResources);
	}
	
	/**
	 * What we need is to make sure that user didn't input negative resources amount 
	 * @param foodAmount
	 * @param woodAmount
	 * @param stoneAmount
	 * @param oreAmount
	 * @return
	 */
	public boolean ValidateUserInput(long foodAmount,
									 long woodAmount,
									 long stoneAmount,
									 long oreAmount) {
		
	return foodAmount >= 0 
			&&
		   woodAmount >= 0
		   	&&
		   stoneAmount >= 0
		   	&&
		   oreAmount >= 0;
	}

	public PlayerResources getPlayerResources() {
		return _playerResources;
	}

	private void setPlayerResources(PlayerResources _playerResources) {
		this._playerResources = _playerResources;
	}

}
