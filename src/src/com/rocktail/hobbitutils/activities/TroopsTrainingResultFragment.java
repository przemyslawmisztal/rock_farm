package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.controllers.ITroopsTrainingResultPresenter;
import com.rocktail.hobbitutils.vos.UnitType;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment for presenting results of troop calculation to the user
 * @author rocktail
 *
 */
public class TroopsTrainingResultFragment extends Fragment implements ITroopsTrainingResultView {

	private TroopsAmountView _footUnits;
	private TroopsAmountView _rangedUnits;
	private TroopsAmountView _mountedUnits;
	private ITroopsTrainingResultPresenter _presenter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_troops_training_result,
				container, false);
		
		this._footUnits = ((TroopsAmountView)rootView.findViewById(R.id.t1footUnits));
		this._rangedUnits = ((TroopsAmountView)rootView.findViewById(R.id.t1mountedUnits));
		this._mountedUnits = ((TroopsAmountView)rootView.findViewById(R.id.t1rangedUnits));
		
		//Initialising unit amounts compound views so we have correct text and icons loaded
		this._footUnits.setUnitType(UnitType.Foot);
		this._mountedUnits.setUnitType(UnitType.Mounted);
		this._rangedUnits.setUnitType(UnitType.Ranged);
	
		return rootView;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
		this._presenter.showResult();
	}
	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingResultView#setFootUnits(long)
	 */
	@Override
	public void setFootUnits(long amount) {
		if (this._footUnits != null)
			this._footUnits.setAmount(amount);
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingResultView#setRangedUnits(long)
	 */
	@Override
	public void setRangedUnits(long amount) {
		if (this._rangedUnits != null)
			this._rangedUnits.setAmount(amount);
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingResultView#setMountedUnits(long)
	 */
	@Override
	public void setMountedUnits(long amount) {
		if (this._mountedUnits != null)
			this._mountedUnits.setAmount(amount);
	}

	@Override
	public void setPresenter(ITroopsTrainingResultPresenter presenter) {
		this._presenter = presenter;
		
	}
}
