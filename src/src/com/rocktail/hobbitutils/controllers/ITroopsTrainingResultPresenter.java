package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

public interface ITroopsTrainingResultPresenter {

	public abstract void init(TroopsTrainingCalculationResult result);
	public abstract void showResult();
}