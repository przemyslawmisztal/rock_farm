package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutilst.models.PlayerResources;

public class TroopsTrainingController extends ControllerBase {

	private PlayerResources _playerResources;
	
	public TroopsTrainingController(PlayerResources playerResources) {
		this._playerResources = playerResources;
	}
	@Override
	public boolean handleMessage(int what, Object data) {
		// TODO Auto-generated method stub
		return false;
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
		
		return false;
	}

}
