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
public class TroopsTraningResultFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_troops_traning_result,
				container, false);
		
		return rootView;
	}
}
