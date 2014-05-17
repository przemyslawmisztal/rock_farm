package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.controllers.ITroopsAmountPresenter;

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
public class TroopsTraningResultFragment extends Fragment {

	private ITroopsAmountView _footUnits;
	private ITroopsAmountView _rangedUnits;
	private ITroopsAmountView _mountedUnits;
	private ITroopsAmountPresenter _presenter;
	
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
	
	/**
	 * Sets presenter for this fragment
	 */
	public void setPresenter(ITroopsAmountPresenter presenter) {
		this._presenter = presenter;
	}

	/**
	 * Sets foot units amount
	 * @param _footUnits
	 */
	public void setFootUnits(long amount) {
		this._footUnits.setAmount(amount);
	}

	/**
	 * Sets ranged units amount
	 * @param _rangedUnits
	 */
	public void setRangedUnits(long amount) {
		this._rangedUnits.setAmount(amount);
	}

	/**
	 * Sets mounted units amount
	 * @param amount
	 */
	public void setMountedUnits(long amount) {
		this._mountedUnits.setAmount(amount);
	}
}
