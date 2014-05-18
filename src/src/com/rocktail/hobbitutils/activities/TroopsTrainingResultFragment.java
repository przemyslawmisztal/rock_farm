package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment for presenting results of troop calculation to the user
 * @author rocktail
 *
 */
public class TroopsTrainingResultFragment extends Fragment implements ITroopsTrainingResultView {

	private ITroopsAmountView _footUnits;
	private ITroopsAmountView _rangedUnits;
	private ITroopsAmountView _mountedUnits;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_troops_traning_result,
				container, false);
		
		this._footUnits = ((ITroopsAmountView)rootView.findViewById(R.id.t1footUnits));
		this._rangedUnits = ((ITroopsAmountView)rootView.findViewById(R.id.t1mountedUnits));
		this._mountedUnits = ((ITroopsAmountView)rootView.findViewById(R.id.t1rangedUnits));
		
		return rootView;
	}
	
	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingResultView#setFootUnits(long)
	 */
	@Override
	public void setFootUnits(long amount) {
		this._footUnits.setAmount(amount);
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingResultView#setRangedUnits(long)
	 */
	@Override
	public void setRangedUnits(long amount) {
		this._rangedUnits.setAmount(amount);
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingResultView#setMountedUnits(long)
	 */
	@Override
	public void setMountedUnits(long amount) {
		this._mountedUnits.setAmount(amount);
	}
}
