package com.rocktail.hobbitutils.controllers;

import android.content.Context;

import com.rocktail.hobbitutils.TroopsTrainingCalculator;
import com.rocktail.hobbitutils.activities.IMainActivity;
import com.rocktail.hobbitutils.activities.ITroopsTrainingView;
import com.rocktail.hobbitutils.utils.AppConfigReader;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

public class TroopsTrainingPresenter {
	private IMainActivity _mainActivity;
	private ITroopsTrainingView _view;
	
	private String _VALIDATE_ERROR = "Invalid user input - provided negative resource amount";
	
	public TroopsTrainingPresenter(IMainActivity mainActivity, ITroopsTrainingView view) {
		this._mainActivity = mainActivity;
		this._view = view;
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

	public void calculateResult(Context context) {
		//first we have to read user input and validate it
		long foodAmount = this._view.getFoodResource();
		long woodAmount = this._view.getWoodResource();
		long stoneAmount = this._view.getStoneResource();
		long oreAmount = this._view.getOreResource();
		
		if (!ValidateUserInput(foodAmount, woodAmount, stoneAmount, oreAmount)) {
			throw new java.lang.IllegalArgumentException(this._VALIDATE_ERROR);
		}
		
		PlayerResources playerResources = new PlayerResources(foodAmount, woodAmount, stoneAmount, oreAmount);
		TroopsTrainingCalculationResult troopsTrainingCalculationResult = getTroopsCalculationResult(playerResources, context);
		
		this._mainActivity.createResultFragment(troopsTrainingCalculationResult);
	}
	
	/**
	 * Delegates calculation task to proper service and updated model with the result
	 */
	private TroopsTrainingCalculationResult getTroopsCalculationResult(PlayerResources playerResources, Context context) {
		TroopsTrainingCalculator calc = new TroopsTrainingCalculator(playerResources, AppConfigReader.getHobbitConfiguration(context));
		
		TroopsTrainingCalculationResult res = calc.CalculateBestT1TroopsTraining();
		
		return res;
	}
}
