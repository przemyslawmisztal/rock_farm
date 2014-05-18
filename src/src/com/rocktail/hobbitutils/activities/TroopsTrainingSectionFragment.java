package com.rocktail.hobbitutils.activities;

import java.util.Observable;
import java.util.Observer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.controllers.TroopsTrainingController;
import com.rocktail.hobbitutils.vos.ResourceType;
import com.rocktail.hobbitutilst.models.PlayerResources;
import com.rocktail.hobbitutilst.models.TroopsTrainingCalculationResult;

public class TroopsTrainingSectionFragment extends Fragment 
	implements Observer {

	private PlayerResources _playerResources;
    private int _ZERO_VAL = 0;
    private PlayerResourceView _foodResource;
    private PlayerResourceView _woodResource;
    private PlayerResourceView _stoneResource;
    private PlayerResourceView _oreResource;
    private TroopsTrainingController _controller;
    private TroopsTrainingCalculationResult _calculationResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_troop_training, container, false);
    
        //lets find all controls here
        this._foodResource = (PlayerResourceView)rootView.findViewById(R.id.foodPlayerResource);
        this._woodResource = (PlayerResourceView)rootView.findViewById(R.id.woodPlayerResource);
        this._stoneResource = (PlayerResourceView)rootView.findViewById(R.id.stonePlayerResource);
        this._oreResource = (PlayerResourceView)rootView.findViewById(R.id.orePlayerResource);

        //we need to find accept button and register listener to be able to catch user interaction
        final ImageButton button = (ImageButton) rootView.findViewById(R.id.accept_button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	readUserInput();
        		calculateUnits();
            }
        });
        
        this.initResourceCompoundViews();
        
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
	
    private void initResourceCompoundViews() {
        this._foodResource.setResource(ResourceType.Food);
        this._woodResource.setResource(ResourceType.Wood);
        this._stoneResource.setResource(ResourceType.Stone);
        this._oreResource.setResource(ResourceType.Ore);
    }
    
	private void readUserInput() {
		long foodAmount = this._foodResource.getAmount();
		long woodAmount = this._woodResource.getAmount();
		long stoneAmount = this._stoneResource.getAmount();
		long oreAmount = this._oreResource.getAmount();
		
		if(this._controller.ValidateUserInput(foodAmount, woodAmount, stoneAmount, oreAmount)) {
			this._controller.handleUserInput(foodAmount, woodAmount, stoneAmount, oreAmount);
		}
	}
	
	private void updateView() {
		this._foodResource.setAmount(this._playerResources.getFood());
		this._woodResource.setAmount(this._playerResources.getWood());
		this._stoneResource.setAmount(this._playerResources.getStone());
		this._oreResource.setAmount(this._playerResources.getOre());
		
		createResultFragment(this._controller.getTroopsTrainingCalculationResult());
	}

	private void createResultFragment(TroopsTrainingCalculationResult res) {
		Fragment newFragment = new TroopsTraningResultFragment();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		
		transaction.replace(R.id.linear_layout_id, newFragment);
		transaction.addToBackStack(null);
		
		transaction.commit();
	}
	
	private void calculateUnits() {
		this._controller.handleTroopsCalculations(this.getActivity().getApplicationContext());
	}

	@Override
	public void update(Observable observable, Object data) {
		updateView();
	}
}
