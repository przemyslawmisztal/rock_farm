package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutils.activities.ITroopsTrainingResultView;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Presenter for troops amount compound view
 * @author rocktail
 *
 */
public class TroopsTrainingResultPresenter implements ITroopsTrainingResultPresenter {

	private ITroopsTrainingResultView _view;
	private TroopsTrainingCalculationResult _troopsTrainingCalculationResult;
	/**
	 * Creating presenter requires passing view
	 * @param view
	 */
	public TroopsTrainingResultPresenter(ITroopsTrainingResultView view) {
		this._view = view;
	}
	
	/**
	 * Updates view with calculated troops amounts
	 */
	public void showResult() {
		this._view.setFootUnits(this._troopsTrainingCalculationResult.getFootTroopsAmount());
		this._view.setRangedUnits(this._troopsTrainingCalculationResult.getRangedTroopsAmount());
		this._view.setMountedUnits(this._troopsTrainingCalculationResult.getMountedTroopsAmount());
	}
	
	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.controllers.ITroopsAmountPresenter#init(com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult)
	 */
	@Override
	public void init(TroopsTrainingCalculationResult result) {
		this._troopsTrainingCalculationResult = result;
	}
}
