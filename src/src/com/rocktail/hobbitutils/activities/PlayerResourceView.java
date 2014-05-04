package com.rocktail.hobbitutils.activities;

import com.rocktail.hobbitutils.R;
import com.rocktail.hobbitutils.vos.ResourceType;

import android.content.Context;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Compound view for player resource input 
 * @author rocktail
 *
 */
public class PlayerResourceView extends GridLayout
	implements IPlayerResourceView {
	
	private TextView _tileTitleTextView;
	private EditText _resourceAmountEditText;
	private ImageView _tileIconImageView;
	
	/**
	 * Creates instance of {@link PlayerResourceView} and finds needed controls
	 * @param context
	 */
	public PlayerResourceView(Context context) {
		super(context);
		
		//have to find all the controls that will be used 
		this._tileIconImageView = (ImageView)findViewById(R.id.tileIconImageView);
		this._resourceAmountEditText = (EditText)findViewById(R.id.resourceAmountEditText);
		this._tileTitleTextView = (TextView)findViewById(R.id.tileTitleTextView);
	}

	/**
	 * Sets amount of resource
	 */
	@Override
	public void setAmount(long resourceAmount) {
		this._resourceAmountEditText.setText(String.valueOf(resourceAmount));
		
	}

	/**
	 * Sets name for resource
	 */
	@Override
	public void setResourceName(String resourceName) {
		this._tileTitleTextView.setText(resourceName);
		
	}

	/**
	 * Enables view to display correct icon for provided resource type
	 */
	@Override
	public void setResourceIcon(ResourceType resourceType) {
		String iconName = getIconResourceName(resourceType);
		
		int resId = getResources().getIdentifier(iconName, "drawable", "com.rocktail.hobbitutils");
		this._tileIconImageView.setImageResource(resId);
		
	}

	/**
	 * Gets icon resource name so we can find and display correct icon 
	 * @param resourceType
	 * @return
	 */
	private String getIconResourceName(ResourceType resourceType) {
		switch (resourceType) {
			case Food: return "food";
			case Wood: return "wood";
			case Stone: return "stone";
			case Ore: return "ore";
			default: return null;
		}
	}

}

