package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutils.utils.AppConfigReader;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

public class TroopsTrainingController {

	private PlayerResources _playerResources;
	private TroopsTrainingCalculationResult _troopsTrainingCalculationResult;
	
	private String _VALIDATE_ERROR = "Invalid user input - provided negative resource amount";
	
	public TroopsTrainingController(PlayerResources playerResources,
			TroopsTrainingCalculationResult troopsTrainingCalculationResult) {
		this.setPlayerResources(playerResources);
		this.setTroopsTrainingCalculationResult(troopsTrainingCalculationResult);
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
	
	/**
	 * Call to pass user input for processing
	 * @param foodAmount
	 * @param woodAmount
	 * @param stoneAmount
	 * @param oreAmount
	 */
	public void handleUserInput(long foodAmount,
									 long woodAmount,
									 long stoneAmount,
									 long oreAmount) {
		if (!ValidateUserInput(foodAmount, woodAmount, stoneAmount, oreAmount)) {
			throw new java.lang.IllegalArgumentException(this._VALIDATE_ERROR);
		}
		
		this._playerResources.setFood(foodAmount);
		this._playerResources.setWood(woodAmount);
		this._playerResources.setStone(stoneAmount);
		this._playerResources.setOre(oreAmount);
	}
	
	/**
	 * Delegates calculation task to proper service and updated model with the result
	 */
	public void handleTroopsCalculations() {
		TroopsTrainingCalculator calc = new TroopsTrainingCalculator(this._playerResources, AppConfigReader.getHobbitConfiguration());
		
		TroopsTrainingCalculationResult res = calc.CalculateBestT1TroopsTraining();
		
		this._troopsTrainingCalculationResult.setFootTroopsAmount(res.getFootTroopsAmount());
		this._troopsTrainingCalculationResult.setMountedTroopsAmount(res.getMountedTroopsAmount());
		this._troopsTrainingCalculationResult.setRangedTroopsAmount(res.getRangedTroopsAmount());
	}

	public TroopsTrainingCalculationResult getTroopsTrainingCalculationResult() {
		return this._troopsTrainingCalculationResult;
	}

	public void setTroopsTrainingCalculationResult(
			TroopsTrainingCalculationResult troopsTrainingCalculationResult) {
		this._troopsTrainingCalculationResult = troopsTrainingCalculationResult;
	}

}
