package com.rocktail.hobbitutils.activities;

import java.util.Observable;
import java.util.Observer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.controllers.TroopsTrainingController;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

public class TroopsTrainingSectionFragment extends Fragment 
	implements Observer,
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
    private EditText _t1FootUnitsAmount;
    private EditText _t1MountedUnitsAmount;
    private EditText _t1RangedUnitsAmount;
    private TroopsTrainingController _controller;
    private TroopsTrainingCalculationResult _calculationResult;
    
    public TroopsTrainingSectionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_troop_training, container, false);
              
        //lets find all user input fields here
        this._foodAmount = (EditText)rootView.findViewById(R.id.foodAmountEditText);
        this._woodAmount = (EditText)rootView.findViewById(R.id.woodAmountEditText);
        this._stoneAmount = (EditText)rootView.findViewById(R.id.stoneAmountEditText);
        this._oreAmount = (EditText)rootView.findViewById(R.id.oreAmountEditText);
        
        this._t1FootUnitsAmount = (EditText)rootView.findViewById(R.id.resT1FootEditText);
        this._t1MountedUnitsAmount = (EditText)rootView.findViewById(R.id.resT1MountedEditText);
        this._t1RangedUnitsAmount = (EditText)rootView.findViewById(R.id.resT1RangedEditText);
        
        //we need to find accept button and register listener to be able to catch user interaction
        final ImageButton button = (ImageButton) rootView.findViewById(R.id.acceptButton);
        button.setOnClickListener(this);
        
        //initialising model 
        this._playerResources = new PlayerResources(this._ZERO_VAL, this._ZERO_VAL, this._ZERO_VAL, this._ZERO_VAL);
        this._calculationResult = new TroopsTrainingCalculationResult();
        
        //registering this view as observer
        this._playerResources.addObserver(this);
        this._calculationResult.addObserver(this);
        
        //we initialise controller and pass resources object
        this._controller = new TroopsTrainingController(this._playerResources, this._calculationResult);
        return rootView;
    }
	
	private void readUserInput() {
		long foodAmount = Long.parseLong(this._foodAmount.getText().toString());
		long woodAmount = Long.parseLong(this._woodAmount.getText().toString());
		long stoneAmount = Long.parseLong(this._stoneAmount.getText().toString());
		long oreAmount = Long.parseLong(this._oreAmount.getText().toString());
		
		if(this._controller.ValidateUserInput(foodAmount, woodAmount, stoneAmount, oreAmount)) {
			this._controller.handleUserInput(foodAmount, woodAmount, stoneAmount, oreAmount);
		}
		
	}
	
	private void updateView() {
		this._foodAmount.setText(String.valueOf(this._playerResources.getFood()));
		this._woodAmount.setText(String.valueOf(this._playerResources.getWood()));
		this._stoneAmount.setText(String.valueOf(this._playerResources.getStone()));
		this._oreAmount.setText(String.valueOf(this._playerResources.getOre()));
		
		this._t1FootUnitsAmount.setText(String.valueOf(this._calculationResult.getFootTroopsAmount()));
		this._t1MountedUnitsAmount.setText(String.valueOf(this._calculationResult.getMountedTroopsAmount()));
		this._t1RangedUnitsAmount.setText(String.valueOf(this._calculationResult.getRangedTroopsAmount()));
	}

	@Override
	public void onClick(View v) {
		readUserInput();
		calculateUnits();
	}

	private void calculateUnits() {
		this._controller.handleTroopsCalculations();
		
	}

	@Override
	public void update(Observable observable, Object data) {
		updateView();
		
	}
}
