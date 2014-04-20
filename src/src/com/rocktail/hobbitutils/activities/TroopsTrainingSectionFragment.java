package com.rocktail.hobbitutils.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutilst.models.OnChangeListener;
import com.rocktail.hobbitutilst.models.PlayerResources;

public class TroopsTrainingSectionFragment extends Fragment 
	implements OnChangeListener<PlayerResources>,
	View.OnClickListener {
	/**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";

    private PlayerResources _playerResources;
    private int _ZERO_VAL = 0;
    private EditText _foodAmount;
    private EditText _woodAmount;
    private EditText _stoneAmount;
    private EditText _oreAmount;
    
    public TroopsTrainingSectionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_troop_training, container, false);
        
        //lets find edit text that contain user input
        this._foodAmount = (EditText)rootView.findViewById(R.id.foodAmountEditText);
        this._woodAmount = (EditText)rootView.findViewById(R.id.woodAmountEditText);
        this._stoneAmount = (EditText)rootView.findViewById(R.id.stoneAmountEditText);
        this._oreAmount = (EditText)rootView.findViewById(R.id.oreAmountEditText);
        
        final Button button = (Button) rootView.findViewById(R.id.acceptButton);
        button.setOnClickListener(this);
        
        //we init player resources with no values so when fragment is shown there are zeros in input fields 
        this._playerResources = new PlayerResources(this._ZERO_VAL, this._ZERO_VAL, this._ZERO_VAL, this._ZERO_VAL);
        
        //adding this fragment as listener so we know when model changes
        this._playerResources.addListener(this);
        
        return rootView;
    }

	@Override
	public void onChange(PlayerResources model) {
		updateView();
	}
	
	private void readUserInput() {
		
	}
	
	private void updateView() {
		this._foodAmount.setText(String.valueOf(this._playerResources.getFood()));
		this._woodAmount.setText(String.valueOf(this._playerResources.getWood()));
		this._stoneAmount.setText(String.valueOf(this._playerResources.getStone()));
		this._oreAmount.setText(String.valueOf(this._playerResources.getOre()));
	}

	@Override
	public void onClick(View v) {
		readUserInput();
	}
}
