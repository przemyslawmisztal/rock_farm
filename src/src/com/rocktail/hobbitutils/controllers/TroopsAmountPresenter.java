package com.rocktail.hobbitutils.controllers;

import com.rocktail.hobbitutils.activities.ITroopsTrainingResultView;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

/**
 * Presenter for troops amount compound view
 * @author rocktail
 *
 */
public class TroopsAmountPresenter implements ITroopsAmountPresenter {

	private ITroopsTrainingResultView _view;
	
	/**
	 * Creating presenter requires passing view
	 * @param view
	 */
	public TroopsAmountPresenter(ITroopsTrainingResultView view) {
		this._view = view;
	}
	
	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.controllers.ITroopsAmountPresenter#init(com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult)
	 */
	@Override
	public void init(TroopsTrainingCalculationResult result) {
		this._view.setFootUnits(result.getFootTroopsAmount());
		this._view.setRangedUnits(result.getRangedTroopsAmount());
		this._view.setMountedUnits(result.getMountedTroopsAmount());
	}
}
