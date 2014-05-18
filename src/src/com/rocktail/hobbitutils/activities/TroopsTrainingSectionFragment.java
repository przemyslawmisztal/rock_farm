package com.rocktail.hobbitutils.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.controllers.TroopsTrainingPresenter;
import com.rocktail.hobbitutils.vos.ResourceType;

public class TroopsTrainingSectionFragment extends Fragment 
	implements ITroopsTrainingView {

    private PlayerResourceView _foodResource;
    private PlayerResourceView _woodResource;
    private PlayerResourceView _stoneResource;
    private PlayerResourceView _oreResource;
    private TroopsTrainingPresenter _presenter;

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
            	acceptButtonClicked();
            }
        });
        
        this.initResourceCompoundViews();
        
        //we initialise controller and pass resources object
        return rootView;
    }
	
    private void acceptButtonClicked() {
    	this._presenter.calculateResult(this.getActivity().getApplicationContext());
    }
    /* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingView#addPresenter(com.rocktail.hobbitutils.controllers.TroopsTrainingPresenter)
	 */
    @Override
	public void addPresenter(TroopsTrainingPresenter presenter) {
    	this._presenter = presenter;
    }
    
    /**
     * Initialises resources compound views so they display correct text and icons
     */
    private void initResourceCompoundViews() {
        this._foodResource.setResource(ResourceType.Food);
        this._woodResource.setResource(ResourceType.Wood);
        this._stoneResource.setResource(ResourceType.Stone);
        this._oreResource.setResource(ResourceType.Ore);
    }

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingView#getFoodResource()
	 */
	@Override
	public long getFoodResource() {
		return _foodResource.getAmount();
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingView#getWoodResource()
	 */
	@Override
	public long getWoodResource() {
		return _woodResource.getAmount();
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingView#getStoneResource()
	 */
	@Override
	public long getStoneResource() {
		return _stoneResource.getAmount();
	}

	/* (non-Javadoc)
	 * @see com.rocktail.hobbitutils.activities.ITroopsTrainingView#getOreResource()
	 */
	@Override
	public long getOreResource() {
		return _oreResource.getAmount();
	}
}

